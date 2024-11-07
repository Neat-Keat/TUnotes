EVERYTHING ON THE TEST HAS ALREADY BEEN COVERED, DW ABOUT CONTENT FOR NOW
 
Nothing on exception handling on exam lmfao
 
-------------------------------------------------------------------------------------------------------------------------------  
Program 2, add a quit program option on 5
 
Intuition behind linked lists  
2 ways to represent lists:

- Arrays (Static size)
    
    - Store objects in contiguous memory locations
        
        - Easier to iterate objects for compiler, its just simple math
        - Efficient to access
        - Must be of a fixed size once declared in order to be contiguous
        - Efficient storage in memory
        - To remove an element, all subsequent elements must be moved up, which is inefficient
- Linked Lists (Dynamic size)
    
    - Each item in the list contains a node which contains an address to the next item in the list
        
        - Compiler must follow all previous links to get to desired object, making it less efficient
        - Increases the memory size of each value in the list
        - Less efficient storage
            
            - Fragments the memory a bit lol
        - Removing an element only changes the previous element's pointer
 
|   |   |
|---|---|
|**Arrays (Static)**|**Linked List (Dynamic)**|
|Efficient to access|Not efficiently accessed|
|Fixed Size|Varying size|
|Efficient Storage|Less efficient storage|
 
You can use an array that stores different linked lists lol, that’s kind of hype
   

Array lists act the same as an array, but if you run out of space, the variable storing the start of the array can link to the start of a new, larger array  
The new array has all the old arrays copied over, and the old array is deleted.  
There's a lot of overhead costs, so only use when necessary
   

How do I implement a linked list?  
---------------------------------  
Public class IntNode {  
private int value;  
private IntNode next;
 
//constructor  
public IntNode(int value, IntNode next) {  
this.value = value;  
this.next = next;  
}
 
//getters  
public int getValue(){  
return value;  
}
 
public IntNode getNext() {  
return next;  
}
 
//setters  
Public void setNext(IntNode next) {  
this.next = next;  
}  
}  
----------------------------------------------------------------------  
//main
 
IntNode head = null;
 
head = new IntNode(10, null);
 
head.SetNext(new IntNode(20, null);
 
head.getNext().setNext(new IntNode(30, null);
 
head.getNext().getNext().setNext(new IntNode(40, null);
 
head.getNext().getNext().getNext().setNext(new IntNode(50, null);
 
//what about lists that are 1000 elements long?  
------------------------------------------------  
Public class ClassA {  
private int n;  
ClassA k;  
}  
---------------------------------------------------