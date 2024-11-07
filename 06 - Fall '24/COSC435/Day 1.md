Android App Development
Randy Valis
Fall 2024

agenda
* introductions
* android background
* git crash course

lab at end of every class
lectures and labs are recorded as 2 separate files

you dont need an android device, we'll use emulators
	you can use yours if you want lmfao

labs 1x/week, due at the end of the day Tuesday
	the 1st and prolly 2nd lab will be due by end of week

hw assignments are independent
	6 assignments, 2 are assigned today

rvalis@towson.edu

RESOURCES
	https://developer.android.com
	http://stackoverflow.com/questions/tagged/android
	http://www.vogella.com/tutorials/android.html
	https://www.codementor.io/android
	http://www.udacity.com

Course Schedule:
	a single final project
		group project (groups of 3)
	pretty open ended, pitch an idea, just build a mobile app
	present the app to the class at the end

6 assignments
	make them well documented and cite sources

final exam M December 16th from 7:30-9:30pm
	no midterm

personal machines probably cant handle the work lmfao

requirements:
	16gb memory

grade breakdown
	assignments/labs: 40%
	attendance/participation: 10%
	Project: 35%
	Exam: 15%

no late work
communicate professionally
grades posted online

dont cheat lol
	0 grade/ F in class

----------------------------
Practical
* software engineering, mobile application development, UI design, version control, unit testing
* Android Studio, Android Development Tools, Kotlin, Git, Sqlite

we will use Kotlin as our programming language
all of next class will discuss Kotlin
"Kotlin is like 90% java and the rest of the 10% is quirky syntax"
	Google uses Kotlin!

Kotlin has features that make it feel modern

---------
on Android Studio...
we use Koala, or v 2024.1.1 Patch 2
developer.android.com lets you install it
between now and the end of the sem, google will release a new version
	we will NOT update!!!

assignments 3,4,5,6 will each have their own app!!
we'll always start from an empty activity

file naming convention is
(company domain backwards).(class).(last name).(projectname)
edu.towson.cosc435.Ketterlinus.demoapp

dump stuff in an easily accessible, empty folder

gradle is a build tool that builds other applications

----------
on git/bitbucket...
assignments pushed to bitbucket for submission

we will be using Git to
* submit assignments
* distribute sample code
* collaborate with partners
* (reuse code)

Version Control

Git
* Distributed (no central source)
* local
* Offline

Others
* Subversion
* TFS (Team Foundation - Microsoft)
* Mercurial
* ???

Bitbucket
https://bitbucket.org
* we will use this for our class
* free private repositories for students
* will host your HW assignments, labs, and projects
* Github slightly better lmfao

git != github
git runs locally
it tracks changes to files

git pushes and pulls from servers, like github

Github
Bitbucket

git talks to the server, and sends the code to the server, and the server can distribute it to others

---------
Teacher will invite you to a BitBucket group
you need to make an account with student email
this is a mess, hope the HW documentation helps lmfao

------
Basics of Git

we wont use ALL the features, he'll teach us the bare minimum of what we'll use for the class
he will post a lecture on basic linux terminal commands
* ls lists files in a folder, use -a to show hidden folders
* cd changes current working directory
* mkdir - make directory, takes the name as an argument
* pwd - print working directory
* rm -r (file) will remove the file
* clear clears the terminal
* touch main.py makes an empty file called main.py
* cat spits out the contents of a file

git has files in 4 states
* untracked
	* all files begin untracked
	* git doesnt keep track of these
	* make git aware of these files with git add
* tracked
	* git is aware of this file
* staged
	* files in the staged stage will be committed in the next step
* commited
	* once you make a commit, all the files in the staged...
	* git commit -m "(message here)"
	* you can view this commit (the entire state of your project at this point in time) by checking out this commit!

basic commands
git init
* initializes a new git repository
* always add...

git status
	tells the status of the current project

git log prints out in descending order the commits added to a project
git config user.email "nketter@students.towson.edu"
git config user.name "Nathan Ketterlinus"

git add . 
	stages everything in current directory

git log
	view history of commits
	look into aliases here

git checkout (commit hash from git log)
	lets you work with an older version of a project
	only have to type enough of the hash to uniquely identify it

"make small changes to your project and commit"

git tag (new name) (hash)
	tagging assigns a name to a specific commit
	$ git tag <tag-name>

	tag final versions of HW for teacher

On Remotes...
	Everything thus far is local

git push
	pushes a commit to a remote server
	everything is local until you push!

git pull


git remote -v
	lists remotes you've connected to current project


steps to link git to bitbucket:
	create repo on BB
		***INCLUDE .GITIGNORE? -ALWAYS SET TO NO!!!***
	for the most part, use HTTPS over SSH
		this uses a separate, app password
	in project directory, run git remote add origin https://nketter@bitbucket.org/nketter/gitdemo.git
	ensure with git remote -v
	run git push origin main --tags
	when prompted for a password, you need to make an app password
		go to settings > personal bitbucket settings > app passwords
		fill in appropriate permissions
			eg write to a repository
		save the password to a password manager

lab time!

assignment 1 and 2 are available, look at them

"im gonna use a program called vim, do not try this at home"