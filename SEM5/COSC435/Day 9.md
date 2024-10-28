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

Big Idea: *LaunchedEffect runs coroutines in composables in a controlled manner*

``` Kotlin
Surface(color = MaterialTheme.colorScheme.background) {
	val scope = rememberCoroutineScope()
	MainScreen()
	scope.launch {
		Log.d("Main Activity", "Launching a coroutine")
	}
}
```