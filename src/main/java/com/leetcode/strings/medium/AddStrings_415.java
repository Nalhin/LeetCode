package com.leetcode.strings.medium;

// Given two non-negative integers num1 and num2 represented as string, return th
// e sum of num1 and num2.
//
// Note:
//
// The length of both num1 and num2 is < 5100.
// Both num1 and num2 contains only digits 0-9.
// Both num1 and num2 does not contain any leading zero.
// You must not use any built-in BigInteger library or convert the inputs to int
// eger directly.
//
// Related Topics String
// 👍 1545 👎 361

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(max(n1,n2)) Runtime: 3 ms, faster than 45.80% of Java online submissions for Add Strings.
 O(max(n1,n2)) Memory Usage: 39.4 MB, less than 27.75% of Java online submissions for Add Strings.
*/
public class AddStrings_415 {
  public String addStrings(String num1, String num2) {
    StringBuilder sb = new StringBuilder();

    int carry = 0;
    for (int i = 0; i < Math.max(num1.length(), num2.length()); ++i) {
      int currNum1 = num1.length() - i - 1;
      int first = currNum1 >= 0 ? Character.getNumericValue(num1.charAt(currNum1)) : 0;
      int currNum2 = num2.length() - i - 1;
      int second = currNum2 >= 0 ? Character.getNumericValue(num2.charAt(currNum2)) : 0;
      int curr = first + second + carry;
      carry = curr / 10;
      sb.append(curr % 10);
    }

    if (carry > 0) {
      sb.append(carry);
    }

    return sb.reverse().toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
