package com.leetcode.bitmanipulation.medium;

// Given a string array words, return the maximum value of length(word[i]) * leng
// th(word[j]) where the two words do not share common letters. If no such two word
// s exist, return 0.
//
//
// Example 1:
//
//
// Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
// Output: 16
// Explanation: The two words can be "abcw", "xtfn".
//
//
// Example 2:
//
//
// Input: words = ["a","ab","abc","d","cd","bcd","abcd"]
// Output: 4
// Explanation: The two words can be "ab", "cd".
//
//
// Example 3:
//
//
// Input: words = ["a","aa","aaa","aaaa"]
// Output: 0
// Explanation: No such pair of words.
//
//
//
// Constraints:
//
//
// 2 <= words.length <= 1000
// 1 <= words[i].length <= 1000
// words[i] consists only of lowercase English letters.
//
// Related Topics Bit Manipulation
// 👍 1240 👎 84
/*
 O(n*m + n^2) Runtime: 8 ms, faster than 60.20% of Java online submissions for Maximum Product of Word Lengths.
 O(n) Memory Usage: 39.2 MB, less than 33.06% of Java online submissions for Maximum Product of Word Lengths.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class MaximumProductOfWordLength_318 {
  public int maxProduct(String[] words) {
    int[] wordsAsBinary = new int[words.length];

    for (int i = 0; i < words.length; i++) {
      wordsAsBinary[i] = encodeWord(words[i]);
    }

    int result = 0;

    for (int i = 0; i < wordsAsBinary.length; i++) {
      for (int j = i; j < wordsAsBinary.length; j++) {
        if (containsUniqueLetters(wordsAsBinary[i], wordsAsBinary[j])) {
          result = Math.max(words[i].length() * words[j].length(), result);
        }
      }
    }

    return result;
  }

  private int encodeWord(String word) {
    int result = 0;
    for (int j = 0; j < word.length(); j++) {
      result |= 1 << (word.charAt(j) - 'a');
    }
    return result;
  }

  private boolean containsUniqueLetters(int encodedWord1, int encodedWord2) {
    return (encodedWord1 & encodedWord2) == 0;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
