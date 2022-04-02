package com.leetcode.strings.easy;

// Given a string s, return true if the s can be palindrome after deleting at
// most one character from it.
//
//
// Example 1:
//
//
// Input: s = "aba"
// Output: true
//
//
// Example 2:
//
//
// Input: s = "abca"
// Output: true
// Explanation: You could delete the character 'c'.
//
//
// Example 3:
//
//
// Input: s = "abc"
// Output: false
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 10⁵
// s consists of lowercase English letters.
//
// Related Topics Two Pointers String Greedy 👍 4768 👎 271
/*
 O(n) Runtime: 9 ms, faster than 75.34% of Java online submissions for Valid Palindrome II.
 O(1) Memory Usage: 55.3 MB, less than 17.22% of Java online submissions for Valid Palindrome II.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class ValidPalindrome_680 {
  public boolean validPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
      }

      left++;
      right--;
    }

    return true;
  }

  private boolean isPalindrome(String s, int left, int right) {

    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }

      left++;
      right--;
    }

    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
