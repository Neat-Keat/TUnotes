Pop quizzes are open note  
2 exams, final is NOT comprehensive
 
Midterm covers ch 1-3.5  
Final covers everything past the midterm
 
Does NOT accept any late assignments
 
1 absence without penalty
 
Every absence on top of that removes a letter grade
 
Midterm on Wednesday, March 13th (NO LAB)  
Final during final week
 
No makeup exams or quizzes
 
No break in lectures
 
PPTX on BB
 
-------------------------------------------------------------------------------------------------------------------------------
 
Objectives

- What are computer organization and computer architecture?
- Understand units of measure common to computer systems
- Appreciate the evolution of computers
- Understand the computer as a layered system
- Be able to explain the von Neumann architecture and the function of basic computer components
 
1.1 Overview

- Why study computer organization and architecture?
    
    - Design better programs, including system software such as compilers, operating systems, and device drivers
    - Optimize program behavior
    - Evaluate (benchmark) computer system performance
    - Understand time, space, and price tradeoffs
- Computer organization
    
    - Encompasses all physical aspects of computer systems (eg circuit design, control signals, memory types).
    - How does a computer work?
- Computer architecture
    
    - Logical aspects of system implementation as seen by the programmer (eg instruction sets, instruction formats, data types, addressing modes).
    - How do I design a computer?
 
1.2 Computer Systems

- There is no clear distinction between matters related to computer organization and matters relevant to computer architecture
- Principle of equivalence of Hardware and Software
    
    - Any task done by software can also be done using hardware, and any operation performed directly by hardware can be done using software*
        
        - Assuming speed is not a concern
- At the most basic level, a computer is a device consisting of 3 pieces:
    
    - A processor to interpret and execute programs
    - A memory to store both data and programs
    - A mechanism for transferring data to and from the outside world
 
1.3 An Example System

- Measures of capacity and speed:
    
    - |   |   |   |
        |---|---|---|
        |Kilo (K)|1 Thousand|10^3 and 2^10|
        |Mega (M)|1 Million|10^6 and 2^20|
        |Giga (G)|1 Billion|10^9 and 2^30|
        |Tera (T)|1 Trillion|10^12 and 2^40|
        |Peta (P)|1 Quadrillion|10^15 and 2^50|
        |Exa (E)|1 Quintillion|10^18 and 2^60|
        |Zetta (Z)|1 Sextillion|10^21 and 2^70|
        |Yotta (Y)|1 Septillion|10^24 and 2^80|
        
- Whether a metric refers to a power of 10 or a power of 2 typically depends upon what is being measured
 
- Hertz = clock cycles per second (frequency)
    
    - 1 MHz = 1,000,000 Hz
    - Processor speeds are measured in MHz or GHz
- Byte = a unit of storage
    
    - 1 KB = 2^10 = 1024 Bytes
    - 1 MB = 2^20 = 1,048,576 Bytes
    - 1 GB = 2^30 = 1,099,511,627,776 Bytes
    - Main Memory (RAM) is measured in GB
    - Disk storage is measured in GB for small systems, TB (2^40) for large systems
 
- Measures of time and space

|   |   |   |
|---|---|---|
|Milli (m)|1 Thousandth|10^-3|
|Micro (µ)|1 Millionth|10^-6|
|Nano (n)|1 Billionth|10^-9|
|Pico (p)|1 Trillionth|10^-12|
|Femto (f)|1 Quadrillionth|10^-15|
|Atto (a)|1 Quintillionth|10^-18|
|Zepto (z)|1 Sextillionth|10^-21|
|Yocto (y)|1 Septillionth|10^-24|
 - Millisecond = 1 thousandth of a second
    
    - Hard disk drive access times are often 10 to 20 milliseconds
- Nanosecond = 1 billionth of a second
    
    - Main memory access times are often 50 to 70 nanoseconds
- Micron (micrometer) = 1 millionth of a meter
    
    - Circuits on computer chips are measured in microns
   

- We note that cycle time is the reciprocal of clock frequency
- A bus operating at 133 MHz has a cycle time of 7.52 nanoseconds
    
    - 133,000,000 cycles/second = 7.52 ns/cycle
 
- COmputers with large main memory capacity can run larger programs with greater speed than computers having small memories.
- RAM is an acronym for Random Access Memory. Random access means that memory contents can be accessed directly if you know its location
- Cache is a type of temporary memory that can be accessed faster than RAM
 
- Serial ports send data as a series of pulses along one or two data lines.
- Parallel ports send data as a single pulse along at least 8 data lines.
- USB, Universal Serial Bus, is an intelligent serial interface that is self-configuring. (It supports "plug and play.")
 
- Throughout the remainder of the book you will see how these components work and how they interace with software to make complete computer systems.
- This statement raises two important questions:
    
    - What assurance do we have that computer components will operate as we expect?
    - What assurance do we have that computer components will operate together?
 
FLOAP  
Floating Arithmetic operation
 
1.5 Historical Development

- Moore's Law (1965)
    
    - Gordon Moore, Intel Founder
    - "The density of transistors in an integrated circuit will double every year."
- Contemporary version:
    
    - "The density of silicon chips doubles every 18 months."
- But this law cannot hold forever... - Rock's Law
    
    - Arthur Rock, Intel financier
    - "The cost of capital equipment to build semiconductors will double every 4 years."
    - In 1968, a new chip plant cost about $12,000
    - At the time, $12,000 would buy a nice home in the suburbs
    - An executive earning $12,000/yr was "making a very comfortable living."
    
    - In 2012, a chip plants under construction cost well over $5 billion
        
        - This is more than the GDP of some small countries like Barbados, Mauritania, and Rwanda
    - For Moore's Law to hold, Rock's Law must fall, or vice versa.. But no one can say which will give out first.     
EXERCISE 1, QUESTION 5  
LOOK AT ONLINE COMPUTER AD, THEN FIND SPECS AND COST
 
1.6 The Computer Level Hierarchy

- Computers consist of many things besides chips.
- Before a computer can do anything worthwhile, it must also use software.
- Writing complex programs requires a "divide and conquer" approach, where each program module solves a smaller problem.
- Complex computer systems employ a similar technique through a series of virtual machine layers.
 
- Each virtual machine layer is an abstraction of the level below it.
- The machines at each level execute their own particular instructions, calling upon machines at lower levels to perform tasks as required.
- Computer circuits ultimately carry out the work.

|   |   |   |
|---|---|---|
|Level 6: The User Level|- Program execution and user interface level<br>- The level with which we are most familiar||
|Level 5: High-Level Language Level|- The level with which we interact when we write programs in languages such as C, Pascal, Lisp, and Java||
|Level 4: Assembly Language Level|- Acts upon assembly language produced from Level 5, as well as instructions programmed directly at this level||
|Level 3: System Software Level|- Controls executing processes on the system<br>- Protects system resources<br>- Assembly language instructions often pass thru Level 3 without modification||
|Level 2: Machine Level|- Also known as the instruction Set Architecture (ISA) Level<br>- Consists of instructions that are particular to the architecture of the machine<br>- Programs written in machine language need no compilers, interpreters, or assemblers||
|Level 1: Control Level|- A control unit decodes and executes instructions and moves data through the system<br>- Control units can be microprogrammed or hardwired<br>- A microprogram is a program written in a low-level language that is implemented by the hardware<br>- Hardwired control units consist of hardware that directly executes machine instructions||
|Level 0: Digital Logic Level|- This level is where we find digital circuits (the chips).<br>- Digital circuits consist of gates and wires.<br>- These components implement the mathematical logic of all other levels.||
 
1. Write down the program in high level language
2. Send this program to the compiler/interpreter
3. Compiler generates object codes (in assembly)
4. Object codes go to the assembler
5. Assembler generates machine codes
6. Run machine codes in Operating System
7. Output!
 
- These translations are made with compiler, assembler, and execution (with the control unit) respectively
 
- Fetch Cycle
- Decode Cycle
- Execution Cycle
 
This class begins discussion at objects codes and assembly
 
We will use a super super simplified sample computer architecture in this class
 
Assembly only has 15 operations  
Load, Store, Add, Subtract, etc
     
Suppose you have a problem you want to solve with a computer
 
High Level Language -> Assembly -> Machine Code -> Output
 
Steps to execute 1 Machine Instruction
         

1.7 Cloud Computing: Computing as a Service

- The ultimate aim of every computer system is to deliver functionality to its users
- Computer users typically do not care about terabytes of storage and gigahertz of processor speed
- Many companies outsource their data centers to 3rd party specialists, who agree to provide computing services for a fee
- These arrangements are managed through service-level agreements (SLAs)
 
- Rather than pay a 3rd party to run a company-owned data center, another approach is to buy computing services from someone else's data center and connect to it via the Internet
- This is the idea behind a collection of service models known as Cloud computing
- The "Cloud" is a visual metaphor traditionally used for the Internet. It is even more apt for service-defined computing. - More Cloud computing models
    
    - Software as a Service, or SaaS. The consumer of this service buy application services
        
        - Well-known examples include Gmail, Dropbox, GoToMeeting, and Nettflix
    - Platform as a Service, or PaaS. Provides server hardware, operating systems, database services, security components, and backup and recovery services.
        
        - Well known PaaS providers include Google App Engine and Microsoft Windows Azure Cloud Services.
- The general term, Cloud computing, consists of several models:
    
    - Infrastructure as a Service (IaaS) provides only server hardware, secure network access to the servers, and baackup and reovery services. The customer is responsible for all system software including the OS and databases.
        
        - Well-known IaaS platforms include Amazon EC2, Google Compute Engine, Microsoft Azure Services Platform, Rackspace, and HP Cloud