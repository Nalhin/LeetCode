package com.leetcode.arrays.medium;

// Given an integer array nums, you need to find one continuous subarray that if
// you only sort this subarray in ascending order, then the whole array will be sor
// ted in ascending order.
//
// Return the shortest such subarray and output its length.
//
//
// Example 1:
//
//
// Input: nums = [2,6,4,8,10,9,15]
// Output: 5
// Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the
// whole array sorted in ascending order.
//
//
// Example 2:
//
//
// Input: nums = [1,2,3,4]
// Output: 0
//
//
// Example 3:
//
//
// Input: nums = [1]
// Output: 0
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 104
// -105 <= nums[i] <= 105
//
//
//
// Follow up: Can you solve it in O(n) time complexity? Related Topics Array
// 👍 3603 👎 169

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ShortestUnsortedContinuousSubarray_581 {

  /*
   O(nlog(n)) Runtime: 6 ms, faster than 48.34% of Java online submissions for Shortest Unsorted Continuous Subarray.
   O(n) Memory Usage: 40.5 MB, less than 47.57% of Java online submissions for Shortest Unsorted Continuous Subarray.
  */
  static class Sort {
    public int findUnsortedSubarray(int[] nums) {
      int[] sorted = new int[nums.length];
      System.arraycopy(nums, 0, sorted, 0, nums.length);
      Arrays.sort(sorted);

      int first = nums.length;
      int last = 0;
      for (int i = 0; i < nums.length; i++) {
        if (sorted[i] != nums[i]) {
          first = Math.min(first, i);
          last = Math.max(last, i);
        }
      }

      int diff = last - first + 1;

      return Math.max(diff, 0);
    }
  }
  /*
    O(n) Runtime: 7 ms, faster than 32.02% of Java online submissions for Shortest Unsorted Continuous Subarray.
    O(n) Memory Usage: 40.2 MB, less than 76.32% of Java online submissions for Shortest Unsorted Continuous Subarray.
  */
  static class Stack {
    public int findUnsortedSubarray(int[] nums) {
      int left = nums.length - 1;
      int right = 0;

      Deque<Integer> stack = new ArrayDeque<>();

      for (int i = 0; i < nums.length; i++) {
        while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
          left = Math.min(left, stack.pop());
        }

        stack.push(i);
      }

      stack.clear();
      for (int i = nums.length - 1; i >= 0; i--) {
        while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
          right = Math.max(right, stack.pop());
        }

        stack.push(i);
      }

      return right - left > 0 ? right - left + 1 : 0;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
