package com.leetcode.strings.easy;

// Given an array of strings words, return the first palindromic string in the
// array. If there is no such string, return an empty string "".
//
// A string is palindromic if it reads the same forward and backward.
//
//
// Example 1:
//
//
// Input: words = ["abc","car","ada","racecar","cool"]
// Output: "ada"
// Explanation: The first string that is palindromic is "ada".
// Note that "racecar" is also palindromic, but it is not the first.
//
//
// Example 2:
//
//
// Input: words = ["notapalindrome","racecar"]
// Output: "racecar"
// Explanation: The first and only string that is palindromic is "racecar".
//
//
// Example 3:
//
//
// Input: words = ["def","ghi"]
// Output: ""
// Explanation: There are no palindromic strings, so the empty string is
// returned.
//
//
//
// Constraints:
//
//
// 1 <= words.length <= 100
// 1 <= words[i].length <= 100
// words[i] consists only of lowercase English letters.
//
// Related Topics Array Two Pointers String 👍 108 👎 7
/*
 O(n*m) Runtime: 1 ms, faster than 99.88% of Java online submissions for Find First Palindromic String in the Array.
 O(1) Memory Usage: 38.8 MB, less than 97.65% of Java online submissions for Find First Palindromic String in the Array.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class FindFirstPalindromicStringInTheArray_2108 {
  public String firstPalindrome(String[] words) {
    for (String word : words) {
      if (isPalindrome(word)) {
        return word;
      }
    }

    return "";
  }

  private boolean isPalindrome(String s) {
    int left = 0;
    int right = s.length() - 1;

    while (left <= right) {
      if (s.charAt(left) == s.charAt(right)) {
        left++;
        right--;
      } else {
        return false;
      }
    }

    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
