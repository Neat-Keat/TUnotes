assignment 3 due date pushed back a week to 10/7
only deals with content from last week
	columns, rows, text, buttons, etc

assignment 4 assigned today, adjusted to be due 10/14
	tip calculator app
	uses what we cover today, and thats it

today:
more jetpack compose
	handling events today!

agenda!
- Quiz
	- sample questions for what to expect on exam
	- not graded! just review material!
- Lambdas
- Modifiers (cont)
- Theming
- Compose Events
- Lab

Q 1. 
What type does the following function return?

```
fun example(): ???? {
	var x: String? = null
	val y = x?.toInt()
	return y
}
```
a. String?
b. String
c. Int
d. *Int?*

Q2.
what is the type of the following x variable?
```
fun example() {
	val x = { y: Int ->
		(y+1).toString()
	}
}
```
a. String
b. Int
c.*(Int) -> String*
d. (String) -> Int

note the type signatures of the lambda function denoted by the arrow!
# Lambdas
-----------
```
val x = { }
```
this is valid syntax, it assigns a function to the variable x (of type function)"
	doesnt take any inputs or outputs rn
	rn its technically of type "() -> Unit"" 
		of the form (parameters) -> (output)

now consider:
```
val x: () -> String = {
	val myLocalVar = "hello"
	myLocalVar
}
```

return type is of the last expression in the {}
	Above example returns a type String
	recall there's no return keyword, its done implicitly

```
val x: () -> String = {
	val myLocalVar = "hello"
	myLocalVar + " world"
}

x()     //outputs "Hello World"
```

passing a single variable (named "arg)
```
val x: (String) -> String = { arg -> 
	val myLocalVar = "hello"
	myLocalVar + " world"
}

x("ANDROID")     //outputs "Hello World"
```

passing >1 variable

```
val x: (String, Int) -> String = { arg1: String, arg2: Int ->
	val myLocalVar = "hello"
	myLocalVar + " world"
}

x("ANDROID")     //outputs "Hello World"
```

when to use a lambda over a function?
	consider:

```
fun HigherOrder1(callback: () -> Unit){
	callback()
}

HigherOrder1{
	println("Hello World") //outputs "Hello World"
}
```
trailing lambda is useful to make your code look cleaner, but the usage is much more convenient
	just being able to pass around functions is huge (?)
	more use cases will be covered later i guess

---------
# Modifiers

all custom functions should accept a modifier argument for customizability's sake
see relevant .txt file

-----------
# Theming

--------

# Events & State

"probably the most important concept of the course"
"students are easily confused here"

The TextField Does not update
	its our responsibility to hold the state of the user's input
```


@Composable
fun HelloContent() {
	//this is how we add state
	var text: MutableState<String> = remember { mutableStateOf("")}  
	
	Column(modifier = Modifier.padding(16.dp)) {
		OutlinedTextField(
			value = text.value,
			onValueChange = { newValue: String ->
				//update the state
				text.value = newValue
			},
			label = { Text("Name")}
		)
		Text(text.value, fontSize = 28.sp)
	}
}
```

TLDR: define your state outside, pass it inside, then update it in the function

how does it know to redraw??
	under the hood, the MutableState<String> = remember { mutableStateOf("") } is doing a lot of heavy lifting

*MutableState is what causes the UI to update*
	it lets the entire UI know something changed, then the UI redraws it

* the remember function remembers the initial object that was created*
whenever we update anything, the entire function re-executes
	this loop reinitializes the initial condition without the remember keyword
		think of it like a cache

you can run logcat outside of android studio, ie thru the terminal
	~ adb logcat

to recap:
to handle events, we need:
	- mutable state
	- pass the state to a composable
	- handle updates (generally update state)
	- use remember to cache initial state

Remember
	composables can hold state in a *remember* composable
	- initial composition: creation of a Composition by running composables the first time
	- Recomposition: re-running composables to update the Composition when data changes

Composable Lifecycle
Enter -> Recompose 0 or more times -> Leave

useful examples on slideshow

As the state object below is mutated, the Text composable is either rendered or completed removed from the UI
`