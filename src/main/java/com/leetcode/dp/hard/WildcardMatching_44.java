package com.leetcode.dp.hard;

// Given an input string (s) and a pattern (p), implement wildcard pattern matchi
// ng with support for '?' and '*' where:
//
//
// '?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).
//
//
// The matching should cover the entire input string (not partial).
//
//
// Example 1:
//
//
// Input: s = "aa", p = "a"
// Output: false
// Explanation: "a" does not match the entire string "aa".
//
//
// Example 2:
//
//
// Input: s = "aa", p = "*"
// Output: true
// Explanation: '*' matches any sequence.
//
//
// Example 3:
//
//
// Input: s = "cb", p = "?a"
// Output: false
// Explanation: '?' matches 'c', but the second letter is 'a', which does not mat
// ch 'b'.
//
//
// Example 4:
//
//
// Input: s = "adceb", p = "*a*b"
// Output: true
// Explanation: The first '*' matches the empty sequence, while the second '*' ma
// tches the substring "dce".
//
//
// Example 5:
//
//
// Input: s = "acdcb", p = "a*c?b"
// Output: false
//
//
//
// Constraints:
//
//
// 0 <= s.length, p.length <= 2000
// s contains only lowercase English letters.
// p contains only lowercase English letters, '?' or '*'.
//
// Related Topics String Dynamic Programming Backtracking Greedy
// 👍 2599 👎 126

import java.util.Arrays;
/*
 O(n * m) Runtime: 30 ms, faster than 24.17% of Java online submissions for Wildcard Matching.
 O(n * m) Memory Usage: 52 MB, less than 5.46% of Java online submissions for Wildcard Matching.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class WildcardMatching_44 {
  public boolean isMatch(String s, String p) {
    Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
    matchDfs(dp, s, p, 0, 0);
    return dp[0][0] != null && dp[0][0];
  }

  private boolean matchDfs(
      Boolean[][] dp, String word, String pattern, int startWord, int startPattern) {
    if (startPattern >= pattern.length()) {
      return startWord >= word.length();
    }

    if (startWord > word.length()
        || (startWord == word.length() && pattern.charAt(startPattern) != '*')) {
      return false;
    }

    if (dp[startWord][startPattern] != null) {
      return dp[startWord][startPattern];
    }

    char pChar = pattern.charAt(startPattern);
    if (pChar == '*') {
      dp[startWord][startPattern] =
          matchDfs(dp, word, pattern, startWord, startPattern + 1)
              || matchDfs(dp, word, pattern, startWord + 1, startPattern);

    } else if (pChar == '?') {
      dp[startWord][startPattern] = matchDfs(dp, word, pattern, startWord + 1, startPattern + 1);
    } else {
      dp[startWord][startPattern] =
          word.charAt(startWord) == pattern.charAt(startPattern)
              && matchDfs(dp, word, pattern, startWord + 1, startPattern + 1);
    }

    return dp[startWord][startPattern];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
