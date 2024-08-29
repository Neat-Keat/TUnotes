Program 3!
 
Just put the new code into your own IDE lmfao  
"Use VSCode lmfao"  
Download the zip on BB, extract, open folder in VSCode
 
Select the main file, then say run  
You can run with or without the debugger  
Install the debugging extension lmfao
 
For the "open file" option, type in the name of the file WITHOUT THE .txt
 
Look at the UML diagram, get familiar with the code
 
The output message will look at each letter, know what letter in the alphabet it is, then output what that is in the other language  
-------------------------------------------------------------------------------------------------------------------------------  
Selection Sort = O(n^2)  
Compare n to n+1  
Swap if they need to
 
Goes thru every step, even if its sorted or not

|   |   |
|---|---|
|10|10 -> 6|
|6|6 -> 10|
|11||
|9||
|21||
|7||
 
Insertion Sort = O(n^2)  
Insert new numbers into the proper position as you see them

|   |   |
|---|---|
|10|10 -> 6|
|6|6 -> 10|
|11|11|
|9||
|21||
|7||
 
BubbleSort (similar to Selection Sort) (n^2, but faster in certain cases)  
21 & 7 are a bubble, swap 7 to the top  
7 & 9 are a bubble, swap 7 to the top  
7 & 11 are a bubble, swap 7 to the top  
7 & 6 are a bubble, leave alone  
6 & 10 are a bubble, swap 6 to the top

|   |   |
|---|---|
|10|6|
|6|7|
|11||
|9||
|21||
|7||

- Takes n-1 comparisons for a sorted list
- Takes n^2 comparisons for an unsorted list
 
Rate of growth has 3 categories

- Best case
- Average Case
- Worst Case
 
-------------------------------------------------------------------------------------------------------------------------------  
**ON FINAL**  
Consider selection sort, insertion sort, and bubble sort  
Whats the best case?  
Average case?  
Worst case?
 
|   |   |   |   |
|---|---|---|---|
||Selection Sort|Insertion Sort|Bubble Sort|
|Best case|O(n^2)|O(n)|O(n)|
|Average case|O(n^2)|O(n^2)|O(n^2)|
|Worst Case|O(n^2)|O(n^2)|O(n^2)|
 
Use this chart to determine the algorithm to implement for your use case  
-------------------------------------------------------------------------------------------------------------------------------
 
Ok but what's the fastest algorithm generally?
 
_QuickSort!_  
_But first: MergeSort!_  
Recursive!  
If the list is of length 1, then it's sorted
 
Divide the list in the middle
   

|   |   |   |   |   |   |
|---|---|---|---|---|---|
|10|10|10|6|6|6|
|6|6|6|10|9|7|
|11|11|11|9|10|9|
|9|9|9|11|7|10|
|21|21|21|7|11|11|
|7|7|7|21|21|21|
 
And now QuickSort!  
It asks: "what happens if you split it to where the smallest numbers on the left and the largers on the right?
 
Pick a pivot value, base comparisons off of that  
This is where the implementation of quicksort can be strange  
Typically we pick 3 random numbers, then pick the middle for the pivot
 
2 pointers, left and right  
They look for and hold items that are on the wrong side of the pivot  
Once both pointers find objects that are on the "wrong" side of the pivot, they swap them!  
Once the pointers cross, you've split the list!
   

(swapping items that are far apart can fix more "out of order" pairs than swapping items that are close together)  
This is why quicksort is slightly faster than mergesort?
 
|   |   |   |   |   |
|---|---|---|---|---|
|10|||||
|6|||||
|11|||||
|9|||||
|21|||||
|7|||||
 
Quicksort is slightly faster than mergesort
 
Quicksort takes n time to split the list * log n layers  
O(n log n)  
Mergesort takes n comparisons * log n splits
 
Merging is not as efficient as concatenating lulw  
That’s why
 
---------------------------------------------  
Algorithms of varying runtimes:  
These are tractable, anything worse is intractable  
O(n^3)  
O(n^2 logn)  
O(n^2)  
O(nlogn) ----------- fastest sort  
O(n) ---------------- linear search  
O(logn) ------------ binary search  
O(1) ---------------- hash map
 
-------------------------------------------------------------------------------------------------------------------------------  
NP = P?
 
Short for Non-Polynomial = Polynomial?  
Refers to their runtime

![NP-Hard NP-Hard NP-Complete = NP-Complete P = NP ](Exported%20image%2020240525213011-0.png)

NP-Hard are proven to be impossible to do in polynomial time  
NP-Complete: we don’t know if they are or not  
NP complete problems are shown to be mathematically equivalent in runtime lol  
Means that if you solve 1 NP-Complete problem, then they're all solvable  
Because no one's done it so far, we're thinking that NP-Complete actually belongss to NP-Hard, not P
 
Literally the biggest open problem in CS rn
 
-------------------------------------------------------------------------------------------------------------------------------
 
What about O(1)?  
What problem can be solved in O(1) runtime for any problem size?
 
You can use hash maps!  
Use the item you're comparing as it's address in the hash map  
Take the word "hear" for ex  
Each letter can be thought of as a number in base 26  
Multiply them together, then put that in the table as its address  
If the number is too big, just wrap lmfao

|   |   |
|---|---|
|0||
|1||
|2||
|3||
|4|hear|
|5||
|6||
|7||
|8||
|9||
|10||