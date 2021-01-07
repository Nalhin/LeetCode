package com.leetcode.strings.medium;

import java.util.*;
/*
 O(n * m) Runtime: 29 ms, faster than 57.05% of Java online submissions for Search Suggestions System.
 O(m) Memory Usage: 84.3 MB, less than 5.04% of Java online submissions for Search Suggestions System.
 where:
 n - num of words in products array
 m - length of search word
*/
public class SearchSuggestionsSystem_1268 {
  public List<List<String>> suggestedProducts(String[] products, String searchWord) {

    Trie trie = new Trie();

    for (String product : products) {
      Trie curr = trie;
      curr.addWord(product);
      for (int i = 0; i < Math.min(product.length(), searchWord.length()); i++) {
        curr = curr.getAndUpsertChild(product.charAt(i));
        curr.addWord(product);
      }
    }
    List<List<String>> result = new ArrayList<>();

    for (int i = 0; i < searchWord.length() && trie.getChild(searchWord.charAt(i)) != null; i++) {
      trie = trie.getChild(searchWord.charAt(i));
      result.add(trie.getSuggested());
    }

    for (int j = result.size(); j < searchWord.length(); j++) {
      result.add(Collections.emptyList());
    }
    return result;
  }

  private static class Trie {
    private final Trie[] children = new Trie[26];
    private final Queue<String> queue = new PriorityQueue<>(Comparator.reverseOrder());

    public void addWord(String word) {
      queue.add(word);
      if (queue.size() > 3) {
        queue.remove();
      }
    }

    public Trie getChild(char letter) {
      return children[letter - 'a'];
    }

    public Trie getAndUpsertChild(char letter) {
      if (children[letter - 'a'] == null) {
        children[letter - 'a'] = new Trie();
      }
      return children[letter - 'a'];
    }

    public List<String> getSuggested() {
      List<String> partialResult = new ArrayList<>();
      while (!queue.isEmpty()) {
        partialResult.add(queue.remove());
      }
      Collections.reverse(partialResult);
      return partialResult;
    }
  }
}
