package com.leetcode.bfs.medium;

//You are given an m x n matrix maze (0-indexed) with empty cells (represented
//as '.') and walls (represented as '+'). You are also given the entrance of the
//maze, where entrance = [entrancerow, entrancecol] denotes the row and column of
//the cell you are initially standing at.
//
// In one step, you can move one cell up, down, left, or right. You cannot step
//into a cell with a wall, and you cannot step outside the maze. Your goal is to
//find the nearest exit from the entrance. An exit is defined as an empty cell
//that is at the border of the maze. The entrance does not count as an exit.
//
// Return the number of steps in the shortest path from the entrance to the
//nearest exit, or -1 if no such path exists.
//
//
// Example 1:
//
//
//Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]],
//entrance = [1,2]
//Output: 1
//Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
//Initially, you are at the entrance cell [1,2].
//- You can reach [1,0] by moving 2 steps left.
//- You can reach [0,2] by moving 1 step up.
//It is impossible to reach [2,3] from the entrance.
//Thus, the nearest exit is [0,2], which is 1 step away.
//
//
// Example 2:
//
//
//Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
//Output: 2
//Explanation: There is 1 exit in this maze at [1,2].
//[1,0] does not count as an exit since it is the entrance cell.
//Initially, you are at the entrance cell [1,0].
//- You can reach [1,2] by moving 2 steps right.
//Thus, the nearest exit is [1,2], which is 2 steps away.
//
//
// Example 3:
//
//
//Input: maze = [[".","+"]], entrance = [0,0]
//Output: -1
//Explanation: There are no exits in this maze.
//
//
//
// Constraints:
//
//
// maze.length == m
// maze[i].length == n
// 1 <= m, n <= 100
// maze[i][j] is either '.' or '+'.
// entrance.length == 2
// 0 <= entrancerow < m
// 0 <= entrancecol < n
// entrance will always be an empty cell.
//
//
// Related Topics Array Breadth-First Search Matrix 👍 1553 👎 56


import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
public class NearestExitFromEntranceInMaze_1926 {

  private final int[][] DX_DY = new int[][]{{1,0}, {0,1}, {-1, 0}, {0, -1}};

  public int nearestExit(char[][] maze, int[] entrance) {
    Queue<int[]> queue = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();

    queue.add(entrance);
    visited.add(entrance[0] * maze[0].length + entrance[1]);

    int distance = 0;

    while(!queue.isEmpty()) {

      int size = queue.size();

      for(int i = 0; i < size; i++) {
        int[] curr = queue.poll();

        if((curr[0] == maze.length - 1 || curr[0] == 0 || curr[1] == 0  || curr[1] == maze[0].length - 1)  && (curr[0] != entrance[0] || curr[1] != entrance[1])) {
          return distance;
        }


        for(int[] change : DX_DY) {
          int newRow = curr[0] + change[0];
          int newCol = curr[1] + change[1];

          int visitedNum = newRow * maze[0].length + newCol;

          if(newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length && maze[newRow][newCol] == '.' && !visited.contains(visitedNum)) {
            queue.add(new int[]{newRow, newCol});
            visited.add(visitedNum);
          }
        }
      }
      distance++;
    }

    return -1;
  }

}
//leetcode submit region end(Prohibit modification and deletion)
