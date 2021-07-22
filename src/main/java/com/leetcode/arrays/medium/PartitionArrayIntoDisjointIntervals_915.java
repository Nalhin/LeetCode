package com.leetcode.arrays.medium;

// Given an array nums, partition it into two (contiguous) subarrays left and rig
// ht so that:
//
//
// Every element in left is less than or equal to every element in right.
// left and right are non-empty.
// left has the smallest possible size.
//
//
// Return the length of left after such a partitioning. It is guaranteed that su
// ch a partitioning exists.
//
//
//
// Example 1:
//
//
// Input: nums = [5,0,3,8,6]
// Output: 3
// Explanation: left = [5,0,3], right = [8,6]
//
//
//
// Example 2:
//
//
// Input: nums = [1,1,1,0,6,12]
// Output: 4
// Explanation: left = [1,1,1,0], right = [6,12]
//
//
//
//
//
// Note:
//
//
// 2 <= nums.length <= 30000
// 0 <= nums[i] <= 106
// It is guaranteed there is at least one way to partition nums as described.
//
//
//
//
//
// Related Topics Array
// 👍 657 👎 45

// leetcode submit region begin(Prohibit modification and deletion)
class PartitionArrayIntoDisjointIntervals_915 {

  static class SuffixMin {

    public int partitionDisjoint(int[] nums) {
      int[] minNums = new int[nums.length];

      minNums[nums.length - 1] = nums[nums.length - 1];
      for (int i = nums.length - 2; i >= 0; i--) {
        minNums[i] = Math.min(nums[i], minNums[i + 1]);
      }

      int max = nums[0];
      for (int i = 1; i < nums.length; i++) {
        if (max <= minNums[i]) {
          return i;
        }
        max = Math.max(max, nums[i]);
      }

      return -1;
    }
  }

  static class OnePass {
    public int partitionDisjoint(int[] nums) {
      int max = nums[0];
      int allMax = nums[0];
      int solution = 1;
      for (int i = 1; i < nums.length; i++) {
        if (nums[i] < max) {
          solution = i + 1;
          max = allMax;
        } else {
          allMax = Math.max(allMax, nums[i]);
        }
      }
      return solution;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
