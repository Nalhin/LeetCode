package com.leetcode.bst.medium;

// Given the root of a binary tree, return the preorder traversal of its nodes' v
// alues.
//
//
// Example 1:
//
//
// Input: root = [1,null,2,3]
// Output: [1,2,3]
//
//
// Example 2:
//
//
// Input: root = []
// Output: []
//
//
// Example 3:
//
//
// Input: root = [1]
// Output: [1]
//
//
// Example 4:
//
//
// Input: root = [1,2]
// Output: [1,2]
//
//
// Example 5:
//
//
// Input: root = [1,null,2]
// Output: [1,2]
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
//
//
//
//
// Follow up:
//
// Recursive solution is trivial, could you do it iteratively?
//
//
// Related Topics Stack Tree
// 👍 1778 👎 66

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class BinaryTreePreorderTraversal_144 {

  static class Iterative {

    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) {
        return result;
      }

      Deque<TreeNode> stack = new ArrayDeque<>();
      stack.push(root);

      while (!stack.isEmpty()) {
        TreeNode curr = stack.pop();

        result.add(curr.val);

        if (curr.right != null) {
          stack.push(curr.right);
        }
        if (curr.left != null) {
          stack.push(curr.left);
        }
      }
      return result;
    }
    /*
    O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
    O(n) Memory Usage: 37.3 MB, less than 7.46% of Java online submissions for Binary Tree Preorder Traversal.
    */
  }

  static class Recursive {

    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      preorderDfs(root, result);
      return result;
    }

    private void preorderDfs(TreeNode root, List<Integer> result) {
      if (root == null) {
        return;
      }
      result.add(root.val);
      preorderDfs(root.left, result);
      preorderDfs(root.right, result);
    }

    /*
     O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
     O(n) Memory Usage: 37.2 MB, less than 7.46% of Java online submissions for Binary Tree Preorder Traversal.
    */
  }
}
// leetcode submit region end(Prohibit modification and deletion)
