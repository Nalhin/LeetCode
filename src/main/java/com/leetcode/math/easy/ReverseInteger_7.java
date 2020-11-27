package com.leetcode.math.easy;

// Given a 32-bit signed integer, reverse digits of an integer.
//
// Note:
// Assume we are dealing with an environment that could only store integers withi
// n the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this prob
// lem, assume that your function returns 0 when the reversed integer overflows.
//
//
// Example 1:
// Input: x = 123
// Output: 321
// Example 2:
// Input: x = -123
// Output: -321
// Example 3:
// Input: x = 120
// Output: 21
// Example 4:
// Input: x = 0
// Output: 0
//
//
// Constraints:
//
//
// -231 <= x <= 231 - 1
//
// Related Topics Math
// 👍 3998 👎 6173

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(log(n)) Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Integer.
 O(1) Memory Usage: 36.3 MB, less than 24.43% of Java online submissions for Reverse Integer.
*/
public class ReverseInteger_7 {
  public int reverse(int x) {
    int sign = x > 0 ? 1 : -1;

    x = Math.abs(x);
    int ans = 0;

    while (x > 0) {
      if (Integer.MAX_VALUE / 10 < ans || (Integer.MAX_VALUE - x % 10) < ans * 10) {
        return 0;
      }

      ans = ans * 10 + x % 10;
      x /= 10;
    }

    return ans * sign;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
