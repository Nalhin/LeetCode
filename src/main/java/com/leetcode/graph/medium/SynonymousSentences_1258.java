package com.leetcode.graph.medium;

// You are given a list of equivalent string pairs synonyms where synonyms[i] = [
// si, ti] indicates that si and ti are equivalent strings. You are also given a
// sentence text.
//
// Return all possible synonymous sentences sorted lexicographically.
//
//
// Example 1:
//
//
// Input: synonyms = [["happy","joy"],["sad","sorrow"],["joy","cheerful"]], text
// = "I am happy today but was sad yesterday"
// Output: ["I am cheerful today but was sad yesterday","I am cheerful today but
// was sorrow yesterday","I am happy today but was sad yesterday","I am happy
// today but was sorrow yesterday","I am joy today but was sad yesterday","I am joy
// today but was sorrow yesterday"]
//
//
// Example 2:
//
//
// Input: synonyms = [["happy","joy"],["cheerful","glad"]], text = "I am happy
// today but was sad yesterday"
// Output: ["I am happy today but was sad yesterday","I am joy today but was sad
// yesterday"]
//
//
//
// Constraints:
//
//
// 0 <= synonyms.length <= 10
// synonyms[i].length == 2
// 1 <= si.length, ti.length <= 10
// si != ti
// text consists of at most 10 words.
// The words of text are separated by single spaces.
//
// Related Topics Array Hash Table String Backtracking Union Find 👍 231 👎 91
/*
 O(n^m) Runtime: 5 ms, faster than 77.90% of Java online submissions for Synonymous Sentences.
 O(n*m) Memory Usage: 42.8 MB, less than 61.46% of Java online submissions for Synonymous Sentences.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class SynonymousSentences_1258 {
  public List<String> generateSentences(List<List<String>> synonyms, String text) {
    Map<String, Set<String>> wordGroupsUnique = new HashMap<>();

    Dsu dsu = new Dsu();

    for (List<String> synonym : synonyms) {
      dsu.connect(synonym.get(0), synonym.get(1));
    }

    Map<String, String> parents = new HashMap<>();

    for (List<String> synonym : synonyms) {
      String first = synonym.get(0);
      String second = synonym.get(1);

      String parent1 = dsu.parent(first);
      String parent2 = dsu.parent(second);

      wordGroupsUnique.computeIfAbsent(parent1, (ign) -> new TreeSet<>()).add(first);
      wordGroupsUnique.computeIfAbsent(parent2, (ign) -> new TreeSet<>()).add(second);
      parents.put(first, parent1);
      parents.put(second, parent2);
    }

    List<String> result = new ArrayList<>();

    backtrack(
        wordGroupsUnique, parents, 0, Arrays.asList(text.split(" ")), new StringBuilder(), result);

    return result;
  }

  private void backtrack(
      Map<String, Set<String>> wordGroups,
      Map<String, String> parents,
      int currWord,
      List<String> words,
      StringBuilder sb,
      List<String> result) {

    if (currWord >= words.size()) {
      result.add(sb.toString().trim());
      return;
    }

    String curr = words.get(currWord);

    String parent = parents.get(curr);

    if (wordGroups.containsKey(parent)) {

      for (String alt : wordGroups.get(parent)) {
        int len = sb.length();
        sb.append(alt);
        sb.append(" ");
        backtrack(wordGroups, parents, currWord + 1, words, sb, result);
        sb.setLength(len);
      }
    } else {
      int len = sb.length();
      sb.append(curr);
      sb.append(" ");
      backtrack(wordGroups, parents, currWord + 1, words, sb, result);
      sb.setLength(len);
    }
  }

  private static class Dsu {
    private final Map<String, Integer> ranks = new HashMap<>();
    private final Map<String, String> parents = new HashMap<>();

    public String parent(String node) {
      if (!parents.containsKey(node)) {
        return node;
      }
      String parent = parents.get(node);
      if (parent.equals(node)) {
        return parent;
      }
      String newParent = parent(parent);
      parents.put(node, newParent);
      return newParent;
    }

    public void connect(String node1, String node2) {
      String parent1 = parent(node1);
      String parent2 = parent(node2);

      if (parent1.equals(parent2)) {
        return;
      }

      int rank1 = ranks.getOrDefault(parent1, 0);
      int rank2 = ranks.getOrDefault(parent2, 0);

      if (rank1 > rank2) {
        parents.put(parent2, parent1);
      } else if (rank2 > rank1) {
        parents.put(parent1, parent2);
      } else {
        parents.put(parent1, parent2);
        ranks.merge(parent2, 1, Integer::sum);
      }
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
