package com.leetcode.binarysearch.medium;

// A peak element is an element that is strictly greater than its neighbors.
//
// Given an integer array nums, find a peak element, and return its index. If th
// e array contains multiple peaks, return the index to any of the peaks.
//
// You may imagine that nums[-1] = nums[n] = -∞.
//
// You must write an algorithm that runs in O(log n) time.
//
//
// Example 1:
//
//
// Input: nums = [1,2,3,1]
// Output: 2
// Explanation: 3 is a peak element and your function should return the index num
// ber 2.
//
// Example 2:
//
//
// Input: nums = [1,2,1,3,5,6,4]
// Output: 5
// Explanation: Your function can return either index number 1 where the peak ele
// ment is 2, or index number 5 where the peak element is 6.
//
//
// Constraints:
//
//
// 1 <= nums.length <= 1000
// -231 <= nums[i] <= 231 - 1
// nums[i] != nums[i + 1] for all valid i.
//
// Related Topics Array Binary Search
// 👍 3383 👎 2845
/*
 O(log(n)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
 O(1) Memory Usage: 38.8 MB, less than 45.96% of Java online submissions for Find Peak Element.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class FindPeakElement_162 {
  public int findPeakElement(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;

      if ((mid - 1 < 0 || nums[mid - 1] < nums[mid])
          && (mid + 1 >= nums.length || nums[mid + 1] < nums[mid])) {
        return mid;
      } else if (nums[mid + 1] > nums[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
