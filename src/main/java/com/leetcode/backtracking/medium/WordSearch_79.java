package com.leetcode.backtracking.medium;

// Given an m x n grid of characters board and a string word, return true if
// word exists in the grid.
//
// The word can be constructed from letters of sequentially adjacent cells,
// where adjacent cells are horizontally or vertically neighboring. The same letter
// cell may not be used more than once.
//
//
// Example 1:
//
//
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCCED"
// Output: true
//
//
// Example 2:
//
//
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "SEE"
// Output: true
//
//
// Example 3:
//
//
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
// "ABCB"
// Output: false
//
//
//
// Constraints:
//
//
// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board and word consists of only lowercase and uppercase English letters.
//
//
//
// Follow up: Could you use search pruning to make your solution faster with a
// larger board?
// Related Topics Array Backtracking Matrix 👍 7281 👎 279
/*
 O(n*m*3^w) Runtime: 113 ms, faster than 60.87% of Java online submissions for Word Search.
 O(n*m) Memory Usage: 37.2 MB, less than 61.89% of Java online submissions for Word Search.
*/
// leetcode submit region begin(Prohibit modification and deletion)

public class WordSearch_79 {
  private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

  public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (word.charAt(0) == board[i][j]) {
          boolean[][] visited = new boolean[board.length][board[0].length];
          visited[i][j] = true;
          if (backtrack(i, j, 1, word, visited, board)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean backtrack(
      int currX, int currY, int currWordPos, String word, boolean[][] visited, char[][] board) {
    if (currWordPos >= word.length()) {
      return true;
    }

    for (int[] direction : DIRECTIONS) {
      int newX = currX + direction[0];
      int newY = currY + direction[1];

      if (newX >= 0
          && newX < board.length
          && newY >= 0
          && newY < board[0].length
          && !visited[newX][newY]
          && word.charAt(currWordPos) == board[newX][newY]) {
        visited[newX][newY] = true;

        if (backtrack(newX, newY, currWordPos + 1, word, visited, board)) {
          return true;
        }

        visited[newX][newY] = false;
      }
    }
    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
