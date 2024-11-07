EXAM 2 Focuses mostly on arrays  
EXAM 2 week of April 10th (2 weeks!)
 
Building Java Programs Chapter 7: 1 dimensional Arrays
 - -------------------------------------------------------------------------------------------------------------------------------Consider the following program (input underlined): 
How many days' temperatures? **7**  
Day 1's high temp: **45**  
Day 2's high temp: **44**  
Day 3's high temp: **39**  
Day 4's high temp: **48**  
Day 5's high temp: **37**  
Day 6's high temp: **46**  
Day 7's high temp: **53**  
Average temp = 44.6  
4 days were above average.  
-------------------------------------------------------------------------------------------------------------------------------
 
This is hard to do because:  
* we need a way to declare many variables in one step.

![Arra s • array: object that stores many values of the same type. — element: One value in an array. — index: A O-based integer to access an element from an array. index 0 1 2 3 4 5 6 7 8 9 element O element 4 element 9 ](Exported%20image%2020240525204028-0.png)   
****WHEN JAVA INITIALIZES AN ARRAY, ALL ELEMENTS ARE POPULATED WITH "0", "0.0", " ", or "null", DEPENDING ON TYPE

![— Example: numbers [O] = 27 numbers [3] = -6 system. out . print ) ; if (numbers[3] < @) { system. out. 3 is negative. index 0123" 56789 ](Exported%20image%2020240525204028-1.png)  

Out-of-bounds

![• Example: int [ ] data = new int [10]; System . out . System. out . print System . out . System . out . ; index O 12345678 okay okay exception exception 9 ](Exported%20image%2020240525204028-2.png) ![Accessin arra int [ ] numbers = new int [8] elements numbers[l] numbers[4] = 99; numbers[6] numbers [1] ; int x = numbers [x] numbers[numbers[6]] = 11 ; // use numbers [6] as index x numbers 3 index value o 1 4 2 11 3 42 4 99 5 o 6 2 7 o ](Exported%20image%2020240525204028-3.png)  

Arrays and for loops

- It is common to use for loops to access array elements. 
for (int i = 0; i < 8; i++) {  
System.out.print(numbers[i] + " ");  
}  
System.out.println(); **// output: 0 4 11 0 44 0 0 2**
 - Sometimes we assign each element a value in a loop. 
for (int i = 0; i < 8; i++) {  
numbers[i] = 2 * i;  
}
 ![index 012 34567 ](Exported%20image%2020240525204028-4.png)

The length field  
it does not use parentheses like a String's .length().
 - -------------------------------------------------------------------------------------------------------------------------------Use an array to solve the weather problem: 
How many days' temperatures? **7**  
Day 1's high temp: **45**  
Day 2's high temp: **44**  
Day 3's high temp: **39**  
Day 4's high temp: **48**  
Day 5's high temp: **37**  
Day 6's high temp: **46**  
Day 7's high temp: **53**  
Average temp = 44.6  
4 days were above average.   ------------------------------------------------------------------------------------------------------------------------------  
**// Reads temperatures from the user, computes average and # days above average.**  
import java.util.*;
 
public class Weather {  
public static void main(String[] args) {  
Scanner console = new Scanner(System.in);  
System.out.print("How many days' temperatures? ");  
int days = console.nextInt();   **int[] temps = new int[days];** **// array to store days' temperatures**  
int sum = 0;
 
for (int i = 0; i < days; i++) { **// read/store each day's temperature**  
System.out.print("Day " + (i + 1) + "'s high temp: ");  
**temps[i] = console.nextInt();**  
sum += temps[i];  
}  
double average = (double) sum / days;
 
int count = 0; **// see if each day is above average**  
for (int i = 0; i < days; i++) {  
if (**temps[i]** > average) {  
count++;  
}  
}   **// report results**  
System.out.printf("Average temp = %.1f\n", average);  
System.out.println(count + " days above average");  
}  
}  
---------------------------------------------------------------
 ![uick arra type[] name = {value, — Example: int [ ] numbers — - {12, index 0 1 initialization value, 49, -2, value} 26, 5, 17, — Useful when you know what the array's elements will be — The compiler figures out the size by counting the values ](Exported%20image%2020240525204028-5.png)   
int[] a = {1, 7, 5, 6, 4, 14, 11};  
for (int i = 0; i < a.length - 1; i++) {  
if (a[i] > a[i + 1]) {  
a[i + 1] = a[i + 1] * 2;  
}  
}
   
![e ](Exported%20image%2020240525204028-6.png)

1, 7, 10, 12, 8, 14, 22
   

Limitations of arrays:
 ![The Arra s class • Class Arrays in package java. util has useful static methods for manipulating arrays: Method name Description binarysearch(array, value) returns the index of the given value in a sorted copyOf (array, length) equals (arrayl, array2) fill(array, value) sort (array) tostring(array) array (or < O if not found) returns a new copy of an array returns true if the two arrays contain same elements in the same order sets every element to the given value arranges the elements into sorted order returns a string representing the array, such as "[10, 30, -25, 17]" • Syntax: Arrays . methodName( parameters) ](Exported%20image%2020240525204028-7.png)  

Arrays.toString  
* Arrays.toString accepts an array as a parameter and returns a String representation of its elements.  
int[] e = {0, 2, 4, 6, 8};  
e[1] = e[3] + e[4];  
System.out.println("e is " + **Arrays.toString(e)**);
 
Output:  
e is [0, 14, 4, 6, 8]  
￼￼￼Must import java.util.*;
   
![Weather uestion 2 • Modify the weather program to print the following output: HOW many days' temperatures? Z Day I's high temp: 45 Day 2' s high temp: 44 Day 3' s high temp: 39 Day 4 's high temp: Day 5 's high temp: 31 Day 6 's high temp: 45 Day 7' s high temp: 53 Average temp = 44 .6 4 days were above average. Temperatures: [45, 44, 39, TWO coldest days • 37, 39 TWO hottest days • 53, 48 48, 37, 46, 53] ](Exported%20image%2020240525204028-8.png) ![Weather answer 2 // Reads temperatures from the user, computes average and * days above average. import java.util.•; public class Weather2 { public static void args) { int [l temps new int[days]; (sane as Weather program) // report results // array to store days' temperatures System. out temp = average); System .out .println(count " days above average"); System. out . print "Temperatures: ' Arrays. sort (temps) ; System. Out coldest days: System .out hottest days: Arrays. tostring(temps) ) ; " temps [G] " ' 4 temps[l]); " • temps[temps. length - ' temps[temps. Length - ](Exported%20image%2020240525204028-9.png)

Arrays as parameters
 
Swapping Values  
public static void main(String[] args) {  
int a = 7;  
int b = 35;   **// swap a with b?**  
**a = b;**  
**b = a;**   System.out.println(a + " " + b);  
}
 - What is wrong with this code? What is its output?
   

- The red code should be replaced with: 
**int temp = a;**  
**a = b;**  
**b = temp;**
 
Array Reversal Question:

- Write code that reverses the elements of an array. - For example, if the array initially stores:

[11, 42, -5, 27, 0, 89]
 - Then after your reversal code, it should store:

[89, 0, 27, -5, 42, 11]
 - The code should work for an array of any size. - Hint: think about swapping various elements...

int[] numbers = [11, 42, -5, 27, 0, 89];  
for (int i = 0; i < **numbers.length / 2**; i++) {  
int temp = numbers[i];  
numbers[i] = numbers[numbers.length - 1 - i];  
numbers[numbers.length - 1 - i] = temp;  
}
 - How do we write methods that accept arrays as parameters?
- Will we need to return the new array contents after reversal? 
￼Array parameter (declare)
 
public static **type** **methodName**(**type**[] **name**) {  

- Example:

**// Returns the average of the given array of numbers.**  
public static double average(**int[] numbers**) {  
int sum = 0;  
for (int i = 0; i < numbers.length; i++) {  
sum += numbers[i];  
}  
return (double) sum / numbers.length;  
}
 - You don't specify the array's length (but you can examine it). 
Array parameter (call)
 
**methodName**(**arrayName**);  

- Example:

public class MyProgram {  
public static void main(String[] args) {  
**// figure out the average TA IQ**  
int[] iq = {126, 84, 149, 167, 95};  
double avg = **average(****iq****)**;  
System.out.println("Average IQ = " + avg);  
}  
...  
￼Notice that you don't write the [] when passing the array.
 
Array return (call)
 
**type**[] **name** = **methodName**(**parameters**);  

- Example:

public class MyProgram {  
public static void main(String[] args) {  
int[] iq = {126, 84, 149, 167, 95};  
**int[] stuttered** **= stutter(iq);**  
System.out.println(Arrays.toString(stuttered));  
}  
...
 - Output:

[126, 126, 84, 84, 149, 149, 167, 167, 95, 95]
   

Reference Semantics
 - Does the following swap method work? Why or why not? 
public static void main(String[] args) {  
int a = 7;  
int b = 35;
 
**// swap a with b?**  
**swap(a, b);**
 
System.out.println(a + " " + b);  
}
 
**public static void swap(int a, int b) {**  
**int temp = a;**  
**a = b;**  
**b = temp;**  
**}**
 
THIS DOES NOT WORK, A AND B ARE LOCAL VALUES TO THE METHOD SWAP
   
![Reference semantics (objects) • reference semantics: Behavior where variables actually store the address of an object in memory. — When one variable is assigned to another, the object is not copied; both variables refer to the same object. — Modifying the value of one variable will affect others. int[] al = {4, 15, 8}; // refer to same array as al int [ ] a2 = al ; a2[0] = 7 System . out. printIn(Arrays. tostring(al)); // [7, 15, 8] index 2 a10—- ](Exported%20image%2020240525204028-10.png)  
![References and objects • Arrays and objects use reference semantics. Why? — efficiency. Copying large objects slows down a program. — sharing. It's useful to share an object's data among methods. Drawingpanel panel 1 = new 50); Drawingpanet pane12 = panell; // same window pane12 . setBackground(C010r . CYAN) ; 00 . panell pane12 ](Exported%20image%2020240525204028-11.png) ![Array reverse question 2 • Turn your array reversal code into a reverse method. — Accept the array of integers to reverse as a parameter. int [ ] numbers = {11, 42, -5, 27, o, 89}; reverse(numbers) ; • Solution: public static void numbers) { for (int i = @ ; i < numbers. length / 2; i++) { int temp = numbers [i]; numbers[i] = numbers[numbers. length numbers[numbers. length - 1 - i] = temp; ](Exported%20image%2020240525204028-12.png)  
![Array parameter questions • Write a method swap that accepts an array of integers and two indexes and swaps the elements at those indexes. int[] al = {12, 34, 56}; swap(al, 1, 2); System . out . pr int In(Arrays . tostring (al) ) ; // [12, 56, 34] • Write a method swapAl I that accepts two arrays of integers as parameters and swaps their entire contents. — Assume that the two arrays are the same length. int[] al = int [J a2 — swapAU(a1, {12, 34, 56}; - {20, 50, 80}; a2); System . out . pr int In(Arrays . tostring (al)) ; System . out . pr int In(Arrays . tostring (a2) ) ; // [20, // [12, 50, 34 , 80] 56] ](Exported%20image%2020240525204028-13.png) ![Array parameter answers // Swaps the values at the given two indexes . public static void swap(int[] a, int i, int j) { int temp = a[i] • = temp; // Swaps the entire contents of al with those of a2. public static void al, int [ ] a2) { for (int i = O; i < al. length; i++) { int temp - - al[i]; al[i] = a2[i]•, a2[i] = temp; ](Exported%20image%2020240525204028-14.png) ![Array return question • Write a method merge that accepts two arrays of integers and returns a new array containing all elements of the first array followed by all elements of the second. int[] al — - {12, 34, 56}; int[] a2 int[] a3 = merge(al, a2); System . out . pr int In(Arrays . tostring (a3) ) ; // [12, 34, 56, 7, 8, 9, 10] • Write a method merge3 that merges 3 arrays similarly. int[] al — - {12, 34, 56}; int[] a2 = int[] a3 = {444, 222, -1}; int[] a4 = merge3(a1, a2, a3); System . out . pr int In(Arrays . tostring (a4)) ; // [12, 34, 56, 7, 8, 9, 10, 444, 222, -1] ](Exported%20image%2020240525204028-15.png) ![Array return answer 1 // Returns a new array containing an elements of al // followed by all elements of a2. public static int [ ] merge(int[] al, int [ ] a2) { int[] result = new int [al. length + a2. length]; for (int i = o; i < al. length; i++) { result [i] - - al[i]; for (int i = o; i < a2. length; i++) { result [al. length + i] = a2[i]•, return result; ](Exported%20image%2020240525204028-16.png) ![Array return answer 2 1,' Returns a new array containing all elements of al, a2,a3. public static int[] al, int[] a2, int[] a3) { int[] a4 = new int[al. length + a2. length + a3. length] ; for (int i = 0; i < al. length; i++) { a4[i] = al[i]; for (int i = 0; i < a2. length; i++) { a4[a1. length + i] — - a2[i]; for (int i = 0; i < a3. length; i++) { a4[a1. length + a2. length + i] — - a3[i]; return a4; // Shorter version that calls merge. public static int[] al, return merge(merge(al, a2), a3); int[] a2, int[] a3) { ](Exported%20image%2020240525204028-17.png) ![A multi-counter • We could declare 10 counter variables int countero, counterl, counter2, counter5, counter6, counter7, roblem counter3, counter8, counter4, counterg; • But a better solution is to use an array of size 10. — The element at index i will store the counter for digit value i. — Example for 669260267: index 0 1 2 3 4 5 6 7 8 9 — How do we build such an array? And how does it help? ](Exported%20image%2020240525204028-18.png)  
![Creatin an arra // assume n = 669260267 int[] counts = new int[10]; while (n > 0) { of tallies // pluck off a digit and add to proper counter int digit = n % counts [digit] ++ ; index 0123456789 ](Exported%20image%2020240525204028-19.png)

Tally Solution:  
**// Returns the digit value that occurs most frequently in n.**  
**// Breaks ties by choosing the smaller value.**  
public static int mostFrequentDigit(int n) {  
int[] counts = new int[10];  
while (n > 0) {  
int digit = n % 10; **// pluck off a digit and tally it**  
counts[digit]++;  
n = n / 10;  
}   **// find the most frequently occurring digit**  
int bestIndex = 0;  
for (int i = 1; i < counts.length; i++) {  
if (counts[i] > counts[bestIndex]) {  
bestIndex = i;  
}  
}   return bestIndex;  
}   -------------------------------------------------------------------------------------------------------------------------------
 ![Arra histo ram uestion • Given a file of integer exam scores, such as: 82 66 79 63 83 Write a program that will print a histogram of stars indicating the number of students who earned each unique exam score. 85 : 86 87 : 88 91 : ](Exported%20image%2020240525204028-20.png)

**// Reads a file of test scores and shows a histogram of score distribution.**  
import java.io.*;  
import java.util.*;
 
public class Histogram {  
public static void main(String[] args) throws FileNotFoundException {  
Scanner input = new Scanner(new File("midterm.txt"));  
**int[] counts = new int[101];** **// counters of test scores 0 - 100**   while (input.hasNextInt()) { **// read file into counts array**  
int score = input.nextInt();  
**counts[score]++;** **// if score is 87, then counts[87]++**  
}   for (int i = 0; i < counts.length; i++) { **// print star histogram**  
if (**counts[i]** > 0) {  
System.out.print(i + ": ");  
for (int j = 0; j < **counts[i]**; j++) {  
System.out.print("*");  
}  
System.out.println();  
}  
}  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------
   
   

Arrays are different in Java compared to C++  
they're objects!
   

* we need each input value twice:  
* to compute the average (a cumulative sum)  
* to count how many were above average
 
* we could read each value into a variable... but we:  
* dont know how many days are needed until the prigram runs  
* dont know how many variables to declare
    
Array Declaration:  
type[] name = new type[length];
 
ex:  
int[] numbers = new int[10];  
double[] temps = new double[100];  
char[] sentence = new String[80];  
String[] page = new String[80];
   

DIFFERENT FROM BEING EMPTY
 
array declaration, contd  
the length can be any integer expression.  
int x = 2 * 3 + 1;  
int[] data = new int[x % 5 +2];

![• Each element initially gets a "zero-equivalent" value. Type int double boo lean String or other object Default value false null (means, "no object") ](Exported%20image%2020240525204028-21.png)  

Accessing elements  
name[index] //access  
name [index] = value; //modify
   

* legal indexes: between 0 and the array's length –1.  
* reading or writing any index outside this range will throw an ArrayIndexOutOfBoundException.
 
C and C++ did not have this, this is where buffer overflow attacks come from
         

* an array's length field stores its number of elements  
name.length
 
for (int i = 0; i < numbers.length; i++) {  
System.out.print(numbers[i] + " ");  
}  
//output: 0 2 4 6 8 10 12 14
   

what expressions refer to:  
the first element of an array?  
name[0]  
the last element of an array?  
name[name.length – 1]  
the middle element?  
name[name.length / 2]
          
"Array Mystery" Problem  
* traversal: an examination of each element of an array  
* what element values are stored in the following array?
         

* you cannot resize an existing array:  
int[] a = new int[4];  
a.length = 10; //error
 
* you cannot compare arrays with == or equals:  
int[] a1 = {42, -7, 1, 15};  
int[] a2 = {42, -7, 1, 15};
 
if (a1 == a2) {} //false!  
if (a1.equals(a2)) {} //false!
 
* an array does not know how to print itself:  
int[] a1 = {42, -7, 1, 15};  
System.out.println(a1); //prints a1's memory location
                        

* turn your array reversal code into a reverse method.  
* accept the array of integers to reverse as a parameter
 
int[] numbers = {11, 42, -5, 27, 0, 89};  
**reverse(numbers)**;  
                
A swap method?
          
Value semantics  
* value semantics: behavior where values are copied when assigned, passed as parameters, or returned  
* all primitive types in Java use value semantics  
* when one variable is assigned to another, its value is copied  
* Modifying the value of one variable does not affect others

![int int у = 17 у = 17 у 17 ](Exported%20image%2020240525204028-22.png)     

ARRAYS FOR TALLYING  
write a method that returns the digit value that occurs most frequently in a number.  
ties return digit with a lower value  
ex: mostFrequentDigit(669260267) returns 6