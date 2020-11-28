package com.leetcode.tree.easy;

// Given a binary tree, check whether it is a mirror of itself (ie, symmetric aro
// und its center).
//
// For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//
//    1
//   / \
//  2   2
// / \ / \
// 3  4 4  3
//
//
//
//
// But the following [1,2,2,null,3,null,3] is not:
//
//
//    1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// Follow up: Solve it both recursively and iteratively.
// Related Topics Tree Depth-first Search Breadth-first Search
// 👍 4835 👎 114

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.Stack;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class SymmetricTree_101 {
  static class Recursive {
    public boolean isSymmetric(TreeNode root) {
      if (root == null) {
        return true;
      }
      return isSymmetricDfs(root.left, root.right) && isSymmetricDfs(root.right, root.left);
    }

    private boolean isSymmetricDfs(TreeNode root, TreeNode corresponding) {
      if (root == null && corresponding == null) {
        return true;
      }
      if (corresponding == null || root == null) {
        return false;
      }
      return root.val == corresponding.val
          && isSymmetricDfs(root.left, corresponding.right)
          && isSymmetricDfs(root.right, corresponding.left);
    }
  }
  /*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
  O(log(n)) Memory Usage: 37 MB, less than 14.44% of Java online submissions for Symmetric Tree.
  */

  static class Iterative {
    public boolean isSymmetric(TreeNode root) {
      if (root == null || (root.left == null && root.right == null)) {
        return true;
      }
      Stack<TreeNode> stack = new Stack<>();
      stack.push(root.right);
      stack.push(root.left);
      stack.push(root.left);
      stack.push(root.right);

      while (stack.size() >= 2) {
        TreeNode node = stack.pop();
        TreeNode corresponding = stack.pop();

        if (node == null && corresponding == null) {
          continue;
        }

        if (node == null || corresponding == null) {
          return false;
        }

        if (node.val != corresponding.val) {
          return false;
        }

        stack.push(corresponding.right);
        stack.push(node.left);
        stack.push(corresponding.left);
        stack.push(node.right);
      }

      return true;
    }
  }
  /*
   O(n)  Runtime: 1 ms, faster than 32.65% of Java online submissions for Symmetric Tree.
   O(h) Memory Usage: 38.4 MB, less than 14.44% of Java online submissions for Symmetric Tree.
  */
}
// leetcode submit region end(Prohibit modification and deletion)
