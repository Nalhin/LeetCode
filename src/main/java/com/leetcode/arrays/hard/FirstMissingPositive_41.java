package com.leetcode.arrays.hard;
// Given an unsorted integer array, find the smallest missing positive integer.
//
// Example 1:
//
//
// Input: [1,2,0]
// Output: 3
//
//
// Example 2:
//
//
// Input: [3,4,-1,1]
// Output: 2
//
//
// Example 3:
//
//
// Input: [7,8,9,11,12]
// Output: 1
//
//
// Follow up:
//
// Your algorithm should run in O(n) time and uses constant extra space.
// Related Topics Array
// 👍 4174 👎 859

// leetcode submit region begin(Prohibit modification and deletion)

public class FirstMissingPositive_41 {
  public int firstMissingPositive(int[] nums) {
    int right = moveNotPositiveToEnd(nums);

    for (int i = 0; i < right; i++) {
      int num = Math.abs(nums[i]) - 1;
      if (num < right && nums[num] > 0) {
        nums[num] *= -1;
      }
    }

    for (int i = 0; i < right; i++) {
      if (nums[i] > 0) {
        return i + 1;
      }
    }
    return right + 1;
  }

  private int moveNotPositiveToEnd(int[] nums) {
    int j = 0;

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0 && nums[j] <= 0) {
        swap(i, j, nums);
      }
      if (nums[j] > 0) j += 1;
    }

    return j;
  }

  private void swap(int first, int second, int[] arr) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
