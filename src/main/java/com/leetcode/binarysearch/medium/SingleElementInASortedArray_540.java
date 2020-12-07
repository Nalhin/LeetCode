package com.leetcode.binarysearch.medium;

// You are given a sorted array consisting of only integers where every element a
// ppears exactly twice, except for one element which appears exactly once. Find th
// is single element that appears only once.
//
// Follow up: Your solution should run in O(log n) time and O(1) space.
//
//
// Example 1:
// Input: nums = [1,1,2,3,3,4,4,8,8]
// Output: 2
// Example 2:
// Input: nums = [3,3,7,7,10,11,11]
// Output: 10
//
//
// Constraints:
//
//
// 1 <= nums.length <= 10^5
// 0 <= nums[i] <= 10^5
// Related Topics Binary Search
// 👍 1993 👎 83

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Element in a Sorted Array.
 O(1) Memory Usage: 42.4 MB, less than 5.08% of Java online submissions for Single Element in a Sorted Array.
*/
public class SingleElementInASortedArray_540 {
  public int singleNonDuplicate(int[] nums) {
    int left = 0;
    int right = nums.length - 1;

    while (left < right) {

      int mid = left + (right - left) / 2;
      int leftSize = mid - left;

      if (nums[mid - 1] == nums[mid]) {
        if (leftSize % 2 == 0) {
          right = mid - 2;
        } else {
          left = mid + 1;
        }
      } else if (nums[mid + 1] == nums[mid]) {
        if (leftSize % 2 == 0) {
          left = mid + 2;
        } else {
          right = mid - 1;
        }
      } else {
        return nums[mid];
      }
    }

    return nums[left];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
