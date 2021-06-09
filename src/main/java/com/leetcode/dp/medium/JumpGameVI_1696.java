package com.leetcode.dp.medium;

// You are given a 0-indexed integer array nums and an integer k.
//
// You are initially standing at index 0. In one move, you can jump at most k st
// eps forward without going outside the boundaries of the array. That is, you can
// jump from index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive
// .
//
// You want to reach the last index of the array (index n - 1). Your score is th
// e sum of all nums[j] for each index j you visited in the array.
//
// Return the maximum score you can get.
//
//
// Example 1:
//
//
// Input: nums = [1,-1,-2,4,-7,3], k = 2
// Output: 7
// Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (und
// erlined above). The sum is 7.
//
//
// Example 2:
//
//
// Input: nums = [10,-5,-2,4,0,3], k = 3
// Output: 17
// Explanation: You can choose your jumps forming the subsequence [10,4,3] (under
// lined above). The sum is 17.
//
//
// Example 3:
//
//
// Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
// Output: 0
//
//
//
// Constraints:
//
//
// 1 <= nums.length, k <= 105
// -104 <= nums[i] <= 104
//
// Related Topics Dequeue
// 👍 616 👎 38
/*
 O(n) Runtime: 23 ms, faster than 49.86% of Java online submissions for Jump Game VI.
 O(n) Memory Usage: 52.7 MB, less than 87.39% of Java online submissions for Jump Game
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

public class JumpGameVI_1696 {
  public int maxResult(int[] nums, int k) {
    int[] dp = new int[nums.length];
    Deque<Integer> deque = new ArrayDeque<>();
    deque.push(0);
    dp[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {

      if (!deque.isEmpty() && deque.peekFirst() < i - k) {
        deque.pollFirst();
      }

      dp[i] = dp[deque.peekFirst()] + nums[i];

      while (!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) {
        deque.removeLast();
      }

      deque.addLast(i);
    }

    return dp[dp.length - 1];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
