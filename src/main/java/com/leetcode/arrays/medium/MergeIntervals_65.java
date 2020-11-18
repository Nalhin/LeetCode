package com.leetcode.arrays.medium;

// Given an array of intervals where intervals[i] = [starti, endi], merge all ove
// rlapping intervals, and return an array of the non-overlapping intervals that co
// ver all the intervals in the input.
//
//
// Example 1:
//
//
// Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//
//
// Example 2:
//
//
// Input: intervals = [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//
//
//
// Constraints:
//
//
// 1 <= intervals.length <= 104
// intervals[i].length == 2
// 0 <= starti <= endi <= 104
//
// Related Topics Array Sort
// 👍 5608 👎 337

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
/*
 O(nlog(n) Runtime: 6 ms, faster than 47.62% of Java online submissions for Merge Intervals.
 O(sort) Memory Usage: 42.1 MB, less than 21.55% of Java online submissions for Merge Intervals.
*/
public class MergeIntervals_65 {
  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

    List<int[]> result = new ArrayList<>();

    int start = intervals[0][0];
    int maxEnd = intervals[0][1];

    for (int i = 1; i < intervals.length; i++) {
      if (maxEnd < intervals[i][0]) {
        result.add(new int[] {start, maxEnd});
        start = intervals[i][0];
      }
      maxEnd = Math.max(maxEnd, intervals[i][1]);
    }

    result.add(new int[] {start, maxEnd});
    return result.toArray(new int[0][0]);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
