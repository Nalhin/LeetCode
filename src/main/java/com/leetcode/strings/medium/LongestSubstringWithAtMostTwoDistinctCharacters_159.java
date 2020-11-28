package com.leetcode.strings.medium;

// most 2 distinct characters.
//
// Example 1:
//
//
// Input: "eceba"
// Output: 3
// Explanation: t is "ece" which its length is 3.
//
//
// Example 2:
//
//
// Input: "ccaabbb"
// Output: 5
// Explanation: t is "aabbb" which its length is 5.
//
// Related Topics Hash Table Two Pointers String Sliding Window
// 👍 1127 👎 20

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/*
 O(n) Runtime: 10 ms, faster than 22.19% of Java online submissions for Longest Substring with At Most Two Distinct Characters.
 O(1) Memory Usage: 39.1 MB, less than 44.79% of Java online submissions for Longest Substring with At Most Two Distinct Characters.
*/
public class LongestSubstringWithAtMostTwoDistinctCharacters_159 {
  private final int COUNT = 2;

  public int lengthOfLongestSubstringTwoDistinct(String s) {
    if (s.length() < 3) {
      return s.length();
    }

    Map<Character, Integer> dups = new HashMap<>();

    int left = 0;
    int max = 2;
    for (int i = 0; i < s.length(); i++) {
      dups.put(s.charAt(i), i);

      if (dups.size() > COUNT) {
        int del = Collections.min(dups.values());
        dups.remove(s.charAt(del));
        left = del + 1;
      }

      max = Math.max(i - left + 1, max);
    }
    return max;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
