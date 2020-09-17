package com.leetcode.arrays.easy;

// Given an array nums, write a function to move all 0's to the end of it while m
// aintaining the relative order of the non-zero elements.
//
// Example:
//
//
// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]
//
// Note:
//
//
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.
// Related Topics Array Two Pointers
// 👍 4224 👎 132

// leetcode submit region begin(Prohibit modification and deletion)
public class MoveZeroes_283 {
  public void moveZeroes(int[] nums) {
    for (int i = 0, lastZero = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        swap(lastZero++, i, nums);
      }
    }
  }

  private void swap(int first, int second, int[] arr) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
    Memory Usage: 39.9 MB, less than 56.15% of Java online submissions for Move Zeroes.
*/
// leetcode submit region end(Prohibit modification and deletion)
