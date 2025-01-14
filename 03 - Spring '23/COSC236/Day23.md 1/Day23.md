Building Java Programs Chapter 12: Recursion
 
Recursion: the definition of an operation in terms of itself

- Solving a problem using recursion depends on solving smaller occurrences of the same problem
 
* recursive programming: writing methods that call themselves to solve problems recursively  
An equally powerful substitute for _iteration_ (loops)  
Particularly well-suited to solving certain types of problems
 
Why learn recursion?  
* "cultural experience" - A different way of thinking of problems  
* can solve some kinds of problems easier than iteration  
* leads to elegant, simplistic, short code (when used well)  
* many programming languages ("functional" languages such as Scheme, ML, and Haskell) use recursion exclusively (no loops)  
* a key component of later chapters of our class textbook
 
Exercise  
* number of people behind me:  
If there is someone behind me, ask them how many people are behind them  
When they say N, I answer N+1  
If there is no one behind me, I answer 0
 
Recursion and cases  
* Every recursive algorithm involves at least 2 cases:  
* base case: a simple occurrence that can be answered directly  
* Recursive case: a more complex occurrence of the problem that cannot be directly answered, but can instead be descrived in terms of smaller occurrences of the same problem
 
* some recursive algorithms have more than one base or recursive case, but all have at least one of each  
* a crucial part of recursive programming is identifying these cases
 
Another recursive task  
* how can we remove exactly half of the M&Ms in a large bowl, withoud dumping them all out or being able to count them?  
What if multiple people help out with solving the problem?  
Can each person do a small part of the work?
 
What is a number of M&Ms that is easy to double, even if you cant count?  
HINT: each person remove 2 and when empty, put 1 back
 
-------------------------------------------------------------------------------------------------------------------------------  
Recursion in Java  
* consider the following method to print a line of * characters:
 
//Prints a line containing the given number of stars/  
//precondition: n >= 0  
public static void printStars(int n) {  
for (int i = 0; i < nl; i++) {  
System.out.print("*");  
}  
System.out.println(); // end the line of output  
}
 
* write a recursive version of this method ( that calls itself)  
solve the problem without any loops  
hint: your solution should print just one star at a time.
 ![Using recursion properly • Condensing the recursive cases into a single case: public static void printstars(int n) { if (n 1) { // base case; just print one star system. out . print " * " ) } else { // recursive case; print one more star system. out . print( printstars(n - 1); ](Exported%20image%2020240525204037-0.png) !["Recursion Zen" • The real, even simpler, base case is an n of O, not 1: public static void printstars(int n) { if (n O) { // base case; just end the line of output system. out . println(), } else { // recursive case; print one more star system. out . print( printstars(n - 1); ](Exported%20image%2020240525204037-1.png)  
![Recursive tracing • Consider the following recursive method: public static int mystery(int n) { if (n < 10) { return n; int a = n / 10; int b = return mystery(a + b) — What is the result of the following call? mystery(648) ](Exported%20image%2020240525204037-2.png) ![A recursive trace mystery(648) : • int a = 648 / 10; . int b = 648 % 10; • return mystery(a m ster 72 • int a = 72 / 10; • int b = 72 % 10; • return mystery(a mystery(9): • return 9; b); // 64 // mystery(72) // mystery(9) ](Exported%20image%2020240525204037-3.png) ![Recursive tracing 2 • Consider the following recursive method: public static int mystery(int n) { if (n < 10) { return (10 * n) + n; int a = mystery(n / 10); int b = mystery(n % 10), return (100 * a) + b; — What is the result of the following call? mystery(348) ](Exported%20image%2020240525204037-4.png) ![A recursive trace 2 mystery(348) • int a = mystery(34) ; •int a = m ster 3 (10 return • int b = mystery(4); (10 * 4) + 4; return • return . int b = re urn // 33 // 44 * 33) + 44; // 3344 mystery(8) ; - return * 3344) + 88; — What is this method really doing? // 334488 ](Exported%20image%2020240525204037-5.png)  

Exercise:  
write a mecursive method pow accepts an integer base and exponent and returns the base raised to that exponent  
ex: pow(3,4) returns 81
 
solve the problem recursively and without using loops
 
**// Returns base ^ exponent.**  
**// Precondition: exponent >= 0**  
public static int pow(int base, int exponent) {  
if (exponent == 0) {  
**// base case; any number to 0th power is 1**  
return 1;  
} else {  
**// recursive case: x^y = x * x^(y-1)**  
return base * pow(base, exponent - 1);  
}  
}
 ![Exercise • Write a recursive method printBinary that accepts an integer and prints that number's representation in binary (base 2). — Example: pripgpgpery(7) prints 111 — Example: prints 1100 — Example: rintBinar (42) prints 101010 place 10 1 32 16 8 4 2 1 — Write the method recursively and without using any loops. ](Exported%20image%2020240525204037-6.png)  
![Case analysis • Recursion is about solving a small piece of a large problem. — What is 69743 in binary? • Do we know anything about its representation in binary? — Case analysis: • What is/are easy numbers to print in binary? • Can we express a larger number in terms of a smaller number(s)? — Suppose we are examining some arbitrary integer N. • if N's binary representation is 10010101011 • (N / 2) 's binary representation is 1001010101 • (N % 2) 's binary representation is 1 ](Exported%20image%2020240525204037-7.png) ![printBinary solution // Prints the given binary representation . // Precondition: n O public static void n) { if (n < 2) { // base case; same as base 10 system. out . print In(n); // recursive case; break number apart printBinary(n / 2); — Can we eliminate the precondition and deal with negatives? ](Exported%20image%2020240525204037-8.png)

this can lead to a bad time for your cpu  
a large enough call turns 1 call into 2 into 4 into 8 into 16 simultaneous calls
 ![Exercise • Write a recursive method isPalindrome accepts a String and returns true if it reads the same forwards as backwards. - ispalindrome( "madam") — true - ispalindrome("racecar") — true - ispalindrome("step on no pets") true - ispalindrome("able was I ere I saw elba") - ispalindrome( — false - ispalindrome("rotater") fa Ise - ispalindrome( "byebye") — false - ispalindrome( "notion") — false — true ](Exported%20image%2020240525204037-9.png)

**// Returns true if the given string reads the same**  
**// forwards as backwards.**  
**// Trivially true for empty or 1-letter strings.**  
public static boolean isPalindrome(String s) {  
if (s.length() < 2) {  
return true; **// base case**  
} else {  
char first = s.charAt(0);  
char last = s.charAt(s.length() - 1);  
if (first != last) {  
return false;  
} **// recursive case**  
String middle = s.substring(1, s.length() - 1);  
return isPalindrome(middle);  
}  
}
 
**// Returns true if the given string reads the same**  
**// forwards as backwards.**  
**// Trivially true for empty or 1-letter strings.**  
public static boolean isPalindrome(String s) {  
if (s.length() < 2) {  
return true; **// base case**  
} else {  
return s.charAt(0) == s.charAt(s.length() - 1)  
&& isPalindrome(s.substring(1, s.length() - 1));  
}  
}
 ![Exercise • Write a recursive method reverseLines that accepts a file Scanner and prints the lines of the file in reverse order. — Example input file: Expected console output: Roses are red, Are belong to you. Violets are blue. Il my base All my base Violet are blue. Are belong to you. oses are red, — What are the cases to consider? • How can we solve a small part of the problem at a time? • What is a file that is very easy to reverse? ](Exported%20image%2020240525204037-10.png)

Reversal pseudocode  
* reversing the lines from a file:  
* read a line L from the file  
*Print the resot of the lines in reverse order  
*Print the line L
 
*If only we had a way to reverse the rest of the lines of the file...
 ![Reversal solution public static void reverseLines(Scanner input) { if (input.hasNextLine()) { // recursive case String line = input . nextLine( ) ; reverseLines(input) ; System . out . print line); — Where is the base case? ](Exported%20image%2020240525204037-11.png)  
![Tracing our algorithm • call stack: The method invocations running at any one time. reverseLines(new Scanner( "poem. txt" ) ) ; public if public if public if public if public if static void reverseLines(Scanner (inpyt . hasNextL1he static void reverseLines(Scanner (input . hasNextL4ne()) C static void reverseLines(Scanner (inpyt . hasNektL4ne ( static void reverseLines(Scanner (inpyt . hasNextL4ne static void reverseLines(Scanner input) input) input) input) input) (input . hasNextLihéC)YT- // false Violets are All my base blue . Are belong to Ill •my base Violets are blue. ](Exported%20image%2020240525204037-12.png)   ![Recursively defined functions • Factoral factoral(l) = 1 factoral(2) = 1+2=2 factoral(3) factoral(N) = N * factoral(N-1) | 1 for n = 1 factoral(n) = I n * factoral(n-l) otherwise • public static int factoral(int n) { if(n 1) return 1; else return n* factoral(n — 1); ](Exported%20image%2020240525204037-13.png) ![Recursive Sequences • Fibonacci: 0 1 1 2 3 5 8 13 21 34 fib(l) O fib(2) = 1 fib(N) = fib(N-1) + fib(N-2) I Oforn=l | 1 for n = 2 base case 1 base case 2 recursive case I fib(n-l) + fib(n-2) otherwise • public static int fib(int term) { if(term 1) return O; else if(term 2) return 1; else return fib(n-l) + fib(n-2); ](Exported%20image%2020240525204037-14.png) ![Tail Recursion • public static int factoral(int n) { // Tail recursive if(n 1) return 1; else return n factoral(n — 1); • public static int fib(int term) { // non-tail recursive if(term 1) return O; else if(term 2) return 1; else return lb(n-l) + fib(n-2); ](Exported%20image%2020240525204037-15.png) ![Pascal's Triangle https://wvwv.youtube.com/watch?v=YUqHdxxdbyM 1 1 1 121 1331 1 46 41 1 5 1010 5 1 1 6 1520 15 6 1 1 7 21 35 3521 7 1 • First and last entries in each row are 1 • Middle index (i) entries are the sum of entries (i-l and i) from the previous row ](Exported%20image%2020240525204037-16.png) ![Tower of Hanoi (game) http://www.cs.armstrong.edu/liang/animation/web/TowerOfHanoi.html •For 1 disk on peg A, just move to peg B (1 move) •For 2 disks, move top to peg C, second to peg B, and first disc from C to B (3 moves) •For 3 disks, move 2 disks to peg B, bottom disk to peg C and move top 2 disks to peg C (7 moves) •For N disks, move N-l disks to another peg, move bottom peg to the remaining peg and move N-l disks back on top (will take 2 * moves needed for N-l disks + 1) ](Exported%20image%2020240525204037-17.png)  

what makes something tail recursive?
   

RecursionExamples.java on bb??
 
anything that can be written as a loop can be written recursively  
anything that can be written recursively can be written as a loop