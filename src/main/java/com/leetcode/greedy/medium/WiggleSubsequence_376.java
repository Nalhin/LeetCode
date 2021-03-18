package com.leetcode.greedy.medium;

// Given an integer array nums, return the length of the longest wiggle sequence.
//
//
// A wiggle sequence is a sequence where the differences between successive numb
// ers strictly alternate between positive and negative. The first difference (if o
// ne exists) may be either positive or negative. A sequence with fewer than two el
// ements is trivially a wiggle sequence.
//
//
// For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences
// (6, -3, 5, -7, 3) are alternately positive and negative.
// In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences, th
// e first because its first two differences are positive and the second because it
// s last difference is zero.
//
//
// A subsequence is obtained by deleting some elements (eventually, also zero) f
// rom the original sequence, leaving the remaining elements in their original orde
// r.
//
//
// Example 1:
//
//
// Input: nums = [1,7,4,9,2,5]
// Output: 6
// Explanation: The entire sequence is a wiggle sequence.
//
//
// Example 2:
//
//
// Input: nums = [1,17,5,10,13,15,10,5,16,8]
// Output: 7
// Explanation: There are several subsequences that achieve this length. One is [
// 1,17,10,13,10,16,8].
//
//
// Example 3:
//
//
// Input: nums = [1,2,3,4,5,6,7,8,9]
// Output: 2
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 1000
// 0 <= nums[i] <= 1000
//
//
//
// Follow up: Could you solve this in O(n) time?
// Related Topics Dynamic Programming Greedy
// 👍 1556 👎 75
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Wiggle Subsequence.
 O(1) Memory Usage: 36.7 MB, less than 33.27% of Java online submissions for Wiggle Subsequence.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class WiggleSubsequence_376 {
  public int wiggleMaxLength(int[] nums) {
    if (nums.length < 2) {
      return nums.length;
    }
    int result = 1;
    int sign = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < nums[i - 1] && sign != -1) {
        sign = -1;
        result++;
      } else if (nums[i] > nums[i - 1] && sign != 1) {
        sign = 1;
        result++;
      }
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
