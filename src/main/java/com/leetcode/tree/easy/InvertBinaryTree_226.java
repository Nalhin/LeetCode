package com.leetcode.tree.easy;

// Invert a binary tree.
//
// Example:
//
// Input:
//
//
//     4
//   /   \
//  2     7
// / \   / \
// 1   3 6   9
//
// Output:
//
//
//     4
//   /   \
//  7     2
// / \   / \
// 9   6 3   1
//
// Trivia:
// This problem was inspired by this original tweet by Max Howell:
//
// Google: 90% of our engineers use the software you wrote (Homebrew), but you c
// an’t invert a binary tree on a whiteboard so f*** off.
// Related Topics Tree
// 👍 4017 👎 66

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class InvertBinaryTree_226 {
  static class Recursive {
    public TreeNode invertTree(TreeNode root) {
      if (root == null) {
        return null;
      }

      TreeNode left = root.left;
      TreeNode right = root.right;
      invertTree(left);
      invertTree(right);
      root.left = right;
      root.right = left;
      return root;
    }
  }
  /*
    O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
    O(h) Memory Usage: 36.2 MB, less than 16.12% of Java online submissions for Invert Binary Tree.
  */

  static class Iterative {

    public TreeNode invertTree(TreeNode root) {
      if (root == null) {
        return null;
      }

      Deque<TreeNode> stack = new ArrayDeque<>();
      stack.push(root);

      while (!stack.isEmpty()) {
        TreeNode node = stack.pop();

        if (node.right != null) {
          stack.push(node.right);
        }
        if (node.left != null) {
          stack.push(node.left);
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
      }
      return root;
    }
  }
  /*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
  O(h) Memory Usage: 36.1 MB, less than 16.12% of Java online submissions for Invert Binary Tree.
  */
}
// leetcode submit region end(Prohibit modification and deletion)
