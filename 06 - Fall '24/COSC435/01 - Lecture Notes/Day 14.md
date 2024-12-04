---
aliases:
  - Android
  - App Development
  - Kotlin
  - COSC435 12-02-2024
tags:
  - "#COSC435"
cssclasses:
---
From: [[2024/12/02]]

-------
# Day 14 ([[12-02-2024]])

# Agenda
- Review (Permissions/Location)
- Quiz
- BroadcastReceivers
- ContentProviders
- Lab
- Quiz 2!

Final Exam Study Guide:
![[Study Guide.pdf]]

Final in this room! Make sure lab pc works!!
25 multiple choice Qs
	30 or 40 min total
	Rest of time for 6 coding tasks

# Quiz 1
Q. What are Intents used for in an Android app?
	a) To pass data between applications
	b) To start another application
	c) To start another Activity
	d) ==All of the above== (and more!)

Q. What are Services used for in an Android app?
	a) ==To run code without a user interface== (on the main thread)
	b) To run code in a background thread
	c) To make network API calls (just do it in the frontend 4head)
	d) All of the above

Q. When making network requests, care must be taken to...
	a) Write the fewest lines of code as possible
	b) ==Make network requests on a background thread==
	c) Make network requests on the main thread
	d) All of the above

--------
# Review
we used a library to ask for permissions at runtime
we looked at how to open google maps with a certain lat and long

``` kotlin
fun openMaps(location: String) {
	val intent = Intent(Intent.ACTION_VIEW).apply {
		data = Uri.parse("geo:${location}")
		flags = Intent.FLAG_ACTIVITY_NEW_TASK
	}
	getApplication<Application>().startActivity(intent)
}
```

------

# BroadcastReceivers

new app shared with us:
PermissionsDemo

### BroadcastReceivers:
- Publish-Subscribe (Pub-Sub) from the System and other Apps
- Subscribe to system events
- Broadcast events from within your app

for system-wide events

### System Events
- Boot finished
- Wifi on/ Wifi off (this is outside the ConnectivityManager)
- Package install (defaults to all new packages, but you can inspect each one and filter!)
	- think of writing your own home-screen application!
```Kotlin
class MyReceiver : BroadcastReceiver() {

	override fun onReceive(context: Context, intent: Intent) {
		when(intent.action) {
			Intent.ACTION_BATTERY_LOW -> {
				Toast.makeText(context, "Power low!!!", Toast.LENGTH_SHORT).show()
				EventBus.getDefault().post(Msg("Battery low"))
			}
			Intent.ACTION_BATTERY_OKAY -> {
				EventBus.getDefault().post(Msg("Battery restored"))
			}
			Intent.ACTION_POWER_CONNECTED -> {
				EventBus.getDefault().post(Msg("POWER CONNECTED"))
			}
		}
	}
}
```

^^^ this code uses the EventBus library, which is not best practice anymore lulw
system is constantly sending out events, its your job to subscribe to what you want!

to see the extras in a system notification, you need a key!
	"how would I find that out?"
	- Check the documentation dummy!
```kotlin
val level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
```

how to subscribe to events?
	its NOT SUFFICIENT to do:
```kotlin
Intent.ACTION_BATTERY...
...
```

2 ways to register for an event!
### Manifest Registered
```kotlin
<receiver android:name=".MyBroadcastReceiver"
android:enabled="true"
android:exported="true"> //lets your broadcastReceiver be seen outside your app!
	<intent-filter>
		<action android:name""android.intent.action.B...
		...
```

^^^ Still not sufficient!
need to register with the context too!

### Context-Registered
- Create a receiver in code.
- Register it with a context
- Receiver is valid as long as the context is alive

``` kotlin
val br: BroadcastReceiver = MyBroadcastReceiver()
//do this ...
...
...
```

for some events: need to register in both!
somewhere in SDK is a list that tells you which permissions need to be registered where!

If targeting devices newer than Android 8, MUST be registered in code!

# Content Providers

Android Components
1. Activity
2. Service (abstracted away in this course)
3. Broadcast Receiver
4. ==Content Provider==
	1. not a fun process to write your own

Motivation:
- Share Tasks with other apps
- Demo

how to share data in a private database?
- with Content Providers!

``` kotlin
<permission android:name="edu.towson.cosc435.valis.contentproviderdemo.READ"/>
<provider
	android:name=".PersonContentProvider"
	android:authorities="edu.towson.cosc435.valis.contentproviderdemo.provider"
	android:enabled="true"
	android:exported="true"
	android:permissions="edu.towson.cosc435.valis.contentproviderdemo.READ"
provider/>
```

The other app launches an intent to start this app in  different activity ("pick")
- then it gets sent back to the other app & all the data you subscribed to!

### Why do we need Content Providers?
- Content Providers are used when your app needs to share data with other components/apps
	- think of how it relates to the home screen application again!
		- appWidget moment!
- Encapsulate your data
- Provides data security

### Other use cases:
- Share access to your data with other apps
- Send data to a widget
- Return custom search suggestions for your app
- Synchronize your data with a server (SyncAdapter)
- Load data in your UI (CursorLoader)


### How are they used?
- Send queries to the ContentResolver
	- similar to a SQL query!
- Get back a Cursor
	- basically a database result set!
- "Publish" a Content Uri (sort like a url)
```kotlin
content://todos_app/todos
```

### Querying Existing Content Providers
### Contacts
...
...
need to request permission in manifest lol

``` kotlin
class PersonContract {
	companion object {
		val AUTHORITY = "edu.towson.cosc435.valis.contentproviderdemo.provier"
		val CONTENT_URI = Uri.parse("content://$AUTHORITY")
		
		private val PERSONS_URI = "${AUTHORITY}.persons"
	
		val PERSON_NAME_EXTRA = "person_name_extra"
		val PERSON_AGE_EXTRA = "person_age_extra"
	}

	Class Person {
		companion object {
			const val TABLE_NAME = "person_table"
			const val ID = "_ID"
			const val NAME = "name"
			const val AGE = "age"
			...
			...

			// a projection of all columns in the items table
			PROJECTION_ALL = array of(ID, NAME, AGE)
		}
	}
}
```

when would we use this in our app?
	android provides a "contacts" and "calendar" content provider
	- twitter, etc use this content provider to tell you who you know!

### Permissions
```kotlin
<uses-permission android:name="edu.towson.cosc435.valis.contentproviderdemo.READ" />

<queries>
	<provider android:authorities="edu.towson.cosc435.valis.contentprovider.provider" />
</queries>
```

when the user installs from the play store, it comes with a list of permissions!

### Query
```kotlin
mProjection = arrayOf (
	Contacts._ID,
	Contacts.DISPLAY_NAME_PRIMARY,
	Contacts.LOOKUP_KEY
	Contacts.PHOTO_THUMBNAIL_URI
)

//retrieves the profile from the Contacts Provider
mprofilecursor = ...
....
...
...
```

### Reading
- same as reading a cursor from a database query.

``` Kotlin
Curso cursor = ...
while(cursor.moveToNext()) {
	cursor.getString(...)
}
```


on the final project, hell be running on an older emulator (version 30!)

lab time!!

# Quiz 2

Q. What are BroadcastReceivers used for?
	a) To broadcast reception events
	b) To receive JSON from a web API
	c) ==To subscribe to system events==
	d) All of the above

Q. What are ContentProviders used for?
	a) To share data between applications
	b) To provide data to an AppWidget
	c) To manage safe access to data
	d) ==All of the above==

no coding task on these topics on exam!
- but possibly 