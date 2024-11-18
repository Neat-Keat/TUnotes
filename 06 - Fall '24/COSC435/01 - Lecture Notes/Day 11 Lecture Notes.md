---
aliases:
  - Android
  - App Development
  - Kotlin
  - COSC435 11-11-2024
tags:
  - "#COSC435"
cssclasses: []
---
From: [[11]]

-------
# Day 11 ([[11]])

# Agenda
- coding task 1
- Review (REST/Network)
- Images
- Services/WorkManager
- Notifications

---------
# Coding task 1
one of at least 2, maybe 3 coding tasks today
- format of the task is very similar to the 6 tasks youll get on the final exam
- fairly empty project, you have to implement a function
	- have about 10 minutes to write the code and complete the task
- all tasks are relatively small, and most are self contained (woohoo!)

next coding task is NOT next week, but 2 weeks from now ("maybe")

------
# Review (REST/Network)
#Met remember to use my-json-server.typicode.com for internet usage!!
REMEMBER to make network calls on background threads!!
``` Kotlin
override suspend fun fetchSongs(): List<Song> {
	return withContext(Dispatchers.IO) {
		val client: OkHttpClient = OkHttpClient()
		val request: Request = Request.Builder().get().url(URL).build()
		//execute the request
		val response: Response = client.newCall(request).execute()
		if(response.isSuccessful) {
			val body: String? = response.body?.string()
			val gson = Gson()
			val songList = gson.fromJson<Array<Song>>(body, Array::class.java)
			songList.toList() //return the song list from this function
		} else {
			listOf()
		}
	}
}
```

when making web requests, remember to:
- add dependencies
- be mindful of how many times you're calling the API
- do NOT run on background thread
- add permission to use the internet to the AndroidManifest.xml
	 <uses-permission android:name="android.permission.INTERNET" [INCOMPLETE]>

if you run into SSL issues in the emulator:
	make sure your emulator's time is set properly
	clock on your device has to be "pretty close" to the real time, otherwise the TLS handshake fails

we want a mechanism to check for updates and auto update our database for us!
- facebook does this!!

## On images in last week's lab:
note that another project has been shared with us about services!

``` Kotlin
...
		val client = OkHttpClient()
			.newBuilder()
			.cache(
				Cache(
					directory = cacheDir,
					maxSize = 10L * 1024 L //100kb
				)
			)
			.build()
		val request = Request.Builder()
			.get()
			.url(url)
			.build(),
		val response = client.newCall(request).execute()
		delay(3000)
		val stream = response.body?.byteStream()
		val bitmap = BitmapFactory.decodeStream(stream)
		BitmapFactory.decodeResource(application???)
		bitmap
	)
```

when fetching images, only render ones that you actively need so you arent burning network resources
but how?
	ensure the fetchIcon function (or whatever is calling an API) is only running when it's parent element is visible!

in MainActivity:
``` Kotlin
LaunchedEffect(key1 = user.id) {
	vm.fetchIcon(user)
}
```

in vm:
``` Kotlin
suspend fun fetchIcon(user:User) {
	if(!isOnline()) return
	user.icon.value = usersFetcher.fetchIcon(user.avatarURL)
}
```

``` Kotlin
if(user.icon.value != null){
	Image(
		modifier = Modifier.size(128.dp),
		bitmap = user.icon.value?.asImageBitmap()!!, contentDescription = null)
	} else {
		CircularProgress Indicator(
			modifier = Modifier.size(128.dp)
		)
	}
}
```

this last block is equivalent to:
```Kotlin
items(vm.users.value) { user ->
	val painter = rememberAsyncImagePainter(
		ImageRequest.Builder(LocalContext.current)
			.data(data = user.avatarUrl)
			.crossfade(true)
			.placeholder(R.drawable.ic_launcher_foreground)
			.build()
	)
	...
}
```
combined with:
``` Kotlin
Image(
	modifier = Modifier.size(128.dp),
	painter = painter, contentDescription = null
)
```
from the io.coil-kt library!
	https://coil-kt.github.io/coil/

neither is better or worse
	library may be less code, but you have less control!

--------
# Services/WorkManager

android has always had this object called a service
	its whole point is to run code in the background
	we've been doing this with coroutines
		technically you should only do this for things that take a trivial amount of time

best use case for a service is to run in the background and check a network resource


Ideal app setup:
![[Pasted image 20241111201035.png]]

## Service
- can run in the background without a UI
- Still runs on the UI thread, though
- Potential use cases:
	1. Download/upload large files
	2. Play music
	3. **Persistent socket connections**
- foreground services must display a notification
	- android doesnt want your app doing something the user is unaware of!

A process is only created in the OS for an application actively using resources
can processes communicate with each other?
	yes! through pipes!

![[Pasted image 20241111201437.png]]

## Service Types
- Foreground Started
	- we'll focus here
- Background Started
- Bound

## Modern Services
- JobService
- WorkManager
both use a scheduler to efficiently schedule background tasks
	without it thats why old android killed your battery!

## WorkManager
- uses the JobManager (andJobService) under the hood for efficient scheduling
- has first-class support for coroutines

## How to
- create a WorkRequest (one-time or periodic)
- optionally set Constraints
- Schedule the WorkRequest

## Constraints
Constraints allow background jobs to be scheduled only when certain constraints are met
1. NetworkType
2. Battery level
3. Idle status
4. Charging status
5. Disk storage amount

now we examine ServicesDemo:

- Workers run when called
- ScheduledWorkers run when called AND at regular intervals after this!
	- if theres no notification, it gets garbage collected first
- ProgressWorkers

LiveData is like the precursor to MutableState lol

## Input Data
Sometimes, your background worker will require some initial data, like a uri to download from. The Worker class allows passing key/value pairs to your worker
``` Kotlin
//see code in slides lololol
```

can pass key value pairs to workers with:
``` Kotlin
val inputs = workDataOf(
	"WORKER_KEY" to "HELLO WORLD",
	"WORKER_KEY2" to false
)
//covered up
	.setConstraints(constraint)
	.setInputData(inputs)
	.build()
```

likely service pathflow:
1. call API
2. put it in your database

# Notifications:
covered next time lol

![[Pasted image 20241111205033.png]]