package com.leetcode.hashtable.easy;

// Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be val
// idated according to the following rules:
//
//
// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without r
// epetition.
//
//
//
// A partially filled sudoku which is valid.
//
// The Sudoku board could be partially filled, where empty cells are filled with
// the character '.'.
//
// Example 1:
//
//
// Input:
// [
//  ["5","3",".",".","7",".",".",".","."],
//  ["6",".",".","1","9","5",".",".","."],
//  [".","9","8",".",".",".",".","6","."],
//  ["8",".",".",".","6",".",".",".","3"],
//  ["4",".",".","8",".","3",".",".","1"],
//  ["7",".",".",".","2",".",".",".","6"],
//  [".","6",".",".",".",".","2","8","."],
//  [".",".",".","4","1","9",".",".","5"],
//  [".",".",".",".","8",".",".","7","9"]
// ]
// Output: true
//
//
// Example 2:
//
//
// Input:
// [
//   ["8","3",".",".","7",".",".",".","."],
//   ["6",".",".","1","9","5",".",".","."],
//   [".","9","8",".",".",".",".","6","."],
//   ["8",".",".",".","6",".",".",".","3"],
//   ["4",".",".","8",".","3",".",".","1"],
//   ["7",".",".",".","2",".",".",".","6"],
//   [".","6",".",".",".",".","2","8","."],
//   [".",".",".","4","1","9",".",".","5"],
//   [".",".",".",".","8",".",".","7","9"]
// ]
// Output: false
// Explanation: Same as Example 1, except with the 5 in the top left corner being
//
//    modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is
// invalid.
//
//
// Note:
//
//
// A Sudoku board (partially filled) could be valid but is not necessarily solva
// ble.
// Only the filled cells need to be validated according to the mentioned rules.
//
// The given board contain only digits 1-9 and the character '.'.
// The given board size is always 9x9.
//
// Related Topics Hash Table
// 👍 1915 👎 481

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku_36 {
  public boolean isValidSudoku(char[][] board) {
    for (char[] chars : board) {
      Set<Character> rowValues = new HashSet<>();
      for (char aChar : chars) {
        if (aChar != '.' && !rowValues.add(aChar)) {
          return false;
        }
      }
    }

    for (int i = 0; i < board.length; i++) {
      Set<Character> columnValues = new HashSet<>();
      for (int j = 0; j < board[i].length; j++) {
        if (board[j][i] != '.' && !columnValues.add(board[j][i])) {
          return false;
        }
      }
    }

    List<Set<Character>> boxes = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
      boxes.add(new HashSet<>());
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        int index = (i / 3) * 3 + j / 3;
        if (board[i][j] != '.' && !boxes.get(index).add(board[i][j])) {
          return false;
        }
      }
    }

    return true;
  }
}
/*
O(n^2) Runtime: 2 ms, faster than 86.48% of Java online submissions for Valid Sudoku.
O(n^2) Memory Usage: 39.3 MB, less than 86.75% of Java online submissions for Valid Sudoku.
*/

// leetcode submit region end(Prohibit modification and deletion)
