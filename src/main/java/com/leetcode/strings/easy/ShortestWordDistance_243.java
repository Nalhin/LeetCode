package com.leetcode.strings.easy;

// Given a list of words and two words word1 and word2, return the shortest dista
// nce between these two words in the list.
//
// Example:
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
//
//
// Input: word1 = “coding”, word2 = “practice”
// Output: 3
//
//
//
// Input: word1 = "makes", word2 = "coding"
// Output: 1
//
//
// Note:
// You may assume that word1 does not equal to word2, and word1 and word2 are bot
// h in the list.
// Related Topics Array
// 👍 548 👎 45

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 1 ms, faster than 99.77% of Java online submissions for Shortest Word Distance.
 O(1) Memory Usage: 39 MB, less than 71.16% of Java online submissions for Shortest Word Distance.
*/
public class ShortestWordDistance_243 {
  public int shortestDistance(String[] words, String word1, String word2) {
    int first = -1;
    int second = -1;
    int result = words.length;

    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(word1)) {
        first = i;
      } else if (words[i].equals(word2)) {
        second = i;
      }

      if (first != -1 && second != -1) {
        result = Math.min(result, Math.abs(first - second));
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
