package com.leetcode.strings.easy;

// Given two strings a and b, find the length of the longest uncommon subsequence
// between them.
//
// A subsequence of a string s is a string that can be obtained after deleting a
// ny number of characters from s. For example, "abc" is a subsequence of "aebdc" b
// ecause you can delete the underlined characters in "aebdc" to get "abc". Other s
// ubsequences of "aebdc" include "aebdc", "aeb", and "" (empty string).
//
// An uncommon subsequence between two strings is a string that is a subsequence
// of one but not the other.
//
// Return the length of the longest uncommon subsequence between a and b. If the
// longest uncommon subsequence doesn't exist, return -1.
//
//
// Example 1:
//
//
// Input: a = "aba", b = "cdc"
// Output: 3
// Explanation: One longest uncommon subsequence is "aba" because "aba" is a subs
// equence of "aba" but not "cdc".
// Note that "cdc" is also a longest uncommon subsequence.
//
//
// Example 2:
//
//
// Input: a = "aaa", b = "bbb"
// Output: 3
// Explanation: The longest uncommon subsequences are "aaa" and "bbb".
//
//
// Example 3:
//
//
// Input: a = "aaa", b = "aaa"
// Output: -1
// Explanation: Every subsequence of string a is also a subsequence of string b.
// Similarly, every subsequence of string b is also a subsequence of string a.
//
//
//
// Constraints:
//
//
// 1 <= a.length, b.length <= 100
// a and b consist of lower-case English letters.
//
// Related Topics String Brainteaser
// 👍 358 👎 4514

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(1) Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest Uncommon Subsequence I.
 O(1) Memory Usage: 36.4 MB, less than 99.05% of Java online submissions for Longest Uncommon Subsequence I.
*/
public class LongestUncommonSubsequenceI_521 {
  public int findLUSlength(String a, String b) {
    if (a.equals(b)) {
      return -1;
    }
    return Math.max(a.length(), b.length());
  }
}
// leetcode submit region end(Prohibit modification and deletion)
