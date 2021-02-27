package com.leetcode.math.medium;

// Given two integers dividend and divisor, divide two integers without using mul
// tiplication, division, and mod operator.
//
// Return the quotient after dividing dividend by divisor.
//
// The integer division should truncate toward zero, which means losing its frac
// tional part. For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
//
// Note:
//
//
// Assume we are dealing with an environment that could only store integers with
// in the 32-bit signed integer range: [−231, 231 − 1]. For this problem, assume th
// at your function returns 231 − 1 when the division result overflows.
//
//
//
// Example 1:
//
//
// Input: dividend = 10, divisor = 3
// Output: 3
// Explanation: 10/3 = truncate(3.33333..) = 3.
//
//
// Example 2:
//
//
// Input: dividend = 7, divisor = -3
// Output: -2
// Explanation: 7/-3 = truncate(-2.33333..) = -2.
//
//
// Example 3:
//
//
// Input: dividend = 0, divisor = 1
// Output: 0
//
//
// Example 4:
//
//
// Input: dividend = 1, divisor = 1
// Output: 1
//
//
//
// Constraints:
//
//
// -231 <= dividend, divisor <= 231 - 1
// divisor != 0
//
// Related Topics Math Binary Search
// 👍 1599 👎 6410

import java.util.ArrayDeque;
import java.util.Deque;
/*
   O(log(n)) Runtime: 3 ms, faster than 24.12% of Java online submissions for Divide Two Integers.
   O(log(n)) Memory Usage: 36.2 MB, less than 44.74% of Java online submissions for Divide Two Integers.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class DivideTwoIntegers_29 {
  public int divide(int dividend, int divisor) {
    int sign = (dividend >= 0 && divisor >= 0) || (dividend < 0 && divisor < 0) ? 1 : -1;

    long longDivisor = Math.abs((long) divisor);
    long longDividend = Math.abs((long) dividend);

    Deque<Long> values = new ArrayDeque<>();
    Deque<Long> results = new ArrayDeque<>();
    values.add(longDivisor);
    results.push(1L);

    long result = 0;

    while (values.peek() <= longDividend) {
      values.push(values.peek() << 1);
      results.push(results.peek() << 1);
    }

    while (longDividend >= longDivisor) {
      if (values.peek() > longDividend) {
        values.pop();
        results.pop();
      } else {
        result += results.peek();
        longDividend -= values.peek();
      }
    }

    if (sign > 0 && result > Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }

    return (int) result * sign;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
