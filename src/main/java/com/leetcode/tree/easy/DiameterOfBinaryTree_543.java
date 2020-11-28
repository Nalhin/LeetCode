package com.leetcode.tree.easy;

//
// Given a binary tree, you need to compute the length of the diameter of the tre
// e. The diameter of a binary tree is the length of the longest path between any t
// wo nodes in a tree. This path may or may not pass through the root.
//
//
//
// Example:
// Given a binary tree
//
//          1
//         / \
//        2   3
//       / \
//      4   5
//
//
//
// Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
//
//
// Note:
// The length of path between two nodes is represented by the number of edges bet
// ween them.
// Related Topics Tree
// 👍 3834 👎 227

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class DiameterOfBinaryTree_543 {
  private int result = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    depthDfs(root);
    return result;
  }

  public int depthDfs(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = depthDfs(root.left);
    int right = depthDfs(root.right);
    result = Math.max(result, left + right);
    return Math.max(left, right) + 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
