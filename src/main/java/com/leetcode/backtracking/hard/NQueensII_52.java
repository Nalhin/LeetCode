package com.leetcode.backtracking.hard;

// The n-queens puzzle is the problem of placing n queens on an n x n chessboard
// such that no two queens attack each other.
//
// Given an integer n, return the number of distinct solutions to the n-queens p
// uzzle.
//
//
// Example 1:
//
//
// Input: n = 4
// Output: 2
// Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
//
//
//
// Example 2:
//
//
// Input: n = 1
// Output: 1
//
//
//
// Constraints:
//
//
// 1 <= n <= 9
//
// Related Topics Backtracking
// 👍 918 👎 189
/*
 O(n!) Runtime: 1 ms, faster than 87.64% of Java online submissions for N-Queens II.
 O(n) Memory Usage: 35.3 MB, less than 94.63% of Java online submissions for N-Queens II.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class NQueensII_52 {
  public int totalNQueens(int n) {
    return backtracking(n, 0, 0, 0, 0);
  }

  private int backtracking(int n, int currRow, int diagonals, int antiDiagonals, int cols) {

    if (currRow >= n) {
      return 1;
    }

    int result = 0;

    for (int currCol = 0; currCol < n; currCol++) {
      if (isPlacementValid(1 << currCol, cols)
          && isPlacementValid(1 << getDiagonal(currRow, currCol, n), diagonals)
          && isPlacementValid(1 << getAntiDiagonal(currRow, currCol), antiDiagonals)) {

        int newDiagonals = diagonals | (1 << getDiagonal(currRow, currCol, n));
        int newAntiDiagonals = antiDiagonals | (1 << getAntiDiagonal(currRow, currCol));
        int newCols = cols | (1 << currCol);
        result += backtracking(n, currRow + 1, newDiagonals, newAntiDiagonals, newCols);
      }
    }

    return result;
  }

  private boolean isPlacementValid(int currPosition, int positions) {
    return (currPosition & positions) == 0;
  }

  private int getDiagonal(int row, int col, int n) {
    return n + row - col;
  }

  private int getAntiDiagonal(int row, int col) {
    return row + col;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
