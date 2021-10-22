package com.leetcode.sort.medium;

// Given a string s, sort it in decreasing order based on the frequency of the
// characters. The frequency of a character is the number of times it appears in the
// string.
//
// Return the sorted string. If there are multiple answers, return any of them.
//
//
//
// Example 1:
//
//
// Input: s = "tree"
// Output: "eert"
// Explanation: 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid
// answer.
//
//
// Example 2:
//
//
// Input: s = "cccaaa"
// Output: "aaaccc"
// Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and
// "aaaccc" are valid answers.
// Note that "cacaca" is incorrect, as the same characters must be together.
//
//
// Example 3:
//
//
// Input: s = "Aabb"
// Output: "bbAa"
// Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 5 * 10⁵
// s consists of uppercase and lowercase English letters and digits.
//
// Related Topics Hash Table String Sorting Heap (Priority Queue) Bucket Sort
// Counting 👍 3146 👎 160
/*
 O(n + mlog(m)) Runtime: 31 ms, faster than 28.00% of Java online submissions for Sort Characters By Frequency.
 O(n)  Memory Usage: 45.4 MB, less than 39.95% of Java online submissions for Sort Characters By Frequency.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency_451 {
  public String frequencySort(String s) {
    Map<Character, Integer> count = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      count.merge(s.charAt(i), 1, Integer::sum);
    }

    List<Character> sortedIndices = new ArrayList<>(count.keySet());
    sortedIndices.sort((a, b) -> Integer.compare(count.get(b), count.get(a)));

    char[] result = new char[s.length()];
    int currIdx = 0;

    for (Character currChar : sortedIndices) {

      for (int i = count.get(currChar); i > 0; i--) {
        result[currIdx++] = currChar;
      }
    }

    return new String(result);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
