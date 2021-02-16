package com.leetcode.strings.easy;

// Given an integer n, add a dot (".") as the thousands separator and return it i
// n string format.
//
//
// Example 1:
//
//
// Input: n = 987
// Output: "987"
//
//
// Example 2:
//
//
// Input: n = 1234
// Output: "1.234"
//
//
// Example 3:
//
//
// Input: n = 123456789
// Output: "123.456.789"
//
//
// Example 4:
//
//
// Input: n = 0
// Output: "0"
//
//
//
// Constraints:
//
//
// 0 <= n < 2^31
//
// Related Topics String
// 👍 172 👎 7

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(log(n)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Thousand Separator.
 O(log(n)) Memory Usage: 36.2 MB, less than 67.97% of Java online submissions for Thousand Separator.
*/
public class ThousandSeparator_1556 {
  public String thousandSeparator(int n) {
    if (n == 0) {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    int count = 0;

    while (n > 0) {
      sb.append(n % 10);
      n = n / 10;
      if (count == 2 && n > 0) {
        count = 0;
        sb.append('.');
      } else {
        count++;
      }
    }

    return sb.reverse().toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
