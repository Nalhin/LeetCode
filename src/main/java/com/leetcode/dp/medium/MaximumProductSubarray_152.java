package com.leetcode.dp.medium;

// Given an integer array nums, find the contiguous subarray within an array (con
// taining at least one number) which has the largest product.
//
// Example 1:
//
//
// Input: [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.
//
//
// Example 2:
//
//
// Input: [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
// Related Topics Array Dynamic Programming
// 👍 5734 👎 191

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 1 ms, faster than 93.43% of Java online submissions for Maximum Product Subarray.
 O(1) Memory Usage: 39.3 MB, less than 7.02% of Java online submissions for Maximum Product Subarray.
*/
public class MaximumProductSubarray_152 {
  public int maxProduct(int[] nums) {
    int max = nums[0];
    int min = nums[0];
    int result = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      int temp = Math.max(num, Math.max(max * num, min * num));
      min = Math.min(num, Math.min(max * num, min * num));
      max = temp;
      result = Math.max(max, result);
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
