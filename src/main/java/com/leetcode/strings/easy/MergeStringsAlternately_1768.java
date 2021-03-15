package com.leetcode.strings.easy;

// You are given two strings word1 and word2. Merge the strings by adding letters
// in alternating order, starting with word1. If a string is longer than the other
// , append the additional letters onto the end of the merged string.
//
// Return the merged string.
//
//
// Example 1:
//
//
// Input: word1 = "abc", word2 = "pqr"
// Output: "apbqcr"
// Explanation: The merged string will be merged as so:
// word1:  a   b   c
// word2:    p   q   r
// merged: a p b q c r
//
//
// Example 2:
//
//
// Input: word1 = "ab", word2 = "pqrs"
// Output: "apbqrs"
// Explanation: Notice that as word2 is longer, "rs" is appended to the end.
// word1:  a   b
// word2:    p   q   r   s
// merged: a p b q   r   s
//
//
// Example 3:
//
//
// Input: word1 = "abcd", word2 = "pq"
// Output: "apbqcd"
// Explanation: Notice that as word1 is longer, "cd" is appended to the end.
// word1:  a   b   c   d
// word2:    p   q
// merged: a p b q c   d
//
//
//
// Constraints:
//
//
// 1 <= word1.length, word2.length <= 100
// word1 and word2 consist of lowercase English letters.
// Related Topics String
// 👍 122 👎 2
/*
 O(n + m) Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Strings Alternately.
 O(1) Memory Usage: 37.4 MB, less than 40.00% of Java online submissions for Merge Strings Alternately.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class MergeStringsAlternately_1768 {
  public String mergeAlternately(String word1, String word2) {

    StringBuilder sb = new StringBuilder();
    int minLen = Math.min(word1.length(), word2.length());

    for (int i = 0; i < minLen; i++) {
      sb.append(word1.charAt(i)).append(word2.charAt(i));
    }

    return sb.append(
            word1.length() > word2.length() ? word1.substring(minLen) : word2.substring(minLen))
        .toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
