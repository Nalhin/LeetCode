package com.leetcode.arrays.medium;

// Given a set of non-overlapping intervals, insert a new interval into the inter
// vals (merge if necessary).
//
// You may assume that the intervals were initially sorted according to their st
// art times.
//
//
// Example 1:
//
//
// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]
//
//
// Example 2:
//
//
// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
//
//
// Example 3:
//
//
// Input: intervals = [], newInterval = [5,7]
// Output: [[5,7]]
//
//
// Example 4:
//
//
// Input: intervals = [[1,5]], newInterval = [2,3]
// Output: [[1,5]]
//
//
// Example 5:
//
//
// Input: intervals = [[1,5]], newInterval = [2,7]
// Output: [[1,7]]
//
//
//
// Constraints:
//
//
// 0 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= intervals[i][0] <= intervals[i][1] <= 105
// intervals is sorted by intervals[i][0] in ascending order.
// newInterval.length == 2
// 0 <= newInterval[0] <= newInterval[1] <= 105
//
// Related Topics Array Sort
// 👍 2548 👎 232

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 1 ms, faster than 98.77% of Java online submissions for Insert Interval.
 O(n) Memory Usage: 44 MB, less than 13.48% of Java online submissions for Insert Interval.
*/
import java.util.ArrayList;
import java.util.List;

public class InsertInterval_57 {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();

    int index = 0;

    while (index < intervals.length && intervals[index][1] < newInterval[0]) {
      result.add(intervals[index++]);
    }

    int start = newInterval[0];
    int end = newInterval[1];

    while (index < intervals.length && intervals[index][0] <= end) {
      start = Math.min(intervals[index][0], start);
      end = Math.max(intervals[index][1], end);
      index++;
    }
    result.add(new int[] {start, end});

    while (index < intervals.length) {
      result.add(intervals[index++]);
    }

    return result.toArray(new int[0][0]);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
