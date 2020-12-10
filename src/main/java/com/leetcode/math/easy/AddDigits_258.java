package com.leetcode.math.easy;

// Given a non-negative integer num, repeatedly add all its digits until the resu
// lt has only one digit.
//
// Example:
//
//
// Input: 38
// Output: 2
// Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
//              Since 2 has only one digit, return it.
//
//
// Follow up:
// Could you do it without any loop/recursion in O(1) runtime? Related Topics Mat
// h
// 👍 994 👎 1215

// leetcode submit region begin(Prohibit modification and deletion)

public class AddDigits_258 {
  public int addDigits(int num) {
    if (num == 0) return 0;
    if (num % 9 == 0) return 9;
    return num % 9;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
