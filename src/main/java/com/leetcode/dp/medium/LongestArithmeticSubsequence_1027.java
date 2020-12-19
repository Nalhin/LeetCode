package com.leetcode.dp.medium;

// Given an array A of integers, return the length of the longest arithmetic subs
// equence in A.
//
// Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] with 0 <
// = i_1 < i_2 < ... < i_k <= A.length - 1, and that a sequence B is arithmetic if
// B[i+1] - B[i] are all the same value (for 0 <= i < B.length - 1).
//
//
// Example 1:
//
//
// Input: A = [3,6,9,12]
// Output: 4
// Explanation:
// The whole array is an arithmetic sequence with steps of length = 3.
//
//
// Example 2:
//
//
// Input: A = [9,4,7,2,10]
// Output: 3
// Explanation:
// The longest arithmetic subsequence is [4,7,10].
//
//
// Example 3:
//
//
// Input: A = [20,1,15,3,10,5,8]
// Output: 4
// Explanation:
// The longest arithmetic subsequence is [20,15,10,5].
//
//
//
// Constraints:
//
//
// 2 <= A.length <= 1000
// 0 <= A[i] <= 500
//
// Related Topics Dynamic Programming
// 👍 1026 👎 53

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 47 ms, faster than 89.88% of Java online submissions for Longest Arithmetic Subsequence.
 O(n) Memory Usage: 48.1 MB, less than 86.48% of Java online submissions for Longest Arithmetic Subsequence.
*/
public class LongestArithmeticSubsequence_1027 {
  public int longestArithSeqLength(int[] nums) {
    int[][] dp = new int[nums.length][1001];

    int ans = 0;

    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        int diff = nums[i] - nums[j] + 500;
        dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] + 1);
        ans = Math.max(ans, dp[i][diff]);
      }
    }

    return ans + 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
