import java.util.*;
import java.io.*;


//simple Driver program to test Adj_List_Graph class

public class attempt1{
    
  public static void main(String[] args) throws FileNotFoundException
  {

    int current;
    int k = -1;  //so that 1st pass is 0
    int i;
    int j;
    
    
	//input handling
	File file = new File("input1.txt");  //INSERT NEW FILES HERE
	Scanner scanner = new Scanner(file);

	int n = scanner.nextInt();            //1st token is # of vertices
    int[] Array = new int[n * n];  //create array to save OG list

    Adj_List_Graph a = new Adj_List_Graph(n); //init graph with n vertices

	while(scanner.hasNextInt()){
		current = scanner.nextInt();
        k++;
        Array[k] = current;

        if (current == 1){
            i = k/n;
            j = k % n;

            a.addEdge(i,j);
        }
	}
    
    a.printGraph();
    scanner.close();
  }
}
