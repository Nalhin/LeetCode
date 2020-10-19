package com.leetcode.tree.medium;

// Given a binary tree, determine if it is a valid binary search tree (BST).
//
// Assume a BST is defined as follows:
//
//
// The left subtree of a node contains only nodes with keys less than the node's
// key.
// The right subtree of a node contains only nodes with keys greater than the no
// de's key.
// Both the left and right subtrees must also be binary search trees.
//
//
//
//
// Example 1:
//
//
//    2
//   / \
//  1   3
//
// Input: [2,1,3]
// Output: true
//
//
// Example 2:
//
//
//    5
//   / \
//  1   4
//      / \
//     3   6
//
// Input: [5,1,4,null,null,3,6]
// Output: false
// Explanation: The root node's value is 5 but its right child's value is 4.
//
// Related Topics Tree Depth-first Search
// 👍 4651 👎 577

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class ValidateBinarySearchTree_98 {

  static class Iterative {
    public boolean isValidBST(TreeNode root) {
      if (root == null) {
        return true;
      }
      Deque<TreeNode> stack = new ArrayDeque<>();
      TreeNode curr = root;
      long prev = Long.MIN_VALUE;
      while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
          stack.push(curr);
          curr = curr.left;
        }
        curr = stack.pop();
        if (curr.val <= prev) {
          return false;
        }
        prev = curr.val;
        curr = curr.right;
      }
      return true;
    }
  }
  /*
   O(n) Runtime: 1 ms, faster than 37.41% of Java online submissions for Validate Binary Search Tree.
   O(h) Memory Usage: 38.7 MB, less than 8.48% of Java online submissions for Validate Binary Search Tree.
  */

  static class Recursive {

    public boolean isValidBST(TreeNode root) {
      return isValidBSTDfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTDfs(TreeNode root, long min, long max) {
      if (root == null) {
        return true;
      }

      if (root.val <= min || root.val >= max) {
        return false;
      }

      return isValidBSTDfs(root.left, min, root.val) && isValidBSTDfs(root.right, root.val, max);
    }
  }
  /*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
  O(h) Memory Usage: 38.8 MB, less than 8.48% of Java online submissions for Validate Binary Search Tre
  */
}
// leetcode submit region end(Prohibit modification and deletion)
