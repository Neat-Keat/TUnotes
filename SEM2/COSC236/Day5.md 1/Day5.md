**Building Java Programs Chapter 3: Parameters and Objects**
 
Redundant recipes
 
Recipe for baking 20 cookies

- Mix the following ingredients in a bowl:
    
    - 4 cups flour
    - 1 cup butter
    - 1 cup sugar
    - 2 eggs
    - 40 lbs chocolate chips
- Place on sheet and bake for about 10 minutes
 
Recipe for baking N cookies

- Mix the following ingredients in a bowl:
    
    - N/5cups flour
    - N/20 cup butter
    - N/20 cup sugar
    - N/10 eggs
    - N/2 lbs chocolate chips
- Place on sheet and bake for about 10 minutes
 
**Parameter:** a value passed to a method by its caller
 
DECLARE:  
Public static void **name (**type name) {  
**Statement(s);**
 
**PASSING**  
name(expression);
 
Common errors  
chant(); // error: parameter value required  
chant(3.7); //error: must be of type int
 
-------------------------------------------------------------------------------------------------------------------------------  
// Prints several lines of stars.  
// Uses a parameterized method to remove redundancy.  
public class Stars2 {  
public static void main(String[] args) {  
line(13);  
line(7);  
line(35);  
}   // Prints the given number of stars plus a line break.  
public static void line(int count) {  
for (int i = 1; i <= count; i++) {  
System.out.print("*");  
}  
System.out.println();  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------
 
MULTIPLE PARAMETERS
 
- A method can accept multiple parameters ( separate by , )
    
    - When calling, you MUST pass values for each parameter
 
DECLARATION:  
public static void name (type name, ..., type name) {  
statement(s);  
}
 
CALL:  
methodName (value, value, ..., value);  
-------------------------------------------------------------------------------------------------------------------------------
 
public static void main(String[] args) {  
printNumber(4, 9);  
printNumber(17, 6);  
printNumber(8, 0);  
printNumber(0, 8);  
}   public static void printNumber(int number, int count) {  
for (int i = 1; i <= count; i++) {  
System.out.print(number);  
}  
System.out.println();  
}   Output:   444444444  
171717171717   00000000  
-------------------------------------------------------------------------------------------------------------------------------
 
public class Stars3 {  
public static void main(String[] args) {  
line(13);  
line(7);  
line(35);  
System.out.println();  
box(10, 3);  
box(5, 4);  
box(20, 7);  
}   // Prints the given number of stars plus a line break.  
public static void line(int count) {  
for (int i = 1; i <= count; i++) {  
System.out.print("*");  
}  
System.out.println();  
}
   

// Prints a box of stars of the given size.  
public static void box(int width, int height) {  
line(width);   for (int line = 1; line <= height - 2; line++) {  
System.out.print("*");  
for (int space = 1; space <= width - 2; space++) {  
System.out.print(" ");  
}  
System.out.println("*");  
}   line(width);  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------
 
When primitive variables (int, double) are passed as parameters, their values are copied
 
String name = "text";  
String name = expression;
 
- examples:

String name = "Marla Singer";  
int x = 3;  
int y = 5;  
String point = "(" + x + ", " + y + ")";
 
-------------------------------------------------------------------------------------------------------------------------------
 
STRINGS AS PARAMETERS  
public class StringParameters {  
public static void main(String[] args) {  
sayHello("Marty");   String teacher = "Bictolia";  
sayHello(teacher);  
}   public static void sayHello(String name) {  
System.out.println("Welcome, " + name);  
}  
}   Output:   Welcome, Marty  
Welcome, Bictolia
 
-------------------------------------------------------------------------------------------------------------------------------
 
// Prints the given String the given number of times.  
public static void repeat(String s, int times) {  
for (int i = 1; i <= times; i++) {  
System.out.print(s);  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------
 ![Method name Math. abs( value) Math. cei I( value) Math. floor( value) Math. value) Math. max( va/uel, va/ue2) Math. min( va/uel, va/ue2) Math. pow(base, exp) Math. random() Math. round( value) Math. sqrt( value) Math. sin( value) Ma th. cos( value) Math. tan( value) Math. toDegrees( value) Math. toRadians( value) Description absolute value rounds up rounds down logarithm, base 10 larger of two values smaller of two values base to the exp power random double between O and 1 nearest whole number square root sine/cosine/tangentof an angle in radians convert degrees to radians and back Constant Math. E Math. PI Description 2.7182818... 3.1415926... ](Exported%20image%2020240525204019-0.png)

- Return: to send out a value as the result of a method:
    
    - The opposite of a parameter:
        
        - Parameters send info in from the caller to the method
        - Return values send info out from a method to its caller
 
int x = Math.pow(10, 3); // ERROR: incompat. Types
 
double result = 1.0 / 3.0;  
System.out.println(result); // 0.3333333333333
 
System.out.println(0.1 + 0.2);   Instead of 0.3, the output is 0.30000000000000004
   

TYPE CASTING: A conversion from one type to another

- To promote an int into a double to get exact division from /
- To truncate a double from a real number to an integer
 
- SYNTAX
    
    - (type) expression
 
- Examples
    
    - Double result = (double) 19/5; //3.8
    - Int result2 = (int) result; //3
    - Int x = (int) Math.pow(10, 3); //1000
 
- Type casting has high precedence and **only casts the item immediately next to it**
    
    - double x = (double) 1 + 1 / 2; // 1
    - double y = 1 + (double) 1 / 2; // 1.5
- A conversion to double can be achieved by multiplying by 1.0 as well!!  
-------------------------------------------------------------------------------------------------------------------------------
 
RETURNING A VALUE
 
public static type name(parameters) {  
statements;  
...  
return expression;  
}
 
EXAMPLE:
 
// Returns the slope of the line between the given points.  
public static **double slope**(int x1, int y1, int x2, int y2) {  
double dy = y2 - y1;  
double dx = x2 - x1;  
return **dy / dx**;  
}   slope(1, 3, 5, 11) returns 2.0
   

// Converts degrees Fahrenheit to Celsius.  
public static double fToC(double degreesF) {  
double degreesC = 5.0 / 9.0 * (degreesF - 32);  
return degreesC;  
}   // Computes triangle hypotenuse length given its side lengths.  
public static double hypotenuse(int a, int b) {  
double c = Math.sqrt(a * a + b * b);  
return c;  
}     
You can shorten the examples by returning an expression:   public static double fToC(double degreesF) {  
return 5.0 / 9.0 * (degreesF - 32);  
}  
-------------------------------------------------------------------------------------------------------------------------------
 
Many students incorrectly think that a return statement sends a variable's name back to the calling method.   public static void main(String[] args) {  
slope(0, 0, 6, 3);  
System.out.println("The slope is " + result); // ERROR:  
} // result not defined   public static double slope(int x1, int x2, int y1, int y2) {  
double dy = y2 - y1;  
double dx = x2 - x1;  
double result = dy / dx;  
return result;  
}
 
**********************************************************************************************************  
Instead, returning sends the variable's value back.  
The returned value must be stored into a variable or used in an expression to be useful to the caller.   public static void main(String[] args) {  
**double s** = slope(0, 0, 6, 3);  
System.out.println("The slope is " + **s**);  
}   public static double slope(int x1, int x2, int y1, int y2) {  
double dy = y2 - y1;  
double dx = x2 - x1;  
double result = dy / dx;  
return result;  
}
 
-------------------------------------------------------------------------------------------------------------------------------
 
- Class: A program entity that represents either:
    
    - A program/module, or
    - A type of objects
- A class is a blueprint or template for constructing objects.
- Example: the DrawingPanel class (type) is a template for creating many DrawingPanel objects (windows).
    
    - Java has 1000s of classes. Later (ch8) we will write our own
   

- Object: an entity that combines data and behavior
    
    - Object-oriented programming (OOP): Programs that perform their behavior as interactions between objects
 
object: An entity that contains data and behavior.  
data: variables inside the object  
behavior: methods inside the object   You interact with the methods;  
the data is hidden in the object.      Constructing (creating) an object:  
Type objectName = new Type(parameters);   Calling an object's method:  
objectName.methodName(parameters);
   

- String: an obkect storing a sequence of text characters.
    
    - Unlike most other objects, a String is not created with new.
        
        - String name = "text";
        - String name = expression;
   

Characters of a string are numbered with 0-based indexes

- 1st character's index: 0
- Last character's index: 1 less than the string's length
 
- The individual characters are values of type char
   
![Strin Method name indexOf (str) length( ) substring(indexl, index2 ) subst ring(indexl ) toLowerCase( ) toUpperCase( ) methods Description index where the start of the given string appears in this string (-1 if not found) number of characters in this string the characters in this string from indexl (inclusive) to index2 (exclusive); if index2is omitted, grabs till end of string a new string with all lowercase letters a new string with all uppercase letters These methods are called using the dot notation: String gangsta = "Dr ](Exported%20image%2020240525204019-1.png)  
![Modi in strin s • Methods like substring and t0Lowercase build and return a new string, rather than modifying the current string. String s = "lil bow wow" ; s. touppercase(); system . out. pr int In(s); • To modify a variable's value, you must reassign it: String s = "lil bow wow" ; s. touppercase(); system . out . print In (s); lit bow wow LIL BOW WOW ](Exported%20image%2020240525204019-2.png)  

-------------------------------------------------------------------------------------------------------------------------------
 
INTERACTIVE PROGRAMS WITH Scanner
 
Input and System.in
 
- Interactive program: Reads input from the console
    
    - While the program runs, it asks the user to type input.
    - The input typed by the user is stored in variables in the code
    
    - Can be tricky; users are unpredictable and misbehave
    - But interactive programs have more interesting behavior.   
- Scanner: an object that can read input from many sources
    
    - Communicates with System.in ( the opposite of system.out)
    - Can also read from files, web sites, databases
      

SCANNER SYNTAX

- The scanner class is found in the java.util package
    
    - Import java.util.*; //so you can use Scanner
 
- Constructing a Scanner object to read console input:
 
Scanner name = new Scanner(System.in);
 - Example:

Scanner console = new Scanner(System.in);
 ![Scanner methods Method nextlnt() next Double() next() next Line() Description reads an int from the user and returns it reads a doub le from the user reads a one-word string from the user reads a one-line string from the user — Each method waits until the user presses Enter. — The value typed by the user is returned. "How old are you? J') pr ompt int age = ; '"You typed " + age); • prompt: A message telling the user what input tq ](Exported%20image%2020240525204019-3.png)