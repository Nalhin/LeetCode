package com.leetcode.strings.medium;

// Given a wordlist, we want to implement a spellchecker that converts a query wo
// rd into a correct word.
//
// For a given query word, the spell checker handles two categories of spelling
// mistakes:
//
//
// Capitalization: If the query matches a word in the wordlist (case-insensitive
// ), then the query word is returned with the same case as the case in the wordlis
// t.
//
//
// Example: wordlist = ["yellow"], query = "YellOw": correct = "yellow"
// Example: wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
// Example: wordlist = ["yellow"], query = "yellow": correct = "yellow"
//
//
// Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the
// query word with any vowel individually, it matches a word in the wordlist (case-
// insensitive), then the query word is returned with the same case as the match in
// the wordlist.
//
// Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
// Example: wordlist = ["YellOw"], query = "yeellow": correct = "" (no match)
// Example: wordlist = ["YellOw"], query = "yllw": correct = "" (no match)
//
//
//
//
// In addition, the spell checker operates under the following precedence rules:
//
//
//
// When the query exactly matches a word in the wordlist (case-sensitive), you s
// hould return the same word back.
// When the query matches a word up to capitlization, you should return the firs
// t such match in the wordlist.
// When the query matches a word up to vowel errors, you should return the first
// such match in the wordlist.
// If the query has no matches in the wordlist, you should return the empty stri
// ng.
//
//
// Given some queries, return a list of words answer, where answer[i] is the cor
// rect word for query = queries[i].
//
//
//
// Example 1:
//
//
// Input: wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiT
// e","Hare","HARE","Hear","hear","keti","keet","keto"]
// Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
//
//
//
// Note:
//
//
// 1 <= wordlist.length <= 5000
// 1 <= queries.length <= 5000
// 1 <= wordlist[i].length <= 7
// 1 <= queries[i].length <= 7
// All strings in wordlist and queries consist only of english letters.
//
// Related Topics Hash Table String
// 👍 222 👎 440
/*
 O(n + m)Runtime: 23 ms, faster than 61.58% of Java online submissions for Vowel Spellchecker.
 O(n) Memory Usage: 43.2 MB, less than 69.95% of Java online submissions for Vowel Spellchecker.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class VowelSpellchecker_966 {
  private final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

  public String[] spellchecker(String[] wordlist, String[] queries) {
    Set<String> exactMatch = new HashSet<>();
    Map<String, String> caseInsensitive = new HashMap<>();
    Map<String, String> changedVowels = new HashMap<>();

    for (int i = wordlist.length - 1; i >= 0; i--) {
      String word = wordlist[i];

      exactMatch.add(word);

      String lowerQuery = word.toLowerCase();
      caseInsensitive.put(lowerQuery, word);

      String lowerQueryWithoutVowels = removeVowels(lowerQuery);
      changedVowels.put(lowerQueryWithoutVowels, word);
    }

    return Arrays.stream(queries)
        .map(query -> getMatch(query, exactMatch, caseInsensitive, changedVowels))
        .toArray(String[]::new);
  }

  private String removeVowels(String str) {
    StringBuilder ans = new StringBuilder();
    for (char c : str.toCharArray()) {
      ans.append(vowels.contains(c) ? '*' : c);
    }
    return ans.toString();
  }

  private String getMatch(
      String query,
      Set<String> exactMatch,
      Map<String, String> caseInsensitive,
      Map<String, String> changedVowels) {

    if (exactMatch.contains(query)) {
      return query;
    }

    String lowerQuery = query.toLowerCase();
    if (caseInsensitive.containsKey(lowerQuery)) {
      return caseInsensitive.get(lowerQuery);
    }

    String lowerQueryWithoutVowels = removeVowels(lowerQuery);
    if (changedVowels.containsKey(lowerQueryWithoutVowels)) {
      return changedVowels.get(lowerQueryWithoutVowels);
    }

    return "";
  }
}
// leetcode submit region end(Prohibit modification and deletion)
