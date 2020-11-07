package com.leetcode.strings.easy;

// Given words first and second, consider occurrences in some text of the form "f
// irst second third", where second comes immediately after first, and third comes
// immediately after second.
//
// For each such occurrence, add "third" to the answer, and return the answer.
//
//
//
// Example 1:
//
//
// Input: text = "alice is a good girl she is a good student", first = "a", secon
// d = "good"
// Output: ["girl","student"]
//
//
//
// Example 2:
//
//
// Input: text = "we will we will rock you", first = "we", second = "will"
// Output: ["we","rock"]
//
//
//
//
// Note:
//
//
// 1 <= text.length <= 1000
// text consists of space separated words, where each word consists of lowercase
// English letters.
// 1 <= first.length, second.length <= 10
// first and second consist of lowercase English letters.
//
//
// Related Topics Hash Table
// 👍 177 👎 195

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Occurrences After Bigram.
 O(n) Memory Usage: 39.3 MB, less than 9.49% of Java online submissions for Occurrences After Bigram.
*/
public class OccurrencesAfterBigram_1078 {
  public String[] findOcurrences(String text, String first, String second) {
    String[] words = text.split(" ");
    List<String> result = new ArrayList<>();

    boolean firstMatched = false;
    boolean secondMatched = false;

    for (String word : words) {
      if (secondMatched) {
        result.add(word);
      }

      secondMatched = firstMatched && word.equals(second);
      firstMatched = word.equals(first);
    }
    return result.toArray(new String[0]);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
