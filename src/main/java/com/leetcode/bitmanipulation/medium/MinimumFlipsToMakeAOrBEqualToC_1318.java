package com.leetcode.bitmanipulation.medium;

// Given 3 positives numbers a, b and c. Return the minimum flips required in som
// e bits of a and b to make ( a OR b == c ). (bitwise OR operation).
// Flip operation consists of change any single bit 1 to 0 or change the bit 0 to
// 1 in their binary representation.
//
//
// Example 1:
//
//
//
//
// Input: a = 2, b = 6, c = 5
// Output: 3
// Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
//
// Example 2:
//
//
// Input: a = 4, b = 2, c = 7
// Output: 1
//
//
// Example 3:
//
//
// Input: a = 1, b = 2, c = 3
// Output: 0
//
//
//
// Constraints:
//
//
// 1 <= a <= 10^9
// 1 <= b <= 10^9
// 1 <= c <= 10^9
// Related Topics Bit Manipulation
// 👍 206 👎 21

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(log(max(a,b,c)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Flips to Make a OR b Equal to c.
 O(1) Memory Usage: 35.7 MB, less than 76.33% of Java online submissions for Minimum Flips to Make a OR b Equal to c.
*/
public class MinimumFlipsToMakeAOrBEqualToC_1318 {
  public int minFlips(int a, int b, int c) {
    int result = 0;

    while (a > 0 || b > 0 || c > 0) {
      int aBit = a % 2;
      int bBit = b % 2;
      int cBit = c % 2;

      a /= 2;
      b /= 2;
      c /= 2;

      if (cBit == 0) {
        result += aBit + bBit;
      } else {
        result += aBit + bBit > 0 ? 0 : 1;
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
