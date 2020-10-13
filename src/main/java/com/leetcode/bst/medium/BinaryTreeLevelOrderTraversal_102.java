package com.leetcode.bst.medium;
// Given a binary tree, return the level order traversal of its nodes' values. (i
// e, from left to right, level by level).
//
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
//
// return its level order traversal as:
//
// [
//  [3],
//  [9,20],
//  [15,7]
// ]
//
// Related Topics Tree Breadth-first Search
// 👍 3569 👎 88

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class BinaryTreeLevelOrderTraversal_102 {

  static class Iterative {
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();

      if (root == null) {
        return result;
      }

      Queue<TreeNode> queue = new ArrayDeque<>();
      queue.add(root);

      while (!queue.isEmpty()) {
        List<Integer> level = new ArrayList<>();

        int size = queue.size();

        for (int i = 0; i < size; i++) {
          TreeNode curr = queue.remove();
          level.add(curr.val);
          if (curr.left != null) {
            queue.add(curr.left);
          }
          if (curr.right != null) {
            queue.add(curr.right);
          }
        }
        result.add(level);
      }

      return result;
    }
  }
  /*
   O(n) Runtime: 1 ms, faster than 60.87% of Java online submissions for Binary Tree Level Order Traversal.
   O(n) Memory Usage: 39 MB, less than 15.02% of Java online submissions for Binary Tree Level Order Traversal.
  */

  static class Recursive {
    public List<List<Integer>> levelOrder(TreeNode root) {
      List<List<Integer>> result = new ArrayList<>();
      if (root == null) {
        return result;
      }
      levelOrderRec(root, result, 0);
      return result;
    }

    private void levelOrderRec(TreeNode curr, List<List<Integer>> result, int level) {
      if (result.size() <= level) {
        result.add(new ArrayList<>());
      }

      result.get(level).add(curr.val);

      if (curr.left != null) {
        levelOrderRec(curr.left, result, level + 1);
      }

      if (curr.right != null) {
        levelOrderRec(curr.right, result, level + 1);
      }
    }
  }
  /*
   O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal.
   O(n) Memory Usage: 38.9 MB, less than 15.02% of Java online submissions for Binary Tree Level Order Traversal.
  */
}

// leetcode submit region end(Prohibit modification and deletion)
