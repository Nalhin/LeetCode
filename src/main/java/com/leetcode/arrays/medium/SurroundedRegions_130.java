package com.leetcode.arrays.medium;

// Given a 2D board containing 'X' and 'O' (the letter O), capture all regions su
// rrounded by 'X'.
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region
// .
//
// Example:
//
//
// X X X X
// X O O X
// X X O X
// X O X X
//
//
// After running your function, the board should be:
//
//
// X X X X
// X X X X
// X X X X
// X O X X
//
//
// Explanation:
//
// Surrounded regions shouldn’t be on the border, which means that any 'O' on th
// e border of the board are not flipped to 'X'. Any 'O' that is not on the border
// and it is not connected to an 'O' on the border will be flipped to 'X'. Two cell
// s are connected if they are adjacent cells connected horizontally or vertically.
//
// Related Topics Depth-first Search Breadth-first Search Union Find
// 👍 2302 👎 724

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n * m) Runtime: 6 ms, faster than 13.08% of Java online submissions for Surrounded Regions.
 O(n * m) Memory Usage: 42.7 MB, less than 14.95% of Java online submissions for Surrounded Regions.
*/
public class SurroundedRegions_130 {
  private final int[][] DXDY = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

  public void solve(char[][] board) {
    if (board.length == 0 || board[0].length == 0) {
      return;
    }
    int w = board.length;
    int h = board[0].length;
    int lastW = w - 1;
    int lastH = h - 1;

    Set<Integer> markedForRemoval = new HashSet<>();
    Deque<Integer> deque = new ArrayDeque<>();

    for (int i = 0; i < w; i++) {
      for (int j = 0; j < h; j++) {
        if (board[i][j] == 'O') {
          if (i == 0 || i == lastW || j == 0 || j == lastH) {
            deque.push(i * h + j);
          } else {
            markedForRemoval.add(i * h + j);
          }
        }
      }
    }

    while (!deque.isEmpty()) {
      int last = deque.pop();
      int x = last / h;
      int y = last % h;
      for (int[] inc : DXDY) {
        int newX = x + inc[0];
        int newY = y + inc[1];
        int newPoint = newX * h + newY;

        if (markedForRemoval.contains(newPoint)) {
          markedForRemoval.remove(newPoint);
          deque.push(newPoint);
        }
      }
    }
    for (int entry : markedForRemoval) {
      int x = entry / h;
      int y = entry % h;
      board[x][y] = 'X';
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
