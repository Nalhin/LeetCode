package com.leetcode.arrays.medium;

// We are given an array asteroids of integers representing asteroids in a row.
//
// For each asteroid, the absolute value represents its size, and the sign repre
// sents its direction (positive meaning right, negative meaning left). Each astero
// id moves at the same speed.
//
// Find out the state of the asteroids after all collisions. If two asteroids me
// et, the smaller one will explode. If both are the same size, both will explode.
// Two asteroids moving in the same direction will never meet.
//
//
// Example 1:
//
//
// Input: asteroids = [5,10,-5]
// Output: [5,10]
// Explanation: The 10 and -5 collide resulting in 10.  The 5 and 10 never collid
// e.
//
//
// Example 2:
//
//
// Input: asteroids = [8,-8]
// Output: []
// Explanation: The 8 and -8 collide exploding each other.
//
//
// Example 3:
//
//
// Input: asteroids = [10,2,-5]
// Output: [10]
// Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resul
// ting in 10.
//
//
// Example 4:
//
//
// Input: asteroids = [-2,-1,1,2]
// Output: [-2,-1,1,2]
// Explanation: The -2 and -1 are moving left, while the 1 and 2 are moving right
// . Asteroids moving the same direction never meet, so no asteroids will meet each
// other.
//
//
//
// Constraints:
//
//
// 1 <= asteroids <= 104
// -1000 <= asteroids[i] <= 1000
// asteroids[i] != 0
//
// Related Topics Stack
// 👍 1414 👎 134

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision_735 {
  public int[] asteroidCollision(int[] asteroids) {
    Deque<Integer> stack = new ArrayDeque<>();

    for (int curr : asteroids) {
      boolean add = true;
      while (!stack.isEmpty() && stack.peek() > 0 && curr < 0) {
        int top = stack.pop();
        if (Math.abs(top) > Math.abs(curr)) {
          curr = top;
        } else if (Math.abs(top) == Math.abs(curr)) {
          add = false;
          break;
        }
      }
      if (add) {
        stack.push(curr);
      }
    }
    int[] result = new int[stack.size()];

    for (int i = result.length - 1; i >= 0; i--) {
      result[i] = stack.pop();
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
