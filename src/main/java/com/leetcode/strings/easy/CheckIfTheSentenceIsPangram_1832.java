package com.leetcode.strings.easy;

// A pangram is a sentence where every letter of the English alphabet appears at
// least once.
//
// Given a string sentence containing only lowercase English letters, return tru
// e if sentence is a pangram, or false otherwise.
//
//
// Example 1:
//
//
// Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
// Output: true
// Explanation: sentence contains at least one of every letter of the English alp
// habet.
//
//
// Example 2:
//
//
// Input: sentence = "leetcode"
// Output: false
//
//
//
// Constraints:
//
//
// 1 <= sentence.length <= 1000
// sentence consists of lowercase English letters.
//
// Related Topics String
// 👍 75 👎 0
/*
 O(n) Runtime: 2 ms, faster than 60.44% of Java online submissions for Check if the Sentence Is Pangram.
 O(1) Memory Usage: 38.9 MB, less than 24.22% of Java online submissions for Check if the Sentence Is Pangram.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class CheckIfTheSentenceIsPangram_1832 {
  public boolean checkIfPangram(String sentence) {
    boolean[] letters = new boolean[26];

    for (int i = 0; i < sentence.length(); i++) {
      letters[sentence.charAt(i) - 'a'] = true;
    }

    for (boolean exists : letters) {
      if (!exists) {
        return false;
      }
    }

    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
