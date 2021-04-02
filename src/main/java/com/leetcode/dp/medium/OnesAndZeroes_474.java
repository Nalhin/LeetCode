package com.leetcode.dp.medium;

// You are given an array of binary strings strs and two integers m and n.
//
// Return the size of the largest subset of strs such that there are at most m 0
// 's and n 1's in the subset.
//
// A set x is a subset of a set y if all elements of x are also elements of y.
//
//
// Example 1:
//
//
// Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
// Output: 4
// Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001",
// "1", "0"}, so the answer is 4.
// Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
// {"111001"} is an invalid subset because it contains 4 1's, greater than the ma
// ximum of 3.
//
//
// Example 2:
//
//
// Input: strs = ["10","0","1"], m = 1, n = 1
// Output: 2
// Explanation: The largest subset is {"0", "1"}, so the answer is 2.
//
//
//
// Constraints:
//
//
// 1 <= strs.length <= 600
// 1 <= strs[i].length <= 100
// strs[i] consists only of digits '0' and '1'.
// 1 <= m, n <= 100
//
// Related Topics Dynamic Programming
// 👍 1511 👎 270
/*
  O(n * m * k) Runtime: 33 ms, faster than 76.41% of Java online submissions for Ones and Zeroes.
  O(m * n) Memory Usage: 38.6 MB, less than 63.94% of Java online submissions for Ones and Zeroes.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class OnesAndZeroes_474 {
  public int findMaxForm(String[] strings, int m, int n) {
    int[][] dp = new int[m + 1][n + 1];
    for (String str : strings) {
      int[] counts = countOnesAndZeroes(str);
      for (int zeroes = m; zeroes >= counts[0]; zeroes--) {
        for (int ones = n; ones >= counts[1]; ones--) {
          dp[zeroes][ones] =
              Math.max(dp[zeroes - counts[0]][ones - counts[1]] + 1, dp[zeroes][ones]);
        }
      }
    }
    return dp[m][n];
  }

  private int[] countOnesAndZeroes(String str) {
    int[] result = new int[2];
    for (int i = 0; i < str.length(); i++) {
      result[str.charAt(i) - '0']++;
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
