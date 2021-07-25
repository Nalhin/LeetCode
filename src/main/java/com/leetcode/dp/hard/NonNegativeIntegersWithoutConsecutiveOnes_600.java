package com.leetcode.dp.hard;

// Given a positive integer n, return the number of the integers in the range [0,
// n] whose binary representations do not contain consecutive ones.
//
//
// Example 1:
//
//
// Input: n = 5
// Output: 5
// Explanation:
// Here are the non-negative integers <= 5 with their corresponding binary repres
// entations:
// 0 : 0
// 1 : 1
// 2 : 10
// 3 : 11
// 4 : 100
// 5 : 101
// Among them, only integer 3 disobeys the rule (two consecutive ones) and the ot
// her 5 satisfy the rule.
//
//
// Example 2:
//
//
// Input: n = 1
// Output: 2
//
//
// Example 3:
//
//
// Input: n = 2
// Output: 3
//
//
//
// Constraints:
//
//
// 1 <= n <= 109
//
// Related Topics Dynamic Programming
// 👍 743 👎 90
/*
 O(log(n)) Runtime: 1 ms, faster than 94.85% of Java online submissions for Non-negative Integers without Consecutive Ones.
 O(log(n)) Memory Usage: 36.1 MB, less than 58.09% of Java online submissions for Non-negative Integers without Consecutive Ones.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class NonNegativeIntegersWithoutConsecutiveOnes_600 {
  private static final int MAX_NUMBER_OF_DIGITS = 31;

  public int findIntegers(int num) {
    int[] endingWithOneCount = new int[MAX_NUMBER_OF_DIGITS + 1];
    endingWithOneCount[0] = 1;
    endingWithOneCount[1] = 2;
    for (int i = 2; i < endingWithOneCount.length; i++) {
      endingWithOneCount[i] = endingWithOneCount[i - 1] + endingWithOneCount[i - 2];
    }

    int i = MAX_NUMBER_OF_DIGITS - 1;
    int result = 0;
    int prevBit = 0;

    while (i >= 0) {
      int currBit = (num & (1 << i)) == 0 ? 0 : 1;
      if (currBit == 1) {
        result += endingWithOneCount[i];
        if (prevBit == 1) {
          return result;
        }
      }
      prevBit = currBit;
      i--;
    }
    return result + 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
