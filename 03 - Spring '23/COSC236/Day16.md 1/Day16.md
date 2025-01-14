Try Catch Blocks
 
-------------------------------------------------------------------------------------------------------------------------------  
For-Each Loops
 
Useful to INSPECT single dimension arrays  
Provides secure access to an array without  
allowing array elements to be changed  
Optimized looping structure  
Cannot be used when you need to modify the array  
or array elements or with multi-dimensional arrays   int arr = { 11, 47, -13, 22, 7, -3, 0};  
int sum = 0;  
double avg = 0.0;   for ( int value : arr )  
sum += value;   System.out.println(“Array average is: “ + (double)sum/arr.length;  
-------------------------------------------------------------------------------------------------------------------------------
 
- arrays: objects that stores many values of the same type
    
    - 1D array: all values in a row
    - 2D array: values in a grid (rows and columns)
![column index 0 1 2 3 4 5 6 7 8 9 row2 12 -17 0 0 31 5 -19 25 12 -13 ](Exported%20image%2020240525204030-0.png)  

- array[2][6] is a single element
- array[1] is a row of elements
- array[3] and array[0][11] are out-of bounds errors with the example above 
- type[][] name = type[rows][columns]
    
    - int[][] arr = new int[4][10];
    ![column index 0 1 2 3 4 5 6 7 8 9 row2 12 -17 0 0 31 5 -19 25 12 -13 ](Exported%20image%2020240525204030-1.png)  
    
 
Fast initialization & printing  
int [ ][ ] arr = { {2, 3, 4}, {9, 7, 14}, { 1, 2, 1} };
 - System.out.println(Arrays.toString(arr));
    
    - [[I@c31131, [I@5f4d1d, [I@10ca250]￼
- System.out.println(Arrays.deepToString(arr));
    
    - [ [2, 3, 4], [9, 7, 14], [1, 2, 1] ]

￼for( int row = 0; row < arr.length; row++) {  
for( int col = 0; col < arr[0].length; col++)  
System.out.printf(arr[row][col] + “\t”);  
System.out.println();  
}
      

initializes to:

![Exported image](Exported%20image%2020240525204030-2.png)   
- Binomial expansion (Pascal's Triangle)
- Lottery Odds //?
   

and matrices!!
 
-------------------------------------------------------------------------------------------------------------------------------
 
5, 4 //define rows and columns  
1, 2, 13, -7  
8,-9, 10, 12  
15, 16, 17, 18  
22, 23, 24, 25  
-29, 30, 31, 32
   

5, 0 //define rows + columns  
1, 2  
8, 9, 10  
15, 16, 17, 18  
22, 23, 24, 25, 26  
29, 30, 31, 32, 33, 34
   
 
-------------------------------------------------------------------------------------------------------------------------------  
while (inputFile.hasNext()) {  
try {  
num = inputFile.nextInt();  
total += num;  
} catch (InputMismatchException ime) {  
System.out.print("Illegal value found");  
inputFile.next();  
}  
}   while (inputFile.hasNext()) { // A Better Solution  
if(inputFile.hasNextInt() {  
num = inputFile.nextInt();  
total += num;  
} else {  
System.out.print("Illegal value found");  
inputFile.next();  
}  
}
 
Building Java Programs Chapter 7  
Multi-Dimensional Arrays
 
Multi-dimension arrays
 
Arrays indexes in 2D arrays
 
2D-array Declaration
         

Accessing elements:  
name[r_index][c_index] //access  
name[r_index][c_index] = value //modify
   

Jagged Arrays  
array grids need not be rectangular. The number of columns in each row can vary.
 
Example:  
int[][] arr = new int[5][];  
int val = 1;  
for( int i = 0; I < arr.length; i++){  
arr[i] = new int[i+1];  
}
    
Jagged array uses