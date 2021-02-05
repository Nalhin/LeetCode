package com.leetcode.strings.easy;

// Given alphanumeric string s. (Alphanumeric string is a string consisting of lo
// wercase English letters and digits).
//
// You have to find a permutation of the string where no letter is followed by a
// nother letter and no digit is followed by another digit. That is, no two adjacen
// t characters have the same type.
//
// Return the reformatted string or return an empty string if it is impossible t
// o reformat the string.
//
//
// Example 1:
//
//
// Input: s = "a0b1c2"
// Output: "0a1b2c"
// Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c
// 2", "0a1b2c", "0c2a1b" are also valid permutations.
//
//
// Example 2:
//
//
// Input: s = "leetcode"
// Output: ""
// Explanation: "leetcode" has only characters so we cannot separate them by digi
// ts.
//
//
// Example 3:
//
//
// Input: s = "1229857369"
// Output: ""
// Explanation: "1229857369" has only digits so we cannot separate them by charac
// ters.
//
//
// Example 4:
//
//
// Input: s = "covid2019"
// Output: "c2o0v1i9d"
//
//
// Example 5:
//
//
// Input: s = "ab123"
// Output: "1a2b3"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 500
// s consists of only lowercase English letters and/or digits.
//
// Related Topics String
// 👍 210 👎 50

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;
/*
 O(n) Runtime: 5 ms, faster than 64.60% of Java online submissions for Reformat The String.
 O(n) Memory Usage: 39.6 MB, less than 50.11% of Java online submissions for Reformat The String.
*/
public class ReformatTheString_1417 {
  public String reformat(String s) {
    Deque<Character> nums = new ArrayDeque<>();
    Deque<Character> letters = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      if (Character.isDigit(s.charAt(i))) {
        nums.push(s.charAt(i));
      } else {
        letters.push(s.charAt(i));
      }
    }

    if (Math.abs(nums.size() - letters.size()) > 1) {
      return "";
    }

    StringBuilder sb = new StringBuilder();
    if (letters.size() != nums.size()) {
      sb.append(nums.size() > letters.size() ? nums.pop() : letters.pop());
    }
    while (!nums.isEmpty()) {
      sb.append(nums.pop());
      sb.append(letters.pop());
    }

    return sb.toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
