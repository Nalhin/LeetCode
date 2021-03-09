package com.leetcode.bitmanipulation.medium;

// Given an integer array nums, in which exactly two elements appear only once an
// d all the other elements appear exactly twice. Find the two elements that appear
// only once. You can return the answer in any order.
//
// Follow up: Your algorithm should run in linear runtime complexity. Could you
// implement it using only constant space complexity?
//
//
// Example 1:
//
//
// Input: nums = [1,2,1,3,2,5]
// Output: [3,5]
// Explanation:  [5, 3] is also a valid answer.
//
//
// Example 2:
//
//
// Input: nums = [-1,0]
// Output: [-1,0]
//
//
// Example 3:
//
//
// Input: nums = [0,1]
// Output: [1,0]
//
//
//
// Constraints:
//
//
// 2 <= nums.length <= 3 * 104
// -231 <= nums[i] <= 231 - 1
// Each integer in nums will appear twice, only two integers will appear once.
//
// Related Topics Bit Manipulation
// 👍 2164 👎 130

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 1 ms, faster than 96.97% of Java online submissions for Single Number III.
 O(1) Memory Usage: 38.8 MB, less than 96.97% of Java online submissions for Single Number III.
*/
public class SingleNumberIII_260 {
  public int[] singleNumber(int[] nums) {

    int sumOfNums = 0;
    for (int num : nums) {
      sumOfNums ^= num;
    }

    int[] result = {0, 0};

    int diffBit = sumOfNums & -sumOfNums;

    for (int num : nums) {
      if ((num & diffBit) == 0) {
        result[0] ^= num;
      } else {
        result[1] ^= num;
      }
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
