package com.leetcode.greedy.medium;

// Given the availability time slots arrays slots1 and slots2 of two people and a
// meeting duration duration, return the earliest time slot that works for both of
// them and is of duration duration.
//
// If there is no common time slot that satisfies the requirements, return an em
// pty array.
//
// The format of a time slot is an array of two elements [start, end] representi
// ng an inclusive time range from start to end.
//
// It is guaranteed that no two availability slots of the same person intersect
// with each other. That is, for any two time slots [start1, end1] and [start2, end
// 2] of the same person, either start1 > end2 or start2 > end1.
//
//
// Example 1:
//
//
// Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], durat
// ion = 8
// Output: [60,68]
//
//
// Example 2:
//
//
// Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], durat
// ion = 12
// Output: []
//
//
//
// Constraints:
//
//
// 1 <= slots1.length, slots2.length <= 104
// slots1[i].length, slots2[i].length == 2
// slots1[i][0] < slots1[i][1]
// slots2[i][0] < slots2[i][1]
// 0 <= slots1[i][j], slots2[i][j] <= 109
// 1 <= duration <= 106
//
/*
  O(nlog(n) + mlog(m)) Runtime: 31 ms, faster than 13.22% of Java online submissions for Meeting Scheduler.
  O(sort(n) + sort(m))  Memory Usage: 48.2 MB, less than 63.09% of Java online submissions for Meeting Scheduler.
*/
// Related Topics Two Pointers Sort Line Sweep
// 👍 424 👎 20

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// leetcode submit region begin(Prohibit modification and deletion)
public class MeetingScheduler_1229 {
  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
    if (slots1.length <= 0 || slots2.length <= 0) {
      return Collections.emptyList();
    }

    Arrays.sort(slots1, Comparator.comparingInt(arr -> arr[0]));
    Arrays.sort(slots2, Comparator.comparingInt(arr -> arr[0]));

    int slots1Left = 0;
    int slots2Left = 0;

    while (slots1Left < slots1.length && slots2Left < slots2.length) {
      int[] first = slots1[slots1Left];
      int[] second = slots2[slots2Left];
      int end = Math.min(first[1], second[1]);
      int start = Math.max(first[0], second[0]);
      if (end - start >= duration) {
        return List.of(start, start + duration);
      } else {
        if (first[1] < second[1]) {
          slots1Left++;
        } else {
          slots2Left++;
        }
      }
    }

    return Collections.emptyList();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
