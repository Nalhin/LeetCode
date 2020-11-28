package com.leetcode.tree.easy;

// Given a binary tree, determine if it is height-balanced.
//
// For this problem, a height-balanced binary tree is defined as:
//
//
// a binary tree in which the left and right subtrees of every node differ in he
// ight by no more than 1.
//
//
//
// Example 1:
//
//
// Input: root = [3,9,20,null,null,15,7]
// Output: true
//
//
// Example 2:
//
//
// Input: root = [1,2,2,3,3,null,null,4,4]
// Output: false
//
//
// Example 3:
//
//
// Input: root = []
// Output: true
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 5000].
// -104 <= Node.val <= 104
//
// Related Topics Tree Depth-first Search
// 👍 2705 👎 186

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class BalancedBinaryTree_110 {
  public boolean isBalanced(TreeNode root) {
    return size(root, 0) != Integer.MAX_VALUE;
  }

  private int size(TreeNode root, int level) {
    if (root == null) {
      return level;
    }
    int left = size(root.left, level + 1);
    int right = size(root.right, level + 1);
    if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
      return Integer.MAX_VALUE;
    }
    return Math.max(left, right);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
