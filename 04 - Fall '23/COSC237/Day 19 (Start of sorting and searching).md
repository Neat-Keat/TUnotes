Program 3 out, due ?
 
Use any IDE that has a debugger, NOT Replit!!
 
-------------------------------------------------------------------------------------------------------------------------------
 
Its impossible to exactly measure algorithm runtime in specific instances  
Too many variables  
Cpu, other programs running, etc
 
Instead, we just measure how the algorithm scales over different input sizes  
Algorithm rate of growth  
Big O notation!  
Graph with time over input size
 
2 Big Misconceptions

- Comparing 2 algorithms for 1 input size does NOT determine their rate of growth!!!
- How much more time typically takes to solve a problem 2x as big is variable. For most algorithms, a problem 2x as big takes more than 2x the time.
 
All sorting algorithms compare and swap elements of a list. They differ in Which are compared and When they are swapped.
 
Naïve sort has a runtime of n(n+1)/2  
Equal to ½n^2 + ½n

- We only look at the leading term
    
    - This means the runtime gets truncated to n^2
    - O(n^2)
        
        - O is short for the Order of the sort :0
          
        
   

Types of O

- O(1) is constant
- O(log(n)) is logarithmic
- O(n) is linear
- O(n log(n)) is "n logn"
- O(n^2) is quadratic
- O(n^2 log(n))
- O(n^3) (this and above are "tractable", or usable in practice)
- …
- O(2^n) (anything above this is considered intractable)  
For any general list, you CANNOT sort faster than nlogn
 
SELECTION SORT  
Compare 1st number to each number in the list, if its smaller, then swap  
Repeat with 2nd, 3rd, etc till the bottom  
½ n^2 + ½ n -> O(n^2)
 
INSERTION SORT  
Have a sorted and unsorted part  
Compare the 1st number of the unsorted part, and insert it into the sorted part in it's proper position  
This insertion is based off of comparisons from the bottom of the sorted part up.  
¼n^2 -> O(n^2)