# Agenda
1. Lab 5 Review/Finish
2. Quiz
3. Compose Preview
4. Activity Lifecycle
5. ViewModels


# Lab 5 Review/Finish
"I dont want you to follow along, its just to present ideas"

why the themes weren't working last week:
	the theme in the UI theme package (~/kotlin+java/.../ui.theme/theme.kt)
	there are 3 default arguments, the one we're worried about is dynamicColor: Boolean = true
		if its set to true, then a block of code runs to dynamically make one based on your wallpaper
		make sure to set that flag to false to use a custom theme lol
	in MainActivity.kt:
``` kotlin
JetpackComposeDemoTheme(dynamicColor = false)
```
must do this for final!!
can also do
~~~ kotlin
(dynamicColor = false, darkTheme = true)
~~~
to force dark theme!

on state hoisting;
recall it means that to make composables reusable, we need to make them stateless

State Hoisting Pattern:
- a pattern used to make a Composable *stateless*
- generally, all state is replaced with a *value* parameter...

Example in the slides

basically pass the function the state, and what to do when the state updates

leave MutableState stuff in places that have to do with UI, not Java class definitions

handle events to modify state at the entry point of your functions (ie MainScreen(handle here))

-----------

# Compose Preview

only executes in the IDE, allows for rapid UI development bc you dont have to constantly rebuild
``` kotlin
@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
	val songs = listOf(song("1", "Thriller", "MJ", 1, true), Song("2", "Hotline Bling", "Drake", 2, false))
	LabsAppTheme {
		Surface(color = MaterialTheme.colorScheme.background) {
			MainScreen(songs)
		}
	}
}
```


--------

# Activity Lifecycle

"Activities are one of the core components of an Android App"

Activities are destroyed and recreated whenever a configuration change occurs, such as an orientation change

"a config change is anything that will run from resources on the device in a specific configuration"
	most common example is landscape vs portrait configuration

in the songs list app, you can delete some song entries, rotate, and the deleted entries are reinstantied

reorienting the screen reruns the MainActivity function as if it were the first time

how to fix?
	redefine where you create state!
	not inside MainActivity, bc the state dies with it!

![[Pasted image 20241007201835.png]]


android apps are subclassed from a base activity
the default methods need to be manually overwritten
	we've only been changing onCreate()


in MainActivity.kt:
``` kotlin
class MainActivity:ComponentActivity() {
	override fun onCreate(){
		super.onCreate()
		log.d("MainActivity", "in onCreate()")
	}
	override fun onStart() {
		super.onStart()
		log.d("MainActivity", "in onStart()")
	}
	override fun onResume() {
		super.onResume()
		log.d("MainActivity", "in onResume")
	}
	override fun onPause(){
		super.onPause()
		log.d("MainActivity", "in onPause()")
	}
	override fun onStop(){
		super.onStop()
		log.d("MainActivity", "in onStop()")
	}
	override fun onDestroy(){
		super.onDestroy()
		log.d("MainActivity", "in onDestroy()")
	}
	override fun onRestart(){
		super.onRestart()
		log.d("MainActivity", "in onRestart()")
	}
}
```

lets logcat print out each change in configuration


this concept is important bc sometimes one of these functions may NOT execute, and you need to be aware of it
it also gives you a good idea of when the user can interact with an app

onRestart is a good place to restore state to a running app

if im running an app and i hit the home button:
	*if i dont stop the timer with onStop(), itll keep running in the background!!*

if you open a shit ton of other apps, then Android MIGHT boot your program out of memory in the background

--------------
# ViewModels
The Android Framework provides the ViewModel class for managing UI-related data

manages data related to your UI

"for every screen in your app, add a new ViewModel"

they are important because
	*ViewModels survive configuration changes*

Declare:
``` Kotlin
class MyViewModel : ViewModel() {
	private val _name: MutableState<String> = mutableStateOf("")
	val name: State<String> = _name //only expose immutable params

	fun updateName(newName: String){
		log.i("MyViewModel", "Setting newName...")
		_name.value = newName
	}
}
```

ie at the bottom of your code:
``` Kotlin
class MyViewModel : ViewModel() {
	val name: MutableState<String> = mutableStateOf("")
}
```
then at the top:

``` Kotlin
Scaffold(){
	val vm: MyViewModel by viewModels<MyViewModel>()
	Greeting(
		name = vm.name.value //stores the state to the viewModel!!!
	)
}
```


put ALL state into it's screen's VM basically (there ARE a few exceptions)

Use
Important: You can on use the viewModels() function inside an Activity
``` Kotlin
override fun OnCreate(...) {
	setContent {
		vm vm: MyViewModel by viewModels()
		...
		MainScreen(
			vm,
			...
		)
	}
}
```

Best Practice
- use internal/private mutable state but expose immutable state
- use functions to mutate state
- only access ViewModels at the top of your Composable/...\
- one view model per screen

``` Kotlin
@Composable
fun Main() {
	val vm: MyViewModel by viewModels()
	MainScreen(
		name = vm.name,
		onNameChange = vm::setName
	)
}
```
use VMs because:
1. they give an easy way to structure your code
2. they persist through configuration changes