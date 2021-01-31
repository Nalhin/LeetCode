package com.leetcode.math.easy;

// Given an integer, return its base 7 string representation.
//
// Example 1:
//
// Input: 100
// Output: "202"
//
//
//
// Example 2:
//
// Input: -7
// Output: "-10"
//
//
//
// Note:
// The input will be in range of [-1e7, 1e7].
// 👍 275 👎 157

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(log(n)) Runtime: 1 ms, faster than 87.97% of Java online submissions for Base 7.
 O(log(n)) Memory Usage: 38.2 MB, less than 11.05% of Java online submissions for Base 7.
*/
public class Base7_504 {
  public String convertToBase7(int num) {
    if (num == 0) {
      return "0";
    }
    StringBuilder sb = new StringBuilder();

    boolean isNegative = num < 0;
    num = Math.abs(num);

    while (num > 0) {
      sb.append(num % 7);
      num /= 7;
    }

    if (isNegative) {
      sb.append("-");
    }

    sb.reverse();

    return sb.toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
