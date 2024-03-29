package com.leetcode.math.easy;

// Given an integer n, return true if it is a power of three. Otherwise, return f
// alse.
//
// An integer n is a power of three, if there exists an integer x such that n ==
// 3x.
//
//
// Example 1:
// Input: n = 27
// Output: true
// Example 2:
// Input: n = 0
// Output: false
// Example 3:
// Input: n = 9
// Output: true
// Example 4:
// Input: n = 45
// Output: false
//
//
// Constraints:
//
//
// -231 <= n <= 231 - 1
//
//
//
// Follow up: Could you solve it without loops/recursion? Related Topics Math
// 👍 77 👎 13
/*
 O(log(n)) Runtime: 10 ms, faster than 100.00% of Java online submissions for Power of Three.
 O(1) Memory Usage: 38.3 MB, less than 97.93% of Java online submissions for Power of Three.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class PowerOfThree_326 {
  public boolean isPowerOfThree(int n) {
    if (n < 1) {
      return false;
    }

    while (n % 3 == 0) {
      n /= 3;
    }

    return n == 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
