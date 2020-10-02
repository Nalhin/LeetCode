package com.leetcode.arrays.easy;
// Given a non-empty array of digits representing a non-negative integer, increme
// nt one to the integer.
//
// The digits are stored such that the most significant digit is at the head of
// the list, and each element in the array contains a single digit.
//
// You may assume the integer does not contain any leading zero, except the numb
// er 0 itself.
//
//
// Example 1:
//
//
// Input: digits = [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
//
//
// Example 2:
//
//
// Input: digits = [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.
//
//
// Example 3:
//
//
// Input: digits = [0]
// Output: [1]
//
//
//
// Constraints:
//
//
// 1 <= digits.length <= 100
// 0 <= digits[i] <= 9
//
// Related Topics Array
// 👍 1781 👎 2621

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;

public class PlusOne_66 {
  public int[] plusOne(int[] digits) {

    int over = 1;
    for (int i = digits.length - 1; i >= 0 && over > 0; i--) {
      int newVal = digits[i] + over;
      over = newVal / 10;
      digits[i] = newVal % 10;
    }

    if (digits[0] == 0) {
      digits = Arrays.copyOfRange(digits, 1, digits.length + 2);
      digits[0] = 1;
    }

    return digits;
  }
}
/*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
  O(1) Memory Usage: 37.6 MB, less than 87.84% of Java online submissions for Plus
/*
// leetcode submit region end(Prohibit modification and deletion)
 */
