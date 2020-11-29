package com.leetcode.arrays.hard;

// You are given an array of integers nums, there is a sliding window of size k w
// hich is moving from the very left of the array to the very right. You can only s
// ee the k numbers in the window. Each time the sliding window moves right by one
// position.
//
// Return the max sliding window.
//
//
// Example 1:
//
//
// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation:
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
// Example 2:
//
//
// Input: nums = [1], k = 1
// Output: [1]
//
//
// Example 3:
//
//
// Input: nums = [1,-1], k = 1
// Output: [1,-1]
//
//
// Example 4:
//
//
// Input: nums = [9,11], k = 2
// Output: [11]
//
//
// Example 5:
//
//
// Input: nums = [4,-2], k = 2
// Output: [4]
//
//
//
// Constraints:
//
//
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
// 1 <= k <= nums.length
// Related Topics Heap Sliding Window Dequeue
// 👍 4542 👎 198

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;
/*
 O(n) Runtime: 43 ms, faster than 19.74% of Java online submissions for Sliding Window Maximum.
 O(n) Memory Usage: 127 MB, less than 5.34% of Java online submissions for Sliding Window Maximum.
*/
public class SlidingWindowMaximum_239 {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (k == 1) {
      return nums;
    }

    Deque<Integer> deque = new ArrayDeque<>();

    int len = nums.length - k + 1;
    int[] ans = new int[len];

    for (int i = 0; i < nums.length; i++) {
      int curr = i - k + 1;

      if (!deque.isEmpty() && deque.peekFirst() < curr) {
        deque.removeFirst();
      }

      while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
        deque.removeLast();
      }

      deque.addLast(i);
      if (curr >= 0) {
        ans[curr] = nums[deque.peekFirst()];
      }
    }

    return ans;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
