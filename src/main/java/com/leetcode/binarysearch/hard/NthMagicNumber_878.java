package com.leetcode.binarysearch.hard;

// A positive integer is magical if it is divisible by either a or b.
//
// Given the three integers n, a, and b, return the nᵗʰ magical number. Since
// the answer may be very large, return it modulo 10⁹ + 7.
//
//
// Example 1:
//
//
// Input: n = 1, a = 2, b = 3
// Output: 2
//
//
// Example 2:
//
//
// Input: n = 4, a = 2, b = 3
// Output: 6
//
//
//
// Constraints:
//
//
// 1 <= n <= 10⁹
// 2 <= a, b <= 4 * 10⁴
//
// Related Topics Math Binary Search 👍 876 👎 127

// leetcode submit region begin(Prohibit modification and deletion)
public class NthMagicNumber_878 {

  private static final int MOD = 1_000_000_007;

  /*
   O(log(n * Math.min(a,b)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Nth Magical Number.
   O(1) Memory Usage: 35.9 MB, less than 44.10% of Java online submissions for Nth Magical Number.
  */
  public int nthMagicalNumber(int n, int a, int b) {
    long left = Math.min(a, b);
    long right = (long) n * Math.min(a, b);

    int lcm = a * b / gdc(a, b);

    long result = -1;
    while (left <= right) {

      long mid = left + (right - left) / 2;

      long count = mid / a + mid / b - mid / lcm;

      if (count >= n) {
        right = mid - 1;
        result = mid;
      } else {
        left = mid + 1;
      }
    }

    return (int) (result % MOD);
  }

  private int gdc(int a, int b) {
    if (b == 0) {
      return a;
    }

    return gdc(b, a % b);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
