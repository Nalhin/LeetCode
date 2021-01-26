package com.leetcode.strings.medium;

// You have a list of words and a pattern, and you want to know which words in wo
// rds matches the pattern.
//
// A word matches the pattern if there exists a permutation of letters p so that
// after replacing every letter x in the pattern with p(x), we get the desired wor
// d.
//
// (Recall that a permutation of letters is a bijection from letters to letters:
// every letter maps to another letter, and no two letters map to the same letter.
// )
//
// Return a list of the words in words that match the given pattern.
//
// You may return the answer in any order.
//
//
//
//
// Example 1:
//
//
// Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
// Output: ["mee","aqq"]
// Explanation: "mee" matches the pattern because there is a permutation {a -> m,
// b -> e, ...}.
// "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permut
// ation,
// since a and b map to the same letter.
//
//
//
// Note:
//
//
// 1 <= words.length <= 50
// 1 <= pattern.length = words[i].length <= 20
//
//
// Related Topics String
// 👍 871 👎 83

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
/*
 O(n*m) Runtime: 1 ms, faster than 94.99% of Java online submissions for Find and Replace Pattern.
 O(n) Memory Usage: 39.7 MB, less than 9.33% of Java online submissions for Find and Replace Pattern.
*/
public class FindAndReplacePattern_890 {
  public List<String> findAndReplacePattern(String[] words, String pattern) {
    List<String> result = new ArrayList<>();

    for (String word : words) {
      if (word.length() == pattern.length()) {
        char[] wordMap = new char[26];
        char[] patternMap = new char[26];
        result.add(word);

        for (int i = 0; i < word.length(); i++) {
          int c = word.charAt(i) - 'a';
          int p = pattern.charAt(i) - 'a';

          if ((wordMap[c] == Character.MIN_VALUE && patternMap[p] == Character.MIN_VALUE)
              || (wordMap[c] == pattern.charAt(i) && patternMap[p] == word.charAt(i))) {
            wordMap[c] = pattern.charAt(i);
            patternMap[p] = word.charAt(i);
          } else {
            result.remove(result.size() - 1);
            break;
          }
        }
      }
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
