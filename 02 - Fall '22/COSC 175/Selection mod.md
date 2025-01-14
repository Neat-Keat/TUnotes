> [!caution] This page contained a drawing which was not converted.   

Decisions

Given hours worked and pay rate, calculate Net pay
 - What if an employee worked overtime?
- How do we indicate if an employee worked overtime?
- How about double overtime?
 
Pseudocode:  
Input payRate  
Input hrsWorked  
netPay = payRate * hrsWorked  
Output netPay
   

Answer these questions with **DECISIONS** 😀

|   |   |
|---|---|
|<|Less than|
|<=|Less than or equal to|
|>|Greater than|
|>=|Greater than or equal to|
|==|Equal to|
|!=|Not equal to|
 
Ex. 10 > 2  
'a' > 'c'

|   |   |   |   |
|---|---|---|---|
|AND|&&|exp1 && exp2|True only if both are true|
|OR|\||exp1 \| \| exp2|True if either OR both are true|
|NOT|!|!exp1|True if exp1 is false|
 
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
 
1)  
If ((sex == 'F') && (city_code == 18) && (gpa >= 3.7))  
Cout << "Merit Award" << endl;
 
2)  
If ((zip =="48002") || (zip == "48003") || (zip == "48004"))  
Cout << "LOCAL" << endl;

"Short-Circuit" Evaluation

- Process in which the computer evaluates a logical expression from left to right and STOPS as soon as the value of the expression is known
    
    - If the computer finds one True in || the whole statement is True
    - If the computer finds one False in && the whole statement is False
 
Selection/Decision  
Selection Test for true or false
   

If Syntax  
If (expression)  
Statement
 
(statements can be a single statement, null statement, or a compound statement)
 
Ex) (single statement)  
If (age >=18)  
{  
Go crazy aaaa  
Go stupid  
aaaaa  
}
 
Ex) (compound statements)  
If ((age >=18) &&(height > "6 feet"))  
{  
Do the thing  
}
 
If statement is a selection of whether or not to execute a statement (which can be a single statement or an entire block)

1)  
If (taxCode == 'T')  
Price == price + taxRate*Price;
 
2)  
If (num < 0)  
{  
//compound statement  
Cout << "Negative" << endl;  
NumNegs = numNegs +1;  
}
 
If-else Syntax
 
if (expression)  
Statement A  
Else  
Statement B
 
(Statement A and Statement B each can be:  
A single statement  
A null statement  
A compunt statement)
 
If-else provides 2-way selection between 2 clauses

Int carDoors, driver Age;  
Float premium, monthlyPayment  
…  
If ((carDoors == 4) && (driverAge > 24))  
{  
Premium == 650.00  
Cout << "LOW RISK" << endl;  
}  
Else  
{  
Premium = 1200.00  
Cout << "HIGH RISK" << endl;  
}
 
MonthlyPayment = premium/12.0 +5.00;

Int main()  
{  
Float temp;  
Float newTemp;  
Char units;
 
Cout << "Enter temperature and C or F"  
Cin >> temp >> units;  
If ((units =='F') || (units == 'C'))  
If (units == 'F')
 
{  
NewTemp = (5*(temp-32))/9;  
Cout << temp << "Degrees F = " << newTemp << " Degrees C";  
}  
Else  
{  
NewTemp = ((9*temp)/5) +32  
Cout << "Degrees C = " << newTemp << "Degrees F" << endl;  
}  
}

Exercises:  
1) Write the statements that allow you to input a number and prints whether it is positive or negative.  
2) Write the statements necessary to input the price of apples and the price of oranges. Then print either "THE APPLES COST MORE" or "THE ORANGES COST MORE". How would you handle the situation where the cost was the same?  
3) Write the statements that allow you to input a number and print whether it is odd or even

1)  
Int num1
 
Cout << "Enter a whole number" << endl;  
Cin >> num1  
If (num1 >= 0)  
{  
Cout << "The number is positive" << endl;  
}  
Else  
{  
Cout << "The number is negative" <<  
}
 
3)  
Int num1
 
Cout << "enter a whole number" <<engl;  
Cin >> num1  
If (num1 % 2 == 0)  
{  
Cout << "Even" << endl;  
}  
Else  
{  
Cout << "Odd" << endl;

2)  
Float applePrice  
Float orangePrice
 
Cout << "how much are apples" << endl;  
Cin >> applePrice
 
Cout << "how much are oranges" << endl;  
Cin >> orangePrice
 
If (applePrice > orangePrice)  
{  
Cout <<"apples are more expensive than oranges" << endl;  
}  
Else if (applePrice < orangePrice)  
{  
Cout << "oranges are more expensive than apples" << endl;  
}  
Else  
{  
Cout << "apples are the same price as oranges" << endl;  
}
   

Nested selection
 
If (hrsWorked <= 40)  
{  
totPay = hrsWorked * payRate;  
}  
else  
{  
regPay = 40 * payRate;  
if (hrsWorked <= 60)  
{  
otPay = hrsWorked –40 * (1.5 * payRate);  
totPay = regPay + otPay;  
}  
else  
{  
otPay = 20 * (1.5 * payRate);  
doubleOtPay = (hrsWorked – 60) * (2 * payRate);  
grossPay = regPay + otPay + doubleOtPay;
 
}  
}

Writing a nested if statement as a Multiple-Alternative Decision
 
If (x > 0)  
Cout << "Positive" << endl;  
Else  
{  
If (x < 0)  
Cout << "Negative" << engl;  
Else  
Cout << "Zero" << endl;  
}

If (x > 0)  
Cout << "Positive" << endl;  
Else if (x < 0)  
Cout << "negative" << endl;  
Else  
Cout << "zero" << endl;

NO ELSE IF KEYWORD IN C++

Cin >> testGrade  
If (testGrade >= 90)  
LetterGrade = 'A';
 
Else if ((testGrade >=80) && (testGrade < 90))  
LetterGrade = 'B';
 
Else if ((testGrade >=70) && (testGrade < 80))  
LetterGrade = 'C';
 
Else if ((testGrade >=60) && (testGrade < 70))  
LetterGrade = 'D';
 
Else  
LetterGrade = 'F';
 
ONLY 1 STATEMENT IN AN IF-ELSE STRUCTURE EXECUTES  
TEST ALL BRANCHES FOR BUGS/ LOGIC ERRORS  
**This is called Minimum Complete Coverage**

Dangling else  
Else matches nearest unmatched if, not based on indentation
 
If  
If  
Else
 
Is actually:
 
If  
If  
else

Switch  
The selector expression is evaluated and compared to each of the case labels.  
Only one statement will be executed  
Use for multiple tests of one variable switch (selector)
 
SYNTAX:  
Switch (selector)  
{  
Case label1:  
Statement 1  
Case label2:  
Statement2  
..  
Case label n:  
Statement n  
Default:  
Statement e  
}
 
int menuOpt;
 
cin >> menuOpt;  
switch (menuOpt)  
{  
case 1:  
cout << "Beginners";  
break;  
case 2:  
cout << "Advanced Beginner";  
break;  
case 3:  
cout << "Intermediate";  
break;  
Default:  
cout << "Invalid Option"  
}  
//END CASE