package com.leetcode.dp.medium;

// Given two strings word1 and word2, return the minimum number of steps required
// to make word1 and word2 the same.
//
// In one step, you can delete exactly one character in either string.
//
//
// Example 1:
//
//
// Input: word1 = "sea", word2 = "eat"
// Output: 2
// Explanation: You need one step to make "sea" to "ea" and another step to make
// "eat" to "ea".
//
//
// Example 2:
//
//
// Input: word1 = "leetcode", word2 = "etco"
// Output: 4
//
//
//
// Constraints:
//
//
// 1 <= word1.length, word2.length <= 500
// word1 and word2 consist of only lowercase English letters.
//
// Related Topics String
// 👍 1628 👎 37
/*
 O(n * m) Runtime: 9 ms, faster than 21.66% of Java online submissions for Delete Operation for Two Strings.
 O(n * m) Memory Usage: 40.2 MB, less than 9.15% of Java online submissions for Delete Operation for Two Strings.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class DeleteOperationForTwoStrings_583 {
  public int minDistance(String word1, String word2) {
    int[][] dp = new int[word1.length()][word2.length()];
    for (int[] row : dp) {
      Arrays.fill(row, word1.length() + word2.length() + 1);
    }
    return dfs(0, 0, word1, word2, dp);
  }

  private int dfs(int pos1, int pos2, String word1, String word2, int[][] dp) {
    if (pos1 >= word1.length()) {
      return word2.length() - pos2;
    }
    if (pos2 >= word2.length()) {
      return word1.length() - pos1;
    }

    if (dp[pos1][pos2] <= word1.length() + word2.length()) {
      return dp[pos1][pos2];
    }

    if (word1.charAt(pos1) == word2.charAt(pos2)) {
      dp[pos1][pos2] = Math.min(dfs(pos1 + 1, pos2 + 1, word1, word2, dp), dp[pos1][pos2]);
    } else {
      int diff =
          Math.min(dfs(pos1 + 1, pos2, word1, word2, dp), dfs(pos1, pos2 + 1, word1, word2, dp))
              + 1;
      dp[pos1][pos2] = Math.min(diff, dp[pos1][pos2]);
    }

    return dp[pos1][pos2];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
