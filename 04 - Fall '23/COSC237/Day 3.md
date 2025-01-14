Quiz is MC & T/F, ~20 min long  
Done at the start of lab
 
5 more practicums, #5 is essentially a programming assignment but with most of the structure given to you
 
OOP starts next Tuesday
 
you can use enhanced for loops (for(int i : exam1_grades) on arraylists!
 
C++ is both procedural and object oriented  
Python is procedural, object oriented, and hybrid  
Java is strictly object oriented  
for every primitive data type, there is a corresponding object class
 
-------------------------------------------------------------------------------------------------------------------------------
 
Java Review (continued)
 
the default case of a case statement is similar to the final else statement of a giant if/else block  
the main difference between case and if/else is that if/else can handle more than 1 variable
 
while is pre-test  
do-while is post-test
 
for loops can always be written as a while loop
 
ASSIGNMENT OPERATORS  
x = y  
x = y = z (right associative)  
x += y -> x = x + y
 
most operators go left-to-right  
some (like assignment) go right-to-left  
assignments are also expressions lol
 
STANDARD INPUT  
Scanner input = new Scanner(System.in);

- System.in is a predefined object in Java
- Scanner is a wrapper class
    
    - eg., num = input.nextInt(); - White space as delimiter
- will generate an error (exception) if a non-digit found
- can change delimiter to something else (ex. a comma)
    
API = Application Programming Interface  
java.lang is a special package that automatically gets imported  
it defines things like the string class and other basic things
 
the include statement tells a program where to look for things if its not found, which is how adding unused packages does NOT slow down anything  
"ERROR: symbol not found" refers to when Java CANT find a user-defined class, like fractions!
 
STANDARD OUTPUT  
System.out is a predefined object in Java  
ex  
System.out.printf("%.2f inches in %d centimeters.", centimeters / 2.54, centimeters);
 
%.2f and %d are called format specifiers. Consider them placeholders for variables defined after the quotation marks  
See ch3 for more details
 
System.out will only ever print out 1 string
 
if you want to print out characters with special meaning, like %, use "/" as an escape character, ex. "/%"
 
ARRAYS IN JAVA  
Arrays are objects in Java.  
int nums[]; - declares a variable of type int[]
 
can declare an array of any type:  
float[] nums;  
String[] names;  
etc.
 
to actually have an array, must allocate memory that the array variable will reference. This is done by use of the "new" operator:  
int[] nums;  
nums = new int[100];
 
can declare and allocate array variable at the same time:  
int[] nums = new int[100];
 
although this seems redundant, it is necessary to differentiate between subtypes, discussed later.
 
chars, ints, doubles, etc store a fixed number of bits by definition  
Strings have no fixed max size, which is why they store the memory location for the full object  
same for arrays  
they basically just store a list of pointers to objects