package com.leetcode.greedy.medium;

// You are given an integer array nums and an integer x. In one operation, you ca
// n either remove the leftmost or the rightmost element from the array nums and su
// btract its value from x. Note that this modifies the array for future operations
// .
//
// Return the minimum number of operations to reduce x to exactly 0 if it's poss
// ible, otherwise, return -1.
//
//
// Example 1:
//
//
// Input: nums = [1,1,4,2,3], x = 5
// Output: 2
// Explanation: The optimal solution is to remove the last two elements to reduce
// x to zero.
//
//
// Example 2:
//
//
// Input: nums = [5,6,7,8,9], x = 4
// Output: -1
//
//
// Example 3:
//
//
// Input: nums = [3,2,20,1,1,3], x = 10
// Output: 5
// Explanation: The optimal solution is to remove the last three elements and the
// first two elements (5 operations in total) to reduce x to zero.
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 105
// 1 <= nums[i] <= 104
// 1 <= x <= 109
//
// Related Topics Two Pointers Binary Search Greedy
// 👍 304 👎 6
/*
 O(n) Runtime: 4 ms, faster than 94.57% of Java online submissions for Minimum Operations to Reduce X to Zero.
 O(1) Memory Usage: 49 MB, less than 96.88% of Java online submissions for Minimum Operations to Reduce X to Zero.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class MinimumOperationsToReduceXToZero_1658 {
  public int minOperations(int[] nums, int x) {
    int result = Integer.MAX_VALUE;
    int current = 0;
    for (int num : nums) {
      current += num;
    }
    int left = 0;

    for (int right = 0; right < nums.length; right++) {
      current -= nums[right];
      while (current < x && left <= right) {
        current += nums[left++];
      }
      if (current == x) {
        result = Math.min(result, (nums.length - 1 - right) + left);
      }
    }
    return result != Integer.MAX_VALUE ? result : -1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
