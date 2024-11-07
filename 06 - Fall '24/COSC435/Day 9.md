Assignment 6 due 11/25
last concepts for it are covered next week
	URL on PDF is broken, use https://picsum.photos/v2/list instead
	also check https://picsum.photos for general info on the API's feature set!
		we will only need the /v2/list endpoint
			first page should be sufficient

# Agenda
- Quiz
- Lab 9 review
- Coroutines (cont.)
- LaunchedEffect
- Files
- Preferences
- Room (SQL)

------------

# Quiz
Coroutines always run on a background thread.
	a. True
	*b. False*
		(they run on the main thread by default, too much will slow down the app)

To start a coroutine, use:
	a. Thread.start           //starts a new thread lol
	b. Coroutine.start    //dont start, you launch
	c. Coroutine.launch
	*d. CoroutineScope.launch*

------------

# Coroutines CTD
### Starting a coroutine
- use either launch or async
- launch -> start a coroutine that doesn't return anything to the caller
- async -> start a coroutine that returns a value to the caller

### Async/Await
- allows you to run multiple coroutine jobs in parallel

``` Kotlin
suspend fun fetchTwoDocs() =
	GlobalScope.async {     //dont use GlobalScope lol
		val deferredOne = async { fetchDoc(1) }
		val deferredTwo = async { fetchDoc(2) }
		deferredOne.await()
		deferredTwo.await()
	}
```

^^ if fetchDoc takes 5 seconds, this implementation runs both simultaneously and takes 5s instead of 10s

### Jobs
- launch will return a Job
- Jobs can be cancelled, and all /child/ coroutines are cancelled too

``` Kotlin
val job = launch {
	launch {
		launch {
		}
	}
}
job.cancel() //cancels everything
```

last week we were using viewModelScope.launch
	it is a function defined in the base viewModel class

``` Kotlin
public val viewModel: //???
```

we can override the  onCleared() function like so:
``` Kotlin
override fun onCleared() {
	super.onCleared()
	viewModelScope.cancel()
}
```


there is a job class! you can store coroutines to them and then call job.cancel() !
	useful to force a timeout if a server isnt responding, etc

### Exceptions
- exceptions thrown by child coroutines can be caught and rethrown to the parent

``` Kotlin
val deferred = GlobalScope.async {
	println("Throwing exception from async")
	throw Exception() // Nothing is printed, relying on user
}
try {
	deferred.await()
	println("Unreached")
} catch (e: Exception) {
	println("Caught ArithmeticException")
}
```

consider the difference between 
viewModelScope.launch{} and 
val deferred: Deferred<String>viewModelScope.async{}
	then you can use deferred.await() in a suspend fun!

-----------

# LaunchedEffect

https://

*LaunchedEffects allow you to run coroutines in the context of a composable*
	generally you should avoid, but you might want to use it sometimes

recall
you put all of your coroutine launching and asynchronous stuff in your ViewModels

occasionally you want to run coroutine stuff in a composable

This coroutine will be launched when the LaunchedEffect enters the composition and whenever the key changes.

``` Kotlin
@Composable
fun Screen() {
	...
	LaunchedEffect(key = someKey) {
		scope.launch {
			...
		}
	}
	...
}
```

##### Big Idea: *LaunchedEffect runs coroutines in composables in a controlled manner*

``` Kotlin
Surface(color = MaterialTheme.colorScheme.background) {
	val scope = rememberCoroutineScope()
	MainScreen()
	scope.launch {
		Log.d("Main Activity", "Launching a coroutine")
	}
}
```

note that this doesnt rerender anything because scope.launch doesnt have the correct scope

do not put your scope.launch in a place that runs everytime the UI is rerendered!!
	launching coroutines is expensive!!

The solution to this is to use a launchedEffect!

in SongListView.kt
```Kotlin
	LaunchedEffect(key1 = true) {
		//in a  coroutine. can call suspend functions here
		Log.d("SongListView", "Launching a coroutine")
	}
```

the real use case for the key is to execute whenever something changes
	think of the power of ``` LaunchedEffect(key1 = songs) ```

now a coroutine is launched ONLY when the song list that was passes is changed
	this works because we're making a completely new list each time, it would NOT work with mutations
		means dont work with mutations lol

----------

NOTE: #files and #preferences is covered briefly, look at attached documentation on today's agenda in the syllabus
	also look at the shared persistencedemo app that he gave us
	it uses SDK version 29 lol, may have to set that up

# Files

cmd > adb shell
	gives you a shell into your emulator!
	now you can use ls, cd, etc
	use su to switch user into an account with root privileges

res > raw > users.txt lets our persistenceDemo program store stuff
	think about storing .mp3s here for met project

Data can also be stored as flat files
- each app has access to directories that are isolated from other apps
- you have 2 options for where to store your app's files:
	- internal storage (isolated app folder)
	- external storage (SDCard)

apps cant access other apps' data
	its silo'd!!

most modern apps use Internal Storage bc External Storage is effectively public lmao

### Internal Storage
- Default: only your app can see these files
- call *openFileOutput* to write
- call *openFileInput* to read

the context is the base class of your activity and the application itself

jumping to FilesScreen.kt:
```Kotlin
class FilesViewModel(app: Application) : AndroidViewModel(app)  //what is an AndroidViewModel

init {
	app.openFileOutput()
	generateFile()
	loadFromResource()
}
```

use androidViewModel when you want to read and write data!!!

![[Pasted image 20241028195548.png]]

```
private run loadFromResource() {
	val fis: InputStream = this.getApplication<Application>()
		.resources
		.openRawResource(R.raw.users)
		//.getDrawable()
		//etc, look at the power of these functions
	val lines = fis.bufferedReader().readLines()
	for( line in Lines...)
	// finish me!!
}
```

``` Kotlin
private fun generateFile() {
	val filesDir: File = getApplication<Application>().filesDir //or .cacheDir if stuff in cache
	val usersFile = File(filesDir, "users.txt")
	if(!usersFile.exists()) {
		val fos: FileOutputStream = getApplication<Application>()
			.openFileOutput("users.txt", Context.MODE_PRIVATE)
			//FINISH ME
	}
}
```

every application on a device has data stored in /data/data/{AppID}

cat {file name} -> prints contents of a file to console

## Cache Directory
for files that are temporary, you can store them in the cache directory
	think of images as you scroll lol

## External Storage
- These files/folders are world readable and accessable when the user connects via USB
- very useful for sharing files
- *Do not store sensitive data here!*
- must ask permission!

# Preferences
- a midpoint between reading simple files and using databases
- Preferences let you store simple user settings data
- data is stored as key/value pairs
	-Example:
		- did the user view the app instructions? (Boolean)
		- Custom server url (string)
		- Email address (string)

look into DataStore<>
	here we use:
```
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "...")

class SettingsViewModel(app: Application) ...
...
```

LOOK AT THIS ITS SUPER COOL!!
``` Kotlin
fun onSave() {
	viewModelScope.launch(Dispatchers.IO) {
		getApplication<Application>()
			.dataStore.edit { prefs ->
				Log.d("SettingsScreen", _text.value)
				prefs[TEXT_SETTING_KEY] = _text.value
			}
	}
}
```

this data is stored in /data/data/{AppID}/files/dataStore/settings.preferences_pb

also look into https://developer.android.com/training/data-storage/app-specific 

# Room (SQL)

the database in mobile apps is typically embedded!
	it uses SQLite!!
	https://www.sqlite.org 
	your final project will use whatever sqlite version that's included in your version of Android

/data/data/{AppID}/databases
	we're interested in the .db file!
	think about the embedded database like a cache from the larger, server-based centralized database
	if you need stuff thats not in the embedded database, then fetch it and put it in!

ORMs abstract away the gross SQL stuff
	-examples include:
		- Hibernate
		- Entity Framework
		- Room
- lets you write kotlin code instead of SQL code

## Overview
- Room is an ORM (object relational mapping) for Android
- Provides a high-level wrapper around SQLite

## Advantages
- easier and faster
- provides SQL syntax checking
- less boilerplate
- almost no SQL

## SQLite
- filebased -> no server!!
- each app maintains its own (not shared)

## Entity
- a class representing a table in your database

``` Kotlin
@Entity(tableName = "word_table")
class Word(
	@PrimaryKey(autoGenerate = true)
	val id: Int = 0,
	@ColumnInfo(name = "word")
	val word: String
)
```

## DAO
- Data Access Object
- an interface representing the operations to perform on your database
- typically implemented as CRUD

``` Kotlin
@Dao
interface WordDao {
	@Query("SELECT * from word_table ORDER BY word ASC")
	fun getAllWords(): LiveData<List<Word>>
}
```

other example @Querys in recording!

we also have 
``` Kotlin
@Insert,
suspend fun addUser(user: User)

@Delete
suspend fun deleteUser(user: User)

@Update
suspend fun updateUser(user: User)
```

# Creating
- use Room.databaseBuilder() to create your database

``` Kotlin
	Room.databaseBuilder(
		app, //your application reference
		YourDatabase::class.java, //the (Java) classname of your ...
		"mydatabase.dp" // the name of the Sqlite database file
	)
	.build()
```

# Migrations
- allows running custom code to migrate from one database version to another
``` Kotlin
	Room.databaseBuilder(..)
	.addMigrations(object : Migration(1,2) {
		override fun migrate(database: SupportSQLiteDatabase) {
			database.execSQL("alter table user ...")
		}
	}).build()
```

# Converters
- for complex datatypes, you must implement a custom converter to convert Kotlin/Java types to SQLite types
``` Kotlin
class Converters {
	@TypeConverter
	fun fromString(id: String): UUID {
		return UUID.fromString(id)
	}
	@TypeConverter
	fun toString(id: UUID): String {
		return id.toString()
	}
}
```

THE BIG POINT: * This data is persistent, and lives through onAppDestroy()s!!*

Lab time!!!