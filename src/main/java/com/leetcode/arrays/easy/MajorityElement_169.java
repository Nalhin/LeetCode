package com.leetcode.arrays.easy;

// Given an array of size n, find the majority element. The majority element is t
// he element that appears more than ⌊ n/2 ⌋ times.
//
// You may assume that the array is non-empty and the majority element always ex
// ist in the array.
//
// Example 1:
//
//
// Input: [3,2,3]
// Output: 3
//
// Example 2:
//
//
// Input: [2,2,1,1,1,2,2]
// Output: 2
//
// Related Topics Array Divide and Conquer Bit Manipulation
// 👍 3895 👎 233

// leetcode submit region begin(Prohibit modification and deletion)

public class MajorityElement_169 {
  /*
   O(n) Runtime: 1 ms, faster than 99.90% of Java online submissions for Majority Element.
   O(1) Memory Usage: 42.4 MB, less than 6.38% of Java online submissions for Majority Element.
  */
  public int majorityElement(int[] nums) {
    int count = 0;
    int candidate = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (count == 0) {
        candidate = nums[i];
      }
      if (nums[i] == candidate) {
        count++;
      } else {
        count--;
      }
    }
    return candidate;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
