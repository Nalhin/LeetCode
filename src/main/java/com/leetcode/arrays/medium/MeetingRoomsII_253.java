package com.leetcode.arrays.medium;

// Given an array of meeting time intervals consisting of start and end times [[s
// 1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms requir
// ed.
//
// Example 1:
//
//
// Input: [[0, 30],[5, 10],[15, 20]]
// Output: 2
//
// Example 2:
//
//
// Input: [[7,10],[2,4]]
// Output: 1
//
// NOTE: input types have been changed on April 15, 2019. Please reset to defaul
// t code definition to get new method signature.
// Related Topics Heap Greedy Sort
// 👍 2955 👎 47

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// leetcode submit region begin(Prohibit modification and deletion)
public class MeetingRoomsII_253 {
  public int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    int result = 0;
    Queue<Integer> pq = new PriorityQueue<>();
    for (int[] interval : intervals) {
      while (!pq.isEmpty() && pq.peek() <= interval[0]) {
        pq.remove();
      }
      pq.add(interval[1]);
      result = Math.max(pq.size(), result);
    }
    return result;
  }
}
/*
  O(nlog(n)) Runtime: 8 ms, faster than 32.85% of Java online submissions for Meeting Rooms II.
  O(n) Memory Usage: 38.7 MB, less than 13.93% of Java online submissions for Meeting Rooms II.

 */
// leetcode submit region end(Prohibit modification and deletion)
