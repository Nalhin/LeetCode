package com.leetcode.binarysearch.medium;

// Suppose an array sorted in ascending order is rotated at some pivot unknown to
// you beforehand. (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
//
// Return the minimum element of this array.
//
//
// Example 1:
// Input: nums = [3,4,5,1,2]
// Output: 1
// Example 2:
// Input: nums = [4,5,6,7,0,1,2]
// Output: 0
// Example 3:
// Input: nums = [1]
// Output: 1
//
//
// Constraints:
//
//
// 1 <= nums.length <= 5000
// -5000 <= nums[i] <= 5000
// All the integers of nums are unique.
// nums is sorted and rotated at some pivot.
//
// Related Topics Array Binary Search
// 👍 2734 👎 267

// leetcode submit region begin(Prohibit modification and deletion)

public class FindMinimumInRotatedSortedArray_153 {

  static class Assignment {
    /*
      O(log(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
      O(1)  Memory Usage: 39.8 MB, less than 8.97% of Java online submissions for Find Minimum in Rotated Sorted Array.
    */
    public int findMin(int[] nums) {
      int left = 0;
      int right = nums.length - 1;
      int ans = -1;

      int leftMin = nums[0];

      while (left <= right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] < leftMin) {
          right = mid - 1;
          ans = mid;
        } else {
          left = mid + 1;
        }
      }
      return ans == -1 ? nums[0] : nums[ans];
    }
  }
  /*
   O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
   O(1) Memory Usage: 39.6 MB, less than 8.97% of Java online submissions for Find Minimum in Rotated Sorted Array.
  */
  static class SmallerSpaceReduction {
    public int findMin(int[] nums) {
      int left = 0;
      int right = nums.length - 1;

      while (left < right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] < nums[right]) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }
      return nums[left];
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
