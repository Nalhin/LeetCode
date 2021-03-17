package com.leetcode.strings.medium;

// Given two equal-size strings s and t. In one step you can choose any character
// of t and replace it with another character.
//
// Return the minimum number of steps to make t an anagram of s.
//
// An Anagram of a string is a string that contains the same characters with a d
// ifferent (or the same) ordering.
//
//
// Example 1:
//
//
// Input: s = "bab", t = "aba"
// Output: 1
// Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of
// s.
//
//
// Example 2:
//
//
// Input: s = "leetcode", t = "practice"
// Output: 5
// Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters
// to make t anagram of s.
//
//
// Example 3:
//
//
// Input: s = "anagram", t = "mangaar"
// Output: 0
// Explanation: "anagram" and "mangaar" are anagrams.
//
//
// Example 4:
//
//
// Input: s = "xxyyzz", t = "xxyyzz"
// Output: 0
//
//
// Example 5:
//
//
// Input: s = "friend", t = "family"
// Output: 4
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 50000
// s.length == t.length
// s and t contain lower-case English letters only.
//
// Related Topics String
// 👍 524 👎 35
/*
 O(n) Runtime: 14 ms, faster than 55.03% of Java online submissions for Minimum Number of Steps to Make Two Strings Anagram.
 O(1) Memory Usage: 39.1 MB, less than 96.74% of Java online submissions for Minimum Number of Steps to Make Two Strings Anagram.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class MinimumNumberOfStepsToMakeTwoStringsAnagram_1347 {
  public int minSteps(String str1, String str2) {

    int[] charsStr1 = countCharacters(str1);
    int[] charsStr2 = countCharacters(str2);

    int result = 0;

    for (int i = 0; i < charsStr1.length; i++) {
      result += Math.abs(charsStr1[i] - charsStr2[i]);
    }

    return result / 2;
  }

  private int[] countCharacters(String str) {
    int[] chars = new int[26];

    for (int i = 0; i < str.length(); i++) {
      chars[str.charAt(i) - 'a']++;
    }

    return chars;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
