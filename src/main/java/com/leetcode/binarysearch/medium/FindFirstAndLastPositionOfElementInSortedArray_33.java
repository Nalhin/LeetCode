package com.leetcode.binarysearch.medium;

// Given an array of integers nums sorted in ascending order, find the starting a
// nd ending position of a given target value.
//
// If target is not found in the array, return [-1, -1].
//
// Follow up: Could you write an algorithm with O(log n) runtime complexity?
//
//
// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:
// Input: nums = [], target = 0
// Output: [-1,-1]
//
//
// Constraints:
//
//
// 0 <= nums.length <= 105
// -109 <= nums[i] <= 109
// nums is a non-decreasing array.
// -109 <= target <= 109
//
// Related Topics Array Binary Search
// 👍 4359 👎 173

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(log(n)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
 O(1) Memory Usage: 42.4 MB, less than 10.04% of Java online submissions for Find First and Last Position of Element in Sorted Array.
*/
public class FindFirstAndLastPositionOfElementInSortedArray_33 {
  public int[] searchRange(int[] nums, int target) {
    if (nums.length == 0) {
      return new int[] {-1, -1};
    }
    int ans = largestSmallerThanTarget(nums, target + 1);
    if (ans == -1 || nums[ans] != target) {
      return new int[] {-1, -1};
    }
    return new int[] {largestSmallerThanTarget(nums, target) + 1, ans};
  }

  private int largestSmallerThanTarget(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    int ans = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] >= target) {
        right = mid - 1;
      } else {
        ans = mid;
        left = mid + 1;
      }
    }
    return ans;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
