package com.leetcode.strings.easy;

// Given a text string and words (a list of strings), return all index pairs [i,
// j] so that the substring text[i]...text[j] is in the list of words.
//
//
//
// Example 1:
//
//
// Input: text = "thestoryofleetcodeandme", words = ["story","fleet","leetcode"]
// Output: [[3,7],[9,13],[10,17]]
//
//
// Example 2:
//
//
// Input: text = "ababa", words = ["aba","ab"]
// Output: [[0,1],[0,2],[2,3],[2,4]]
// Explanation:
// Notice that matches can overlap, see "aba" is found in [0,2] and [2,4].
//
//
//
//
// Note:
//
//
// All strings contains only lowercase English letters.
// It's guaranteed that all strings in words are different.
// 1 <= text.length <= 100
// 1 <= words.length <= 20
// 1 <= words[i].length <= 50
// Return the pairs [i,j] in sorted order (i.e. sort them by their first coordin
// ate in case of ties sort them by their second coordinate).
// Related Topics String Trie
// 👍 132 👎 55

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
/*
 O(n*n + m * k) Runtime: 1 ms, faster than 100.00% of Java online submissions for Index Pairs of a String.
 O(m * k) Memory Usage: 38.9 MB, less than 98.42% of Java online submissions for Index Pairs of a String.
 where:
 n - len of text
 m - num of words
 k - len of word
*/
public class IndexPairsOfAString_1065 {
  public int[][] indexPairs(String text, String[] words) {
    List<int[]> pairs = new ArrayList<>();

    Trie trie = new Trie();
    for (String word : words) {
      trie.add(word);
    }

    for (int i = 0; i < text.length(); i++) {
      pairs.addAll(trie.getContaining(text, i));
    }

    return pairs.toArray(new int[][] {});
  }

  private static class Trie {
    private final Trie[] children = new Trie[26];
    private boolean isEnd = false;

    public void add(String word) {
      Trie curr = this;

      for (int i = 0; i < word.length(); i++) {
        int idx = word.charAt(i) - 'a';
        if (curr.children[idx] == null) {
          curr.children[idx] = new Trie();
        }
        curr = curr.children[idx];
      }
      curr.isEnd = true;
    }

    public List<int[]> getContaining(String inWord, int startIdx) {
      Trie curr = this;
      List<int[]> result = new ArrayList<>();
      for (int i = startIdx; i < inWord.length() && curr != null; i++) {
        curr = curr.children[inWord.charAt(i) - 'a'];
        if (curr != null && curr.isEnd) {
          result.add(new int[] {startIdx, i});
        }
      }

      return result;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
