package com.leetcode.math.medium;

// There is a special square room with mirrors on each of the four walls. Except
// for the southwest corner, there are receptors on each of the remaining corners,
// numbered 0, 1, and 2.
//
// The square room has walls of length p, and a laser ray from the southwest cor
// ner first meets the east wall at a distance q from the 0th receptor.
//
// Return the number of the receptor that the ray meets first. (It is guaranteed
// that the ray will meet a receptor eventually.)
//
//
//
//
// Example 1:
//
//
// Input: p = 2, q = 1
// Output: 2
// Explanation: The ray meets receptor 2 the first time it gets reflected back to
// the left wall.
//
//
//
// Note:
//
//
// 1 <= p <= 1000
// 0 <= q <= p
//
//
// Related Topics Math
// 👍 236 👎 412

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(log(p)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Mirror Reflection.
 O(1) Memory Usage: 35.9 MB, less than 30.55% of Java online submissions for Mirror Reflection.
*/
public class MirrorReflection_858 {
  public int mirrorReflection(int p, int q) {
    int g = gcd(p, q);
    p /= g;
    p %= 2;
    q /= g;
    q %= 2;

    if (p == 1 && q == 1) return 1;
    return p == 1 ? 0 : 2;
  }

  private int gcd(int a, int b) {
    if (a == 0) return b;
    return gcd(b % a, a);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
