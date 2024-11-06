import java.util.*;

public class nlognsolution {
	static int lengthOfLIS(int[] nums) {
		// Binary search approach
		int n = nums.length;
		List<Integer> ans = new ArrayList<>();

		// Initialize the answer list with the
		// first element of nums
		ans.add(nums[0]);

		for (int i = 1; i < n; i++) {
			if (nums[i] > ans.get(ans.size() - 1)) {
				// If the current number is greater
				// than the last element of the answer
				// list, it means we have found a
				// longer increasing subsequence.
				// Hence, we append the current number
				// to the answer list.
				ans.add(nums[i]);
			} else {
				// If the current number is not
				// greater than the last element of
				// the answer list, we perform
				// a binary search to find the smallest
				// element in the answer list that
				// is greater than or equal to the
				// current number.

				// The binarySearch method returns
				// the index of the first element that is not less than
				// the current number.
				int low = Collections.binarySearch(ans, nums[i]);

				// We update the element at the
				// found position with the current number.
				// By doing this, we are maintaining
				// a sorted order in the answer list.
				if (low < 0) {
					low = -(low + 1);
				}
				ans.set(low, nums[i]);
			}
		}

		// The size of the answer list
		// represents the length of the
		// longest increasing subsequence.
		return ans.size();
	}

	// Driver program to test above function
	public static void main(String[] args) {
		int[] nums = {318 , 536 , 390 , 598 , 602 , 408 , 254 , 868 , 379 , 565 , 206 , 619 , 936 , 195 ,
			123 , 314 , 729 , 608 , 148 , 540, 256 , 768 , 404 , 190 , 559 , 1000 , 482 , 141 , 26,
			230 , 550 , 881 , 759 , 122 , 878, 350, 756, 82, 562, 897, 508, 853, 317 ,
			380 , 807 , 23 , 506 , 98 , 757 , 247};
		// Function call
		System.out.println("Length of LIS is " + lengthOfLIS(nums));
	}
}
