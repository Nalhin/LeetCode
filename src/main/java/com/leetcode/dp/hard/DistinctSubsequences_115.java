package com.leetcode.dp.hard;

// Given two strings s and t, return the number of distinct subsequences of s
// which equals t.
//
// A string's subsequence is a new string formed from the original string by
// deleting some (can be none) of the characters without disturbing the remaining
// characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while
// "AEC" is not).
//
// It is guaranteed the answer fits on a 32-bit signed integer.
//
//
// Example 1:
//
//
// Input: s = "rabbbit", t = "rabbit"
// Output: 3
// Explanation:
// As shown below, there are 3 ways you can generate "rabbit" from S.
// rabbbit
// rabbbit
// rabbbit
//
//
// Example 2:
//
//
// Input: s = "babgbag", t = "bag"
// Output: 5
// Explanation:
// As shown below, there are 5 ways you can generate "bag" from S.
// babgbag
// babgbag
// babgbag
// babgbag
// babgbag
//
//
// Constraints:
//
//
// 1 <= s.length, t.length <= 1000
// s and t consist of English letters.
//
// Related Topics String Dynamic Programming 👍 2548 👎 110

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class DistinctSubsequences_115 {
  /*
    O(n*m) Runtime: 9 ms, faster than 60.28% of Java online submissions for Distinct Subsequences.
    O(n*m) Memory Usage: 43 MB, less than 53.92% of Java online submissions for Distinct Subsequences.
  */
  static class Memo {
    public int numDistinct(String s, String t) {
      int[][] memo = new int[s.length()][t.length()];

      for (int[] row : memo) {
        Arrays.fill(row, -1);
      }

      recurse(0, 0, s, t, memo);

      return memo[0][0];
    }

    private int recurse(int firstPos, int secondPos, String s1, String s2, int[][] memo) {
      if (secondPos >= s2.length()) {
        return 1;
      }

      if (firstPos >= s1.length()) {
        return 0;
      }

      if (memo[firstPos][secondPos] != -1) {
        return memo[firstPos][secondPos];
      }

      int result = 0;
      if (s1.charAt(firstPos) == s2.charAt(secondPos)) {
        result += recurse(firstPos + 1, secondPos + 1, s1, s2, memo);
      }
      result += recurse(firstPos + 1, secondPos, s1, s2, memo);

      memo[firstPos][secondPos] = result;

      return result;
    }
  }
  /*
   O(n*m) Runtime: 10 ms, faster than 39.44% of Java online submissions for Distinct Subsequences.
   O(n*m) Memory Usage: 43 MB, less than 53.92% of Java online submissions for Distinct Subsequences.
  */
  static class Iterative {
    public int numDistinct(String s, String t) {
      int[][] dp = new int[s.length() + 1][t.length() + 1];

      for (int i = 0; i <= s.length(); i++) {
        dp[i][t.length()] = 1;
      }

      for (int i = s.length() - 1; i >= 0; i--) {
        for (int j = t.length() - 1; j >= 0; j--) {

          if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] += dp[i + 1][j + 1];
          }
          dp[i][j] += dp[i + 1][j];
        }
      }

      return dp[0][0];
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
