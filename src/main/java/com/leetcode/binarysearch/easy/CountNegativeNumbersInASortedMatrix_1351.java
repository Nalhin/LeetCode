package com.leetcode.binarysearch.easy;

// Given a m * n matrix grid which is sorted in non-increasing order both row-wis
// e and column-wise.
//
// Return the number of negative numbers in grid.
//
//
// Example 1:
//
//
// Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
// Output: 8
// Explanation: There are 8 negatives number in the matrix.
//
//
// Example 2:
//
//
// Input: grid = [[3,2],[1,0]]
// Output: 0
//
//
// Example 3:
//
//
// Input: grid = [[1,-1],[-1,-1]]
// Output: 3
//
//
// Example 4:
//
//
// Input: grid = [[-1]]
// Output: 1
//
//
//
// Constraints:
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 100
// -100 <= grid[i][j] <= 100
// Related Topics Array Binary Search
// 👍 625 👎 40

// leetcode submit region begin(Prohibit modification and deletion)
/*
 O(n * log(m)) Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
 O(1) Memory Usage: 39.5 MB, less than 36.27% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
*/
public class CountNegativeNumbersInASortedMatrix_1351 {
  public int countNegatives(int[][] grid) {
    int ans = 0;

    for (int[] ints : grid) {
      int left = 0;
      int right = ints.length - 1;
      int firstNeg = ints.length;

      while (left <= right) {
        int mid = left + (right - left) / 2;
        int midVal = ints[mid];

        if (midVal < 0) {
          firstNeg = mid;
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      ans += ints.length - firstNeg;
    }
    return ans;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
