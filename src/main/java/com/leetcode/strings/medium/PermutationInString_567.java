package com.leetcode.strings.medium;

// Given two strings s1 and s2, return true if s2 contains a permutation of s1,
// or false otherwise.
//
// In other words, return true if one of s1's permutations is the substring of
// s2.
//
//
// Example 1:
//
//
// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").
//
//
// Example 2:
//
//
// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false
//
//
//
// Constraints:
//
//
// 1 <= s1.length, s2.length <= 10⁴
// s1 and s2 consist of lowercase English letters.
//
// Related Topics Hash Table Two Pointers String Sliding Window 👍 5437 👎 157
/*
 O(n) Runtime: 37 ms, faster than 30.23% of Java online submissions for Permutation in String.
 O(k) Memory Usage: 43.9 MB, less than 29.09% of Java online submissions for Permutation in String.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

public class PermutationInString_567 {
  public boolean checkInclusion(String s1, String s2) {
    final Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s1.length(); i++) {
      map.merge(s1.charAt(i), 1, Integer::sum);
    }

    int totalChars = map.size();

    for (int i = 0; i < s2.length(); i++) {

      char currChar = s2.charAt(i);

      if (map.containsKey(currChar)) {
        int nextVal = map.merge(currChar, -1, Integer::sum);

        if (nextVal == 0) {
          totalChars--;
        }
      }

      int prevIdx = i - s1.length();
      if (prevIdx >= 0) {
        char prevChar = s2.charAt(prevIdx);

        if (map.containsKey(prevChar)) {
          int nextVal = map.merge(prevChar, 1, Integer::sum);

          if (nextVal == 1) {
            totalChars++;
          }
        }
      }

      if (totalChars == 0) {
        return true;
      }
    }

    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
