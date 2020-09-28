package com.leetcode.hashtable.easy;

// Given two strings s and t, determine if they are isomorphic.
//
// Two strings are isomorphic if the characters in s can be replaced to get t.
//
// All occurrences of a character must be replaced with another character while
// preserving the order of characters. No two characters may map to the same charac
// ter but a character may map to itself.
//
// Example 1:
//
//
// Input: s = "egg", t = "add"
// Output: true
//
//
// Example 2:
//
//
// Input: s = "foo", t = "bar"
// Output: false
//
// Example 3:
//
//
// Input: s = "paper", t = "title"
// Output: true
//
// Note:
// You may assume both s and t have the same length.
// Related Topics Hash Table
// 👍 1562 👎 385

// leetcode submit region begin(Prohibit modification and deletion)

public class IsomorphicStrings_205 {
  public boolean isIsomorphic(String s, String t) {
    int[] mapS = new int[256];
    int[] mapT = new int[256];

    for (int i = 0; i < s.length(); i++) {
      if (mapS[s.charAt(i)] != mapT[t.charAt(i)]) {
        return false;
      }
      mapS[s.charAt(i)] = i + 1;
      mapT[t.charAt(i)] = i + 1;
    }
    return true;
  }
}
/*
  O(n) Runtime: 4 ms, faster than 91.47% of Java online submissions for Isomorphic Strings.
  O(1) Memory Usage: 39 MB, less than 99.29% of Java online submissions for Isomorphic Strings.
*/

// leetcode submit region end(Prohibit modification and deletion)
