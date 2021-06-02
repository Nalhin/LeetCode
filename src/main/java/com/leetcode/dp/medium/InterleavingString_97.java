package com.leetcode.dp.medium;

// Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of
// s1 and s2.
//
// An interleaving of two strings s and t is a configuration where they are divi
// ded into non-empty substrings such that:
//
//
// s = s1 + s2 + ... + sn
// t = t1 + t2 + ... + tm
// |n - m| <= 1
// The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 +
// t3 + s3 + ...
//
//
// Note: a + b is the concatenation of strings a and b.
//
//
// Example 1:
//
//
// Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
// Output: true
//
//
// Example 2:
//
//
// Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
// Output: false
//
//
// Example 3:
//
//
// Input: s1 = "", s2 = "", s3 = ""
// Output: true
//
//
//
// Constraints:
//
//
// 0 <= s1.length, s2.length <= 100
// 0 <= s3.length <= 200
// s1, s2, and s3 consist of lowercase English letters.
//
//
//
// Follow up: Could you solve it using only O(s2.length) additional memory space
// ?
// Related Topics String Dynamic Programming
// 👍 2230 👎 114

// leetcode submit region begin(Prohibit modification and deletion)
public class InterleavingString_97 {
  /*
   O(n * m) Runtime: 5 ms, faster than 39.69% of Java online submissions for Interleaving String.
   O(n * m) Memory Usage: 38.8 MB, less than 14.88% of Java online submissions for Interleaving String.
  */
  static class TwoDimensionalDp {
    public boolean isInterleave(String s1, String s2, String s3) {
      if (s1.length() + s2.length() != s3.length()) {
        return false;
      }

      boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

      for (int i = 0; i <= s1.length(); i++) {
        for (int j = 0; j <= s2.length(); j++) {
          if (i == 0 && j == 0) {
            dp[i][j] = true;
          } else if (i > 0 && dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
            dp[i][j] = true;
          } else if (j > 0 && dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
            dp[i][j] = true;
          }
        }
      }

      return dp[s1.length()][s2.length()];
    }
  }
  /*
    O(n * m) Runtime: 2 ms, faster than 79.94% of Java online submissions for Interleaving String.
    O(m) Memory Usage: 37.2 MB, less than 67.89% of Java online submissions for Interleaving String.
  */
  static class SingleDimensionalDp {
    public boolean isInterleave(String s1, String s2, String s3) {
      if (s1.length() + s2.length() != s3.length()) {
        return false;
      }
      boolean[] prevDp = new boolean[s2.length() + 1];

      for (int i = 0; i <= s1.length(); i++) {
        boolean[] currDp = new boolean[s2.length() + 1];
        for (int j = 0; j <= s2.length(); j++) {
          if (i == 0 && j == 0) {
            currDp[j] = true;
          } else if (i > 0 && prevDp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
            currDp[j] = true;
          } else if (j > 0 && currDp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
            currDp[j] = true;
          }
        }
        prevDp = currDp;
      }

      return prevDp[s2.length()];
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
