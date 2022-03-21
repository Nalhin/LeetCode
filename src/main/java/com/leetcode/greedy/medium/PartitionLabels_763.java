package com.leetcode.greedy.medium;

// You are given a string s. We want to partition the string into as many parts
// as possible so that each letter appears in at most one part.
//
// Note that the partition is done so that after concatenating all the parts in
// order, the resultant string should be s.
//
// Return a list of integers representing the size of these parts.
//
//
// Example 1:
//
//
// Input: s = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it
// splits s into less parts.
//
//
// Example 2:
//
//
// Input: s = "eccbbbbdec"
// Output: [10]
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 500
// s consists of lowercase English letters.
//
// Related Topics Hash Table Two Pointers String Greedy 👍 7301 👎 276
/*
 O(n + log(m)) Runtime: 6 ms, faster than 55.88% of Java online submissions for Partition Labels.
 O(m) Memory Usage: 42.5 MB, less than 56.11% of Java online submissions for Partition Labels.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels_763 {
  public List<Integer> partitionLabels(String s) {
    Map<Character, Integer> minIndices = new HashMap<>();
    Map<Character, Integer> maxIndices = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char curr = s.charAt(i);

      if (!minIndices.containsKey(curr)) {
        minIndices.put(curr, i);
      }
      maxIndices.put(curr, i);
    }

    List<MinMaxCharIdx> entries = new ArrayList<>();

    for (Character c : minIndices.keySet()) {
      entries.add(new MinMaxCharIdx(minIndices.get(c), maxIndices.get(c)));
    }

    entries.sort(
        (a, b) -> a.min == b.min ? Integer.compare(a.max, b.max) : Integer.compare(a.min, b.min));

    int largestEnd = 0;
    int smallestStart = 0;

    List<Integer> result = new ArrayList<>();

    for (MinMaxCharIdx minMax : entries) {

      if (minMax.min > largestEnd) {
        result.add(largestEnd - smallestStart + 1);
        smallestStart = minMax.min;
      }

      largestEnd = Math.max(minMax.max, largestEnd);
    }

    result.add(largestEnd - smallestStart + 1);

    return result;
  }

  private class MinMaxCharIdx {
    private final int min;
    private final int max;

    private MinMaxCharIdx(int min, int max) {
      this.min = min;
      this.max = max;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
