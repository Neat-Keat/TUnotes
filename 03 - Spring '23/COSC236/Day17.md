Lab tomorrow is optional  
Go for mock exam
 
Next week is the exam  
Covers:  
1x File processing  
1x String processing  
3x array programs
 
SAMPLE ARRAY PROCESSING METHODS:  
-------------------------------------------------------------------------------------------------------------------------------import java.util.*;  
public class Statistics {  
public static void main(String[] args) {  
int[] arr = {1, -2, 4, -4, 9, -6, 16, -8, 25, -10};  
System.out.println("Original Array: " + Arrays.toString(arr));  
Arrays.sort(arr);  
System.out.println("Sorted Array: " + Arrays.toString(arr));  
System.out.println("Median Element: " + median(arr)); // -2  
System.out.printf("Mean of Elements: %.3f\n", + mean(arr)); // 2.500  
System.out.printf("Standard Deviation %.3f\n", + stdev(arr, mean(arr)); //11.237  
}
 
-------------------------------------------------------------------------------------------------------------------------------  
public static int median(int[] in) {  
Arrays.sort(in);  
return in[ (int) Math.ceil(in.length/2.0) -1];  
}  
------------------------------------------------------------------------------------------------------------------------------  
public static double mean(int[] in) {  
int sum = 0  
for (int i = 0; i < in.length, i++){  
sum += in[i];  
}  
return (double) sum/in.length;  
}  
-------------------------------------------------------------------------------------------------------------------------------  
public static double stdev(int[] in, double mean) {  
double sum = 0;  
for(int i =0; i< in.length; i++) {  
sum += (in[i] - mean) * (in[i] - mean);  
}  
return Math.sqrt(sum/in.length - 1));  
}  
-------------------------------------------------------------------------------------------------------------------------------  
}
      

word counting program
 
import java.util.*;  
import java.io.*;
 
public class WordCount {  
public static void main(String[] args) throws FileNotFoundException {  
Scanner fileIn = new Scanner(new File("story.txt")); //46 words, 9 lines, 229 chars  
int lines = 0, words = 0, characters = 0; //counters
 
//loop here to analyze file  
while(fileIn.hasNextLine()) {  
String nextLine = fileIn.nextLine();  
lines++;  
Scanner lineScan = new Scanner(nextLine);  
while(lineScan.hasNext()) {  
String nextToken = lineScan.next();  
words++;  
characters += nextToken.length();  
}  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------  
to include whitespace:
 
import java.util.*;  
import java.io.*;
 
public class WordCount {  
public static void main(String[] args) throws FileNotFoundException {  
Scanner fileIn = new Scanner(new File("story.txt")); //46 words, 9 lines, 29X chars  
int lines = 0, words = 0, characters = 0; //counters
 
//loop here to analyze file  
while(fileIn.hasNextLine()) {  
String nextLine = fileIn.nextLine();  
lines++;  
characters += (nextLine.length() + 1);
 
Scanner lineScan = new Scanner(nextLine);  
while(lineScan.hasNext()) {  
String nextToken = lineScan.next();  
words++;  
}  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------
 
methods to compare arrays
 
blahblahblahblah header stuff  
System.out.println("Arrays arr1 and arr2 are " + (equals(arr1, arr2)? "equal" : "not equal"));  
System.out.println("Arrays arr1 and arr2 are " + (equalsAnyOrder(arr1, arr2)? "equal": "not equal"));  
}
 
-------------------------------------------------------------------------------------------------------------------------------  
public static boolean equals(int[] arr1, int[] arr2) {  
if(arr1.length != arr2.length)  
return false;
 
for(int i = 0; i < arr1.length; i++) {  
if(arr1[i] != arr2[i]))  
return false;  
}  
return true;  
}  
-------------------------------------------------------------------------------------------------------------------------------
 
public static boolean equalsAnyOrder(int[] arr1, int[] arr2) {
 
int[] a1 = Arrays.copyOf(arr1, arr1.length);  
int[] a2 = Arrays.copyOf(arr2, arr2.length);  
Arrays.sort(a1);  
Arrays.sort(a2);
 
return equals(a1, a2);  
}  
-------------------------------------------------------------------------------------------------------------------------------
 
import java.util.*;  
public class SortedOrder {  
public static void main(String[] args) {  
int[] arr1 = {1, 2, 3, 4, 5, 6};  
int[] arr2 = {6, 5, 4, 3, 2, 1};  
int[] arr3 = {1, 2, 3, 4, 12, 6};
 
isSorted(arr1); //sorted ascending  
isSorted(arr2); //sorted descending  
isSorted(arr3); //not sorted
   

}
 
public static void isSorted(int[] arr) {  
if(isSortedAscending(arr))  
System.out.println("Array is sorted in ascending order");  
else if (isSortedDescending(arr))  
System.out.println("Array is sorted in descending order");  
else  
System.out.println("Array is NOT in sorted order");  
}
 
public static boolean isSortedAscending(int[] arr) {  
for(int i = 0; i < arr.length - 1; i++) {  
if(arr[i] > arr[i+1])  
return false;  
}  
return true;  
}
 
public static boolean isSortedDescending(int[] arr) {  
for(int i = 0; i < arr.length - 1; i++) {  
if(arr[i] < arr[i+1])  
return false;  
}  
return true;