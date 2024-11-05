Today we're talking about networking
	links in schedule are super relevant!!

last week: Persistence
- Saving to files
- DataStore for preferences
- Room - SQLite database!

[https://engineering.teknasyon.com/a-simple-guide-to-version-catalog-implementation-in-android-17d0ff3fd1f](https://engineering.teknasyon.com/a-simple-guide-to-version-catalog-implementation-in-android-17d0ff3fd1f)
- this tells you how to add libraries to your libs.versions.toml file!!
--------

# Agenda
- Lab 9 (review/finish)
- Persistence (cont.)
- Networking
- JSON modeling
- REST APIs

# Lab 9 review/Finish

Recall @Dao's
	or database access objects
```Kotlin
@Dao
interface SongsDao {
	@Insert
	suspend fun addSong(song: Song)
	...
}

@Entity //create table
data class User(val name: String)

@Dao //create an object to query table
interface UsersDao {
	@Query("select * from user")
	suspend fun getUsers(): List<User>
}

//define table
@Database(entities) = [song::class, User::class], version = 1, exportSchema = false)
abstract class SongsDatabase : RoomDatabase() {
	abstract fun getSongsDao(): SongsDao
	abstract fun getUsersDao(): UsersDao
	//can be extended for any number of tables!!
}
```

on the app Inspector:
right click on left ribbon > app Inspector > running device > lets you inspect *instantiated* databases!!
- even if you define a database, it wont appear unless you instantiate it!

consider modifying SongsRepository from LabsApp lab 9 to store sounds, click tracks, etc for your own project!!

in SongsDatabaseRepository:
recall you should only launch coroutines from viewModels!
```Kotlin

override suspend fun getSongs(): List<Song> { //this is not best practice, but it illustrates the point in class
	return db.getSongsDao().getSongs()
}

```

in SongListViewModel.kt:
```
class SongListViewModel(app: Application) : AndroidViewModel(app){
	...
	...
	private val _repository: ISongsRepository = SongsDatabaseRepository(getApplication())
	
	init {
		viewModelScope.launch{
			_songs.value = _repository.getSongs()
		}
		_selected = mutableStateOf(null)
		selectedSong = _selected
		_songToBeDeleted = null
		_waiting = mutableStateOf(false)
		waiting = _waiting
		...
	}
	...
}
```


>google "android room _impl does not exist"

![[Pasted image 20241104192740.png]]

from https://developer.android.com/training/data-storage/room, paste this into your libs.versions.toml file
``` Kotlin
dependencies {
    val room_version = "2.6.1"

    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")

    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$room_version")
    // To use Kotlin Symbol Processing (KSP)
    ksp("androidx.room:room-compiler:$room_version")

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")

    // optional - RxJava2 support for Room
    implementation("androidx.room:room-rxjava2:$room_version")

    // optional - RxJava3 support for Room
    implementation("androidx.room:room-rxjava3:$room_version")

    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation("androidx.room:room-guava:$room_version")

    // optional - Test helpers
    testImplementation("androidx.room:room-testing:$room_version")

    // optional - Paging 3 Integration
    implementation("androidx.room:room-paging:$room_version")
}
```

in the database:
``` Kotlin
override suspend fun getSong(song:Song){
	return db.getSongsDao().getSongs(song)
}

override suspend fun deleteSong(song:Song){
	db.getSongsDao().deleteSong(song)
}

override suspend fun addSong(song:Song){
	db.getSongsDao().addsong(song)
}
```

back to the database inspector:
	we can use it to see live updates to a table!
	if live updates disabled, then you can modify table entries manually!!


from last weeks slides:

# Converters
- for complex datatypes, you must implement a custom converter to convert Kotlin/Java types to SQLite types
``` Kotlin
class Converters{
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

suppose:
```Kotlin
	@RequiresApi(Build.VERSION_CODES.0)
	fun addUser(f: String, l: String) {
		viewModelScope.launch {
			userDb.userDao().addUser(User(FirstName = f, LastName = l, Birthday = Date.from(Instant.now))...)
		}
	}
```

the date cant be stored in your database!
	"you can consider adding a type converter for it."

in Users.kt:
``` Kotlin
class Converters{
	@TypeConverter //type converters replaced with docs implementation
	fun fromString(id: String): Date {
		return Date.from(Instant.parse(id))
	} 
	@TypeConverter 
	fun toString(id: Date): String { 
		return id.toString() 
	}


	@Database(entities = [User::class], version = 5, exportSchema = false)
	@TypeConverters(Converters::class)
	abstract class AppDataBase::
}
```

----------

Starting on today's content: The REST API!!
	note that we skip a lot in the slides!

we were given access to today's demo project:
	RestAPIDemo on rvalis's bitbucket

it fetches pictures!
	only of ones that are visible
	once fetched, its cached so you dont have to redownload!
	all this stuff can be inspected with the Network Inspector!

# Networking

## Permissions
- in order to access the network, you must ask permission
- if you don't, Android will throw an Exception, crashing your app
	- in app > manifests > AndroidManifest.xml

note that you cannot run network requests on the main thread
	if you do the app wont compile
``` Kotlin
	class UsersFetcher(private val cahceDir: File)
	....
	....
	something about dispatcher.io
	...
	...
```

## Cellular Connectivity
- ***It is a best practice to check to see if there is even networking available before using it***
	- he'll run your app in airplane mode
		- if it crashes that's points off!
- cell phones may not have service
- network connection may be very slow
- use the ConnectivityManager

## ConnectivityManager
Use the ConnectivityManager to check the state of the device's network connection

NetworkCallback
```Kotlin
cm = ctx.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
val nr = NetworkRequest.Builder()
	.addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
	.addCapability(NetworkCapabilities.NET_CAPABILITY_NOT_METERED)
	//add other capabilities you need here!
	.build()
cm.requestNetwork(nr, object: ConnectivityManager.NetworkCallback() {
	override fun onAvailable{
	...
	}

	override fun onLost(network: Network) {
	...
	}
}
...
...
...
```

its useful to know if you're on cell or wifi so that you dont accidentally use all of a client's data allowance
	think google photos

## Network Capabilities
Sometimes, its useful to know whether a device is connected to wifi or cellular
``` Kotlin
code from slides here lol
${nc.hasTransport...}
```

# REST
- Representational State Transfer
- Typically used to communicate with Web Services
- Alternative to SOAP (XML based protocol)
- stateless and simple
- VERY popular

## Verbs
- GET -to retrieve
- PUT 
- POST -to create 
- DELETE -

know other HTTP verbs!!
https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods
- get
- head
- post
- put
- delete
- connect
- options
- trace
- patch - we might actually use this one lol

websites return objects of data type **HTML**

--------

lets look at https://jsonplaceholder.typicode.com
- lets us create a "fake API"

as well as https://my-json-server.typicode.com/
- if we need to fulfill the "connect to internet requirement" on project, we can use this!
- lets you put stuff on a JSON file on a public github repo, then access it from your code!
	- 2 endpoints: posts, and profile


``` JSON
[
	{
		"id": 1,
		"title": "Post 1"
	},
	{
		"id": 2,
		"title": "Post 2"
	},
	{
		"id": 3,
		"title": "Post 3"
	}
]
```

we can run the following in the page inspector
```
fetch("/typicode/demo/posts").then(a => a.json()).then(a => console.log(a))
```
to call the server, and get request the JSON off of the file!

or we can do:
```
fetch("/typicode/demo/comments").then(a => a.json()).then(a => console.log(a))
```

first thing to do is inspect the API and figure how to use the JSON
	model the response in a new java class
		like this:

``` Kotlin
data class User(val id: Int,
			   @SerializedName("first_name")
			   val firstName: String,
			   @serializedName("last_name")
			   val lastName: String,
			   @SerializedName("avatar")
			   val
			   )
```


***JSON is a String***
we can use GSon (a Google Library) to convert JSON to objects we define and vice versa
```
val apiResult = Gson().fromJson(body, ApiResult::class.java)
apiResult.data
```

we make the request with:
``` Kotlin
val client = OkHttpClient()
val request = Request.Builder()
	.get()
	.url("${API_URL}?per_page=12&page=1&delay=3")
	.build()
```

also look into UsersFetcher.kt line 37 for how to fetch images to cache
``` Kotlin
override suspend fun fetchIcon(url: String) :Bitmap {
	return withContext(Dispatchers.IO){
	
	}
}
```


## Structure (Java API specific)
- Objects are essentially key-value pairs
- Objects and Arrays can be nested
- Values can be strings, objects, arrays, numbers, bools
- no date, no binary
- sometimes binary data is encoded in Base64 strings
- more often, binary data is placed at a special URL

**make sure you have a cache defined for fetched images so you arent constantly fetching!!!**

## JSON in Java
- JSON library is found in org.json.*
- ...
- ...

examples in slides!

# GSON
https://github.com/google/gson

## Data Modeling
- look at your API's data format
- create a class that models the format
- can be your existing model, but likely something new

## 3 typical structures
- Object
	- create a single class for your object
	- just map keys to property names
- Array/List
	- create a class for the list items
	- parse the list (example below)
- Object with a single property for the list
	- create a class with a single property for the list

## Object Parsing
``` JSON
{
	"hello": "world",
	age": 20
}
```

```Kotlin
data class Thing(val hello: String, val age: Double)

val thing = Gson().....
```

## List/Array Parsing
``` JSON
[
	{
		"hello": "world",
		age": 20
	},
	...
]
```

``` Kotlin
data class ...
...
```

## Nested Object Parsing
```JSON
{
	"thing": {
		"hello": "world",
		"age": 20
	}
}
```

```Kotlin
data class Thing(val hello: String, val age: Double)
data class ThingWrapper(val thing: Thing)

val thing = Gson().fromJson(json, ThingWrapper:: class.java)
```

# Libraries (links in slides)
## OkHttp
https://square.github.io...

## FastHttpNetworking

## Retrofit

## Volley (maybe developed by Google?)

----------

Lab time!!
