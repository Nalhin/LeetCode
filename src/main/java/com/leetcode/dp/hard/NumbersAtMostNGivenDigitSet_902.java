package com.leetcode.dp.hard;

// Given an array of digits, you can write numbers using each digits[i] as many t
// imes as we want. For example, if digits = ['1','3','5'], we may write numbers su
// ch as '13', '551', and '1351315'.
//
// Return the number of positive integers that can be generated that are less th
// an or equal to a given integer n.
//
//
// Example 1:
//
//
// Input: digits = ["1","3","5","7"], n = 100
// Output: 20
// Explanation:
// The 20 numbers that can be written are:
// 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
//
//
// Example 2:
//
//
// Input: digits = ["1","4","9"], n = 1000000000
// Output: 29523
// Explanation:
// We can write 3 one digit numbers, 9 two digit numbers, 27 three digit numbers,
//
// 81 four digit numbers, 243 five digit numbers, 729 six digit numbers,
// 2187 seven digit numbers, 6561 eight digit numbers, and 19683 nine digit numbe
// rs.
// In total, this is 29523 integers that can be written using the digits array.
//
//
// Example 3:
//
//
// Input: digits = ["7"], n = 8
// Output: 1
//
//
//
// Constraints:
//
//
// 1 <= digits.length <= 9
// digits[i].length == 1
// digits[i] is a digit from '1' to '9'.
// All the values in digits are unique.
// 1 <= n <= 109
//
// Related Topics Math Dynamic Programming
// 👍 327 👎 48

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Numbers At Most N Given Digit Set.
 O(1) Memory Usage: 36.4 MB, less than 45.38% of Java online submissions for Numbers At Most N Given Digit Set.
*/
public class NumbersAtMostNGivenDigitSet_902 {
  public int atMostNGivenDigitSet(String[] digits, int n) {
    String num = String.valueOf(n);
    int k = num.length();
    int prev = 1;

    for (int i = k - 1; i >= 0; i--) {
      int currNum = num.charAt(i) - '0';
      int curr = 0;
      for (String digit : digits) {
        if (currNum > Integer.parseInt(digit)) {
          curr += Math.pow(digits.length, k - i - 1);
        } else if (currNum == Integer.parseInt(digit)) {
          curr += prev;
        }
      }
      prev = curr;
    }
    int ans = 0;
    for (int i = 1; i < k; i++) {
      ans += Math.pow(digits.length, i);
    }
    return ans + prev;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
