MISSED FIRST 25 MINUTES BC OF HOCO PARADE, CHECK RECORDING!!!

-----------------------

# Agenda
* Lab 5 review/finish
* Navigation
* Scaffold
* Dialogs
----------
![[Pasted image 20241014193231.png]]
*State flows down the UI tree*

```kotlin
if(LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE){
	LandscapeView{
		LazyColumn{
			items(songs) { song ->
				SongRow(song, onDelete, onToggle)
			}
		}
	}
}
```

```kotlin
@Composable
fun LandscapeView(content: @Composable () -> Unit) {
	Row(
	){
		Card(
			modifier = Modifier
				.size(250.dp)
				.align(Alignment.CenterVertically)
		)
	}
		...
		...
		...
}
```

# CompositionLocal
A tool for passing data down through a composition *implicitly*

# Navigation
will this relate to the hamburger menu and drop downs?

1. NavController
NavController maintains a backstack as you navigate through different screens in your app
```kotlin
val navController = rememberNavController()
```

Create this add the top off your compose view hierarchy

2. NavHost
NavHost declares the destinations/routes that your app will navigate to. Each route is a string, similar to a url

```kotlin
NavHost(navController = navController, startDestination = "screen)
	composable("screenOne") {ScreenOne(/*...*/) }
	composable("screenTwo") {ScreenTwo(/*...*/)}
```

3. Navigate
Use .navigate to switch routes. The navigation controller will track the stack and allow the user to backtrack
```kotlin
navController.navigate("screenTwo")
```
Avoid passing the NavController to destination controllers. Instead, use state hoisting and expose a function to navigate

in order to use this library, you have to add it to your project!
how?
if you do it now, you do it through a libs.version.toml file
	info guide linked on https://developer.android.com/build/migrate-to-catalogs#kts
	also on Slack

this file is in Gradle Scrips/libs.versions.toml
first section is versions, lists versions of dependencies
```kotlin
[versions]
navigation = "2.8.2"   //note navigation can be called anything you want

[library]

androidx-navigation-compose = { module = "androidx.navigation:navigation-compose", version.ref = "navigation" }
```

the module part is important, it comes from the documentation
```kotlin
implementation("androidx.navigation:navigation-compose:$nav_version")
```

then, in the build.gradle.kts file:
```kotlin
implementation(libs.androidx.navigation.compose) //note that dashes became dots, with libs prepended
```

congrats, now your project can use it! lets go back to MainActivity:
```kotlin
Scaffold(modifier = Modifier.fillMaxSize()){
	val navController: NavHostController = rememberNavController()
	Main(navController)
}

@Composable
fun Main(
	nav:NavHostController,
){
	NavHost(
		navController = nav,
		startDestination = Screens.First.route
	){
		composable(Screens.First.route) {
			FirstScreen({ route -> nav.navigate(route)}) //allocates an extra unnecessary function over (nav::navigate)
		}
		composable("second/{name}){ backstack ->
			val name = backstack.arguments?.getString("name") ?: "DEFAULT"
			Log.d("TAG", "$name")
			SecondScreen(name, {route ->
				nav::navigate(route){
					popUpTo("first")
				}
			}
		}
		composable("Third"){
			ThirdScreen(nav::navigate)
		}
	}
}

sealed class Screens(val route: String){
	object First : Screens("First")
	object Second : Screens("Second")
	object Third : Screens("Third")
}
```

navController keeps track of a backStack for you, makes it SUPER useful

note that to access screen 3, you need to add:
```kotlin
@Composable
fun SecondScreen(
	nav: (String) -> Unit
){
	Button({
		nav(Screens.Third.route)
	}){
		Text("Nav to page 3")
}
}
```

x :: y is a shorthand for x(y) //i think?? 

---------

# Navigation Options
![[Pasted image 20241014201444.png]]
first is used when:


if backstack is empty, pressing back = leave the app by default

being able to highjack the backstack is useful in scenarios like online shopping, so you dont accidentally go pack to a payment page, etc

do NOT add buttons to get everywhere!!
	it'll make the backstack useless!!

utilize the backstack to make everything linear

consider:
```kotlin
popUpTo("first") { launchSingeTop(true)} //syntax changed lol
```

what this does: if a page is already in the backstack, it wont re-add it to the stack
its not elegant ("not what he wants"), but it works

# Arguments
Routes can include *arguments*, similar again to a http url path. Arguments can be required (path-based) or optional (query-based)
```kotlin
NavHost(navController = navController, startDestination = "screen")
	composable("ScreenOne") {ScreenOne(//)}
	composable("screenTwo/{name}") { backStack ->
		val name: String? = backStack.arguments?.getString("name")
		ScreenTwo(//)
	}
}
navController.navigate("screenTwo/Randy")
```


```kotlin
@Composable
fun FirstScreen(
	nav: (String) -> Unit
){
	Button({
		nav("second/yourNameHere!!)
	}){
		Text("Nav to page 3")
}
}
```

# More arguments
Query parameters can also be used for optional arguments
- must provide a default
- or make the parameter nullable
```kotlin
"two?name={name}",
arguments = listOf(navArgument("name") { defaultValue = "Randy"
})...
...
...
```


# Scaffold
Scaffold has a generic content trailing lambda slot, plus parameters for TopBar, Drawer, BottomBar, and FloatingActionBars. These are all optional.
```kotlin
Scaffold(
	topBar = {
		topAppBar { // }
	},
	drawContent = {
		DrawerContent { // }
	},
	bottomBar = {
		BottomAppBar { // }
	},
	floatingActionButton = {
		FloatingActionButton { //}
	}
) {
	//Screen Content
}
```

lab time!!
