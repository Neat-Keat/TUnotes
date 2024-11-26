---
aliases:
  - Android
  - App Development
  - Kotlin
  - COSC435 11-25-2024
tags:
  - "#COSC435"
cssclasses:
---
From: [[2024/11/25]]

-------
# Day 13 ([[11-25-2024]])

second coding task today!

Today:

Location Services and Permissions!

next week (12/2): Last Lecture!
The week after (12/9): Presentations!
The week after (12/16): Final Exam! (7:30pm-9:30pm)

# Agenda
- Review (notifications/intents)
- Coding Task 2 (final exam prep)
- permissions
- location API


Valis shared ComposePermissionsDemo project with us, will be demo'd from today!
rewatch lecture bc i was distracted
# Intents
...

This example uses the GetContent result contract
## Contracts
```Kotlin
val getContent = registerForActivityResult(GetContent())
	...
	...
```

## Permissions
- on pre-6.0 devices, just add to manifest
``` Kotlin
<uses-feature android:name="android.hardware.camera"
	android:required="false" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_ />
```
- Write external storage if you want to be able to write to the public Photos folder
- on 6.0 & above, you must request individual permissions

## Marshmallow Permissions
- Users are prompted at runtime
- Each permission is asked for individually
- Always check if permissions have been granted
- if not, prompt for permissions
	- we'll do this with a third party library!
- Handle the onRequestPermissionResult callback method in your Activity

## More permissions
...
...

## Request Permissions
- Request multiple permissions at once.
- Include a requestID


```Kotlin
...
...
```


## Jetpack Compose
Google Accompanist library (https://google.github.io/accompanist/permissions/)
Provides support for runtime permissions in Jetpack Compose


--------

```Kotlin
private fun requestLocation() {
	val locReq = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 10000).build()
	if(PermissionChecker.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PermissionChecker.PERMISSION_GRANTED) {
		locationClient.requestLocationUpdates(
			locReq, //the location request
			locationCallback, //the callback for when the location is updated
			Looper.getMainLooper() // the loop running to update the UI (used bc its a legacy library!)
		)
	}
}
```

------

launchedEffects let us launch Coroutines


# Location APIs

## Google Play Services
In order to access a device's location, you must have Play Services installed
An emulator with Play services is required
``` Kotlin
implementation 'com.google.android.gms:play-services-location'
```

also for adding ads!
if its not in the core SDK, its in Google Play Services

## Permissions
In order to access a users location...
...

## Code
Three major components are needed in order to get location updates:
1. FusedocationProviderClient
2. A location request
3. A location callback

``` Kotlin
@ExperimentalPermissionsAPI
override fun onCreate(savedInstanceState: Bundle?) {
	super.onCreate(savedInstanceState)
	locationClient = LocationServices.getFusedLocationProviderClient(this)
	locationCallback = object : LocationCallback() {
		override fun onLocationResult(result: LocationResult){
			super.onLocationResult(result)
			//I HAVE THE LOC
			location = "${result.lastLocation?....}"
			...
			...
		}
	}
}
```

check the location infrequently so as to not drain the user's battery!

## Fused Location Client
...
...

## Location Callback
Gets called when location changes occur
```Kotlin
locationCallback = object : LocationCallback() {
	override fun onLocationRequest(locationResult: LocationResult) {
		//do something with the location
	}
}
```

Finally, initiate the request
```kotlin
fusedLocationClient.requestLocationUpdates(
	locationRequest,
	locationCallback,
	Looper.getMainLooper()
)
```

lab time!