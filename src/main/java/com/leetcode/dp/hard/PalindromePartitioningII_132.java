package com.leetcode.dp.hard;

// Given a string s, partition s such that every substring of the partition is a
// palindrome.
//
// Return the minimum cuts needed for a palindrome partitioning of s.
//
//
// Example 1:
//
//
// Input: s = "aab"
// Output: 1
// Explanation: The palindrome partitioning ["aa","b"] could be produced using 1
// cut.
//
//
// Example 2:
//
//
// Input: s = "a"
// Output: 0
//
//
// Example 3:
//
//
// Input: s = "ab"
// Output: 1
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 2000
// s consists of lower-case English letters only.
//
// Related Topics String Dynamic Programming
// 👍 2472 👎 68

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class PalindromePartitioningII_132 {
  /*
    O(n^3) Runtime: 80 ms, faster than 23.88% of Java online submissions for Palindrome Partitioning II..
    O(n^2) Memory Usage: 72 MB, less than 8.17% of Java online submissions for Palindrome Partitioning II.
  */
  static class TopDown {

    public int minCut(String s) {
      int[] dp = new int[s.length()];
      Boolean[][] palindromeMemo = new Boolean[s.length()][s.length()];

      Arrays.fill(dp, s.length() + 1);

      return memo(0, s.length() - 1, s, dp, palindromeMemo);
    }

    private int memo(int startIdx, int endIdx, String str, int[] dp, Boolean[][] palindromeMemo) {
      if (startIdx == endIdx || isPalindrome(startIdx, endIdx, str, palindromeMemo)) {
        return 0;
      }
      if (dp[startIdx] <= str.length()) {
        return dp[startIdx];
      }

      int curr = str.length() + 1;
      for (int i = startIdx; i < endIdx; i++) {
        if (isPalindrome(startIdx, i, str, palindromeMemo)) {
          curr = Math.min(curr, memo(i + 1, endIdx, str, dp, palindromeMemo) + 1);
        }
      }

      dp[startIdx] = curr;
      return curr;
    }

    private boolean isPalindrome(int startIdx, int endIdx, String str, Boolean[][] palindromeMemo) {
      if (startIdx >= endIdx) {
        return true;
      }

      if (palindromeMemo[startIdx][endIdx] != null) {
        return palindromeMemo[startIdx][endIdx];
      }

      return palindromeMemo[startIdx][endIdx] =
          (str.charAt(startIdx) == str.charAt(endIdx))
              && isPalindrome(startIdx + 1, endIdx - 1, str, palindromeMemo);
    }
  }

  /*
   O(n^2) Runtime: 4 ms, faster than 95.23% of Java online submissions for Palindrome Partitioning II.
   O(n) Memory Usage: 39.2 MB, less than 83.64% of Java online submissions for Palindrome Partitioning II.
  */
  static class ExpandAroundCenter {

    public int minCut(String s) {
      int[] dp = new int[s.length()];

      for (int i = 0; i < s.length(); i++) {
        dp[i] = i;
      }

      for (int i = 0; i < s.length(); i++) {
        expandAround(i, i, s, dp);
        expandAround(i - 1, i, s, dp);
      }

      return dp[s.length() - 1];
    }

    private void expandAround(int startLeft, int startRight, String str, int[] dp) {
      while (startLeft >= 0
          && startRight < dp.length
          && str.charAt(startLeft) == str.charAt(startRight)) {
        dp[startRight] = Math.min(startLeft == 0 ? 0 : dp[startLeft - 1] + 1, dp[startRight]);
        startLeft--;
        startRight++;
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
