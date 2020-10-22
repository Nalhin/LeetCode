package com.leetcode.tree.easy;

// Given the root node of a binary search tree (BST) and a value. You need to fin
// d the node in the BST that the node's value equals the given value. Return the s
// ubtree rooted with that node. If such node doesn't exist, you should return NULL
// .
//
// For example,
//
//
// Given the tree:
//        4
//       / \
//      2   7
//     / \
//    1   3
//
// And the value to search: 2
//
//
// You should return this subtree:
//
//
//      2
//     / \
//    1   3
//
//
// In the example above, if we want to search the value 5, since there is no nod
// e with value 5, we should return NULL.
//
// Note that an empty tree is represented by NULL, therefore you would see the e
// xpected output (serialized tree format) as [], not null.
// Related Topics Tree
// 👍 1054 👎 122

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class SearchInABinarySearchTree_700 {

  /*
    O(h) Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in a Binary Search Tree.
    O(1) Memory Usage: 39.6 MB, less than 14.29% of Java online submissions for Search in a Binary Search Tree.
  */
  static class Iterative {
    public TreeNode searchBST(TreeNode root, int val) {
      while (root != null) {
        if (root.val == val) {
          return root;
        } else if (root.val > val) {
          root = root.left;
        } else {
          root = root.right;
        }
      }
      return null;
    }
  }

  /*
   O(h)  Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in a Binary Search Tree.
   O(h)  Memory Usage: 39.7 MB, less than 13.32% of Java online submissions for Search in a Binary Search Tree.
  */
  static class Recursive {
    public TreeNode searchBST(TreeNode root, int val) {
      if (root == null || root.val == val) {
        return root;
      }
      if (root.val > val) {
        return searchBST(root.left, val);
      }
      return searchBST(root.right, val);
    }
  }
}

// leetcode submit region end(Prohibit modification and deletion)
