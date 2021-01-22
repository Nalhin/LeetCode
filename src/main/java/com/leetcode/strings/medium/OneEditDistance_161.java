package com.leetcode.strings.medium;

// Given two strings s and t, return true if they are both one edit distance apar
// t, otherwise return false.
//
// A string s is said to be one distance apart from a string t if you can:
//
//
// Insert exactly one character into s to get t.
// Delete exactly one character from s to get t.
// Replace exactly one character of s with a different character to get t.
//
//
//
// Example 1:
//
//
// Input: s = "ab", t = "acb"
// Output: true
// Explanation: We can insert 'c' into s to get t.
//
//
// Example 2:
//
//
// Input: s = "", t = ""
// Output: false
// Explanation: We cannot get t from s by only one step.
//
//
// Example 3:
//
//
// Input: s = "a", t = ""
// Output: true
//
//
// Example 4:
//
//
// Input: s = "", t = "A"
// Output: true
//
//
//
// Constraints:
//
//
// 0 <= s.length <= 104
// 0 <= t.length <= 104
// s and t consist of lower-case letters, upper-case letters and/or digits.
//
// Related Topics String
// 👍 736 👎 128

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 1 ms, faster than 79.59% of Java online submissions for One Edit Distance.
 O(1) Memory Usage: 37.7 MB, less than 63.42% of Java online submissions for One Edit Distance.
*/
public class OneEditDistance_161 {
  public boolean isOneEditDistance(String s, String t) {
    if (Math.abs(s.length() - t.length()) > 1) {
      return false;
    }

    int min = Math.min(s.length(), t.length());

    for (int i = 0; i < min; i++) {
      if (s.charAt(i) != t.charAt(i)) {
        int diff = s.length() - t.length();
        int leftInc = diff == -1 ? 0 : 1;
        int rightInc = diff == 1 ? 0 : 1;
        for (int j = i; j < s.length() - leftInc && j < t.length() - rightInc; j++) {
          if (s.charAt(j + leftInc) != t.charAt(j + rightInc)) {
            return false;
          }
        }
        return true;
      }
    }

    return Math.abs(t.length() - s.length()) == 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
