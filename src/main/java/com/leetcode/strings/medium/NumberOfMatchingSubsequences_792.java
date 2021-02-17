package com.leetcode.strings.medium;

// Given string S and a dictionary of words words, find the number of words[i] th
// at is a subsequence of S.
//
//
// Example :
// Input:
// S = "abcde"
// words = ["a", "bb", "acd", "ace"]
// Output: 3
// Explanation: There are three words in words that are a subsequence of S: "a",
// "acd", "ace".
//
//
// Note:
//
//
// All words in words and S will only consists of lowercase letters.
// The length of S will be in the range of [1, 50000].
// The length of words will be in the range of [1, 5000].
// The length of words[i] will be in the range of [1, 50].
//
// Related Topics Array
// 👍 1249 👎 89

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
/*
 O(n + m * k) Runtime: 169 ms, faster than 30.85% of Java online submissions for Number of Matching Subsequences.
 O(n) Memory Usage: 57.4 MB, less than 13.41% of Java online submissions for Number of Matching Subsequences.
*/
public class NumberOfMatchingSubsequences_792 {
  public int numMatchingSubseq(String str, String[] words) {
    int[][] nextLetters = new int[str.length()][26];

    int[] prevNextLetters = new int[26];
    Arrays.fill(prevNextLetters, -1);

    for (int i = nextLetters.length - 1; i >= 0; i--) {
      nextLetters[i] = prevNextLetters;
      int[] currNextLetters = new int[26];
      System.arraycopy(prevNextLetters, 0, currNextLetters, 0, prevNextLetters.length);
      currNextLetters[str.charAt(i) - 'a'] = i;
      prevNextLetters = currNextLetters;
    }

    int result = 0;
    for (String word : words) {
      System.out.println(word);

      int currIndex = prevNextLetters[word.charAt(0) - 'a'];
      int currWordIndex = 1;
      int gathered = currIndex != -1 ? 1 : 0;

      while (currWordIndex < word.length() && currIndex < str.length() && currIndex != -1) {
        currIndex = nextLetters[currIndex][word.charAt(currWordIndex) - 'a'];
        currWordIndex++;

        if (currIndex != -1) {
          gathered++;
        }
      }

      if (gathered >= word.length()) {
        result++;
      }
    }
    return result;
  }
}

// leetcode submit region end(Prohibit modification and deletion)
