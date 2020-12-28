package com.leetcode.math.medium;

//
// You are standing at position 0 on an infinite number line. There is a goal at
// position target.
//
// On each move, you can either go left or right. During the n-th move (starting
// from 1), you take n steps.
//
// Return the minimum number of steps required to reach the destination.
//
//
// Example 1:
//
// Input: target = 3
// Output: 2
// Explanation:
// On the first move we step from 0 to 1.
// On the second step we step from 1 to 3.
//
//
//
// Example 2:
//
// Input: target = 2
// Output: 3
// Explanation:
// On the first move we step from 0 to 1.
// On the second move we step  from 1 to -1.
// On the third move we step from -1 to 2.
//
//
//
// Note:
// target will be a non-zero integer in the range [-10^9, 10^9].
// Related Topics Math
// 👍 610 👎 464
/*
 O(sqrt(n)) Runtime: 1 ms, faster than 75.57% of Java online submissions for Reach a Number.
 O(1)       Memory Usage: 35.6 MB, less than 74.81% of Java online submissions for Reach a Number.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class ReachANumber_754 {
  public int reachNumber(int target) {
    int curr = Math.abs(target);
    int k = 0;
    while (curr > 0) {
      curr -= ++k;
    }

    if (curr % 2 == 0) {
      return k;
    }
    return k + 1 + k % 2;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
