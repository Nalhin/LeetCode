package com.leetcode.arrays.easy;

// Given an array of integers nums, you start with an initial positive value star
// tValue.
//
// In each iteration, you calculate the step by step sum of startValue plus elem
// ents in nums (from left to right).
//
// Return the minimum positive value of startValue such that the step by step su
// m is never less than 1.
//
//
// Example 1:
//
//
// Input: nums = [-3,2,-3,4,2]
// Output: 5
// Explanation: If you choose startValue = 4, in the third iteration your step by
// step sum is less than 1.
//                step by step sum
//                 startValue = 4 | startValue = 5 | nums
//                   (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
//                   (1 +2 ) = 3  | (2 +2 ) = 4    |   2
//                   (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
//                   (0 +4 ) = 4  | (1 +4 ) = 5    |   4
//                   (4 +2 ) = 6  | (5 +2 ) = 7    |   2
//
//
// Example 2:
//
//
// Input: nums = [1,2]
// Output: 1
// Explanation: Minimum start value should be positive.
//
//
// Example 3:
//
//
// Input: nums = [1,-2,-3]
// Output: 5
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 100
// -100 <= nums[i] <= 100
// Related Topics Array
// 👍 283 👎 81
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Value to Get Positive Step by Step Sum.
 O(1) Memory Usage: 36.3 MB, less than 82.34% of Java online submissions for Minimum Value to Get Positive Step by Step Sum
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class MinimumValueToGetPositiveStepByStepSum_1413 {
  public int minStartValue(int[] nums) {
    int sum = 0;
    int min = Integer.MAX_VALUE;

    for (int num : nums) {
      sum += num;
      if (sum <= 0) {
        min = Math.min(min, sum);
      }
    }

    return min <= 0 ? Math.abs(min) + 1 : 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
