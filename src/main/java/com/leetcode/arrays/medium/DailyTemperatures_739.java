package com.leetcode.arrays.medium;

//
// Given a list of daily temperatures T, return a list such that, for each day in
// the input, tells you how many days you would have to wait until a warmer temper
// ature. If there is no future day for which this is possible, put 0 instead.
//
// For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 7
// 3], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
//
//
// Note:
// The length of temperatures will be in the range [1, 30000].
// Each temperature will be an integer in the range [30, 100].
// Related Topics Hash Table Stack
// 👍 3276 👎 98

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures_739 {
  public int[] dailyTemperatures(int[] T) {
    int[] result = new int[T.length];
    Deque<Integer> deque = new ArrayDeque<>();

    for (int i = 0; i < T.length; i++) {
      while (!deque.isEmpty() && T[deque.peek()] < T[i]) {
        int index = deque.pop();
        result[index] = i - index;
      }
      deque.push(i);
    }

    return result;
  }
}
/*
 O(n)  Runtime: 11 ms, faster than 90.44% of Java online submissions for Daily Temperatures.
 O(n)  Memory Usage: 48 MB, less than 28.44% of Java online submissions for Daily Temperatures.
*/
// leetcode submit region end(Prohibit modification and deletion)
