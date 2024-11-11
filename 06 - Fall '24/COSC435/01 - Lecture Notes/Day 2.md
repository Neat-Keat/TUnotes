Android App development
Towson University
Randy Valis
Fall 2024

Agenda:
- House Keeping
- Final Projects
- Assignments
- Review
- Kotlin
- Lab 2
---------------

download video lectures from BB, they disappear after a few weeks automatically
read links on BB agenda each week before lecture

final project:
	due 12/9
	proposal and requirements are available
		they are due on the 23rd (2 weeks from today)
	proposal is a 3 slide presentation
	requirements: list of requirements your app will fulfill

groups available on BB
	if you dont join by next monday, you'll be autoassigned

on the project proposal:
	scope of the application is pretty broad
		you can do whatever you want, but you need an achievable idea

on the project requirements:
	need 10 user requirements
	make them complete sentences
		1. The user should be able to control the tempo of the metronome
		2. The user should be able to control the sound being played
		3. The user should be able to accent every Nth beat
		4. The user should be able to control the rhythm being played back (8th, 16th, triplet note subdivisions)
		5. The user should be able to program and playback tempo changes
		6. The user should be able to gradually accelerate the tempo of the metronome
		7. The user should be able to use the metronome with a visualizer for difficult listening environments
		8. The user should be able to time and log how long they practice over different intervals (day, week, etc)
		9. 
		10. 


Assignment 2 is due on the 23rd (2 weeks)
	familiarize yourself with kotlin
	done completely in the browser?
	submitting a URL
		try to solve the problem yourself, but solutions exist online
	copy link -> submit the shortened one lol
		submit 3 screenshots with green checkmarks
	Intro, Classes, Collections sections are required, others are optional

Review
	last class we talked about git!
	look into gitscm online
		has a free pdf of the Pro Git textbook 2nd edition (2014)
	look into free resources posted on BB (the missing semester, esp the 1st vid)

Git review!
4 file states
- untracked
- tracked
- staged
- committed

a commit is a snapshot of the changes to your files at a point in time
	(think of a linked list)
	![[Pasted image 20240909194636.png]]

use checkout to switch between snapshots

"head" is whatever's pointing to your working directory
head /= main branch
make tiny changes? commit it!
	only benefits!

git init
	initializes a new git repo
	always add and commit a project before changing stuff
git status
	lists the status of current repo
	shows which tracked files have changed and which files are staged for commit
git log
	see other branches

-----------
on Kotlin:
	Kotlin is "a modern, statically typed lang with 100% interoperability with java and android"
	since 2017, fully supported by Google in Android Studio
		static lang means declared variables are of a certain type, and that CANNOT be changed

Basics
	Syntax\
		no semi-colons
		inline functions
		class-less functions
		no *new* keyword
		val, var
			val declares an immutable variable
			var declares a mutable variable (still cant change type)
				declare everything as a val, and go back and change *IF NEEDED*
		Otherwise, a lot like Java (classes, methods, packages)

Immutability
- lots of collections are immutable by default listOf() vs mutableListOf()

var aList: List<String> = listOf("hello", "world")
	List<String> is an optional annotation
	no .add function, because the list is immutable by default
	make a mutable list with 
		var aList: MutableList<String> = mutableListOf("Hello", "World")

difference between a mutable object and a mutable variable pointing to an object

Type inference
- local variable's types 
- ...
- ...

Nullable
- by default, variables can't be null
- Use ? to denote a nullable variable
	var hello: string = "Hello World"
		CANNOT do: hello = null
	must do:
	var hello: String? = "Hello World"
		CAN do: hello = null
		also have to call functions like:
			hello?.length
almost always use the non-nullable version, but annotate with nullable versions when interfacing with legacy java code, where anything can be null

Functions
	- can be *top-level* (not inside a class)\
	- Parameter types must be declared as well as return types


```fun sayHello(msg: String): String { 
	return "Hello, ${msg.uppercase()}!!!"
}
sayHello("World")
```


Lambdas
	- otherwise known as inline functions
	- much more concise than anonymous interface implementations

control flow
	- in addition to loops and if statements, Kotlin provides the very powerful: when
	- like a switch statement on steroids
	- can switch on values, types,...

```fun sayHello(msg: String): String { 
	return "Hello, ${msg.uppercase()}!!!"
}
val msg: String? = sayHello("World")

val msgLen: Int = when(msg) {
	null -> 0
	else ->msg.length
}
```

Data Classes
- Data classes make class declaration much more concise
- cant be extended (class is final)
- auto-generates getters, setters, equals(), hashCode(), toString(), and copy()

```data class User(val name: String)

val user1: User = User("Bob")
```

regular class
 - no generated toString()
 - *can* be extended

------------------

Lab time!





