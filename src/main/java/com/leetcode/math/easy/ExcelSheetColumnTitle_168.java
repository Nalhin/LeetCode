package com.leetcode.math.easy;

// Given a positive integer, return its corresponding column title as appear in a
// n Excel sheet.
//
// For example:
//
//
//    1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB
//    ...
//
//
// Example 1:
//
//
// Input: 1
// Output: "A"
//
//
// Example 2:
//
//
// Input: 28
// Output: "AB"
//
//
// Example 3:
//
//
// Input: 701
// Output: "ZY"
// Related Topics Math
// 👍 1437 👎 271

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(log(n)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Title.
 O(1) Memory Usage: 36.4 MB, less than 32.62% of Java online submissions for Excel Sheet Column Title.
*/
public class ExcelSheetColumnTitle_168 {
  public String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();

    while (n > 0) {
      n--;
      int res = n % 26;
      sb.append((char) ('A' + res));
      n /= 26;
    }

    return sb.reverse().toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
