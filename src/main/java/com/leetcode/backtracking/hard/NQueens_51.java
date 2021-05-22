package com.leetcode.backtracking.hard;

// The n-queens puzzle is the problem of placing n queens on an n x n chessboard
// such that no two queens attack each other.
//
// Given an integer n, return all distinct solutions to the n-queens puzzle.
//
// Each solution contains a distinct board configuration of the n-queens' placem
// ent, where 'Q' and '.' both indicate a queen and an empty space, respectively.
//
//
// Example 1:
//
//
// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as show
// n above
//
//
// Example 2:
//
//
// Input: n = 1
// Output: [["Q"]]
//
//
//
// Constraints:
//
//
// 1 <= n <= 9
//
// Related Topics Backtracking
// 👍 3164 👎 110
/*
 O(n!) Runtime: 5 ms, faster than 45.05% of Java online submissions for N-Queens.
 O(n^2) Memory Usage: 39.6 MB, less than 29.01% of Java online submissions for N-Queens.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens_51 {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<>();
    char[][] board = new char[n][n];

    for (char[] row : board) {
      Arrays.fill(row, '.');
    }

    placeBacktrack(0, n, new ArrayList<>(), board, result);

    return result;
  }

  private void placeBacktrack(
      int row, int n, List<int[]> queens, char[][] board, List<List<String>> result) {
    if (row >= n) {
      result.add(queensToString(board));
    }

    for (int i = 0; i < n; ++i) {
      if (!isFieldBlocked(row, i, queens)) {
        queens.add(new int[] {row, i});
        board[row][i] = 'Q';
        placeBacktrack(row + 1, n, queens, board, result);
        board[row][i] = '.';
        queens.remove(queens.size() - 1);
      }
    }
  }

  private boolean isFieldBlocked(int row, int col, List<int[]> queens) {
    for (int[] queen : queens) {
      if (queen[0] == row) {
        return true;
      }
      if (queen[1] == col) {
        return true;
      }
      if (Math.abs(queen[0] - row) == Math.abs(queen[1] - col)) {
        return true;
      }
    }
    return false;
  }

  private List<String> queensToString(char[][] board) {
    List<String> result = new ArrayList<>();
    for (char[] row : board) {
      result.add(new String(row));
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
