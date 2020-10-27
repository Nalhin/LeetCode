package com.leetcode.arrays.easy;

// You have a total of n coins that you want to form in a staircase shape, where
// every k-th row must have exactly k coins.
//
// Given n, find the total number of full staircase rows that can be formed.
//
// n is a non-negative integer and fits within the range of a 32-bit signed inte
// ger.
//
// Example 1:
//
// n = 5
//
// The coins can form the following rows:
// ¤
// ¤ ¤
// ¤ ¤
//
// Because the 3rd row is incomplete, we return 2.
//
//
//
// Example 2:
//
// n = 8
//
// The coins can form the following rows:
// ¤
// ¤ ¤
// ¤ ¤ ¤
// ¤ ¤
//
// Because the 4th row is incomplete, we return 3.
//
// Related Topics Math Binary Search
// 👍 740 👎 736

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(log(n)) Runtime: 1 ms, faster than 100.00% of Java online submissions for Arranging Coins.
 O(1) Memory Usage: 36.1 MB, less than 6.34% of Java online submissions for Arranging Coins.
*/
public class ArrangingCoins_441 {
  public int arrangeCoins(int n) {
    long left = 0;
    long right = n;

    while (left <= right) {
      long mid = (left + right) >> 1;
      long val = stairCount(mid);

      if (val == n) {
        return (int) mid;
      } else if (val > n) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return (int) left - 1;
  }

  private long stairCount(long k) {
    return (k * (k + 1)) / 2;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
