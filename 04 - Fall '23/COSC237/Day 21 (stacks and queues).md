Start looking at program 3  
It’s the last one!  
Due 12/5
 
Now you translate between 3 languages!  
You don’t have to worry about digits now  
Messages are strictly uppercase letters without digits or punctuation
 
Ordinals in the translator start at 0
 
Get the 1st character's ordinal, output the same ordinal in the right language  
Check if you're at the end of a word, and the end of a line!  
Read a complete line, then go letter by letter?
 
The binary getLetter() reads 8 1s and 0s at a time  
End of a word is "00010000" //blank character lol
 
No error handling, its already built in
 
-------------------------------------------------------------------------------------------------------------------------------
 
**Stacks**

- A data type implemented with a particular data structure
- a list that can only be accessed at one end
- Operations include:
    
    - push
        
        - adds items to the top of the stack
    - pop
        
        - resolves the top item on the stack
    - isEmpty
    - isFull

push(10)  
push(20)  
pop()  
push(30)
 
|   |   |   |   |
|---|---|---|---|
|||||
|||||
||20||30|
|10|10|10|10|
 
a stack is a LIFO  
Last In, First Out
 
consider an Array Implementation of a Stack:

|   |   |
|---|---|
|0|10|
|1|20|
|2|30|
|3|40|
|4|50|
|5|60|
|6|70|
|7|80|
|8|90|
|9|100|
 
putting these values on a stack top down means 100 is on top
 
all we need to do is count which item is the top  
use an integer counter!
 
Empty: top = 0  
1 element: top = 1  
top element = top - 1  
full top = 10
 
OR you could do a different implementation where top = -1, NOT 0  
this makes the count match the array indices
 
empty: top = -1  
1 element: top = 0  
top element = top  
full top = 9
 
EITHER IMPLEMENTATION IS FINE  
JUST BE CONSISTENT
 
consider a Linked List Implementation of a Stack:
 
|   |   |   |   |   |   |   |   |   |   |   |
|---|---|---|---|---|---|---|---|---|---|---|
|head|10|20|30|40|50|60|70|80|90|//|
 
makes more sense to make 10 the top, not 90  
push means make the head point to the new object, then the new object point to 10  
pop means remove the 1st object after head, then make head point to the new next object
 
**QUEUES**  
(Data Type implemented with a particular data structure)  
it’s a list that can only be accessed at both ends
   

enqueue ( put on queue)  
dequeue (take off queue)  
isEmpty  
isFull
 
Array implementation (sideways this time bc its more natural!)
 
|   |   |   |   |   |   |   |   |   |   |   |
|---|---|---|---|---|---|---|---|---|---|---|
|0|1|2|3|4|5|6|7|8|9|10|
|10|20|30|40|50|60||||||
 
now you need 2 pointers: front and back
 
dequeue O(n) with a front pointer only  
you have to move each object down after a dequeue lol
 
with 2 pointers, O(1) time  
the pointers will eventually reach the end of the array, then wrap back to the front!  
use modulus!
 
enqueue(){  
rear = (rear + 1) % 10;  
front = (front + 1) % 10;  
}
 
when front = rear, there's one element in queue