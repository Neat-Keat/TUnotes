Program 3
 
Each class is its own file  
Submit on replit
 
Finishing stacks and queues
 
-------------------------------------------------------------------------------------------------------------------------------
 
Stack Implementation as an array
 
1. "top" pointer starts at –1 (for empty)
    
    1. Push increments top by 1, then place new element @ top
    2. Pop grabs element @ top, then decrements top by 1 
OR
   

1. "top" pointer starts at 0 (for empty)
    
    1. Push places element at @ top, then increment by 1
    2. Pop decrements top by 1, then grabs the element @ top
 
Note that (top++) -> (top = top + 1)
 
Means that you can have

- for(int i = 0; i < x, i++);
- for(int i = 0; i <x, ++i);
 
SAMPLE IMPLEMENTATION OF AN ARRAY STACK  
value = elements[top]  
top = top – 1;  
return value;
 
-------------------------------------------------------------------------------------------------------------------------------
 
Stack implementation as an array
 
it makes more sense to make the 1st element after the head the top of the stack
 
-------------------------------------------------------------------------------------------------------------------------------
 
Queue – array implementation
 
4 methods

1. enqueue()
2. dequeue()
3. isEmpty()
4. isFull()
 
SIMPLE ARRAY IMPLEMENTATION
   

|   |   |   |   |   |   |   |   |   |   |
|---|---|---|---|---|---|---|---|---|---|
|0|1|2|3|4|5|6|7|8|9|
|10|20|30|40|||||||
||||rear|||||||
 
Enqueue() = O(1)  
Dequeue() = O(n)
   

ADVANCED ARRAY IMPLEMENTATION
   

|   |   |   |   |   |   |   |   |   |   |
|---|---|---|---|---|---|---|---|---|---|
|0|1|2|3|4|5|6|7|8|9|
||||10|20|30|||||
||||front|||rear||||
 
Enqueue() = O(1)  
Dequeue() = O(1)
 
Note that:  
with 0 elements on the queue:  
rear = front  
with 1 element on the queue:  
rear = front + 1 in queue  
with max elements on the queue:  
rear = front – 1  
(technically this removes a spot from the queue, but it stops logic errors)
 
front = 3  
front = (front + 1) ÷ (arraySize)
 
this implementation makes Enqueue AND Dequeue O(1)
 
EXPRESSION REPRESENTATIONS  
we normally use infix expressions  
2+3*4  
(2+3 )* 4  
2 + (3 * 4)
 
computers like postfix expressions because there's no ambiguity and it's fast  
23+4* ALWAYS MEANS (2 + 3) * 4  
234+* ALWAYS MEANS 2 + (3 * 4)
 
java actually automatically converts infix expressions to postfix expressions in the compiler but how?  
during the translation step, an algorithm uses a stack to get it in the right form lol  
this plays nicely with stacks and queues  
any time you see a number, push to stack any time you see an operator, pop the amount of numbers needed, do the operation, then push back to the stack
 
there's also prefix expressions!  
(2+3) * 4  
23+4*  
*+234
 
2 + (3 * 4)  
234 * +  
+2 * 34
 
prefix gives you flexibility in expressing operators  
+23  
+234  
+2345
 
you can overload + to take any number of input numbers
 
LISP, the 2nd high level lang, uses prefix (+234) (+(34)5) (print _) these are instructions to be executed '(+234) with a quote makes it data then LISP cam create its own instructions and execute them  
out of date by the 80s?  
----------------------------------------------------------------------------------------------------------------------------  
REGULAR EXPRESSIONS
 
x - 0 or more  
+ - 1 or more  
| - or
 
consider a lang where any string of binary that begins with 1 is in the lang  
1(0|1)^*
 
consider a lang where any string of binary needs any number of 1s, followed by the same # of 0s, ie 11110000  
this can't be expressed with those rules, so its an irregular expression
 
WHAT THAT MEAN?  
if it can be expressed regularly, anything can be checked if it's in the lang easily
 
Finite State Machine  
start state  
state 2  
state 3  
transitions between states
 
if any rule can be expressed this way iys very easy to implement consider the 2nd, irregular expression it can't be written out in finite states it is fundamentally more difficult to check expressions to match that rule than the 1st
 
4 levels of computing  
theory was invented by Noam Chomsky lmfao
 
lowest level  
finite state machine
 
highest level  
Turing machine
 ![Exported image](Exported%20image%2020240525213012-0.jpeg)