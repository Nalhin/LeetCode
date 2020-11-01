package com.leetcode.math.easy;

// Implement int sqrt(int x).
//
// Compute and return the square root of x, where x is guaranteed to be a non-ne
// gative integer.
//
// Since the return type is an integer, the decimal digits are truncated and onl
// y the integer part of the result is returned.
//
// Example 1:
//
//
// Input: 4
// Output: 2
//
//
// Example 2:
//
//
// Input: 8
// Output: 2
// Explanation: The square root of 8 is 2.82842..., and since
//              the decimal part is truncated, 2 is returned.
//
// Related Topics Math Binary Search
// 👍 1582 👎 2077

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 1 ms, faster than 99.98% of Java online submissions for Sqrt(x).
 O(1) Memory Usage: 35.8 MB, less than 7.59% of Java online submissions for Sqrt(x).
*/
public class SqrtX_69 {
  public int mySqrt(int x) {
    if (x < 2) {
      return x;
    }
    int left = 2;
    int right = x / 2;

    while (left <= right) {
      int mid = (left + right) >> 1;
      long curr = (long) mid * mid;
      if (curr < x) {
        left = mid + 1;
      } else if (curr > x) {
        right = mid - 1;
      } else {
        return mid;
      }
    }
    return right;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
