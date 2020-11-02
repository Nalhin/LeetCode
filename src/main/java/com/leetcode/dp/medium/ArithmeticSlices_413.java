package com.leetcode.dp.medium;

// A sequence of numbers is called arithmetic if it consists of at least three el
// ements and if the difference between any two consecutive elements is the same.
//
// For example, these are arithmetic sequences:
//
//
// 1, 3, 5, 7, 9
// 7, 7, 7, 7
// 3, -1, -5, -9
//
// The following sequence is not arithmetic.
//
//
// 1, 1, 2, 5, 7
//
//
// A zero-indexed array A consisting of N numbers is given. A slice of that arra
// y is any pair of integers (P, Q) such that 0 <= P < Q < N.
//
// A slice (P, Q) of the array A is called arithmetic if the sequence:
// A[P], A[P + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means t
// hat P + 1 < Q.
//
// The function should return the number of arithmetic slices in the array A.
//
//
// Example:
//
//
// A = [1, 2, 3, 4]
//
// return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4]
// itself.
//
// Related Topics Math Dynamic Programming
// 👍 1224 👎 176

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n)  Runtime: 0 ms, faster than 100.00% of Java online submissions for Arithmetic Slices.
 O(1)  Memory Usage: 37.1 MB, less than 15.34% of Java online submissions for Arithmetic Slices.
*/
public class ArithmeticSlices_413 {
  public int numberOfArithmeticSlices(int[] A) {
    int dp = 0;
    int ans = 0;
    for (int i = 2; i < A.length; i++) {
      if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
        dp += 1;
        ans += dp;
      } else {
        dp = 0;
      }
    }
    return ans;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
