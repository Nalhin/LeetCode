package com.leetcode.arrays.easy;

// Given the array of integers nums, you will choose two different indices i and
// j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
//
// Example 1:
//
//
// Input: nums = [3,4,5,2]
// Output: 12
// Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will
// get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12
// .
//
//
// Example 2:
//
//
// Input: nums = [1,5,4,5]
// Output: 16
// Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get t
// he maximum value of (5-1)*(5-1) = 16.
//
//
// Example 3:
//
//
// Input: nums = [3,7]
// Output: 12
//
//
//
// Constraints:
//
//
// 2 <= nums.length <= 500
// 1 <= nums[i] <= 10^3
//
// Related Topics Array
// 👍 307 👎 72

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Product of Two Elements in an Array.
 O(1) Memory Usage: 38.5 MB, less than 75.02% of Java online submissions for Maximum Product of Two Elements in an Array.
*/
public class MaximumProductOfTwoElementsInAnArray_1464 {
  public int maxProduct(int[] nums) {
    int firstMax = 0;
    int secondMax = 0;
    for (int num : nums) {
      if (num > firstMax) {
        secondMax = firstMax;
        firstMax = num;
      } else if (num > secondMax) {
        secondMax = num;
      }
    }
    return (firstMax - 1) * (secondMax - 1);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
