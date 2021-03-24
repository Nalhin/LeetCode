package com.leetcode.strings.easy;

// Given an arbitrary ransom note string and another string containing letters fr
// om all the magazines, write a function that will return true if the ransom note
// can be constructed from the magazines ; otherwise, it will return false.
//
// Each letter in the magazine string can only be used once in your ransom note.
//
//
//
// Example 1:
// Input: ransomNote = "a", magazine = "b"
// Output: false
// Example 2:
// Input: ransomNote = "aa", magazine = "ab"
// Output: false
// Example 3:
// Input: ransomNote = "aa", magazine = "aab"
// Output: true
//
//
// Constraints:
//
//
// You may assume that both strings contain only lowercase letters.
//
// Related Topics String
// 👍 838 👎 234
/*
 O(n) Runtime: 3 ms, faster than 80.77% of Java online submissions for Ransom Note.
 O(1) Memory Usage: 39 MB, less than 89.69% of Java online submissions for Ransom Note.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class RansomNote_383 {
  public boolean canConstruct(String ransomNote, String magazine) {
    int[] counter = new int[26];
    for (int i = 0; i < magazine.length(); i++) {
      counter[magazine.charAt(i) - 'a']++;
    }

    for (int i = 0; i < ransomNote.length(); i++) {
      int charNum = ransomNote.charAt(i) - 'a';
      if (counter[charNum] <= 0) {
        return false;
      }
      counter[charNum]--;
    }

    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
