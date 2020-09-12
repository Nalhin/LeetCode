package com.leetcode.easy;

// Given a binary tree, find its maximum depth.
//
// The maximum depth is the number of nodes along the longest path from the root
// node down to the farthest leaf node.
//
// Note: A leaf is a node with no children.
//
// Example:
//
// Given binary tree [3,9,20,null,null,15,7],
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
// return its depth = 3.
// Related Topics Tree Depth-first Search
// 👍 2826 👎 81

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class MaximumDepthOfBinaryTree_104 {
  int top = 0;

  public int maxDepth(TreeNode root) {
    if (root != null) {
      treeTraversal(root, 1);
    }
    return top;
  }

  private void treeTraversal(TreeNode node, int level) {
    if (node.left != null) {
      treeTraversal(node.left, level + 1);
    }
    if (node.right != null) {
      treeTraversal(node.right, level + 1);
    }

    if (node.right == null && node.left == null) {
      top = Math.max(level, top);
    }
  }
}

/*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
    Memory Usage: 39.4 MB, less than 76.08% of Java online submissions for Maximum Depth of Binary Tree.
*/
// leetcode submit region end(Prohibit modification and deletion)
