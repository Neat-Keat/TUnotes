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
```
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
	**d. onPause, onStop, onDestroy**
	