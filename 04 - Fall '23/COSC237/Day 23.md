Test next week on thursday  
Review on BB  
Will NOT cover binary trees  
May not be online
 
Final is cumulative  
Might be online
 
-------------------------------------------------------------------------------------------------------------------------------
 
Binary trees!
 
Linear vs non-linear data structures
   

Graph

![Exported image](Exported%20image%2020240525213014-0.png)  

Tree  
Special kind of graph  
One of the nodes behaves as the root  
Unique path from root to any node

- Ancestor node
- Descendant node
- Sibling node

A forest is a collection of trees
 
The bottom of a tree are called terminal nodes, or leaves
 
The depth of a node is how far away it is from the root  
The height of a node is the **furthest** distance of a node to a leaf node
 
2 is the root, 7 and 5 are child nodes with depth 1  
2, 5, 11, 4 are terminal nodes
 ![10 11 ](Exported%20image%2020240525213014-1.png)  

Binary tree  
Type of tree
 
The definition of a binary tree is recursive  
The left side and right side of each node is also a binary tree, called a subtree

![П рои Ч5ие• 3чбџ зарои арои арои р з ИГЈЧ орои 300' ](Exported%20image%2020240525213014-2.png)  

Back to prefix vs postfix expressions!  
2 + 3 * 4  
2 + (3 * 4)  
= 234*+  
(2 + 3) * 4  
= 23+4*
 
Can be seen as a special binary tree called an expression tree  
+  
2 *  
3 4
 
Or  
*  
+ 4  
2 3
 
3 fundamental ways to search a tree in which you look at each node once and only once
 
Tree Traversals

1. Preorder traversal
    
    1. Visit root
    2. Preorder traversal of left subtree
    3. Preorder traversal of right subtree
2. Inorder traversal
    
    1. Inorder traversal of left subtree
    2. Visit root
    3. Inorder traversal or right subtree
3. Postorder traversal
    
    1. Postorder traversal of left subtree
    2. Postorder traversal or right subtree
    3. Visit root
 
The names refer to when you visit the root
 
Consider the tree
 
A  
B C  
D E F  
G
 
Preorder searches  
**A** B D C E F G
 
Inorder searches  
D B **A** E C G F
 
Postorder searches  
D B E G F C **A**
 
Going back to the postfix expression tree for 2 + 3 * 4  
Preorder traversal gets you a prefix expression  
Inorder traversal gets you an infix expression  
(notice how its ambiguous across both meanings)  
Postorder traversal gets you a postorder expression
   

Another use of trees is for storing a sorted list for efficient searching later
   

Binary search tree

- Binary tree
- Everything in the left subtree is less than the root
- Everything in the right subtree is greater than the root
    
    - For every subtree
   

Ex  
50  
30 80  
20 40 65 90  
10 36 42 72 88 95
   

You can add each element up with a pre-, in-, or postorder traversal  
Has O(log(n)) time
 
How to add elements?  
Just search for it!  
When theres nothing there, add it!  
(YOU DONT ALWAYS ADD TO A LEAF NODE)  
If you have duplicate entries, like 2 40s, have a counter variable in each node!  
You could store other things in the node too, like student records!  
Like, sort the node by student ID, then each node contains a link to their record #
 
You can use a binary search tree as an index file!
 
What can be a tree?
 
50  
60  
70  
80
 
(Make your trees balanced to make it more efficient to search!)
 
Balanced Binary Search Tree  
A subtree of a binary search tree
 
How do you balance a binary search tree?

1. Pick a good, median value to be your root node (if you know it)
2. If you get values fot the tree over time, you'll rebalance it naturally
 
Representing a binary search tree

1. As a linked list
2. As a special list
   

Considet the tree  
50  
30 80  
20 40 65 90  
10 36 42 72 88 95  
5
 
Child nodes are 2i, 2i+1 of their parent  
NOTE THAT EMPTY SPOTS ARE NOT REPRESENTED IN THE TREE

|   |   |
|---|---|
|1|50|
|2|30|
|3|80|
|4|20|
|5|40|
|6|65|
|7|90|
|8|10|
|9||
|10|36|
|11|42|
|12||
|13|72|
|14|88|
|15|95|
|16|5|
   

NEED TO KNOW FOR FINAL  
Traversals  
Binary tree terminology  
What is a binary search tree  
etc