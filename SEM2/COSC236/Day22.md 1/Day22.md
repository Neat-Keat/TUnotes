Building Java Programs Chapter 10  
arrayList
 
exercise

- write a program that reads a file and displays the words of that file as a list
    
    - first display all words
    - then remove all duplicate words and display the new list
- should we solve this problem using an array?
    
    - why/why not?
 ![Static array solution String[] allWords = new String[1000] ; int wordCount = 0; scanner input = new scanner (new txt")); while (input .hasNext()) { String word = input . next(); wordCount++ ; scanner input2 = new scanner (new txt")) while (input2.hasNext()) { String word = input2. next(); aUWords[wordCount] = word; • Removing duplicates is even more complicated ](Exported%20image%2020240525204036-0.png)

THIS IS A NONSENSE APPROACH LMFAO
   

Java Collections – ArrayList

- Collection: an object that stores data; (data structure)
    
    - the objects stored are called **elements**
    - typical operations:
        
        - add
        - remove
        - clear
        - contains(search)
        - size
    - all collections are in the java.util package
        
        - import java.util.*;
- ArrayList
    
    - the list object keeps track of the element values that have been added to it, their order, indexes, and its total size
    - think of an "array list" as an automatically resizing array object
    - internally, the list is implemented using an array and a size field
   

ArrayList methods 1
 
|   |   |
|---|---|
|add(value)|appends value at end of list|
|add(index, value)|inserts given value just before the given index, shifting subsequent values to the right|
|clear()|removes all elements of the list|
|indexOf(value)|returns first index where given value is found in list (-1 if not found)|
|get(index)|returns the value at given index|
|remove(index)|removes/returns value at given index, shifting subsequent values to the left|
|set(index, value)|replaces value at given index with a new value|
|size()|returns the number of elements in list|
|toString()|returns a string representation of the list such as "(3, 42, -7, 15)"|

![ArrayList methods 2 addA11(1ist) addAII(index, list) contains(value) containsAll(list) equals (list) lastlndexOf(value) remove (value) removeAll(list) retainAll(list) subList(from, to) toArray() adds all elements from the given list to this list (at the end of the list, or inserts them at the given index) returns true if given value is found somewhere in this list returns true if this list contains every element from given list returns true if given other list contains the same elements returns last index value is found in list (-1 if not found) finds and removes the given value from this list removes any elements found in the given list from this list removes any elements not found in given list from this list returns the sub-portion of the list between indexes from (inclusive) and to (exclusive) returns the elements in this list as an array ](Exported%20image%2020240525204036-1.png) ![Type Parameters (Generics) ArrayList<Type> name = new ArrayList<Type>(); • When constructing an ArrayList, you must specify the type of elements it will contain between < and >. — This is called a type parameter or a generic class. — Allows the same Ar rayList class to store lists of different types. ArrayList<String> names = new ) ; names. add( "Marty Stepp"); names. add( "Stuart Reges"); ](Exported%20image%2020240525204036-2.png) ![ArrayList vs. array • construction String[] names = new String[5]; ArrayList<String> list = new ArrayList<String>(); • storing a value names [O] = "Jessica"; list . add( "Jessica" ) ; • retrieving a value String s = names ; String s = list. get (O); ](Exported%20image%2020240525204036-3.png) ![ArrayList vs. array 2 • doing something to each value that starts with "B" for (int i = @ ; i < names. length; i++) { if (names [i] . startsWith("B")) { for (int i = O; i < list. size(); i++) { if (list. get (i) . startsWith( "B")) { • seeing whether the value "Benson" is found for (int i = @ ; i < names. length; i++) { if (names [i] . equals( "Benson")) { if (list. contains( "Benson")) { ](Exported%20image%2020240525204036-4.png)   
Exercise, revisited

- Write a program that reads a file and displays the words of that file as a list
    
    - first display all words
    - then display them in reverse order
    - then display them with all plurals (ending in "s") capitalized
    - then display them with all plural words removed
 ![Exercise solution (partial) = new ArrayList<String>(); ArrayList<String> altwords scanner input = new scanner (new File( "words. txt" ) ) , while (input.hasNext()) { String word = input . next(); aUWords . add(word) ; system . out . print In (al twords) ; // remove all plural words for (int i = O; i < allwords.size(); i++) { String word = altwords.get(i), if (word. { allWords. remove(i); i--; // 0 THIS IS IMPORTANT!!! ](Exported%20image%2020240525204036-5.png)  

ArrayList of primitives?

- the type you specify when creating an ArrayList must be an object type; it cannot be a primitive type
    
    - //illegal -- int cannot be a type parameter
    - ArrayList<int> list = new ArrayList<int>();
      
    
- But we can still use ArrayList with primitive types by using special classes called _wrapper_ classes in their place
    
    - //creates a list of ints
    - ArrayList<Integer> list = new ArrayList<Integer>();
   

|   |   |
|---|---|
|Primitive Type|Wrapper Type|
|int|Integer|
|double|Double|
|char|Character|
|boolean|Boolean|

- a wrapper is an object whose sole purpose is to hold a primitive value
- Once you construct the list, use it with primitives as normal:

ArrayList<Double> grades = new ArrayList<Double>();  
grades.add(3.2);  
grades.add(2.7);  
…  
double myGrade = grades.get(0);  

![The compareTo method (10.2) • The standard way for a Java class to define a comparison function for its objects is to define a compareTo method. — Example: in the String class, there is a method: public int compareT0(String other) •A call of A. compareTo(B) will return: a value < O if A comes "before" B in the ordering, a value > O if A comes "after" B in the ordering, or O if A and B are considered "equal" in the ordering. ](Exported%20image%2020240525204036-6.png) ![Using compareTo • compareTo can be used as a test in an if statement. String a = "al ice" ; String b = "bob" ; >= if (a. compareT0(b) < Primitives > 0) // true Objects (a . compareT0( b) (a . compareT0( b) (a . compareT0( b) (a . compareT0( b) (a . compareT0( b) (a . compareT0( b) > ](Exported%20image%2020240525204036-7.png) ![ArrayList as parameter public static void name(ArrayList<Type> name) { • Example: // Removes a Il plural words from the given list. public static void removePluraI(ArrayList<String> list) { for (int i = O; i < list. size(); i++) { String str = list . get(i); if (str.endswith("s")) { list . remove(i); 1--; • You can also return a list: public static ArrayList<Type> methodName(params) ](Exported%20image%2020240525204036-8.png)

￼DO NOT FORGET TO DEFINE ARRAYLIST'S TYPE WHEN PASSING, IF YOU DONT JAVA WILL TREAT IT LIKE A SEPARATE OBJECT
 
when given story.txt, here’s how you remove duplicate tokens!  
//removes duplicates  
for(int I = 0; I < words.size(); I++) {  
int lastIndex;  
do {  
lastIndex = words.lastIndexOf(words.get(I));  
if(lastIndex > i)  
words.remove(lastIndex);  
} while(lastIndex > i);  
}  
System.out.println(words);  
}
 
OR YOU CAN SORT EVERY WORD IN A FILE, THEN YOU ONLY HAVE TO COMPARE i to i+1
 
sort with
 
ArrayList<String> words = new ArrayList<String>();  
Collections.sort(words)