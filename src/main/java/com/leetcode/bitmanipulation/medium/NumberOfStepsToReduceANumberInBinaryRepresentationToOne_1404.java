package com.leetcode.bitmanipulation.medium;

// Given a number s in their binary representation. Return the number of steps to
// reduce it to 1 under the following rules:
//
//
//
// If the current number is even, you have to divide it by 2.
//
//
// If the current number is odd, you have to add 1 to it.
//
//
//
// It's guaranteed that you can always reach to one for all testcases.
//
//
// Example 1:
//
//
// Input: s = "1101"
// Output: 6
// Explanation: "1101" corressponds to number 13 in their decimal representation.
//
// Step 1) 13 is odd, add 1 and obtain 14.
// Step 2) 14 is even, divide by 2 and obtain 7.
// Step 3) 7 is odd, add 1 and obtain 8.
// Step 4) 8 is even, divide by 2 and obtain 4.
// Step 5) 4 is even, divide by 2 and obtain 2.
// Step 6) 2 is even, divide by 2 and obtain 1.
//
//
// Example 2:
//
//
// Input: s = "10"
// Output: 1
// Explanation: "10" corressponds to number 2 in their decimal representation.
// Step 1) 2 is even, divide by 2 and obtain 1.
//
//
// Example 3:
//
//
// Input: s = "1"
// Output: 0
//
//
//
// Constraints:
//
//
// 1 <= s.length <= 500
// s consists of characters '0' or '1'
// s[0] == '1'
//
// Related Topics String Bit Manipulation
// 👍 267 👎 25

// leetcode submit region begin(Prohibit modification and deletion)
/*
   O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Steps to Reduce a Number in Binary Representation to One.
   O(1) Memory Usage: 36.6 MB, less than 95.58% of Java online submissions for Number of Steps to Reduce a Number in Binary Representation to One.
*/
public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne_1404 {
  public int numSteps(String s) {
    int result = 0;
    int take = 0;

    for (int i = s.length() - 1; i >= 1; i--) {
      int num = Character.getNumericValue(s.charAt(i));
      if ((num + take) % 2 == 0) {
        result += 1;
        take = (num + take) / 2;
      } else {
        take = 1;
        result += 2;
      }
    }
    return result + take;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
