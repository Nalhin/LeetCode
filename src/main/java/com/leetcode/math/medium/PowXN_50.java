package com.leetcode.math.medium;

// Implement pow(x, n), which calculates x raised to the power n (i.e., xⁿ).
//
//
// Example 1:
//
//
// Input: x = 2.00000, n = 10
// Output: 1024.00000
//
//
// Example 2:
//
//
// Input: x = 2.10000, n = 3
// Output: 9.26100
//
//
// Example 3:
//
//
// Input: x = 2.00000, n = -2
// Output: 0.25000
// Explanation: 2⁻² = 1/2² = 1/4 = 0.25
//
//
//
// Constraints:
//
//
// -100.0 < x < 100.0
// -2³¹ <= n <= 2³¹-1
// -10⁴ <= xⁿ <= 10⁴
//
// Related Topics Math Recursion 👍 3570 👎 4710

// leetcode submit region begin(Prohibit modification and deletion)

public class PowXN_50 {
  /*
   O(log(n)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Pow(x, n).
   O(log(n)) Memory Usage: 38.3 MB, less than 72.59% of Java online submissions for Pow(x, n).
  */
  static class Recursive {
    public double myPow(double x, int n) {
      if (n == 0) {
        return 1;
      }

      if (n < 0) {
        return 1 / (x * myPow(x, -(n + 1)));
      }

      double half = myPow(x, n / 2);

      return half * half * (n % 2 == 1 ? x : 1);
    }
  }
  /*
   O(log(n))Runtime: 0 ms, faster than 100.00% of Java online submissions for Pow(x, n).
   O(1) Memory Usage: 38.3 MB, less than 60.66% of Java online submissions for Pow(x, n).
  */
  static class Iterative {

    public double myPow(double x, int n) {
      long nAbs = Math.abs((long) n);
      if (n == 0) {
        return 1;
      }

      double result = 1;

      for (long i = nAbs; i > 0; i >>= 1) {
        if ((i & 1) == 1) {
          result = result * x;
        }
        x = x * x;
      }

      return n < 0 ? 1 / result : result;
    }

  }
}
// leetcode submit region end(Prohibit modification and deletion)
