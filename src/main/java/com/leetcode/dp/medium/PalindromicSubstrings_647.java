package com.leetcode.dp.medium;

// Given a string, your task is to count how many palindromic substrings in this
// string.
//
// The substrings with different start indexes or end indexes are counted as dif
// ferent substrings even they consist of same characters.
//
// Example 1:
//
//
// Input: "abc"
// Output: 3
// Explanation: Three palindromic strings: "a", "b", "c".
//
//
//
//
// Example 2:
//
//
// Input: "aaa"
// Output: 6
// Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
//
//
//
//
// Note:
//
//
// The input string length won't exceed 1000.
//
//
// Related Topics String Dynamic Programming
// 👍 3511 👎 133

// leetcode submit region begin(Prohibit modification and deletion)

public class PalindromicSubstrings_647 {

  /*
   O(n^2) Runtime: 22 ms, faster than 19.62% of Java online submissions for Palindromic Substrings.
   O(n^2) Memory Usage: 42.9 MB, less than 9.75% of Java online submissions for Palindromic Substrings.
  */
  static class Dp {
    public int countSubstrings(String s) {
      boolean[][] dp = new boolean[s.length()][s.length()];
      int result = 0;
      for (int i = 0; i < s.length(); i++) {
        for (int j = i; j < s.length(); j++) {
          if (isPalindromic(dp, i, j, s)) {
            result++;
          }
        }
      }

      return result;
    }

    public boolean isPalindromic(boolean[][] dp, int left, int right, String str) {
      if (left >= right) {
        return true;
      }
      if (str.charAt(left) != str.charAt(right)) {
        return false;
      }

      if (dp[left + 1][right - 1]) {
        dp[left][right] = true;
        return true;
      }

      dp[left][right] = isPalindromic(dp, left + 1, right - 1, str);
      return dp[left][right];
    }
  }
  /*
   O(n^2) Runtime: 2 ms, faster than 96.45% of Java online submissions for Palindromic Substrings.
   O(1) Memory Usage: 37.1 MB, less than 81.49% of Java online submissions for Palindromic Substrings.
  */
  static class Expand {
    public int countSubstrings(String s) {
      int result = 0;
      for (int i = 0; i < s.length(); i++) {
        result += expandAround(i, i, s);
        result += expandAround(i, i + 1, s);
      }

      return result;
    }

    private int expandAround(int left, int right, String str) {
      int count = 0;
      while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
        left--;
        right++;
        count++;
      }
      return count;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
