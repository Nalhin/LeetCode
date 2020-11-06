package com.leetcode.arrays.easy;

// Given a sorted (in ascending order) integer array nums of n elements and a tar
// get value, write a function to search target in nums. If target exists, then ret
// urn its index, otherwise return -1.
//
//
// Example 1:
//
//
// Input: nums = [-1,0,3,5,9,12], target = 9
// Output: 4
// Explanation: 9 exists in nums and its index is 4
//
//
//
// Example 2:
//
//
// Input: nums = [-1,0,3,5,9,12], target = 2
// Output: -1
// Explanation: 2 does not exist in nums so return -1
//
//
//
//
// Note:
//
//
// You may assume that all elements in nums are unique.
// n will be in the range [1, 10000].
// The value of each element in nums will be in the range [-9999, 9999].
//
// Related Topics Binary Search
// 👍 842 👎 49

// leetcode submit region begin(Prohibit modification and deletion)
public class BinarySearch_704 {
  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = (left + right) >>> 1;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return -1;
  }
}
/*
  O(nlog(n))  Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search.
  O(1)        Memory Usage: 39.7 MB, less than 96.02% of Java online submissions for Binary Search.

*/
// leetcode submit region end(Prohibit modification and deletion)
