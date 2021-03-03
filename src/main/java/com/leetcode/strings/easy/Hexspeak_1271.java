package com.leetcode.strings.easy;

// A decimal number can be converted to its Hexspeak representation by first conv
// erting it to an uppercase hexadecimal string, then replacing all occurrences of
// the digit 0 with the letter O, and the digit 1 with the letter I. Such a represe
// ntation is valid if and only if it consists only of the letters in the set {"A",
// "B", "C", "D", "E", "F", "I", "O"}.
//
// Given a string num representing a decimal integer N, return the Hexspeak repr
// esentation of N if it is valid, otherwise return "ERROR".
//
//
// Example 1:
//
//
// Input: num = "257"
// Output: "IOI"
// Explanation:  257 is 101 in hexadecimal.
//
//
// Example 2:
//
//
// Input: num = "3"
// Output: "ERROR"
//
//
//
// Constraints:
//
//
// 1 <= N <= 10^12
// There are no leading zeros in the given string.
// All answers must be in uppercase letters.
//
// Related Topics Math String
// 👍 42 👎 73

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Map;
/*
 O(log(n)) Runtime: 2 ms, faster than 77.78% of Java online submissions for Hexspeak.
 O(1) Memory Usage: 37.3 MB, less than 95.37% of Java online submissions for Hexspeak.
*/
public class Hexspeak_1271 {
  private static final Map<Long, Character> transforms =
      Map.of(1L, 'I', 0L, 'O', 10L, 'A', 11L, 'B', 12L, 'C', 13L, 'D', 14L, 'E', 15L, 'F');

  public String toHexspeak(String num) {
    long numAsInt = Long.parseLong(num);
    StringBuilder sb = new StringBuilder();

    while (numAsInt > 0) {
      long code = numAsInt % 16;
      if (!transforms.containsKey(code)) {
        return "ERROR";
      }
      sb.append(transforms.get(code));
      numAsInt /= 16;
    }

    return sb.toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
