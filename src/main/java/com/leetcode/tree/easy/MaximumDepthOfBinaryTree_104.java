package com.leetcode.tree.easy;

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
  public int maxDepth(TreeNode root) {
    return maxDepthDfs(root, 0);
  }

  private int maxDepthDfs(TreeNode root, int depth){
    if(root == null){
      return depth;
    }

    return Math.max(maxDepthDfs(root.right, depth + 1), maxDepthDfs(root.left, depth + 1));
  }
}

/*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
  O(h) Memory Usage: 39.4 MB, less than 76.08% of Java online submissions for Maximum Depth of Binary Tree.
*/
// leetcode submit region end(Prohibit modification and deletion)
