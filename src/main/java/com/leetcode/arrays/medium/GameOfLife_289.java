package com.leetcode.arrays.medium;

// According to Wikipedia's article: "The Game of Life, also known simply as Life
// , is a cellular automaton devised by the British mathematician John Horton Conwa
// y in 1970."
//
// The board is made up of an m x n grid of cells, where each cell has an initia
// l state: live (represented by a 1) or dead (represented by a 0). Each cell inter
// acts with its eight neighbors (horizontal, vertical, diagonal) using the followi
// ng four rules (taken from the above Wikipedia article):
//
//
// Any live cell with fewer than two live neighbors dies as if caused by under-p
// opulation.
// Any live cell with two or three live neighbors lives on to the next generatio
// n.
// Any live cell with more than three live neighbors dies, as if by over-populat
// ion.
// Any dead cell with exactly three live neighbors becomes a live cell, as if by
// reproduction.
//
//
// The next state is created by applying the above rules simultaneously to every
// cell in the current state, where births and deaths occur simultaneously. Given
// the current state of the m x n grid board, return the next state.
//
//
// Example 1:
//
//
// Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
// Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
//
//
// Example 2:
//
//
// Input: board = [[1,1],[1,0]]
// Output: [[1,1],[1,1]]
//
//
//
// Constraints:
//
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 25
// board[i][j] is 0 or 1.
//
//
//
// Follow up:
//
//
// Could you solve it in-place? Remember that the board needs to be updated simu
// ltaneously: You cannot update some cells first and then use their updated values
// to update other cells.
// In this question, we represent the board using a 2D array. In principle, the
// board is infinite, which would cause problems when the active area encroaches up
// on the border of the array (i.e., live cells reach the border). How would you ad
// dress these problems?
//
// Related Topics Array
// 👍 2315 👎 318

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(m*n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Game of Life.
 O(m*n) Memory Usage: 37.6 MB, less than 22.10% of Java online submissions for Game of Life.
*/
public class GameOfLife_289 {

  private final int[][] neighbours =
      new int[][] {{0, 1}, {1, 0}, {1, 1}, {-1, -1}, {-1, 0}, {0, -1}, {1, -1}, {-1, 1}};

  public void gameOfLife(int[][] board) {
    int m = board.length;
    int n = board[0].length;
    int[][] nextBoard = new int[m][n];

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int count = 0;
        for (int[] neighbour : neighbours) {
          int newI = i + neighbour[0];
          int newJ = j + neighbour[1];
          if (newI >= 0 && newI < m && newJ >= 0 && newJ < n) {
            if (board[newI][newJ] == 1) {
              count++;
            }
          }
        }
        if (board[i][j] == 0 && count == 3) {
          nextBoard[i][j] = 1;
        }
        if (board[i][j] == 1 && (count == 2 || count == 3)) {
          nextBoard[i][j] = 1;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      System.arraycopy(nextBoard[i], 0, board[i], 0, n);
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
