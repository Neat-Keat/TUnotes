Circuit Design Tutorial  
Algorithm <-> Truth Table <-> Karnaugh Map <-> Boolean Expression <-> Circuit Drawing
 
1) Algorithm Establishment

- On the computer programmers perspective:
- On the circuit designer's perspective
    
    - Take 2 inputs -> 1 bit each
        
        - Output 1 if the same
        - Output 0 if different 
Boolean input1, input2;  
Scanf (%d, &input1);  
Scanf(%d, &input2);  
If(input1==input2)  
System.out.println("output (same) \n");  
Else  
System.out.println("(different)\n);
 
2) Truth Table Construction

|   |   |   |
|---|---|---|
|A|B|Out|
|0|0|1|
|0|1|0|
|1|0|0|
|1|1|1|
 
3) Karnaugh map

- Developed by Maurice Karnaugh in 1953
- Description
    
    - Transformation of a truth table to extract a boolean expression
- Method
    
    - Sum of products (positive logic: eg., 1 = A and 0 = A')
    - Product of sums (negative logic: eg., 0 = A and 1 = A')
- How to build the Karnaugh map
- NOTE
    
    - The output positions can be grouped with the number of...
      
    

WE USE SUM OF PRODUCTS IN THIS LAB  
Truth table -> kmap -> boolean expression -> digital circuit
 
2) Boolean expression

1) 1-on-1 relationship between a Kmap and an output  
Eg 3 outputs -> 3 kmaps needed  
2) Conversion to the 2D graph; X and Y axis construction  
Categorize inputs to two groups  
3) Placement of outputs to the appropriate cases  
Copy outputs from a truth table to its K map  
4) The extraction of Boolean expression (positive logic applied)  
Make a product from each output position if its value is 1 and sum all the products
   

1) Boolean expression  
1) Truth table

|   |   |   |
|---|---|---|
|A|B|Out|
|0|0|1|
|0|1|0|
|1|0|0|
|1|1|1|
 
|   |   |   |   |
|---|---|---|---|
||A|||
|B||0|1|
||0|1|0|
||1|0|1|
 
Kmap to Boolean Expression  
1) Rules

- Adjacent 1s in the Kmap represents opportunities to simplify the expression
- The minterms for the final expression are found by encircling groups of 1s in the map
- Minterm groups must be rectangular and must have an area that’s a power of 2
- Minterm rectangles should be as large as possible without containing any 0s
- Groups may overlap in order to make each one larger
 ![4) Boolean Expression Ex- traction 1. Boolean expression 1) Sum of Products (Positive logic: 1=A A o . Boolean expression=P1 + P2 — A • B+ A • B Boolean expressions Electric circuit di- agrams VOWSON UNIVERSITY ](Exported%20image%2020240525213134-0.png)

The boolean expression above needs 2 and gates, 1 or gate, and 2 not gates
 ![5) Draw the circuit! 1 . —A needed 2. needed VOWSON UNIVERSITY 5. sum of products: 3.+4. O output 4, A B (precedence) ](Exported%20image%2020240525213134-1.png)   
Consider the truth table (using positive logic (1 =A, 0 = A')
 
|   |   |   |   |   |   |
|---|---|---|---|---|---|
|||AB||||
|||00|01|11|10|
|C|0|==1== ==1== ==1== ==0==
||1|==0== ==0== ==0== ==0==

Note how cells 2, 3 always have B=1 and C=0  
We can pull these out and describe cells 2, 3 with BC'
 
Likewise cells 1,2 always have A=0, C=0  
We can describe this as A'C'
 
OR all the terms and describe the reduced function as BC' + A'C'
 
|   |   |   |   |   |   |
|---|---|---|---|---|---|
|||B||||
|||00|01|11|10|
|A|0|==1== ==0== ==1== ==1==
||1|==0== ==0== ==0== ==0==
   

Now consider A'B'C'' + A'BC' + A'BC + ABC' (each term is a 1 in the table!)

|   |   |   |   |   |   |
|---|---|---|---|---|---|
|||AB||||
|||00|01|11|10|
|C|0|==1== ==1== ==1== ==0==
||1|==0== ==1== ==0== ==0==
   

Groups are cells (1,2), (2,3), and (2,6)
 
Simplifies to A'C' + A'B + C'B (each term is a group!)
    
Lets build a 1 bit binary adder!

- 0 + 0 = 0
- 0 + 1 = 1
- 1+ 0 = 1
- 1 + 1 = 0 and a carry
   
![Let's think (cont) • We have two I-bit binary values for addition: A o o 1 1 B o 1 o 1 s o 1 1 o C o o o 1 S (sum) A o C (Carry-out) 1 (11 Booleanerpreffill . Boo/eanerpmssion= A • B VOWSON UNIVERSITY ](Exported%20image%2020240525213134-2.png)

THIS SLIDE IS FORMATTED BAD, LOOK ON BB
 
S = A XOR B  
C = A AND B
 ![Half Adder • Add two one-bit binary numbers. INPUT OUTPUT B o S=Å.B+Å.B B o <Truth Table> VOWSON UNIVERSITY ](Exported%20image%2020240525213134-3.png)  

Binary Decoder in Digital Logical

- An n-to-m decoder converts inputs into output with multiple bit inputs resulting in 2^n outputs
- The decoder works by producing all possible outputs of 2^n depending on if the input is on or off, producing only one positive output for each unique combination of inputs ![inputs Decoder 2 Outputs ](Exported%20image%2020240525213134-4.png)  
![Binary Decoder in Digital Logical h yr-I yo y, 2n lines XTOWSON UNIVERSITY ](Exported%20image%2020240525213134-5.png)  

HALF ADDER
   

FULL ADDER
 
|   |   |   |   |   |
|---|---|---|---|---|
|Input|Input|Input|Output|Output|
|A|B|Cin|Sum|Cout|
|0|0|0|0|0|
|0|0|1|1|0|
|0|1|0|1|0|
|0|1|1|0|1|
|1|0|0|1|0|
|1|0|1|0|1|
|1|1|0|0|1|
|1|1|1|1|1|
   

Have 2 outputs, 1 for sum, 1 for output
   

|   |   |   |   |   |   |
|---|---|---|---|---|---|
|||BC||||
|||00|01|11|10|
|A|0|==0== ==0== ==1== ==0==
||1|==0== ==1== ==1== ==1==
 
Cell group 6,7 = AC, because those are the values that DONT change across the group, and the values of A, C are 1
 
Cell group 7,8 = AB because those are the values that DONT change across the group, and the values of A, B are 1
 
Cell group 3, 7 = BC because those are the values that DONT change across the group, and the values of B, C are 1
 
Sum of product all these terms, we get AC + AB + BC