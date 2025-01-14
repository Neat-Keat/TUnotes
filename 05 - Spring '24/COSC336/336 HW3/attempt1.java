import java.util.Arrays;

public class attempt1 {

    int starPairs = 0;
    public static void main (String[] args){
        int[] input = new int[] {7, 3, 8, 1, 5};    //put new arrays here!
        int start = 0;
        int end = input.length - 1;

        MergeSort(input, start, end, starPairs);
        System.out.println("sorted: " + Arrays.toString(input));

        
        
    }

    public void MergeSort(int[] A, int p, int r, int s){
        if(p >= r){      //0 or 1 element?
            return;
        }   
        int q = (int) Math.floor((p + r)/2);  //midpoint of A[p:r]
        MergeSort(A, p, q, s);                   //recursively sort A[p:q]
        MergeSort(A, q + 1, r, s);               //recursively sort A[q+1:r]

        //Merge A[p:q] and A[q+1:r] into A[p:r]
        s = s + Merge(A, p, q, r, s);
    }

    public int Merge(int[] A, int p, int q, int r, int s){
        int newLeft = q - p + 1 ;          //length of A[p:q]
        int newRight = r - q;              //length of A[q+1:r]
        int[] L = new int[newLeft];
        int[] R = new int[newRight];

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
                s++;                                                               //increment *pair counter
                System.out.println("*-pair found: (" + L[i] +", "+ R[j] + ")");    //print out found *pair
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
        return s;
    }
}
