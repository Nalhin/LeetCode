package com.leetcode.arrays.medium;

// There is a ball in a maze with empty spaces (represented as 0) and walls (repr
// esented as 1). The ball can go through the empty spaces by rolling up, down, lef
// t or right, but it won't stop rolling until hitting a wall. When the ball stops,
// it could choose the next direction.
//
// Given the maze, the ball's start position and the destination, where start =
// [startrow, startcol] and destination = [destinationrow, destinationcol], return
// true if the ball can stop at the destination, otherwise return false.
//
// You may assume that the borders of the maze are all walls (see examples).
//
//
// Example 1:
//
//
// Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], s
// tart = [0,4], destination = [4,4]
// Output: true
// Explanation: One possible way is : left -> down -> left -> down -> right -> do
// wn -> right.
//
//
// Example 2:
//
//
// Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], s
// tart = [0,4], destination = [3,2]
// Output: false
// Explanation: There is no way for the ball to stop at the destination. Notice t
// hat you can pass through the destination but you cannot stop there.
//
//
// Example 3:
//
//
// Input: maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], s
// tart = [4,3], destination = [0,1]
// Output: false
//
//
//
// Constraints:
//
//
// 1 <= maze.length, maze[i].length <= 100
// maze[i][j] is 0 or 1.
// start.length == 2
// destination.length == 2
// 0 <= startrow, destinationrow <= maze.length
// 0 <= startcol, destinationcol <= maze[i].length
// Both the ball and the destination exist on an empty space, and they will not
// be at the same position initially.
// The maze contains at least 2 empty spaces.
//
// Related Topics Depth-first Search Breadth-first Search
// 👍 897 👎 98

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;
/*
 O(mn) Runtime: 4 ms, faster than 64.55% of Java online submissions for The Maze.
 O(mn)  Memory Usage: 39.9 MB, less than 6.24% of Java online submissions for The Maze.
*/
public class TheMaze_490 {
  private final int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
  private final int NOT_VISITED = 0;
  private final int VISITED = 2;
  private final int WALL = 1;

  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    int maxX = maze.length;
    int maxY = maze[0].length;

    Deque<int[]> queue = new ArrayDeque<>();
    queue.add(start);
    while (!queue.isEmpty()) {
      int[] topPos = queue.remove();

      for (int[] dir : directions) {
        int newX = topPos[0];
        int newY = topPos[1];

        while (newX >= 0
            && newX < maxX
            && newY >= 0
            && newY < maxY
            && maze[newX][newY] != WALL) {
          newX += dir[0];
          newY += dir[1];
        }
        newX -= dir[0];
        newY -= dir[1];

        if (newX == destination[0] && newY == destination[1]) {
          return true;
        }

        if (newX >= 0
            && newX < maxX
            && newY >= 0
            && newY < maxY
            && maze[newX][newY] == NOT_VISITED) {
          queue.add(new int[] {newX, newY});
          maze[newX][newY] = VISITED;
        }
      }
    }
    return false;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
