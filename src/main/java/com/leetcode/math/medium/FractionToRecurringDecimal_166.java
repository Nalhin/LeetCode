package com.leetcode.math.medium;

// Given two integers representing the numerator and denominator of a fraction, r
// eturn the fraction in string format.
//
// If the fractional part is repeating, enclose the repeating part in parenthese
// s.
//
// If multiple answers are possible, return any of them.
//
// It is guaranteed that the length of the answer string is less than 104 for al
// l the given inputs.
//
//
// Example 1:
// Input: numerator = 1, denominator = 2
// Output: "0.5"
// Example 2:
// Input: numerator = 2, denominator = 1
// Output: "2"
// Example 3:
// Input: numerator = 2, denominator = 3
// Output: "0.(6)"
// Example 4:
// Input: numerator = 4, denominator = 333
// Output: "0.(012)"
// Example 5:
// Input: numerator = 1, denominator = 5
// Output: "0.2"
//
//
// Constraints:
//
//
// -231 <= numerator, denominator <= 231 - 1
// denominator != 0
//
// Related Topics Hash Table Math
// 👍 1070 👎 2176

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;
/*
 O(n) Runtime: 1 ms, faster than 100.00% of Java online submissions for Fraction to Recurring Decimal.
 O(n) Memory Usage: 36.3 MB, less than 84.60% of Java online submissions for Fraction to Recurring Decimal.
*/
public class FractionToRecurringDecimal_166 {
  public String fractionToDecimal(int numerator, int denominator) {
    if (denominator == 0) {
      return "0";
    }

    StringBuilder sb = new StringBuilder();
    if (numerator < 0 && denominator > 0 || denominator < 0 && numerator > 0) {
      sb.append("-");
    }
    long numeratorLong = Math.abs((long) numerator);
    long denominatorLong = Math.abs((long) denominator);
    sb.append(numeratorLong / denominatorLong);

    long remainder = numeratorLong % denominatorLong;
    if (remainder == 0) {
      return sb.toString();
    }

    sb.append(".");
    Map<Long, Integer> remainders = new HashMap<>();

    while (remainder != 0) {
      if (remainders.containsKey(remainder)) {
        sb.insert(remainders.get(remainder), "(");
        sb.append(")");
        return sb.toString();
      }

      remainders.put(remainder, sb.length());
      remainder *= 10;
      sb.append(remainder / denominatorLong);
      remainder %= denominatorLong;
    }

    return sb.toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
