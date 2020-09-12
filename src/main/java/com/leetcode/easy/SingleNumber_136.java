package com.leetcode.easy;
// Given a non-empty array of integers, every element appears twice except for on
// e. Find that single one.
//
// Note:
//
// Your algorithm should have a linear runtime complexity. Could you implement i
// t without using extra memory?
//
// Example 1:
//
//
// Input: [2,2,1]
// Output: 1
//
//
// Example 2:
//
//
// Input: [4,1,2,1,2]
// Output: 4
//
// Related Topics Hash Table Bit Manipulation
// 👍 4872 👎 169

// leetcode submit region begin(Prohibit modification and deletion)

public class SingleNumber_136 {
  public int singleNumber(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum ^= num;
    }
    return sum;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
