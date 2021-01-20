package com.leetcode.bitmanipulation.easy;

// Given an integer n, return true if it is a power of two. Otherwise, return fal
// se.
//
// An integer n is a power of two, if there exists an integer x such that n == 2
// x.
//
//
// Example 1:
//
//
// Input: n = 1
// Output: true
// Explanation: 20 = 1
//
//
// Example 2:
//
//
// Input: n = 16
// Output: true
// Explanation: 24 = 16
//
//
// Example 3:
//
//
// Input: n = 3
// Output: false
//
//
// Example 4:
//
//
// Input: n = 4
// Output: true
//
//
// Example 5:
//
//
// Input: n = 5
// Output: false
//
//
//
// Constraints:
//
//
// -231 <= n <= 231 - 1
//
// Related Topics Math Bit Manipulation
// 👍 1190 👎 211

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(1) Runtime: 1 ms, faster than 100.00% of Java online submissions for Power of Two.
 O(1) Memory Usage: 35.7 MB, less than 98.09% of Java online submissions for Power of Two.
*/
public class PowerOfTwo_231 {
  public boolean isPowerOfTwo(int n) {
    if (n <= 0) {
      return false;
    }
    return (n & (n - 1)) == 0;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
