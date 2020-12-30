package com.leetcode.bitmanipulation.easy;

// The Hamming distance between two integers is the number of positions at which
// the corresponding bits are different.
//
// Given two integers x and y, calculate the Hamming distance.
//
// Note:
// 0 ≤ x, y < 231.
//
//
// Example:
//
// Input: x = 1, y = 4
//
// Output: 2
//
// Explanation:
// 1   (0 0 0 1)
// 4   (0 1 0 0)
//       ↑   ↑
//
// The above arrows point to positions where the corresponding bits are different
// .
//
// Related Topics Bit Manipulation
// 👍 2039 👎 172
/*
 O(1) Runtime: 0 ms, faster than 100.00% of Java online submissions for Hamming Distance.
 O(1) Memory Usage: 35.8 MB, less than 64.05% of Java online submissions for Hamming Distance.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class HammingDistance_461 {
  public int hammingDistance(int x, int y) {
    int xor = x ^ y;
    int result = 0;
    while (xor > 0) {
      result += 1;
      xor = xor & (xor - 1);
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
