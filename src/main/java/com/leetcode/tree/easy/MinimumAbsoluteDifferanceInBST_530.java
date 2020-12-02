package com.leetcode.tree.easy;

// Given a binary search tree with non-negative values, find the minimum absolute
// difference between values of any two nodes.
//
// Example:
//
//
// Input:
//
//   1
//    \
//     3
//    /
//   2
//
// Output:
// 1
//
// Explanation:
// The minimum absolute difference is 1, which is the difference between 2 and 1
// (or between 2 and 3).
//
//
//
//
// Note:
//
//
// There are at least two nodes in this BST.
// This question is the same as 783: https://leetcode.com/problems/minimum-dista
// nce-between-bst-nodes/
//
// Related Topics Tree
// 👍 1044 👎 78

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Absolute Difference in BST.
 O(h) Memory Usage: 38.4 MB, less than 89.03% of Java online submissions for Minimum Absolute Difference in BST.
*/
public class MinimumAbsoluteDifferanceInBST_530 {

  private int prev = -1;
  private int min = Integer.MAX_VALUE;

  public int getMinimumDifference(TreeNode root) {
    minDfs(root);
    return min;
  }

  private void minDfs(TreeNode root) {
    if (root == null) {
      return;
    }

    minDfs(root.left);
    if (prev >= 0) {
      min = Math.min(min, root.val - prev);
    }
    prev = root.val;
    minDfs(root.right);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
