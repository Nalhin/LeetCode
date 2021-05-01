package com.leetcode.design.hard;

// Design a special dictionary which has some words and allows you to search the
// words in it by a prefix and a suffix.
//
// Implement the WordFilter class:
//
//
// WordFilter(string[] words) Initializes the object with the words in the dicti
// onary.
// f(string prefix, string suffix) Returns the index of the word in the dictiona
// ry which has the prefix prefix and the suffix suffix. If there is more than one
// valid index, return the largest of them. If there is no such word in the diction
// ary, return -1.
//
//
//
// Example 1:
//
//
// Input
// ["WordFilter", "f"]
// [[["apple"]], ["a", "e"]]
// Output
// [null, 0]
//
// Explanation
// WordFilter wordFilter = new WordFilter(["apple"]);
// wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix =
// "a" and suffix = 'e".
//
//
//
// Constraints:
//
//
// 1 <= words.length <= 15000
// 1 <= words[i].length <= 10
// 1 <= prefix.length, suffix.length <= 10
// words[i], prefix and suffix consist of lower-case English letters only.
// At most 15000 calls will be made to the function f.
//
// Related Topics Trie
// 👍 559 👎 252
/*
  encode - O(n), retrieve - O(Max(m, k))  Runtime: 335 ms, faster than 13.73% of Java online submissions for Prefix and Suffix Search.
  O(n) Memory Usage: 278.3 MB, less than 5.15% of Java online submissions for Prefix and Suffix Search.
  WHERE:
  n - len of word
  m - len of prefix
  k - len of suffix
 */
// leetcode submit region begin(Prohibit modification and deletion)

public class PrefixAndSuffixSearch_745 {

  static class WordFilter {

    private final Trie trie = new Trie();

    public WordFilter(String[] words) {
      for (int i = 0; i < words.length; i++) {
        String word = words[i];
        add(word, i);
      }
    }

    private void add(String word, int index) {

      Trie curr = trie;
      for (int i = 0; i < word.length(); i++) {
        int prefix = word.charAt(i) - 'a';
        int suffix = word.charAt(word.length() - i - 1) - 'a';

        if (curr.children[prefix][suffix] == null) {
          curr.children[prefix][suffix] = new Trie();
        }
        curr = curr.children[prefix][suffix];
        curr.largestIndex = index;
      }
    }

    public int f(String prefix, String suffix) {
      Trie curr = trie;
      suffix = new StringBuilder(suffix).reverse().toString();
      int minOfWords = Math.min(prefix.length(), suffix.length());
      for (int i = 0; i < minOfWords; i++) {
        curr = curr.children[prefix.charAt(i) - 'a'][suffix.charAt(i) - 'a'];
        if (curr == null) {
          return -1;
        }
      }

      String largest = prefix.length() > suffix.length() ? prefix : suffix;
      return visitDfs(curr, largest, minOfWords, prefix.length() > suffix.length());
    }

    private int visitDfs(Trie curr, String largest, int index, boolean isPrefix) {
      if (curr == null) {
        return -1;
      }

      if (largest.length() <= index) {
        return curr.largestIndex;
      }

      int max = -1;
      for (int i = 0; i < 26; i++) {
        Trie next =
            isPrefix
                ? curr.children[largest.charAt(index) - 'a'][i]
                : curr.children[i][largest.charAt(index) - 'a'];
        max = Math.max(max, visitDfs(next, largest, index + 1, isPrefix));
      }
      return max;
    }

    static class Trie {
      private Trie[][] children = new Trie[26][26];
      private int largestIndex = -1;
    }
  }
}
/*
 * Your WordFilter object will be instantiated and called as such: WordFilter obj = new
 * WordFilter(words); int param_1 = obj.f(prefix,suffix);
 */
// leetcode submit region end(Prohibit modification and deletion)
