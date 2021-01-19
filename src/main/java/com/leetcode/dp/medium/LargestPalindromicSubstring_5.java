package com.leetcode.dp.medium;

// Given a string s, return the longest palindromic substring in s.
//
//
// Example 1:
//
//
// Input: s = "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.
//
//
// Example 2:
//
//
// Input: s = "cbbd"
// Output: "bb"
//
//
// Example 3:
//
//
// Input: s = "a"
// Output: "a"
//
//
// Example 4:
//
//
// Input: s = "ac"
// Output: "a"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 1000
// s consist of only digits and English letters (lower-case and/or upper-case),
//
//
// Related Topics String Dynamic Programming
// 👍 9320 👎 627

// leetcode submit region begin(Prohibit modification and deletion)

public class LargestPalindromicSubstring_5 {
  /*
   O(n^2) Runtime: 24 ms, faster than 82.39% of Java online submissions for Longest Palindromic Substring.
   O(1) Memory Usage: 39.6 MB, less than 42.66% of Java online submissions for Longest Palindromic Substring.
  */
  static class CenterExpansion {

    public String longestPalindrome(String s) {
      int[] best = new int[] {0, 0};

      for (int i = 0; i < s.length(); i++) {
        int[] odd = maxSubstrFromCenter(s, i, i);
        int[] even = maxSubstrFromCenter(s, i, i + 1);

        if (odd[1] - odd[0] > best[1] - best[0]) {
          best = odd;
        }
        if (even[1] - even[0] > best[1] - best[0]) {
          best = even;
        }
      }

      return s.substring(best[0], best[1] + 1);
    }

    private int[] maxSubstrFromCenter(String str, int left, int right) {
      while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
        left--;
        right++;
      }
      return new int[] {left + 1, right - 1};
    }
  }

  static class Dp {
    /*
     O(n^2) Runtime: 179 ms, faster than 35.57% of Java online submissions for Longest Palindromic Substring.
     O(n^2) Memory Usage: 42.9 MB, less than 25.33% of Java online submissions for Longest Palindromic Substring.
    */
    public String longestPalindrome(String s) {
      boolean[][] dp = new boolean[s.length()][s.length()];
      int maxLeft = 0;
      int maxRight = 0;

      for (int i = 0; i < s.length(); i++) {
        dp[i][i] = true;
      }

      for (int right = 0; right < s.length(); right++) {
        for (int left = 0; left < right; left++) {
          if (s.charAt(right) == s.charAt(left) && (dp[left + 1][right - 1] || right - left == 1)) {
            dp[left][right] = true;
            if (right - left > maxRight - maxLeft) {
              maxLeft = left;
              maxRight = right;
            }
          }
        }
      }
      return s.substring(maxLeft, maxRight + 1);
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
