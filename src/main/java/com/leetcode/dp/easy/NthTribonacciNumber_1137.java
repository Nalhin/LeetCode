package com.leetcode.dp.easy;

// The Tribonacci sequence Tn is defined as follows:
//
// T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
//
// Given n, return the value of Tn.
//
//
// Example 1:
//
//
// Input: n = 4
// Output: 4
// Explanation:
// T_3 = 0 + 1 + 1 = 2
// T_4 = 1 + 1 + 2 = 4
//
//
// Example 2:
//
//
// Input: n = 25
// Output: 1389537
//
//
//
// Constraints:
//
//
// 0 <= n <= 37
// The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 -
// 1.
// Related Topics Recursion
// 👍 485 👎 52

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(1) Runtime: 0 ms, faster than 100.00% of Java online submissions for N-th Tribonacci Number.
 O(1) Memory Usage: 35.6 MB, less than 84.54% of Java online submissions for N-th Tribonacci Number.
*/
public class NthTribonacciNumber_1137 {
  private static final int[] CACHE = new int[38];

  public int tribonacci(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    }

    if (CACHE[n] > 0) {
      return CACHE[n];
    }

    CACHE[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);

    return CACHE[n];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
