Building Java Programs Chapter 5
   

A deceptive problem

- Write a method printNumbers that prints each number from 1 to a given maximum, separated by commas
 
- Fence Post analogy
    
    - We print n numbers but only need n-1 commas
    - Fencepost loop
        
        - Add a statement outside the loop to place the initial post

-------------------------------------------------------------------------------------------------------------------------------  
Public static void printNumbers(int max){  
System.out.print(1);  
For (int I = 2; I <= max; I++){  
System.out.print("," + I);  
}  
System.out.println();  
}  
------------------------------------------------------------------------------------------------------------------------------

![Fencepost answer // Prints a It prime numbers up to the iven max. public static void printPrimes(int max; { if (max 2) { System. out . print( "2"); for (int i 3; 1 <= max; i++) { if (countFactors(i) = 22 { System. out . print( " , System. out . println(); // Returns how many factors the given number has. public static int countFactors(int number) { int count for (int i 1; i <= number; i++) { If (number % i count +4 ; // i is a factor of n Imber return count; ](SEM2/COSC236/Day8.md%201/Exported%20image%2020240525204023-0.png)

While Loops

- Definite loop: executes a known number of times
    
    - The for loops we have seen are definite loops
        
        - Print "hello" 10 times
        - Find all primes up to an integer N
        - Print each odd number between 5 and 127
- Indefinite loop: one where the number of times its body repeats is not known in advance
    
    - Prompt the user until they type a non-negative number
    - Print random numbers until a prime is printed
    - Repeat until the user types q to quit
 ![The while loo • while loop: Repeatedly executes its body as long as a logical test is true. while (test) { statement(s) ; • Example: int num = 1; while (num <= 200) { System. out.print(num + ' num = num * 2; // output: 1 2 4 8 16 32 64 init ia Liz at ion test update 128 ](SEM2/COSC236/Day8.md%201/Exported%20image%2020240525204023-1.png)  
![Exam le while loo // finds the first factor of 91, other than 1 int n = 91 int factor = 2 while (n % factor != O) { factor ++ ; "First factor is " // output: First factor is 7 + fact O r ) ; — while is better than for because we don't know how many times we will need to increment to find the factor. ](SEM2/COSC236/Day8.md%201/Exported%20image%2020240525204023-2.png)

Sentinel Values

- Sentinel: a value that signals the end of user input
    
    - Sentinel loop: repeats until a sentinel value is seen
- Ex: write a program that prompts the user for numbers until the user types 0, then outputs their sum (0 = sentinel)
-   
    
- ![Enter a Enter a Enter a Enter a The sum number number number number is 60 to to to to quit): quit): quit): quit): 10 20 30 ](Exported%20image%2020240525204023-3.png)
- WRONG
- ![Scanner console = new Scanner int sum = @ int number = 1 // 'J dummy va , anything but O while (number ! — "Enter a number (E) to quit): " number = ; sum = sum + number; total is + sum); ](Exported%20image%2020240525204023-4.png)
-   
    
- ![A fencepost solution sum = O. prompt for input; read input. while (input is not the sentinel) { add input to the sum. prompt for input; read input. //p/ace a "post" //p/ace a "wire" //p/ace a "post" • Sentinel loops often utilize a fencepost "loop-and-a- half" style solution by pulling some code out of the loop. ](Exported%20image%2020240525204023-5.png)
- RIGHT
- ![Correct sentinel code Scanner console = new Scanner int sum = E); // pun one prompt/read ("post") out "Enter a number (-1 int number = qeosgwneunx(); while (number ! = sum + number; // moved sum = "Enter a number number = ; total is of the loop to quit): ' to top of loop (-1 to quit): sum); ](Exported%20image%2020240525204023-6.png)
-   
    
- ![Sentinel as a constant public static final int SENTINEL = -1; Scanner console = new Scanner (System. in); int sum = E); // pun one prompt/read ("post") out of the loop System. out.print( "Enter a number + SENTINEL + to quit): int number = console.nextlnt(); while (number SENTINEL) { sum = sum + number; // moved to top of loop System. out.print( "Enter a number (" + SENTINEL + to quit): number = console. nextlnt(); System. out.println( "The total is ' + sum); ](Exported%20image%2020240525204023-7.png)
    
RANDOM NUMBERS
 
The Random Class

- A Random object generates pseudo-random numbers.
    
    - Class Random is found in the java.util package.
    
    Import java.util.*;
    

|   |   |
|---|---|
|Method name|Description|
|NextInt()|Returns a random integer|
|NextInt(max)|Returns a random integer in the range [0, max) ( 0 to max- 1 inclusive)|
|NextDouble()|Returns a random real number in the range [0.0, 1.0)|
 
- Ex:
    
    - Random rand = new Random();
    - Int randomNumber = rand.nextInt(10); //0-9
 
Generating random numbers

- Common usage: to get a random number from 1 – n
    
    - Int n = rand.nextInt(20)+1; //1-20 inclusive
- To get a number in arbitrary range [min, max] inclusive:
    
    - Name.nextInt(size of range) + min
        
        - Where (size of range) is (max – min + 1)
- Ex: a random int between 4 and 10 inclusive:
    
    - Int n = rand.nextInt(7)+4;
   

Random rand = new Random();   A random number between 1 and 47 inclusive?  
int random1 = rand.nextInt(47) + 1;     
A random number between 23 and 30 inclusive?  
int random2 = rand.nextInt(8) + 23;     
A random even number between 4 and 12 inclusive?  
int random3 = rand.nextInt(5) * 2 + 4;
 ![• Any set of possible values can be mapped to integers — code to randomly play Rock-paper-scissors: int r = rand. nextInt(3); if (r O) { system . out . pr int In ( " Rock"); } else if (r 1) { system . out . pr int In ( " paper" ) ; } else { // r 2 system . out . pr int In ( " scis sor s" ) ; ](Exported%20image%2020240525204023-8.png)