# Agenda
0. Git - Collaboration
1. Quiz
2. Review (Lab, Navigation, Activity Lifecycle)
3. Dialogs
4. Coroutines

make sure you read up on coroutines!!

Assignment 5 due 11/4!!
	UI isnt super important, but functional requirements are!!
	typo on assignment! ModalBottonSheet -> ModalBottomSheet
		not covered in class, do your own research!
			on this and TopAppSheets!
	MAINTAIN REMOVALS THRU ROTATIONS!!
		and Assignment 3 -> Assignment 5
	UI uses elevated cards!

after assignment 5, we have one final assignment!
	due 11/25!

----------

# Git

teacher's suggestions on how to collaborate:
	work on a single branch
		simplifies workflow, but need to check with group to incorporate everyone's work

achieved with small, frequent commits (and pushes)!
	runs the lowest risk of having conflicts
	NOTE: only push an app that works lol

this forces group mates to have to "git pull origin main" before they work
	this auto-integrates work to everyone's local copy

needs communication between group mates so that 2 people aren't working simultaneously


if you're a git power user, then each member works on their own branch
	each work on their own branch, then merge it into main
	the problem with this is that students dont merge into main early/often enough

note: frequently means "every day/every few days"
	should happen every time you sit down to work lol

![[Pasted image 20241021192503.png]]
note that the single branch idea will give you full points despite what the rubric says


-----------------

# Quiz

1. What's the type of the result?
``` Kotlin
data class Person(val name: String, val age: Int)
(0..10)
	.map { i -> Person("Joe $i, i) }
	.filter { j -> j.age > 5 }
	.map { a -> a.age }
```

*a. List<Int>*
b. List<String>
c. List<Person>
d. List<(String, Int)>


2. What is the correct lifecycle event order when pressing the back button?
	a. onStop, onPause
	b. onStop, onDestroy
	c. onPause, onStop
	*d. onPause, onStop, onDestroy*


3. What is the type of the parameter?
``` Kotlin
fun someFunc(
	callback: //????
	param: String? = null
) {
	...
	callback(param, param)
}
```

a. (String, String) -> Unit
b. (String) -> String?
c. (String?) -> String
*d. (String?, String?) -> Unit*

-----------

# Lab Review

Add padding to the NavHost with modifier = Modifier.padding(top = 40.dp, bottom = 50.dp)
	this is less than ideal because we're guessing at the padding

instead, look at the padding that the scaffolding gives you
``` Kotlin
Scaffold(...){ paddingValues: PaddingValues ->
	SongsNavGraph(nav, paddingValues)
}
```
and

``` Kotlin
fun SongsNavGraph(
	navController: NavHostController = rememberNavController(),
	paddingValues: PaddingValues
) {
	NavHost(
		modifier = Modifier.padding(paddingValues)
	)
}
```

and boom! padding issue fixed!

now: bottom nav bar dont show whats selected
```
valCurrentRoute: String = nav.currentBackStackEntry?.destination?.route ?: ""
```
this works, but doesnt update the UI because it doesnt have state!

fix with:
``` Kotlin
val backStackEntry = nav.currentBackStackEntryAsState()
val currentRoute: String = backStackEntry.value?.destination?.route ?: ""
```

and boom! no highlighted page issue fixed!
	note that if the library doesn't contain state we could add it ourselves!

finally, New Song screen 

``` Kotlin
fun NewSongView(
	vm: NewSongViewModel = viewModel(),
	onAddSong: (Song) -> Unit
){
	...
}
```

and
``` Kotlin
val vm: SongListViewModel = viewModel()
navHost(

) {
	composable(Routes.AddSongScreen.route) { backstack: NavBackStackEntry ->
	//how do we get a reference to a view model???

	NewSongView(
		onAddSong = { song: Song ->
			// put newly created song into existing list and go back to SongList page
			//recall that the songList is stored in the SongListViewModel.kt file
			vm.addSong(song)
			navController.popBackstack()
		}
	)
}	
```

STUDY VIEWMODELS SO YOU DONT LOOK LIKE AN IDIOT


---------------

# Coroutines

## Concurrency
this class does NOT cover threads, research them on your own!
threads only work on multi-core processors

concurrency allows you to...
	- perform multiple tasks at once
	- make your app more responsive
	- avoid app crashes (more on this later)
	- do things faster (usually)

use a thread to handle the visualizers??

Threads can be created in Kotlin very easily!
``` Kotlin
thread {
	//do the thing on a thread...
}
```
DOESNT RETURN ANYTHING
also note that you cant use threads too often
only use as many threads as you have processor cores
spawning thousands of threads can take all your memory lol

# Threads vs Coroutines

- threads are more expensive than coroutines
- coroutines dont necessarily run on a separate thread

## Android Threading
- your code CANNOT block the UI (Main) thread
- android will display a "App Not Responding" dialog box
- Any long running tasks should be done on a thread (>16.67 ms (like ALL web requests!))
- this includes files, databases, and networking

## Networking
- Android forces you to write ALL networking code on a background thread
- your app will crash otherwise


## Coroutines
- the NEW AND PREFERRED way to handle concurrency in Android
- typically, does not create a new thread per coroutine
- MANY coroutines can be launched (millions)
	- threads can NOT do this!

- do NOT map to threads directly
- safe to create 1000Ks of coroutines
- can be suspended/resumed **SUPER NEAT**

demo!
``` Kotlin
Demo(
	vm.text,
	updateText = { vm.setTextAsync("DONE")},
	waiting = vm.waiting.value,
	modifier = Modifier.padding(innerPadding)
)
```
``` Kotlin
fun setTextAsync(msg: String) {
	viewModelScope.launch {
		waiting.value = true
		text = ""
		delay(5000)
		text = "DONE"
		waiting.value = false
	}
}
```

the circle spinner is just
``` Kotlin
	if(waiting) {
		CircularProgressIndicator() 
	}
```
lol

note that
delay(5000)
and
Thread.sleep(5000)
can be used to stop for a while, but Thread.sleep on the main thread causes Android to throw a "Demo isn't working -> Close app" warning!

most important part of all this is the line
```
viewModelScope.launch {}
```
this works bc we're in a viewmodel

put it in a function in your viewmodel to work asynchronously

now suppose:
```Kotlin
Scaffold(...) {
	val vm: DemoViewModel by viewModels()
	val scope = rememberCoroutineScope()
	Demo(
		vm.text,
		updateText = {
			scope.launch {
				vm.waiting.value = true
				delay(5000)
				vm.text = "BLAH"
				vm.waiting.value = false
			}
		}
	)
}
```
this takes the coroutine out of the viewmodel

now notice that you cant call delay() outside of a coroutine
	it should only be called from a coroutine or another suspend function


## Suspend/Resume
- adding *suspend* to a function definition will enable it to be used in coroutines
```
suspend fun getUser(): User {
	...
	return user
}
```

***only launch coroutines in a vm***
	make every function that works long operate in a suspend function thats launched from the viewmodel

```
...

	fun setTextSynch(msg: String) {
		viewModel.scope.launch //??
		...
	}

	suspend fun setTextAsync(msg: String) {
		waiting.value = true
		text = ""
		delay(5000)
		text = "DONE"
		waiting.value = false
	}
}
```
notice that delay(5000) now works

as a result, we'll end up with a bunch of suspend functions

now we have 2 *flavors* of functions: regular and suspendable
	make sure you're using the appropriate one!!

## Dispatchers
- allow you to specify which thread the coroutine runs on
	- Dispatchers.Main -> Runs on the UI/Main thread
	- Dispatchers.IO -> Optimized for IO tasks (network calls, file reads, etc)
	- Dispatchers.Default -> for CPU intensive tasks off the main thread
		- could be useful for playing audio for the met?

``` Kotlin
fun setTextSync(msg: String){
	viewModelScope.launch {
		withContext(Dispatchers.IO) { //instantiate on an IO thread
				withContext(Dispatchers.Main) { //switch to main thread (NOTE: Generally not a good idea to nest Dispatchers like this)
					setTextAsynch(msg)
				}
			}
		}	
	}
}
```

# Lab time!