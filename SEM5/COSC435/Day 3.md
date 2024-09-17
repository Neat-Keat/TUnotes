Today:
Lambdas
	READ STUFF FROM THE SYLLABUS 4HEAD

building UIs with Jetpack and compose
	will be used in the rest of the lectures this semester
	today it'll be completely static

assignment 3 is building a UI from scratch

Agenda
1. Kotlin review
2. Android Dev intro
3. App resources
4. Jetpack Compose

on bitbucket, there's the concept of a project
	a project is a root of repositories
	each android app you develop should have its own repository on BB
	do NOT nest applications!!

------------
reviewing Kotlin concepts
- how to declare variables
- difference between var and val
	- var is mutable
	- val is mutable
	``` 
		var hello: String? = "Hello World"
		hello = null
		hello?.length
	```

type inference!
	kotlin is pretty smart, it'll do its best to infer type
	dont forget the "?" operator that allows variables to be null

we have null pointer exceptions in kotlin largely through interacting with legacy APIs written in Java

functions!
Jetpack makes UI from Kotlin functions!

when > switch

class declarations!
```
data class User(val name: String)

val user1: User = User("Bob")
```

--------------
Android

Versions
- 2008 - SDK 1.0 released
	- went through a dessert naming scheme: Froyo, Gingerbread, Kitkat,...
- 2014 - SDK 5.0 released (Lollipop)
- 2020 - SDK 11.0 released (11)
- 2021 - SDK 12.0 released
- 2022 - SDK 13.0 released

generally you want to target the latest SDK version
	unless your userbase is running an older version lmfao
the android version you are building in is defined in the build.gradle.kts file

What is Google Android?
- a software stack for mobile devices that includes
	- an OS
	- middleware
	- ...
- Uses Linux to provide core system services
	- security
	- memory management
	- process management
	- power management
	- hardware drivers
- your apps sit on a layer on top of the linux OS
- the only thing accessible to your applications are android APIs

Android Apps
- built using Java/Kotlin and Android SDK libraries
	- no support for some Java libraries like Swing or AWT
- Java/Kotlin code compiled into ART byte code (.dex)
	- ART is optimized for mobile devices (better memory management, batter utilization, ...)
- Dalvik VM runs .dex files (not JRE) NOT .class!

Building and Running
- compile .kt or .java files into .dex
- combine AndroidManifest.xml, assets (images, files, ...), and .dex files into a single .apk (App Package)

Applications are Sandboxed
- by default, each app (and all its components!) run in its own Linux process
- by default, each app is assigned a unique Linux user ID
- Permissions are set so only your app can view its own files

----------
App Resources
- under the Android view in the top left 
	- note its NOT your project file explorer
- switch to Project view lmfao
- source code is in:
	app/src/main/java/edu/towson/cosc435/labsapp/MainActivity.kt
- under app/source/main
	- you have /java and /res
		- /res is your resources folder!
		- we care about the ones in the /values subfolder
if you want to edit the name of your program, its in ~/values/strings.xml

resources are stored in ~/res
these can be...
1. images
2. layouts
3. strings
4. raw audio/video
5. other data

-------------
Jetpack Compose Basics
	is Android's new UI Framework

Composables
UIs are built by combining (or composing) Composable functions, each of which produce a part of the UI
```
@Composable
fun Hello() {
	Text("Hello World")
}
```

```
Text()
Button{
	Text()
}
Text()
```

git init
git add .
git commit -m "Initial Commit"

delete greeting function and ...

you can put function definitions wherever you want
	important for what functions are able to access
		those outside of everything only have access to what you pass it

```
@Composable
fun MainScreen() {
	Column(){
		Text("Hello", fontSize = 24.sp)
		Text("World", fontSize = 24.sp)
		Text("!!!!!!", fontSize = 24.sp)
	}
}
```

Basic Elements
	Column
		Vertical stack of composables

in kotlin, {...} indicates a function (more specifically, a lambda)
	a lambda is just a function without a name

Alignment/Arrangement
```
Column(
	horizontalAlignment = Alignment.CenterHorizontally,
	verticalArrangement = Arrangement.SpaceEvenly
	modifier = Modifier
	.border(.2dp, Color.Red)
	.fillMaxWidth()
	.fillMaxHeight()
	.padding(20.dp)
) {
	Row(
		verticalAlignment = Alignment.CenterVertically,
		horizontalArrangement = Arrangement.SpaceEvenly,
		modifier = Modifier.border(2.dp, Color.Blue).fillMaxWidth()
	){
		Text("Hello", fontSize = 24.sp, modifier = Modifier.border(2.dp, Color.Green))
		Text("World", fontSize = 24.sp, modifier = Modifier.border(2.dp, Color.Green)))
		Text("!!!!!!", fontSize = 24.sp, modifier = Modifier.border(2.dp, Color.Green)))
	}
	
}
```

how to plan a UI? turn on borders! (see above!)

Order of modifiers matters!
they execute left -> right (top -> down)

when you do 
	modifier = Modifier
you're creating a new modifier object, then chaining effects on the tail of it
you can define global modifiers with:
	val myCustomModifier = Modifier.border(2.dp, Color.Red)
then use it with:
	modifier = myCustomModifier


look in documentation to see what each modifier does!!


Lab time!!
