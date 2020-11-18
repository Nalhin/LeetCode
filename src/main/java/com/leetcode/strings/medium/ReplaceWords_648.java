package com.leetcode.strings.medium;

// In English, we have a concept called root, which can be followed by some other
// word to form another longer word - let's call this word successor. For example,
// when the root "an" is followed by the successor word "other", we can form a new
// word "another".
//
// Given a dictionary consisting of many roots and a sentence consisting of word
// s separated by spaces, replace all the successors in the sentence with the root
// forming it. If a successor can be replaced by more than one root, replace it wit
// h the root that has the shortest length.
//
// Return the sentence after the replacement.
//
//
// Example 1:
// Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled b
// y the battery"
// Output: "the cat was rat by the bat"
// Example 2:
// Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
// Output: "a a b c"
// Example 3:
// Input: dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa a
// aa aaa aaaaaa bbb baba ababa"
// Output: "a a a a a a a a bbb baba a"
// Example 4:
// Input: dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was ra
// ttled by the battery"
// Output: "the cat was rat by the bat"
// Example 5:
// Input: dictionary = ["ac","ab"], sentence = "it is abnormal that this solutio
// n is accepted"
// Output: "it is ab that this solution is ac"
//
//
// Constraints:
//
//
// 1 <= dictionary.length <= 1000
// 1 <= dictionary[i].length <= 100
// dictionary[i] consists of only lower-case letters.
// 1 <= sentence.length <= 10^6
// sentence consists of only lower-case letters and spaces.
// The number of words in sentence is in the range [1, 1000]
// The length of each word in sentence is in the range [1, 1000]
// Each two consecutive words in sentence will be separated by exactly one space
// .
// sentence does not have leading or trailing spaces.
//
// Related Topics Hash Table Trie
// 👍 844 👎 136

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;
/*
 O(m + n) Runtime: 8 ms, faster than 84.29% of Java online submissions for Replace Words.
 O(m + n) Memory Usage: 51.1 MB, less than 38.89% of Java online submissions for Replace Words.
*/
public class ReplaceWords_648 {
  public String replaceWords(List<String> dictionary, String sentence) {
    Trie trie = new Trie();
    for (String str : dictionary) {
      trie.add(str);
    }

    String[] words = sentence.split(" ");
    for (int i = 0; i < words.length; i++) {
      String prefix = trie.shortestPrefix(words[i]);
      if (prefix != null) {
        words[i] = prefix;
      }
    }

    return String.join(" ", words);
  }

  static class Trie {
    TrieNode head = new TrieNode();

    public void add(String word) {
      TrieNode curr = head;

      for (char c : word.toCharArray()) {
        if (curr.children[c - 'a'] == null) {
          curr.children[c - 'a'] = new TrieNode();
        }
        curr = curr.children[c - 'a'];
      }
      curr.isWord = true;
    }

    public String shortestPrefix(String word) {
      TrieNode curr = head;

      StringBuilder sb = new StringBuilder();

      for (char c : word.toCharArray()) {
        if (curr.children[c - 'a'] == null) {
          return curr.isWord ? sb.toString() : null;
        }
        sb.append(c);
        if (curr.children[c - 'a'].isWord) {
          return sb.toString();
        }
        curr = curr.children[c - 'a'];
      }
      return curr.isWord ? sb.toString() : null;
    }

    static class TrieNode {
      boolean isWord;
      TrieNode[] children = new TrieNode[26];
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
