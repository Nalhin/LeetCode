package com.leetcode.strings.hard;

// Given a list of unique words, return all the pairs of the distinct indices (i,
// j) in the given list, so that the concatenation of the two words words[i] + wor
// ds[j] is a palindrome.
//
//
// Example 1:
//
//
// Input: words = ["abcd","dcba","lls","s","sssll"]
// Output: [[0,1],[1,0],[3,2],[2,4]]
// Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
//
//
// Example 2:
//
//
// Input: words = ["bat","tab","cat"]
// Output: [[0,1],[1,0]]
// Explanation: The palindromes are ["battab","tabbat"]
//
//
// Example 3:
//
//
// Input: words = ["a",""]
// Output: [[0,1],[1,0]]
//
//
//
// Constraints:
//
//
// 1 <= words.length <= 5000
// 0 <= words[i].length <= 300
// words[i] consists of lower-case English letters.
//
// Related Topics Hash Table String Trie
// 👍 2028 👎 189
/*
 O(n * m^2) Runtime: 51 ms, faster than 73.97% of Java online submissions for Palindrome Pairs.
 O((n + m)^2) Memory Usage: 40.8 MB, less than 86.62% of Java online submissions for Palindrome Pairs.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class PalindromePairs_336 {

  public List<List<Integer>> palindromePairs(String[] words) {
    Map<String, Integer> wordMap = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      wordMap.put(words[i], i);
    }

    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      String reversedWord = new StringBuilder(word).reverse().toString();

      if (wordMap.containsKey(reversedWord) && wordMap.get(reversedWord) != i) {
        result.add(List.of(i, wordMap.get(reversedWord)));
      }

      for (String suffix : buildValidSuffixes(word)) {
        String reversedSuffix = new StringBuilder(suffix).reverse().toString();
        if (wordMap.containsKey(reversedSuffix)) {
          result.add(List.of(wordMap.get(reversedSuffix), i));
        }
      }

      for (String prefix : buildValidPrefixes(word)) {
        String reversedPrefix = new StringBuilder(prefix).reverse().toString();
        if (wordMap.containsKey(reversedPrefix)) {
          result.add(List.of(i, wordMap.get(reversedPrefix)));
        }
      }
    }

    return result;
  }

  private List<String> buildValidPrefixes(String word) {
    List<String> validPrefixes = new ArrayList<>();
    for (int i = 0; i < word.length(); i++) {
      if (isPalindrome(word, i, word.length() - 1)) {
        validPrefixes.add(word.substring(0, i));
      }
    }
    return validPrefixes;
  }

  private List<String> buildValidSuffixes(String word) {
    List<String> validSuffixes = new ArrayList<>();
    for (int i = 0; i < word.length(); i++) {
      if (isPalindrome(word, 0, i)) {
        validSuffixes.add(word.substring(i + 1));
      }
    }
    return validSuffixes;
  }

  private boolean isPalindrome(String word, int start, int end) {
    while (start < end) {
      if (word.charAt(start) != word.charAt(end)) {
        return false;
      }
      start++;
      end--;
    }
    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
