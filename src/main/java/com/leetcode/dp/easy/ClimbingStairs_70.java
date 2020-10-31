package com.leetcode.dp.easy;

// You are climbing a stair case. It takes n steps to reach to the top.
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can yo
// u climb to the top?
//
// Example 1:
//
//
// Input: 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps
//
//
// Example 2:
//
//
// Input: 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step
//
//
//
// Constraints:
//
//
// 1 <= n <= 45
//
// Related Topics Dynamic Programming
// 👍 5185 👎 167

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n)  Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
 O(1)  Memory Usage: 35.3 MB, less than 12.42% of Java online submissions for Climbing Stairs.
*/
public class ClimbingStairs_70 {
  public int climbStairs(int n) {
    if (n == 1) {
      return 1;
    }

    int prev = 2;
    int prevPrev = 1;

    for (int i = 3; i <= n; i++) {
      int temp = prev;
      prev = prev + prevPrev;
      prevPrev = temp;
    }

    return prev;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
