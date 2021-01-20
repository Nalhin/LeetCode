package com.leetcode.strings.easy;

// Given a string, determine if it is a palindrome, considering only alphanumeric
// characters and ignoring cases.
//
// Note: For the purpose of this problem, we define empty string as valid palind
// rome.
//
// Example 1:
//
//
// Input: "A man, a plan, a canal: Panama"
// Output: true
//
//
// Example 2:
//
//
// Input: "race a car"
// Output: false
//
//
//
// Constraints:
//
//
// s consists only of printable ASCII characters.
//
// Related Topics Two Pointers String
// 👍 1691 👎 3475

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 2 ms, faster than 97.84% of Java online submissions for Valid Palindrome.
 O(1) Memory Usage: 38.8 MB, less than 94.34% of Java online submissions for Valid Palindrome.
*/
public class ValidPalindrome_125 {
  public boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {

      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      }

      if ((s.charAt(left) | ' ') != (s.charAt(right) | ' ')) {
        return false;
      }
      left++;
      right--;
    }

    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
