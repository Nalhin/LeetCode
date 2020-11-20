package com.leetcode.binarysearch.medium;

// Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand.
//
// (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
//
// You are given a target value to search. If found in the array return true, ot
// herwise return false.
//
// Example 1:
//
//
// Input: nums = [2,5,6,0,0,1,2], target = 0
// Output: true
//
//
// Example 2:
//
//
// Input: nums = [2,5,6,0,0,1,2], target = 3
// Output: false
//
// Follow up:
//
//
// This is a follow up problem to Search in Rotated Sorted Array, where nums may
// contain duplicates.
// Would this affect the run-time complexity? How and why?
//
// Related Topics Array Binary Search
// 👍 1704 👎 510

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array II.
 O(1) Memory Usage: 38.6 MB, less than 89.46% of Java online submissions for Search in Rotated Sorted Array II.
*/
public class SearchInRotatedSortedArrayII_81 {
  public boolean search(int[] nums, int target) {
    if (nums.length == 0) {
      return false;
    }

    int breakLow = nums[nums.length - 1];
    int i = 0;

    while (nums[i] == breakLow && i < nums.length - 1) {
      if (nums[i] == target) {
        return true;
      }
      i++;
    }

    int breakHigh = nums[i];
    boolean shouldBeInLeft = target >= breakHigh;
    boolean shouldBeInRight = !shouldBeInLeft;

    int left = i;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] == target) {
        return true;
      }

      boolean isInLeft = nums[mid] >= breakHigh;

      if (isInLeft && shouldBeInRight) {
        left = mid + 1;
      } else if (!isInLeft && shouldBeInLeft) {
        right = mid - 1;
      } else {
        if (nums[mid] > target) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
    }
    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
