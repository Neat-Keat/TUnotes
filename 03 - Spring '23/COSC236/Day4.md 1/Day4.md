Building Java Programs Chapter 2: Primitive Data and definite loops ctd:
 
What nested for loops produce the following output?  
….1  
...2  
..3  
.4  
5
 
For (int line = 1; line <=5; line++) {  
For (int j=1; j<=(-1 * line + 5); j++) {  
System.out.print(".");  
}  
}  
For (int k = 1; k<= line; k++) {  
System.out.print(line);  
}  
System.out.println();
 
--------------------------------------------------------
 
Use nested for loops to produce ASCII art!
 
Pseudocode: an english description of an algorithm
 
1. Line
    
    - #, 16=, #
2. Top Half
    
    - |
    - Spaces (decreasing)
    - <>
    - Dots (increasing)
    - <>
    - |
3. Bottom half
    
    - Top half inverse
4. Line
    
    - #, 16=, #
 
Public class Mirror {  
Public static void main (String[] args) {  
line();  
tophalf();  
bottomHalf();  
line();
   

A table for the top half

|   |   |   |   |   |
|---|---|---|---|---|
|line|spaces|Line * -2 + (2*size)|dots|Line * 4 - 4|
|1|6||0||
|2|4||4||
|3|2||8||
|4|0||12||
 
Idea: make a variable represent the size

- Use the variable's value in the methods
 
Problem: a variable in 1 method can't be seen in others
 
Scope: The part of a program where a variable exists.  
From its declaration to the end of the {} braces  
A variable declared in a for loop exists only in that loop  
A variable declared in a method exists only in that method
 
Variables without overlapping scope can have the same name
 
A variable can't be declared twice or used out of its scope
 
Class Constants: A fixed value visible to the whole program.

- Value can be set only at declaration; cannot be reassigned
 
SYNTAX:  
public static final type name = value;

- Name is usually in ALL_UPPER_CASE
- Ex:
    
    - public static final int DAYS_IN_WEEK = 7;
    - public static final double INTEREST_RATE = 3.5;
    - public static final int SSN = 658234569;

DECLARED BEFORE MAIN!!!
 
Use class constants to scale ASCII art!!
 
------------------------------------------------------------------------------------------------------  
Must scale 1 figure on HW

Print 4, 7, 10, 13, 16  
For int count = 1; count <=5; count++){  
System.out.print(3* count + 1 + " ")
 
Print 2, 7, 12, 17, 22  
For (int count = 1; count <=5; count++) {  
System.out.print(5 * count – 1 + " ")
 
Print 17, 13, 9, 5, 1  
For (int count = 1; count <=5; count++) {  
System.out.print(21 - (4 * count));
 
![public class Sign { public static void main(String[] args) { drawLine drawBody drawLine public static void drawLine() { System . out . print( "+" ) ; for (int i 1; 1 <= 10 • i++) { System . out . print( System . out . print "+" ) ; public static void drawBpdy() { for (int line 1 •t I Ine <= 5; line++) { System . out . prxnt(" I " for (int spaces 1; spaces <= 20; spaces++) { System. out. print (" " System . out . print " I " ) ](Exported%20image%2020240525204018-0.png)  

![public class Sign { public static final int HEIGHT = 5; public static void main(String[] args) { drawLine drawBody drawLine public static void drawLine() { System . out . print( "+" ) ; for (int i 1; 1 HEIGHT System. out . System . out . print "+" ) ; public static void drawBpdy() { for (int line 1 •t line HEIGHT; System . out . prxnt(" I " for (int spaces 1; spaces System. out. print (" " System . out . print " I " ) line++) { HEIGHT * 4; spaces++) { ](Exported%20image%2020240525204018-1.png)