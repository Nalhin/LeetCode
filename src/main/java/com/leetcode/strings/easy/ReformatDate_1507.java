package com.leetcode.strings.easy;

// Given a date string in the form Day Month Year, where:
//
//
// Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
// Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
// "Sep", "Oct", "Nov", "Dec"}.
// Year is in the range [1900, 2100].
//
//
// Convert the date string to the format YYYY-MM-DD, where:
//
//
// YYYY denotes the 4 digit year.
// MM denotes the 2 digit month.
// DD denotes the 2 digit day.
//
//
//
// Example 1:
//
//
// Input: date = "20th Oct 2052"
// Output: "2052-10-20"
//
//
// Example 2:
//
//
// Input: date = "6th Jun 1933"
// Output: "1933-06-06"
//
//
// Example 3:
//
//
// Input: date = "26th May 1960"
// Output: "1960-05-26"
//
//
//
// Constraints:
//
//
// The given dates are guaranteed to be valid, so no error handling is necessary
// .
//
// Related Topics String
// 👍 111 👎 204

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

public class ReformatDate_1507 {
  private static final Map<String, Integer> months = new HashMap<>();

  static {
    months.put("Jan", 1);
    months.put("Feb", 2);
    months.put("Mar", 3);
    months.put("Apr", 4);
    months.put("May", 5);
    months.put("Jun", 6);
    months.put("Jul", 7);
    months.put("Aug", 8);
    months.put("Sep", 9);
    months.put("Oct", 10);
    months.put("Nov", 11);
    months.put("Dec", 12);
  }

  public String reformatDate(String date) {
    String[] fields = date.split(" ");
    String dayString = fields[0];

    int days = Integer.parseInt(dayString.substring(0, dayString.length() == 3 ? 1 : 2));
    int month = months.get(fields[1]);
    int year = Integer.parseInt(fields[2]);

    return year + "-" + appendZero(month) + "-" + appendZero(days);
  }

  public String appendZero(int num){
    return num < 10 ? "0" + num : "" + num;
  }

}
// leetcode submit region end(Prohibit modification and deletion)
