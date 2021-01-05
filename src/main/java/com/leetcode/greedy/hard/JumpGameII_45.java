package com.leetcode.greedy.hard;

// Given an array of non-negative integers nums, you are initially positioned at
// the first index of the array.
//
// Each element in the array represents your maximum jump length at that positio
// n.
//
// Your goal is to reach the last index in the minimum number of jumps.
//
// You can assume that you can always reach the last index.
//
//
// Example 1:
//
//
// Input: nums = [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2. Jump 1
// step from index 0 to 1, then 3 steps to the last index.
//
//
// Example 2:
//
//
// Input: nums = [2,3,0,1,4]
// Output: 2
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 3 * 104
// 0 <= nums[i] <= 105
//
// Related Topics Array Greedy
// 👍 3470 👎 163

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 1 ms, faster than 100.00% of Java online submissions for Jump Game II.
 O(n) Memory Usage: 41.5 MB, less than 14.12% of Java online submissions for Jump Game II.
*/
public class JumpGameII_45 {
  public int jump(int[] nums) {
    int count = 0;
    int left = 0;
    int right = nums[0];
    while (left < nums.length - 1) {
      int max = 0;
      for (int i = left; i <= right && i < nums.length; i++) {
        max = Math.max(max, nums[i] - (right - i));
      }
      left = right;
      right += max;
      count++;
    }
    return count;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
