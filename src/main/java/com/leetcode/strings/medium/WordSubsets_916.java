package com.leetcode.strings.medium;

// We are given two arrays A and B of words. Each word is a string of lowercase l
// etters.
//
// Now, say that word b is a subset of word a if every letter in b occurs in a,
// including multiplicity. For example, "wrr" is a subset of "warrior", but is not
// a subset of "world".
//
// Now say a word a from A is universal if for every b in B, b is a subset of a.
//
//
// Return a list of all universal words in A. You can return the words in any or
// der.
//
//
//
//
//
//
//
// Example 1:
//
//
// Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
// Output: ["facebook","google","leetcode"]
//
//
//
// Example 2:
//
//
// Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
// Output: ["apple","google","leetcode"]
//
//
//
// Example 3:
//
//
// Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
// Output: ["facebook","google"]
//
//
//
// Example 4:
//
//
// Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
// Output: ["google","leetcode"]
//
//
//
// Example 5:
//
//
// Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","
// ceo"]
// Output: ["facebook","leetcode"]
//
//
//
//
// Note:
//
//
// 1 <= A.length, B.length <= 10000
// 1 <= A[i].length, B[i].length <= 10
// A[i] and B[i] consist only of lowercase letters.
// All words in A[i] are unique: there isn't i != j with A[i] == A[j].
//
//
//
//
//
//
// Related Topics String
// 👍 494 👎 89
/*
 O(n*m) Runtime: 20 ms, faster than 47.91% of Java online submissions for Word Subsets.
 O(n) Memory Usage: 47.5 MB, less than 34.29% of Java online submissions for Word Subsets.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;

public class WordSubsets_916 {
  public List<String> wordSubsets(String[] A, String[] B) {

    int[] bCharCounter = new int[26];
    List<String> result = new ArrayList<>();

    for (String second : B) {
      int[] counter = countLetters(second);

      for (int i = 0; i < bCharCounter.length; i++) {
        bCharCounter[i] = Math.max(bCharCounter[i], counter[i]);
      }
    }

    for (String first : A) {
      int[] firstCharCounter = countLetters(first);

      boolean add = true;

      for (int i = 0; i < bCharCounter.length; i++) {
        if (bCharCounter[i] > firstCharCounter[i]) {
          add = false;
          break;
        }
      }

      if (add) {
        result.add(first);
      }
    }

    return result;
  }

  private int[] countLetters(String str) {
    int[] counter = new int[26];
    for (int i = 0; i < str.length(); i++) {
      counter[str.charAt(i) - 'a']++;
    }
    return counter;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
