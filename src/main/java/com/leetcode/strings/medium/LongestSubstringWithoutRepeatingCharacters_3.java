package com.leetcode.strings.medium;
// Given a string s, find the length of the longest substring without repeating c
// haracters.
//
//
// Example 1:
//
//
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
//
//
// Example 2:
//
//
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
//
//
// Example 3:
//
//
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a
// substring.
//
//
// Example 4:
//
//
// Input: s = ""
// Output: 0
//
//
//
// Constraints:
//
//
// 0 <= s.length <= 5 * 104
// s consists of English letters, digits, symbols and spaces.
//
// Related Topics Hash Table Two Pointers String Sliding Window
// 👍 10967 👎 618

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters_3 {
  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int initial = 0;
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      char key = s.charAt(i);

      if (map.containsKey(key)) {
        int pos = map.get(key);

        for (int j = initial; j < pos; j++) {
          map.remove(s.charAt(j));
        }
        initial = pos + 1;
      }

      map.put(key, i);
      max = Math.max(i - initial, max);
    }
    return max;
  }
}
/*
  O(n) Runtime: 4 ms, faster than 91.11% of Java online submissions for Longest Substring Without Repeating Characters.
  O(1) Memory Usage: 39 MB, less than 99.43% of Java online submissions for Longest Substring Without Repeating Characters.
*/

// leetcode submit region end(Prohibit modification and deletion)
