package com.leetcode.graph.medium;

// You are given a map of a server center, represented as a m * n integer matrix
// grid, where 1 means that on that cell there is a server and 0 means that it is n
// o server. Two servers are said to communicate if they are on the same row or on
// the same column.
//
// Return the number of servers that communicate with any other server.
//
//
// Example 1:
//
//
//
//
// Input: grid = [[1,0],[0,1]]
// Output: 0
// Explanation: No servers can communicate with others.
//
// Example 2:
//
//
//
//
// Input: grid = [[1,0],[1,1]]
// Output: 3
// Explanation: All three servers can communicate with at least one other server.
//
//
//
// Example 3:
//
//
//
//
// Input: grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
// Output: 4
// Explanation: The two servers in the first row can communicate with each other.
// The two servers in the third column can communicate with each other. The server
// at right bottom corner can't communicate with any other server.
//
//
//
// Constraints:
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m <= 250
// 1 <= n <= 250
// grid[i][j] == 0 or 1
//
// Related Topics Array Graph
// 👍 474 👎 43

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(m*n) Runtime: 2 ms, faster than 97.77% of Java online submissions for Count Servers that Communicate.
 O(m*n) Memory Usage: 45.6 MB, less than 93.64% of Java online submissions for Count Servers that Communicate.
*/
public class CountServersThatCommunicate_1267 {
  public int countServers(int[][] grid) {
    int rows = grid.length;
    int cols = grid[0].length;
    int[] visitedRows = new int[rows];
    int[] visitedCols = new int[cols];
    int result = 0;

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == 1) {
          visitedCols[col]++;
          visitedRows[row]++;
        }
      }
    }

    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        if (grid[row][col] == 1) {
          if (visitedCols[col] > 1 || visitedRows[row] > 1) {
            result++;
          }
        }
      }
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
