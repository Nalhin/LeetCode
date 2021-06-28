package com.leetcode.strings.easy;
// You are given a string s consisting of lowercase English letters. A duplicate
// removal consists of choosing two adjacent and equal letters and removing them.
//
// We repeatedly make duplicate removals on s until we no longer can.
//
// Return the final string after all such duplicate removals have been made. It
// can be proven that the answer is unique.
//
//
// Example 1:
//
//
// Input: s = "abbaca"
// Output: "ca"
// Explanation:
// For example, in "abbaca" we could remove "bb" since the letters are adjacent a
// nd equal, and this is the only possible move.  The result of this move is that t
// he string is "aaca", of which only "aa" is possible, so the final string is "ca"
// .
//
//
// Example 2:
//
//
// Input: s = "azxxzy"
// Output: "ay"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 105
// s consists of lowercase English letters.
//
// Related Topics String Stack
// 👍 1803 👎 106
/*
  O(n) Runtime: 18 ms, faster than 58.65% of Java online submissions for Remove All Adjacent Duplicates In String.
  O(n) Memory Usage: 39.8 MB, less than 41.51% of Java online submissions for Remove All Adjacent Duplicates In String.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjacentDuplicatesInString_1047 {
  public String removeDuplicates(String s) {
    Deque<Character> deque = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      char currChar = s.charAt(i);
      if (!deque.isEmpty() && deque.peek() == currChar) {
        deque.pop();
      } else {
        deque.push(currChar);
      }
    }

    StringBuilder sb = new StringBuilder();

    while (!deque.isEmpty()) {
      sb.append(deque.removeLast());
    }

    return sb.toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
