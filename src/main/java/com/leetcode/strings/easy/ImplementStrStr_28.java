package com.leetcode.strings.easy;

// Implement strStr().
//
// Return the index of the first occurrence of needle in haystack, or -1 if need
// le is not part of haystack.
//
// Clarification:
//
// What should we return when needle is an empty string? This is a great questio
// n to ask during an interview.
//
// For the purpose of this problem, we will return 0 when needle is an empty str
// ing. This is consistent to C's strstr() and Java's indexOf().
//
//
// Example 1:
// Input: haystack = "hello", needle = "ll"
// Output: 2
// Example 2:
// Input: haystack = "aaaaa", needle = "bba"
// Output: -1
// Example 3:
// Input: haystack = "", needle = ""
// Output: 0
//
//
// Constraints:
//
//
// 0 <= haystack.length, needle.length <= 5 * 104
// haystack and needle consist of only lower-case English characters.
//
// Related Topics Two Pointers String
// 👍 1959 👎 2126

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O((n - m) n) Runtime: 1 ms, faster than 60.39% of Java online submissions for Implement strStr().
 O(1) Memory Usage: 37.6 MB, less than 69.06% of Java online submissions for Implement strStr().
 where:
 n - haystack len
 m - needle len
*/
public class ImplementStrStr_28 {
  public int strStr(String haystack, String needle) {
    int needleLen = needle.length();

    for (int i = 0; i < haystack.length() - needleLen + 1; i++) {
      int j = 0;
      while (j < needleLen && needle.charAt(j) == haystack.charAt(j + i)) {
        j++;
      }
      if (j == needleLen) {
        return i;
      }
    }
    return -1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
