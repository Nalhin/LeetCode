package com.leetcode.bitmanipulation.medium;

// Given two integers left and right that represent the range [left, right],
// return the bitwise AND of all numbers in this range, inclusive.
//
//
// Example 1:
//
//
// Input: left = 5, right = 7
// Output: 4
//
//
// Example 2:
//
//
// Input: left = 0, right = 0
// Output: 0
//
//
// Example 3:
//
//
// Input: left = 1, right = 2147483647
// Output: 0
//
//
//
// Constraints:
//
//
// 0 <= left <= right <= 2³¹ - 1
//
// Related Topics Bit Manipulation 👍 1772 👎 157
/*
 O(log(max(n,m)) Runtime: 4 ms, faster than 100.00% of Java online submissions for Bitwise AND of Numbers Range.
 O(1) Memory Usage: 38.3 MB, less than 63.66% of Java online submissions for Bitwise AND of Numbers Range.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class BitwiseANDOfNumbersRange_201 {
  public int rangeBitwiseAnd(int m, int n) {
    int notCommonBits = 0;

    while (m < n) {
      m >>= 1;
      n >>= 1;
      ++notCommonBits;
    }

    return m << notCommonBits;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
