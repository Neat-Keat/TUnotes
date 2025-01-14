Be on the lookout for program 3
 
-------------------------------------------------------------------------------------------------------------------------------
 
Head marks the first node  
tempPointer is free to move, is used to find the last node in the list [while tempPointer != null]
 
To insert 25 to:
 
Head -> 10 -> 20 -> 30 -> 40 -> 50 -> //
 
1. look for the first node that’s bigger than 25 (ie 30)
2. Run tempPointer from head till 30
3. create the new node that points to the previous object's old target node
4. change the previous object's target node to the newly created node
 
CONSIDER  
have 2 pointers, a leading and a trailing, to change nodes without rescanning the linked list
   

IMPLEMENTATION:
 
IntNode leadingPtr = head;  
IntNode trailingPtr = head;
 
while(leadingPtr.getValue() < 25){  
trailingPtr = leadingPtr;  
leadingPtr = leadingPtr.getNext();  
}
 
trailingPtr.setNext(new IntNode(25, trailingPtr.getNext()));
   

the ONLY TIME we change head's value is when it points to null or you're inserting a new 1st value
 
-------------------------------------------------------------------------------------------------------------------------------
 
ok but how do we delete 30?
 
IntNode leadingPtr = head;  
IntNode trailingPtr = head;
 
//this test is arbitrary, change the condition to select what you want to delete  
while(leadingPtr.getValue() != 30){  
trailingPtr = leadingPtr;  
leadingPtr = leadingPtr.getNext();  
}
 
trailingPtr = setNext(leadingPtr.getNext());
 
-------------------------------------------------------------------------------------------------------------------------------
 
eventually, java will come around, delete the skipped node, and free up its memory space
 
-------------------------------------------------------------------------------------------------------------------------------
 
FULL CLASS
 
public class IntList {
 
private IntNode head;
 
public IntList()  
head = null;
 
public boolean isEmpty()  
return head == null;
 
//append method  
public void append(int newValue){  
if (isEmpty()){  
head = new IntNode(new_value, null);  
} else{  
IntNode tempPtr = head;  
while (tempPtr.getNext() != null)  
tempPtr = tempPtr.getNext();  
tempPtr.setNext(new IntNode(newValue, null));  
}
 
public void insert(int newValue, int insertBefore) {  
//assume implemented  
}
 
public void delete(int deleteValue) {  
//assume implemented  
}
 
public int length() {  
//assume implemented  
}  
}  
-------------------------------------------------------------------------------------------------------------------------------
 
using this class in a sample main file
 
//main  
IntList my_list = new IntList();  
my_list.append(10);  
my_list.append(20);  
…  
my_list.insert(15,20);  
my_list.delete(20);  
system.out.println("current length: " + my_list.length());
 
-------------------------------------------------------------------------------------------------------------------------------
 
ok, but how do we do the same thing with an array?
 
public class IntList {
 
private int[] values;  
private int current_index //= -1?;
 
private IntList() { values = new int[100]; }
 
private IntList(int size) { values = new int[size]; }
 
public boolean isEmpty() { return current_index == -1; }
 
public void append (int new_value) throw ListExceededException {  
if(current_index == values.length - 1)  
throw new ListExceededException();  
else{  
values[++current_index] = new_value;  
}
 
public int length() {  
return current_index + 1;  
}
 
//assume delete and insert are implemented lol  
}
 
-------------------------------------------------------------------------------------------------------------------------------
 
these two codes can utilize the same main code, which means that the job for the client is much easier to deal with.
      

you will need 2 basic while loops to traverse linked lists  
1 that stops at the end  
1 that falls off the end