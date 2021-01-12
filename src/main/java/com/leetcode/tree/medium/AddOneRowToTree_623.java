package com.leetcode.tree.medium;

// Given the root of a binary tree, then value v and depth d, you need to add a r
// ow of nodes with value v at the given depth d. The root node is at depth 1.
//
// The adding rule is: given a positive integer depth d, for each NOT null tree
// nodes N in depth d-1, create two tree nodes with value v as N's left subtree roo
// t and right subtree root. And N's original left subtree should be the left subtr
// ee of the new left subtree root, its original right subtree should be the right
// subtree of the new right subtree root. If depth d is 1 that means there is no de
// pth d-1 at all, then create a tree node with value v as the new root of the whol
// e original tree, and the original tree is the new root's left subtree.
//
// Example 1:
//
// Input:
// A binary tree as following:
//       4
//     /   \
//    2     6
//   / \   /
//  3   1 5
//
// v = 1
//
// d = 2
//
// Output:
//       4
//      / \
//     1   1
//    /     \
//   2       6
//  / \     /
// 3   1   5
//
//
//
//
//
// Example 2:
//
// Input:
// A binary tree as following:
//      4
//     /
//    2
//   / \
//  3   1
//
// v = 1
//
// d = 3
//
// Output:
//      4
//     /
//    2
//   / \
//  1   1
// /     \
// 3       1
//
//
//
// Note:
//
// The given d is in range [1, maximum depth of the given tree + 1].
// The given binary tree has at least one tree node.
//
// Related Topics Tree
// 👍 548 👎 137

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Add One Row to Tree.
 O(h) Memory Usage: 39.3 MB, less than 19.96% of Java online submissions for Add One Row to Tree.
*/
public class AddOneRowToTree_623 {
  public TreeNode addOneRow(TreeNode root, int v, int d) {
    if (d == 1) {
      return new TreeNode(v, root, null);
    }
    return addRowDfs(root, v, d - 1);
  }

  private TreeNode addRowDfs(TreeNode root, int v, int targetDepth) {
    if (root == null) {
      return null;
    }

    if (targetDepth <= 0) {
      return root;
    }

    if (targetDepth == 1) {
      root.left = new TreeNode(v, addRowDfs(root.left, v, 0), null);
      root.right = new TreeNode(v, null, addRowDfs(root.right, v, 0));
    } else {
      root.left = addRowDfs(root.left, v, targetDepth - 1);
      root.right = addRowDfs(root.right, v, targetDepth - 1);
    }

    return root;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
