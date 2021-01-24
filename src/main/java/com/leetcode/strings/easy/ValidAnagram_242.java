package com.leetcode.strings.easy;

// Given two strings s and t , write a function to determine if t is an anagram o
// f s.
//
// Example 1:
//
//
// Input: s = "anagram", t = "nagaram"
// Output: true
//
//
// Example 2:
//
//
// Input: s = "rat", t = "car"
// Output: false
//
//
// Note:
// You may assume the string contains only lowercase alphabets.
//
// Follow up:
// What if the inputs contain unicode characters? How would you adapt your soluti
// on to such case?
// Related Topics Hash Table Sort
// 👍 2143 👎 156

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 3 ms, faster than 74.53% of Java online submissions for Valid Anagram.
 O(1) Memory Usage: 39.2 MB, less than 62.54% of Java online submissions for Valid Anagram.
*/
public class ValidAnagram_242 {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] counter = new int[26];

    for (int i = 0; i < t.length(); i++) {
      counter[s.charAt(i) - 'a']++;
      counter[t.charAt(i) - 'a']--;
    }

    for (int count : counter) {
      if (count != 0) {
        return false;
      }
    }

    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
