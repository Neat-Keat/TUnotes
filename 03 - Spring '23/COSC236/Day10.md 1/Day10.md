Last lecture we discussed
 
- fencepost type problems
- Indefinite-repetition loops
    
    - Loop controlled by a condition other than a counter
        
        - While-loops!
- Sentinel controlled loops
    
    - Mostly a type of fence post ( read N values, only process N-1)
    - Often uses a constant declaration:
- We started looking at the Random class which provides a random-number-generator object to programs

Task 1: N times  
Task 2: N-1 times  
Ex. Print N numbers and N-1 commas  
Public static final String SENTINEL = "quit";
 
- Write a program that simulates rolling 2 6 sided dice until you roll a 7
    
    - You cant roll from 2-12, you have to add 1-6 + 1-6
 
Write a program that plays an adding game  
Ask user to solve random adding problems with 2-5 numbers  
The user gets 1 point for a correct answer, 0 for incorrect  
The program stops after 3 incorrect answers  
-------------------------------------------------------------------------------------------------------------------------------  
// Asks the user to do adding problems and scores them.  
import java.util.*;   public class AddingGame {  
public static void main(String[] args) {  
Scanner console = new Scanner(System.in);  
Random rand = new Random();   // play until user gets 3 wrong  
int points = 0;  
int wrong = 0;  
while (wrong < 3) {  
int result = play(console, rand); // play one game  
if (result > 0) {  
points++;  
} else {  
wrong++;  
}  
}   System.out.println("You earned " + points + " total points.");  
}   // Builds one addition problem and presents it to the user.  
// Returns 1 point if you get it right, 0 if wrong.  
public static int play(Scanner console, Random rand) {  
// print the operands being added, and sum them  
int operands = rand.nextInt(4) + 2;  
int sum = rand.nextInt(10) + 1;  
System.out.print(sum);   for (int i = 2; i <= operands; i++) {  
int n = rand.nextInt(10) + 1;  
sum += n;  
System.out.print(" + " + n);  
}  
System.out.print(" = ");   // read user's guess and report whether it was correct  
int guess = console.nextInt();  
if (guess == sum) {  
return 1;  
} else {  
System.out.println("Wrong! The answer was " + total);  
return 0;  
}  
}  
}  
------------------------------------------------------------------------------------------------------  
The do/while loop  
Do/while loop: Performs its test at the _end_ of each repetition.  
Guarantees that the loop's {} body runs at least once.

![Guarantees that the loop's { } body will run at I do { statement(s) ; } while (test); // Example: prompt until correct password String phrase; do { System. out.print( "Type your password: phrase = console. next(); } while ( !phrase. equals( "abracadabra")); is typed ](Exported%20image%2020240525204024-0.png)   
Type boolean
 
Boolean false = 0  
Boolean true = any other number
 
Some methods return logical values

A call to such a method is used as a test in a loop or if
 ![Scanner console = new Scanner(System.in); System. out .print("Type your first name: String name = console. next( if (name. startsWith( "Dr.")) { System. out .print "Will you marry me?"); } else if (name. endsWith("Esq. { System. out .print "And I am Ted 'Theodore' Logan ! ](Exported%20image%2020240525204024-1.png) ![Strin test methods Method equals(str) equal sl gnoreCase(str) startsWith(str) endsWith(str) contains(str) Description whether two strings contain the same characters whether two strings contain the same characters, ignoring upper vs. lower case whether one contains other's characters at start whether one contains other's characters at end whether the given string is found within this one String name = console . next( if (name. contains("Prof")) { System are your office hours?" } else if (name. equalslgnorecase( "STUART")) { 's talk about meta! ](Exported%20image%2020240525204024-2.png)  

Type boolean
 
Boolean: a logical type whose values are true and false.

- A logical test is actually a boolean expression
- It is legal to:
    
    - Create a boolean variable
    - Pass a boolean value as a parameter
    - Return a boolean value from methods
    - Call a method that returns a boolean and use it as a test
    -   
        
    - ![// allow only CSE- loving students over 21 if (minor I I isprof Il ! lovesCSE) { system. out. println("can't enter the club! " ) • ](Exported%20image%2020240525204024-3.png)        
Why is type boolean useful?

- Can capture a complex logical test result and use it later
- Can write a method that does a complex test and returns it
- Makes code more readable
- Can pass around the result of a logical test (as param/return)
 ![boolean goodAge boolean goodHeight = height boolean rich = salary if ( (goodAge && goodHeight) 12 age < 29; 78 height < 84; Il rich) { System. out.println( "Okay, let's go out! J') • } else { System. out.println("lt's not you, it's me. ](Exported%20image%2020240525204024-4.png)  
![public static boolean isPrime(int n) { int factors = @ for (int i = if (n % i E)) { factors++ ; if (factors 2) { return true; } else { return false; Calls to methods returning boolean can be used as tests: if (isPrime(57)) { ](Exported%20image%2020240525204024-5.png)  

- Students new to boolean often test if a result is true:

If (isPrime(57) == true) { //BAD
 
}  
////////////////////////////////////////////////////////////////  
If (isPrime(57)) { //GOOD   }

![if if (isprime(57) false) ( ! isprime(57)) bad good ](Exported%20image%2020240525204024-6.png) ![Methods that return boolean often have an if/else that returns true or false: public static boolean bothOdd(int n1, int n2) { if (ni % 2 O n2 % 2 0) { return true; } else { return false; But the code above is unnecessarily verbose. ](Exported%20image%2020240525204024-7.png) ![We could store the result of the logical test. public static boolean bothOdd(int n1, int n2) { boolean test = if (test) { // test true return true; } else { // test false return false; Notice: Whatever test is, we want to return that. If test is true , we want to return true. If test is false, we want to return false. ](Exported%20image%2020240525204024-8.png)   !["Boolean Zen" tem late Replace public static boo lean name (parameters) { if (test) { return true; } else { return false; with public static boo lean name (parameters) { return test; ](Exported%20image%2020240525204024-9.png) !["Short-circuit" Java stops evaluating a test if it knows the answer. stops early if any part of the test is false Il stops early if any part of the test is true The following test will crash if s2's length is less than 2: // Returns true if sl and s2 end with the same two letters. public static boolean rhyme(String sl, String s2) { return sl . endsWith(s2. substring(s2. length( ) sl. length() 2 && s2. length() 2; The following test will not crash; it stops if length < 2: // Returns true if sl and s2 end with the same two letters. public static boolean rhyme(String sl, String s2) { return sl. length() 2 && s2. length() >= 2 sl . endsWith(s2. substr ing(s2 . length( ) ](Exported%20image%2020240525204024-10.png)  

De Morgan's Law
 
|   |   |   |
|---|---|---|
|Original Expression|Negated Expression|Alternative|
|A && B|!A \| !B|!(A && B)|
|A \| B|!A && !B|!(A \| B)|
 ![// Enlightened version. I have seen the true way (and false way) public static boolean isVowel(String s) { return s. equalsIgnoreCase( Il s. equalsIgnoreCase( Il s. equalsIgnoreCase( "i Il s.equa IslgnoreCase( "0") Il s. equa IslgnoreCase( "u // Enlightened "BooIean Zen" version public static boolean isNonVcwel(String s) { return // or, ! s. equalsIgnoreCase( "a") && equalsIgnoreCase( "e") equalsIgnoreCase( "i") && equalsIgnoreCase( && ! s . equa IslgnoreCase( " u") ; return ! isVowel(s); ](Exported%20image%2020240525204024-11.png) ![When to return? Methods with loops and return values can be tricky. When and where should the method return its result? Write a method seven that accepts a Random parameter and uses it to draw up to ten lotto numbers from 1-30. If any of the numbers is a lucky 7, the method should stop and return true. If none of the ten are 7 it should return fa use. The method should print each number as it is drawn. 15 29 18 29 11 3 30 17 19 22 (first call) 29 5 29 4 7 (second call) ](Exported%20image%2020240525204024-12.png) ![Flawed solution // Draws 10 lotto numbers; returns true if one is 7. public static boolean seven(Random rand) { for (int i = 1; i 10; i++) { int num = rand.nextInt(3@) + 1; System. out .print(num + " if (num == return true; } else { false; return The method always returns immediately after the first roll. This is wrong if that roll isn't a 7; we need to keep rolling. ](Exported%20image%2020240525204024-13.png) ![Returning at the right // Draws 10 lotto numbers; returns true if one is 7. public static boolean seven(Random rand) { for (int i = 1; i 10; i++) { int num = rand.nextInt(3@) + 1; System. out .print(num + " if (num 7) { // found lucky 7; can exit now return true; return false; // if we get here, there was no 7 Returns true immediately if 7 is found. If 7 isn't found, the loop continues drawing lotto numbers. If all ten aren't 7, the loop ends and we return false. ](Exported%20image%2020240525204024-14.png)

----------------------------------------------------------------------------------------------------
 ![while loop question Write a method that accepts an integer parameter and returns the sum of its digits. Assume that the number is non-negative. Example: returns 2+9+1+0+7 or 19 Hint: Use the % operator to extract a digit from a number. ](Exported%20image%2020240525204024-15.png) ![while loop answer public static int digitsum(int n) { n = Math. abs(n); int sum = E); while (n > O) { sum = sum + (n % 10); return sum; // handle negatives // add last digit // remove last digit ](Exported%20image%2020240525204024-16.png)

hasAnOddDigit : returns true if any digit of an integer is odd.   hasAnOddDigit(4822116) returns true  
hasAnOddDigit(2448) returns false     
allDigitsOdd : returns true if every digit of an integer is odd.   allDigitsOdd(135319) returns true  
allDigitsOdd(9174529) returns false     
isAllVowels : returns true if every char in a String is a vowel.   isAllVowels("eIeIo") returns true  
isAllVowels("oink") returns false
 ![Boolean return answers public static boolean hasAnOddDigit(int n) { while (n E)) { if (n % 2 // check whether last digit is odd return false; public static boolean allDigitsOdd(int n) { // check whether last digit is even return false; return true; public s atic.bool?an isAllVowel * rin tring - s. substrlnå(i, 1 1); if (!1sVowel(letter)) { return false; return true; ](Exported%20image%2020240525204024-17.png)

-----------------------------------------------------------------------------------------------------

- Assertion: a statement that is either true or false - ![Lo ical assertions assertion: A statement that is either true or false. Examples: 0 Java was created in 1995. The sky is purple. 23 is a prime number. 10 is greater than 20. 0 x divided by 2 equals 7. (depends on the value of x) An assertion might be false ("The sky is purple" above), but it is still an assertion because it is a true/false statement. ](Exported%20image%2020240525204024-18.png)
 ![Reasonung about assertions Suppose you have the following code: if (x > 3) { // point A x--; } else { // point B // point C // point D What do you know about xls value at the three points? Is x > 3? Always? Sometimes? Never? ](Exported%20image%2020240525204024-19.png) ![Assertions in code We can make assertions about our code and ask whether they are true at various points in the code. Valid answers are ALWAYS, NEVER, or SOMETIMES. system. out. a nonnegative number: double number = console. nextDouble( ) ; // point A: is number < 0.0 here? (SOMETIMES) while (number < { // point B: is number < 0.0 here? (ALWAYS) system . out. try agäin: ") number = console. nextDouble() ; // point C: // point D: is number number < 0.0 0.0 here? (SOMETIMES) here? (NEVER) ](Exported%20image%2020240525204024-20.png)