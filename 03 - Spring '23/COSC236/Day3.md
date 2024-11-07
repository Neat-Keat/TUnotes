**Building Java Programs, Chapter 2**

**Primitive Data and Definite Loops**
 - Type: a category or set of data values
    
    - Constrains the operations that can be performed on data
    - Many languages ask the programmer to specify types
    - Ex: int, real number, string
- Internally, computers store everything as 1's and 0s
    
    - 104 -> 01101000
    - "hi" -> 01101000110101
   

- Primitive types: 8 simple types for numbers, text, etc.
    
    - Java also has object types, discussed later
 
|   |   |   |
|---|---|---|
|Int|Integers (up to 2^31-1)|42, -3, 0, 926394|
|Double|Real numbers (up to 10^308)|3.1, -0.25, 9.4e3|
|Char|Single text characters|a, X, ?|
|Etc|||
 
Expression: a value or operation that computes a value

- Ex: 1+4*5
    
    - (7+2)*6/3
    - 42
- The simplest expression is a literal value
- A complex expression can use operators and parentheses
 
- Operator: combines multiple values or expressions
    
    - + addition
    - Subtraction
    - Multiplication
    - / division
    - % modulus (remainder
- As a program runs, its expressions are evaluated.
    
    - 1+1 evaluates to 2
    - System.out.println(3*4); prints 12
        
        - How would we print the text 3*4?
            
            - System.out.println("3*4");  
Integer division with /

- When we divide integers, the qoutient is also an integer
    
    - 14/4 =3, not 3.5
    - 32/5 = 6
    - 84/10 = 8
    - 156/100 = 1
- Dividing by 0 causes an error when your program runs
 
Integer remainder with %

- The % operator computes the remainder from integer division
    
    - 14%4 = 2
    - 218%5 = 3
    - 45%6 = 3
    - 2%2 = 2
    - 8%20 = 8
    - 11 % 0 = error
 
Applications of % operator

- Obtain last digit of a number:
    
    - 230857%10 = 7
- Obtain last 4 digits
    
    - 658236489%10000 = 6489
- Determine evenness
    
    - 7%2 = 1, 42 % 2 = 0
 
Precedence: order in which operators are evaluated.

- Generally operators evaluate left to right
    
    - () has higher precedence than */% have higher precedence that +-
 
Spacing does not affect order of evaluation  
1+3 * 4-2 = 11
 
1*2+3*5%4 = 5  
1+8%3*2-9 = -4
 
**Real numbers (type double)**

- Examples: 6.022, -42.0, 2.14e^17
    
    - Placing .0 or . After an integer makes it a double
- The operators +-*/%() all still work with double
    
    - / produces an exact answer: 15.0 / 2.0 is 7.5
    - Precedence is the same: () before */% before +-
 
- When int and double are mixed, the result is a double.
    
    - 4.2 * 3 = 12.6
    - The conversion is per-operator, affecting only its operands.
        
        - 7/3 * 1.2 + 3/2
            
            - 2*1.2+3/2
            - 2.4+3/2
            - 2.4 +1
            - 3.4
          
          
        
   

String Concatenation: using + between a string and another value to make a longer string

- "hello" + 42 = "hello42"
- 1 + "abc" +2 = "1abc2"
- "Hello" + 9*3 = Hello27
- Use + to print a string and an expression's value together.
    
    - System.out.println("Grade: " + (95.1+71.9) / 2);
        
        - Output: Grade: 83.5  
Variable: a piece of the computerss memory that is given a name and type, and can store a value

- Like preset stations on a car stereo, or speed dial
 
STEPS FOR USING A VARIABLE:

1. Declare it - state its name and type
2. Initialize it - store a value into it
3. Use it - print it or use it as part of an expression
 
Variable declaration: sets aside memory for storing a value  
Assignment: stores a value into a variable  
Name = expression;  
Int x;  
X = 3
 
Once given a value, variables can be used in expressions  
Int x;  
X = 3;  
System.out.println("X is " + x ); // x is 3
 
You can assign a value more than once  
You can declare AND initialize in one statement  
type name = value;  
int x = (11%3)+12;  
double myGPA = 3.95;
 
Assignment uses =, but it is not an algebraic equation  
= means store the value at right in variable at left

- The right side expression is evaluated first, and then its result is stored in the variable at left
- Int x=3
- X = x+2 //??

A variable can only store a value of its own type

- int x =2.5; //ERROR: incompatible types
- An int value can be stored in a double variable
    
    - the value is converted into the equivalent real number
    - double myGPA =4; //4.0
    - double avg =11/2; //5.0
 
COMPILER ERRORS

- A variable can't be used until it is assigned a value
- Int x;
- System.out.println(x); //error: x has no value
 
- You may not declare the same variable twice in the same scope
 
- Int x;
- Int x; //error: x already exists
 
- Int x=3;
- Int x=5; //error: x already exists
 
----------------------------------------------------------------------------------------------------------------------------------------------------------------
 
**THE FOR LOOP**  
So far, repeating a statement is redundant:
 
For Loop syntax:
 
For (initialization; test; update) { //Header  
Statement; // Body  
Statement;  
…..  
Statement;  
}
 
EX.  
For (int I = 1; I <=6; i++) {  
System.out.println("I am so smart");

}
 - Int I = 1 Tells Java what variable to use in the loop
    
    - Performed once as the loop begins
    - The variable is called a loop counter
        
        - Can use any name, not just i
        - Can start at any value, not just 1
   

- I <= 6; tests the variable against a condition
    
    - Variable++; equivalent to variable = variable = variable + 1;
    - Variable--; equivalent to variable = variable = variable - 1;
        
        - Works with ints and doubles!
 
Modify and assign operators

- Variable += value -> variable = variable + value;
- Variable -= value -> variable = variable - value;
- Variable *= value -> variable = variable * value;
- Variable /= value -> variable = variable / value;
- Variable %= value -> variable = variable % value;
 
Loops can be used to print multi line graphics
 
Int highTemp = 5;  
For (int I = -3; I <=highTemp /2 i++) {  
System.out.print((I * 1.8 +32) + " ");  
}  
Output:  
26.6 28.4 30.2 32.0 33.8 34.6
 
Loops can be used for countdowns
 
-------------------------------------------------------------------------------------------------------------------------------------------------------
 
**Nested For Loop**  
Nested loop: a loop placed inside another loop  
For (int I = 1; I <=5; i++) {  
For (int j = 1; j <=10; j++) {  
System.out.print("*");  
}  
}
 
**********  
**********  
**********  
**********  
**********
 
**MAKE SURE YOUR CODE DOESN'T MAKE INFINITE LOOPS!!!!**  
Can happen when inner loop references outer loop improperly
 
--------------------------------------------------------------------------------------------------------------------------------------------------------
 
Binary Number System, based on powers of 2  
2^0 = 1  
2^1 = 2  
2^2 = 4  
2^3 = 8  
2^4 = 16  
2^5 = 32  
2^6 = 64  
2^7 = 128  
2^8 = 256
 
104-64-32-8 = 01101000
 
A series of binary digits can represent characters, numbers, or commands

- Numbers
- Ascii text
- Object
- Command
 
In JAVA, the compiler handles the accounting of how memory is interpreted

- Variable declarations tell the compiler how much memory is needed and what's stored there
    
    - Numeric types: (Java keywords)
        
        - Short, int, long
        - Float, double
 
Variables have 5 characteristics:

- Type
- Name
- Size (related to type)
- Value
- Location (address) handled by compiler
 
Variable declarations always set name & type

- Int items;
- Double cost;

Optionalln can initialize the value

- Int x = 3;
 
Should be descriptive  
Int item; > int I;
 
May be long or short

- Int myExampleItemCountForSampleProgram;
- Int x;
   

Exceeding the max values for number values wraps to negative / wraps to positive
 
.1 + .2 = 0.30000000000000000000004