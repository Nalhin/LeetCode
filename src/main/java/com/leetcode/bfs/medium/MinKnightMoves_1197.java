package com.leetcode.bfs.medium;

// In an infinite chess board with coordinates from -infinity to +infinity, you h
// ave a knight at square [0, 0].
//
// A knight has 8 possible moves it can make, as illustrated below. Each move is
// two squares in a cardinal direction, then one square in an orthogonal direction
// .
//
//
//
// Return the minimum number of steps needed to move the knight to the square [x
// , y]. It is guaranteed the answer exists.
//
//
// Example 1:
//
//
// Input: x = 2, y = 1
// Output: 1
// Explanation: [0, 0] → [2, 1]
//
//
// Example 2:
//
//
// Input: x = 5, y = 5
// Output: 4
// Explanation: [0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
//
//
//
// Constraints:
//
//
// |x| + |y| <= 300
//
// Related Topics Breadth-first Search
// 👍 479 👎 200

// leetcode submit region begin(Prohibit modification and deletion)
/*
  Runtime: 746 ms, faster than 13.86% of Java online submissions for Minimum Knight Moves.
  Memory Usage: 48.5 MB, less than 50.95% of Java online submissions for Minimum Knight Moves.
*/
import java.util.*;

public class MinKnightMoves_1197 {
  private final int[][] KNIGHT_MOVES =
      new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

  public int minKnightMoves(int x, int y) {
    if (x == 0 && y == 0) {
      return 0;
    }
    x = Math.abs(x);
    y = Math.abs(y);

    Set<String> visited = new HashSet<>();

    Deque<int[]> deque = new ArrayDeque<>();
    int[] startPosition = new int[] {0, 0};
    deque.add(startPosition);
    visited.add(Arrays.toString(startPosition));

    int moves = 1;
    while (!deque.isEmpty()) {
      int size = deque.size();

      for (int i = 0; i < size; i++) {

        int[] position = deque.pop();

        for (int[] move : KNIGHT_MOVES) {
          int newX = position[0] + move[0];
          int newY = position[1] + move[1];

          if (newX == x && newY == y) {
            return moves;
          }

          int[] newPosition = {newX, newY};
          String strPosition = Arrays.toString(newPosition);

          if (!visited.contains(strPosition) && newX >= -1 && newY >= -1) {
            visited.add(strPosition);
            deque.add(newPosition);
          }
        }
      }
      moves++;
    }
    return -1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
