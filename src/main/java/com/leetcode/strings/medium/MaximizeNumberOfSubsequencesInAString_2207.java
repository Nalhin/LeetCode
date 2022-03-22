package com.leetcode.strings.medium;

// You are given a 0-indexed string text and another 0-indexed string pattern of
// length 2, both of which consist of only lowercase English letters.
//
// You can add either pattern[0] or pattern[1] anywhere in text exactly once.
// Note that the character can be added even at the beginning or at the end of text.
//
//
// Return the maximum number of times pattern can occur as a subsequence of the
// modified text.
//
// A subsequence is a string that can be derived from another string by
// deleting some or no characters without changing the order of the remaining characters.
//
//
// Example 1:
//
//
// Input: text = "abdcdbc", pattern = "ac"
// Output: 4
// Explanation:
// If we add pattern[0] = 'a' in between text[1] and text[2], we get "abadcdbc".
// Now, the number of times "ac" occurs as a subsequence is 4.
// Some other strings which have 4 subsequences "ac" after adding a character to
// text are "aabdcdbc" and "abdacdbc".
// However, strings such as "abdcadbc", "abdccdbc", and "abdcdbcc", although
// obtainable, have only 3 subsequences "ac" and are thus suboptimal.
// It can be shown that it is not possible to get more than 4 subsequences "ac"
// by adding only one character.
//
//
// Example 2:
//
//
// Input: text = "aabb", pattern = "ab"
// Output: 6
// Explanation:
// Some of the strings which can be obtained from text and have 6 subsequences
// "ab" are "aaabb", "aaabb", and "aabbb".
//
//
//
// Constraints:
//
//
// 1 <= text.length <= 10⁵
// pattern.length == 2
// text and pattern consist only of lowercase English letters.
//
// 👍 162 👎 11
/*
 O(n) Runtime: 42 ms, faster than 38.45% of Java online submissions for Maximize Number of Subsequences in a String.
 O(n) Memory Usage: 54.9 MB, less than 38.45% of Java online submissions for Maximize Number of Subsequences in a String.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class MaximizeNumberOfSubsequencesInAString_2207 {
  public long maximumSubsequenceCount(String text, String pattern) {
    char firstChar = pattern.charAt(0);
    char secondChar = pattern.charAt(1);

    return Math.max(
        countSub(firstChar + text, firstChar, secondChar),
        countSub(text + secondChar, firstChar, secondChar));
  }

  private long countSub(String text, char firstChar, char secondChar) {
    long result = 0;
    int firstCount = 0;

    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == secondChar) {
        result += firstCount;
      }
      if (text.charAt(i) == firstChar) {
        firstCount++;
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
