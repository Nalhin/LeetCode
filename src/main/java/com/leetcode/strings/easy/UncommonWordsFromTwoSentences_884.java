package com.leetcode.strings.easy;

// We are given two sentences A and B. (A sentence is a string of space separated
// words. Each word consists only of lowercase letters.)
//
// A word is uncommon if it appears exactly once in one of the sentences, and do
// es not appear in the other sentence.
//
// Return a list of all uncommon words.
//
// You may return the list in any order.
//
//
//
//
//
//
//
// Example 1:
//
//
// Input: A = "this apple is sweet", B = "this apple is sour"
// Output: ["sweet","sour"]
//
//
//
// Example 2:
//
//
// Input: A = "apple apple", B = "banana"
// Output: ["banana"]
//
//
//
//
// Note:
//
//
// 0 <= A.length <= 200
// 0 <= B.length <= 200
// A and B both contain only spaces and lowercase letters.
//
//
//
// Related Topics Hash Table
// 👍 507 👎 93

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
/*
  O(n + m) Runtime: 4 ms, faster than 33.63% of Java online submissions for Uncommon Words from Two Sentences.
  O(n + m) Memory Usage: 39.6 MB, less than 13.66% of Java online submissions for Uncommon Words from Two Sentences.
*/
public class UncommonWordsFromTwoSentences_884 {
  public String[] uncommonFromSentences(String A, String B) {
    String[] wordsA = A.split(" ");
    String[] wordsB = B.split(" ");

    Map<String, Integer> visited = new HashMap<>();

    for (String word : wordsA) {
      visited.put(word, visited.getOrDefault(word, 0) + 1);
    }
    for (String word : wordsB) {
      visited.put(word, visited.getOrDefault(word, 0) + 1);
    }

    return visited.entrySet().stream()
        .filter(i -> i.getValue() == 1)
        .map(Map.Entry::getKey)
        .toArray(String[]::new);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
