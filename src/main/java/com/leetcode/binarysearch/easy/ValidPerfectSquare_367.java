package com.leetcode.binarysearch.easy;

// Given a positive integer num, write a function which returns True if num is a
// perfect square else False.
//
// Follow up: Do not use any built-in library function such as sqrt.
//
//
// Example 1:
// Input: num = 16
// Output: true
// Example 2:
// Input: num = 14
// Output: false
//
//
// Constraints:
//
//
// 1 <= num <= 2^31 - 1
//
// Related Topics Math Binary Search
// 👍 1024 👎 177

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Perfect Square.
 O(n) Memory Usage: 35.8 MB, less than 6.80% of Java online submissions for Valid Perfect Square.
*/
public class ValidPerfectSquare_367 {
  public boolean isPerfectSquare(int num) {
    if (num == 1) {
      return true;
    }
    int left = 0;
    int right = num / 2;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      long pow = (long) mid * mid;

      if (pow == num) {
        return true;
      }
      if (pow > num) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
