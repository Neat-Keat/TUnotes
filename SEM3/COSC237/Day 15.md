Cyber corps scholarship?
 
-------------------------------------------------------------------------------------------------------------------------------
 
Arrays vs Linked lists

- The 2 fundamental ways to represent a list in memory 
|   |   |
|---|---|
|**Arrays**|**Linked Lists**|
|Static|Dynamic|
|Efficiently Accessed|Not Efficiently Accessed|
|Inefficiently Modified|Efficiently Modified|
   

Array in memory
 
int[] nums points to [0], and each subsequent # represents a static size jump thru memory

|   |   |   |   |   |
|---|---|---|---|---|
||||||
||==[0]==|||
||==[1]==|||
||==[2]==|||
||==[3]==|||
||||||

- how to insert a new value?
    
    - move subsequent items down a location, then insert at gap
 
Linked List in Memory
 
nums[] points to 1st object

|   |
|---|
==10== ==addr[2]==|==20== ==addr[3]==
||||||
||==30== ==addr[4]==||
==40== ==addr[5]==|||
||||==60== ==null==

- how to insert a new value?
    
    - add object and node
    - change the previous link
 
-----------------------------------------------------------------------------------------------------------------------
 
but how do you make a linked list anyways?
 
}
   

need to know:

- how to append a node to the end
- how to insert a node in the middle
- how to delete a node
                
public class IntNode {  
//the important parts  
private int value;  
private IntNode next;
 
//constructor  
public IntNode(int value, IntNode next) {  
this.value = value;  
this.next = next;  
}
 
//getters and setters  
public int setValue() { return value; }  
public IntNode getNext() { return next; }
 
public void setNext(IntNode next) { this.next = next; }
    
-------------------------------------------------------------------------------------------------------------------------------
 
How do we represent an empty list?
 
IntNode head = null; //empty list
 
//ONCE YOU HAVE A FIRST NODE  
//DO NOT CHANGE HEAD
 
//appending (define this as an appending function?)  
if(head ==null)  
head = new Intnode(10, null);
 
else {  
IntNode temp = head;  
while (temp.getNext() != null)  
temp = temp.getNext(); //allegorous to I++ in a for loop
 
temp.setNext(new IntNode(40, null));  
}
 
-------------------------------------------------------------------------------------------------------------------------------
 
you can have a linked list of arrays lol

- a sample application of this is storing RBG colors, which are 3 i

head -> //  
head -> 10 -> //  
head -> 10 ->… -> //