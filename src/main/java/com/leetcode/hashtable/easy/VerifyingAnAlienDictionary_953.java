package com.leetcode.hashtable.easy;

// In an alien language, surprisingly they also use english lowercase letters, bu
// t possibly in a different order. The order of the alphabet is some permutation o
// f lowercase letters.
//
// Given a sequence of words written in the alien language, and the order of the
// alphabet, return true if and only if the given words are sorted lexicographical
// y in this alien language.
//
// Example 1:
//
//
// Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
// Output: true
// Explanation: As 'h' comes before 'l' in this language, then the sequence is so
// rted.
//
//
// Example 2:
//
//
// Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
// Output: false
// Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1]
// , hence the sequence is unsorted.
//
//
// Example 3:
//
//
// Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
// Output: false
// Explanation: The first three characters "app" match, and the second string is
// shorter (in size.) According to lexicographical rules "apple" > "app", because '
// l' > '∅', where '∅' is defined as the blank character which is less than any oth
// er character (More info).
//
//
//
// Constraints:
//
//
// 1 <= words.length <= 100
// 1 <= words[i].length <= 20
// order.length == 26
// All characters in words[i] and order are English lowercase letters.
//
// Related Topics Hash Table
// 👍 1308 👎 542

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n * m) Runtime: 0 ms, faster than 100.00% of Java online submissions for Verifying an Alien Dictionary.
 O(1) Memory Usage: 37.6 MB, less than 71.98% of Java online submissions for Verifying an Alien Dictionary.
*/
public class VerifyingAnAlienDictionary_953 {
  public boolean isAlienSorted(String[] words, String order) {
    int[] map = new int[26];
    for (int i = 0; i < order.length(); ++i) {
      map[order.charAt(i) - 'a'] = i;
    }

    for (int i = 0; i < words.length - 1; ++i) {
      String word1 = words[i];
      String word2 = words[i + 1];

      boolean checkLen = true;

      for (int j = 0; j < Math.min(word1.length(), word2.length()); ++j) {
        if (word1.charAt(j) != word2.charAt(j)) {
          if (map[word1.charAt(j) - 'a'] > map[word2.charAt(j) - 'a']) {
            return false;
          }
          checkLen = false;
          break;
        }
      }

      if (checkLen && word1.length() > word2.length()) {
        return false;
      }
    }

    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
