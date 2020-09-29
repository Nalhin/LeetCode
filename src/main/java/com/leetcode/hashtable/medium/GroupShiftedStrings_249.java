package com.leetcode.hashtable.medium;

// Given a string, we can "shift" each of its letter to its successive letter, fo
// r example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
//
//
// "abc" -> "bcd" -> ... -> "xyz"
//
// Given a list of non-empty strings which contains only lowercase alphabets, gr
// oup all strings that belong to the same shifting sequence.
//
// Example:
//
//
// Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
// Output:
// [
//  ["abc","bcd","xyz"],
//  ["az","ba"],
//  ["acef"],
//  ["a","z"]
// ]
//
// Related Topics Hash Table String
// 👍 568 👎 102

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// leetcode submit region begin(Prohibit modification and deletion)
public class GroupShiftedStrings_249 {
  public List<List<String>> groupStrings(String[] strings) {
    Map<String, List<String>> map =
        Arrays.stream(strings).collect(Collectors.groupingBy(this::countShift));

    return new ArrayList<>(map.values());
  }

  private String countShift(String s) {
    char[] chars = new char[s.length()];

    for (int i = 0; i < s.length(); i++) {
      chars[i] = (char) ((s.charAt(0) - s.charAt(i) + 26) % 26);
    }
    return String.valueOf(chars);
  }
}
/*
 k - average string length
 n - array length
 O(n * k) Runtime: 2 ms, faster than 74.81% of Java online submissions for Group Shifted Strings.
 O(n) Memory Usage: 39 MB, less than 99.76% of Java online submissions for Group Shifted Strings.
*/
// leetcode submit region end(Prohibit modification and deletion)
