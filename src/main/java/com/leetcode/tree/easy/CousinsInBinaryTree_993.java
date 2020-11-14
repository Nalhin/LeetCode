package com.leetcode.tree.easy;

// In a binary tree, the root node is at depth 0, and children of each depth k no
// de are at depth k+1.
//
// Two nodes of a binary tree are cousins if they have the same depth, but have
// different parents.
//
// We are given the root of a binary tree with unique values, and the values x a
// nd y of two different nodes in the tree.
//
// Return true if and only if the nodes corresponding to the values x and y are
// cousins.
//
//
//
// Example 1:
//
//
//
// Input: root = [1,2,3,4], x = 4, y = 3
// Output: false
//
//
//
// Example 2:
//
//
//
// Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
// Output: true
//
//
//
// Example 3:
//
//
//
//
// Input: root = [1,2,3,null,4], x = 2, y = 3
// Output: false
//
//
//
//
//
// Constraints:
//
//
// The number of nodes in the tree will be between 2 and 100.
// Each node has a unique integer value from 1 to 100.
//
// Related Topics Tree Breadth-first Search
// 👍 1143 👎 62

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Cousins in Binary Tree.
 O(h) Memory Usage: 36.4 MB, less than 96.92% of Java online submissions for Cousins in Binary Tree
*/
public class CousinsInBinaryTree_993 {

  private TreeNode xParent;
  private TreeNode yParent;
  private int xDepth;
  private int yDepth;

  public boolean isCousins(TreeNode root, int x, int y) {
    if (root == null) {
      return false;
    }
    dfsCousins(root.left, root, x, y, 0);
    dfsCousins(root.right, root, x, y, 0);
    return xDepth == yDepth && xParent != yParent && xParent != null && yParent != null;
  }

  private void dfsCousins(TreeNode root, TreeNode parent, int x, int y, int depth) {
    if (root == null) {
      return;
    }

    if (root.val == x) {
      xDepth = depth;
      xParent = parent;
      return;
    }
    if (root.val == y) {
      yDepth = depth;
      yParent = parent;
      return;
    }

    dfsCousins(root.left, root, x, y, depth + 1);
    dfsCousins(root.right, root, x, y, depth + 1);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
