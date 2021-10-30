package com.leetcode.strings.hard;

// Given a string s, consider all duplicated substrings: (contiguous) substrings
// of s that occur 2 or more times. The occurrences may overlap.
//
// Return any duplicated substring that has the longest possible length. If s
// does not have a duplicated substring, the answer is "".
//
//
// Example 1:
// Input: s = "banana"
// Output: "ana"
// Example 2:
// Input: s = "abcd"
// Output: ""
//
//
// Constraints:
//
//
// 2 <= s.length <= 3 * 10⁴
// s consists of lowercase English letters.
//
// Related Topics String Binary Search Sliding Window Rolling Hash Suffix Array
// Hash Function 👍 1313 👎 290
/*
 avg O(nlog(n)) Runtime: 317 ms, faster than 66.18% of Java online submissions for Longest Duplicate Substring.
 O(n) Memory Usage: 51.9 MB, less than 45.19% of Java online submissions for Longest Duplicate Substring.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class LongestDuplicateSubstring_1044 {
  private static final int MOD = 1_000_000_007;
  private static final int BASE = 26;

  public String longestDupSubstring(String s) {

    int[] result = null;

    int[] stringWithBase = s.chars().map(c -> c - 'a').toArray();

    int left = 1;
    int right = s.length();

    while (left <= right) {
      int mid = left + (right - left) / 2;
      int[] midResult = getSubstringWithLength(stringWithBase, mid);
      if (midResult == null) {
        right = mid - 1;
      } else {
        left = mid + 1;
        result = midResult;
      }
    }

    return result == null ? "" : s.substring(result[0], result[1]);
  }

  private int[] getSubstringWithLength(int[] stringWithBase, int substringLength) {

    Map<Long, ArrayList<Integer>> seen = new HashMap<>();

    long hash = 0;
    long pow = 1;

    for (int i = 0; i < substringLength; i++) {
      hash = (hash * BASE + stringWithBase[i]) % MOD;
      pow = (pow * BASE) % MOD;
    }

    seen.computeIfAbsent(hash, (e) -> new ArrayList<>()).add(0);

    for (int start = 1; start < stringWithBase.length - substringLength + 1; start++) {
      hash = (hash * BASE - (stringWithBase[start - 1] * pow) % MOD + MOD) % MOD;
      hash = (hash + stringWithBase[start + substringLength - 1]) % MOD;

      List<Integer> prev = seen.get(hash);
      if (prev != null) {
        for (Integer prevStart : prev) {
          if (subArrayEqual(
              stringWithBase,
              start,
              start + substringLength,
              prevStart,
              prevStart + substringLength)) {
            return new int[] {prevStart, prevStart + substringLength};
          }
        }
      }

      seen.computeIfAbsent(hash, (e) -> new ArrayList<>()).add(start);
    }

    return null;
  }

  private boolean subArrayEqual(int[] array, int start1, int end1, int start2, int end2) {

    if (end1 - start1 != end2 - start2) {
      return false;
    }

    for (int i = 0; i < end1 - start1; i++) {
      if (array[i + start1] != array[i + start2]) {
        return false;
      }
    }
    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
