package com.leetcode.hashtable.hard;

// Given two strings s and t of lengths m and n respectively, return the minimum
// window substring of s such that every character in t (including duplicates) is i
// ncluded in the window. If there is no such substring, return the empty string ""
// .
//
// The testcases will be generated such that the answer is unique.
//
// A substring is a contiguous sequence of characters within the string.
//
//
// Example 1:
//
//
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' fr
// om string t.
//
//
// Example 2:
//
//
// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.
//
//
// Example 3:
//
//
// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window.
// Since the largest window of s only has one 'a', return empty string.
//
//
//
// Constraints:
//
//
// m == s.length
// n == t.length
// 1 <= m, n <= 105
// s and t consist of uppercase and lowercase English letters.
//
//
//
// Follow up: Could you find an algorithm that runs in O(m + n) time? Related Top
// ics Hash Table String Sliding Window
// 👍 7628 👎 479
/*
 O(n + m) Runtime: 12 ms, faster than 53.09% of Java online submissions for Minimum Window Substring.
 O(n + m) Memory Usage: 38.8 MB, less than 94.50% of Java online submissions for Minimum Window Substring.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring_76 {

  public String minWindow(String s, String t) {
    Map<Character, Integer> chars = new HashMap<>();
    int totalCharsFilled = 0;

    for (int i = 0; i < t.length(); i++) {
      chars.merge(t.charAt(i), 1, Integer::sum);
    }

    int resultStart = -1;
    int resultEnd = s.length();

    for (int left = 0, right = 0; right < s.length(); right++) {
      if (chars.containsKey(s.charAt(right))) {
        int val = chars.merge(s.charAt(right), -1, Integer::sum);
        if (val == 0) {
          totalCharsFilled++;
        }
      }

      while (totalCharsFilled == chars.size()) {
        if (resultEnd - resultStart > right - left) {
          resultStart = left;
          resultEnd = right;
        }

        if (chars.containsKey(s.charAt(left))) {
          int val = chars.merge(s.charAt(left), 1, Integer::sum);
          if (val == 1) {
            totalCharsFilled--;
          }
        }

        left++;
      }
    }

    if (resultEnd - resultStart > s.length()) {
      return "";
    }

    return s.substring(resultStart, resultEnd + 1);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
