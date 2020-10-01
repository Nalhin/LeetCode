package com.leetcode.hashtable.medium;

// An abbreviation of a word follows the form <first letter><number><last letter>
// . Below are some examples of word abbreviations:
//
//
// a) it                      --> it    (no abbreviation)
//
//     1
//     ↓
// b) d|o|g                   --> d1g
//
//              1    1  1
//     1---5----0----5--8
//     ↓   ↓    ↓    ↓  ↓
// c) i|nternationalizatio|n  --> i18n
//
//              1
//     1---5----0
//      ↓   ↓    ↓
// d) l|ocalizatio|n          --> l10n
//
// Additionally for any string s of size less than or equal to 2 their abbreviati
// on is the same string s.
//
//
// Find whether its abbreviation is unique in the dictionary. A word's abbreviat
// ion is called unique if any of the following conditions is met:
//
//
// There is no word in dictionary such that their abbreviation is equal to the a
// bbreviation of word.
// Else, for all words in dictionary such that their abbreviation is equal to th
// e abbreviation of word those words are equal to word.
//
//
//
// Example 1:
//
//
// Input
// ["ValidWordAbbr", "isUnique", "isUnique", "isUnique", "isUnique"]
// [[["deer", "door", "cake", "card"]], ["dear"], ["cart"], ["cane"], ["make"]]
// Output
// [null, false, true, false, true]
//
// Explanation
// ValidWordAbbr validWordAbbr = new ValidWordAbbr(["deer", "door", "cake", "card
// "]);
// validWordAbbr.isUnique("dear"); // return False
// validWordAbbr.isUnique("cart"); // return True
// validWordAbbr.isUnique("cane"); // return False
// validWordAbbr.isUnique("make"); // return True
//
//
//
// Constraints:
//
//
// Each word will only consist of lowercase English characters.
//
// Related Topics Hash Table Design
// 👍 113 👎 1358

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UniqueWordAbbreviation_288 {
  static class ValidWordAbbr {
    private final Map<String, Set<String>> map;

    public ValidWordAbbr(String[] dictionary) {
      map =
          Stream.of(dictionary)
              .collect(Collectors.groupingBy(this::convertToAbbr, Collectors.toSet()));
    }

    private String convertToAbbr(String s) {
      if (s.length() <= 2) {
        return s;
      }
      return s.charAt(0) + String.valueOf(s.length() - 2) + s.charAt(s.length() - 1);
    }

    public boolean isUnique(String word) {
      String key = convertToAbbr(word);
      if(!map.containsKey(key)){
        return true;
      }
      Set<String> words = map.get(key);
      return words.size() == 1 && words.contains(word);
    }
  }
}
/*
    O(n) init O(1) search Runtime: 66 ms, faster than 55.02% of Java online submissions for Unique Word Abbreviation.
    O(n)                  Memory Usage: 49.7 MB, less than 44.65% of Java online submissions for Unique Word Abbreviation.
*/
/*
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
// leetcode submit region end(Prohibit modification and deletion)
