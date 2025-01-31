---
aliases:
  - OS
  - Operating Systems
  - COSC439 01-30-2025
tags:
  - "#COSC439"
  - COSC439/CH2
  - OperatingSystemStructures
cssclasses:
---
From: [[2025/01/30]]

------
# Day 2 ([[01-30-2025]]) 

# Recap
![[Pasted image 20250130140258.png]]
## Chapter 2: Operating-System Structures
- OS Services
- User OS Interface
- System Calls
- Types of System Calls
- System Programs
- OS Design and Implementation
- OS Structure
- OS Debugging
- OS Generation
- System Boot

## OS Services
- OS's provide an environment for execution of programs and services to programs and users
- One set of OS services provides functions that are helpful to the user:
	- **UI** - Almost all OS's have a user interface (==UI==)
		- varies between ==Command-Line (CLI), Graphical User Interface (GUI), Batch==
	- **Program execution** - the system must be able to load a program into memory and to run that program, end execution, either normally or abnormally (indicating error)
	- **I/O operations** - A running program may require I/O, which may involve a file or an I/O device
![[Pasted image 20250130140924.png]]

- One set of OS services provides functions that are helpful to the user (CONT.)
	- **File-system manipulation** - the file system is of particular interest. Programs need to read and write files and directories, create and delete them, search them, list file information, permission management.
	- **Communications** - Processes may exchange information, on the same computer or between computers over a network
		- Communications may be via shared memory or through message passing (packets moved by the OS)
	- **Error detection** - OS needs to be constantly aware of possible errors
		- May occur in the CPU and memory hardware, in I/O devices, in user program
		- For each type of error, OS should take the appropriate action to ensure correct and consistent computing
		- Debugging facilities can greatly enhance the user's and programmer's abilities to efficiently use the system
- Another set of OS functions exists for ensuring the efficient operation of the system itself via resource sharing
	- **Resource allocation** - When multiple users or multiple jobs running concurrently, resources must be allocated to each of them
		- Many types of resources - CPU cycles, main memory, file storage, I/O devices
	- **Accounting** - to keep track of which users use how much and what kinds of computer resources
	- **Protection and security** - the owners of information stored in a multiuser or networked computer system may want to control use of that information, concurrent processes should not interfere with each other
		- **Protection** involves ensuring that all access to system resources is controlled
		- **Security** of the system from outsiders requires user authentication, extends to defending external I/O devices from invalid access attempts
![[Pasted image 20250130141909.png]]
![[Pasted image 20250130141946.png]]
## User Operating System Interface
CLI or ==command interpreter== allows direct command entry
- sometimes implemented in kernel, sometimes by systems program
- sometimes multiple flavors implemented - ==shells==
- Primarily fetches a command from user and executes it
- Sometimes commands built-in, sometimes just names of programs
	- if the latter, adding new features doesn't require shell modification
![[Pasted image 20250130142152.png]]

#### User Operating System Interface - GUI
- User-friendly ==desktop== metaphor interface
	- usually mouse, keyboard, and monitor
	- ==Icons== represent files, programs, actions, etc
	- Various mouse buttons over objects in the interface cause various actions (provide information, options, execute function, open directory (known as a ==folder==))
	- invented at Xerox PARC
- Many systems now include both CLI and GUI interfaces
	- Microsoft Windows is GUI with CLI "command" shell
	- Apple Mac OS X is "Aqua" GUI interface with UNIX kernel underneath and shells available
	- Unix and Linux have CLI with optional GUI interfaces (CDE, KDE, GNOME)
![[Pasted image 20250130142520.png]]
## System Calls
- System calls provide an interface to the service made available by an OS
- Typically written in a high-level language (C or C++)
![[Pasted image 20250130142636.png]]
2 modes to execute programs:
1. User mode - does NOT have direct access to memory, hardware
2. Kernel mode - DOES have direct access to memory, hardware (has the ALL privilege)
	1. if a kernel mode program crashes, then the entire system crashes

Thus, most programs are written to run in user mode.
	if they need info from kernel mode, it makes a system call to switch from user mode to kernel mode and back again. (called "Context Switching")

![[Pasted image 20250130143155.png]]
basically everything thats not the loop or writing a message to screen takes a system call

## Types of System Calls
- Process control
	- create process, terminate process
	- end, abort
	- load, execute
	- get process attributes, set process attributes
	- wait for time
	- wait for event, signal event
	- allocate and free memory
	- Dump memory if error
	- ==Debugger== for determining ==bugs, single step== execution
	- ==Locks== for managing access to shared data between processes
- File management
	- create file, delete file
	- open, close file
	- read, write, reposition
	- get and set file attributes
- Device management
	- request device, release device
	- read, write, reposition
	- get device attributes, set device attributes
	- logically attach or detach devices
- Information maintenance
	- get time or date, set time or date
	- get system data, set system data
	- get and set process, file, or device attributes
- Communications
	- create, delete communication connection
	- send, receive messages if ==message passing model== to ==host name== or ==process name==
		- from ==client== to ==server==
	- ==shared-memory model== create and gain access to memory regions
	- transfer status information
	- attach and detach remote devices
- Protection
	- control access to resources
	- get and set permissions
	- allow and deny user access

![[Pasted image 20250130144445.png]]

## System Programs
- System programs provide a convenient environment for program development and execution. They can be divided into:
	- File manipulation
	- Status information sometimes stored in a File modification
	- Programming language support
	- Program loading and execution
	- Communications
	- Background services
	- Application programs
- Most users' view of the OS is defined by system programs, not the actual system calls
![[Pasted image 20250130144715.png]]
in the lowest level, we find the hardware like CPU, memory, and IO devices
on top of that is the OS
on top of that are system and application programs. In reality application programs exist just outside system programs

## Operating System Design and Implementation
- Design and Implementation of OS not "solvable", but some approaches have proven successful
- Internal structure of different OS's can vary widely
- Start the design by defining goals and specifications
- affected by choice of hardware, type of system
- ==User== goals and ==System== goals
	- User goals - OS should be convenient to use, easy to learn, reliable, safe, and fact
	- System goals - OS should be easy to design, implement, and maintain, as well as flexible, reliable, error-free, and efficient
![[Pasted image 20250130145807.png]]
- Important principle to separate
	==Policy==: **What** will be done?
	==Mechanism==: **How** to do it?
- Mechanisms determine how to do something, policies decide what will be done
- the separation of policy from mechanism is a very important principle, it allows maximum flexibility if policy decisions are to be changed later (ex - timer)
- Specifying and designing an OS is a highly creative task of ==software engineering==

ex. think of a car's mechanism to go forward, compared to the gov's policy of speed limits to ensure safety

### Implementation
- much variation
	- early OS's in assembly language
	- then system programming languages like Algol, PL/1
	- now C, C++
- Actually usually a mix of languages
	- lowest levels in assembly
	- main body in C
	- Systems programs in C, C++, scripting languages like PERL, Python, shell scripts
- More high-level language easier to ==port== to other hardware
	- but slower
- ==Emulation== can allow an OS to run on non-native hardware

## Operating System Structure
- General-purpose OS is a very large program
- Various ways to structure ones
	- Simple structure - MS-DOS
	- more complex - UNIX
	- Layered - an abstraction
	- Microkernel - Mach
#### Simple Structure - MS-DOS
- MS-DOS - written to provide the most functionality in the least space
	- not divided into modules
	- although MS-DOS has some structure, its interfaces and levels of functionality are not well separated
![[Pasted image 20250130150927.png]]
no real user mode vs kernel mode, so any app crash also crashes the entire system
#### Traditional UNIX System Structure
![[Pasted image 20250130151135.png]]
high risk because of all the features packed into the kernel.
need to make sure small changes dont ruin everything else

#### Layered Approach
![[Pasted image 20250130151325.png]]
designing the layered structure is difficult. What goes on top of what?
major advantage is hardware access protection

#### Microkernel System Structure
![[Pasted image 20250130151612.png]]
basically implement all non-essential kernel functions as user-mode processes

#### Solaris Modular Approach
![[Pasted image 20250130151747.png]]
> perhaps this is by far the best methodology for OS design. leverages OOP concepts

## OS Generation
- OS's are designed to run on any of a class of machines; the system must be configured for each specific computer site
- ==SYSGEN== program obtains information concerning the specific configuration of the hardware system
	- Used to build system-specific compiled kernel or system-tuned
	- Can general more efficient code that one general kernel
## System Boot
- When power initialized on system, execution starts at a fixed memory location
	- Firmware ROM used to hold initial boot code
- OS must be made available to hardware so hardware can start it
	- Small piece of code - ==bootstrap loader==, stored in ==ROM== or ==EEPROM== locates the kernel, loads it into memory, and starts it
	- Sometimes two-step process where ==boot block== at fixed location oaded by ROM code, which loads bootstrap loader from disk
- Common bootstrap loader, ==GRUB==, allows selection of kernel from multiple disks, versions, kernel options
- Kernel loads and system is then ==running==
virus cannot touch ROM, and by extension the boot code