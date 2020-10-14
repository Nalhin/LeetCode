package com.leetcode.bitmanipulation.easy;

// Given an integer (signed 32 bits), write a function to check whether it is a p
// ower of 4.
//
// Example 1:
//
//
// Input: 16
// Output: true
//
//
//
// Example 2:
//
//
// Input: 5
// Output: false
//
//
// Follow up: Could you solve it without loops/recursion? Related Topics Bit Man
// ipulation
// 👍 725 👎 243

// leetcode submit region begin(Prohibit modification and deletion)

public class PowerOfFour_342 {
  public boolean isPowerOfFour(int num) {
    return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
