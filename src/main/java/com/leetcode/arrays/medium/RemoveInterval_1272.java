package com.leetcode.arrays.medium;

// Given a sorted list of disjoint intervals, each interval intervals[i] = [a, b]
// represents the set of real numbers x such that a <= x < b.
//
// We remove the intersections between any interval in intervals and the interva
// l toBeRemoved.
//
// Return a sorted list of intervals after all such removals.
//
//
// Example 1:
//
//
// Input: intervals = [[0,2],[3,4],[5,7]], toBeRemoved = [1,6]
// Output: [[0,1],[6,7]]
//
//
// Example 2:
//
//
// Input: intervals = [[0,5]], toBeRemoved = [2,3]
// Output: [[0,2],[3,5]]
//
//
// Example 3:
//
//
// Input: intervals = [[-5,-4],[-3,-2],[1,2],[3,5],[8,9]], toBeRemoved = [-1,4]
// Output: [[-5,-4],[-3,-2],[4,5],[8,9]]
//
//
//
// Constraints:
//
//
// 1 <= intervals.length <= 10^4
// -10^9 <= intervals[i][0] < intervals[i][1] <= 10^9
//
// Related Topics Math Line Sweep
// 👍 169 👎 16

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
/*
 O(n) Runtime: 4 ms, faster than 98.49% of Java online submissions for Remove Interval.
 O(n) Memory Usage: 47.4 MB, less than 86.66% of Java online submissions for Remove Interval.
*/
public class RemoveInterval_1272 {
  public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {

    List<List<Integer>> result = new ArrayList<>();

    int removedStart = toBeRemoved[0];
    int removedEnd = toBeRemoved[1];

    for (int[] interval : intervals) {

      int start = interval[0];
      int end = interval[1];

      if (removedEnd <= start || removedStart >= end) {
        result.add(List.of(start, end));
      } else if (removedStart <= start && removedEnd < end) {
        result.add(List.of(removedEnd, end));
      } else if (start < removedStart && end < removedEnd) {
        result.add(List.of(start, removedStart));
      } else if (removedStart > start && removedEnd < end) {
        result.add(List.of(start, removedStart));
        result.add(List.of(removedEnd, end));
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
