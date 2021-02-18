package com.leetcode.bfs.hard;

// You are asked to cut off all the trees in a forest for a golf event. The fores
// t is represented as an m x n matrix. In this matrix:
//
//
// 0 means the cell cannot be walked through.
// 1 represents an empty cell that can be walked through.
// A number greater than 1 represents a tree in a cell that can be walked throug
// h, and this number is the tree's height.
//
//
// In one step, you can walk in any of the four directions: north, east, south,
// and west. If you are standing in a cell with a tree, you can choose whether to c
// ut it off.
//
// You must cut off the trees in order from shortest to tallest. When you cut of
// f a tree, the value at its cell becomes 1 (an empty cell).
//
// Starting from the point (0, 0), return the minimum steps you need to walk to
// cut off all the trees. If you cannot cut off all the trees, return -1.
//
// You are guaranteed that no two trees have the same height, and there is at le
// ast one tree needs to be cut off.
//
//
// Example 1:
//
//
// Input: forest = [[1,2,3],[0,0,4],[7,6,5]]
// Output: 6
// Explanation: Following the path above allows you to cut off the trees from sho
// rtest to tallest in 6 steps.
//
//
// Example 2:
//
//
// Input: forest = [[1,2,3],[0,0,0],[7,6,5]]
// Output: -1
// Explanation: The trees in the bottom row cannot be accessed as the middle row
// is blocked.
//
//
// Example 3:
//
//
// Input: forest = [[2,3,4],[0,0,5],[8,7,6]]
// Output: 6
// Explanation: You can follow the same path as Example 1 to cut off all the tree
// s.
// Note that you can cut off the first tree at (0, 0) before making any steps.
//
//
//
// Constraints:
//
//
// m == forest.length
// n == forest[i].length
// 1 <= m, n <= 50
// 0 <= forest[i][j] <= 109
//
// Related Topics Breadth-first Search
// 👍 640 👎 369

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(nm * log(nm) * nm) Runtime: 305 ms, faster than 48.55% of Java online submissions for Cut Off Trees for Golf Event.
 O(nm)      Memory Usage: 39.1 MB, less than 91.57% of Java online submissions for Cut Off Trees for Golf Event.
*/
import java.util.*;

public class CutOffTreesForGolfEvent_675 {
  public int cutOffTree(List<List<Integer>> forest) {
    List<Tree> trees = new ArrayList<>();

    for (int i = 0; i < forest.size(); i++) {
      List<Integer> row = forest.get(i);
      for (int j = 0; j < row.size(); j++) {
        if (row.get(j) != 0) {
          trees.add(new Tree(i, j, row.get(j)));
        }
      }
    }

    trees.sort(Comparator.comparingInt(Tree::getValue));
    int result = 0;

    int currRow = 0;
    int currCol = 0;
    for (Tree next : trees) {
      int dist = next.getDistance(currRow, currCol, forest);
      if (dist == -1) {
        return -1;
      }
      result += dist;
      currRow = next.getRow();
      currCol = next.getCol();
    }

    return result;
  }

  private static class Tree {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private final int value;
    private final int row;
    private final int col;

    public Tree(int row, int col, int value) {
      this.row = row;
      this.col = col;
      this.value = value;
    }

    public int getDistance(int fromRow, int fromCol, List<List<Integer>> forest) {
      int n = forest.size();
      int m = forest.get(0).size();
      Queue<int[]> queue = new ArrayDeque<>();
      queue.add(new int[] {fromRow, fromCol});

      boolean[][] visited = new boolean[n][m];
      visited[fromRow][fromCol] = true;

      int dist = 0;

      while (!queue.isEmpty()) {
        int size = queue.size();

        for (int i = 0; i < size; i++) {
          int[] prev = queue.remove();

          if (prev[0] == row && prev[1] == col) {
            return dist;
          }

          for (int[] dir : DIRECTIONS) {

            int newRow = prev[0] + dir[0];
            int newCol = prev[1] + dir[1];

            if (newRow >= 0
                && newRow < n
                && newCol >= 0
                && newCol < m
                && forest.get(newRow).get(newCol) != 0
                && !visited[newRow][newCol]) {
              queue.add(new int[] {newRow, newCol});
              visited[newRow][newCol] = true;
            }
          }
        }
        dist++;
      }
      return -1;
    }

    public int getValue() {
      return value;
    }

    public int getRow() {
      return row;
    }

    public int getCol() {
      return col;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
