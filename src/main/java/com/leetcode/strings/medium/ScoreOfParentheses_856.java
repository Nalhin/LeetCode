package com.leetcode.strings.medium;

// Given a balanced parentheses string S, compute the score of the string based o
// n the following rule:
//
//
// () has score 1
// AB has score A + B, where A and B are balanced parentheses strings.
// (A) has score 2 * A, where A is a balanced parentheses string.
//
//
//
//
//
// Example 1:
//
//
// Input: "()"
// Output: 1
//
//
//
// Example 2:
//
//
// Input: "(())"
// Output: 2
//
//
//
// Example 3:
//
//
// Input: "()()"
// Output: 2
//
//
//
// Example 4:
//
//
// Input: "(()(()))"
// Output: 6
//
//
//
//
// Note:
//
//
// S is a balanced parentheses string, containing only ( and ).
// 2 <= S.length <= 50
//
//
//
//
//
// Related Topics String Stack
// 👍 1756 👎 58

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Score of Parentheses.
 O(n) Memory Usage: 37.1 MB, less than 60.25% of Java online submissions for Score of Parentheses.
*/
import java.util.ArrayDeque;
import java.util.Deque;

public class ScoreOfParentheses_856 {
  public int scoreOfParentheses(String str) {
    Deque<Integer> stack = new ArrayDeque<>();
    int cur = 0;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      if (c == '(') {
        stack.push(cur);
        cur = 0;
      } else {
        cur = stack.pop() + Math.max(cur * 2, 1);
      }
    }
    return cur;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
