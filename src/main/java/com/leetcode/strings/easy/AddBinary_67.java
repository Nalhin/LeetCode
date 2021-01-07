package com.leetcode.strings.easy;

// Given two binary strings a and b, return their sum as a binary string.
//
//
// Example 1:
// Input: a = "11", b = "1"
// Output: "100"
// Example 2:
// Input: a = "1010", b = "1011"
// Output: "10101"
//
//
// Constraints:
//
//
// 1 <= a.length, b.length <= 104
// a and b consist only of '0' or '1' characters.
// Each string does not contain leading zeros except for the zero itself.
//
// Related Topics Math String
// 👍 2408 👎 314
/*
 O(n) Runtime: 5 ms, faster than 20.65% of Java online submissions for Add Binary.
 O(n) Memory Usage: 39.3 MB, less than 20.89% of Java online submissions for Add Binary.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class AddBinary_67 {
  public String addBinary(String a, String b) {
    int aCurr = a.length() - 1;
    int bCurr = b.length() - 1;
    StringBuilder sb = new StringBuilder();

    int over = 0;

    while (aCurr >= 0 || bCurr >= 0) {
      int aChar = aCurr < 0 ? 0 : Character.getNumericValue(a.charAt(aCurr--));
      int bChar = bCurr < 0 ? 0 : Character.getNumericValue(b.charAt(bCurr--));

      int curr = aChar + bChar + over;

      over = curr / 2;
      curr = curr % 2;

      sb.append(curr);
    }

    if (over != 0) {
      sb.append(over);
    }

    return sb.reverse().toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
