package com.leetcode.strings.medium;

// A valid encoding of an array of words is any reference string s and array of i
// ndices indices such that:
//
//
// words.length == indices.length
// The reference string s ends with the '#' character.
// For each index indices[i], the substring of s starting from indices[i] and up
// to (but not including) the next '#' character is equal to words[i].
//
//
// Given an array of words, return the length of the shortest reference string s
// possible of any valid encoding of words.
//
//
// Example 1:
//
//
// Input: words = ["time", "me", "bell"]
// Output: 10
// Explanation: A valid encoding would be s = "time#bell#" and indices = [0, 2, 5
// ].
// words[0] = "time", the substring of s starting from indices[0] = 0 to the next
// '#' is underlined in "time#bell#"
// words[1] = "me", the substring of s starting from indices[1] = 2 to the next '
// #' is underlined in "time#bell#"
// words[2] = "bell", the substring of s starting from indices[2] = 5 to the next
// '#' is underlined in "time#bell#"
//
//
// Example 2:
//
//
// Input: words = ["t"]
// Output: 2
// Explanation: A valid encoding would be s = "t#" and indices = [0].
//
//
//
//
// Constraints:
//
//
// 1 <= words.length <= 2000
// 1 <= words[i].length <= 7
// words[i] consists of only lowercase letters.
//
// 👍 375 👎 105

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class ShortEncodingOfWords_820 {
  /*
   O(nlog(n) + n*m) Runtime: 284 ms, faster than 19.20% of Java online submissions for Short Encoding of Words.
   O(n) Memory Usage: 39 MB, less than 90.07% of Java online submissions for Short Encoding of Words.
  */
  static class Sort {
    public int minimumLengthEncoding(String[] words) {
      Set<Integer> redundant = new HashSet<>();
      int total = 0;
      Arrays.sort(words, (a, b) -> b.length() - a.length());

      for (int i = 0; i < words.length; i++) {
        String word = words[i];
        total += word.length();
        for (int j = i + 1; j < words.length; j++) {
          String nested = words[j];
          if (word.endsWith(nested)) {
            redundant.add(j);
          }
        }
      }

      for (Integer wordIdx : redundant) {
        total -= words[wordIdx].length();
      }

      return total + words.length - redundant.size();
    }
  }
  /*
    O(n*m) Runtime: 13 ms, faster than 67.55% of Java online submissions for Short Encoding of Words.
    O(m) Memory Usage: 45.8 MB, less than 45.03% of Java online submissions for Short Encoding of Words.
  */
  static class Trie {
    public int minimumLengthEncoding(String[] words) {
      TrieNode trie = new TrieNode();
      Map<TrieNode, Integer> endNodes = new HashMap<>();

      for (int i = 0; i < words.length; ++i) {
        String word = words[i];
        TrieNode curr = trie;
        for (int j = word.length() - 1; j >= 0; --j) {
          curr = curr.get(word.charAt(j));
        }
        endNodes.put(curr, i);
      }

      int result = 0;
      for (TrieNode node : endNodes.keySet()) {
        if (!node.isFilled()) {
          result += words[endNodes.get(node)].length() + 1;
        }
      }
      return result;
    }

    static final class TrieNode {
      private final TrieNode[] children = new TrieNode[26];
      private boolean filled = false;

      public TrieNode get(char c) {
        if (children[c - 'a'] == null) {
          children[c - 'a'] = new TrieNode();
          filled = true;
        }
        return children[c - 'a'];
      }

      public boolean isFilled() {
        return filled;
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
