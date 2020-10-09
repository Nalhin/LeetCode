package com.leetcode.arrays.medium;

// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//
// Valid operators are +, -, *, /. Each operand may be an integer or another exp
// ression.
//
// Note:
//
//
// Division between two integers should truncate toward zero.
// The given RPN expression is always valid. That means the expression would alw
// ays evaluate to a result and there won't be any divide by zero operation.
//
//
// Example 1:
//
//
// Input: ["2", "1", "+", "3", "*"]
// Output: 9
// Explanation: ((2 + 1) * 3) = 9
//
//
// Example 2:
//
//
// Input: ["4", "13", "5", "/", "+"]
// Output: 6
// Explanation: (4 + (13 / 5)) = 6
//
//
// Example 3:
//
//
// Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
// Output: 22
// Explanation:
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
// = ((10 * (6 / (12 * -11))) + 17) + 5
// = ((10 * (6 / -132)) + 17) + 5
// = ((10 * 0) + 17) + 5
// = (0 + 17) + 5
// = 17 + 5
// = 22
//
// Related Topics Stack
// 👍 1200 👎 487

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public class EvaluateReversePolishNotation_150 {
  private final Map<String, IntBinaryOperator> operations =
      Map.of("+", Integer::sum, "-", (a, b) -> a - b, "*", (a, b) -> a * b, "/", (a, b) -> a / b);

  public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();

    for (String token : tokens) {
      if (operations.containsKey(token)) {
        int second = stack.pop();
        int first = stack.pop();
        stack.push(operations.get(token).applyAsInt(first, second));
      } else {
        stack.push(Integer.valueOf(token));
      }
    }
    return stack.pop();
  }
}
/*
   O(n) Runtime: 5 ms, faster than 43.83% of Java online submissions for Evaluate Reverse Polish Notation.
   O(n) Memory Usage: 38.7 MB, less than 93.72% of Java online submissions for Evaluate Reverse Polish Notation.
*/
// leetcode submit region end(Prohibit modification and deletion)
