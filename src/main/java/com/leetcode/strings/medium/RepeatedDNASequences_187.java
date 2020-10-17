package com.leetcode.strings.medium;

// All DNA is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', a
// nd 'T', for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
// identify repeated sequences within the DNA.
//
// Write a function to find all the 10-letter-long sequences (substrings) that o
// ccur more than once in a DNA molecule.
//
//
// Example 1:
// Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
// Output: ["AAAAACCCCC","CCCCCAAAAA"]
// Example 2:
// Input: s = "AAAAAAAAAAAAA"
// Output: ["AAAAAAAAAA"]
//
//
// Constraints:
//
//
// 0 <= s.length <= 105
// s[i] is 'A', 'C', 'G', or 'T'.
//
// Related Topics Hash Table Bit Manipulation
// 👍 902 👎 308

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class RepeatedDNASequences_187 {
  public List<String> findRepeatedDnaSequences(String s) {
    Set<String> set = new HashSet<>();
    Set<String> result = new HashSet<>();
    int l = 10;
    if (s.length() < l) {
      return Collections.emptyList();
    }

    for (int i = 0; i < s.length() - l + 1; i++) {
      String str = s.substring(i, i + l);
      if (set.contains(str)) {
        result.add(str);
      }
      set.add(str);
    }
    return new ArrayList<>(result);
  }
}
/*
  O(n) Runtime: 17 ms, faster than 65.80% of Java online submissions for Repeated DNA Sequences.
  O(n) Memory Usage: 47.9 MB, less than 5.80% of Java online submissions for Repeated DNA Sequences.
 */
// leetcode submit region end(Prohibit modification and deletion)
