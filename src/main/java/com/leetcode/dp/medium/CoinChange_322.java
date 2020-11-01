package com.leetcode.dp.medium;

// You are given coins of different denominations and a total amount of money amo
// unt. Write a function to compute the fewest number of coins that you need to mak
// e up that amount. If that amount of money cannot be made up by any combination o
// f the coins, return -1.
//
// You may assume that you have an infinite number of each kind of coin.
//
//
// Example 1:
//
//
// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
//
//
// Example 2:
//
//
// Input: coins = [2], amount = 3
// Output: -1
//
//
// Example 3:
//
//
// Input: coins = [1], amount = 0
// Output: 0
//
//
// Example 4:
//
//
// Input: coins = [1], amount = 1
// Output: 1
//
//
// Example 5:
//
//
// Input: coins = [1], amount = 2
// Output: 2
//
//
//
// Constraints:
//
//
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104
//
// Related Topics Dynamic Programming
// 👍 5251 👎 159

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.Arrays;
/*
 O(n*m) Runtime: 10 ms, faster than 95.50% of Java online submissions for Coin Change.
 O(n)  Memory Usage: 38.1 MB, less than 12.54% of Java online submissions for Coin Change.
*/
public class CoinChange_322 {
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);

    dp[0] = 0;

    for (int i = 1; i < dp.length; i++) {
      for (int coin : coins) {
        if (coin <= i) {
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
      }
    }
    int last = dp[amount];

    return last > amount ? -1 : last;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
