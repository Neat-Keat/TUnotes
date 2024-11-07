sample problems that cover same areas that you might see on exam 2  
this thursday!! during lab  
2 hours, 5 problems
 
class on wed is optional, it covers questions abt the mock exam  
1) file processing  
2) string processing  
3) array processing (largest part!)
 
1) Write a static method replaceChars that accepts a Scanner containing an input file as 1 param and 2 other char params. The 1st is the taget char to be replaced. The 2nd is the replacement char. The method should create a new output file "out.txt" where the original file contents are copied, except all target characters are replaced with the replacement character. The formatting of the output file should be identical to the original file.
 
MAKE SURE YOU SAFE .TXT FILES TO YOUR WORKING DIRECTORY, UNDER YOUR NAMED FOLDER
 
-------------------------------------------------------------------------------------------------------------------------------
 
import java.util.*;  
import java.io.*;
 
public class ReplaceChar{
 
public static void main(String[] args) throws FileNotFoundException{  
File myFile = new File("text.txt");  
Scanner in = new Scanner(myFile);  
replaceChar(in, 'o', 'x');  
}
 
public static void replaceChar(Scanner inFile, char oldChar, char newChar) throws FileNotFoundException {  
PrintStream outFile = new PrintStream(new File("out.txt"));  
while(inFile.hasNextLine()){  
String nextLine = inFile.nextLine();  
nextLine = nextLine.replace(oldChar, newChar);  
outFile.println(nextLine);  
}  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------
 
2) Array Programming  
Write a static method isVegan that takes an array of Strings as a parameter and that returns a boolean value indicating whether or not its vegan  
Where a fruit is any of [apple banana orange pear avocado peach]  
Where a veggie is [beans carrots broccoli cauliflower potato]  
where a pasta is any of [spaghetti rice ravioli ziti]  
-------------------------------------------------------------------------------------------------------------------------------
 
public class Vegan {
 
public static void main(String[] args) {  
String[] shopList1 = {"apple", "potato", "carrot", "ziti"};  
if(isVegan(shopList1)){  
System.out.println("List1 is vegan");  
} else {  
System.out.println("List1 is NOT vegan");  
}  
String[] shopList2 = {"pear", "broccoli", "rice", "eggs"};  
if(isVegan(shopList1)){  
System.out.println("List1 is vegan");  
} else {  
System.out.println("List1 is NOT vegan");  
}  
}
 
public static boolean isVegan(String[] list) {  
String fruits = "apple banana orange pear avocado peach";  
String veggies = " beans carrots broccoli cauliflower potato";  
String pasta = "spaghetti rice ravioli ziti";
 
for(int i = 0; i < list.length; i++){  
String nextItem = list[i];  
if(!(fruits.contains(nextItem) || veggies.contains(nextItem) ||  
pasta.contains(nextitem))){  
return false;  
}  
}  
return true;  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------
 
3) Array Programming  
Write a static method named isSortedByLength
 
-------------------------------------------------------------------------------------------------------------------------------
 
public class LengthSort {  
public static void main(String[] args){  
String[] list1 = {"Hi", "lo", "low", "yoyo", "help"};  
String[] list2 = {"Hi", "lo", "low", "yoyo", "help", "hip"};  
System.out.println(isSortedByLength(list1));  
System.out.println(isSortedByLength(list2));  
}
 
public static boolean isSortedByLength(String[] list) {  
for(int i = 0; i < list.length - 1; i++) {  
if(list[i].length() > list[i+1].length())  
return false;  
}  
return true;  
}  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------  
4) array programming  
Write a static method named partitionByLength that accepts a String array as its parameter and which creates 2 new arrays composed of the Strings that have even and odd length from the original array. just print it lol, dont return it.
 
-------------------------------------------------------------------------------------------------------------------------------  
import java.util.*;  
public class LengthPartition{
 
public static void main(String[] args) {  
String[] list = {"Hi", "Low", "Low", "yoyo", "Helps", "Yelps"};  
partitionByLength(list);  
}
 
public static void partitionByLength(String[] list) {  
int evens = 0;  
for(int i = 0; i < list.length; i++) {  
if(list[i].length() % 2 == 0)  
evens++;  
}  
String[] evenStrings = new String[evens];  
String[] oddStrings = new String[list.length - evens];
 
int evenIndex = 0, oddIndex = 0;  
for(int i = 0; i < list.length; i++) {  
if(list[i].length() % 2 == 0){  
evenStrings[evenIndex] = list[i];  
evenIndex++;  
} else {  
oddStrings[oddIndex] = list[i]  
oddIndex++;  
}  
}  
System.out.println(Arrays.toString(list));  
System.out.println(Arrays.toString(evenStrings));  
System.out.println(Arrays.toString(oddStrings));
 
}  
}  
-------------------------------------------------------------------------------------------------------------------------------
 
import java.util.*;  
public class RemoveDuplicates {  
public static void main(String[] args) {  
int[] arr1 = { 14, 7, 63, 1, 7, 7, 88, -15, 44, 9, 63};  
int[] arr2 = { 7, 7, 7, 7, 7};  
int[] arr3 = removeDups(arr1);  
int[] arr4 = removeDups(arr2);  
System.out.println(Arrays.toString(arr1));  
System.out.println(Arrays.toString(arr2));  
System.out.println(Arrays.toString(arr3));  
System.out.println(Arrays.toString(arr4));  
}
 
public static int[] removeDups(int[] arr) {  
int[] arrCopy = Arrays.copyOf(arr, arr.length);  
Arrays.sort(arrCopy);  
int duplicates = 0;  
for(int i = 0; i < arr.length - 1; i++){  
if(arrCopy[i] == arrCopy[i+1])  
duplicates++;  
}  
if(duplicates ==0){  
return arr;  
} else {  
int[] retArr = new Arr[arrCopy.length - duplicates];  
int retArrIdx = 1;  
retArr[0] = arrCopy[0];  
for(int i = 1; i < arrCopy.length; i++) {  
if(arrCopy[i] != arrCopy[i - 1]) {  
retArr[retArrIdx = arrCopy[i];  
retArrIdx++;  
}  
}  
}  
return retArr;  
}