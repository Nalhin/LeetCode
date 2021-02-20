package com.leetcode.math.hard;

// A move consists of taking a point (x, y) and transforming it to either (x, x+y
// ) or (x+y, y).
//
// Given a starting point (sx, sy) and a target point (tx, ty), return True if a
// nd only if a sequence of moves exists to transform the point (sx, sy) to (tx, ty
// ). Otherwise, return False.
//
//
// Examples:
// Input: sx = 1, sy = 1, tx = 3, ty = 5
// Output: True
// Explanation:
// One series of moves that transforms the starting point to the target is:
// (1, 1) -> (1, 2)
// (1, 2) -> (3, 2)
// (3, 2) -> (3, 5)
//
// Input: sx = 1, sy = 1, tx = 2, ty = 2
// Output: False
//
// Input: sx = 1, sy = 1, tx = 1, ty = 1
// Output: True
//
//
//
// Note:
//
//
// sx, sy, tx, ty will all be integers in the range [1, 10^9].
//
// Related Topics Math
// 👍 672 👎 121

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(log(max(n,m)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Reaching Points.
 O(1)      Memory Usage: 37.9 MB, less than 7.40% of Java online submissions for Reaching Points.
*/

public class ReachingPoints_780 {
  public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    while (tx >= sx && ty >= sy && tx != ty) {
      if (tx > ty) {
        if (ty == sy) {
          return (tx - sx) % ty == 0;
        }
        tx %= ty;
      } else {
        if (tx == sx) {
          return (ty - sy) % tx == 0;
        }
        ty %= tx;
      }
    }

    return tx == sx && ty == sy;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
