package com.leetcode.strings.medium;

// Given an array of strings strs, return the length of the longest uncommon
// subsequence between them. If the longest uncommon subsequence does not exist,
// return -1.
//
// An uncommon subsequence between an array of strings is a string that is a
// subsequence of one string but not the others.
//
// A subsequence of a string s is a string that can be obtained after deleting
// any number of characters from s.
//
//
// For example, "abc" is a subsequence of "aebdc" because you can delete the
// underlined characters in "aebdc" to get "abc". Other subsequences of "aebdc"
// include "aebdc", "aeb", and "" (empty string).
//
//
//
// Example 1:
// Input: strs = ["aba","cdc","eae"]
// Output: 3
// Example 2:
// Input: strs = ["aaa","aaa","aa"]
// Output: -1
//
//
// Constraints:
//
//
// 1 <= strs.length <= 50
// 1 <= strs[i].length <= 10
// strs[i] consists of lowercase English letters.
//
// Related Topics Array Hash Table Two Pointers String Sorting 👍 254 👎 736
/*
 O(n^2 * m)Runtime: 1 ms, faster than 93.01% of Java online submissions for Longest Uncommon Subsequence II.
 O(1) Memory Usage: 36.6 MB, less than 51.08% of Java online submissions for Longest Uncommon Subsequence II.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class LongestUncommonSubsequence_522 {
  public int findLUSlength(String[] strs) {
    int result = -1;

    for (int i = 0; i < strs.length; i++) {
      boolean shouldConsider = true;

      for (int j = 0; j < strs.length; j++) {
        if (i == j) {
          continue;
        }

        if (isSubsequence(strs[i], strs[j])) {
          shouldConsider = false;
          break;
        }
      }

      if (shouldConsider) {
        result = Math.max(result, strs[i].length());
      }
    }

    return result;
  }

  private boolean isSubsequence(String first, String second) {
    if (first.length() > second.length()) {
      return false;
    }

    int firstIdx = 0;
    for (int secondIdx = 0; secondIdx < second.length() && firstIdx < first.length(); secondIdx++)
      if (first.charAt(firstIdx) == second.charAt(secondIdx)) {
        firstIdx++;
      }

    return firstIdx == first.length();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
