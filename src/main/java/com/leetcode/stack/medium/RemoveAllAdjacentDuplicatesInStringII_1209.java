package com.leetcode.stack.medium;

// Given a string s, a k duplicate removal consists of choosing k adjacent and eq
// ual letters from s and removing them causing the left and the right side of the
// deleted substring to concatenate together.
//
// We repeatedly make k duplicate removals on s until we no longer can.
//
// Return the final string after all such duplicate removals have been made.
//
// It is guaranteed that the answer is unique.
//
//
// Example 1:
//
//
// Input: s = "abcd", k = 2
// Output: "abcd"
// Explanation: There's nothing to delete.
//
// Example 2:
//
//
// Input: s = "deeedbbcccbdaa", k = 3
// Output: "aa"
// Explanation:
// First delete "eee" and "ccc", get "ddbbbdaa"
// Then delete "bbb", get "dddaa"
// Finally delete "ddd", get "aa"
//
// Example 3:
//
//
// Input: s = "pbbcggttciiippooaais", k = 2
// Output: "ps"
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 10^5
// 2 <= k <= 10^4
// s only contains lower case English letters.
//
// Related Topics Stack
// 👍 1373 👎 30
/*
 O(n) Runtime: 4 ms, faster than 91.33% of Java online submissions for Remove All Adjacent Duplicates in String II.
 O(n) Memory Usage: 39.2 MB, less than 61.82% of Java online submissions for Remove All Adjacent Duplicates in String II.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjacentDuplicatesInStringII_1209 {
  public String removeDuplicates(String s, int k) {
    char prev = s.charAt(0);
    int count = 1;

    Deque<Payload> deque = new ArrayDeque<>();

    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) != prev) {
        Payload payload = new Payload(count, prev).removeExcessIfPossible(k);
        if (!deque.isEmpty() && deque.peek().canMerge(payload)) {
          payload = deque.pop().merge(payload).removeExcessIfPossible(k);
        }

        if (!payload.isEmpty()) {
          deque.push(payload);
        }

        prev = s.charAt(i);
        count = 0;
      }
      count++;
    }

    StringBuilder sb = new StringBuilder();

    while (!deque.isEmpty()) {
      Payload payload = deque.removeLast();
      sb.append(String.valueOf(payload.letter).repeat(payload.count));
    }
    sb.append(String.valueOf(prev).repeat(count % k));

    return sb.toString();
  }

  private static class Payload {
    private final int count;
    private final char letter;

    private Payload(int count, char letter) {
      this.count = count;
      this.letter = letter;
    }

    private boolean canMerge(Payload with) {
      return letter == with.letter;
    }

    private Payload merge(Payload with) {
      return new Payload(count + with.count, letter);
    }

    private Payload removeExcessIfPossible(int k) {
      if (count < k) {
        return this;
      }
      return new Payload(count % k, letter);
    }

    private boolean isEmpty() {
      return count == 0;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
