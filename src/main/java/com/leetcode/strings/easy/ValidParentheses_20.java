package com.leetcode.strings.easy;
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
import java.util.Set;

public class ValidParentheses_20 {

  private static final Set<Character> closing = Set.of(')', ']', '}');
  private static final Map<Character, Character> mapping = Map.of('(', ')', '[', ']', '{', '}');

  public boolean isValid(String s) {
    Deque<Character> stack = new ArrayDeque<>();

    for (char c : s.toCharArray()) {
      if (mapping.containsKey(c)) {
        stack.push(mapping.get(c));
      } else if (closing.contains(c)) {
        if (stack.isEmpty()) {
          return false;
        }
        char expected = stack.pop();
        if (expected != c) {
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
