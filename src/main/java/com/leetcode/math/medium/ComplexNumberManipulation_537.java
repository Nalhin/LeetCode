package com.leetcode.math.medium;

// A complex number can be represented as a string on the form "real+imaginaryi"
// where:
//
//
// real is the real part and is an integer in the range [-100, 100].
// imaginary is the imaginary part and is an integer in the range [-100, 100].
// i2 == -1.
//
//
// Given two complex numbers num1 and num2 as strings, return a string of the co
// mplex number that represents their multiplications.
//
//
// Example 1:
//
//
// Input: num1 = "1+1i", num2 = "1+1i"
// Output: "0+2i"
// Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it
// to the form of 0+2i.
//
//
// Example 2:
//
//
// Input: num1 = "1+-1i", num2 = "1+-1i"
// Output: "0+-2i"
// Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it
// to the form of 0+-2i.
//
//
//
// Constraints:
//
//
// num1 and num2 are valid complex numbers.
//
// Related Topics Math String Simulation
// 👍 410 👎 991
/*
 O(1) Runtime: 7 ms, faster than 37.59% of Java online submissions for Complex Number Multiplication.
 O(1) Memory Usage: 37.6 MB, less than 46.35% of Java online submissions for Complex Number Multiplication.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class ComplexNumberManipulation_537 {
  public String complexNumberMultiply(String num1, String num2) {
    String[] firstParts = num1.split("\\+");
    int firstNum = Integer.parseInt(firstParts[0]);
    int firstI = Integer.parseInt(firstParts[1].replace("i", ""));

    String[] secondParts = num2.split("\\+");
    int secondNum = Integer.parseInt(secondParts[0]);
    int secondI = Integer.parseInt(secondParts[1].replace("i", ""));

    int firstFirst = firstNum * secondNum;
    int firstSecond = firstNum * secondI;
    int secondFirst = secondNum * firstI;
    int secondSecond = firstI * secondI;

    return String.format("%d+%di", firstFirst - secondSecond, firstSecond + secondFirst);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
