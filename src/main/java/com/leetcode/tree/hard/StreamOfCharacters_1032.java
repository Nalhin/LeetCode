package com.leetcode.tree.hard;

// Design an algorithm that accepts a stream of characters and checks if a
// suffix of these characters is a string of a given array of strings words.
//
// For example, if words = ["abc", "xyz"] and the stream added the four
// characters (one by one) 'a', 'x', 'y', and 'z', your algorithm should detect that the
// suffix "xyz" of the characters "axyz" matches "xyz" from words.
//
// Implement the StreamChecker class:
//
//
// StreamChecker(String[] words) Initializes the object with the strings array
// words.
// boolean query(char letter) Accepts a new character from the stream and
// returns true if any non-empty suffix from the stream forms a word that is in words.
//
//
//
// Example 1:
//
//
// Input
// ["StreamChecker", "query", "query", "query", "query", "query", "query",
// "query", "query", "query", "query", "query", "query"]
// [[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"],
// ["i"], ["j"], ["k"], ["l"]]
// Output
// [null, false, false, false, true, false, true, false, false, false, false,
// false, true]
//
// Explanation
// StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
// streamChecker.query("a"); // return False
// streamChecker.query("b"); // return False
// streamChecker.query("c"); // return False
// streamChecker.query("d"); // return True, because 'cd' is in the wordlist
// streamChecker.query("e"); // return False
// streamChecker.query("f"); // return True, because 'f' is in the wordlist
// streamChecker.query("g"); // return False
// streamChecker.query("h"); // return False
// streamChecker.query("i"); // return False
// streamChecker.query("j"); // return False
// streamChecker.query("k"); // return False
// streamChecker.query("l"); // return True, because 'kl' is in the wordlist
//
//
//
// Constraints:
//
//
// 1 <= words.length <= 2000
// 1 <= words[i].length <= 2000
// words[i] consists of lowercase English letters.
// letter is a lowercase English letter.
// At most 4 * 10⁴ calls will be made to query.
//
// Related Topics Array String Design Trie Data Stream 👍 1119 👎 144

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// leetcode submit region begin(Prohibit modification and deletion)
public class StreamOfCharacters_1032 {

  /*
   O(n*m) Runtime: 527 ms, faster than 13.22% of Java online submissions for Stream of Characters.
   O(m) Memory Usage: 70.8 MB, less than 91.26% of Java online submissions for Stream of Characters.
  */
  static class PrefixList {

    static class StreamChecker {

      private final Trie trie;
      private List<Trie> prefixTries = new ArrayList<>();

      public StreamChecker(String[] words) {
        this.trie = new Trie();

        for (String word : words) {
          Trie curr = trie;
          for (int i = 0; i < word.length(); i++) {
            int hash = word.charAt(i) - 'a';
            if (curr.children[hash] == null) {
              curr.children[hash] = new Trie();
            }
            curr = curr.children[hash];
          }
          curr.isEnd = true;
        }
      }

      public boolean query(char letter) {

        prefixTries.add(trie);
        List<Trie> newStream = new ArrayList<>();

        boolean result = false;

        for (Trie trie : prefixTries) {
          int hash = letter - 'a';
          if (trie.children[hash] != null) {
            Trie curr = trie.children[hash];
            result |= curr.isEnd;
            newStream.add(curr);
          }
        }

        prefixTries = newStream;
        return result;
      }

      private static class Trie {
        private final Trie[] children = new Trie[26];
        private boolean isEnd = false;
      }
    }
  }
  /*
   O(n*m) Runtime: 86 ms, faster than 74.27% of Java online submissions for Stream of Characters.
   O(m) Memory Usage: 70.1 MB, less than 92.60% of Java online submissions for Stream of Characters.
  */
  static class Reversed {

    static class StreamChecker {

      private final Trie trie;
      private final Deque<Character> stream = new ArrayDeque<>();
      private final int maxWordSize;

      public StreamChecker(String[] words) {
        this.trie = new Trie();

        int maxSize = 0;

        for (String word : words) {
          maxSize = Math.max(maxSize, word.length());
          Trie curr = trie;
          for (int i = word.length() - 1; i >= 0; i--) {
            int hash = word.charAt(i) - 'a';
            if (curr.children[hash] == null) {
              curr.children[hash] = new Trie();
            }
            curr = curr.children[hash];
          }
          curr.isEnd = true;
        }
        maxWordSize = maxSize;
      }

      public boolean query(char letter) {

        if (stream.size() > maxWordSize) {
          stream.removeLast();
        }

        stream.addFirst(letter);

        Trie curr = trie;

        for (char c : stream) {
          int hash = c - 'a';
          if (curr.children[hash] == null) {
            return false;
          }

          curr = curr.children[hash];
          if (curr.isEnd) {
            return true;
          }
        }
        return false;
      }

      private static class Trie {
        private final Trie[] children = new Trie[26];
        private boolean isEnd = false;
      }
    }
  }
}

/*
 * Your StreamChecker object will be instantiated and called as such: StreamChecker obj = new
 * StreamChecker(words); boolean param_1 = obj.query(letter);
 */
// leetcode submit region end(Prohibit modification and deletion)
