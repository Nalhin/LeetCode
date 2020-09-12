package com.leetcode.easy;
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
// ', determine if the input string is valid.
//
// An input string is valid if:
//
//
// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
//
//
//
// Example 1:
//
//
// Input: s = "()"
// Output: true
//
//
// Example 2:
//
//
// Input: s = "()[]{}"
// Output: true
//
//
// Example 3:
//
//
// Input: s = "(]"
// Output: false
//
//
// Example 4:
//
//
// Input: s = "([)]"
// Output: false
//
//
// Example 5:
//
//
// Input: s = "{[]}"
// Output: true
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.
//
// Related Topics String Stack
// 👍 5502 👎 233

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParentheses_20 {

  static final Map<Character, Character> mappings = Map.of('(', ')', '[', ']', '{', '}');

  public boolean isValid(String s) {
    if (s.length() <= 1) {
      return false;
    }

    Deque<Character> stack = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      char current = s.charAt(i);
      if (mappings.containsKey(current)) {
        stack.push(current);
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char top = stack.pop();
        if (current != mappings.get(top)) {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }
}

/*
  Runtime:2 ms, faster than 53.27% of Java online submissions.
  Memory Usage:37.2 MB, less than 94.44% of Java online submissions.
*/

// leetcode submit region end(Prohibit modification and deletion)
