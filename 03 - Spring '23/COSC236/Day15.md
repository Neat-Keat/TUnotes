Building Java Programs Chapter 7: Contains method
 
- For method: contains(int[] arr1, int[] arr2) the method will test to see if arr1 contains arr2 in its entirety and in the same order

-------------------------------------------------------------------------------------------------------------------------------  
//prints the number of times each digit appears in a long number.
 
import java.util.*  
public class TallyDigits{
 
public static void main(String[] args) {  
tallyDigits(1123599976);  
}
 
public static void tallyDigits(long input {  
int[] digits = new int[10];  
while(input >0) {  
int nextDigit = input %10; //capture last digit of input  
digits[nextDigit]++; //increment index location of nextDigit  
input /= 10; //destroy last digit of input  
}  
System.out.println(Arrays.toString(digits));  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------  
//compares 2 arrays and returns true if array 1 contains array 2
 
import java.util.*;  
public class Contains {  
public static void main(String[] args) {  
int[] list1 = {1, 6, 2, 1, 4, 1, 2, 1, 8};  
int[] list2 = {1, 2, 1};  
System.out.println("list 1 = " + Arrays.toString(list1));  
System.out.println("list 2 = " + Arrays.toString(list2));  
if contains(list1, list2)){  
System.out.println("list 2 is contained in list 1");  
} else {  
System.out.println("list 2 is NOT contained in list 1");  
}  
}
 
public static boolean contains(int[] arr1, int[] arr2) {  
for(int i = 0; i <= arr1.length - arr2.length; i++) { //optimize length of search  
int matched = 0;  
for(int j = 0; j < arr2.length; j++) {  
if(arr1[i+j] == arr2[j]) // each match, increment counter  
matched++;
 
if(matched == arr2.length)  
return true;  
}  
}  
return false;  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------  
//compares 2 arrays and returns the index where array 1 contains array 2, else returns -1
 
import java.util.*;  
public class Contains2 {  
public static void main(String[] args) {  
int[] list1 = {1, 6, 2, 1, 4, 1, 2, 1, 8};  
int[] list2 = {1, 2, 1};  
System.out.println("list 1 = " + Arrays.toString(list1));  
System.out.println("list 2 = " + Arrays.toString(list2));  
if (contains2(list1, list2) >= 0) {  
System.out.println("list 2 is contained in list 1 at index " + contains2(list1, list2));  
} else {  
System.out.println("list 2 is NOT contained in list 1");  
}  
}
 
public static boolean contains(int[] arr1, int[] arr2) {  
for(int i = 0; i <= arr1.length - arr2.length; i++) { //optimize length of search  
int matched = 0;  
for(int j = 0; j < arr2.length; j++) {  
if(arr1[i+j] == arr2[j]) // each match, increment counter  
matched++;
 
if(matched == arr2.length)  
return true;  
}  
}  
return false;  
}  
}  
--------------------------------------------------------------------------------------------------------------------------------------------------  
/* write a method named percentEven that accepts an array of integers as a parameter and returns the percentage of even numbers in the array as a real number. For example, if a variable named nums refers to an array of the elements {6, 2, 9, 11, 3}, then the call of percentEven(nums) should return 40.0. If the array contains no even elements or no elements at all, return 0.0. */
 
public class PercentOfEvens {
 
public static void main(String[] args) {  
int[] arr1 = {2, 7, 14, 21, 55, 12, 111};  
System.out.printf("Percent of even numbers is: %.2f", percentEvens(arr1) ); //returns to 2 decimals  
}
 
public static double percentEvens(int[] arr) {  
if arr.length <1)  
return 0.0;  
else {  
int evenCount = 0;  
for(int index = 0; index < arr.length; index++) {  
if(arr[index] % 2 == 0)  
evenCount++;  
}  
if(evenCount == 0)  
return 0.0;  
else  
return ((double)evenCount/arr.length) *100; //typecast evenCount so you dont get 0  
}  
}  
}  
--------------------------------------------------------------------------------------------------------------------------------------------------  
/* Write a method named equals that accepts 2 arrays of integers as parameters and returns true if they contain exactly the same elements in the same order, and false otherwise. Note that the arrays might not be the same length; if the lengths differ, return false. Do not call Arrays.equals in your solution. */
 
import java.util.*;
 
public class Equals {  
public static void main(String[] args) {  
int[] list1 = [1, 2, 1, 1, 4, 1, 2, 2, 8};  
int[] list2 = {1, 2, 1};  
System.out.println("list 1 = " + Arrays.toString(list1));  
System.out.println("list 2 = " + Arrays.toString(list2));  
if( equals(list1, list2)){  
System.out.println("list 2 equals list 1");  
} else {  
System.out.println("list 2 DOES NOT equal list 1");  
}  
}
 
public static boolean equals(int[] arr1, int[] arr2) {  
if(arr1.length != arr2.length)  
return false;  
else {  
for(int i = 0; i < arr1.length; i++) {  
if(arr1[i] != arr2[i])  
return false;  
}  
return true;  
}  
}  
}  
--------------------------------------------------------------------------------------------------------------------------------------------------  
/* Write a method named minGap that accepts an integer array as a parameter and returns the minimum 'gap' between adjacent values in the array. The gap between 2 adjacent values in an array is defined as the second value minus the first value. For example, suppose a variable called array is an array of integers that stores the following sequence of values: */
 
import java.util.*;
 
public class MinGap {
 
public static void main(String[] args) {  
int[] arr1 = {2, 7, 14, 21, 55, 12, 111};  
System.out.println("The minimum gap is: " + minGap(arr1));  
}
 
public static int minGap(int[] arr) {  
if(arr.length < 2)  
return 0;  
else {  
int min = Math.abs(arr1[1] - arr1[0]);  
for(int i = 0; i < arr.length - 1; i++) {  
if(Math.abs(arr[i + 1] - arr[i]) < min)  
min = Math.abs(arr[i + 1] - arr[i]);  
}  
}  
return min;  
}  
}  
--------------------------------------------------------------------------------------------------------------------------------------------------  
Array Security – Buffer Overflow, OoB
 
1. Mind your Indices!  
1. Validate your input. Always check values that are input as an array index.  
2. Check your loops! Especially watch the limit, beware of off-by-one errors.  
3. Check any methods that may modify an ad=rray index.
 
2. Make sure you have enough space: Before copying data to a fixed size block, make sure it is large enough to hold the data that you are going to copy.
 
3. Validate indices: If you have an integer variable, verify that it is within the proper bounds before you use it as an index.....
    
Try Catch Blocks
 
while(inputFile.hasNext()) {  
if(inputFile.hasNextInt() {  
num = in.............................
    
For-Each loops
 
- Useful to INSPECT single dimension arrays  
* provides secure access to an array without allowing arrya elements to be changed  
* optimized looping structure  
* cannot be used when you need to modify the array or array elements or with multi-dimensional arrays
 
int arr = { ................................