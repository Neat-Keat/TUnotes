Algorithms  
Arithemetic:  
+ addition  
- subtraction  
* multiplication  
/ division  
pow exponentiation  
% modulus
 
Assignment Operator  
=  
Differs from equality  
X = 3  
Assigns X the value 3
 
Variable = Expression

|   |   |
|---|---|
|Variable|Physical location in computer memory|
|Constant|X = 10;  <br>X = pi;  <br>Other variables  <br>Y = X;  <br>Formula to evaluate  <br>Y = a*x/2+3;|

Assignment  
Processor evals the right member of an assignment statement to get a single value  
Places this value in the memory location (variable name) given as the left member  
NOT a mathematical equation, cant be switched  
Stamp = 14;  
Good  
14 = Stamp;  
Bad  
A+x = 2+y (CANT DO IT)
 
Given the declarations:  
Int stuff;  
String name;  
Int widget;  
Int numWidgets

|   |   |
|---|---|
|numWidgets = 10;|10 is in memory for numWidgets|
|numWidgets = numWidgets + 1|11 is in memory for numWidgets|
|name = "toby"|toby is in memory (not "", they're delimiters)|
|stuff = numWidgets;|11 is in memory for stuff|
|widget = numWidgets * 2|22 is in memory for widget|

Int x;  
x = 5;  
x = x + 1 // this is an increment
 
float item1Price;  
float item2Price;  
float total;  
item1Price = 10.00;  
item2Price = 2.00;  
total = item1Price + item2Price

Int x;  
X = 5;  
X = x –1; //this is a decrement
 
float grossPay;  
float tax;  
float netPay;  
grossPay = 2000;  
tax = 200;  
netPay = grossPay – tax;

Int x;  
X = 5;  
X = x * 2;
 
float bill;  
float tip;  
float totalBill;  
bill = 20.00;  
tip = bill * .2; //could use const here  
totalBill = bill + tip

Division  
Cant devide by 0  
Int division yields integer result  
5 / 10 = 0  
10 / 3 = 3
 
Float division yields real number result\  
5 / 10.0 = .5
 
**Division and Type Casting**  
Type Casting:  
Used to explicitly convert data from one data type to another  
Ex:  
int num1;  
int num2;  
num1 = 10;  
num2 = 3;  
(float) num1/num2 => float result
 
//In this case it would result in 3.333, not 3 (DONT USE IN THIS CLASS)

Modulus %  
Gives the REMAINDER of division  
10 % 5 => 0  
23 % 5 => 3  
7 % 2 => 1  
58 % 10 => 8  
Useful for determining even/odd numbers  
If (num1 % 2 == 0)  
Cout << "even";

== is used for equality  
= is used for assignment

PRECEDENCE:  
PEMDAS

|   |   |
|---|---|
|<|Less than|
|<=|Less than or equal to|
|>|Greater than|
|>=|Greater than or equal to|
|==|Equal to|
|!=|Not equal to|

Logical Operators
 
|   |   |   |   |
|---|---|---|---|
|AND|&&|exp1 && exp2|True only if both are true|
|OR|\||exp1 \| \| exp2|True if either OR both are true|
|NOT|!|!exp1|True if exp1 is false|
 
Exp = expression

&&

|   |   |   |
|---|---|---|
|X|Y|X && Y|
|T|T|T|
|T|F|F|
|F|T|F|
|F|F|F|

| |

|   |   |   |
|---|---|---|
|X|Y|X \| \| Y|
|T|T|T|
|T|F|T|
|F|T|T|
|F|F|F|

!

|   |   |
|---|---|
|X|!X|
|T|F|
|F|T|

Trace- simulate the algorithm using known results (desk check)  
Most major logic errors occur during the dev. Of the algorithm
 
How to do a trace  
1) list variables across the top of the page  
2) Include column for output  
3) Step through code one line at a time  
4) Fill in variables as they change  
5) Fill in output column if appropriate  
6) Do it for 3 sets of data

IPO Exercise 3

1. A program is required that will read in a tax rate (as a percentage), tip rate (as a percentage) and the price of three items (use three variables). The program is to calculate the total price before tax, the tax payable, bill after tax, tip, and total bill. Print all values 
(MY ANSWER)

|   |   |   |
|---|---|---|
|Input|Process|Output|
|float taxRate|initPrice = item1 + item2 + item3|float initPrice|
|float tipRate|taxPayable = initPrice * taxRate|float taxPayable|
|float item1|billAfterTax = taxPayable + initPrice|float billAfterTax|
|float item2|tip = billAfterTax * tipRate|float tip|
|float item3|totalBill = billAfterTax + tip|float totalBill|
|||float taxRate|
|||float tipRate|
|||float item1|
|||float item2|
|||float item3|
   

(CLASS ANSWER)

|   |   |   |
|---|---|---|
|Input|Process|Output|
|taxRate|Read taxRate, tipRate, itemPrice1, itemPrice2, itemPrice3|taxRate, tipRate, itemPrice1, itemPrice2, itemPrice3|
|tipRate|Calculate priceBTax, taxPayable, billAfterTax, tip, totalBill|priceBtax, taxPayable, billAfterTax, tip, totalBill|
|itemPrice1|Display taxRate, tipRate, itemPrice1, itemPrice2, itemPrice3, priceBTax, taxPayable, billAfterTax, tip, totalBill||
|itemPrice2|||
|itemPrice3|||
       

HW: