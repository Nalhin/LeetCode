package com.leetcode.strings.medium;

// Implement a basic calculator to evaluate a simple expression string.
//
// The expression string contains only non-negative integers, +, -, *, / operato
// rs and empty spaces . The integer division should truncate toward zero.
//
// Example 1:
//
//
// Input: "3+2*2"
// Output: 7
//
//
// Example 2:
//
//
// Input: " 3/2 "
// Output: 1
//
// Example 3:
//
//
// Input: " 3+5 / 2 "
// Output: 5
//
//
// Note:
//
//
// You may assume that the given expression is always valid.
// Do not use the eval built-in library function.
// Related Topics String Stack
// 👍 1816 👎 300

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public class BasicCalculatorII_227 {
  private final Map<Character, IntBinaryOperator> operations =
      Map.of('+', Integer::sum, '-', (a, b) -> a - b, '*', (a, b) -> a * b, '/', (a, b) -> a / b);

  public int calculate(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    Deque<Character> pendingOperations = new ArrayDeque<>();

    int last = 0;
    for (int i = 0; i < s.length(); i++) {

      if (operations.containsKey(s.charAt(i))) {
        stack.push(getIntBetween(s, last, i));
        last = i + 1;

        if (!pendingOperations.isEmpty()
            && (pendingOperations.peek().equals('*') || pendingOperations.peek().equals('/'))) {
          int second = stack.pop();
          int first = stack.pop();
          stack.push(operations.get(pendingOperations.pop()).applyAsInt(first, second));
        }else if(pendingOperations.size() >=2){
          int second = stack.pop();
          int first = stack.pop();
          stack.push(operations.get(pendingOperations.pop()).applyAsInt(first, second));
        }

        pendingOperations.push(s.charAt(i));
      }
    }

    stack.push(getIntBetween(s, last, s.length()));

    if (!pendingOperations.isEmpty()
        && (pendingOperations.peek().equals('*') || pendingOperations.peek().equals('/'))) {
      int second = stack.pop();
      int first = stack.pop();
      stack.push(operations.get(pendingOperations.pop()).applyAsInt(first, second));
    }

    while (!pendingOperations.isEmpty()) {
      int first = stack.removeLast();
      int second = stack.removeLast();
      stack.add(operations.get(pendingOperations.removeLast()).applyAsInt(first, second));
    }

    return stack.pop();
  }

  private Integer getIntBetween(String s, int start, int end) {
    return Integer.valueOf(s.substring(start, end).replaceAll(" ", ""), 10);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
