package com.leetcode.strings.hard;

// A valid number can be split up into these components (in order):
//
//
// A decimal number or an integer.
// (Optional) An 'e' or 'E', followed by an integer.
//
//
// A decimal number can be split up into these components (in order):
//
//
// (Optional) A sign character (either '+' or '-').
// One of the following formats:
//
// At least one digit, followed by a dot '.'.
// At least one digit, followed by a dot '.', followed by at least one digit.
// A dot '.', followed by at least one digit.
//
//
//
//
// An integer can be split up into these components (in order):
//
//
// (Optional) A sign character (either '+' or '-').
// At least one digit.
//
//
// For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.1
// 4", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"], w
// hile the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "-
// -6", "-+3", "95a54e53"].
//
// Given a string s, return true if s is a valid number.
//
//
// Example 1:
//
//
// Input: s = "0"
// Output: true
//
//
// Example 2:
//
//
// Input: s = "e"
// Output: false
//
//
// Example 3:
//
//
// Input: s = "."
// Output: false
//
//
// Example 4:
//
//
// Input: s = ".1"
// Output: true
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 20
// s consists of only English letters (both uppercase and lowercase), digits (0-
// 9), plus '+', minus '-', or dot '.'.
//
// Related Topics Math String
// 👍 68 👎 198
/*
 O(n) Runtime: 3 ms, faster than 26.63% of Java online submissions for Valid Number.
 O(n) Memory Usage: 39.3 MB, less than 18.75% of Java online submissions for Valid Number.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class ValidNumber_65 {
  public boolean isNumber(String s) {
    boolean startsWithSign = s.startsWith("+") || s.startsWith("-");

    boolean hasDot = false;

    for (int i = startsWithSign ? 1 : 0; i < s.length(); i++) {
      if (s.charAt(i) == 'E' || s.charAt(i) == 'e') {
        return isValidInteger(s.substring(0, i).replace(".", ""))
            && isValidInteger(s.substring(i + 1));
      } else if (s.charAt(i) == '.') {
        if (hasDot) {
          return false;
        }
        if (!(i > 0 && Character.isDigit(s.charAt(i - 1)))
            && !(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))) {
          return false;
        }

        hasDot = true;
      } else if (!Character.isDigit(s.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  private boolean isValidInteger(String s) {
    boolean startsWithSign = s.startsWith("+") || s.startsWith("-");

    if (s.length() == (startsWithSign ? 1 : 0)) {
      return false;
    }

    for (int i = startsWithSign ? 1 : 0; i < s.length(); i++) {
      if (!Character.isDigit(s.charAt(i))) {
        return false;
      }
    }

    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
