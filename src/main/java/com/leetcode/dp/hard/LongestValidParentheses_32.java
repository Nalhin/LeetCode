package com.leetcode.dp.hard;

// Given a string containing just the characters '(' and ')', find the length of
// the longest valid (well-formed) parentheses substring.
//
//
// Example 1:
//
//
// Input: s = "(()"
// Output: 2
// Explanation: The longest valid parentheses substring is "()".
//
//
// Example 2:
//
//
// Input: s = ")()())"
// Output: 4
// Explanation: The longest valid parentheses substring is "()()".
//
//
// Example 3:
//
//
// Input: s = ""
// Output: 0
//
//
//
// Constraints:
//
//
// 0 <= s.length <= 3 * 104
// s[i] is '(', or ')'.
//
// Related Topics String Dynamic Programming
// 👍 5107 👎 185

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses_32 {

  /*
   O(n) Runtime: 1 ms, faster than 100.00% of Java online submissions for Longest Valid Parentheses.
   O(n) Memory Usage: 39.3 MB, less than 27.89% of Java online submissions for Longest Valid Parentheses.
  */
  static class Dp {
    public int longestValidParentheses(String s) {
      int[] dp = new int[s.length()];
      int result = 0;

      for (int i = 1; i < dp.length; i++) {
        if (s.charAt(i) == ')') {
          int closing = i - dp[i - 1] - 1;
          if (s.charAt(i - 1) == '(') {
            dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
          } else if (closing >= 0 && s.charAt(closing) == '(') {
            int before = (closing - 1) >= 0 ? dp[closing - 1] : 0;
            dp[i] = dp[i - 1] + before + 2;
          }
        }
        result = Math.max(result, dp[i]);
      }

      return result;
    }
  }
  /*
    O(n) Runtime: 2 ms, faster than 69.03% of Java online submissions for Longest Valid Parentheses.
    O(n) Memory Usage: 38.5 MB, less than 98.06% of Java online submissions for Longest Valid Parentheses.
  */
  static class Stack {
    public int longestValidParentheses(String s) {

      Deque<Integer> stack = new ArrayDeque<>();
      stack.push(-1);
      int result = 0;

      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == ')') {
          stack.pop();
          if (stack.isEmpty()) {
            stack.push(i);
          } else {
            result = Math.max(result, i - stack.peek());
          }

        } else {
          stack.push(i);
        }
      }

      return result;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
