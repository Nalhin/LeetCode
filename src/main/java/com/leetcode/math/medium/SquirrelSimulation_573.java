package com.leetcode.math.medium;

// There's a tree, a squirrel, and several nuts. Positions are represented by the
// cells in a 2D grid. Your goal is to find the minimal distance for the squirrel
// to collect all the nuts and put them under the tree one by one. The squirrel can
// only take at most one nut at one time and can move in four directions - up, dow
// n, left and right, to the adjacent cell. The distance is represented by the numb
// er of moves.
// Example 1:
//
//
// Input:
// Height : 5
// Width : 7
// Tree position : [2,2]
// Squirrel : [4,4]
// Nuts : [[3,0], [2,5]]
// Output: 12
// Explanation:
// ​​​​​
//
//
// Note:
//
//
// All given positions won't overlap.
// The squirrel can take at most one nut at one time.
// The given positions of nuts have no order.
// Height and width are positive integers. 3 <= height * width <= 10,000.
// The given positions contain at least one nut, only one tree and one squirrel.
//
//
// Related Topics Math
// 👍 155 👎 24

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n) Runtime: 5 ms, faster than 7.78% of Java online submissions for Squirrel Simulation.
 O(1) Memory Usage: 39.3 MB, less than 48.89% of Java online submissions for Squirrel Simulation.
*/
public class SquirrelSimulation_573 {
  public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
    int result = 0;

    int distToRemove = Integer.MIN_VALUE;

    for (int[] nut : nuts) {
      int distFromTree = getDist(tree, nut) * 2;
      result += distFromTree;
      distToRemove = Math.max(distToRemove, getDist(nut, tree) - getDist(nut, squirrel));
    }

    return result - distToRemove;
  }

  private int getDist(int[] p1, int[] p2) {
    return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
