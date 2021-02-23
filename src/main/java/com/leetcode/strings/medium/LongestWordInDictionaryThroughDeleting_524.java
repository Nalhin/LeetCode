package com.leetcode.strings.medium;

//
// Given a string and a string dictionary, find the longest string in the diction
// ary that can be formed by deleting some characters of the given string. If there
// are more than one possible results, return the longest word with the smallest l
// exicographical order. If there is no possible result, return the empty string.
//
// Example 1:
//
// Input:
// s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
// Output:
// "apple"
//
//
//
//
// Example 2:
//
// Input:
// s = "abpcplea", d = ["a","b","c"]
//
// Output:
// "a"
//
//
//
// Note:
//
// All the strings in the input will only contain lower-case letters.
// The size of the dictionary won't exceed 1,000.
// The length of all the strings in the input won't exceed 1,000.
//
// Related Topics Two Pointers Sort
// 👍 876 👎 284

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;
/*
  O(n * m) Runtime: 30 ms, faster than 18.00% of Java online submissions for Longest Word in Dictionary through Deleting.
  O(1) Memory Usage: 47.8 MB, less than 10.00% of Java online submissions for Longest Word in Dictionary through Deleting.
*/
public class LongestWordInDictionaryThroughDeleting_524 {
  public String findLongestWord(String s, List<String> d) {
    String longest = "";
    for (String word : d) {
      if (isSubsequence(s, word)) {
        if ((word.length() == longest.length() && word.compareTo(longest) < 0)
            || word.length() > longest.length()) {
          longest = word;
        }
      }
    }
    return longest;
  }

  private boolean isSubsequence(String sequence, String candidate) {
    int candidateIndex = 0;
    for (int i = 0; i < sequence.length(); i++) {
      if (sequence.charAt(i) == candidate.charAt(candidateIndex)) {
        candidateIndex++;
      }
    }
    return candidateIndex == candidate.length();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
