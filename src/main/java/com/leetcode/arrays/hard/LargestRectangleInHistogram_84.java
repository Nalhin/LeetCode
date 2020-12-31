package com.leetcode.arrays.hard;

// Given n non-negative integers representing the histogram's bar height where th
// e width of each bar is 1, find the area of largest rectangle in the histogram.
//
//
//
//
// Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3
// ].
//
//
//
//
// The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
//
//
// Example:
//
//
// Input: [2,1,5,6,2,3]
// Output: 10
//
// Related Topics Array Stack
// 👍 4912 👎 103

import java.util.ArrayDeque;
import java.util.Deque;
/*
 O(n) Runtime: 7 ms, faster than 73.85% of Java online submissions for Largest Rectangle in Histogram.
 O(n) Memory Usage: 40.2 MB, less than 70.36% of Java online submissions for Largest Rectangle in Histogram.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class LargestRectangleInHistogram_84 {
  public int largestRectangleArea(int[] heights) {
    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(-1);
    int result = 0;
    for (int i = 0; i < heights.length; i++) {
      while ((stack.peek() != -1) && (heights[stack.peek()] >= heights[i])) {
        int currHeight = heights[stack.pop()];
        int currWidth = i - stack.peek() - 1;
        result = Math.max(result, currHeight * currWidth);
      }
      stack.push(i);
    }
    while (stack.peek() != -1) {
      int currHeight = heights[stack.pop()];
      int currWidth = heights.length - stack.peek() - 1;
      result = Math.max(result, currHeight * currWidth);
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
