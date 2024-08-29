Programming assignment #3 sent out  
Read a character, translate, output  
Both forwards and backwards  
2 translators?
 
UML Diagram online  
Unified Modelling Language
 
Do a shit ton of while !endOfMesg, endOfLine, endOfWord nested loops?
 
Binary search a morse code character?
 
-------------------------------------------------------------------------------------------------------------------------------
 
RECURSION!!  
Look at lecture notes pls ty
 
Recursive functions call their own definition, effectively cloning the ongoing process  
These calls MUST be CONDITIONAL, otherwise there will be infinite clones and everything will break.
 
Recursion doesn’t give you any more capability than while loops  
Its just easier to envision some problems with recursion than loops  
"it’s a conceptual tool"
 
Think Towers of Hanoi problem
 
Recursion is related to proof by induction  
"if I can solve a small version of the problem, I can solve any size version of the problem.
 
Break a problem down until you hit the base case, solve it and work up
 
**FIRST 2 PRACTICUMS ON RECURSION ON EXAM??**
 
**Recursion:**

- Iteration and recursion are computationally equivalent
- The proper way to conceptualize recursion is a function that calls another instance of itself (clone)
- The values of the local variables are unique for each recursive instance
- Every properly defined recursive function must have a base case
- Each recursive call must be conditional, otherwise have infinite recursion)
 
The factorial problem!  
Recursion is a less efficient way of solving problems compared to loops  
Only use it when its much easier to implement recursively then with loops
 
Recurrence definition  
Factorial(n) = 1 if n <= 1 (base case)  
Factorial(n) = n * factorial(n-1) (recursive case)
 
Implementation  
public static int factorial(int n) {  
if (n <= 1)  
return 1;  
else  
return n * factorial(n-1);  
}
 
That’s it!
 
consider factorial(3):  
return 3 * factorial(2)  
return 3 * (2 * factorial(1))  
return 3 * (2 * (1))  
return 3 * 2  
return 6