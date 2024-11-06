import java.util.*;
import java.io.*;
import java.lang.Math;


//simple Driver program to test Adj_List_Graph class

public class attempt2{
  public static void main(String[] args) throws FileNotFoundException
    {    

        //input handling
        File file = new File("input1.txt");  //INSERT NEW FILES HERE
        Scanner scanner = new Scanner(file);

        int index = 0;
        int size = scanner.nextInt();           //1st token is size
        int[] Array = new int[(size * size)];  //create array to save OG list

        while(scanner.hasNextInt()){
            Array[index] = scanner.nextInt();
            index++;
        }
        scanner.close();

        //graphCreator(Array, size);
        graphModifier(Array, size);
	}




  public static void graphCreator(int[] Array, int n){
    int current;
    int k = 1;  
    int i;
    int j;

    Adj_List_Graph a = new Adj_List_Graph(n); //init graph with n vertices

	while(k < (n*n)){   //CHECK
		current = Array[k];

        if (current == 1){
            i = k/n;
            j = k % n;

            a.addEdge(i,j);
        }
        k++;
    }
    a.printGraph();

    
  }

  public static void graphModifier(int[] a, int size){


    int[] b = new int[size * size];

    for (int k = 0; k < size * size; k++){ //copy init array into output array
        b[k] = a[k];
    }



    int finalOffset; 
    

    for(int i = 0; i < size * size; i++){                                 //scan for connected nodes of length 1

        if (a[i] == 1){
            finalOffset = (int) Math.floor(i / size);                             //store which bit to flip in final grouping

            for(int j = (i % size)  * size; j <= (i % size) * size + (size - 1); j++){    //scans connected nodes for path of length 2
                if (a[j] == 1){
                    b[(j % size)  + (size * finalOffset)] = 1;                 //flip bit to 1 in output, "adding" the edge between nodes with a path of length 2 between them
                }
            }
        }
    }

    graphCreator(b, size);  //create and output graph for modified array
  }
}
