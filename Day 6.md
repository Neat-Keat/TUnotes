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
```
JetpackComposeDemoTheme(dynamicColor = false,)
```
must do this for final!!
can also do
~~~
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