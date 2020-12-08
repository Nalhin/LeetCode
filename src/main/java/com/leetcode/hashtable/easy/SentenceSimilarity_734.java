package com.leetcode.hashtable.easy;

// We can represent a sentence as an array of words, for example, the sentence "I
// am happy with leetcode" can be represented as arr = ["I","am",happy","with","le
// etcode"].
//
// Given two sentences sentence1 and sentence2 each represented as a string arra
// y and given an array of string pairs similarPairs where similarPairs[i] = [xi, y
// i] indicates that the two words xi and yi are similar.
//
// Return true if sentence1 and sentence2 are similar, or false if they are not
// similar.
//
// Two sentences are similar if:
//
//
// They have the same length (i.e. the same number of words)
// sentence1[i] and sentence2[i] are similar.
//
//
// Notice that a word is always similar to itself, also notice that the similari
// ty relation is not transitive. For example, if the words a and b are similar and
// the words b and c are similar, a and c are not necessarily similar.
//
//
// Example 1:
//
//
// Input: sentence1 = ["great","acting","skills"], sentence2 = ["fine","drama","t
// alent"], similarPairs = [["great","fine"],["drama","acting"],["skills","talent"]
// ]
// Output: true
// Explanation: The two sentences have the same length and each word i of sentenc
// e1 is also similar to the corresponding word in sentence2.
//
//
// Example 2:
//
//
// Input: sentence1 = ["great"], sentence2 = ["great"], similarPairs = []
// Output: true
// Explanation: A word is similar to itself.
//
//
// Example 3:
//
//
// Input: sentence1 = ["great"], sentence2 = ["doubleplus","good"], similarPairs
// = [["great","doubleplus"]]
// Output: false
// Explanation: As they don't have the same length, we return false.
//
//
//
// Constraints:
//
//
// 1 <= sentence1.length, sentence2.length <= 1000
// 1 <= sentence1[i].length, sentence2[i].length <= 20
// sentence1[i] and sentence2[i] consist of lower-case and upper-case English le
// tters.
// 0 <= similarPairs.length <= 1000
// similarPairs[i].length == 2
// 1 <= xi.length, yi.length <= 20
// xi and yi consist of lower-case and upper-case English letters.
// All the pairs (xi, yi) are distinct.
//
// Related Topics Hash Table
// 👍 200 👎 336

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;
/*
  O(n)  Runtime: 1 ms, faster than 99.77% of Java online submissions for Sentence Similarity.
  O(m)  Memory Usage: 38.8 MB, less than 49.65% of Java online submissions for Sentence Similarity.
*/
public class SentenceSimilarity_734 {
  public boolean areSentencesSimilar(
      String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
    if (sentence1.length != sentence2.length) {
      return false;
    }

    Map<String, Set<String>> map = new HashMap<>();

    for (List<String> pair : similarPairs) {
      Set<String> set = map.getOrDefault(pair.get(0), new HashSet<>());
      set.add(pair.get(1));
      map.put(pair.get(0), set);
    }

    for (int i = 0; i < sentence1.length; i++) {
      String first = sentence1[i];
      String second = sentence2[i];
      Set<String> firstSimilarSet = map.getOrDefault(first, Collections.emptySet());
      Set<String> secondSimilarSet = map.getOrDefault(second, Collections.emptySet());

      if (!first.equals(second)
          && (!firstSimilarSet.contains(second) && !secondSimilarSet.contains(first))) {
        return false;
      }
    }
    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
