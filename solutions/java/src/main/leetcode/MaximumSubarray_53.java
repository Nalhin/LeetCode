// Given an integer array nums, find the contiguous subarray (containing at least
// one number) which has the largest sum and return its sum.
//
// Example:
//
//
// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.
//
//
// Follow up:
//
// If you have figured out the O(n) solution, try coding another solution using
// the divide and conquer approach, which is more subtle.
// Related Topics Array Divide and Conquer Dynamic Programming
// 👍 8741 👎 412

import java.util.Arrays;

// leetcode submit region begin(Prohibit modification and deletion)
public class MaximumSubarray_53 {
  public int maxSubArray(int[] nums) {
    int sum = 0;
    int max_total = Integer.MIN_VALUE;

    for (int num : nums) {
      sum = sum + num;
      max_total = Math.max(max_total, sum);
      if (sum < 0) {
        sum = 0;
      }
    }
    return max_total;
  }
}

/*
  	Runtime:0 ms, faster than 100.00% of Java online submissions.
	Memory Usage:39.2 MB, less than 92.76% of Java online submissions.
*/

// leetcode submit region end(Prohibit modification and deletion)
