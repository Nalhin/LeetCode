package com.leetcode.strings.medium;

// We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)". Then, we r
// emoved all commas, decimal points, and spaces, and ended up with the string s. R
// eturn a list of strings representing all possibilities for what our original coo
// rdinates could have been.
//
// Our original representation never had extraneous zeroes, so we never started
// with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other numbe
// r that can be represented with less digits. Also, a decimal point within a numbe
// r never occurs without at least one digit occuring before it, so we never starte
// d with numbers like ".1".
//
// The final answer list can be returned in any order. Also note that all coordi
// nates in the final answer have exactly one space between them (occurring after t
// he comma.)
//
//
// Example 1:
// Input: s = "(123)"
// Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
//
//
//
// Example 2:
// Input: s = "(00011)"
// Output:  ["(0.001, 1)", "(0, 0.011)"]
// Explanation:
// 0.0, 00, 0001 or 00.01 are not allowed.
//
//
//
// Example 3:
// Input: s = "(0123)"
// Output: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.
// 12, 3)"]
//
//
//
// Example 4:
// Input: s = "(100)"
// Output: [(10, 0)]
// Explanation:
// 1.0 is not allowed.
//
//
//
//
// Note:
//
//
// 4 <= s.length <= 12.
// s[0] = "(", s[s.length - 1] = ")", and the other elements in s are digits.
//
//
//
// Related Topics String
// 👍 174 👎 395
/*
 O(n^3) Runtime: 11 ms, faster than 38.30% of Java online submissions for Ambiguous Coordinates.
 O(n^3) Memory Usage: 40.3 MB, less than 15.96% of Java online submissions for Ambiguous Coordinates.

*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates_816 {
  public List<String> ambiguousCoordinates(String str) {
    List<String> result = new ArrayList<>();

    for (int i = 1; i < str.length() - 1; i++) {

      List<String> leftStrings = generateDottedStrings(str, 1, i);
      List<String> rightStrings = generateDottedStrings(str, i, str.length() - 1);

      for (String left : leftStrings) {
        for (String right : rightStrings) {
          result.add("(" + left + ", " + right + ")");
        }
      }
    }

    return result;
  }

  private List<String> generateDottedStrings(String str, int leftIdx, int rightIdx) {
    List<String> strings = new ArrayList<>();

    for (int offset = leftIdx + 1; offset <= rightIdx; offset++) {
      String left = str.substring(leftIdx, offset);
      String right = str.substring(offset, rightIdx);
      if (isLeftValid(left) && isRightValid(right)) {
        strings.add(left + (offset < rightIdx ? "." : "") + right);
      }
    }
    return strings;
  }

  private boolean isLeftValid(String left) {
    return !left.startsWith("0") || left.equals("0");
  }

  private boolean isRightValid(String right) {
    return !right.endsWith("0");
  }
}
// leetcode submit region end(Prohibit modification and deletion)
