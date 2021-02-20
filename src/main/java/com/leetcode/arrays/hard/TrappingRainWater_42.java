package com.leetcode.arrays.hard;

// Given n non-negative integers representing an elevation map where the width of
// each bar is 1, compute how much water it can trap after raining.
//
//
// Example 1:
//
//
// Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
// Explanation: The above elevation map (black section) is represented by array [
// 0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are
// being trapped.
//
//
// Example 2:
//
//
// Input: height = [4,2,0,3,2,5]
// Output: 9
//
//
//
// Constraints:
//
//
// n == height.length
// 0 <= n <= 3 * 104
// 0 <= height[i] <= 105
//
// Related Topics Array Two Pointers Dynamic Programming Stack
// 👍 10003 👎 152

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater_42 {
  /*
   O(n) Runtime: 2 ms, faster than 28.65% of Java online submissions for Trapping Rain Water.
   O(n) Memory Usage: 38.9 MB, less than 26.72% of Java online submissions for Trapping Rain Water.
  */
  public static class Stack {
    public int trap(int[] height) {

      Deque<Integer> deque = new ArrayDeque<>();
      int total = 0;

      for (int i = 0; i < height.length; i++) {
        while (!deque.isEmpty() && height[deque.peek()] < height[i]) {
          int prev = deque.pop();
          int waterBetween =
              deque.isEmpty()
                  ? 0
                  : (Math.min(height[deque.peek()], height[i]) - height[prev])
                      * (i - deque.peek() - 1);
          total += waterBetween;
        }
        deque.push(i);
      }

      return total;
    }
  }
  /*
   O(n) Runtime: 1 ms, faster than 85.69% of Java online submissions for Trapping Rain Water.
   O(n) Memory Usage: 38.6 MB, less than 52.42% of Java online submissions for Trapping Rain Water.
  */
  public static class Dp {
    public int trap(int[] height) {
      int total = 0;

      int[] leftMax = new int[height.length];
      leftMax[0] = height[0];

      for (int i = 1; i < height.length; i++) {
        leftMax[i] = Math.max(leftMax[i - 1], height[i]);
      }

      int[] rightMax = new int[height.length];
      rightMax[height.length - 1] = height[height.length - 1];

      for (int i = height.length - 2; i >= 0; i--) {
        rightMax[i] = Math.max(rightMax[i + 1], height[i]);
      }

      for (int i = 0; i < height.length; i++) {
        total += Math.min(rightMax[i], leftMax[i]) - height[i];
      }

      return total;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
