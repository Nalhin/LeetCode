package com.leetcode.strings.easy;

//
// Given a non-empty string s and an abbreviation abbr, return whether the string
// matches with the given abbreviation.
//
//
// A string such as "word" contains only the following valid abbreviations:
//
// ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1",
// "w1r1", "1o2", "2r1", "3d", "w3", "4"]
//
//
// Notice that only the above abbreviations are valid abbreviations of the strin
// g "word". Any other string is not a valid abbreviation of "word".
//
// Note:
// Assume s contains only lowercase letters and abbr contains only lowercase lett
// ers and digits.
//
//
// Example 1:
//
// Given s = "internationalization", abbr = "i12iz4n":
//
// Return true.
//
//
//
// Example 2:
//
// Given s = "apple", abbr = "a2e":
//
// Return false.
//
// Related Topics String
// 👍 182 👎 757

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Word Abbreviation.
 O(1) Memory Usage: 37.2 MB, less than 77.43% of Java online submissions for Valid Word Abbreviation.
*/
public class ValidWordAbbreviation_408 {
  public boolean validWordAbbreviation(String word, String abbr) {
    int currNum = 0;
    int wordIdx = 0;

    for (int i = 0; i < abbr.length(); i++) {
      char currChar = abbr.charAt(i);
      if (currChar == '0' && currNum == 0) {
        return false;
      }

      if (currChar >= '0' && currChar <= '9') {
        currNum = currNum * 10 + (currChar - '0');
      } else {
        wordIdx += currNum;

        if (wordIdx >= word.length() || currChar != word.charAt(wordIdx)) {
          return false;
        }

        currNum = 0;
        wordIdx++;
      }
    }

    return wordIdx + currNum == word.length();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
