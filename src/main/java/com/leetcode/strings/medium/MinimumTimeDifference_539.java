package com.leetcode.strings.medium;

// Given a list of 24-hour clock time points in "HH:MM" format, return the minimu
// m minutes difference between any two time-points in the list.
//
// Example 1:
// Input: timePoints = ["23:59","00:00"]
// Output: 1
// Example 2:
// Input: timePoints = ["00:00","23:59","00:00"]
// Output: 0
//
//
// Constraints:
//
//
// 2 <= timePoints <= 2 * 104
// timePoints[i] is in the format "HH:MM".
//
// Related Topics String
// 👍 638 👎 170

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;
import java.util.stream.Collectors;
/*
 O(nlog(n)) Runtime: 15 ms, faster than 24.53% of Java online submissions for Minimum Time Difference.
 O(n) Memory Usage: 41 MB, less than 28.17% of Java online submissions for Minimum Time Difference.
*/
public class MinimumTimeDifference_539 {
  private static final int MINS_IN_DAY = 60 * 24;

  public int findMinDifference(List<String> timePoints) {
    List<Integer> sortedTimes =
        timePoints.stream().map(this::toBaseMinutes).sorted().collect(Collectors.toList());

    int prev = -MINS_IN_DAY;
    int min = MINS_IN_DAY;

    for (int time : sortedTimes) {
      min = Math.min(min, time - prev);
      prev = time;
    }

    return Math.min(min, sortedTimes.get(0) + MINS_IN_DAY - sortedTimes.get(timePoints.size() - 1));
  }

  private int toBaseMinutes(String date) {
    String[] numbers = date.split(":");

    int hours = Integer.parseInt(numbers[0]);
    int minutes = Integer.parseInt(numbers[1]);

    return hours * 60 + minutes;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
