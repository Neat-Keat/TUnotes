Ch1 slides ctd
 
1.7 Cloud Computing: Computing as a service

- The ultimate aim of every computer system is to deliver functionality to its users
- Computer users typically do not care about terabytes of storage and gigahertz of processor speed.
- Many companies outsource their data centers to third-party specialists, who agree to provide computing services for a fee
- These arrangements are managed through service-level agreements (SLAs)
 
- Rather than pay a 3rd party to run a company-owned data center, another approach is to buy computing services from someone else's data center and connect to it via the internet.
- This is the idea behind a collection of service models known as Cloud computing
- The "Cloud" is a visual metaphor traditionally used for the Internet. It is even more apt for service-defined computing
 
- Software as a service (SaaS)
    
    - The consumer of this service buy application services
        
        - Includes Gmail, Dropbox, GoToMeeting, and Netflix
- Platform as a service, (PaaS)
    
    - Provides server hardware, operating systems, database services, security components, and backup and recovery services
        
        - Include Google App Engine, Microsoft Windows Azure Cloud Services
- Infrastructure as a Service (IaaS)
    
    - Provides only server hardware, secure network access to the servers, and backup and recovery services.
    - The customer is responsible for all system software including the operating system and databases.
        
        - Includes Amazon EC2, Google Compute Engine, Microsoft Azure Services Platform, Rackspace, and HP Cloud
    - Cloud storage is a limited type of IaaS that includes services such as Dropbox, Google Drive, and Amazon.com's Cloud Drive - Cloud computing relies on the concept of elasticity, where resources can be added and removed as needed.
- You pay only for what you use
- Virtualization is an enabler of elasticity.
    
    - Instead of having a physical machine, you have a "logical" machine that may span several physical machines, or occupy only part of a single physical machine.
- Potential issues: Privacy, security, having someone else in control of software and hardware you use
   

1.9 The von Neumann Model

- On the ENIAC, all programming was done at the digital logic level.
- Programming the computer involved moving plugs and wires
- A different hardware configuration was needed to solve every unique problem type.
    
    - Configuring the ENIAC to solve a "simple" problem required many days labor by skilled technicians.
      
    
- Inventors of the ENIAC, John Mauchley and J. Presper Eckert, conceived of a computer that could store instructions in memory. The invention of this idea has since been ascribed to a mathematician, John von Neumann, who was a contemporary of Mauchley and Eckert.
- Stored-program computers have become known as von Neumann Architecture Systems. - Today's stored program computers have the following characteristics:
    
    - 3 hardware systems:
        
        - A CPU
        - A main memory system
        - An I/O system
    - The capacity to carry out sequential instruction processing
    - A single data path between the CPU and main memory
        
        - This single path is known as the von Neumann bottleneck - These computers employ a fetch-decode-execute cycle to run programs as follows
    
    - The control unit fetches the next instruction from memory using the program counter to determine where the instruction is located
    - The instruction is decoded into a language that the Arithmetic Logic Unit (ALU) can understand
    - Any data operands required to execute the instruction are fetched from memory and placed into registers
    - The ALU executes the instruction and places results in registers or memory
      

1.10 Non-von Neumann Models

- Convential stored program computers have undergone many incremental improvements over the years.
- These improvements include adding specialized buses, floating point units, and cache memories, to name only a few.
- But enormous improvements in computational power require departure from the classic von Neumann architecture
- Adding processors is one approach
 
- Some of today's systems have separate buses for data and instructions
    
    - Called a Harvard architecture
- Other non-con Neumann systems provide special-purpose processors to offload work from the main CPU
- More radical departures include dataflow computing, quantum computing, cellular automata, and parallel computing
 
1.11 Parallel Computing

- In the late 1960's, high performance computer systems were equipped with dual processors to increase computational throughput.
- In the 1970s, supercomputer systems were introduced with 32 processors
- Supercomputers with 1,000 processors were built in the 1980s
- In 1999, IBM announced its Blue Gene system containing over 1 mil processors
 
- Parallel processing allows a computer to simultaneously work on subparts of a problem
- Multicore processors have 2+ processor cores sharing a single die
- Each core has its own ALU and set of registers, but all processors share memory and other resources
- "Dual core" differs from "dual processor"
    
    - Dual-processor machines, for example, have 2 processors, but each processor plugs into the motherboard separately
 
- Multi-core systems provide the ability to multitask (eg browse the web while burning a CD)
- Multithreaded applications spread mini-processes, threads, across one or more processors for increased throughput
- New programming languages are necessary to fully exploit multiprocessor power  
Conclusion

- This chapter has given you an overview of the subject of computer architecture
- You should now be sufficiently familiar with general system structure to guide your studies throughout the remainder of this course
- Subsequent chapters will explore many of these topics in great detail.
 
CHAPTER 2: DATA REPRESENTATION IN COMPUTER SYSTEMS
 
Objectives

- Understand the fundamentals of numerical data representation and manipulation in digital computers
- Master the skill of converting between various radix systems
- Understand how errors can occur in computations because of overflow and truncation - Understand the fundamental concepts of floating point representation
- Gain familiarity with the most popular character codes
- Understand the concepts of error detecting and correcting codes
   

2.1 Introduction

- A bit is the most basic unit of information in a computer
    
    - It is a state of on or off in a digital circuit
    - Sometimes these states are high or low voltage instead of on or off
- A byte is a group of eight bits
    
    - A byte is the smallest possible addressable unit of computer storage
    - The term, addressable, means that a particular byte can be retrieved according to its location in memory
- A word is a contiguous group of bytes
    
    - Words can be any number of bits or bytes
    - Word sizes of 16, 32, or 64 bits are most common
    - In a word-addressable system, a word is the smallest addressable unit of storage
- A group of 4 bits is called a nibble
    
    - Bytes, therefore, consist of 2 nibbles, a high order nibble and a low order nibble
 
2.2 Positional Numbering Systems

- Weighted Numbering Systems
- Increasing powers of a radix (base)
- A set of valid numeral = radix of the number system
    
    - Ex a decimal system (r=10) = {0, 1, 2, 3, 4, 5 ,6, 7, 8, 9}
    - Ex a hexadecimal system (r=16) = {0, 1, 2 ,…, c, d, e, f}
- General form of a base-r (radix-r) number ![blb2b3... bn where ai ranges in value from O to (r-l) Ex) 243.5210 4x 101+ 3x 5x 2x ](Exported%20image%2020240525213126-0.png)  
- Bytes store numbers using the position of each bit to represent a power of 2
    
    - The binary system is also called base 2
    - Decimal is base 10, it uses powers of 10 for each position in a number
    - Any integer quantity can be represented exactly using any base (or radix) - The decimal 947 in powers of 10 is 9*100 + 40 * 10 + 7*1
- The decimal 5836.47 in powers of 10 is 5*1000 + 8*100 + 3*10 + 6*1 + 4*.1 + 7*.01
      

The binary number 11001 in powers of 2 is 1*16 + 1*8 + 1*1 = 25
 
- When the radix of a number is something other than 10, the base is denoted by a subscript
    
    - Sometimes, the subscript 10 is added for emphasis
 
2.3 Converting Between Bases

- Because binary numbers are the basis for all data representation in digital computer systems, it is important that you become proficient with this radix system
- Your knowledge of the binary numbering system will enable you to understand the operation of all computer components as well as the design of instruction set architectures
 
- Radix conversion
    
    - Successive division/multiplication by base-r (radix-r)
        
        - Decimal -> Binary, Octal, Hexadecimal
    - Bit grouping/expanding
    - Positional conversion
 ![Base-IO (Decimal number) Base-2 (Binary Number) Base-16 (Hexadecimal Number) Sucessive division/multiplication_ : positional conversion : Bit grouping/expanding Base-8 (Octal Number) ](Exported%20image%2020240525213126-1.png)  

- This method is mechanical and easy
- It employs the idea that successive division by a base is equivalent to successive subtraction by powers of the base
- Let's use the division remainder method to again convert 190 in decimal to base 3
    
    - First we take the number that we wish to convert and divide it by the radix in which we want to express our result
    - In this case 3 divides 190 63 times with a remainder of 1
    - Record the quotient and the remainder
    - 63 is evenly divisible by 3
    - Our remainder is 0, and the quotient is 21
    - Continue in this way until the quotient is 0
    - In the final calculation, we note that 3 divides 2 0 times with a remainder of 2
    - Our result, reading from bottom to top is: 21001
    - ![3 190 3 63 3 21 3 12 3 2 0 1 0 0 1 2 ](Exported%20image%2020240525213126-2.png)
      
    
- Fractional values van be approximated in all base systems
- Unlike integer values, fractions do not necessarily have exact representations under all radices
- The quantity ½ is exactly representable in the binary and decimal systems, but is not in the ternary (base 3) numbering system
   

- Fractional decimal values have nonzero digits to the right of the decimal point.
- Fractional values of other radix systems have nonzero digits to the right of the radix point
- Numerals to the right of a radix point represent negative powers of the radix
- As with whole-number conversions, you can use either of 2 methods: a subtraction method or an easy multiplication method
- The subtraction method for fractions is identical to the subtraction method for whole numbers. Instead of subtracting positive powers of the target radix, we subtract negative powers of the radix.
- We always start with the largest value first. n^-1, where n is our radix, and work our way along using larger negative exponents
- Using the multiplication method to convert the decimal 0.8125 to binary, we multiply the radix by 2
    
    - The 1st product carries into the units place
    - Ignoring the value in the units place at each step, continue multiplying fractional part by the radix
    - You are finished when the product is 0, or you’ve reached the desired # of places
    - Our result, reading from top to bottom, is 0.1101
    - This method also works with any base, just use the target radix as the multiplier
    -   
        
    - ![-8125 1. 6250 . 6250 ı. 2500 . 2500 0 5000 . 5000 1.0000 ](Exported%20image%2020240525213126-3.png)
- Convert a base-r number to decimal number
- Use the definition of positional numbering system
- Ex convert 70.24(8) to the decimal number

70.24(8) = 7*8^1 + 0*8^0 + 2*8^-1 + 4*8^-2  
= 56+0 + 0.25 + 0.0625  
= 56.3125(10)
   

- Ex convert 10011.11(2) to the decimal number

10011.10(2) = 1*2^4 + 1*2^1 + 1*2^0 +1*2^-1  
= 16 + 2 + 1 + 0.5 + 0.25  
= 19.75(10)
 - Convert a binary number(r=2) to octal (r=8) or hexadecimal (r=16) number
    
    - Start at the right of the binary point and at the left of the binary point
    - Pad with 0s as needed
- The binary numbering system is the most important radix system for digital computers
- However, it is difficult to read long strings of binary numbers- and even a modestly-sized decimal number becomes a very ong binary number
    
    - Ex 11010100011011(2) = 13595(10)
- For compactness and ease of reading, binary values are usually expressed using the hexadecimal, or base-16, numbering system
   

- The hexadecimal numbering system uses the numberals 0-9 and the letters A-F
    
    - The decimal number 12 is C(16)
    - The decimal number 26 is 1A(16)
- It is easy to convert between base16 and base 2 because 16 = 2^4
- Thus, to convert from binary to hexadecimal, all we need to do is group the binary digits into groups of 4
- A group of 4 binary digits is called a hextet
 
- Using groups of hextets, the binary number 11010100011011(2) (=13595(10))

0011010100011011 (if the number of bits is not a multiple of 0, pad the left with 0s)  
3 5 1 B
 - Octal is the same idea, but with 3 bit groupings instead of 2

011010100011011  
3 2 4 3 3
   
- Ex) The binary number with binary point 10100011010.1110100111(2) in hexadecimal is 51A.E9C(16)
- And its octal number is 2432.7234(8)
    
![Input Device Central Processing Unit Control Unit Arithmetic / Logic Unit Output Device Registers Memory Unit ](Exported%20image%2020240525213126-4.png)

Von Neumann architecture diagram

X86 architecture has 16 General purpose registers, and a bunch of specific registers
 
L1 and L2 Cache can be thought of as faster parts of total memory, separate from main memory
 
Circuits to handle all relevant arithmetic operations are in the ALU  
The Control Unit does everything else
 
3 cycles – fetch, decode, execute
 
CPUs can be Microprogrammed or hardwired
 
What is a register?  
Current working assumption is that they are just places to store relevant date to be operated on in the execute cycle of the cpu
 
Assembly has 15 commands bc 4 bits in binary is 16! (or something)
 
Floating point computation is much more difficult than integer  
Make special, extra powerful processors to handle these in non von neumann systems!
 
Multiprocessor is like a dinosaur with more than 1 head
 
Image array processors can do computions related strictly to neighboring array processors, allowing for quick processing of image editing, etc
 
Quantum computing doesn’t use 0s and 1s, they read voltage amounts for 1-16 (?)
 
On HW, find out the description of each von neuman architecture using google? ChatGPT? 1 para per architecture
      

Numbers can be unsigned or signed  
How to represent them?  
Unsigned = {integer, floating} <- use math lol  
Signed = {integer, floating}  
Signed integer = {SM, OC, TC, Excess-M}  
Signed floating = {learn later lol}
 
We use the positional numbering system to help interpret
 
What about characters?

35.625(10) to base2?
 
Use 2 methods, 1 for before the decimal and 1 for after  
35 = 100011 by division  
.625 = 101 by multiplication
 
0.625 * 2 = 1.250  
250 * 2 = 0.5  
5 * 2 = 1
 
35.625(10) = 100011.101(2)
   

What about to base 8?
 
35.625(10), change the 2 to 8 when multiplying
   

CONVERSION IS ON THE QUIZ!!!!1!!1!!!!1!11!
    
Convert 1011011.1101(2) to base 10  
1+2+8+16+64 = 27+64 = 91  
½ + ¼ + 1/16 = .75 + 0.0625 = 0.8125
 
91.8125(10)!
   

Using grouping?
 
1011011.1101(2)  
1 3 3 . 6 4 = 133.64(8)
 
1011011.1101(2)  
5 B . D = 5B.D(16)
   

You can do this backwards too!
 
3f.21(16)
 
00111111.00100001
 
Get rid of leading 0s  
111111.00100001(2)
 
Then you can group 3s to get base 8
 
77.102(8)