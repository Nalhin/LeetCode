package com.leetcode.dp.medium;

// Given a list of words, each word consists of English lowercase letters.
//
// Let's say word1 is a predecessor of word2 if and only if we can add exactly o
// ne letter anywhere in word1 to make it equal to word2. For example, "abc" is a p
// redecessor of "abac".
//
// A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1
// , where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, an
// d so on.
//
// Return the longest possible length of a word chain with words chosen from the
// given list of words.
//
//
// Example 1:
//
//
// Input: words = ["a","b","ba","bca","bda","bdca"]
// Output: 4
// Explanation: One of the longest word chain is "a","ba","bda","bdca".
//
//
// Example 2:
//
//
// Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
// Output: 5
//
//
//
// Constraints:
//
//
// 1 <= words.length <= 1000
// 1 <= words[i].length <= 16
// words[i] only consists of English lowercase letters.
//
// Related Topics Hash Table Dynamic Programming
// 👍 1306 👎 89

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
/*
  O(n * m^2) Runtime: 40 ms, faster than 35.01% of Java online submissions for Longest String Chain.
  O(n)  Memory Usage: 39.7 MB, less than 15.34% of Java online submissions for Longest String Chain.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class LongestStringChain_1048 {
  public int longestStrChain(String[] words) {
    Arrays.sort(words, Comparator.comparingInt(String::length));
    Map<String, Integer> map = new HashMap<>();

    for (String word : words) {
      int maxVal = 0;
      for (int i = 0; i < word.length(); i++) {
        String subWord = word.substring(0, i) + word.substring(i + 1);
        maxVal = Math.max(map.getOrDefault(subWord, 0), maxVal);
      }
      map.put(word, maxVal + 1);
    }

    return map.values().stream().mapToInt(i -> i).max().orElse(0);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
