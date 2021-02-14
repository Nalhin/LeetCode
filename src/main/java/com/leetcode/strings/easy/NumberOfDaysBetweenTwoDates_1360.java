package com.leetcode.strings.easy;

// Write a program to count the number of days between two dates.
//
// The two dates are given as strings, their format is YYYY-MM-DD as shown in th
// e examples.
//
//
// Example 1:
// Input: date1 = "2019-06-29", date2 = "2019-06-30"
// Output: 1
// Example 2:
// Input: date1 = "2020-01-15", date2 = "2019-12-31"
// Output: 15
//
//
// Constraints:
//
//
// The given dates are valid dates between the years 1971 and 2100.
//
// 👍 86 👎 489

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(1) Runtime: 1 ms, faster than 97.49% of Java online submissions for Number of Days Between Two Dates.
 O(1) Memory Usage: 37.3 MB, less than 51.25% of Java online submissions for Number of Days Between Two Dates.
*/
// leetcode submit region end(Prohibit modification and deletion)
public class NumberOfDaysBetweenTwoDates_1360 {
  public int daysBetweenDates(String date1, String date2) {
    MyDate myDate1 = new MyDate(date1);
    MyDate myDate2 = new MyDate(date2);

    return myDate1.daysBetween(myDate2);
  }

  static class MyDate {
    private final static int BASE_YEAR = 1970;
    private final static int[] DAYS_PER_MONTH = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private final static int DAYS_PER_YEAR = 365;

    private final int year;
    private final int month;
    private final int day;

    public MyDate(String date) {
      String[] dateArr = date.split("-");
      year = Integer.parseInt(dateArr[0]);
      month = Integer.parseInt(dateArr[1]);
      day = Integer.parseInt(dateArr[2]);
    }

    public int daysBetween(MyDate date2) {
      return Math.abs(getAsDays() - date2.getAsDays());
    }

    public int getAsDays() {
      int result = 0;
      for (int currYear = BASE_YEAR; currYear < year; currYear++) {
        result += DAYS_PER_YEAR;
        if (isLeap(currYear)) {
          result++;
        }
      }

      for (int i = 0; i < month - 1; i++) {
        result += DAYS_PER_MONTH[i];
      }

      if (isLeap(year) && month > 2) {
        result++;
      }

      return result + day;
    }
  }

  private static boolean isLeap(int year) {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
  }
}
