package com.leetcode.dp.medium;

// Alice and Bob take turns playing a game, with Alice starting first.
//
// There are n stones arranged in a row. On each player's turn, they can remove
// either the leftmost stone or the rightmost stone from the row and receive points
// equal to the sum of the remaining stones' values in the row. The winner is the
// one with the higher score when there are no stones left to remove.
//
// Bob found that he will always lose this game (poor Bob, he always loses), so
// he decided to minimize the score's difference. Alice's goal is to maximize the d
// ifference in the score.
//
// Given an array of integers stones where stones[i] represents the value of the
// ith stone from the left, return the difference in Alice and Bob's score if they
// both play optimally.
//
//
// Example 1:
//
//
// Input: stones = [5,3,1,4,2]
// Output: 6
// Explanation:
// - Alice removes 2 and gets 5 + 3 + 1 + 4 = 13 points. Alice = 13, Bob = 0, sto
// nes = [5,3,1,4].
// - Bob removes 5 and gets 3 + 1 + 4 = 8 points. Alice = 13, Bob = 8, stones = [
// 3,1,4].
// - Alice removes 3 and gets 1 + 4 = 5 points. Alice = 18, Bob = 8, stones = [1,
// 4].
// - Bob removes 1 and gets 4 points. Alice = 18, Bob = 12, stones = [4].
// - Alice removes 4 and gets 0 points. Alice = 18, Bob = 12, stones = [].
// The score difference is 18 - 12 = 6.
//
//
// Example 2:
//
//
// Input: stones = [7,90,5,1,100,10,10,2]
// Output: 122
//
//
// Constraints:
//
//
// n == stones.length
// 2 <= n <= 1000
// 1 <= stones[i] <= 1000
//
// Related Topics Dynamic Programming
// 👍 281 👎 75

// leetcode submit region begin(Prohibit modification and deletion)

public class StoneGameVII_1690 {
  /*
  O(n^2) Runtime: 422 ms, faster than 10.51% of Java online submissions for Stone Game VII.
  O(n^2) Memory Usage: 121.6 MB, less than 5.06% of Java online submissions for Stone Game VII.
  */
  static class MinMax {
    public int stoneGameVII(int[] stones) {
      Integer[][] memo = new Integer[stones.length][stones.length];

      int[] stonesPrefix = new int[stones.length + 1];
      for (int i = 0; i < stonesPrefix.length - 1; i++) {
        stonesPrefix[i + 1] = stonesPrefix[i] + stones[i];
      }

      return dfs(memo, stonesPrefix, 0, stones.length - 1);
    }

    private int dfs(Integer[][] memo, int[] stonesPrefix, int left, int right) {
      if (left > right) {
        return 0;
      }

      if (memo[left][right] != null) {
        return memo[left][right];
      }

      boolean isAlice = (left + stonesPrefix.length - right) % 2 == 0;

      if (isAlice) {
        memo[left][right] =
            Math.max(
                dfs(memo, stonesPrefix, left, right - 1)
                    + getStonesSum(left, right - 1, stonesPrefix),
                dfs(memo, stonesPrefix, left + 1, right)
                    + getStonesSum(left + 1, right, stonesPrefix));
      } else {
        memo[left][right] =
            Math.min(
                dfs(memo, stonesPrefix, left, right - 1)
                    - getStonesSum(left, right - 1, stonesPrefix),
                dfs(memo, stonesPrefix, left + 1, right)
                    - getStonesSum(left + 1, right, stonesPrefix));
      }

      return memo[left][right];
    }

    private int getStonesSum(int left, int right, int[] stonesPrefix) {
      return stonesPrefix[right + 1] - stonesPrefix[left];
    }
  }
  /*
   O(n^2) Runtime: 45 ms, faster than 72.76% of Java online submissions for Stone Game VII.
   O(n^2) Memory Usage: 47.3 MB, less than 54.86% of Java online submissions for Stone Game VII.
  */
  static class Dp {

    public int stoneGameVII(int[] stones) {
      int[][] dp = new int[stones.length][stones.length];

      int[] stonesPrefix = new int[stones.length + 1];
      for (int i = 0; i < stonesPrefix.length - 1; i++) {
        stonesPrefix[i + 1] = stonesPrefix[i] + stones[i];
      }

      for (int left = stones.length - 2; left >= 0; left--) {
        for (int right = left + 1; right < stones.length; right++) {
          dp[left][right] =
              Math.max(
                  getStonesSum(left, right - 1, stonesPrefix) - dp[left][right - 1],
                  getStonesSum(left + 1, right, stonesPrefix) - dp[left + 1][right]);
        }
      }

      return dp[0][stones.length - 1];
    }

    private int getStonesSum(int left, int right, int[] stonesPrefix) {
      return stonesPrefix[right + 1] - stonesPrefix[left];
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
