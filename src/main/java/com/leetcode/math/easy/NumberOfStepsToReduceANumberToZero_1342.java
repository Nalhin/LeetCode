package com.leetcode.math.easy;

// Given a non-negative integer num, return the number of steps to reduce it to z
// ero. If the current number is even, you have to divide it by 2, otherwise, you h
// ave to subtract 1 from it.
//
//
// Example 1:
//
//
// Input: num = 14
// Output: 6
// Explanation:
// Step 1) 14 is even; divide by 2 and obtain 7.
// Step 2) 7 is odd; subtract 1 and obtain 6.
// Step 3) 6 is even; divide by 2 and obtain 3.
// Step 4) 3 is odd; subtract 1 and obtain 2.
// Step 5) 2 is even; divide by 2 and obtain 1.
// Step 6) 1 is odd; subtract 1 and obtain 0.
//
//
// Example 2:
//
//
// Input: num = 8
// Output: 4
// Explanation:
// Step 1) 8 is even; divide by 2 and obtain 4.
// Step 2) 4 is even; divide by 2 and obtain 2.
// Step 3) 2 is even; divide by 2 and obtain 1.
// Step 4) 1 is odd; subtract 1 and obtain 0.
//
//
// Example 3:
//
//
// Input: num = 123
// Output: 12
//
//
//
// Constraints:
//
//
// 0 <= num <= 10^6
//
// Related Topics Bit Manipulation
// 👍 598 👎 62

// leetcode submit region begin(Prohibit modification and deletion)
/*
  O(log(n)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Steps to Reduce a Number to Zero.
  O(1)      Memory Usage: 35.7 MB, less than 58.45% of Java online submissions for Number of Steps to Reduce a Number to Zero.
*/
public class NumberOfStepsToReduceANumberToZero_1342 {
  public int numberOfSteps(int num) {
    if (num == 0) {
      return 0;
    }
    int steps = 0;
    while (num > 1) {
      steps += num % 2 == 0 ? 1 : 2;
      num /= 2;
    }
    return steps + 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
