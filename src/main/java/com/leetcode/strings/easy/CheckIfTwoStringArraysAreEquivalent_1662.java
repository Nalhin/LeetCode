package com.leetcode.strings.easy;

// Given two string arrays word1 and word2, return true if the two arrays represe
// nt the same string, and false otherwise.
//
// A string is represented by an array if the array elements concatenated in ord
// er forms the string.
//
//
// Example 1:
//
//
// Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
// Output: true
// Explanation:
// word1 represents string "ab" + "c" -> "abc"
// word2 represents string "a" + "bc" -> "abc"
// The strings are the same, so return true.
//
// Example 2:
//
//
// Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
// Output: false
//
//
// Example 3:
//
//
// Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
// Output: true
//
//
//
// Constraints:
//
//
// 1 <= word1.length, word2.length <= 103
// 1 <= word1[i].length, word2[i].length <= 103
// 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
// word1[i] and word2[i] consist of lowercase letters.
//
// Related Topics String
// 👍 65 👎 14

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 1 ms, faster than 66.83% of Java online submissions for Check If Two String Arrays are Equivalent.
 O(n) Memory Usage: 37.2 MB, less than 47.46% of Java online submissions for Check If Two String Arrays are Equivalent.
*/
public class CheckIfTwoStringArraysAreEquivalent_1662 {
  public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
    return String.join("", word1).equals(String.join("", word2));
  }
}
// leetcode submit region end(Prohibit modification and deletion)
