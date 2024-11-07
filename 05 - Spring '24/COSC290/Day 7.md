New topic! Boolean Algebra & digital logic  
See paper notes for midterm info
 
-------------------------------------------------------------------------------------------------------------------------------
 
SWBAT

- Understand the relationship between Boolean logic and digital computer circuits
- Learn to how to design simple logic circuits
- Understand how digital circuits work together to form complex computer systems
 
- In the latter part of the 19th century, George Boole incensed philosophers and mathematicians alike when he suggested that ...
- Boole's Law of Thought 
Most important part:

- Boolean algebra is a mathematical system
- 3 important aspects
    
    1. Boolean operators
        
        - AND
        - OR
        - NOT
    
    |   |   |   |   |
    |---|---|---|---|
    |X|Y|XY (and)|X + Y (or)|
    |0|0|0|0|
    |0|1|0|1|
    |1|0|0|1|
    |1|1|1|1|
    
      
    4. Boolean Functions have:
        
        1. At least 1 boolean variable
        2. At least one boolean operator
        3. At least one input, {0,1}
        4. Produces an output that’s from the set {0,1}
    
    Ex. F(x,y) = ??
    
      
    
    - Sum of Products form
    - Product of Sums form
    
      
    9. Truth Table for boolean function
      
    
    F(x,y,z) =
    
      
      
    
- AND operator is known as a boolean product (XY)
- OR operator known an a boolean sum (X+Y)
- NOT operator inverts whatever its paired with (x')
    
Can be written in:
    
|   |   |   |   |
|---|---|---|---|
|X|Y|Z|F(x,y,z)|
|0|0|0|0|
|0|0|1|0|
|0|1|0|0|
|0|1|1|0|
|1|0|0|0|
|1|0|1|0|
|1|1|0|0|
|1|1|1|1 or smthn|
    ![Exported image](Exported%20image%2020240525213133-0.png)  

- Digital computers contain circuits that implement Boolean functions
- The simpler that we can make a Boolean function, the smaller the circuit that will result
    
    - Simpler circuits are cheaper to build, consume less power, and run faster than complex circuits
- With this in mind, we always want to reduce our Boolean functions to their simplest form.
- There are a number of Boolean identities that help us to do this. 
Most Boolean identities have an AND (product) form as well as an OR (sum) form. We give out identities using both forms. Out first group is rather intuitive
 
Simplification of a Boolean Function
 
Boolean Algebra Laws:  
(try to memorize)

![Iden i ty N ame Identity Law Null Law Idempotent Law Inverse Law AND Form OR Form 1 ](Exported%20image%2020240525213133-1.png) ![I den ty N ame Commutative Law Associative Law Distributive Law AND Form xy = YX x+yz = (x+y) (x+z) OR (x+y)+z = x + (Y+Z) x (y+z) = xy+xz ](Exported%20image%2020240525213133-2.png) ![Identi ty Absorption Law DeMorgan's Law Double Complement Law Form (xy) = x (x) OR Form x + xy x x ](Exported%20image%2020240525213133-3.png)  
   

Approaches:  
1) Use Boolean Algebra  
2) Use a K-map  
Works well for 2,3,4,up to 5 variables  
3) Use a software  
Works well for any number of variables
    
Note that Demorgan's law can be extended to any number of variables

- Replace each variable by its complement and change all ANDs to ORs and all ORs to ANDs
- Thus, we find the complement of:
![,y,z) is: ,y,z) (ху)+(х'у)+ (xz') (ху) ' (х ' у) ' (xz') ' (х'+у') (х + у ') (xI+z) ](Exported%20image%2020240525213133-4.png)  

- Recall the boolean product is the AND operation and the boolean sum is the OR operation
 ![• In the sum-of-products form, ANDed variables are ORed together. — For example: F (x, y, z) = xy + x z + y z • In the product-of-sums form, ORed variables are ANDed together. — For example: F (x, y, (x+z) (y+z) ](Exported%20image%2020240525213133-5.png)   - It is easy to convert a function to sum-of-products form using its truth table
- We are interested in the values of the variables that make the function true (=1)
- Using the truth table, we list the values of the variables that result in a true function value
- Each group of variables is then ORed together ![xz'+y xz'+y х о О о о 1 1 1 1 у о о 1 1 о о 1 1 z о 1 1 о 1 о 1 ](Exported%20image%2020240525213133-6.png)  
![• The sum-of-products form for our function is: = (x'yz')+(x'yz) + (x y 'z') + (xyz + (xyz) x o O o o 1 1 1 1 y o o 1 1 o o 1 1 z o 1 1 o 1 1 xz'+y 1 1 1 1 1 We note that this function is not in simplest terms. Our aim is only to rewrite our function in canonical sum-of-products form. ](Exported%20image%2020240525213133-7.png)

Note that each term in the answer is just the inputs that make the output true lol

- (x' = 0, x = 1) for each row
- This is called the minterm,
 
There are 2 canonical forms for Boolean expressions: sums-of-products and product-of sums.
         

3.3 Logic Gates

- We have looked at Boolean fuctions in abstract terms
- In this section, we see that Boolean functions are implemented in digital computer circuits called gates.
- A gate is an electronic device that produces a result based on 2+ input values
 ![Х AND У Х У ХУ Х ORY мот х ](Exported%20image%2020240525213133-8.png)

These are the basic gates, but theres more complex gates!
 
- Exclusive OR (XOR) gate
- The output of the XOR operation is true only when the values of the inputs differ ![X XOR Y x o o 1 1 o 1 o 1 XOY o 1 1 x Note the special symbol C for the XOR operation. ](Exported%20image%2020240525213133-9.png)- NAND and NOR are 2 very important gates. Their symbols and truth tables are shown at the right ![Х NANO У (ху) ' х о о х о У 1 Х NAND У х Ноа У У о Х NOR У ](Exported%20image%2020240525213133-10.png)- Study the above charts, they are very important!
    
- Any boolean function can be described with JUST NANDs lol
- Any boolean function can be described with JUST NORs lol
    
    - These are the universal gates
 
- NAND and NOR are known as universal gates because they are inexpensive to manufacture and any boolean function can be constructed using only NAND or only NOR gates
![AND (ху) ' (ху)“ = ху NOT х х'у')' =Х+У ](Exported%20image%2020240525213133-11.png)  
- Gates can have multiple inputs and more than one output
    
    - A 2nd output can be provided for the complement of the operation
    - We'll see more of this later
      
    ![XY'z ](Exported%20image%2020240525213133-12.png)  
    
    
3.4 Karnaugh Maps

- Simplification of boolean functions leads to simpler (and usually faster) digital circuits
- Simplifying boolean functions using identities is time-consuming and error-prone
- This special section presents an easy, systematic method for reducing Boolean expressions - In 1953, Maurice Karnaugh was a telecommunications engineer at Bell Labs
- While exploring the new field of digital logic and its application to the design of telephone circuits, he invented a graphical way of visualizing and then simplifying Boolean expressions
- This graphical representation, now known as a Karnaugh map, or Kmap, is named in his honor - A Kmap is a matrix consisting of rows and columns that represent the output values of a Boolean function
- The output values placed in each cell are derived from the minterms of a Boolean function
- A minterm is a product term that contains all of the function's variables exactly once, either complemented or not complemented - Ex, the minterms for a function
-