import java.util.*;
import java.io.*;

//Input 1: 4 pairs: (3,8) (7,8) (1,5) (3,5)
//Input 2: 3936 pairs
//Input 3: 57053 pairs

public class assignment3FINAL {

    public static int stars = 0;                     //counts # of star pairs
    public static void main (String[] args) throws FileNotFoundException{

        File file = new File("10000.txt");
        Scanner scanner = new Scanner(file);

        int[] input = new int[scanner.nextInt()];    //instantiate new array of size (1st element in list)
        int index = 0;
        while (scanner.hasNextInt()){                //populate new array with elements of list
            input[index] = scanner.nextInt();
            index++;
        }

        int start = 0;
        int end = input.length - 1;

        MergeSort(input, start, end);
        System.out.println("sorted: " + Arrays.toString(input));
        System.out.println("total: " + stars);

        
    }

    public static int MergeSort(int[] A, int p, int r){

        if(p >= r){      //0 or 1 element?
            return 0;
        }   
        int q = (int) Math.floor((p + r)/2);  //midpoint of A[p:r]
        MergeSort(A, p, q);                   //recursively sort A[p:q]
        MergeSort(A, q + 1, r);               //recursively sort A[q+1:r]

        //Merge A[p:q] and A[q+1:r] into A[p:r]
        Merge(A, p, q, r);
        System.out.println("found: " + stars);
        return stars;
    }

    public static int Merge(int[] A, int p, int q, int r){
        int newLeft = q - p + 1 ;          //length of A[p:q]
        int newRight = r - q;              //length of A[q+1:r]
        int[] L = new int[newLeft];    // -1?
        int[] R = new int[newRight];    //-1?

        for (int i = 0; i <= newLeft - 1; i++){ //copy A[p:q] into L[0:newLeft-1]
            L[i] = A[p + i];
        }

        for (int j = 0; j <= newRight - 1; j++){ //copy A[q+1:r] into R[0:newRight-1]
            R[j] = A[q + j + 1];
        }

        int i = 0;          //i indexes the smallest remaining element in L
        int j = 0;          //j indexes the smallest remaining element in R
        int k = p;          //k indexes the location in A to fill
        //as long as each of the arrays L and R contains an unmerged element,
        //copy the smallest unmerged element back into A[p:r].
        while (i < newLeft && j < newRight){
            if (L[i] <= R[j]){
                A[k] = L[i];
                if (L[i] < R[j]){
                    stars++;                                                               //increment *pair counter
                    System.out.println("*-pair found: (" + L[i] +", "+ R[j] + ")");       //print out found *pair
                }
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }
        //having gone through one of L and R entirely, copy the
        //remainder of the other to the end of A[p:r].
        while (i < newLeft){
            A[k] = L[i];
            i++;
            k++;
        }
        while (j < newRight){
            A[k] = R[j];
            j++;
            k++;
        }
        return stars; //save value here!
    }
}
