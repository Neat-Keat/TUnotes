Building Java Programs Chapter 6  
File Processing
 
PrintStream: an object in the java.io package that lets you print output to a destination such as a file

- Any methods you have used on System.out (such as print, println) will work on a PrintStream

- Syntax: 
PrintStream **name** = new PrintStream(new File("**file name**"));   Example:  
PrintStream output = new PrintStream(new File("out.txt"));  
output.println("Hello, file!");  
output.println("This is a second line of output.");
 
-------------------------------------------------------------------------------------------------------------------------------
 
- if the given file DNE, it's created
- if the given file exists, its overwritten

- The output you print appears in a file, not on the console

You'll have to open the file with an editor to see it
 - DO NOT open the same for both reading (Scanner) and writing (PrintStream) at the same time
    
    - you will overwrite your input file with an empty file (0 bytes)
 ![— A reference to it can be stored in a printstream variable. • Printing to that variable causes console output to appear. — You can pass System. out to a method as a printStream. • Allows a method to send output to the console or a file. ](Exported%20image%2020240525204027-0.png)

------------------------------------------------------------------------------------------------------------------------------
   

**// Processes an employee input file and outputs each employee's hours.**  
import java.io.*; **// for File**  
import java.util.*; **// for Scanner**
 
public class Hours2 {  
public static void main(String[] args) throws FileNotFoundException {  
Scanner input = new Scanner(new File("hours.txt"));  
**PrintStream out = new PrintStream(new File("hours_out.txt"));**  
while (input.hasNextLine()) {  
String line = input.nextLine();  
Scanner lineScan = new Scanner(line);  
int id = lineScan.nextInt(); **// e.g. 456**  
String name = lineScan.next(); **// e.g. "Eric"**  
double sum = 0.0;  
int count = 0;  
while (lineScan.hasNextDouble()) {  
sum = sum + lineScan.nextDouble();  
count++;  
}
 
double average = sum / count;  
**out.println**(name + " (ID#" + id + ") worked " +  
sum + " hours (" + average + " hours/day)");  
}  
}  
}  
----------------------------------------------------------------------------

- we can ask the user to tell us the file to read
    
    - the filename might have spaces; use nextLine(), not next()

**// prompt for input file name**  
Scanner console = new Scanner(System.in);  
**System.out.print("Type a file name to use: ");**  
**String filename = console.nextLine();**  
Scanner input = new Scanner(new File(**filename**));
 - Files have an exists method to test for file-not-found: 
File file = new File("hours.txt");
 
**if (!file.exists()) {**  
**// try a second input file as a backup**  
System.out.print("hours file not found!");  
file = new File("hours2.txt");  
**}**  
------------------------------------------------------------------------------------------------------------------------------------------------------  
Mixing tokens and lines

- using nextLine in conjunction with the token-based methods on the same Scanner can cause bad results 
23 3.14  
Joe "Hello" world  
45.2 19  
￼

- You'd think you could read 23 and 3.14 with nextInt and nextDouble, then read Joe "Hello" world with nextLine . 
System.out.println(input.nextInt()); **// 23**  
System.out.println(input.nextDouble()); **// 3.14**  
System.out.println(input.nextLine()); **//**  
Scanner console = new Scanner(System.in);  
System.out.print("Enter your age: ");  
int age = **console.nextInt()**;
 
System.out.print("Now enter your name: ");  
String name = **console.nextLine()**;  
System.out.println(name + " is " + age + " years old.");
 
Log of execution (user input underlined):
 
Enter your age: **12**  
Now enter your name: **Sideshow Bob**  
is 12 years old.
 - Why?
- Overall input: 12\nSideshow Bob
- After nextInt(): **12**\nSideshow Bob  
    **^**
- After nextLine(): 12\nSideshow Bob  
    **^** 
STRING METHODS

|   |   |
|---|---|
|**Method**|**Description**|
|equals(**str**)|whether two strings contain the same characters|
|equalsIgnoreCase(**str**)|whether two strings contain the same characters, ignoring upper vs. lower case|
|startsWith(**str**)|whether one contains other's characters at start|
|endsWith(**str**)|whether one contains other's characters at end|
|contains(**str**)|whether the given string is found within this one|

**-----------------------------------------------------------------------------**
 
**HOW TO APPEND TO THE END OF A FILE:**
 
import java.io.*;  
public class AppendToFile {  
}
        
PrintStream name = new PrintStream(new File("file name"));
    
The console output object, System.out, is a PrintStream  
PrintStream out1 = System.out;  
PrintStream out2 = newPrintStream(new File("data.txt"));  
out1.println("Hello, console!"); //goes to console  
out2.println("hello, file!"); //goes to file
 
Modify Hours program to use a PrintStream to send output to the file hours_out.txt  
the program produces no console output  
the file hours_out.txt will be created with the text:  
Kim (ID#123) worked 31.4 hours (7.85 hours/day)  
Eric (ID#456) worked 36.8 hours (7.36 hours/day)  
Stef (ID#789) worked 39.5 hours (7.9 hours/day)
      

Prompting for a file name
       
￼But the nextLine call produces no output! Why?  
nextLine() consumes the \n token at the end of the first line, without reading line 2.
             
public static void main( String[] args ) throws FileNotFoundException {  
PrintStream out = new PrintStream(new FileOutputStream("keeper.txt", true));  
out.println("this is my first entry");  
out.println("this is my second entry");  
out.close();  
}