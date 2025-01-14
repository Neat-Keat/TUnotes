import java.util.*;
/* Dynamic Programming Java 
implementation of Maximum Sum 
Increasing Subsequence (MSIS) 
problem */
class GFG 
{ 
	/* maxSumIS() returns the 
	maximum sum of increasing 
	subsequence in arr[] of size n */
	static int maxSumIS(int arr[], int n) 
	{ 
		int i, j, max = 0; 
		int[] msis = new int[n]; 

		/* Initialize msis values 
		for all indexes */
		for (i = 0; i < n; i++) 
			msis[i] = arr[i]; 

		/* Compute maximum sum values 
		in bottom up manner */
		for (i = 1; i < n; i++) 
			for (j = 0; j < i; j++) 
				if (arr[i] >= arr[j] &&              //changed to >= from > to accommodate for the 5 5 5 case in input 1
					msis[i] < msis[j] + arr[i]) 
					msis[i] = msis[j] + arr[i]; 

		/* Pick maximum of all 
		msis values */

        System.out.println("max values per index: " + Arrays.toString(msis));

		for (i = 0; i < n; i++) 
			if (max < msis[i]) 
				max = msis[i]; 

		return max; 
	} 

	// Driver code 
	public static void main(String args[]) 
	{ 
		//int arr[] = new int[]{1, 14, 5, 5, 2, 5};
        //int arr[] = new int[]{41, 18467, 6334, 26500, 19169, 15724, 11478, 29358, 26962, 24464, 30000, 30000};
        //int arr[] = new int[]{50000, 25053, 4601, 4540, 20255, 23073, 17419, 10282, 3621, 32092, 945, 50000};
        int arr[] = new int[]{25197, 18779, 4132, 30465, 18162, 26355, 16158, 5893, 4938, 25342, 29960, 3947, 4841, 1006, 9238, 30953, 28094, 15299, 30936, 30953};
		int n = arr.length; 
		System.out.println("Sum of maximum sum "+ 
							"increasing subsequence is "+ 
							maxSumIS(arr, n)); 
	} 
} 

// This code is contributed 
// by Rajat Mishra 
