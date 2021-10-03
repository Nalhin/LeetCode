package com.leetcode.dp.hard;

// The demons had captured the princess and imprisoned her in the bottom-right
// corner of a dungeon. The dungeon consists of m x n rooms laid out in a 2D grid.
// Our valiant knight was initially positioned in the top-left room and must fight
// his way through dungeon to rescue the princess.
//
// The knight has an initial health point represented by a positive integer. If
// at any point his health point drops to 0 or below, he dies immediately.
//
// Some of the rooms are guarded by demons (represented by negative integers),
// so the knight loses health upon entering these rooms; other rooms are either
// empty (represented as 0) or contain magic orbs that increase the knight's health (
// represented by positive integers).
//
// To reach the princess as quickly as possible, the knight decides to move
// only rightward or downward in each step.
//
// Return the knight's minimum initial health so that he can rescue the
// princess.
//
// Note that any room can contain threats or power-ups, even the first room the
// knight enters and the bottom-right room where the princess is imprisoned.
//
//
// Example 1:
//
//
// Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
// Output: 7
// Explanation: The initial health of the knight must be at least 7 if he
// follows the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.
//
//
// Example 2:
//
//
// Input: dungeon = [[0]]
// Output: 1
//
//
//
// Constraints:
//
//
// m == dungeon.length
// n == dungeon[i].length
// 1 <= m, n <= 200
// -1000 <= dungeon[i][j] <= 1000
//
// Related Topics Array Dynamic Programming Matrix 👍 3323 👎 65
/*
 O(n*m) Runtime: 2 ms, faster than 65.93% of Java online submissions for Dungeon Game.
 O(n*m) Memory Usage: 38.8 MB, less than 56.87% of Java online submissions for Dungeon Game.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class DungeonGame_174 {

  private static final int MAX = 200 * 200 * 1001;

  public int calculateMinimumHP(int[][] dungeon) {
    int rows = dungeon.length;
    int cols = dungeon[0].length;

    int[][] dp = new int[rows][cols];

    for (int i = rows - 1; i >= 0; i--) {
      for (int j = cols - 1; j >= 0; j--) {

        if (i == rows - 1 && j == cols - 1) {
          dp[i][j] = (dungeon[i][j] < 0 ? -dungeon[i][j] : 0) + 1;
        } else {
          int left = i + 1 < rows ? dp[i + 1][j] : MAX;
          int right = j + 1 < cols ? dp[i][j + 1] : MAX;

          int max = Math.min(left, right);

          if (dungeon[i][j] < 0) {
            int minus = max - dungeon[i][j];
            dp[i][j] = minus <= 0 ? -minus + 1 : minus;
          } else {
            dp[i][j] = Math.max(max - dungeon[i][j], 1);
          }
        }
      }
    }

    return dp[0][0];
  }
}
// leetcode submit region end(Prohibit modification and deletion)
