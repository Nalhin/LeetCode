package com.leetcode.bitmanipulation.easy;

// The complement of an integer is the integer you get when you flip all the 0's
// to 1's and all the 1's to 0's in its binary representation.
//
//
// For example, The integer 5 is "101" in binary and its complement is "010"
// which is the integer 2.
//
//
// Given an integer num, return its complement.
//
//
// Example 1:
//
//
// Input: num = 5
// Output: 2
// Explanation: The binary representation of 5 is 101 (no leading zero bits),
// and its complement is 010. So you need to output 2.
//
//
// Example 2:
//
//
// Input: num = 1
// Output: 0
// Explanation: The binary representation of 1 is 1 (no leading zero bits), and
// its complement is 0. So you need to output 0.
//
//
//
// Constraints:
//
//
// 1 <= num < 2³¹
//
//
//
// Note: This question is the same as 1009: https://leetcode.com/problems/
// complement-of-base-10-integer/
// Related Topics Bit Manipulation 👍 1732 👎 98

// leetcode submit region begin(Prohibit modification and deletion)

public class NumberComplement_476 {
  /*
    O(log(n)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Number Complement.
    O(1) Memory Usage: 35.6 MB, less than 91.94% of Java online submissions for Number Complement.
  */
  static class Iterative {
    public int findComplement(int num) {

      int result = 0;
      int i = 0;
      while (num > 0) {
        if ((num & 1) == 0) {
          result += 1 << i;
        }
        num >>= 1;
        i++;
      }

      return result;
    }
  }
  /*
    O(1) Runtime: 0 ms, faster than 100.00% of Java online submissions for Number Complement.
    O(1) Memory Usage: 35.7 MB, less than 66.97% of Java online submissions for Number Complement.
  */
  static class BitMask {

    public int findComplement(int num) {
      int mask = num;
      mask |= mask >> 1;
      mask |= mask >> 2;
      mask |= mask >> 4;
      mask |= mask >> 8;
      mask |= mask >> 16;

      return num ^ mask;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
