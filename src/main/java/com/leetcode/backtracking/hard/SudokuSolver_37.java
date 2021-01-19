package com.leetcode.backtracking.hard;

import java.util.*;
/*
  O(9^(m*n)) Runtime: 16 ms, faster than 38.04% of Java online submissions for Sudoku Solver.
  O(m*n) Memory Usage: 39 MB, less than 7.52% of Java online submissions for Sudoku Solver.
*/
public class SudokuSolver_37 {
  private boolean solved = false;

  public void solveSudoku(char[][] board) {

    List<Set<Integer>> usedCols = new ArrayList<>();
    List<Set<Integer>> usedRows = new ArrayList<>();
    List<Set<Integer>> usedBoxes = new ArrayList<>();

    for (int i = 0; i < 9; i++) {
      usedCols.add(new HashSet<>());
      usedRows.add(new HashSet<>());
      usedBoxes.add(new HashSet<>());
    }

    for (int row = 0; row < board.length; ++row) {
      for (int col = 0; col < board[row].length; col++) {
        if (board[row][col] != '.') {
          addNum(usedCols, usedRows, usedBoxes, row, col, board[row][col] - '0');
        }
      }
    }

    solveDfs(usedCols, usedRows, usedBoxes, board, 0, 0);
  }

  private void solveDfs(
      List<Set<Integer>> usedCols,
      List<Set<Integer>> usedRows,
      List<Set<Integer>> usedBoxes,
      char[][] board,
      int row,
      int col) {

    if (col >= 9) {
      col = 0;
      row++;
    }

    if (row >= 9) {
      solved = true;
      return;
    }

    if (board[row][col] != '.') {
      solveDfs(usedCols, usedRows, usedBoxes, board, row, col + 1);
    } else {
      for (int i = 1; i <= 9; i++) {
        if (canAdd(usedCols, usedRows, usedBoxes, row, col, i)) {
          addNum(usedCols, usedRows, usedBoxes, row, col, i);
          board[row][col] = (char) (i + '0');
          solveDfs(usedCols, usedRows, usedBoxes, board, row, col + 1);
          if (!solved) {
            board[row][col] = '.';
            removeNum(usedCols, usedRows, usedBoxes, row, col, i);
          }
        }
      }
    }
  }

  private void addNum(
      List<Set<Integer>> usedCols,
      List<Set<Integer>> usedRows,
      List<Set<Integer>> usedBoxes,
      int row,
      int col,
      int num) {
    usedCols.get(col).add(num);
    usedRows.get(row).add(num);
    usedBoxes.get(col / 3 + (row / 3) * 3).add(num);
  }

  private boolean canAdd(
      List<Set<Integer>> usedCols,
      List<Set<Integer>> usedRows,
      List<Set<Integer>> usedBoxes,
      int row,
      int col,
      int num) {
    return !usedCols.get(col).contains(num)
        && !usedRows.get(row).contains(num)
        && !usedBoxes.get(col / 3 + (row / 3) * 3).contains(num);
  }

  private void removeNum(
      List<Set<Integer>> usedCols,
      List<Set<Integer>> usedRows,
      List<Set<Integer>> usedBoxes,
      int row,
      int col,
      int num) {
    usedCols.get(col).remove(num);
    usedRows.get(row).remove(num);
    usedBoxes.get(col / 3 + (row / 3) * 3).remove(num);
  }
}
