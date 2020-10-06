package com.leetcode.queue.easy;

// Given a stream of integers and a window size, calculate the moving average of
// all integers in the sliding window.
//
// Example:
//
//
// MovingAverage m = new MovingAverage(3);
// m.next(1) = 1
// m.next(10) = (1 + 10) / 2
// m.next(3) = (1 + 10 + 3) / 3
// m.next(5) = (10 + 3 + 5) / 3
//
//
//
// Related Topics Design Queue
// 👍 672 👎 69

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAverageFromDataStream_346 {
  static class MovingAverage {

    private final Queue<Integer> queue;
    private int sum = 0;
    private final int size;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
      this.queue = new ArrayDeque<>(size);
      this.size = size;
    }

    public double next(int val) {
      sum += val;
      if (queue.size() > size - 1) {
        sum -= queue.poll();
      }
      queue.add(val);
      return sum / (double) Math.min(size, queue.size());
    }
  }
}
/*
  O(1) Runtime: 45 ms, faster than 49.71% of Java online submissions for Moving Average from Data Stream.
  O(n) Memory Usage: 43.3 MB, less than 94.88% of Java online submissions for Moving Average from Data Stream.
*/
/*
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
// leetcode submit region end(Prohibit modification and deletion)
