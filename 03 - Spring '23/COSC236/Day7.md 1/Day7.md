Building Java Programs Chapter 4  
Conditional Execution
 
Dont use if-else logic on lab this week or you'll lose credit
 
The if statement  
If (test) {  
statement;  
}  
The if/else statement  
If (test) {  
Statement;  
} else {  
Statement;  
}
 
Relational expressions

- If statements and for loops both use logical tests.
    
    - For (int I = 1; I <=10; I++) {
    
    If (I <= 10) {
    
      
    
    These are boolean!
    
![Operato Meaning equals does not equal less than greater than less than or equal to greater than or equal to Example 2 3.2 ! = 2.5 126 5.0 Valu true true false true false true ](Exported%20image%2020240525204022-0.png)  
   

Nested if/else
  if (test) {  
statement(s);  
} else if (test) {  
statement(s);  
} else {  
statement(s);  
}
   

Nested if/else/if  
If it ends with else, exactly one path must be taken.  
If it ends with if, the code might not execute any path.
 
if (test) {  
statement(s);  
} else if (test) {  
statement(s);  
} else if (test) {  
statement(s);  
}
 ![Nested if structures exactly 1 path (mutua//y exclusive) O or 1 path (mutua//y exclusive) if (test) { if (test) { statement(s) ; statement(s) ; } else if (test) { } else if (test) { statement(s) ; statement(s) ; } else { } else if (test) { statement(s) ; statement(s) ; O, 1, or many paths (independent tests; not exclusive) if if if (test) { statement(s) ; (test) { statement(s) ; (test) { statement(s) ; ](Exported%20image%2020240525204022-1.png)

-------------------------------------------------------------------------------------------------------------------------------/** BMI for 2 people */
 
import java.util.*;
 
public class sandbox {
   

public static void main(String[] args) {
 
introduction();
 
Scanner keyboard = new Scanner(System.in);
 
double bmi1 = person(keyboard);  
double bmi2 = person(keyboard);
 
report(1, bmi1);  
report(2, bmi2);
 
System.out.println("Difference = " + Math.abs(bmi1 - bmi2));  
}
   

public static void introduction() {  
System.out.println("This program reads data for 2 people & computes their BMI .\n\n");  
}
   

public static double person(Scanner keyboard) {
 
System.out.println("Enter next person's information:");  
System.out.print("Height in inches? ");  
double height = keyboard.nextDouble();
 
System.out.print("Weight in pounds? ");  
double weight = keyboard.nextDouble();  
double bodyMassIndex = bmi(height, weight);
 
return bodyMassIndex;  
}
   

public static double bmi(double height, double weight) {
 
return weight / (height * height) * 703;  
}
 
public static void report(int person, double bmi) {  
System.out.println("Person " + person + " bmi = " + bmi);  
if(bmi < 18.5) {  
System.out.println("Underweight");  
} else if(bmi < 25) {  
System.out.println("Normal");  
} else if(bmi < 30) {  
System.out.println("Overweight");  
} else {  
System.out.println("Obese");  
}  
}  
}  
------------------------------------------------------------------------------------------------------------------------------  
Scanners as parameters

- If many methods need to read input, declare a scanner in main and pass it to the other methods as a parameter
 ![public static void main(String[] args) { Scanner console = new Scanner (System. in); int sum = readSum3( console) ; System. out.println( "The sum is " + sum); // Prompts for 3 numbers and returns their sum. public static int readSum3(Scanner console) { System. 3 numbers: int numl = console. nextlnt(); int num2 = console. nextlnt(); int num3 = console. nextlnt(); return numl + num2 + nUm3; ](Exported%20image%2020240525204022-2.png)  

LOGICAL OPERATORS

![Operato Descriptio n and or not Example 5) (2 -z 3) Il 5) Resul false true true ](Exported%20image%2020240525204022-3.png)  
![P true true fals fals q true fals true fals true false false false PI I q true true true false ](Exported%20image%2020240525204022-4.png)  
![P tr ue fals false tr ue ](Exported%20image%2020240525204022-5.png)  

Relational operators have lower precedence than math
  5 * 7 >= 3 + 5 * (7-1)  
35 >= 33  
True
 
Relational operators cannot be "chained" as in algebra (x = 15)  
2 <= x <= 10  
True <= 10  
Error!
 
Instead, combine multiple tests with && or ||
 
2 <= x && x <- 10  
True && false  
False
 
Factoring if/else code  
Factoring: extracting common/redundant code

- Can reduce or eliminate redundancy from if/else code
 ![• Example: if (a 1) { System . out . print In(a) ; } else if (a 2) { System. out .println(a); } else { System . out . print In(a) ; if (a 2) { ](Exported%20image%2020240525204022-6.png) ![if/else with return // Returns the larger of the two given integers. public static int max(int a, int b) { if (a > b) { return a; } else { return b; • Methods can return different values using if/else — Whichever path the code enters, it will retum that value. — Retuming a value causes a method to immediately exit. — All paths through the code must reach a return statement. ](Exported%20image%2020240525204022-7.png)

ALL PATHS MUST RETURN  
---------------------------------------------------------------------------------------------------------  
CUMULATIVE ALGORITHMS
 
Cumulative sum loop  
Int sum = 0;  
For (int I = 1; I <= 1000; I++{  
Sum = sum + I;  
}  
System.out.println("The sum is " + sum);
   

Cumulative sum: A variable that keeps a sum in progress and is updated repeatedly until summing is finished  
MUST DECLARE OUTSIDE THE LOOPS THAT UPDATE THEM