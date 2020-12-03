package com.leetcode.strings.medium;

// Given an input string s, reverse the order of the words.
//
// A word is defined as a sequence of non-space characters. The words in s will
// be separated by at least one space.
//
// Return a string of the words in reverse order concatenated by a single space.
//
//
// Note that s may contain leading or trailing spaces or multiple spaces between
// two words. The returned string should only have a single space separating the w
// ords. Do not include any extra spaces.
//
//
// Example 1:
//
//
// Input: s = "the sky is blue"
// Output: "blue is sky the"
//
//
// Example 2:
//
//
// Input: s = "  hello world  "
// Output: "world hello"
// Explanation: Your reversed string should not contain leading or trailing space
// s.
//
//
// Example 3:
//
//
// Input: s = "a good   example"
// Output: "example good a"
// Explanation: You need to reduce multiple spaces between two words to a single
// space in the reversed string.
//
//
// Example 4:
//
//
// Input: s = "  Bob    Loves  Alice   "
// Output: "Alice Loves Bob"
//
//
// Example 5:
//
//
// Input: s = "Alice does not even like bob"
// Output: "bob like even not does Alice"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 104
// s contains English letters (upper-case and lower-case), digits, and spaces '
// '.
// There is at least one word in s.
//
//
//
//
// Follow up:
//
//
// Could you solve it in-place with O(1) extra space?
//
//
//
// Related Topics String
// 👍 1360 👎 3081

// leetcode submit region begin(Prohibit modification and deletion)
/*
  O(n) Runtime: 6 ms, faster than 55.96% of Java online submissions for Reverse Words in a String.
  O(n) Memory Usage: 39.2 MB, less than 50.23% of Java online submissions for Reverse Words in a String.
*/
public class ReverseWordsInAString_151 {
  public String reverseWords(String s) {
    char[] word = s.replaceAll("\\s+", " ").toCharArray();

    reverse(word, 0, word.length - 1);

    int prev = 0;
    for (int i = 0; i < word.length; i++) {
      if (word[i] == ' ') {
        reverse(word, prev, i - 1);
        prev = i + 1;
      }
    }

    reverse(word, prev, word.length - 1);

    return new String(word).trim();
  }

  private void reverse(char[] word, int start, int end) {
    while (start < end) {
      swap(word, start, end);
      start++;
      end--;
    }
  }

  private void swap(char[] word, int first, int second) {
    char temp = word[first];
    word[first] = word[second];
    word[second] = temp;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
