Final is "most likely online", in two lab rooms  
Format is similar to exams we've had  
A few TF/ MC, coding questions
 
Graph -> Tree (any # of child nodes)-> Binary Tree (2 child nodes max) -> binary search tree (vales follow order)
 
Consider a tree made of nodes, ie treeNode instead of intNode
 
Remember that binary tree items are organized such that each parent's child nodes are at array locations 2i and 2i+1
 
Binary search tree: same effect of binary searching a sorted list  
Consider

|   |   |   |   |   |   |   |   |
|---|---|---|---|---|---|---|---|
|10|20|30|40|50|60|70|80|
 
Making 40 the root node leads to this tree
 
40  
20 60  
10 30 50 70  
80  
Remember to keep the difference in height between subtrees no more than 1   Binary expression tree:
 
Consider 2*3+4  
Is ambiguous, could be (2*3) + 4 or 2* (3+4)
 
Trees remove ambiguity  
(2*3) + 4 becomes
 
+  
* 4  
2 3
 
Infix: 2*3+4  
Prefix: +*234  
Postfix: 23*4+
   

2* (3+4) becomes
 
*  
2 +  
3 4
 
Infix: 2*3+4  
Prefix: *2+34  
Postfix: 234+*
   

Enqueue is O(1)  
Dequeue is O(n)
 
Mergesort  
1st pass is literally divide the list down the middle
 
Ex. Consider the list  
21, 6, 32, 14, 9, 27, 3, 16
 
First pass:  
21, 6, 32, 14 || 9, 27, 3, 16
 
Second pass:  
21, 6 || 32, 14 || 9, 27 || 3, 16
 
Third pass:  
21 || 6 || 32 || 14 || 9 || 27 || 3 || 16
 
START MERGING!!  
6 21 || 14 32 || 9 27 || 3 16
 
6 14 21 32 || 3 9 16 27
 
3 6 9 14 16 21 27 32