package com.leetcode.queue.medium;

// You have a lock in front of you with 4 circular wheels. Each wheel has 10 slot
// s: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freel
// y and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each
// move consists of turning one wheel one slot.
//
// The lock initially starts at '0000', a string representing the state of the 4
// wheels.
//
// You are given a list of deadends dead ends, meaning if the lock displays any
// of these codes, the wheels of the lock will stop turning and you will be unable
// to open it.
//
// Given a target representing the value of the wheels that will unlock the lock
// , return the minimum total number of turns required to open the lock, or -1 if i
// t is impossible.
//
//
// Example 1:
//
//
// Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
// Output: 6
// Explanation:
// A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "12
// 01" -> "1202" -> "0202".
// Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would
// be invalid,
// because the wheels of the lock become stuck after the display becomes the dead
// end "0102".
//
//
// Example 2:
//
//
// Input: deadends = ["8888"], target = "0009"
// Output: 1
// Explanation:
// We can turn the last wheel in reverse to move from "0000" -> "0009".
//
//
// Example 3:
//
//
// Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], t
// arget = "8888"
// Output: -1
// Explanation:
// We can't reach the target without getting stuck.
//
//
// Example 4:
//
//
// Input: deadends = ["0000"], target = "8888"
// Output: -1
//
//
//
// Constraints:
//
//
// 1 <= deadends.length <= 500
// deadends[i].length == 4
// target.length == 4
// target will not be in the list deadends.
// target and deadends[i] consist of digits only.
//
// Related Topics Breadth-first Search
// 👍 1279 👎 48

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n*digits^n + d)Runtime: 123 ms, faster than 57.32% of Java online submissions for Open the Lock.
 O(n*digits^n + d) Memory Usage: 47 MB, less than 54.11% of Java online submissions for Open the Lock.
 where:
 n - string size,
 digits - num of digits,
 d - num of deadends
*/
public class OpenTheLock_752 {
  private final String BASE = "0000";

  public int openLock(String[] deadends, String target) {
    if (target.equals(BASE)) {
      return 0;
    }

    Set<String> visited = Arrays.stream(deadends).collect(Collectors.toSet());
    if (visited.contains(BASE)) {
      return -1;
    }
    Queue<String> queue = new ArrayDeque<>();
    visited.add(BASE);
    queue.add(BASE);

    int level = 0;

    while (!queue.isEmpty()) {

      int size = queue.size();

      for (int j = 0; j < size; j++) {
        String lock = queue.remove();

        for (int i = 0; i <= 3; i++) {
          int val = Character.getNumericValue(lock.charAt(i));
          String left = replaceVal(lock, Character.forDigit(val + 1 > 9 ? 0 : val + 1, 10), i);
          if (!visited.contains(left)) {
            visited.add(left);
            queue.add(left);
          }
          String right = replaceVal(lock, Character.forDigit(val - 1 < 0 ? 9 : val - 1, 10), i);
          if (!visited.contains(right)) {
            visited.add(right);
            queue.add(right);
          }
          if (left.equals(target) || right.equals(target)) {
            return level + 1;
          }
        }
      }
      level++;
    }
    return -1;
  }

  private String replaceVal(String str, char c, int index) {
    return str.substring(0, index) + c + str.substring(index + 1);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
