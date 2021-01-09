package com.leetcode.bfs.hard;

// Given two words beginWord and endWord, and a dictionary wordList, return the l
// ength of the shortest transformation sequence from beginWord to endWord, such th
// at:
//
//
// Only one letter can be changed at a time.
// Each transformed word must exist in the word list.
//
//
// Return 0 if there is no such transformation sequence.
//
//
// Example 1:
//
//
// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot"
// ,"log","cog"]
// Output: 5
// Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog
// " -> "cog", return its length 5.
//
//
// Example 2:
//
//
// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot"
// ,"log"]
// Output: 0
// Explanation: The endWord "cog" is not in wordList, therefore no possible trans
// formation.
//
//
//
// Constraints:
//
//
// 1 <= beginWord.length <= 100
// endWord.length == beginWord.length
// 1 <= wordList.length <= 5000
// wordList[i].length == beginWord.length
// beginWord, endWord, and wordList[i] consist of lowercase English letters.
// beginWord != endWord
// All the strings in wordList are unique.
//
// Related Topics Breadth-first Search
// 👍 4411 👎 1378

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n*m^2) Runtime: 643 ms, faster than 18.58% of Java online submissions for Word Ladder.
 O(n) Memory Usage: 39.1 MB, less than 98.71% of Java online submissions for Word Ladder.
*/
import java.util.*;

public class WordLadder_127 {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    int result = 0;
    Deque<String> deque = new ArrayDeque<>();
    Set<String> remaining = new HashSet<>(wordList);

    if (!remaining.contains(endWord)) {
      return 0;
    }

    deque.add(beginWord);

    while (!deque.isEmpty()) {
      int size = deque.size();

      for (int i = 0; i < size; i++) {
        String curr = deque.pop();
        if (curr.equals(endWord)) {
          return result + 1;
        }

        for (Iterator<String> it = remaining.iterator(); it.hasNext(); ) {
          String word = it.next();
          if (remaining.contains(word) && diffsByOne(word, curr)) {
            deque.add(word);
            it.remove();
          }
        }
      }
      result++;
    }
    return 0;
  }

  private boolean diffsByOne(String first, String second) {
    int diffs = 0;

    for (int i = 0; i < first.length(); i++) {
      if (first.charAt(i) != second.charAt(i)) {
        diffs++;
        if (diffs == 2) {
          return false;
        }
      }
    }

    return diffs == 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
