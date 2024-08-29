Don’t cheat lol  
Theres mock tests  
40% HW/labs/etc  
20% exam1  
20% exam2  
20% final
    
**What is computer science?**

- The study of theoretical foundations of info and computation and their implementation and application in computer systems
- Many subfields
    
    - Graphics, computer vision
    - AI
    - Scientific computing
    - Robotics
    - Databases, data mining
    - Computational linguistics, natural lang processing  
110,000 to start w/ a bachelors apparently
 
- Program: a set of instructions carried out by a computer
- Program execution: the act of carrying out the instructions in a program
 
Programming languages  
FORTRAN  
COBOL  
LISP  
BASIC  
Assembler
 
Modern langs  
PROCEDURAL  
Pascal - for education  
C - low level OS and drivers  
FUNCTIONAL  
Lisp/ Scheme, ML, Haskell  
Object Oriented  
Smalltalk - 1st major OOL  
C++ -win10  
Java
 
JAVA  
SOURCE CODE -> compile -> BYTE CODE -> run (in a VM!) -> OUTPUT
 
C++  
SOURCE CODE -> compile -> link w/ OS libraries -> run (in the OS!) -> OUTPUT
   

Public class Hello {  
Public static void main(String[] args) {  
System.out.println("Hello, world!");  
System.out.println();  
System.out.println("This program produces");  
System.out.println("four lines of output");  
}  
}
 
Structure of a Java Program
 
Public class **name** { //class: a program  
Public static void **main**(String[] args) {  
**Statement;**  
**Statement;**  
**Statement;**  
}  
}
 
Naming convention is to capitalize each word of a program (public class GangstaRap)  
FILE NAME MUST MATCH EXACTLY (GangstaRap.java) CAPS SENSITIVE
 
Identifier: a name given to an item in your program.

- Must start with a letter or _ or $
- _ for OS method
- $ for file system methods
- Capital for class
- ALL CAPS for constant  
FOLLOW THESE OR POINTS OFF  
Illegal examples:  
Me+u, 49ers, side-swipe, Ph.D's
 
KEYWORDS: cant be used for identifiers  
Abstract, boolean, break, byte, case, catch, char, class, etc.
 
Syntax: set of legal structures and commands that can be used in a particular lang

- Every basic Jaca statement ends w/ a semicolon ;
- The contents of a class or method occur between { and }
 
Syntax error (compiler error): a problem in the structure of a program that causes the compiler to fail.

- Missing semicolon
- Too many/few {} braces
- Illegal identifier for class name
- Class and file names don’t match
- …
 
WHEN DEBUGGING:  
FIX THE TOP FIRST, THEN WORK DOWN
 
Strings: a sequence of characters to be printed.

- Starts and ends with a " quote " character.
- The quotes font appear in the output.
- Are a class in java, it creates an object that stores the string, unlike c++ (methods can be used on strings here)
- CAPITALIZE String, not string
 
You cannot define a string with a linebreak  
"this is not  
A legal string when defining"
 
Can use \n as an escape character to have linebreaks in output  
Cant have double quotes  
"this is "also" not a legal string"
 
\t tab character  
\n new line character  
\" quotation mark character  
\\ backslash character
 
System.out.println("/ \\ // \\\\ /// \\\\\\")  
/ \ // \\ /// \\\
 
2 types of comments

- Single line
- Multi line  
Not executed when program runs  
Ignored by C++ compiler, but included w/ Java compile (why?)
 
// comment on one line  
/* comment text, may span multiple lines */
 
USE COMMENTS:

- At the top of each file (a "comment header")
- At the start of every method (seen later)
- To explain complex pieces of code
 
USEFUL FOR:

- Understanding larger, more complex programs.
- Multiple programmers working together

￼WELL WRITTEN CODE IS SELF DOCUMENTED
 
STATIC METHODS

- Static method: a named group of statements.
    
    - Defines the structure of a program
    - Eliminates redundancy by code reuse
 
- Procedural decomposition:
    
    - Dividing a problem into methods
 
USING STATIC METHODS

1. Design the algorithm
    
    1. Look at the structure, and which commands are repeated.
    2. Decide what are the important overall tasks
2. Call
3. …
 
DECLARING A METHOD

- Syntax

Public static void **name()** {  
**Statement;**  
**Statement;**  
**Statement;**  
}
 
CALLING A METHOD  
Syntax  
Name();
 
METHODS CAN CALL METHODS
 
Execution jumps to a method when called, then jumps back when done
 
- Place statements into a static method if:

Statements are related structurally, and/or  
Statements are repeated (TO CAPTURE REDUNDANCY!!!)
 - DO NOT MAKE METHODS FOR:

Anything small lol
    

USE LIBRARIES TO REUSE ALGORITHMS AND METHODS