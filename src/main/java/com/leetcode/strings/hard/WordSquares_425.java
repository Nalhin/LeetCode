package com.leetcode.strings.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/*
 O(N * M + 26^M) Runtime: 26 ms, faster than 92.92% of Java online submissions for Word Squares.
 O(N * M) Memory Usage: 63.1 MB, less than 16.96% of Java online submissions for Word Squares.
*/

public class WordSquares_425 {

  private static class TrieNode {
    private final TrieNode[] children = new TrieNode[26];
    private final List<String> words = new ArrayList<>();
  }

  public List<List<String>> wordSquares(String[] words) {
    TrieNode trie = new TrieNode();
    for (String word : words) {
      TrieNode curr = trie;
      for (int i = 0; i < word.length(); i++) {
        int charHash = word.charAt(i) - 'a';
        if (curr.children[charHash] == null) {
          curr.children[charHash] = new TrieNode();
        }
        curr.words.add(word);
        curr = curr.children[charHash];
      }
    }

    List<List<String>> result = new ArrayList<>();
    backtrack(
        words[0].length(),
        IntStream.range(0, words[0].length()).mapToObj(ign -> trie).collect(Collectors.toList()),
        new ArrayList<>(),
        result);

    return result;
  }

  private void backtrack(
      int wordsLeft,
      List<TrieNode> remainingWordTries,
      List<String> currentCombination,
      List<List<String>> result) {
    if (wordsLeft <= 0) {
      result.add(new ArrayList<>(currentCombination));
      return;
    }

    for (String word : remainingWordTries.get(0).words) {
      int len = currentCombination.size();
      currentCombination.add(word);
      List<TrieNode> newWordTries = new ArrayList<>();
      for (int i = 1; i < wordsLeft; i++) {
        TrieNode child = remainingWordTries.get(i).children[word.charAt(i + len) - 'a'];
        if (child == null) {
          break;
        }
        newWordTries.add(child);
      }
      if (newWordTries.size() == wordsLeft - 1) {
        backtrack(wordsLeft - 1, newWordTries, currentCombination, result);
      }
      currentCombination.remove(currentCombination.size() - 1);
    }
  }
}
