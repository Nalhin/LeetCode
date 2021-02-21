package com.leetcode.greedy.medium;

// On a broken calculator that has a number showing on its display, we can perfor
// m two operations:
//
//
// Double: Multiply the number on the display by 2, or;
// Decrement: Subtract 1 from the number on the display.
//
//
// Initially, the calculator is displaying the number X.
//
// Return the minimum number of operations needed to display the number Y.
//
//
//
// Example 1:
//
//
// Input: X = 2, Y = 3
// Output: 2
// Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
//
//
// Example 2:
//
//
// Input: X = 5, Y = 8
// Output: 2
// Explanation: Use decrement and then double {5 -> 4 -> 8}.
//
//
// Example 3:
//
//
// Input: X = 3, Y = 10
// Output: 3
// Explanation:  Use double, decrement and double {3 -> 6 -> 5 -> 10}.
//
//
// Example 4:
//
//
// Input: X = 1024, Y = 1
// Output: 1023
// Explanation: Use decrement operations 1023 times.
//
//
//
//
// Note:
//
//
// 1 <= X <= 10^9
// 1 <= Y <= 10^9
// Related Topics Math Greedy
// 👍 664 👎 106
/*
 O(log(target)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Broken Calculator.
 O(1) Memory Usage: 35.8 MB, less than 45.67% of Java online submissions for Broken Calculator.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class BrokenCalculator_991 {
  public int brokenCalc(int x, int target) {
    int curr = target;
    int operations = 0;
    while (curr > x) {
      if (curr % 2 == 1) {
        curr += 1;
      } else {
        curr /= 2;
      }
      operations++;
    }

    return operations + x - curr;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
