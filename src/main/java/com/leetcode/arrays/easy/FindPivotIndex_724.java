package com.leetcode.arrays.easy;
// Given an array of integers nums, write a method that returns the "pivot" index
// of this array.
//
// We define the pivot index as the index where the sum of all the numbers to th
// e left of the index is equal to the sum of all the numbers to the right of the i
// ndex.
//
// If no such index exists, we should return -1. If there are multiple pivot ind
// exes, you should return the left-most pivot index.
//
//
// Example 1:
//
//
// Input: nums = [1,7,3,6,5,6]
// Output: 3
// Explanation:
// The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the su
// m of numbers to the right of index 3.
// Also, 3 is the first index where this occurs.
//
//
// Example 2:
//
//
// Input: nums = [1,2,3]
// Output: -1
// Explanation:
// There is no index that satisfies the conditions in the problem statement.
//
//
//
// Constraints:
//
//
// The length of nums will be in the range [0, 10000].
// Each element nums[i] will be an integer in the range [-1000, 1000].
//
// Related Topics Array
// 👍 1289 👎 264

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class FindPivotIndex_724 {
  public int pivotIndex(int[] nums) {
    int sum = Arrays.stream(nums).sum();
    int leftSum = 0;

    for (int i = 0; i < nums.length; i++) {
      if (sum - leftSum - nums[i] == leftSum) {
        return i;
      }
      leftSum += nums[i];
    }
    return -1;
  }
}
/*
   O(n) Runtime: 6 ms, faster than 11.32% of Java online submissions for Find Pivot Index.
   O(1) Memory Usage: 49.4 MB, less than 19.02% of Java online submissions for Find Pivot Index.
*/
// leetcode submit region end(Prohibit modification and deletion)

