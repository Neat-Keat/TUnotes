Exams are written  
Not a *lot* of code  
"I'll consider doing it online"  
------------------------------------------------------------------------------------------------
 
A data type is a set of values that can be assigned to a variable

- Also includes a set of operations valid on that type!
 
Defining your own data type lets you also define your own methods!

- The fact you can share them makes java quite powerful
 
Its important to know whether the bool and/or operators in a given programming language uses short-circuit eval or not. Consider:
 
if (denominator != 0 && numerator / denominator > 1) {  
…  
}
 
&& short circuits and runs fine.  
& executes and gets a "divide by 0" error
 
without short circuit eval, you have to use nested if statements to get the same effect
 
Expression Evaluation  
2 fundamental considerations

- Operator Precedence
- Mixed-type expressions
 
Implicit and Explicit handling of Operator Precedence  
for all the operators, there is defined an operator precedence (defined in an operator precedence table) for the particular programming language.
 
Implicit: multiplication before addition, etc  
10 + 2 * 5 evaluated as 10 + (2 * 5) -> 20
 
Explicit: use of parentheses by programmer  
(10 + 2) * 5 -> 60
 
Implicit and explicit handling of Mixed-Type Expressions  
Java CANNOT perform an arithmetic operation on operands of mixed type, eg, 10.5+2. The 2 operators must first be converted to the same type. For all types there is defined a hierarchy of types ( defined in a type promotion table)
 
implicit: based on defined type promotion ("using coercion")  
10.5 + 2 evaluated as 10.5 + 2.0 -> 12.5
 
Explicit: use of unary cast operator in Java:  
(int) 10.5 + 2 evaluated as 10 + 2 -> 12
 
Data Types  
All programming languages have a set of primitive data types. New data types can be defined by the programmer from the provided primitive types. Pirmitive types in java:

- int / short / long / byte
- float / double
- boolean
- char

Note that the String type is NOT a primitive data type. It is a class type
 
A data type is defined by:

- a set of values
- a set of operators on those values
 
the int type in 1 lang may not = the int in another. (EX. one has % and one doesn’t)
 
Strings in Java are provided by 2 particular classes in Java:  
String and StringBuffer
 
Values (objects) of type String are immutable  
Values of type StringBuffer are mutable
 
The Creation/ Assignment of Strings  
can declare and assign strings one of 2 ways:

- String str1 = new String("Hello World");
- String str2 = "Hello World";
 
The difference is that with the use of the new operator, a new string is always created  
…..
 
The String Type  
The following creates a String type in java  
String name = "John Walters";  
Therefore, the value "John Smith" is immutable, but what about thhe replace operator on strings?!  
name.replace('h','a') -> "Joan Walters"
 
The original string is not changed – a new string is returned. Therefore, variable name must be reassigned to the new returned value,  
name = name.replace('h','a').
 
The StringBuffer type  
The following creates a StringBuffer type in Java:  
StringBuffer name = "John Walters"
 
here, the value "John Walters" is mutable. Therefore, a new string is not created. Rather, the original string is modified,
 
name.replace('h','a')  
System.out.println("name = " + name);  
-> Joan Walters
 
Control Structures  
The three forms of control necessary (and sufficient) to perform ANY computation are:

- Sequential Control (implicit)
- Selection Control (if, switch)
- Iterative Control (while, for)
 
Selection Control using if statement  
if else if else if else
 
Selection Control with switches:  
case 1:  
case 2:  
case...:  
default: optional "catch all"
 
While loops are pre-test loops  
doesn’t necessarily execute once  
do while are post-test loops  
ALWAYS executes at least once
 
for loop
 
for(int n = 1; n <=10; n++){  
}  
initialize, condition, update
 
You can ALWAYS do the same thing with for loops and while loops
 
Enhanced for loop  
there are times when the values that the variable in a for loop is to iterate over a stored set of values (eg an array of grades). In suce cases, the more concise enhanced for statement can be used:  
int[] grades = {89, 94, 75, 98,…}  
for (int grade: grades)  
{  
system.out.println(grade);  
}  
this would print out each of the grades in array grades