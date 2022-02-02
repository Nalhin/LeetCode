package com.leetcode.hashtable.medium;

// Given two strings s and p, return an array of all the start indices of p's
// anagrams in s. You may return the answer in any order.
//
// An Anagram is a word or phrase formed by rearranging the letters of a
// different word or phrase, typically using all the original letters exactly once.
//
//
// Example 1:
//
//
// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".
//
//
// Example 2:
//
//
// Input: s = "abab", p = "ab"
// Output: [0,1,2]
// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".
//
//
//
// Constraints:
//
//
// 1 <= s.length, p.length <= 3 * 10⁴
// s and p consist of lowercase English letters.
//
// Related Topics Hash Table String Sliding Window 👍 6669 👎 244
/*
 O(n) Runtime: 18 ms, faster than 55.21% of Java online submissions for Find All Anagrams in a String.
 O(m) Memory Usage: 43.4 MB, less than 55.07% of Java online submissions for Find All Anagrams in a String.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString_438 {
  public List<Integer> findAnagrams(String s, String p) {
    Map<Character, Integer> lettersCount = new HashMap<>();

    for (int i = 0; i < p.length(); i++) {
      lettersCount.merge(p.charAt(i), 1, Integer::sum);
    }

    int distinctLetters = lettersCount.size();
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < s.length(); i++) {

      char currChar = s.charAt(i);

      if (i - p.length() >= 0) {
        char prevChar = s.charAt(i - p.length());
        if (lettersCount.containsKey(prevChar)) {
          int newCount = lettersCount.merge(prevChar, 1, Integer::sum);

          if (newCount == 1) {
            distinctLetters++;
          }
        }
      }

      if (lettersCount.containsKey(currChar)) {
        int newCount = lettersCount.merge(currChar, -1, Integer::sum);

        if (newCount == 0) {
          distinctLetters--;
        }
      }

      if (distinctLetters == 0) {
        result.add(i - p.length() + 1);
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
