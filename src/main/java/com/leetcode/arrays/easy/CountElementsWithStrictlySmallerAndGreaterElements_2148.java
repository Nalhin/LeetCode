package com.leetcode.arrays.easy;

import java.util.Arrays;

// Given an integer array nums, return the number of elements that have both a
// strictly smaller and a strictly greater element appear in nums.
//
//
// Example 1:
//
//
// Input: nums = [11,7,2,15]
// Output: 2
// Explanation: The element 7 has the element 2 strictly smaller than it and the
// element 11 strictly greater than it.
// Element 11 has element 7 strictly smaller than it and element 15 strictly
// greater than it.
// In total there are 2 elements having both a strictly smaller and a strictly
// greater element appear in nums.
//
//
// Example 2:
//
//
// Input: nums = [-3,3,3,90]
// Output: 2
// Explanation: The element 3 has the element -3 strictly smaller than it and
// the element 90 strictly greater than it.
// Since there are two elements with the value 3, in total there are 2 elements
// having both a strictly smaller and a strictly greater element appear in nums.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 100
// -10⁵ <= nums[i] <= 10⁵
//
// Related Topics Array Sorting 👍 167 👎 6
/*
  O(n) Runtime: 5 ms, faster than 16.57% of Java online submissions for Count Elements With Strictly Smaller and Greater Elements .
  O(1) Memory Usage: 40.9 MB, less than 14.51% of Java online submissions for Count Elements With Strictly Smaller and Greater Elements .
 */
// leetcode submit region begin(Prohibit modification and deletion)

public class CountElementsWithStrictlySmallerAndGreaterElements_2148 {
  public int countElements(int[] nums) {
    int max = Arrays.stream(nums).max().getAsInt();
    int min = Arrays.stream(nums).min().getAsInt();

    int count = 0;

    for (int num : nums) {
      if (num > min && num < max) {
        count++;
      }
    }

    return count;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
