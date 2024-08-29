Building Java Programs Chapter 6  
File Processing
 
Import java.io.*;  
Create a file object to get info about a file on your drive.

- This doesn’t actually create a new file on the hard disk
 
------------------------------------------------------------------------------------------------------------------------------
 
File f = new File("example.txt");  
if (f.exists() && f.length() > 1000) {  
f.delete();  
}
 
----------------------------------------

|   |   |
|---|---|
|Method name|description|
|canRead()||
|delete()||
|exists()||
|getName()||
|length()||
|renameTo(file)||
 
- To read a file, pass a File when constructing a Scanner.
    
    - Scanner name = new Scanner(new File("file name"));
 
Ex:

- File file = new File("mydata.txt");

Scanner input = new Scanner(file);
 
Or
   

- Scanner input = new Scanner(new File("mydata.txt"));
   

Absolute Path  
C:/Documents/Smith/hw6/input/data.csv
 
Relative path  
Names.dat  
Input/kinglear.txt
 
Assumed to be relative to the current directory
   
![Compiler error w/ files import java.io.*; import java.util.*• // for File // for Scanner public class ReadFile { public static void main(String[] args) { Scanner input = new Scanner (new File( "data. txt ; String text = input . next(); System . out . print text) ; • The program fails to compile with the following error: ReadFile.java:6: unreported exception j ava. io . FileNotFoundException; must be caught or declared to be thrown Scanner input = new Scanner(new txt")); ](Exported%20image%2020240525204026-0.png)   
Exceptions:  
An object representing a runtime error

- Dividing an integer by 0
- Calling substring on a String and passing too large an indes
- Trying to read the wrong type of value from a Scanner
- Trying to read a file that does not exist
  - We say that a program with an error "throws" an exception
- It is also possible to "catch" (handle or fix) an exception
 
- Checked exception: an error that must be handled by our program (otherwise it will not compile
 
The throws clause

- Throws clause: Keywords on a method's header that state that it may generate an exception ( and will not handle it).
- Syntax:
    
    - public static type name(params) throws type{

![— Example: public class ReadFile { public static void main(String[] args) throws FileN0tFoundException { — Like saying, "/ hereby announce that this method might throw an exception, and / accept the consequences if this ](Exported%20image%2020240525204026-1.png)  

Input Tokens

- Token: a unit of user input, separated by whitespace.
    
    - A scanner splits a file's contents into tokens

![• If an input file contains the following: 23 3.14 "John smith" The scanner can interpret the tokens as the following types: Token Type(s) int, double, String 23 3.14 double, String " John String smith" String ](Exported%20image%2020240525204026-2.png)  

Files and input cursor

![• Consider a file weather . txt that contains this text: 6.2 23.5 19.1 7.4 22.8 8.5 -1.8 14.9 • A scanner views all input as a stream of characters: 23.5\n19.1 7.4 -1.8 14.9\n 16.2 • input cursor: The current position of the scanner. ](Exported%20image%2020240525204026-3.png)

Consuming input: reading input and advancing the cursor

![cursor. — Calling next Int etc. moves the cursor past the current // "23 5 token. double d = 6.2 String s = 6.2 input . nextDoub1e() ; 23. 5\n19.1 7.4 input . next(); 23.5\n19.1 7.4 // 16.2 -1.8 14.9\n -1.8 14.9\n ](Exported%20image%2020240525204026-4.png)

Recall weather.txt  
Write a program that prints the change in temperature between each pair of neighboring days  
-------------------------------------------------------------------------------------------------------------------------------
 
// Displays changes in temperature from data in an input file.   import java.io.*; // for File  
import java.util.*; // for Scanner   public class Temperatures {  
public static void main(String[] args)  
throws FileNotFoundException {  
Scanner input = new Scanner(new File("weather.txt"));  
double prev = input.nextDouble(); // fencepost  
for (int i = 1; i <= 7; i++) {  
double next = input.nextDouble();  
System.out.println(prev + " to " + next +  
", change = " + (next - prev));  
prev = next;  
}  
}  
}  
---------------------------------------------------------------------------------------------------------------------------
 
Reading an entire file

- Suppose we want our program to work no matter how many numbers are in the file
    
    - Currently, if the file has more numbers, they will not be read
    - If the file has fewer numbers, you get a NoSuchElement Exception error

![• NosuchElementException — You read past the end of the input. • InputMismatchException — You read the wrong type of token (e.g. read "hi" as an int). ](Exported%20image%2020240525204026-5.png)   
Scanner tests for valid input

|   |   |
|---|---|
|Method|Description|
|hasNext()|Returns true if there is a next token|
|hasNextInt()|Returns true if there is a next token  <br>That can be read as an int|
|hasNextDouble()|Returns true if there is a next token  <br>That can be read as a double|
 These do not consume input, and can be used to avoid crashes
 
Avoiding type mismatches:  
------------------------------------------------------------------------------------------------------------------------------   Scanner console = new Scanner(System.in);  
System.out.print("How old are you? ");  
if (console.hasNextInt()) {  
int age = console.nextInt(); // will not crash!  
System.out.println("Wow, " + age + " is old!");  
} else {  
System.out.println("You didn't type an integer.");  
}   Avoiding reading past the end of a file:   Scanner input = new Scanner(new File("example.txt"));  
if (input.hasNext()) {  
String token = input.next(); // will not crash!  
System.out.println("next token is " + token);  
}
 
------------------------------------------------------------------------------------------------------------------------------  
Modifying our earlier weather program, we get:
 
// Displays changes in temperature from data in an input file.   import java.io.*; // for File  
import java.util.*; // for Scanner   public class Temperatures {  
public static void main(String[] args)  
throws FileNotFoundException {  
Scanner input = new Scanner(new File("weather.txt"));  
double prev = input.nextDouble(); // fencepost  
while (input.hasNextDouble()) {  
double next = input.nextDouble();  
System.out.println(prev + " to " + next +  
", change = " + (next - prev));  
prev = next;  
}  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------

![File input question 3 • Modify the temperature program to handle files that contain non-numeric tokens (by skipping them). • For example, it should produce the same output as before when given this input file, weather2. txt: 16.2 23.5 Tuesday 19.1 18.5 -1.8 14.9 . wed 7 .4 THURS. TEMP: 22.8 Marty here is my data! - -Kim — You may assume that the file begins with a real number. ](Exported%20image%2020240525204026-6.png)  

// Displays changes in temperature from data in an input file.   import java.io.*; // for File  
import java.util.*; // for Scanner   public class Temperatures2 {  
public static void main(String[] args)  
throws FileNotFoundException {  
Scanner input = new Scanner(new File("weather.txt"));  
double prev = input.nextDouble(); // fencepost  
while (input.hasNext()) {  
if (input.hasNextDouble()) {  
double next = input.nextDouble();  
System.out.println(prev + " to " + next +  
", change = " + (next - prev));  
prev = next;  
} else {  
input.next(); // throw away unwanted token  
}  
}  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------
 ![Election question • Write a program that reads a file of poll data. — Format: State Obama% McCain% Po//ster CT 56 31 7 oct U. of connecticut NE 37 56 5 sep Rasmussen AZ 41 49 oct Northern Arizona U. • The program should print how many electoral votes each candidate leads in, and who is leading overall in the polls. Obama . Mccain : 214 votes 257 votes ](Exported%20image%2020240525204026-7.png)  

// Computes leader in presidential polls, based on input file such as:  
// AK 42 53 3 Oct Ivan Moore Research   import java.io.*; // for File  
import java.util.*; // for Scanner   public class Election {  
public static void main(String[] args) throws FileNotFoundException {  
Scanner input = new Scanner(new File("polls.txt"));  
int obamaVotes = 0, mccainVotes = 0;   while (input.hasNext()) {  
if (input.hasNextInt()) {  
int obama = input.nextInt();  
int mccain = input.nextInt();  
int eVotes = input.nextInt();  
if (obama > mccain) {  
obamaVotes = obamaVotes + eVotes;  
} else if (mccain > obama) {  
mccainVotes = mccainVotes + eVotes;  
}  
} else {  
input.next(); // skip non-integer token  
}  
}   System.out.println("Obama : " + obamaVotes + " votes");  
System.out.println("McCain: " + mccainVotes + " votes");  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------
 ![Hours question • Given a file hours . txt with the following contents: 123 Kim 12.5 8.1 7.6 3.2 456 Eric 4. @ 11.6 6.5 2.7 12 789 Stef 8. @ 8. @ 8.0 8.0 7.5 — Consider the task of computing hours worked by each person: Kim (ID#123) worked 31.4 hours (7.85 hours/ day) Eric (ID#456) worked 36.8 hours (7.36 hours/day) Stef (ID#789) worked 39.5 hours (7.9 hours/ day) • Let's try to solve this problem token-by-token . ](Exported%20image%2020240525204026-8.png)

Token-by-token does not work  
Break input into lines  
Break lines into tokens
 
|   |   |
|---|---|
|Method|description|
|nextLine()|Returns next entire nile of input (from cursor to \n)|
|hasNextLine()|returns true if there are any more lines of input to read (always true for console input)|
 
Scanner input = new Scanner(new File("file name"));  
while (input.hasNextLine()) {  
String line = input.nextLine();  
process this line;  
}  
-------------------------------------------------------------------------------------------------------------------------------

![Scanners on Strings • A scanner can tokenize the contents of a string: scanner name = new scanner (String); string text = "15 3.2 hello — Example: scanner scan = 9 new scanner (text); int num = scan. nextlnt(); system . out. pr int In (num); doub le — scan . nextDouble(); num2 — system . out . pr int In (num2) ; String word = scan . next(); system . out . pr int In (word) ; 27 . 5"; // 15 // 3.2 // hello ](Exported%20image%2020240525204026-9.png)     
![Input file input. The quick brown the lazy dog. txt: fox J umps over Output to console: Line has 6 words Line has 3 words ](Exported%20image%2020240525204026-10.png)
 // Counts the words on each line of a file  
Scanner input = new Scanner(new File("input.txt"));  
while (input.hasNextLine()) {  
String line = input.nextLine();  
Scanner lineScan = new Scanner(line);   // process the contents of this line  
int count = 0;  
while (lineScan.hasNext()) {  
String word = lineScan.next();  
count++;  
}  
System.out.println("Line has " + count + " words");  
}  
-------------------------------------------------------------------------------------------------------------------------------  
HOURS PROBLEM CORRECTED
 
// Processes an employee input file and outputs each employee's hours.  
import java.io.*; // for File  
import java.util.*; // for Scanner   public class Hours {  
public static void main(String[] args) throws FileNotFoundException {  
Scanner input = new Scanner(new File("hours.txt"));  
while (input.hasNextLine()) {  
String line = input.nextLine();  
Scanner lineScan = new Scanner(line);  
int id = lineScan.nextInt(); // e.g. 456  
String name = lineScan.next(); // e.g. "Eric"  
double sum = 0.0;  
int count = 0;  
while (lineScan.hasNextDouble()) {  
sum = sum + lineScan.nextDouble();  
count++;  
}   double average = sum / count;  
System.out.println(name + " (ID#" + id + ") worked " +  
sum + " hours (" + average + " hours/day)");  
}  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------  
FILE OUTPUT ON WEDNESDAY