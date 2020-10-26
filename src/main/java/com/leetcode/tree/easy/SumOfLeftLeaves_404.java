package com.leetcode.tree.easy;

// Find the sum of all left leaves in a given binary tree.
//
// Example:
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
// There are two left leaves in the binary tree, with values 9 and 15 respectivel
// y. Return 24.
//
// Related Topics Tree
// 👍 1488 👎 147

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Left Leaves.
 O(h) Memory Usage: 36.7 MB, less than 10.76% of Java online submissions for Sum of Left Leaves.
*/
public class SumOfLeftLeaves_404 {
  public int sumOfLeftLeaves(TreeNode root) {
    return sumDfs(root, false);
  }

  private int sumDfs(TreeNode root, boolean isLeft) {
    if (root == null) {
      return 0;
    }
    if (isLeft && root.left == null && root.right == null) {
      return root.val;
    }

    return sumDfs(root.left, true) + sumDfs(root.right, false);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
