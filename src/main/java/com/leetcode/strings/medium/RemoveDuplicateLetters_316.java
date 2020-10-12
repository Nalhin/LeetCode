package com.leetcode.strings.medium;

// Given a string s, remove duplicate letters so that every letter appears once a
// nd only once. You must make sure your result is the smallest in lexicographical
// order among all possible results.
//
// Note: This question is the same as 1081: https://leetcode.com/problems/smalle
// st-subsequence-of-distinct-characters/
//
//
// Example 1:
//
//
// Input: s = "bcabc"
// Output: "abc"
//
//
// Example 2:
//
//
// Input: s = "cbacdcbc"
// Output: "acdb"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 104
// s consists of lowercase English letters.
//
// Related Topics String Stack Greedy
// 👍 1659 👎 124

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

public class RemoveDuplicateLetters_316 {
  public String removeDuplicateLetters(String s) {
    Map<Character, Integer> map = new HashMap<>();
    char[] chars = s.toCharArray();

    for (int i = 0; i < chars.length; i++) {
      map.put(chars[i], i);
    }

    Deque<Character> stack = new ArrayDeque<>();
    Set<Character> visited = new HashSet<>();

    for (int i = 0; i < chars.length; i++) {
      if (visited.contains(chars[i])) {
        continue;
      }
      while (!stack.isEmpty() && stack.peek() > chars[i] && map.get(stack.peek()) > i) {
        visited.remove(stack.pop());
      }
      visited.add(chars[i]);
      stack.push(chars[i]);
    }

    StringBuilder sb = new StringBuilder(stack.size());

    for (char c : stack) {
      sb.append(c);
    }
    return sb.reverse().toString();
  }
}
/*
 O(n) Runtime: 3 ms, faster than 81.40% of Java online submissions for Remove Duplicate Letters.
 O(n) Memory Usage: 38.7 MB, less than 8.97% of Java online submissions for Remove Duplicate Letters.
*/
// leetcode submit region end(Prohibit modification and deletion)
