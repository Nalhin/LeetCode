package com.leetcode.easy;
// Given a sorted array nums, remove the duplicates in-place such that each eleme
// nt appear only once and return the new length.
//
// Do not allocate extra space for another array, you must do this by modifying
// the input array in-place with O(1) extra memory.
//
// Example 1:
//
//
// Given nums = [1,1,2],
//
// Your function should return length = 2, with the first two elements of nums be
// ing 1 and 2 respectively.
//
// It doesn't matter what you leave beyond the returned length.
//
// Example 2:
//
//
// Given nums = [0,0,1,1,1,2,2,3,3,4],
//
// Your function should return length = 5, with the first five elements of nums b
// eing modified to 0, 1, 2, 3, and 4 respectively.
//
// It doesn't matter what values are set beyond the returned length.
//
//
// Clarification:
//
// Confused why the returned value is an integer but your answer is an array?
//
// Note that the input array is passed in by reference, which means modification
// to the input array will be known to the caller as well.
//
// Internally you can think of this:
//
//
//// nums is passed in by reference. (i.e., without making a copy)
// int len = removeDuplicates(nums);
//
//// any modification to nums in your function would be known by the caller.
//// using the length returned by your function, it prints the first len element
// s.
// for (int i = 0; i < len; i++) {
//     print(nums[i]);
// } Related Topics Array Two Pointers
// 👍 2794 👎 5547

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;

public class RemoveDuplicatesFromSortedArray_26 {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int lastPosition = 1;
    int prev = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (prev != nums[i]) {
        nums[lastPosition] = nums[i];
        lastPosition++;
      }
      prev = nums[i];
    }

    return lastPosition;
  }
}
/*
    Runtime:0 ms, faster than 100.00% of Java online submissions.
	Memory Usage:41.6 MB, less than 49.53% of Java online submissions.
*/

// leetcode submit region end(Prohibit modification and deletion)
