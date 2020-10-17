package com.leetcode.tree.medium;

// Given the root of a binary tree, return the inorder traversal of its nodes' va
// lues.
//
//
// Example 1:
//
//
// Input: root = [1,null,2,3]
// Output: [1,3,2]
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
// Related Topics Hash Table Stack Tree
// 👍 3715 👎 155

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class BinaryTreeInorderTraversal_94 {

  static class Iterative {

    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      Deque<TreeNode> stack = new ArrayDeque<>();

      TreeNode curr = root;

      while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
          stack.push(curr);
          curr = curr.left;
        }
        curr = stack.pop();
        result.add(curr.val);
        curr = curr.right;
      }

      return result;
    }
  }
  /*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
  O(n) Memory Usage: 37.1 MB, less than 6.96% of Java online submissions for Binary Tree Inorder Travers
  */

  static class Recursive {

    public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      inorderTraversalDfs(root, result);
      return result;
    }

    private void inorderTraversalDfs(TreeNode root, List<Integer> result) {
      if (root == null) {
        return;
      }
      inorderTraversalDfs(root.left, result);
      result.add(root.val);
      inorderTraversalDfs(root.right, result);
    }
  }
  /*
  O(n)  Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
  O(n) Memory Usage: 37.3 MB, less than 6.87% of Java online submissions for Binary Tree Inorder Traversal.
   */
}

// leetcode submit region end(Prohibit modification and deletion)
