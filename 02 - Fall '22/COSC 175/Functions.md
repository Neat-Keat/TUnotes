> [!caution] This page contained a drawing which was not converted.   

Introduction to Modularity

- Function/procedures
- Void/value-returning
- Arguments/parameters
- Formal parameters (in definition) vs actual parameters (in call)
- Pass by value/ pass by reference
- Scope: global/local/name precedence
 
Modularity

- Most programs so far have been simple- less than one page in length
- In reality, most problems are not so simple
- Top down design: identify first the major tasks and further subtasks within them
- Modularity: breaking a program into subprograms
 
Modules

- All tasks can be subdivided and further subdivided into subtasks
- Goal => can easily construct pseudocode for each subtask
- Each module constructed and tested as unit
- Black Box
- Suggestion: stubbing in (write dummy modules)
    
    - Always have something working  
Good Names Help

- Begin with Verb!
- Use several short words
    
    - PrintPageHeadings
    - CalcSalesTax
    - ValidateInputDate

Mainline or Driver

- Call subtasks
- Should show the main processing functions, the order they should be performed
- Use a loop!
 
Int main()  
{  
…  
DoProc1();  
…  
} // end main  
//**********************  
Void DoProc1()  
{  
…  
…  
} // end DoProc1
 
Advantages of well structured programs:

- Can easily be changed, updated, and maintained
- Division into tasks makes them easy to understand
- Easy to construct
- Can test modules individually
- Easy to test and debug – easier to isolate errors
 
|   |   |   |
|---|---|---|
||Void Function|Value-returning function|
|return|Can return 1+ value  <br>GetVals(x,y,z)|Returns one result  <br>return x*x|
|name|Begins with a verb  <br>CalcSquare(..)|Noun  <br>Square(..)|
||Void function  <br>void CalcSquare(..)|Value Returning function  <br>float Square(..)|
|Call|Stand-alone  <br>CalcSquare(..)|Call is part of expression  <br>x = Square(..)|
||Multipurpose|Usually Mathematical|
 
1) Define the Function  
Write the function definition  
2) put in prototype  
3) Call/Invoke function
 
void DisplayArea(float length, float width) // defining void Function with formal parameters  
{  
float area; // Declaring a local variable  
area = length * width;  
cout<< "Area is " << area << endl;  
}
 
Put Function Header above int main to let C++ know that you want to define a function (called a prototype
 
#include <iostream>  
Using namespace std;
 
Void DisplayArea(float length, float width); //Prototype
 
Int main()  
{  
…  
}
 
Actual parameters in the call to the function
 
Int main()  
{  
DisplayArea(...); //uses actual parameters  
}
 
DisplayArea(...) // uses formal parameters  
{  
…  
}
 
FUNCTION AS PART OF A PROGRAM   Int main()  
{  
PrintLines(2);  
Cout << " Welcome Home!" << endl;  
PrintLines(2);  
Return0;  
}  
//************************************************  
//Prints lines of *'s  
//numLines specifies how many lines to print  
Void PrintLines (int numLines )  
{  
Int count;  
For (count = 1; count <= numlines; count++)  
Cout << "***********" <<endl;  
}// End PrintLines
 
VALUE RETURNING FUNCTION EXAMPLES  
Void ShowFuncs()  
{  
int num1, num2;  
cout << "Enter 2 numbers"  
cin >> num1 >> num2;  
cout << "The max of" << num1 << "and " << num2 << "is" << Max(num1, num2);  
cube = Cube(num1)  
cout << "The cube of " << num1 << "is" << Cube(num1);  
}  
//*****************************************************  
//this function returns the cube of x  
int Cube (int x)  
{  
return x*x*x;  
}  
//******************************************************  
//this function returns the maximum of 2 numbers  
int Max (int num1, int num2)  
{  
int max;  
if (num1 > num2)  
max = num1;  
else  
max = num2;  
Return max;
    
1) Write Function Definition  
2) Create Prototype  
3) Call (or Invoke) the Function
   

Call void Function  
Int main()  
{  
Display();  
}
 
Display Area ()  
{  
…...........  
}
 
Call Value Returning Function
 
Int x;
 
X = Cube();
   

When to use void versus value-returning Functions

- When returning more than 1 value - use void
- When I/O is required – use void
- Returning ONE Boolean value – value-returning
- Returning one value to be used immediately in an expression – value-returning
- When in doubt – use void
 
Multiple Parameters:
 
- Matched by position
- Each param must be declared:
 
For example:  
PrintLines (3, '$');// call a void function
 
Void PrintLines(int numLines, char whichChar)  
{  
…..  
}  
***********************************
 
Parameters

- In – value parameters
    
    - Pass by value
    - Function receives a copy of the value
    - (note: pass by value is the Default way of passing parameters)

Value Parameters

- Void PrintLines(int numLines)
    
    - NumLines is formal parameter
- PrintLines(lineCount);
    
    - LineCount is actual parameter
- **Formal parameter receives a copy of the value of lineCount**
- **PrintLines** **cannot** **change lineCount**
- # of actual params must match # of formal params
- Types of actual params should match types of formal params

Parameters

- In, in out, out
- In – value parameters
    
    - Pass by value
    - Function receives a copy of the value
    - Function cannot change the value of the parameter
- In out, out – reference parameters
    
    - Pass by reference
    - Attach ampersand to data type, int& param
    - Function receives the address of the actual parameter
    - Function can change the value of the parameter

Scope

- Is the area of a program where a variable is visible
- Global variables
- Local variables
- Side effects

Local Variables and Functions

- Each function is a block
- Any function can declare variables within a block
- Local variables are accessible only within the block they are declared
- Local variables occupy space only when the function is executing
- When the function is invoked – local variables are created
- When function is finished – local variables are destroyed

Global variables

- Declared outside all functions

Int gamma; // global
 
Int main()  
}  
Void SomeFunc()  
}

- Can be accessed from main or SomeFunc
 
{  
Float avg; // local  
{  
String name; // local  
Global and Local Variables (continued)

- It is possible to have identifiers (variables) with the same name both in the main program and the subprogram:
- Name precedence- a local identifier in a module takes precedence over a global identifier with the same spelling in any reference, the procedure makes to the identifier
 
Call function CalcSum that has 2 parameters:  
CalcSum(num1,num2);  
Call function Cube that returns the total and has 1 parameter:  
Float Cube(num1);
 
HW 4 is assigned  
Project is assigned  
Quiz 2 (Functions) NEXT CLASS

- Line 2 invokes/ calls the subprogram
- Control is transferred to the subprogram: line 5
- The code in the subprogram is executed: line 6, 7, 8
- At line 8, control returns to statement following call, line 3
- 1, 2, 5, 6, 7, 8, 3, 4

Void Function Definition
 
void PrintPageHeadings()  
{  
￼}

Function header

Function body

Value Returning Function Definition
 
Int Square()  
{
 
}

Output:  
**********  
**********  
Welcome Home!  
**********  
**********

YOU CAN CALL VALUE RETURNING FUNCTIONS IN COUT STATEMENTS!!!

2 ways to call value returning functions:  
***1) use assignment statement  
2) use cout statement

Function exercise 1 in BB

Int main()  
{  
Int lineCount;  
Cin>>lineCount;  
PrintLines(lineCount);  
}  
Void PrintLines(int numLines)  
{  
…..  
}

If lineCount = 10, then that is passed (copied?) to PrintLines  
(pass by value)
 
Void PrintLines CANNOT change numLines value

Can pass multiple parameters, some by value and some by reference