package com.leetcode.design.medium;

// Implement a trie with insert, search, and startsWith methods.
//
// Example:
//
//
// Trie trie = new Trie();
//
// trie.insert("apple");
// trie.search("apple");   // returns true
// trie.search("app");     // returns false
// trie.startsWith("app"); // returns true
// trie.insert("app");
// trie.search("app");     // returns true
//
//
// Note:
//
//
// You may assume that all inputs are consist of lowercase letters a-z.
// All inputs are guaranteed to be non-empty strings.
//
// Related Topics Design Trie
// 👍 3890 👎 60

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(m) Runtime: 28 ms, faster than 99.59% of Java online submissions for Implement Trie (Prefix Tree).
 O(m) Memory Usage: 50.1 MB, less than 44.19% of Java online submissions for Implement Trie (Prefix Tree).
*/
public class ImplementTriePrefixTree_208 {
  static class Trie {

    private TrieNode head = new TrieNode();

    /** Inserts a word into the trie. */
    public void insert(String word) {

      TrieNode curr = head;
      for (char c : word.toCharArray()) {
        if (curr.children[c - 'a'] == null) {
          curr.children[c - 'a'] = new TrieNode();
        }
        curr = curr.children[c - 'a'];
      }
      curr.isWord = true;
    }

    private TrieNode searchTrie(String word) {
      TrieNode curr = head;
      for (char c : word.toCharArray()) {
        if (curr.children[c - 'a'] == null) {
          return null;
        }
        curr = curr.children[c - 'a'];
      }
      return curr;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
      TrieNode curr = searchTrie(word);
      return curr != null && curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
      TrieNode curr = searchTrie(prefix);
      return curr != null;
    }

    static class TrieNode {

      public boolean isWord;
      public TrieNode[] children = new TrieNode[26];
    }
  }
}
/*
 * Your Trie object will be instantiated and called as such: Trie obj = new Trie();
 * obj.insert(word); boolean param_2 = obj.search(word); boolean param_3 = obj.startsWith(prefix);
 */
// leetcode submit region end(Prohibit modification and deletion)
