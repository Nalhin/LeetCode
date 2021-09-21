package com.leetcode.math.hard;

// Given a string s representing a valid expression, implement a basic
// calculator to evaluate it, and return the result of the evaluation.
//
// Note: You are not allowed to use any built-in function which evaluates
// strings as mathematical expressions, such as eval().
//
//
// Example 1:
//
//
// Input: s = "1 + 1"
// Output: 2
//
//
// Example 2:
//
//
// Input: s = " 2-1 + 2 "
// Output: 3
//
//
// Example 3:
//
//
// Input: s = "(1+(4+5+2)-3)+(6+8)"
// Output: 23
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 3 * 10⁵
// s consists of digits, '+', '-', '(', ')', and ' '.
// s represents a valid expression.
// '+' is not used as a unary operation.
// '-' could be used as a unary operation and in this case, it will not be used
// directly after a +ve or -ve signs (will be inside parentheses).
// There will be no two consecutive operators in the input.
// Every number and running calculation will fit in a signed 32-bit integer.
//
// Related Topics Math String Stack Recursion 👍 2845 👎 252
/*
  O(n) Runtime: 7 ms, faster than 71.69% of Java online submissions for Basic Calculator.
  O(m) Memory Usage: 39.4 MB, less than 63.63% of Java online submissions for Basic Calculator.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator_224 {
  public int calculate(String s) {

    Deque<Integer> signs = new ArrayDeque<>();
    signs.add(1);

    int result = 0;
    int sign = 1;

    int curr = 0;

    for (int i = 0; i < s.length(); i++) {
      char currChar = s.charAt(i);

      if (Character.isDigit(currChar)) {
        curr *= 10;
        curr += Character.getNumericValue(currChar);
      } else {
        result += curr * sign;
        curr = 0;
      }

      if (currChar == '-') {
        sign = signs.peek() * -1;
      } else if (currChar == '+') {
        sign = signs.peek();
      } else if (currChar == '(') {
        signs.push(sign);
      } else if (currChar == ')') {
        signs.pop();
        sign = signs.peek();
      }
    }

    return result + curr * sign;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
