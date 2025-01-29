---
aliases:
  - OS
  - Operating Systems
  - COSC439 01-29-2025
tags:
  - "#COSC439"
  - COSC439/CH1
cssclasses:
---
From: [[2025/01/29]]

------
# Day 1 ([[01-29-2025]]) 

# Chapter 1: Introduction

computer systems can be divided into 4 components:
1. Hardware
	1. CPU, memory, I/O devices
	2. provides basic computing resources
2. Operating system
	1. Controls and coordinates use of hardware among various applications and users
3. Application programs
	1. define the ways in which the system resources are used to solve the computing problems of the users
4. Users
	1. People, machines, other computers

4 layered on 3 layered on 2 layered on 1

Apps send a message to the OS, Builds network packets for hardware, sends the message to users

# What is an OS?
- a program that acts as an intermediary between a user of a computer and the computer hardware
- OS goals:
	- execute user programs and make solving user problems easier
	- make the computer system convenient to use
	- Use the computer hardware in an efficient manner

- OS's turn ugly hardware into beautiful abstractions
![[Pasted image 20250129151901.png]]

### Defining an Operating System
- OS is a ==resource allocator==
	- manages all resources
	- decides between conflicting requests for efficient and fair resource use
- OS is a ==control program==
	- Controls execution of programs to prevent errors and improper use of the computer
	- think of it like the lights at an intersection preventing crashes

- ==Bootstrap program== is loaded at power-up or reboot
	- typically stored in ROM or EPROM, generally known as ==firmware==
	- initializes all aspects of system
	- Loads operating system kernel and starts execution
### Computer-System Operation
- I/O devices and the CPU can execute concurrently
- Each device controller is in charge of a particular device type
- Each device controller has a local buffer
- CPU moves data from/to main memory to/from local buffers
- I/O is from the device to local buffer of controller
- Device controller informs CPU that it has finished its operation by causing an ==interrupt==
![[Pasted image 20250129152610.png]]
ex. 
you're making a table, then your doordasher knocks on your door with food. You are interrupted, eat your food, and come back to remember the table you've been working on

ex. 
you press a button on a keyboard, generating an interrupt for the CPU. The CPU takes the data from the keypress, then feeds it to the relevant program, then goes back to normal execution.

> if anything happens, it happens through interrupting the OS

## Storage Structure
- Main memory - only large storage media that the CPU can access directly
	- ==Random access (RAM)==
	- typically ==volatile==
- Secondary storage - extension of main memory that provides large ==nonvolatile== storage capacity
- Hard disks - rigid metal or glass patterns covered with magnetic recording material
	- Disk surface is logically divided into ==tracks==, which are subdivided into ==sectors==
	- the ==disk controller== determines the logical interaction between the device and the computer
- ==Solid-state disks== - faster than hard disks, nonvolatile
	- various technologies
	- Becoming more popular

- Storage systems organized in hierarchy
	- speed
	- cost
	- volatility
- ==Caching== - copying information into faster storage system; main memory can be viewed as a cache for secondary storage
![[Pasted image 20250129153204.png]]

  think of cloud storage as an extra layer under magnetic tapes
### Caching
- important principle, performed at many levels in a computer (in hardware, OS, software)
- info in use copied from slower to faster storage temporarily
- Faster storage (cache) checked first to determine if information is there
	- if it is, info used directly from cache
	- if not, data copied to cache and used there
- Cache smaller than storage being cached
	- Cache management important design problem
	- Cache size and replacement policy

![[Pasted image 20250129153719.png]]

## Computer-System Architecture
- most systems use a single general-purpose processor
	- most systems have special-purpose processors as well
- ==Multiprocessors== systems growing in use and importance
	- also known as ==parallel systems, tightly-coupled systems==
	- Advantages include:
		1. ==Increased throughput==
		2. ==Economy of scale==
		3. ==Increased reliability==
			1. graceful degradation or fault tolerance
![[Pasted image 20250129153957.png]]

Two types:
1. ==Asymmetric Multiprocessing== - each processor is assigned a specific task
2. ==Symmetric Multiprocessing== - each processor performs all tasks
![[Pasted image 20250129154056.png]]

### Clustered Systems
- like multiprocessor systems, but multiple systems working together
	- usually sharing storage via a ==storage-area network (SAN)==
	- provides a ==high-availability== service which survives failures
		- ==Asymmetric clustering== has one machine in hot-standby mode
		- ==Symmetric clustering== has multiple nodes running applications, monitoring each other
	- Some clusters are for ==high-performance computing (HPC)
		- Applications must be written to use ==parallelization==
	- Some have ==distributed lock manager (DLM)== to avoid conflicting operations
![[Pasted image 20250129154435.png]]

video rendering utilizes parallelization, for example!

## Operating System Structure
- ==Multiprogramming (Batch system)== needed for efficiency
	- Single user cannot keep CPU and I/O devices busy at all times
	- Multiprogramming organizes jobs (code and data) so CPU always has one to execute
	- A subset of total jobs in system is kept in memory
	- One job selected and run via ==job scheduling==
	- When it has to wait (for I/O for example), OS switches to another job
	- think of a lawyer working for multiple clients at once
- ==Timesharing (multitasking)== is a logical extension in which CPU switches jobs so frequently that users can interact with each job while it is running, creating ==interactive== computing
	- ==Response time== should be < 1 second
	- Each user has at least one program executing in memory -> ==process==
	- If several jobs ready to run at the same time -> ==CPU scheduling==
	- if processes don't fit in memory, ==swapping== moves them in and out to run
	- ==Virtual memory== allows execution of processes not completely in memory
![[Pasted image 20250129155058.png]]

## Operating-System Operations
- ==Interrupt driven== (hardware and software)
- Software interrupt (==exception== or ==trap==):
	- Software error (ex /0), Request for operating system service
- Other process problems include infinite loop, processes modifying each other or the operating system
- ==Dual-mode== operation allows OS to protect itself and other system components
	- ==User mode== and ==kernel mode==
	- ==Mode bit== provided by hardware
		- provides ability to distinguish when system is running user code or kernel code
		- some instructions designated as ==privileged==, only executable in kernel mode
		- System call changes mode to kernel, return from call resets it to user

## Transition from User to Kernel Mode
- Timer to prevent infinite loop / process hogging resources
	- Timer is set to interrupt the computer after some time period
	- Keep a counter that is decremented by the physical clock
	- Operating system set the counter (privileged instruction)
	- When counter zero generate an interrupt
	- Set up before scheduling process to regain control or terminate program that exceeds allotted time
![[Pasted image 20250129155646.png]]

## Process Management
- A process is a program in execution. It is a unit of work within the system.. Program is a **passive entity**, process is an **active entity**.
- Process needs resources to accomplish its task
	- CPU, memory, I/O, files
	- initialization data
- Process termination requires reclaim of any reusable resources
- Single-threaded process has one ==program counter== specifying location of next instruction to execute
	- Process executes instructions sequentially, one at a time, until completion
- Multi-threaded process has only one program counter per thread.
- Typically system has many processes, some user, some OS running concurrently on one or more CPUs
	- Concurrency by multiplexing the CPUs among the processes / threads

- Context switch!
	- recall the table building scenario: when switching jobs, the OS needs to know the state of each task, so it creates a snapshot of each job when it leaves it, and switched to the snapshot of each job it switches to

## Process Management Activities
The OS is responsible for the following activities in connection with process management:
- creating and deleting both user and system processes
- Suspending and resuming processes
- Providing mechanisms for:
	- process synchronization
	- process communication
	- deadlock handling

## Memory Management
- To execute a program all (or part) of the instructions must be in memory
- All (or part) of the data that is needed by the program must be in memory
- Memory management determines what is in memory and when
	- Optimizing CPU utilization and computer response to users
- Memory management activities
	- Keeping *track of* which parts of memory are currently being used and by whom
	- Deciding which processes (or parts thereof) and data to *move into* and *out of memory*
	- *Allocating* and *deallocating memory* space as needed

## Storage Management
- OS provides uniform, logical view of info storage
	- Abstracts physical properties to logical storage unit - ==file==
	- each medium is controlled by device (ie disk drive, tape drive)
		- varying properties include access speed, capacity, data-transfer rate, access method (sequential or random)
- File-System management
	- Files usually organized into directories
	- Access control on most systems to determine who can access what
	- OS activities include:
		- Creating and deleting files and directories
		- Primitives to manipulate files and directories
		- Mapping files onto secondary storage
		- Backup files onto stable (non-volatile) storage media

## Performance of Various Levels of Storage
![[Pasted image 20250129161015.png]]

## Mass-Storage Management
slide skipped lol

## Protection and Security
- ==Protection== - any mechanism for controlling access of processes or users to resources defined by the OS
- ==Security== - defense of the system against internal and external attacks
	- huge range, including DOS, worms, viruses, identity theft, theft of service
- Systems generally first distinguish among users, to determine who can do what
	- User identities (==user IDs==, security IDs) include name and associated number, one per user
	- User ID then associated with all files, processes of that user to determine access control
	- Group identifier (==group ID==) allows set of users to be defined and controls managed, then also associated with each process, file
	- ==Privilege escalation== allows user to change to effective ID with more rights
## Distributed Computing
- Collection of separate, possibly heterogeneous, systems networked together
	- ==Network== is a communications path, ==TCP/IP== most common
		- ==LANs==
		- ==WANs==
- ==Network Operating System== provide features between systems across network
	- Communication scheme allows systems to exchange messages
		- Illusion of a single system

## Computing Environments - Traditional 
- Stand-alone general purpose machines
- But blurred as most systems interconnect with others (ie the Internet)
- ==Portals== provide web access to internal systems
- ==Network computers (thin clients)== are like Web terminals
- Mobile computers interconnect via ==wireless networks==
- Networking becoming ubiquitous - even home systems use ==firewalls== to protect home computers from Internet attacks
## Computing Environments - Client-Server 
- Client-Server Computing
	- Dumb terminals supplanted by smart PCs
	- Many systems now ==servers==, responding to requests generated by ==clients==
		- ==Compute-server system== provides an interface to client to request services (ie database)
		- ==File-server system== provides interface for clients to store and retrieve files
![[Pasted image 20250129162305.png]]

## Computing Environments - P2P 
- Another model of distributed system
- P2P does not distinguish clients and servers
	- instead all nodes are considered peers
	-  May each act as client, server or both
	- Node must join P2P network
		- Registers its service with central lookup service on network, or
		- Broadcast request for service and respond to requests for service via **discovery protocol**
	- Examples include Napster and Gnutella, ==Voice over IP (VoIP)== such as Skype
![[Pasted image 20250129162515.png]]

## Open-Source Operating Systems
- OS's made available in source-code format rather than just binary ==closed-source==
- Counter to the ==copy protection== and ==DRM== movement
- Startted by ==Free Software Foundation (FSF)==, which has "copyleft" ==GNU Public License (GPL)==
- Examples include ==GNU/Linus== and ==BSD UNIX== (including core of ==MAC OS X==), and many more
- Can use VMM like VMware Player, Virtualbox
	- use to run guest operating systems for exploration