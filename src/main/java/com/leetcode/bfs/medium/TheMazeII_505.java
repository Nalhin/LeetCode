package com.leetcode.bfs.medium;

// There is a ball in a maze with empty spaces (represented as 0) and walls (repr
// esented as 1). The ball can go through the empty spaces by rolling up, down, lef
// t or right, but it won't stop rolling until hitting a wall. When the ball stops,
// it could choose the next direction.
//
// Given the m x n maze, the ball's start position and the destination, where st
// art = [startrow, startcol] and destination = [destinationrow, destinationcol], r
// eturn the shortest distance for the ball to stop at the destination. If the ball
// cannot stop at destination, return -1.
//
// The distance is the number of empty spaces traveled by the ball from the star
// t position (excluded) to the destination (included).
//
// You may assume that the borders of the maze are all walls (see examples).
//
//
// Example 1:
//
//
// Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], s
// tart = [0,4], destination = [4,4]
// Output: 12
// Explanation: One possible way is : left -> down -> left -> down -> right -> do
// wn -> right.
// The length of the path is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.
//
//
// Example 2:
//
//
// Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], s
// tart = [0,4], destination = [3,2]
// Output: -1
// Explanation: There is no way for the ball to stop at the destination. Notice t
// hat you can pass through the destination but you cannot stop there.
//
//
// Example 3:
//
//
// Input: maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], s
// tart = [4,3], destination = [0,1]
// Output: -1
//
//
//
// Constraints:
//
//
// m == maze.length
// n == maze[i].length
// 1 <= m, n <= 100
// maze[i][j] is 0 or 1.
// start.length == 2
// destination.length == 2
// 0 <= startrow, destinationrow <= m
// 0 <= startcol, destinationcol <= n
// Both the ball and the destination exist in an empty space, and they will not
// be in the same position initially.
// The maze contains at least 2 empty spaces.
//
// Related Topics Depth-first Search Breadth-first Search
// 👍 771 👎 37
/*
 O(n * m * max(w,h)) Runtime: 14 ms, faster than 28.56% of Java online submissions for The Maze II.
 O(n * m) Memory Usage: 52.4 MB, less than 5.02% of Java online submissions for The Maze II.
*/
import java.util.*;

// leetcode submit region begin(Prohibit modification and deletion)
public class TheMazeII_505 {

  private static final int[][] possibleDirections = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

  public int shortestDistance(int[][] maze, int[] start, int[] destination) {

    Queue<PointWithStance> queue = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();

    queue.add(new PointWithStance(start[0], start[1], new int[] {-maze.length, -maze[0].length}));
    int dist = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        PointWithStance minDist = queue.remove();
        if (minDist.x == destination[0]
            && minDist.y == destination[1]
            && minDist.getStance(maze) == PointStances.STOPPED) {
          return dist;
        }

        if (minDist.getStance(maze) == PointStances.ROLLING) {
          queue.add(minDist.getNextRoll());
        } else {
          int encodedPoint = minDist.x * maze[0].length + minDist.y;
          if (visited.contains(encodedPoint)) {
            continue;
          }
          visited.add(encodedPoint);
          for (int[] direction : possibleDirections) {
            PointWithStance point = new PointWithStance(minDist.x, minDist.y, direction);
            if (point.getStance(maze) == PointStances.ROLLING) {
              queue.add(point.getNextRoll());
            }
          }
        }
      }
      dist++;
    }

    return -1;
  }

  private enum PointStances {
    STOPPED,
    ROLLING
  }

  private static class PointWithStance {
    private final int x;
    private final int y;
    private final int[] direction;

    public PointWithStance(int x, int y, int[] direction) {
      this.x = x;
      this.y = y;
      this.direction = direction;
    }

    private boolean canContinueRolling(int[][] maze) {
      int newX = x + direction[0];
      int newY = y + direction[1];
      if (newX < 0 || newX >= maze.length || newY < 0 || newY >= maze[0].length) {
        return false;
      }
      return maze[newX][newY] != 1;
    }

    public PointStances getStance(int[][] maze) {
      return canContinueRolling(maze) ? PointStances.ROLLING : PointStances.STOPPED;
    }

    public PointWithStance getNextRoll() {
      return new PointWithStance(x + direction[0], y + direction[1], direction);
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
