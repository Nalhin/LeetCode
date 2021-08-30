package com.leetcode.arrays.easy;

// You are given an m x n matrix M initialized with all 0's and an array of
// operations ops, where ops[i] = [ai, bi] means M[x][y] should be incremented by one
// for all 0 <= x < ai and 0 <= y < bi.
//
// Count and return the number of maximum integers in the matrix after
// performing all the operations.
//
//
// Example 1:
//
//
// Input: m = 3, n = 3, ops = [[2,2],[3,3]]
// Output: 4
// Explanation: The maximum integer in M is 2, and there are four of it in M. So
// return 4.
//
//
// Example 2:
//
//
// Input: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2
// ,2],[3,3],[3,3],[3,3]]
// Output: 4
//
//
// Example 3:
//
//
// Input: m = 3, n = 3, ops = []
// Output: 9
//
//
//
// Constraints:
//
//
// 1 <= m, n <= 4 * 10⁴
// 1 <= ops.length <= 10⁴
// ops[i].length == 2
// 1 <= ai <= m
// 1 <= bi <= ns
//
// Related Topics Array Math 👍 485 👎 689
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Range Addition II.
 O(1) Memory Usage: 39.2 MB, less than 31.34% of Java online submissions for Range Addition II.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class RangeAdditionII_598 {
  public int maxCount(int m, int n, int[][] ops) {
    int firstRow = m;
    int firstCol = n;

    for (int[] op : ops) {
      firstRow = Math.min(firstRow, op[0]);
      firstCol = Math.min(firstCol, op[1]);
    }

    return firstRow * firstCol;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
