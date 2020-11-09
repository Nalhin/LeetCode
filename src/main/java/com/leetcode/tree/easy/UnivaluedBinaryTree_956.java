package com.leetcode.tree.easy;

// A binary tree is univalued if every node in the tree has the same value.
//
// Return true if and only if the given tree is univalued.
//
//
//
// Example 1:
//
//
// Input: [1,1,1,1,1,null,1]
// Output: true
//
//
//
// Example 2:
//
//
// Input: [2,2,2,5,2]
// Output: false
//
//
//
//
//
// Note:
//
//
// The number of nodes in the given tree will be in the range [1, 100].
// Each node's value will be an integer in the range [0, 99].
//
// Related Topics Tree
// 👍 668 👎 44

import com.leetcode.utils.BinaryTree.TreeNode;

// leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class UnivaluedBinaryTree_956 {
  public boolean isUnivalTree(TreeNode root) {
    return isUnivalDfs(root, root.val);
  }

  private boolean isUnivalDfs(TreeNode root, int val) {
    if (root == null) {
      return true;
    }

    if (root.val != val) {
      return false;
    }

    return isUnivalDfs(root.left, root.val) && isUnivalDfs(root.right, root.val);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
