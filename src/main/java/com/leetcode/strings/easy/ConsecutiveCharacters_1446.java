package com.leetcode.strings.easy;

// Given a string s, the power of the string is the maximum length of a non-empty
// substring that contains only one unique character.
//
// Return the power of the string.
//
//
// Example 1:
//
//
// Input: s = "leetcode"
// Output: 2
// Explanation: The substring "ee" is of length 2 with the character 'e' only.
//
//
// Example 2:
//
//
// Input: s = "abbcccddddeeeeedcba"
// Output: 5
// Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
//
//
//
// Example 3:
//
//
// Input: s = "triplepillooooow"
// Output: 5
//
//
// Example 4:
//
//
// Input: s = "hooraaaaaaaaaaay"
// Output: 11
//
//
// Example 5:
//
//
// Input: s = "tourist"
// Output: 1
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 500
// s contains only lowercase English letters.
// Related Topics String
// 👍 266 👎 7

// leetcode submit region begin(Prohibit modification and deletion)

public class ConsecutiveCharacters_1446 {
  public int maxPower(String s) {
    char[] str = s.toCharArray();

    int max = 0;
    int occ = 1;
    for (int i = 1; i < str.length; i++) {
      if (str[i - 1] != str[i]) {
        max = Math.max(max, occ);
        occ = 1;
      } else {
        occ++;
      }
    }
    return Math.max(max, occ);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
