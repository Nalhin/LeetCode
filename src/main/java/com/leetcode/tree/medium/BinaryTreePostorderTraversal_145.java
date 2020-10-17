package com.leetcode.tree.medium;

// Given the root of a binary tree, return the postorder traversal of its nodes'
// values.
//
//
// Example 1:
//
//
// Input: root = [1,null,2,3]
// Output: [3,2,1]
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
// Output: [2,1]
//
//
// Example 5:
//
//
// Input: root = [1,null,2]
// Output: [2,1]
//
//
//
// Constraints:
//
//
// The number of the nodes in the tree is in the range [0, 100].
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
// 👍 2103 👎 104

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
public class BinaryTreePostorderTraversal_145 {
  static class Recursive {
    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      postorderTraversalDfs(root, result);
      return result;
    }

    private void postorderTraversalDfs(TreeNode root, List<Integer> result) {
      if (root == null) {
        return;
      }

      postorderTraversalDfs(root.left, result);
      postorderTraversalDfs(root.right, result);
      result.add(root.val);
    }
  }
  /*
   O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Postorder Traversal.
   O(n) Memory Usage: 37.1 MB, less than 6.80% of Java online submissions for Binary Tree Postorder Traversal.
  */
  static class Iterative {

    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) {
        return result;
      }
      TreeNode curr = root;
      Deque<TreeNode> stack = new ArrayDeque<>();
      while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
          if (curr.right != null) {
            stack.push(curr.right);
          }
          stack.push(curr);
          curr = curr.left;
        }
        TreeNode node = stack.pop();
        if (!stack.isEmpty() && node.right == stack.peek()) {
          curr = stack.pop();
          stack.push(node);
        } else {
          result.add(node.val);
        }
      }
      return result;
    }
  }
  /*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Postorder Traversal.
  O(n) Memory Usage: 37.5 MB, less than 6.80% of Java online submissions for Binary Tree Postorder Traversal.
  */
  static class IterativeDoublePush {

    public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      if (root == null) {
        return result;
      }
      Deque<TreeNode> stack = new ArrayDeque<>();
      stack.push(root);
      stack.push(root);
      while (!stack.isEmpty()) {
        TreeNode curr = stack.pop();
        if (!stack.isEmpty() && stack.peek() == curr) {
          if (curr.right != null) {
            stack.push(curr.right);
            stack.push(curr.right);
          }
          if (curr.left != null) {
            stack.push(curr.left);
            stack.push(curr.left);
          }
        } else {
          result.add(curr.val);
        }
      }
      return result;
    }
  }
  /*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Postorder Traversal.
  O(n) Memory Usage: 37.2 MB, less than 6.80% of Java online submissions for Binary Tree Postorder Traversal.
  */
}
// leetcode submit region end(Prohibit modification and deletion)
