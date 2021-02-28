package com.leetcode.strings.easy;

// Given a word, you need to judge whether the usage of capitals in it is right o
// r not.
//
// We define the usage of capitals in a word to be right when one of the followi
// ng cases holds:
//
//
// All letters in this word are capitals, like "USA".
// All letters in this word are not capitals, like "leetcode".
// Only the first letter in this word is capital, like "Google".
//
// Otherwise, we define that this word doesn't use capitals in a right way.
//
//
//
// Example 1:
//
//
// Input: "USA"
// Output: True
//
//
//
//
// Example 2:
//
//
// Input: "FlaG"
// Output: False
//
//
//
//
// Note: The input will be a non-empty word consisting of uppercase and lowercas
// e latin letters.
// Related Topics String
// 👍 772 👎 288

// leetcode submit region begin(Prohibit modification and deletion)

public class DetectCapital_520 {
  public boolean detectCapitalUse(String word) {
    int capitals = 0;

    for (int i = 0; i < word.length(); i++) {
      if (Character.isUpperCase(word.charAt(i))) {
        capitals++;
      }
    }

    return capitals == word.length()
        || capitals == 0
        || (capitals == 1 && Character.isUpperCase(word.charAt(0)));
  }
}
// leetcode submit region end(Prohibit modification and deletion)
