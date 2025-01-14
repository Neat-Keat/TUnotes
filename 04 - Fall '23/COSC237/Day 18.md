New program 3, should be easier
 
-------------------------------------------------------------------------------------------------------------------------------
 
Equivalence of iteration and recursion  
Conceptualize recursive procedures as calling another invocation of itself  
Every call must be conditional  
…  
,…
 
How to reverse the characters in a string recursively?
 
-------------------------------------------------------------------  
import java.util.scanner;  
public class main {
 
reverseString("Hello.");
 
public static void reverseString(String s) {  
char oneChar;  
oneChar = s.charAt(0);
 
if(oneChar != '.'){  
reverseLine(s.substring(1));  
}
 
System.out.print(oneChar);  
---------------------------------------------------------------------
 
… (CHECK LECTURE NOTES)…
 
top down vs bottom up computation

- top-down – solution derived at the bottom of recursive calls
- bottom-up – solution derived after recursive calls unwind
 
the factorial problem is bottom-up
 
the binary search is top-down
 
towers of hanoi implementation:  
----------------------------------------------------------------------------  
public static void towers(int numDisks, String startPeg, String destPeg, String sparePeg){  
if (numDisks == 1)  
System.out.println("move disk from " + startPeg + " to " + destPeg)  
else {  
towers(numDisks – 1, startPeg, sparePeg, destPeg);  
System.out.println("move disk from " + startPeg + " to " + destPeg);  
towers(numDisks – 1, sparePeg, destPeg, startPeg);  
}  
}