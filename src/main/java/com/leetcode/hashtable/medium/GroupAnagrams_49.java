package com.leetcode.hashtable.medium;

// Given an array of strings strs, group the anagrams together. You can return th
// e answer in any order.
//
// An Anagram is a word or phrase formed by rearranging the letters of a differe
// nt word or phrase, typically using all the original letters exactly once.
//
//
// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
// Example 2:
// Input: strs = [""]
// Output: [[""]]
// Example 3:
// Input: strs = ["a"]
// Output: [["a"]]
//
//
// Constraints:
//
//
// 1 <= strs.length <= 104
// 0 <= strs[i].length <= 100
// strs[i] consists of lower-case English letters.
//
// Related Topics Hash Table String
// 👍 4118 👎 198

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// leetcode submit region begin(Prohibit modification and deletion)
public class GroupAnagrams_49 {
  public List<List<String>> groupAnagrams(String[] strs) {
    Map<Integer, List<String>> map = Arrays.stream(strs).collect(Collectors.groupingBy(this::hash));
    return new ArrayList<>(map.values());
  }

  private int hash(String word) {
    int hash = 0;
    for (int i = 0; i < word.length(); i++) {
      hash += word.charAt(i);
    }
    return hash;
  }
}
/*
  n - length of strs
  k - average length of strs entry
  O(n*k) Runtime: 8 ms, faster than 57.40% of Java online submissions for Group Anagrams.
  O(n) Memory Usage: 42.5 MB, less than 68.75% of Java online submissions for Group Anagrams.
*/

// leetcode submit region end(Prohibit modification and deletion)

