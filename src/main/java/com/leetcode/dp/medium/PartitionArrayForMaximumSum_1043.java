package com.leetcode.dp.medium;

// Given an integer array arr, you should partition the array into (contiguous) s
// ubarrays of length at most k. After partitioning, each subarray has their values
// changed to become the maximum value of that subarray.
//
// Return the largest sum of the given array after partitioning.
//
//
// Example 1:
//
//
// Input: arr = [1,15,7,9,2,5,10], k = 3
// Output: 84
// Explanation: arr becomes [15,15,15,9,10,10,10]
//
//
// Example 2:
//
//
// Input: arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
// Output: 83
//
//
// Example 3:
//
//
// Input: arr = [1], k = 1
// Output: 1
//
//
//
// Constraints:
//
//
// 1 <= arr.length <= 500
// 0 <= arr[i] <= 109
// 1 <= k <= arr.length
//
// Related Topics Dynamic Programming
// 👍 969 👎 122

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(nk) Runtime: 12 ms, faster than 19.43% of Java online submissions for Partition Array for Maximum Sum.
 O(n) Memory Usage: 39.8 MB, less than 14.49% of Java online submissions for Partition Array for Maximum Sum.
*/
public class PartitionArrayForMaximumSum_1043 {
  public int maxSumAfterPartitioning(int[] arr, int k) {
    int[] dp = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      int max = 0;
      for (int j = 0; j < k && i + j < arr.length; j++) {
        max = Math.max(max, arr[i + j]);
        dp[i + j] = Math.max(dp[i + j], max * (j + 1) + (i - 1 >= 0 ? dp[i - 1] : 0));
      }
    }

    return dp[arr.length - 1];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
