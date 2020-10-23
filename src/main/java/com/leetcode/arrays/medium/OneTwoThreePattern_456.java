package com.leetcode.arrays.medium;

// Given an array of n integers nums, a 132 pattern is a subsequence of three int
// egers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < n
// ums[j].
//
// Return true if there is a 132 pattern in nums, otherwise, return false.
//
// Follow up: The O(n^2) is trivial, could you come up with the O(n logn) or the
// O(n) solution?
//
//
// Example 1:
//
//
// Input: nums = [1,2,3,4]
// Output: false
// Explanation: There is no 132 pattern in the sequence.
//
//
// Example 2:
//
//
// Input: nums = [3,1,4,2]
// Output: true
// Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
//
//
// Example 3:
//
//
// Input: nums = [-1,3,2,0]
// Output: true
// Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3,
// 0] and [-1, 2, 0].
//
//
//
// Constraints:
//
//
// n == nums.length
// 1 <= n <= 104
// -109 <= nums[i] <= 109
//
// Related Topics Stack
// 👍 1781 👎 109

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

/*
 O(n) Runtime: 3 ms, faster than 94.44% of Java online submissions for 132 Pattern.
 O(n) Memory Usage: 39.6 MB, less than 5.91% of Java online submissions for 132 Pattern.
*/
public class OneTwoThreePattern_456 {
  public boolean find132pattern(int[] nums) {
    if (nums.length <= 2) {
      return false;
    }

    int[] min = new int[nums.length];
    min[0] = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      min[i] = Math.min(min[i - 1], nums[i]);
    }
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] > min[i]) {
        while (!stack.isEmpty() && stack.peek() <= min[i]) {
          stack.pop();
        }
        if (!stack.isEmpty() && stack.peek() < nums[i]) {
          return true;
        }
        stack.push(nums[i]);
      }
    }

    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
