---
aliases:
  - Android
  - App Development
  - Kotlin
  - COSC435 11-18-2024
tags:
  - "#COSC435"
  - COSC435/Services
  - COSC435/WorkManager
  - COSC435/Notifications
  - COSC435/Intents
cssclasses:
---
From: [[2024/11/18]]

-------
# Day 12 ([[11-18-2024]])


Project due in 3 weeks!!
12/9!!

Final Exam 12/16 7:30-9:30pm


## Final Project requirements:
5 slide minimum pptx that includes:
1. title (app and group member names)
2. explain what problem your app solves
3. list essential tech used in making the app
	1. will deduct points for mentioning certain technologies (like android studio or the emulator!! basically stick to stuff outside of stuff covered in lecture!)
4. A description of the most difficult/challenging piece of making the app (1 per person is fine!)
5. Questions slide!

after the presentation, a live demo!

on the SQLite Database
	write the code for a database, but actually use it!
	use the ROOM library!

on the README:
	explain what the project is, and like to any 3rd party libraries
	put it in the root of the project folder!

# Agenda
- Coding Task (Final Exam prep)
- Services/WorkManager (Review)
- Notifications (cont.)
- Intents

we'll need to install an older version of android IE before version 33

----------
What is a service? why should we use it?
- Useful for accessing a database when an app isn't actively running (think Twitter)
- Generally use one any time a process takes >1 sec


![[Pasted image 20241118193627.png]]
The ? is a subscription that Progress Workers can use!

``` Kotlin
WorkManager
	.getInstance(app)
	.getWorkInfoByIdLiveData(req.id)
	.observe(app as MainActivity, { data: WorkInfo ->
		progress = data.progress.getInt("progress", 0)
	})
}) 	
```

### LiveData
you can wrap any object in LiveData
ex. \[1,2,3,4,5]

then you can use functions on it like:
\[1,2,3,4,5].observe
	this is the old way we did state I believe

-------

# Notifications

add a freakybob is calling notification with callstyle field lololol

https://developer.android.com/guide/topics/ui/notifiers/notifications

![[Pasted image 20241118190557.png]]
1. Small Icon (required)
2. App Name (system provided)
3. Timestamp (system provided)
4. Large Icon (optional)
5. Title
6. Text

## Channels
Starting with Android 8, all notifications must be assigned a Channel.
Users can turn on/off notifications by channel and assign channels different priorities


but what is a Notification Channel?
	they categorize types of notifications for users
		lets them opt in or out as they please!

example:
``` kotlin
private fun createChannels() {
	var name = "SERVICE_DEMO_CHANNEL"
	var descriptionText = "Notificatn channel for ServiceDemo"
	var importance = NotificationManager.IMPORTANCE_DEFAULT
	var channel = NotificationChannel(NOTIF_ID, name, importance).apply {
		description = descriptionText
	}
	//register the channel with the system
	val notificationManager: NotificationManager =
		applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as Notification
	notification
	...
	...
}

companion object {
	val NOTIF__ID = "edu.towson.cosc435"
	val NOTIF_ID2 = "edu.towson.cosc435.(...)"
}
```
## Example
1. Build the notification
2. Using the NotificationManager, call notify
3. Update a notification by using the same ID

note that one channel can support multiple notifications that are defined by different IDs
to "update" a notification, just republish a notification with the same ID as the old one

``` Kotlin
var builder = NotificationCompat.Builder(this, CHANNEL_ID)
	.setSmallIcon(R.drawable.notification_icon)
	.setContentTitle(textTitle)
	.setContentText(textContent)
	.setPriority(NotificationCompat.PRIORITY_DEFAULT) 
	
NotificationManager.notify(id, builder.build())
```

## Tap action
Users typically expect to tap a notification and open your app
1. Create a PendingIntent
2. setContentIntent() on the notification
``` Kotlin
val intent = Intent(this, AlertDetails::class.java).apply { 
	flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
}
val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
... 
builder.setContentIntent(pendingIntent)
...
```


you can play custom sounds with 
	.setSound(sound: Uri?)

you can vibrate with:
	.setVibrate(pattern: LongArray?)
	//note that .setVibrate(arrayOf(1000L, 2000L, 500L).toLongArray()) will have it vibrate for 1 second, then 2s, than 1/2s


--------

# Intents

- Start Activities and start Services
- pass data between apps and components within an app (super important!!)
	- lets you take data from your app and send it to another app!
- open other apps
- and more!

## Explicit vs Implicit

```kotlin
val intent = Intent()
val intent2 = Intent(ctx, SomeComponent::class.java) // explicit
val intent3 = Intent(Intent.ACTION_DIAL) // implicit
```

## Starting Activities
``` kotlin
val intent = Intent(Intent.ACTION_PICK)
try {
	context.startActivity(intent)
} catch (e: Exception) {
		//no activity found?
}

```

## Intents (with results)

https://developer.android.com/training/basics/intents/result

This example uses the getContent result contract
https://developer.android.com/reference/androidx/activity/result/contract/ActivityResultContracts

``` kotlin
val getContent = registerForActivityResult(GetContent()) {
	uri: Uri? -> 
	// Handle the returned Uri
}
... 
getContent.launch("image/*")
```

# Custom Contracts

``` Kotlin
class PickRingtone : ActivityResultContract<Int, Uri?>() {
	override fun createIntent(
		context: Context,
		someInputData: Int) = 
			// create the intent 
		
		override fun parseResult(resultCode: Int, result: Intent?) : Uri? {
		// retreive the result from the Intent
	} 
}
```

------

# Permissions
- on pre-6.0 devices, just add to manifest
``` kotlin
<uses-feature android:name="android.hardware.camera"
	android:required="false" /> 
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
```
- Write external storage if you want to be able to write to the public Photos folder
- On 6.0 and above, you must request individual permissions

## Marshmallow Permissions
- Users are prompted at runtime
- Each permission is asked for individually
- always check if permissions have been granted
- if not, prompt for permissions
- handle the onRequestPermissionResult callback method in your Activity

## More permissions
- You may request multiple permissions at once
- Users may choose to always ignore the permission
- Users may deny permissions

## Request Permissions
- Request multiple permissions at once.
- Include a requestId

``` Kotlin
if(ContextCompat.checkSelfPermission(this,
	android.Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
		PackageManager.PERMISSION_GRANTED) {
	ActivityCompat.requestPermissions(this, arrayOf(
		android.Manifest.permission.WRITE_EXTERNAL_STORAGE), MY_REQUEST_CODE)
	return null
}
```

## Jetpack Compose
Google Accompanist library

https://google.github.io/accompanist/permissions/

provides support for runtime permissions in Jetpack Compose

---------

# Location APIs

## Google Play Services
In order to access a device's location, you must have Play Services installed
An emulator with Play services is required
``` kotlin
implementation 'com.google.android.gms:play-services-location:18.0.0'
```

## Permissions
In order to access a user's location, you must, at runtime, ask for permission
``` kotlin
Manifest.permission.ACCESS_FINE_LOCATION
```

## Code
Three major components are needed in order to get location updates:
1. FusedLocationProviderClient
2. A location request
3. A location callback

## FusedLocationClient
**Fused** meaning its a combination of Wifi and GPS
``` kotlin
private lateinit var fusedLocationClient: FusedLocationProviderClient
	override fun onCreate(savedInstanceState: Bundle?) {
	// ...
	fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
}
```

## Location Request
``` kotlin
val locationRequest = LocationRequest.create()?.apply {
	interval = 10000 // milliseconds
	fastestInterval = 5000
	priority = LocationRequest.PRIORITY_HIGH_ACCURACY
}
```

## Location Callback
Gets called when location changes occur
``` kotlin
	locationCallback = object : LocationCallback() {
		override fun onLocationResult(locationResult: LocationResult?) {
			// do something with the location
		}
	}
```

Finally, initiate the request...
``` kotlin
	fusedLocationClient.requestLocationUpdates(
		locationRequest,
		locationCallback,
		Looper.getMainLooper()
	)
```