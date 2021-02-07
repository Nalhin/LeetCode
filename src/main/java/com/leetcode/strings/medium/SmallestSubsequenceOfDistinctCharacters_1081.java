package com.leetcode.strings.medium;

// Return the lexicographically smallest subsequence of s that contains all the d
// istinct characters of s exactly once.
//
// Note: This question is the same as 316: https://leetcode.com/problems/remove-
// duplicate-letters/
//
//
// Example 1:
//
//
// Input: s = "bcabc"
// Output: "abc"
//
//
// Example 2:
//
//
// Input: s = "cbacdcbc"
// Output: "acdb"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 1000
// s consists of lowercase English letters.
//
// Related Topics String Stack Greedy
// 👍 784 👎 107

import java.util.ArrayDeque;
import java.util.Deque;
/*
  O(n) Runtime: 2 ms, faster than 93.08% of Java online submissions for Smallest Subsequence of Distinct Characters.
  O(n) Memory Usage: 36.9 MB, less than 93.67% of Java online submissions for Smallest Subsequence of Distinct Characters.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class SmallestSubsequenceOfDistinctCharacters_1081 {
  public String smallestSubsequence(String s) {
    int[] lastPositions = new int[26];
    for (int i = 0; i < s.length(); i++) {
      lastPositions[s.charAt(i) - 'a'] = i;
    }

    Deque<Character> stack = new ArrayDeque<>();
    boolean[] visited = new boolean[26];

    for (int i = 0; i < s.length(); i++) {
      int charIndex = s.charAt(i) - 'a';
      while (!stack.isEmpty()
          && !visited[charIndex]
          && stack.peek() > s.charAt(i)
          && lastPositions[stack.peek() - 'a'] > i) {
        visited[stack.pop() - 'a'] = false;
      }
      if (!visited[charIndex]) {
        stack.push(s.charAt(i));
        visited[charIndex] = true;
      }
    }

    StringBuilder sb = new StringBuilder();

    while (!stack.isEmpty()) {
      sb.append(stack.pollLast());
    }

    return sb.toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
