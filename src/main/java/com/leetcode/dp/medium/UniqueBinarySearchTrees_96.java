package com.leetcode.dp.medium;

// Given n, how many structurally unique BST's (binary search trees) that store v
// alues 1 ... n?
//
// Example:
//
//
// Input: 3
// Output: 5
// Explanation:
// Given n = 3, there are a total of 5 unique BST's:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
//
//
//
// Constraints:
//
//
// 1 <= n <= 19
//
// Related Topics Dynamic Programming Tree
// 👍 4115 👎 151
/*
 O(n^2) Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
 O(n^2) Memory Usage: 35.7 MB, less than 48.67% of Java online submissions for Unique Binary Search Trees.
*/
// leetcode submit region begin(Prohibit modification and deletion)
public class UniqueBinarySearchTrees_96 {
  public int numTrees(int n) {
    int[][] dp = new int[n + 1][n + 1];
    return dpDfs(dp, 0, n);
  }

  private int dpDfs(int[][] dp, int first, int last) {
    if (last <= first) {
      return 1;
    }

    if (dp[first][last] > 0) {
      return dp[first][last];
    }

    int sum = 0;
    for (int mid = first; mid < last; mid++) {
      dp[first][mid] = dpDfs(dp, first, mid);
      dp[mid + 1][last] = dpDfs(dp, mid + 1, last);
      sum += dp[first][mid] * dp[mid + 1][last];
    }
    return sum;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
