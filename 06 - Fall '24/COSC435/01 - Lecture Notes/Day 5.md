resubmit assignment 3 from a new repo (NOT LabsApp)

assignment 3 - static UI
"
upload project to bitbucket
separate repo from ALL other repos for labs AND assignments
start every assignment from an empty activity in Android Studio
that way they wont be linked to anything in BB
make sure that the new project is NOT nested in another existing assignment

on bitbucket:
create repo - 'Assignment3' (in existing project: fall2024) - include.gitignore? NO!!! include a README? NOOOO!!!
in the local project, link it to this new remote, then push, then submit

will deduct points if incorrect lol
""

-------

today: Lists, State Hoisting
lab 5: Songs app - song list

on the final project: make small incremental steps towards it! (best way to do it!!)
	should already have made the project, now think about making a UI (actually do it???)
	1st prototype due 10/24!!!
		preferred format is (see your face + screen)
		2 present the 1st one, last person presents the 3rd one
		can do through BB collaborate
		can use other software (OBS and Discord??)

# Agenda
- review
- theming/material design
- lists
- LazyColumn/Row
- State Hoisting
- Lab

# Review
last week, we moved on from static UI to interactive UI with simple event handling
	recall:
``` kotlin
TextField -> onTextChange: ((String) -> Unit)?
Button -> onClick: () -> Unit
```

recall the ((String) -> Unit)? represents that it takes a String *argument*, and returns an object of type *Unit*, but the entire expression is *nullable*

now consider the Checkbox:
	OnCheckedChange: (Boolean) -> Unit
``` kotlin
val checked = remember { mutableStateOf(false) }

@Composable
Checkbox(
	checked = checked.value,
	onCheckedChange = { newValue -> 
		checked.value = newValue
	}
)
```

remember that when you click the checkbox, the ENTIRE function reexecutes!!
	be careful to code responsibly!!
	dont CallTheWebAPI() inside your @Composables!!
		details later

From last week's slides, we skipped:

Delegate
``` kotlin
var name by remember{} 
```

is syntactic sugar for
``` kotlin
val (value, setValue) = remember{}
```

Where setValue is a function for setting the state value Using by syntax requires
``` kotlin
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
```

applying this to the checkbox, it becomes:
``` kotlin
var checked: Boolean by remember { mutableStateOf(false) }
	//dont forget to import state.getValue & .setValue

@Composable
Checkbox(
	checked = checked,
	onCheckedChange = { newValue -> 
		checked = newValue
	}
)
```

looks like we aren't using mutableStateOf(), which makes it look prettier but obfuscates the code
	most code online looks like this

# Theming
Material Design
Material is a design system created by Google to help teams build high-quality digital experiences

note that the lecture is NOT comprehensive enough to stand alone, do your own research
https://m3.material.io

from a dev's POV, it means that there's pre-built components that already use the best practices, we just have to use them
	examples:
		- checkbox
		- outlinedTextField
		- anything in androidx.compose.material3.*
note that Material Design has a heavy focus on Primary and secondary colors and *animations*

simple button lol
``` kotlin
Button({}){
	Text("Click")
}
```

what do we need to know?
	Material Theming is a systematic way to customize Material Design to better reflect an app's brand. A Material Theme contains color, typography, and shape attributes
``` kotlin
MaterialTheme(
	colorScheme = ...
	typography = ...
	
)
```

final needs to customize this, its found
	Android -> Kotlin + Java ->  (project domain) -> ui.theme -> {Color.kt, Theme.kt, Type.kt}
	colors can change from a color picker in the gutter of your code!

in theme.kt, theres a composable that defines the used theme! look for 
``` kotlin
val colorScheme = when {
	...
}
```
around line 43?

in MainActivity.kt, towards the top:
``` kotlin
(Project Name)Theme{
	...
		MainScreen()
}
```

(project Name)Theme defines what theme your project uses, as defined in Theme.kt

Dark Theme
``` kotlin
@Composable
fun MyTheme(
	darkTheme: Boolean = isSystemInDarkTheme(),
	content: @Composable () -> Unit
) {
	MaterialTheme(
		colorScheme = if (darkTheme) DarkColors else LightColors ...
		...
	)
}
```

back on the m3 website, theres a link to a builder tool!
	google "material design tool"
	will be posted to Slack
	have to do this for final
	it does give you a jetpack compose file you can copy paste into your project, but he doesnt like it bc copying whole files is bad
		EXPORT AS "Jetpack Compose (Theme.kt)"
		the resulting folders can be dropped over top of existing ones in project (replacing?)
		hardest part is putting the files in the right place

Typography
Specify your theme's text styles
``` kotlin
val MyTypography = Typography(
	titleLarge = TextStyle(
		fontFamily = Rubik,
		fontWeight = FontWeight.W300,
		fontSize = 96.sp
	),
	bodyMedium = TextStype(
		fontFamily = Rubik,
		fontWeight = FontWeight.W600,
		fontSize = 16.sp
	),
	subtitle = TextStyle(
	...
	)
)
```

allows for mass refactoring basically

in your MainScreen(), now you can use these values with:
``` kotlin
Text(text.value, style = MaterialTheme.typography.titleLarge //or whatever)
```

-----------

# Lists

Kotlin makes use of *higher order functions* (functions that take another function as a parameter)

Lists/Collections are a common place where *higher order functions* are used

today, we'll use:
	Collections -> lists : {Map{}, Filter{}, ForEach{}}

the Map({}) is a function on a list 
	think [1, 2, 3].map{}
	or [1, 2, 3].filter{}

Map
``` kotlin
val things: List<Thing> =
(0..10).map{i ->
	Thing(i, ...)
}
```

map transforms a list of objects: T into a list of objects: S
	ie Map: List<T> -> List<S> 

in class demo:

``` kotlin
val newList = 
(o <= .. <= 10).map {i: Int -> (i * 2).toString() }
	//returns [0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20], where each element is a String
	//is basically a rule that maps all existing vals to new ones
```

this idea of performing functions on functions is CRITICAL to how we'll progress in the class

filter is very similar:
``` kotlin
val filteredList =
	(0<=..<=10).filter{ i: Int -> i  % 2 == 0 }
	//returns [0, 2, 4, 6, 8, 10]
	//is basically a rule for what to keep
```

on ForEach
``` kotlin
(0<=..<=10).forEach { i -> println(i) }
	//prints each num 1 thru 10 on its own line
```
whats the diff between map and for each?


naive approach:
``` kotlin
@Composable
fun MessageList(messages: List<Message>) {
	Column {
		messages.forEach { message -> MessageRow(message)
		}
	}
}
```

``` kotlin
val messages = (0 <= .. <= 100).map { i -> "Message #${i}"}
Column {
	messages.forEach { message ->
		Text(message, fontSize = 18.sp)
	}
}
```
this is problematic bc the screen can't fit all the lines, so you need to change your Parent Column to have the Modifier.verticalScroll()), which needs a lot of complicated stuff to work

but jetpack compose is still making the other 80, and wasting CPU resources

how to solve this issue? LazyColumn / Lazy Rows!!


previous code changes to:
``` kotlin
val messages = (0 <= .. <= 100).map { i -> "Message #${i}"}
LazyColumn {
	items(messages){ message: String ->
		Text(message, fontSize = 24.sp)
	}
}
```

note:
	items(messages){ message ->
			Text(message, fontSize = 24.sp)
		}

and
	messages.forEach { message ->
		Text(message, fontSize = 18.sp)
	}

are functionally equivalent, but now you can scroll thru the list of messages!
	the lazyColumn will only be called to scroll when interacted with!
	can be proved with println(message) and looking at logcat while scrolling
note that its important not to CallWebAPI() in a lazyColumn for very similar reasons to above
	if the LazyColumn is too busy, then the user will have lots of lag

think about nesting columns and LazyRows like Netflix lol

------------
# State Hoisting

In order to make composables reusable, we need to make them stateless

State Hoisting pattern
	A pattern used to make a composable stateless
	...

Ex:
``` kotlin
@Composable
fun HelloScreen(){
	var name by rememberSaveable { mutableStateOf("") }
	
	HelloContent(name = name, onNameChange = { name = it})
		//"it" is an implicit reference to argument -> only works when function only has 1 argument
}

@Composable
fun HelloContent(name: String, onNameChange: (String) -> Unit) {
	Column(modifier = Modifier.padding(16.dp)) {
		Text(
			text = "hello, $name",
		)
		OutlinedTextField(
			value = name,
			onValueChange = ...
			...
		)
	}
}
```
change state to args so you can use it later basically


in lab today, we'll be starting to build a full app week over week, and using state hoisting for future stuffs
