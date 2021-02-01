package com.leetcode.math.easy;

// The k-digit number N is an Armstrong number if and only if the k-th power of e
// ach digit sums to N.
//
// Given a positive integer N, return true if and only if it is an Armstrong num
// ber.
//
//
//
// Example 1:
//
//
// Input: 153
// Output: true
// Explanation:
// 153 is a 3-digit number, and 153 = 1^3 + 5^3 + 3^3.
//
//
// Example 2:
//
//
// Input: 123
// Output: false
// Explanation:
// 123 is a 3-digit number, and 123 != 1^3 + 2^3 + 3^3 = 36.
//
//
//
//
// Note:
//
//
// 1 <= N <= 10^8
//
// Related Topics Math
// 👍 78 👎 11

// leetcode submit region begin(Prohibit modification and deletion)

public class ArmstrongNumber_1134 {
  public boolean isArmstrong(int n) {
    int len = 0;

    int num = n;
    while (num > 0) {
      num /= 10;
      len++;
    }

    int result = 0;

    num = n;
    while (num > 0) {
      result += (int) Math.pow(num % 10, len);
      num /= 10;
    }

    return result == n;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
