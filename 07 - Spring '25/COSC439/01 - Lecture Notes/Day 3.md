---
aliases:
  - OS
  - Operating Systems
  - COSC439 02-03-2025
tags:
  - "#COSC439"
cssclasses:
---
From: [[2025/02/03]]

------
# Day 3 ([[02-03-2025]]) 
![[Syllabus_COSC439_002_spring25.pdf]]

call prof MD Sajid or Mohammed
today: syllabus, overview of ch1 and ch2, intro to virtualization

intro to OS (ch1-2)
Process Management (ch3-6)


required textbook:
Abraham Silberschatz, Peter B. Galvin, Greg Gagne
...

Group Project
topics announced after midterm
2-3 students
project proposal 1-2 pages
originality and contribution: 
	proper references are expected
	everyone should contribute
final report: should not exceed 20 pages
Code submission and Presentation: Due last week of class
Grade: 20%

all members will be submitting a contribution report

code must work on his pc lolol
write a README.md or perhaps use docker


![[ch03.pdf]]

# Assignments/Homework
Assignments (5 coding based, 1 report based)
	8 assignments
	2 are mandatory (1 and 6)
	for the other 6, best 4 are considered
Quizzes:
	6 total
	Best of 4 considered
Grade:
	Assignments/HW: 20%
	Quizzes: 15%
	Midterm: 20%
	Final: 20%
	Attendance: 5%
	Project: 20%

for exams, we're given a question pool to help focus time and energy on key topics to prep

remember an A is 90-100% lolol

### office hours:
Tuesdays 12pm-1:00pm or 3:00pm-4:00pm
TA: Stephen Aboagye-Ntow
read policies in syllabus

if you cant make OH, just email

---

# CH 1 & 2 review

### Computer System Structure:

4 components:
		1. Hardware - provides basic computing resources
			1. CPU, memory, IO devices
		2. OS
			2. controls and coordinates use of hardware among various apps and users
		3. Application programs - define the ways in which the system resources are used to solve the computing problems of the users
			1. word processors, compilers, web browsers, database systems, video games
		4. Users
			1. people, machines, other computers

Apps send a message to the OS
OS builds network packets for the hardware
hardware sends a message to other users

### What is an OS?
- A program that acts as an intermediary between a user of a computer and the computer hardware
- OS goals:
	- execute user programs and make solving user problems easier
	- Make the computer system convenient to use
	- Use the computer hardware in an efficient manner

### Computer Startup
- ==bootstrap program== is loaded at power-up or reboot
	- typically stored in ROM or EPROM, generally known as ==firmware==
	- initializes all aspects of system
	- Loads OS kernel and starts execution

### Storage Structure
- Main memory (his name for RAM) - only large storage media that the CPU can access directly
	- ==Random access (RAM)==
	- typically ==volatile==
- Secondary storage (the hard disk) - extension of main memory  that provides large ==nonvolatile== storage capacity
- Hard disks - rigid m
- SSDs
### Computer-System Architecture
- Most systems used to have a single general-purpose processor
- ==multiprocessors== systems growing in use and importance
	- also known as ==parallel systems, tightly-coupled systems==
	- advantages include:
		- ==Increased throughput== (more cores = more speed)
		- ==Increased reliability== (if a core fails you can fallback to an alternate core)

Two types:
1. ==Asymmetric Multiprocessing== - each processor is assigned a specific task
2. ==Symmetric Multiprocessing== - each processor performs all tasks

### OS Structure
- ==Multiprogramming (Batch system)== needed for efficiency
	- single user cant keep CPU and IO devices busy at all times
	- Multiprogramming organizes jobs (code and data) so CPU
	- ...
- ==Timesharing==
	- ...
	- ...

OS decides which process gets hardware resources at any given time

### Transition from User to Kernel Mode
- Timer to prevent infinite loop / process hogging resources
	- Timer is set to interrupt the computer after some time period
	- Keep a counter that is decremented by the physical clock
	- OS set the counter (privileged instruction)
	- When counter zero generate an interrupt
	- Set up before scheduling process to regain control or terminate program that exceeds allotted time

### System Calls
- System calls provide an interface to the service made available by an OS
- typically written in a high-level language (C or C++)

### Process Management
- A process is a program in execution. It is a unit of work within the system. Program is a *passive entity*, process is an *active entity*
- Process needs resources to accomplish its task
	- CPU, memory, IO, files
	- Initialization data
- Process termination requires reclaim of any reusable resources
- Typically, system has many processes, some user, some OS running concurrently on one or more CPUs

who is responsible for managing these tasks?
	the OS!

### Memory Management
- To execute a program all (or part) of the instructions must be in memory
- All (or part) of the data that is needed by the program must be in memory.
- Memory management determines what is in memory and when
- Memory management activities
	- keeping track of which parts of memory are currently being used and by whom
	- deciding which processes (or parts thereof) and data to move into and out of memory
	- allocating and deallocating memory space as needed

think of how a 30 GB game can run on a PC with 8 GB of ram by only loading data associated with the current level

### Storage Management
- OS provides uniform, logical view of information storage
- File-System management
	- files usually *organized* into directories
	- *Access control* on most systems to determine who can access what
	- OS activities include:
		- Creating and deleting files and directories
		- Primitives to manipulate files and directories
		- Mapping files onto secondary storage
		- Backup files onto stable (non-volatile) storage media

### OS Design and Implementation (cont.)
==Policy==: What will be done?
==Mechanism==: how to do it?

- Mechanisms determine how to do something, policies decide what will be done
- The separation of policy from mechanism is a very important principle, it allows maximum flexibility if policy decisions are to be changed later (ex - File Access Control)
- Specifying and designing an OS is a highly creative task of ==software engineering==

# Virtualization
### Computing Environments - Virtualization
- Use cases involve laptops and desktops running multiple OSes for exploration or compatibility
	- Apple laptop running Mac OS X host, Windows as a guest
	- Developing apps for multiple OSes without having multiple systems
	- QA testing applications without having multiple systems
	- Executing and managing compute environments within data centers
- VMM (Virtual Machine Manager)...
	- ...

A technology that provides an abstraction of the resources used by some software which runs in a simulated environment called a virtual machine (VM)

VMs are also referred to as GUEST, whereas the physical system they run on is referred to as the HOST

### Virtualization Benefits
- Efficient Resource Utilization
	- Maximized hardware efficiency
	- Multiple VMs on a single physical server
- Support for Multiple OS systems
	- Run diverse operating systems on one physical system
- Isolation between VMs
	- independent operation of each VM
	- Ensures activities in one VM do not impact others