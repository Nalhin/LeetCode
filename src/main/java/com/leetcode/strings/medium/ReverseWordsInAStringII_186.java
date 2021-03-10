package com.leetcode.strings.medium;

// Given a character array s, reverse the order of the words.
//
// A word is defined as a sequence of non-space characters. The words in s will
// be separated by a single space.
//
//
// Example 1:
// Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
// Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
// Example 2:
// Input: s = ["a"]
// Output: ["a"]
//
//
// Constraints:
//
//
// 1 <= s.length <= 105
// s[i] is an English letter (uppercase or lowercase), digit, or space ' '.
// There is at least one word in s.
// s does not contain leading or trailing spaces.
// All the words in s are guaranteed to be separated by a single space.
//
//
//
// Follow up: Could you do it in-place without allocating extra space? Related To
// pics String
// 👍 557 👎 110

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 1 ms, faster than 99.70% of Java online submissions for Reverse Words in a String II.
 O(1) Memory Usage: 42.1 MB, less than 100.00% of Java online submissions for Reverse Words in a String II.
*/
public class ReverseWordsInAStringII_186 {
  public void reverseWords(char[] s) {

    int last = 0;
    for (int i = 0; i < s.length; i++) {
      if (s[i] == ' ') {
        reverse(s, last, i - 1);
        last = i + 1;
      }
    }
    reverse(s, last, s.length - 1);
    reverse(s, 0, s.length - 1);
  }

  private void reverse(char[] arr, int from, int to) {
    while (from < to) {
      swap(arr, from++, to--);
    }
  }

  private void swap(char[] arr, int first, int second) {
    char temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
