package com.leetcode.easy;
// Given an array nums with n objects colored red, white, or blue, sort them in-p
// lace so that objects of the same color are adjacent, with the colors in the orde
// r red, white, and blue.
//
// Here, we will use the integers 0, 1, and 2 to represent the color red, white,
// and blue respectively.
//
// Follow up:
//
//
// Could you solve this problem without using the library's sort function?
// Could you come up with a one-pass algorithm using only O(1) constant space?
//
//
//
// Example 1:
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
// Example 2:
// Input: nums = [2,0,1]
// Output: [0,1,2]
// Example 3:
// Input: nums = [0]
// Output: [0]
// Example 4:
// Input: nums = [1]
// Output: [1]
//
//
// Constraints:
//
//
// n == nums.length
// 1 <= n <= 300
// nums[i] is 0, 1, or 2.
//
// Related Topics Array Two Pointers Sort
// 👍 3929 👎 236

// leetcode submit region begin(Prohibit modification and deletion)

public class SortColors_75 {
  public void sortColors(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    for (int i = 0; i < nums.length; i++) {
      while (nums[i] == 2 && right > i) {
        swap(i, right--, nums);
      }
      while (nums[i] == 0 && left < i) {
        swap(i, left++, nums);
      }
    }
  }

  private void swap(int i1, int i2, int[] nums) {
    int temp = nums[i1];
    nums[i1] = nums[i2];
    nums[i2] = temp;
  }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
    Memory Usage: 37.9 MB, less than 78.66% of Java online submissions for Sort Colors.
 */
// leetcode submit region end(Prohibit modification and deletion)
