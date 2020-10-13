package com.leetcode.bst.easy;

// Given a binary tree and a sum, determine if the tree has a root-to-leaf path s
// uch that adding up all the values along the path equals the given sum.
//
// Note: A leaf is a node with no children.
//
// Example:
//
// Given the below binary tree and sum = 22,
//
//
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \      \
// 7    2      1
//
//
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
//
// Related Topics Tree Depth-first Search
// 👍 2365 👎 537

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class PathSum_112 {
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    return hasPathSumDfs(root, sum);
  }

  private boolean hasPathSumDfs(TreeNode root, int sum) {
    if (root.left == null && root.right == null) {
      return sum == root.val;
    }

    return (root.left != null && hasPathSumDfs(root.left, sum - root.val))
        || (root.right != null && hasPathSumDfs(root.right, sum - root.val));
  }
}
/*
 O(n)  Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
 O(1)  Memory Usage: 38.7 MB, less than 18.96% of Java online submissions for Path Sum.
*/
// leetcode submit region end(Prohibit modification and deletion)
