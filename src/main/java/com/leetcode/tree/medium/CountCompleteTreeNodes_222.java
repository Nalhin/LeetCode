package com.leetcode.tree.medium;

// Given a complete binary tree, count the number of nodes.
//
// Note:
//
// Definition of a complete binary tree from Wikipedia:
// In a complete binary tree every level, except possibly the last, is completely
// filled, and all nodes in the last level are as far left as possible. It can hav
// e between 1 and 2h nodes inclusive at the last level h.
//
// Example:
//
//
// Input:
//    1
//   / \
//  2   3
// / \  /
// 4  5 6
//
// Output: 6
// Related Topics Binary Search Tree
// 👍 2577 👎 242

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class CountCompleteTreeNodes_222 {
  /*
   O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Complete Tree Nodes.
   O(log(n)) Memory Usage: 41.3 MB, less than 79.68% of Java online submissions for Count Complete Tree Nodes.
  */
  public static class BruteForce {
    public int countNodes(TreeNode root) {
      if (root == null) {
        return 0;
      }

      return countNodes(root.left) + countNodes(root.right) + 1;
    }
  }
  /*
   O(log(n)^2) Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Complete Tree Nodes.
   O(log(n)) Memory Usage: 40.9 MB, less than 99.80% of Java online submissions for Count Complete Tree Nodes.
  */
  public static class DivideAndConquer {
    public int countNodes(TreeNode root) {
      if (root == null) {
        return 0;
      }
      int left = leftHeight(root.left);
      int right = leftHeight(root.right);
      if (left == right) {
        return countNodes(root.right) + (1 << left);
      }
      return countNodes(root.left) + (1 << right);
    }

    private int leftHeight(TreeNode node) {
      int height = 0;
      while (node != null) {
        height++;
        node = node.left;
      }
      return height;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
