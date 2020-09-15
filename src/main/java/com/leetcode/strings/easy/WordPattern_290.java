package com.leetcode.strings.easy;
// Given a pattern and a string str, find if str follows the same pattern.
//
// Here follow means a full match, such that there is a bijection between a lett
// er in pattern and a non-empty word in str.
//
// Example 1:
//
//
// Input: pattern = "abba", str = "dog cat cat dog"
// Output: true
//
// Example 2:
//
//
// Input:pattern = "abba", str = "dog cat cat fish"
// Output: false
//
// Example 3:
//
//
// Input: pattern = "aaaa", str = "dog cat cat dog"
// Output: false
//
// Example 4:
//
//
// Input: pattern = "abba", str = "dog dog dog dog"
// Output: false
//
// Notes:
// You may assume pattern contains only lowercase letters, and str contains lower
// case letters that may be separated by a single space.
// Related Topics Hash Table
// 👍 1393 👎 179

import java.util.HashMap;

// leetcode submit region begin(Prohibit modification and deletion)
class WordPattern_290 {
  public boolean wordPattern(String pattern, String str) {
    String[] strings = str.split(" ");

    if (strings.length != pattern.length()) {
      return false;
    }
    HashMap<Character, String> patternCache = new HashMap<>();
    HashMap<String, Character> outputCache = new HashMap<>();

    for (int i = 0; i < strings.length; i++) {
      char curr = pattern.charAt(i);
      if (patternCache.containsKey(curr)) {
        if (!patternCache.get(curr).equals(strings[i])) {
          return false;
        }
      } else if (outputCache.containsKey(strings[i]) && outputCache.get(strings[i]) != curr) {
        return false;
      } else {
        outputCache.put(strings[i], curr);
        patternCache.put(curr, strings[i]);
      }
    }
    return true;
  }
}

/*
      Runtime:0 ms, faster than 100.00% of Java online submissions.
	  Memory Usage:37.4 MB, less than 74.79% of Java online submissions.

 */
// leetcode submit region end(Prohibit modification and deletion)
