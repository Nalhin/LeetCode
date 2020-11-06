package com.leetcode.binarysearch.medium;

// You are given an integer array nums sorted in ascending order, and an integer
// target.
//
// Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [
// 0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
// If target is found in the array return its index, otherwise, return -1.
//
//
// Example 1:
// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:
// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
// Example 3:
// Input: nums = [1], target = 0
// Output: -1
//
//
// Constraints:
//
//
// 1 <= nums.length <= 5000
// -10^4 <= nums[i] <= 10^4
// All values of nums are unique.
// nums is guranteed to be rotated at some pivot.
// -10^4 <= target <= 10^4
//
// Related Topics Array Binary Search
// 👍 6177 👎 535

// leetcode submit region begin(Prohibit modification and deletion)

public class SearchInRotatedSortedArray_33 {
  /*
   O(log(n)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
   O(1) Memory Usage: 38.1 MB, less than 9.41% of Java online submissions for Search in Rotated Sorted Array.
  */
  static class TwoSearches {
    public int search(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;

      int smallerThan = nums[0];

      while (left < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] < smallerThan) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
      right = target >= smallerThan ? left : nums.length - 1;
      left = target >= smallerThan ? 0 : left;
      while (left <= right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
          return mid;
        }
        if (nums[mid] > target) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      return -1;
    }
  }
  /*
   O(log(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
   O(1)   Memory Usage: 38.3 MB, less than 9.41% of Java online submissions for Search in Rotated Sorted Array.
  */
  static class SingleSearch {
    public int search(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;

      int leftSplitMid = nums[left];
      int rightSplitMax = nums[right];
      boolean shouldBeInLeft = target >= leftSplitMid;
      boolean shouldBeInRight = target <= rightSplitMax;

      while (left <= right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
          return mid;
        }

        boolean shouldChangeSide =
            (shouldBeInLeft && nums[mid] < leftSplitMid)
                || (shouldBeInRight && nums[mid] > rightSplitMax);

        if (shouldChangeSide) {
          if (shouldBeInRight) {
            left = mid + 1;
          } else {
            right = mid - 1;
          }
        } else {
          if (nums[mid] < target) {
            left = mid + 1;
          } else {
            right = mid - 1;
          }
        }
      }
      return -1;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
