package com.leetcode.math.medium;

// Given an integer array nums of size n, return the minimum number of moves requ
// ired to make all array elements equal.
//
// In one move, you can increment or decrement an element of the array by 1.
//
//
// Example 1:
//
//
// Input: nums = [1,2,3]
// Output: 2
// Explanation:
// Only two moves are needed (remember each move increments or decrements one ele
// ment):
// [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
//
//
// Example 2:
//
//
// Input: nums = [1,10,2,9]
// Output: 16
//
//
//
// Constraints:
//
//
// n == nums.length
// 1 <= nums.length <= 105
// -109 <= nums[i] <= 109
//
// Related Topics Math
// 👍 821 👎 57
/*
 O(nlog(n)) Runtime: 2 ms, faster than 98.21% of Java online submissions for Minimum Moves to Equal Array Elements II.
 O(sort(n)) Memory Usage: 39.7 MB, less than 57.85% of Java online submissions for Minimum Moves to Equal Array Elements II.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII_462 {
  public int minMoves2(int[] nums) {
    int left = 0;
    int right = nums.length - 1;
    int result = 0;

    Arrays.sort(nums);
    while (left < right) {
      result += nums[right--] - nums[left++];
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
