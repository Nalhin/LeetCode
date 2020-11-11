package com.leetcode.math.medium;

// Given the coordinates of four points in 2D space, return whether the four poin
// ts could construct a square.
//
// The coordinate (x,y) of a point is represented by an integer array with two i
// ntegers.
//
// Example:
//
//
// Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
// Output: True
//
//
//
//
// Note:
//
//
// All the input integers are in the range [-10000, 10000].
// A valid square has four equal sides with positive length and four equal angle
// s (90-degree angles).
// Input points have no order.
//
//
//
// Related Topics Math
// 👍 361 👎 512

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashSet;
import java.util.Set;
/*
  O(1) Runtime: 1 ms, faster than 79.52% of Java online submissions for Valid Square.
  O(1) Memory Usage: 37 MB, less than 6.12% of Java online submissions for Valid Square.
*/
public class ValidSquare_593 {
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    Set<Integer> set = new HashSet<>();

    if (isEqual(p1, p2) || isEqual(p2, p3) || isEqual(p3, p4) || isEqual(p4, p1)) {
      return false;
    }

    set.add(distPow(p1, p2));
    set.add(distPow(p1, p3));
    set.add(distPow(p1, p4));
    set.add(distPow(p2, p3));
    set.add(distPow(p2, p4));
    set.add(distPow(p3, p4));

    return set.size() == 2;
  }

  private boolean isEqual(int[] p1, int[] p2) {
    return p1[0] == p2[0] && p1[1] == p2[1];
  }

  private int distPow(int[] p1, int[] p2) {
    return (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
