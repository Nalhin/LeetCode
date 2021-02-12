package com.leetcode.strings.easy;

// Given a string s formed by digits ('0' - '9') and '#' . We want to map s to En
// glish lowercase characters as follows:
//
//
// Characters ('a' to 'i') are represented by ('1' to '9') respectively.
// Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
//
//
// Return the string formed after mapping.
//
// It's guaranteed that a unique mapping will always exist.
//
//
// Example 1:
//
//
// Input: s = "10#11#12"
// Output: "jkab"
// Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
//
//
// Example 2:
//
//
// Input: s = "1326#"
// Output: "acz"
//
//
// Example 3:
//
//
// Input: s = "25#"
// Output: "y"
//
//
// Example 4:
//
//
// Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
// Output: "abcdefghijklmnopqrstuvwxyz"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 1000
// s[i] only contains digits letters ('0'-'9') and '#' letter.
// s will be valid string such that mapping is always possible.
//
// Related Topics String
// 👍 488 👎 48

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;
/*
 O(n) Runtime: 1 ms, faster than 77.26% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
 O(n) Memory Usage: 37.5 MB, less than 63.34% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
*/
public class DecryptStringFromAlphabetToIntegerMapping_1309 {
  private final int DIFF = 'a' - 1;

  public String freqAlphabets(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != '#') {
        stack.push(Character.getNumericValue(s.charAt(i)));
      } else {
        int prev = stack.pop() + stack.pop() * 10;
        while (!stack.isEmpty()) {
          sb.append((char) (stack.removeLast() + DIFF));
        }
        sb.append((char) (prev + DIFF));
      }
    }
    while (!stack.isEmpty()) {
      sb.append((char) (stack.removeLast() + DIFF));
    }

    return sb.toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
