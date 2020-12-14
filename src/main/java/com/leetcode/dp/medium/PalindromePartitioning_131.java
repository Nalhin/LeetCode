package com.leetcode.dp.medium;

// Given a string s, partition s such that every substring of the partition is a
// palindrome. Return all possible palindrome partitioning of s.
//
// A palindrome string is a string that reads the same backward as forward.
//
//
// Example 1:
// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]
// Example 2:
// Input: s = "a"
// Output: [["a"]]
//
//
// Constraints:
//
//
// 1 <= s.length <= 16
// s contains only lowercase English letters.
//
// Related Topics Dynamic Programming Backtracking Depth-first Search
// 👍 2643 👎 88

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
/*
 O(n * 2^n) Runtime: 8 ms, faster than 17.28% of Java online submissions for Palindrome Partitioning.
 O(n^2) Memory Usage: 53.2 MB, less than 5.31% of Java online submissions for Palindrome Partitioning.
*/
public class PalindromePartitioning_131 {
  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    boolean[][] dp = new boolean[s.length()][s.length()];
    dfs(s, 0, result, new ArrayList<>(), dp);
    return result;
  }

  private void dfs(
      String s, int start, List<List<String>> result, List<String> currentList, boolean[][] dp) {

    if (start >= s.length()) {
      result.add(new ArrayList<>(currentList));
    }

    for (int end = start; end < s.length(); end++) {
      if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
        dp[start][end] = true;
        currentList.add(s.substring(start, end + 1));
        dfs(s, end + 1, result, currentList, dp);
        currentList.remove(currentList.size() - 1);
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
