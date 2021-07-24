package com.leetcode.bfs.hard;

// A transformation sequence from word beginWord to word endWord using a dictiona
// ry wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
//
//
//
// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to
// be in wordList.
// sk == endWord
//
//
// Given two words, beginWord and endWord, and a dictionary wordList, return all
// the shortest transformation sequences from beginWord to endWord, or an empty li
// st if no such sequence exists. Each sequence should be returned as a list of the
// words [beginWord, s1, s2, ..., sk].
//
//
// Example 1:
//
//
// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot"
// ,"log","cog"]
// Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
// Explanation: There are 2 shortest transformation sequences:
// "hit" -> "hot" -> "dot" -> "dog" -> "cog"
// "hit" -> "hot" -> "lot" -> "log" -> "cog"
//
//
// Example 2:
//
//
// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot"
// ,"log"]
// Output: []
// Explanation: The endWord "cog" is not in wordList, therefore there is no valid
// transformation sequence.
//
//
//
// Constraints:
//
//
// 1 <= beginWord.length <= 5
// endWord.length == beginWord.length
// 1 <= wordList.length <= 1000
// wordList[i].length == beginWord.length
// beginWord, endWord, and wordList[i] consist of lowercase English letters.
// beginWord != endWord
// All the words in wordList are unique.
//
// Related Topics Hash Table String Backtracking Breadth-First Search
// 👍 2741 👎 304
/*
 O(n*m^2) Runtime: 33 ms, faster than 15.97% of Java online submissions for Word Ladder II.
 O(n^2) Memory Usage: 39.2 MB, less than 93.39% of Java online submissions for Word Ladder II.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class WordLadderII_126 {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> result = new ArrayList<>();
    Map<String, Integer> wordDepths = new HashMap<>();
    Map<String, Set<String>> predecessors = new HashMap<>();

    wordDepths.put(beginWord, 0);

    Queue<String> queue = new ArrayDeque<>();
    queue.add(beginWord);

    while (!queue.isEmpty()) {

      String currWord = queue.poll();
      if (currWord.equals(endWord)) {
        dfs(result, new ArrayList<>(), predecessors, beginWord, endWord);
        return result;
      }

      int depth = wordDepths.get(currWord) + 1;

      for (String newWord : wordList) {

        if (differByOneLetter(currWord, newWord)
            && depth <= wordDepths.getOrDefault(newWord, Integer.MAX_VALUE)) {
          queue.add(newWord);
          wordDepths.put(newWord, depth);
          predecessors.computeIfAbsent(currWord, (e) -> new HashSet<>()).add(newWord);
        }
      }
    }

    return result;
  }

  private void dfs(
      List<List<String>> result,
      List<String> worldList,
      Map<String, Set<String>> predecessors,
      String currWord,
      String endWord) {

    if (currWord.equals(endWord)) {
      worldList.add(currWord);
      result.add(new ArrayList<>(worldList));
      worldList.remove(worldList.size() - 1);
      return;
    }

    if (predecessors.containsKey(currWord)) {
      worldList.add(currWord);
      for (String predecessor : predecessors.get(currWord)) {
        dfs(result, worldList, predecessors, predecessor, endWord);
      }
      worldList.remove(worldList.size() - 1);
    }
  }

  private boolean differByOneLetter(String s1, String s2) {
    boolean equalLetters = true;

    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        if (!equalLetters) {
          return false;
        }
        equalLetters = false;
      }
    }

    return !equalLetters;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
