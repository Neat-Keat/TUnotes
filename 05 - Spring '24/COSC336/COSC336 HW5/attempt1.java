
  
import java.util.Scanner;
import java.util.Stack; 
import java.io.*;
  
public class attempt1 { 
    static int MPSofIS(int[] A){
        
        int i = 0;
        int j = 0;
        int max = 0;
        int[] p = new int[A.length];

        //init all p[i] to their corresponding "starting value" in A[i]
        for (i = 0; i < A.length; i++) {
            p[i] = A[i];
        }

        //find MPS bottom up for each index of A[i]
        for (i = 1; i < A.length; i++){
            for(j = 0; j<i; j++){
                if (A[i] > A[j] && p[i] < p[j] + A[i]){
                    p[i] = p[j] + A[i];
                }
            }
        }

        //store max val in p[i]
        for (i = 0; i < A.length; i++){
            if (max < p[i]){
                max = p[i];
            }
        }

        return max;
    }

    public static void main(String[] args) throws FileNotFoundException
    { 

        File file = new File("input1.txt");                                  //PUT NEW FILES HERE
        Scanner scanner = new Scanner(file);

        int A[] = new int[scanner.nextInt()]; 

        int index = 0;
        while (scanner.hasNextInt()){
            A[index] = scanner.nextInt();
            index++;
        }
        scanner.close();
  
        // Function call 
        System.out.println("Maximum Possible sum of Increasing Subsequences: " + MPSofIS(A));
    } 
} 