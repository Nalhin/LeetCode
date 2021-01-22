package com.leetcode.strings.medium;

// Two strings are considered close if you can attain one from the other using th
// e following operations:
//
//
// Operation 1: Swap any two existing characters.
//
//
// For example, abcde -> aecdb
//
//
// Operation 2: Transform every occurrence of one existing character into anothe
// r existing character, and do the same with the other character.
//
// For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a
// 's)
//
//
//
//
// You can use the operations on either string as many times as necessary.
//
// Given two strings, word1 and word2, return true if word1 and word2 are close,
// and false otherwise.
//
//
// Example 1:
//
//
// Input: word1 = "abc", word2 = "bca"
// Output: true
// Explanation: You can attain word2 from word1 in 2 operations.
// Apply Operation 1: "abc" -> "acb"
// Apply Operation 1: "acb" -> "bca"
//
//
// Example 2:
//
//
// Input: word1 = "a", word2 = "aa"
// Output: false
// Explanation: It is impossible to attain word2 from word1, or vice versa, in an
// y number of operations.
//
//
// Example 3:
//
//
// Input: word1 = "cabbba", word2 = "abbccc"
// Output: true
// Explanation: You can attain word2 from word1 in 3 operations.
// Apply Operation 1: "cabbba" -> "caabbb"
// Apply Operation 2: "caabbb" -> "baaccc"
// Apply Operation 2: "baaccc" -> "abbccc"
//
//
// Example 4:
//
//
// Input: word1 = "cabbba", word2 = "aabbss"
// Output: false
// Explanation: It is impossible to attain word2 from word1, or vice versa, in an
// y amount of operations.
//
//
//
// Constraints:
//
//
// 1 <= word1.length, word2.length <= 105
// word1 and word2 contain only lowercase English letters.
//
// Related Topics Greedy
// 👍 239 👎 17

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/*
 O(n) Runtime: 21 ms, faster than 46.41% of Java online submissions for Determine if Two Strings Are Close.
 O(n) Memory Usage: 39.5 MB, less than 91.36% of Java online submissions for Determine if Two Strings Are Close.
*/
public class DetermineIfTwoStringsAreClose_1657 {
  public boolean closeStrings(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }

    int[] chars1 = new int[26];
    for (int i = 0; i < word1.length(); i++) {
      chars1[word1.charAt(i) - 'a']++;
    }

    int[] chars2 = new int[26];
    for (int i = 0; i < word2.length(); i++) {
      if (chars1[word2.charAt(i) - 'a'] == 0) {
        return false;
      }
      chars2[word2.charAt(i) - 'a']++;
    }

    Arrays.sort(chars1);
    Arrays.sort(chars2);
    return Arrays.equals(chars1, chars2);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
