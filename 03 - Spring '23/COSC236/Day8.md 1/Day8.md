Building Java Programs Chapter 4  
Conditional Execution
 
EXAM 1 REVIEW/ MOCK EXAM MARCH 6, 8, 9
   

Cumulative algorithms  
Used to sum numbers, etc,
 
cumulative product  
-------------------------------------------------------------------------------------------------  
int product = 1;  
for (int i = 1; i <= 20; i++) {  
product = product * 2;  
}  
System.out.println("2 ^ 20 = " + product);  
---------------------------------------------------------------------------------------------------  
Write a method countFactors that returns  
the number of factors of an integer.  
countFactors(24) returns 8 because  
1, 2, 3, 4, 6, 8, 12, and 24 are factors of 24.   Solution:   // Returns how many factors the given number has.  
public static int countFactors(int number) {  
int count = 0;  
for (int i = 1; i <= number; i++) {  
if (number % i == 0) {  
count++; // i is a factor of number  
}  
}  
return count;  
}  
---------------------------------------------------------------------------------------------------  
Text Processing
 
Type char

- A primitive type representing single characters
    
    - A string is stored internally as an array of char
      
    
 ![inde 0 1 2 3 4 5 string s "Ali G. " , ](03%20-%20Spring%20'23/COSC236/Day8.md%201/Exported%20image%2020240525204023-0.png)

- It is legal to have variables, parameters, returns of type char
    
    - Surrounded with apostrophes: 'a' or '4' or '\n' or '\''

Char letter = 'P';  
System.out.println(letter); //P  
System.out.println(letter + "Diddy"; //P Diddy
 
The charAt method

![• The chars in a string can be accessed using the charAt method. — accepts an int index parameter and returns the char at that index String food = "cookie"; char first Letter = food. charAt(O) ; System. out .print In(firstLetter + " is for ' + food); • You can use a for loop to print or examine each character. String major = "CSE for (int i = O; i < major. length(); i++) { char c = major .charAt(i); System . out . print In(c) ; output: ](03%20-%20Spring%20'23/COSC236/Day8.md%201/Exported%20image%2020240525204023-1.png)  

Comparing char values

- You can compare chars with ==, !=, and other operators:
    
    - String word = console.next();
    
    char last = word.charAt(word.length() - 1);  
    }
    
      
    
    //prints the alphabet  
    }
    
      
    

if (last == 's') {  
System.out.println(word + " is plural.");
 
for (char c = 'a'; c <= 'z'; c++) {  
System.out.print(c);
 
Char VS. Int

- Each char is mapped to an integer value internally
    
    - Called an ASCII value
      
    
    |   |   |   |
    |---|---|---|
    |'A' is 65|'B' is 66|' ' is 32|
    |'a' is 97|'b' is 98|'*' is 42|
    
      
    - Mixing char and int causes automatic conversion to int
        
        - 'a' + 10 = 107,
        - 'A' + 'A' = 130
    - To convert an int into the equivalent char, type-cast it.
        
        - (char) ('a' + 2) is 'c'
          
        
- "h" is a String, 'h' is a char (THEY ARE DIFFERENT)
    
-----------------------------------------------------------------------------------

- A String is an object; it contains methods.

String s = "h";  
s = s.toUpperCase(); // "H"  
int len = s.length(); // 1  
char first = s.charAt(0); // 'H'
 
- A char is primitive; you cant call methods on it

char c = 'h';  
c = c.toUpperCase(); // ERROR  
s = s.charAt(0).toUpperCase(); // ERROR  
Does this work?  
s = s.toUpperCase().charAt(0);
  What is s + 1 ? What is c + 1 ?  
What is s + s ? What is c + c ?
 
----------------------------------------------------------------------------------------------------  
Formatting text with printf
 
System.out.printf("format string", parameters);
 
- A format string can contain placeholders to insert parameters:
- Example:

%d integer  
%f real number  
%s string

- These placeholders are used instead of + concatenation
 
int x = 3;  
int y = -17;  
System.out.printf("x is %d and y is %d!\n", x, y);  
// x is 3 and y is -17!   printf does not drop to the next line unless you write \n
 
printf width  
%Wd integer, W characters wide, right alined  
%-Wd integer, W characters wide, left aligned  
%Wf real number, W characters wide, right alined  
-----------------------------------------------------------------------------------------------------------   for (int i = 1; i <= 3; i++) {  
for (int j = 1; j <= 10; j++) {  
System.out.printf("%4d", (i * j));  
}  
System.out.println(); // to end the line  
}   Output:  
1 2 3 4 5 6 7 8 9 10  
2 4 6 8 10 12 14 16 18 20  
3 6 9 12 15 18 21 24 27 30  
--------------------------------------------------------------------------------------------------------  
printf precision  
%.Df real number, rounded to D digits after decimal  
%W.Df real number, W chars wide, D digits after decimal  
#-W.Df real number, W wide (left align), D after decimal  
----------------------------------------------------------------------------------------------------------  
double gpa = 3.253764;  
System.out.printf("your GPA is %.1f\n", gpa);  
System.out.printf("more precisely: %8.3f\n", gpa);   Output:  
your GPA is 3.3  
more precisely: 3.254  
-----------------------------------------------------------------------------------------------------------  
TO FORMAT THE RECIPE SCRIPT:
 
...   // Calculates total owed, assuming 8% tax and 15% tip  
public static void results(double subtotal) {  
double tax = subtotal * .08;  
double tip = subtotal * .15;  
double total = subtotal + tax + tip;   // System.out.println("Subtotal: $" + subtotal);  
// System.out.println("Tax: $" + tax);  
// System.out.println("Tip: $" + tip);  
// System.out.println("Total: $" + total);   System.out.printf("Subtotal: $%.2f\n", subtotal);  
System.out.printf("Tax: $%.2f\n", tax);  
System.out.printf("Tip: $%.2f\n", tip);  
System.out.printf("Total: $%.2f\n", total);  
}  
}  
----------------------------------------------------------------------------------------------------------------

- Relational operators such as < and == fail on objects
- This code will compile, but It will not print the song
- Technically this returns a value of type boolean
- == compares objects by _reference_ (seen later), so it often gives false even when two Strings have the same letters

Scanner console = new Scanner(System.in);  
System.out.print("What is your name? ");  
String name = console.next();  
if (name == "Barney") {  
System.out.println("I love you, you love me,");  
System.out.println("We're a happy family!");  
}  
-----------------------------------------------------------------------------------------------------------------  
STRING TEST METHODS
 ![Method equals(str) equalslgnorecase(str) startsWith(str) endsWith(str) contains(str) Description whether two strings contain the same characters whether two strings contain the same characters, ignoring upper vs. lower case whether one contains other's characters at start whether one contains other's characters at end whether the given string is found within this one ](03%20-%20Spring%20'23/COSC236/Day8.md%201/Exported%20image%2020240525204023-2.png)  

String name = console.next();  
if (name.startsWith("Prof")) {  
System.out.println("When are your office hours?");  
} else if (name.equalsIgnoreCase("STUART")) {  
System.out.println("Let's talk about meta!");  
}  
--------------------------------------------------------------------------------------------------------------------