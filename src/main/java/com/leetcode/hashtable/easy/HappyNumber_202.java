package com.leetcode.hashtable.easy;

// Write an algorithm to determine if a number n is "happy".
//
// A happy number is a number defined by the following process: Starting with an
// y positive integer, replace the number by the sum of the squares of its digits,
// and repeat the process until the number equals 1 (where it will stay), or it loo
// ps endlessly in a cycle which does not include 1. Those numbers for which this p
// rocess ends in 1 are happy numbers.
//
// Return True if n is a happy number, and False if not.
//
// Example:
//
//
// Input: 19
// Output: true
// Explanation:
// 12 + 92 = 82
// 82 + 22 = 68
// 62 + 82 = 100
// 12 + 02 + 02 = 1
//
// Related Topics Hash Table Math
// 👍 2446 👎 452

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {

  public static class HashTable {
    public boolean isHappy(int n) {
      Set<Integer> set = new HashSet<>();
      while (set.add(n) && n != 1) {
        int newVal = 0;
        while (n > 0) {
          newVal += Math.pow(n % 10, 2);
          n = n / 10;
        }
        n = newVal;
      }

      return n == 1;
    }
  }
  /*
    O(log(n)) Runtime: 1 ms, faster than 90.08% of Java online submissions for Happy Number.
    O(log(n)) Memory Usage: 36.4 MB, less than 79.30% of Java online submissions for Happy Number.
  */

  public static class Floyd {

    private int next(int n) {
      int newVal = 0;
      while (n > 0) {
        newVal += Math.pow(n % 10, 2);
        n = n / 10;
      }
      return newVal;
    }

    public boolean isHappy(int n) {
      int slow = n;
      int fast = next(n);
      while (fast != 1 && slow != fast) {
        slow = next(slow);
        fast = next(next(fast));
      }

      return fast == 1;
    }
  }
  /*
    O(log(n)) Runtime: 1 ms, faster than 90.08% of Java online submissions for Happy Number.
    O(1)    Memory Usage: 36.1 MB, less than 96.34% of Java online submissions for Happy Number.
  */
}
// leetcode submit region end(Prohibit modification and deletion)
