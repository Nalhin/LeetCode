package com.leetcode.strings.medium;

// Given an encoded string, return its decoded string.
//
// The encoding rule is: k[encoded_string], where the encoded_string inside the
// square brackets is being repeated exactly k times. Note that k is guaranteed to
// be a positive integer.
//
// You may assume that the input string is always valid; No extra white spaces,
// square brackets are well-formed, etc.
//
// Furthermore, you may assume that the original data does not contain any digit
// s and that digits are only for those repeat numbers, k. For example, there won't
// be input like 3a or 2[4].
//
//
// Example 1:
// Input: s = "3[a]2[bc]"
// Output: "aaabcbc"
// Example 2:
// Input: s = "3[a2[c]]"
// Output: "accaccacc"
// Example 3:
// Input: s = "2[abc]3[cd]ef"
// Output: "abcabccdcdcdef"
// Example 4:
// Input: s = "abc3[cd]xyz"
// Output: "abccdcdcdxyz"
// Related Topics Stack Depth-first Search
// 👍 3767 👎 186

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString_394 {
  public String decodeString(String s) {
    StringBuilder sb = new StringBuilder();
    Deque<int[]> stack = new ArrayDeque<>();

    for (char c : s.toCharArray()) {
      if (c == '[') {
        int times = parseNum(sb, sb.length() - 1);
        stack.push(new int[] {times, sb.length() - 1});
      } else if (c == ']') {
        int[] timesAndStart = stack.pop();
        String inserted = sb.substring(timesAndStart[1] + 1);
        int times = timesAndStart[0];
        while (times-- > 1) {
          sb.append(inserted);
        }
      } else {
        sb.append(c);
      }
    }
    return sb.toString();
  }

  private int parseNum(StringBuilder sb, int index) {
    int times = 0;
    int base = 1;
    while (index >= 0) {
      char currChar = sb.charAt(index);
      if (!Character.isDigit(currChar)) {
        return times;
      }
      int val = Character.getNumericValue(currChar);
      times += base * val;
      sb.deleteCharAt(index);
      index--;
      base *= 10;
    }
    return times;
  }
}
/*
  O(n * max(k))Runtime: 0 ms, faster than 100.00% of Java online submissions for Decode String.
  O(n) Memory Usage: 39 MB, less than 10.84% of Java online submissions for Decode String.

  where:
  k - number of repetitions
 */
// leetcode submit region end(Prohibit modification and deletion)
