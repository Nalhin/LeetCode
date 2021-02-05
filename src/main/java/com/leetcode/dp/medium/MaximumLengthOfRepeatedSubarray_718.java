package com.leetcode.dp.medium;

// Given two integer arrays A and B, return the maximum length of an subarray tha
// t appears in both arrays.
//
// Example 1:
//
//
// Input:
// A: [1,2,3,2,1]
// B: [3,2,1,4,7]
// Output: 3
// Explanation:
// The repeated subarray with maximum length is [3, 2, 1].
//
//
//
//
// Note:
//
//
// 1 <= len(A), len(B) <= 1000
// 0 <= A[i], B[i] < 100
//
//
//
// Related Topics Array Hash Table Binary Search Dynamic Programming
// 👍 1770 👎 49

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(mn) Runtime: 38 ms, faster than 84.18% of Java online submissions for Maximum Length of Repeated Subarray.
 O(mn) Memory Usage: 47.9 MB, less than 67.58% of Java online submissions for Maximum Length of Repeated Subarray.
*/
public class MaximumLengthOfRepeatedSubarray_718 {
  public int findLength(int[] A, int[] B) {
    int m = A.length;
    int n = B.length;
    int[][] dp = new int[m + 1][n + 1];

    int result = 0;

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (A[i - 1] == B[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
          result = Math.max(dp[i][j], result);
        }
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
