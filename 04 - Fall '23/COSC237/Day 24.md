Exam #3 Review
 
In paper, not coding
 
-------------------------------------------------------------------------------------------------------------------------------
 
Look at review sheet
 
Exam is roughly 50% on linked lists WITH IMPLEMENTATION
 
Recursion, sorting and searching, and the last topic are ~ 5-10% of the final
 
No questions on binary trees
   
![1. (a) Declare a class named User that contains the following information: String name String username String password Include in the class a single constructor that is passed a particular name, username, and password; setters and getters, and a toString method that returns the information in a given User object as follows: 'Ashley Smith username: asmith password: aWjPP406!" (b) Declare a class named UserNode that contains a single User object and a link to another UserNode. Include an appropriate constructor and an appropriate set of methods for this class. ](Exported%20image%2020240525213015-0.png)  

public class User {  
private String name;  
private String username;  
private String password;
 
public User(String name, String username, String password){  
this.name = name;  
this.username = username;  
this.password = password;
 
public string getName() {  
return name;  
}
 
public string getUsername() {  
return username;  
}
 
public string getPassword() {  
return password;  
}
 
public void setName(String name){  
this.name = name;  
}
 
public void setUsername(String username){  
this.username = username;  
}
 
public void setPassword(String password){  
this.password = password;  
}
 
public String toString(){  
return name + " username: " + username + " password: " + password;  
}
   

there is NOT a question like the UserAccounts on the exam
 
how to traverse, insert, and append to a linked list?
 
bottom up vs top down recursion?
 
REVIEW HOW SORTING ALGORITHMS WORK
 
linked lists basic rundown  
we know how to create a node class  
NEVER change where the head node points unless you're modifying the first node
 
do NOT need to insert or delete for exam!
 
-----------------------------------------------------------------------------------------------------------------------  
how to append?  
if (head == null)  
head = new IntNode(10, null) //check first case exception  
else {  
IntNode pointer = head;
 
while (pointer.getNext() != null){ //stop on last, DO NOT fall off!  
pointer = pointer.getNext();  
}
 
pointer.setNext(new IntNode(40, null)); //add new node  
}
 
------------------------------------------------------------------------------------------------------------------------how to add up all values in a linked list?  
if (head == null)  
return 0  
else  
IntNode pointer = head;  
int sum = 0;
 
while(pointer != null) { //NOTE HOW THIS CHANGED FOR LAST ITEM  
sum = sum + pointer.getValue();  
pointer = pointer.getNext();  
}  
]
 
-----------------------------------------------------------------------------------------------------------------------  
while(pointer != null && pointer.getValue != 30){ //use this test to find a specific value in the list!  
return !pointer == null; // true means you found 30, else false  
-----------------------------------------------------------------------------------------------------------------------
 
public class IntList {  
private IntNode head;  
public IntList() [  
head = null;  
}
 
public void append(int new_value) {  
…  
…//see above for implementation  
}
 
public void add_up() {  
…  
…//see above for implementation  
}
 
public boolean contains (int value) {  
…  
...  
}
 
-----------------------------------------------------------------------------------------------------------------------
 
mergesort and quicksort are O(nlogn)  
all others are n^2 on average
 
selection sort  
compares top to all lower values, swapping mismatches  
compares 2nd item to all lower values, swapping mismatches  
etc  
ALWAYS O(n^2)
 
Insertion sort  
move the insertion line lower each pass, insert values into the sorted portion each time  
O(n^2) generally, O(n) when sorted
 
Bubble sort  
O(n^2) generally, O(n) when sorted