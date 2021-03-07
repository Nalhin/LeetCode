package com.leetcode.strings.easy;

// Given a string s, return the length of the longest substring between two equal
// characters, excluding the two characters. If there is no such substring return
// -1.
//
// A substring is a contiguous sequence of characters within a string.
//
//
// Example 1:
//
//
// Input: s = "aa"
// Output: 0
// Explanation: The optimal substring here is an empty substring between the two
// 'a's.
//
// Example 2:
//
//
// Input: s = "abca"
// Output: 2
// Explanation: The optimal substring here is "bc".
//
//
// Example 3:
//
//
// Input: s = "cbzxy"
// Output: -1
// Explanation: There are no characters that appear twice in s.
//
//
// Example 4:
//
//
// Input: s = "cabbac"
// Output: 4
// Explanation: The optimal substring here is "abba". Other non-optimal substring
// s include "bb" and "".
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 300
// s contains only lowercase English letters.
//
// Related Topics String
// 👍 186 👎 11

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
/*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Largest Substring Between Two Equal Characters.
  O(1) Memory Usage: 37.1 MB, less than 37.19% of Java online submissions for Largest Substring Between Two Equal Characters.
*/
public class LargestSubstringBetweenTwoEqualCharacters_1624 {
  public int maxLengthBetweenEqualCharacters(String s) {
    int result = -1;

    int[] chars = new int[26];
    Arrays.fill(chars, -1);

    for (int i = 0; i < s.length(); i++) {
      int idx = s.charAt(i) - 'a';

      if (chars[idx] == -1) {
        chars[idx] = i;
      } else {
        result = Math.max(result, i - chars[idx] - 1);
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
