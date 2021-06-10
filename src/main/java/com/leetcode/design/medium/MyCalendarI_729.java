package com.leetcode.design.medium;

// Implement a MyCalendar class to store your events. A new event can be added if
// adding the event will not cause a double booking.
//
// Your class will have the method, book(int start, int end). Formally, this rep
// resents a booking on the half open interval [start, end), the range of real numb
// ers x such that start <= x < end.
//
// A double booking happens when two events have some non-empty intersection (ie
// ., there is some time that is common to both events.)
//
// For each call to the method MyCalendar.book, return true if the event can be
// added to the calendar successfully without causing a double booking. Otherwise,
// return false and do not add the event to the calendar.
// Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCale
// ndar.book(start, end)
//
// Example 1:
//
//
// MyCalendar();
// MyCalendar.book(10, 20); // returns true
// MyCalendar.book(15, 25); // returns false
// MyCalendar.book(20, 30); // returns true
// Explanation:
// The first event can be booked.  The second can't because time 15 is already bo
// oked by another event.
// The third event can be booked, as the first event takes every time less than 2
// 0, but not including 20.
//
//
//
//
// Note:
//
//
// The number of calls to MyCalendar.book per test case will be at most 1000.
// In calls to MyCalendar.book(start, end), start and end are integers in the ra
// nge [0, 10^9].
//
//
//
// Related Topics Array
// 👍 1251 👎 46
/*
 O(nlog(n)) Runtime: 22 ms, faster than 67.49% of Java online submissions for My Calendar I.
 O(n) Memory Usage: 39.9 MB, less than 39.40% of Java online submissions for My Calendar I.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.TreeMap;

public class MyCalendarI_729 {
  static class MyCalendar {

    private final TreeMap<Integer, Integer> events = new TreeMap<>();

    public boolean book(int start, int end) {
      Integer prevStart = events.floorKey(start);
      Integer nextStart = events.ceilingKey(start);

      if ((prevStart != null && events.get(prevStart) > start)
          || (nextStart != null && nextStart < end)) {
        return false;
      }

      events.put(start, end);
      return true;
    }
  }
}
/*
 * Your MyCalendar object will be instantiated and called as such: MyCalendar obj = new
 * MyCalendar(); boolean param_1 = obj.book(start,end);
 */
// leetcode submit region end(Prohibit modification and deletion)
