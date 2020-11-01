package com.leetcode.arrays.easy;

// Given an array of meeting time intervals where intervals[i] = [starti, endi],
// determine if a person could attend all meetings.
//
//
// Example 1:
// Input: intervals = [[0,30],[5,10],[15,20]]
// Output: false
// Example 2:
// Input: intervals = [[7,10],[2,4]]
// Output: true
//
//
// Constraints:
//
//
// 0 <= intervals.length <= 104
// intervals.length == 2
// 0 <= starti < endi <= 106
//
// Related Topics Sort
// 👍 704 👎 41

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms_252 {
  public boolean canAttendMeetings(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    int prevEnd = -1;
    for (int[] interval : intervals) {
      if (prevEnd > interval[0]) {
        return false;
      }
      prevEnd = interval[1];
    }
    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
