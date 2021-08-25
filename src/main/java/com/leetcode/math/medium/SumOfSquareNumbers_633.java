package com.leetcode.math.medium;

// Given a non-negative integer c, decide whether there're two integers a and b
// such that a² + b² = c.
//
//
// Example 1:
//
//
// Input: c = 5
// Output: true
// Explanation: 1 * 1 + 2 * 2 = 5
//
//
// Example 2:
//
//
// Input: c = 3
// Output: false
//
//
// Example 3:
//
//
// Input: c = 4
// Output: true
//
//
// Example 4:
//
//
// Input: c = 2
// Output: true
//
//
// Example 5:
//
//
// Input: c = 1
// Output: true
//
//
//
// Constraints:
//
//
// 0 <= c <= 2³¹ - 1
//
// Related Topics Math Two Pointers Binary Search 👍 908 👎 415
/*
 O(sqrt(n)) Runtime: 2 ms, faster than 93.87% of Java online submissions for Sum of Square Numbers.
 O(1) Memory Usage: 35.8 MB, less than 62.04% of Java online submissions for Sum of Square Numbers.
*/

// leetcode submit region begin(Prohibit modification and deletion)

public class SumOfSquareNumbers_633 {
  public boolean judgeSquareSum(int c) {
    int right = (int) Math.sqrt(c);
    int left = 0;

    while (left <= right) {
      int target = left * left + right * right;
      if (target == c) {
        return true;
      } else if (target > c) {
        right--;
      } else {
        left++;
      }
    }

    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
