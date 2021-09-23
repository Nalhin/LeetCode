package com.leetcode.strings.medium;

// Given a palindromic string of lowercase English letters palindrome, replace
// exactly one character with any lowercase English letter so that the resulting
// string is not a palindrome and that it is the lexicographically smallest one
// possible.
//
// Return the resulting string. If there is no way to replace a character to
// make it not a palindrome, return an empty string.
//
// A string a is lexicographically smaller than a string b (of the same length)
// if in the first position where a and b differ, a has a character strictly
// smaller than the corresponding character in b. For example, "abcc" is
// lexicographically smaller than "abcd" because the first position they differ is at the fourth
// character, and 'c' is smaller than 'd'.
//
//
// Example 1:
//
//
// Input: palindrome = "abccba"
// Output: "aaccba"
// Explanation: There are many ways to make "abccba" not a palindrome, such as
// "zbccba", "aaccba", and "abacba".
// Of all the ways, "aaccba" is the lexicographically smallest.
//
//
// Example 2:
//
//
// Input: palindrome = "a"
// Output: ""
// Explanation: There is no way to replace a single character to make "a" not a
// palindrome, so return an empty string.
//
//
// Example 3:
//
//
// Input: palindrome = "aa"
// Output: "ab"
//
// Example 4:
//
//
// Input: palindrome = "aba"
// Output: "abb"
//
//
//
// Constraints:
//
//
// 1 <= palindrome.length <= 1000
// palindrome consists of only lowercase English letters.
//
// Related Topics String Greedy 👍 452 👎 354
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Break a Palindrome.
 O(n) Memory Usage: 36.9 MB, less than 79.60% of Java online submissions for Break a Palindrome.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class BreakAPalindrome_1328 {
  public String breakPalindrome(String palindrome) {
    if (palindrome.length() == 1) {
      return "";
    }

    char[] result = palindrome.toCharArray();

    for (int i = 0; i < palindrome.length() / 2; i++) {
      if (result[i] != 'a') {
        result[i] = 'a';
        return new String(result);
      }
    }

    result[palindrome.length() - 1] = 'b';
    return new String(result);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
