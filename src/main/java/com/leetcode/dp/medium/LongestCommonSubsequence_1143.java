package com.leetcode.dp.medium;

// Given two strings text1 and text2, return the length of their longest common s
// ubsequence.
//
// A subsequence of a string is a new string generated from the original string
// with some characters(can be none) deleted without changing the relative order of
// the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is
// not). A common subsequence of two strings is a subsequence that is common to bo
// th strings.
//
//
//
// If there is no common subsequence, return 0.
//
//
// Example 1:
//
//
// Input: text1 = "abcde", text2 = "ace"
// Output: 3
// Explanation: The longest common subsequence is "ace" and its length is 3.
//
//
// Example 2:
//
//
// Input: text1 = "abc", text2 = "abc"
// Output: 3
// Explanation: The longest common subsequence is "abc" and its length is 3.
//
//
// Example 3:
//
//
// Input: text1 = "abc", text2 = "def"
// Output: 0
// Explanation: There is no such common subsequence, so the result is 0.
//
//
//
// Constraints:
//
//
// 1 <= text1.length <= 1000
// 1 <= text2.length <= 1000
// The input strings consist of lowercase English characters only.
//
// Related Topics Dynamic Programming
// 👍 2209 👎 29

// leetcode submit region begin(Prohibit modification and deletion)
/*
  O(n * m) Runtime: 9 ms, faster than 77.42% of Java online submissions for Longest Common Subsequence.
  O(n * m) Memory Usage: 42.5 MB, less than 76.83% of Java online submissions for Longest Common Subsequence.
*/
public class LongestCommonSubsequence_1143 {
  public int longestCommonSubsequence(String text1, String text2) {
    int[][] dp = new int[text1.length() + 1][text2.length() + 1];

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[i].length; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[text1.length()][text2.length()];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
