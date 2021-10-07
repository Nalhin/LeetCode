package com.leetcode.math.hard;

// You are given an n x n binary grid board. In each move, you can swap any two
// rows with each other, or any two columns with each other.
//
// Return the minimum number of moves to transform the board into a chessboard
// board. If the task is impossible, return -1.
//
// A chessboard board is a board where no 0's and no 1's are 4-directionally
// adjacent.
//
//
// Example 1:
//
//
// Input: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
// Output: 2
// Explanation: One potential sequence of moves is shown.
// The first move swaps the first and second column.
// The second move swaps the second and third row.
//
//
// Example 2:
//
//
// Input: board = [[0,1],[1,0]]
// Output: 0
// Explanation: Also note that the board with 0 in the top left corner, is also
// a valid chessboard.
//
//
// Example 3:
//
//
// Input: board = [[1,0],[1,0]]
// Output: -1
// Explanation: No matter what sequence of moves you make, you cannot end with a
// valid chessboard.
//
//
//
// Constraints:
//
//
// n == board.length
// n == board[i].length
// 2 <= n <= 30
// board[i][j] is either 0 or 1.
//
// Related Topics Array Math Bit Manipulation Matrix 👍 264 👎 275
/*
 O(n^2) Runtime: 1 ms, faster than 98.61% of Java online submissions for Transform to Chessboard.
 O(1) Memory Usage: 38.6 MB, less than 61.88% of Java online submissions for Transform to Chessboard.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class TransformToChessboard_782 {
  public int movesToChessboard(int[][] board) {
    int n = board.length;

    int zeroesFirstRow = 0;
    int zeroesFirstCol = 0;
    int zeroesEvenCols = 0;
    int zeroesEvenRows = 0;

    for (int i = 0; i < n; i++) {
      if (board[i][0] == 0) {
        zeroesFirstCol++;
        if (i % 2 == 0) {
          zeroesEvenRows++;
        }
      }
      if (board[0][i] == 0) {
        zeroesFirstRow++;
        if (i % 2 == 0) {
          zeroesEvenCols++;
        }
      }
    }

    if (Math.abs(n - 2 * zeroesFirstRow) > 1) {
      return -1;
    }
    if (Math.abs(n - 2 * zeroesFirstCol) > 1) {
      return -1;
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < n; j++) {
        if ((board[0][0] == board[i][0]) ^ (board[0][j] == board[i][j])) {
          return -1;
        }
      }
    }

    if (n % 2 == 0) {
      return Math.min(zeroesEvenRows, n / 2 - zeroesEvenRows)
          + Math.min(zeroesEvenCols, n / 2 - zeroesEvenCols);
    }

    int totalZeroes =
        board[0][0] == 0
            ? zeroesFirstRow * zeroesFirstCol + (n - zeroesFirstRow) * (n - zeroesFirstCol)
            : zeroesFirstRow * (n - zeroesFirstCol) + (n - zeroesFirstRow) * zeroesFirstCol;

    int rowSwaps = zeroesFirstCol * 2 > n ? (n + 1) / 2 - zeroesEvenRows : zeroesEvenRows;
    if (zeroesFirstCol * 2 > n) {
      if (board[0][0] == 1) {
        zeroesEvenCols = (n + 1) / 2 - zeroesEvenCols;
      }
    } else {
      if (board[0][0] == 0) {
        zeroesEvenCols = (n + 1) / 2 - zeroesEvenCols;
      }
    }

    return rowSwaps + (totalZeroes * 2 > n * n ? (n + 1) / 2 - zeroesEvenCols : zeroesEvenCols);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
