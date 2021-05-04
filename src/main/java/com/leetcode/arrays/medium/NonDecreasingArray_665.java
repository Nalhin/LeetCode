package com.leetcode.arrays.medium;

// Given an array nums with n integers, your task is to check if it could become
// non-decreasing by modifying at most one element.
//
// We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for ever
// y i (0-based) such that (0 <= i <= n - 2).
//
//
// Example 1:
//
//
// Input: nums = [4,2,3]
// Output: true
// Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
//
//
// Example 2:
//
//
// Input: nums = [4,2,1]
// Output: false
// Explanation: You can't get a non-decreasing array by modify at most one elemen
// t.
//
//
//
// Constraints:
//
//
// n == nums.length
// 1 <= n <= 104
// -105 <= nums[i] <= 105
//
// Related Topics Array
// 👍 2714 👎 614
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Non-decreasing Array.
 O(1) Memory Usage: 40.3 MB, less than 56.85% of Java online submissions for Non-decreasing Array.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class NonDecreasingArray_665 {
  public boolean checkPossibility(int[] nums) {

    boolean swapped = false;
    for (int i = 1; i < nums.length; i++) {

      if (nums[i - 1] > nums[i]) {

        if (swapped) {
          return false;
        }

        if (i < 2 || nums[i - 2] <= nums[i]) {
          nums[i - 1] = nums[i];
        } else {
          nums[i] = nums[i - 1];
        }
        swapped = true;
      }
    }

    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
