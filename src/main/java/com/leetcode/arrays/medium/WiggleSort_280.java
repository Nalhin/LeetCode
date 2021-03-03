package com.leetcode.arrays.medium;

// Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1]
// >= nums[2] <= nums[3]....
//
// Example:
//
//
// Input: nums = [3,5,2,1,6,4]
// Output: One possible answer is [3,5,1,6,2,4]
// Related Topics Array Sort
// 👍 716 👎 68
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Wiggle Sort.
 O(1) Memory Usage: 39.7 MB, less than 83.99% of Java online submissions for Wiggle Sort.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class WiggleSort_280 {
  public void wiggleSort(int[] nums) {
    boolean even = true;

    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1] == even) {
        swap(nums, i, i + 1);
      }

      even = !even;
    }
  }

  private void swap(int[] nums, int first, int second) {
    int temp = nums[first];
    nums[first] = nums[second];
    nums[second] = temp;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
