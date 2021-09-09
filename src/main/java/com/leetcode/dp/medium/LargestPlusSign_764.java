package com.leetcode.dp.medium;

// You are given an integer n. You have an n x n binary grid grid with all
// values initially 1's except for some indices given in the array mines. The iᵗʰ
// element of the array mines is defined as mines[i] = [xi, yi] where grid[xi][yi] == 0.
//
// Return the order of the largest axis-aligned plus sign of 1's contained in
// grid. If there is none, return 0.
//
// An axis-aligned plus sign of 1's of order k has some center grid[r][c] == 1
// along with four arms of length k - 1 going up, down, left, and right, and made
// of 1's. Note that there could be 0's or 1's beyond the arms of the plus sign,
// only the relevant area of the plus sign is checked for 1's.
//
//
// Example 1:
//
//
// Input: n = 5, mines = [[4,2]]
// Output: 2
// Explanation: In the above grid, the largest plus sign can only be of order 2.
// One of them is shown.
//
//
// Example 2:
//
//
// Input: n = 1, mines = [[0,0]]
// Output: 0
// Explanation: There is no plus sign, so return 0.
//
//
//
// Constraints:
//
//
// 1 <= n <= 500
// 1 <= mines.length <= 5000
// 0 <= xi, yi < n
// All the pairs (xi, yi) are unique.
//
// Related Topics Array Dynamic Programming 👍 746 👎 146
/*
 O(n^2) Runtime: 82 ms, faster than 49.10% of Java online submissions for Largest Plus Sign.
 O(n^2) Memory Usage: 81.8 MB, less than 8.30% of Java online submissions for Largest Plus Sign.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class LargestPlusSign_764 {
  public int orderOfLargestPlusSign(int n, int[][] mines) {
    if (mines.length <= 0 || mines.length >= n * n) {
      return 0;
    }

    boolean[][] hasMine = new boolean[n][n];
    for (int[] mine : mines) {
      hasMine[mine[0]][mine[1]] = true;
    }

    int[][] leftRows = new int[n][n];
    int[][] rightRows = new int[n][n];
    int[][] topCols = new int[n][n];
    int[][] bottomCols = new int[n][n];

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < n; j++) {
        leftRows[i][j] = hasMine[i - 1][j] ? 0 : leftRows[i - 1][j] + 1;
      }
    }

    for (int i = n - 2; i >= 0; i--) {
      for (int j = 0; j < n; j++) {
        rightRows[i][j] = hasMine[i + 1][j] ? 0 : rightRows[i + 1][j] + 1;
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 1; j < n; j++) {
        topCols[i][j] = hasMine[i][j - 1] ? 0 : topCols[i][j - 1] + 1;
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = n - 2; j >= 0; j--) {
        bottomCols[i][j] = hasMine[i][j + 1] ? 0 : bottomCols[i][j + 1] + 1;
      }
    }

    int result = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (!hasMine[i][j]) {
          int newValueRow = Math.min(leftRows[i][j], rightRows[i][j]);
          int newValueCol = Math.min(topCols[i][j], bottomCols[i][j]);
          result = Math.max(result, Math.min(newValueRow, newValueCol) + 1);
        }
      }
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
