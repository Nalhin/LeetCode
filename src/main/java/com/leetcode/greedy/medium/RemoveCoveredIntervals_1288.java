package com.leetcode.greedy.medium;

// Given a list of intervals, remove all intervals that are covered by another in
// terval in the list.
//
// Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
//
//
// After doing so, return the number of remaining intervals.
//
//
// Example 1:
//
//
// Input: intervals = [[1,4],[3,6],[2,8]]
// Output: 2
// Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
//
//
// Example 2:
//
//
// Input: intervals = [[1,4],[2,3]]
// Output: 1
//
//
// Example 3:
//
//
// Input: intervals = [[0,10],[5,12]]
// Output: 2
//
//
// Example 4:
//
//
// Input: intervals = [[3,10],[4,10],[5,11]]
// Output: 2
//
//
// Example 5:
//
//
// Input: intervals = [[1,2],[1,4],[3,4]]
// Output: 1
//
//
//
// Constraints:
//
//
// 1 <= intervals.length <= 1000
// intervals[i].length == 2
// 0 <= intervals[i][0] < intervals[i][1] <= 10^5
// All the intervals are unique.
// Related Topics Greedy Sort Line Sweep
// 👍 365 👎 20

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class RemoveCoveredIntervals_1288 {
  public int removeCoveredIntervals(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

    int result = 0;
    int lastEnd = 0;
    for (int[] interval : intervals) {
      if (lastEnd < interval[1]) {
        result++;
        lastEnd = interval[1];
      }
    }
    return result;
  }
}
/*
  O(nlog(n)) Runtime: 4 ms, faster than 97.49% of Java online submissions for Remove Covered Intervals.
  O(1)       Memory Usage: 39.5 MB, less than 73.62% of Java online submissions for Remove Covered Intervals.
*/
// leetcode submit region end(Prohibit modification and deletion)
