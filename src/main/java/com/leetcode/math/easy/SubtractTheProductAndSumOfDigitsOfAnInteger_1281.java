package com.leetcode.math.easy;

// Given an integer number n, return the difference between the product of its di
// gits and the sum of its digits.
//
// Example 1:
//
//
// Input: n = 234
// Output: 15
// Explanation:
// Product of digits = 2 * 3 * 4 = 24
// Sum of digits = 2 + 3 + 4 = 9
// Result = 24 - 9 = 15
//
//
// Example 2:
//
//
// Input: n = 4421
// Output: 21
// Explanation:
// Product of digits = 4 * 4 * 2 * 1 = 32
// Sum of digits = 4 + 4 + 2 + 1 = 11
// Result = 32 - 11 = 21
//
//
//
// Constraints:
//
//
// 1 <= n <= 10^5
//
// Related Topics Math
// 👍 412 👎 118

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
 O(1) Memory Usage: 36 MB, less than 17.65% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
*/
public class SubtractTheProductAndSumOfDigitsOfAnInteger_1281 {
  public int subtractProductAndSum(int n) {
    int sum = 0;
    int product = 1;

    while (n > 0) {
      int last = n % 10;
      sum += last;
      product *= last;
      n /= 10;
    }

    return product - sum;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
