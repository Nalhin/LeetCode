package com.leetcode.design.medium;

// Design a data structure that supports adding new words and finding if a string
// matches any previously added string.
//
// Implement the WordDictionary class:
//
//
// WordDictionary() Initializes the object.
// void addWord(word) Adds word to the data structure, it can be matched later.
//
// bool search(word) Returns true if there is any string in the data structure t
// hat matches word or false otherwise. word may contain dots '.' where dots can be
// matched with any letter.
//
//
//
// Example:
//
//
// Input
// ["WordDictionary","addWord","addWord","addWord","search","search","search","se
// arch"]
// [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
// Output
// [null,null,null,null,false,true,true,true]
//
// Explanation
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("bad");
// wordDictionary.addWord("dad");
// wordDictionary.addWord("mad");
// wordDictionary.search("pad"); // return False
// wordDictionary.search("bad"); // return True
// wordDictionary.search(".ad"); // return True
// wordDictionary.search("b.."); // return True
//
//
//
// Constraints:
//
//
// 1 <= word.length <= 500
// word in addWord consists lower-case English letters.
// word in search consist of '.' or lower-case English letters.
// At most 50000 calls will be made to addWord and search.
//
// Related Topics Backtracking Depth-first Search Design Trie
// 👍 2547 👎 117

// leetcode submit region begin(Prohibit modification and deletion)

/*
 * Your WordDictionary object will be instantiated and called as such: WordDictionary obj = new
 * WordDictionary(); obj.addWord(word); boolean param_2 = obj.search(word);
 */
/*
  O(m) Runtime: 36 ms, faster than 93.88% of Java online submissions for Design Add and Search Words Data Structure.
  O(m) Memory Usage: 50.2 MB, less than 24.99% of Java online submissions for Design Add and Search Words Data Structure.
 */
public class DesignAddAndSearchWordsDataStructure_211 {
  public static class WordDictionary {

    private final Trie head = new Trie();

    public void addWord(String word) {
      Trie curr = head;
      for (int i = 0; i < word.length(); i++) {
        char letter = word.charAt(i);
        if (curr.children[letter - 'a'] == null) {
          curr.children[letter - 'a'] = new Trie();
        }
        curr = curr.children[letter - 'a'];
      }
      curr.isEnd = true;
    }

    public boolean search(String word) {
      return searchDfs(word.toCharArray(), 0, head);
    }

    private boolean searchDfs(char[] word, int index, Trie trie) {
      if (trie == null) {
        return false;
      }
      if (index >= word.length) {
        return trie.isEnd;
      }
      char letter = word[index];
      if (letter == '.') {
        for (Trie child : trie.children) {
          boolean contains = searchDfs(word, index + 1, child);
          if (contains) {
            return true;
          }
        }
        return false;
      } else {
        return searchDfs(word, index + 1, trie.children[letter - 'a']);
      }
    }

    private static class Trie {
      Trie[] children = new Trie[26];
      boolean isEnd;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
