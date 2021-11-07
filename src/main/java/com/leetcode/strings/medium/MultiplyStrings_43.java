package com.leetcode.strings.medium;

// Given two non-negative integers num1 and num2 represented as strings, return
// the product of num1 and num2, also represented as a string.
//
// Note: You must not use any built-in BigInteger library or convert the inputs
// to integer directly.
//
//
// Example 1:
// Input: num1 = "2", num2 = "3"
// Output: "6"
// Example 2:
// Input: num1 = "123", num2 = "456"
// Output: "56088"
//
//
// Constraints:
//
//
// 1 <= num1.length, num2.length <= 200
// num1 and num2 consist of digits only.
// Both num1 and num2 do not contain any leading zero, except the number 0
// itself.
//
// Related Topics Math String Simulation 👍 3480 👎 1368
/*
 O(n*m) Runtime: 2 ms, faster than 99.47% of Java online submissions for Multiply Strings.
 O(n+m) Memory Usage: 38.9 MB, less than 80.94% of Java online submissions for Multiply Strings.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class MultiplyStrings_43 {
  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }

    int[] result = new int[num1.length() + num2.length()];

    for (int i = 0; i < num1.length(); i++) {
      for (int j = 0; j < num2.length(); j++) {
        result[i + j + 1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
      }
    }

    int carry = 0;
    for (int i = result.length - 1; i >= 0; --i) {
      result[i] += carry;
      carry = result[i] / 10;
      result[i] %= 10;
    }

    int index = 0;

    while (index < result.length && result[index] == 0) {
      index++;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = index; i < result.length; i++) {
      sb.append(result[i]);
    }
    return sb.toString();
  }
}
// leetcode submit region end(Prohibit modification and deletion)
