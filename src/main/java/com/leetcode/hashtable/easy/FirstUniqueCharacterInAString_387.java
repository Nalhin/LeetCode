package com.leetcode.hashtable.easy;

// Given a string, find the first non-repeating character in it and return its in
// dex. If it doesn't exist, return -1.
//
// Examples:
//
//
// s = "leetcode"
// return 0.
//
// s = "loveleetcode"
// return 2.
//
//
//
//
// Note: You may assume the string contains only lowercase English letters.
// Related Topics Hash Table String
// 👍 2214 👎 120

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString_387 {
  public int firstUniqChar(String s) {
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    }

    for (int i = 0; i < s.length(); i++) {
      if (map.get(s.charAt(i)) == 1) {
        return i;
      }
    }

    return -1;
  }
}
/*
 O(n) Runtime: 24 ms, faster than 42.47% of Java online submissions for First Unique Character in a String.
 O(1) Memory Usage: 38.9 MB, less than 100.00% of Java online submissions for First Unique Character in a String.
*/
// leetcode submit region end(Prohibit modification and deletion)
