package com.leetcode.tree.easy;

// Given a binary tree, return the bottom-up level order traversal of its nodes'
// values. (ie, from left to right, level by level from leaf to root).
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
// return its bottom-up level order traversal as:
//
// [
//  [15,7],
//  [9,20],
//  [3]
// ]
//
// Related Topics Tree Breadth-first Search
// 👍 1780 👎 227

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal II.
 O(n) Memory Usage: 39 MB, less than 84.87% of Java online submissions for Binary Tree Level Order Traversal II.
*/
public class BinaryTreeLevelOrderTraversalII_107 {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    levelOrderDfs(root, 0, result);
    Collections.reverse(result);
    return result;
  }

  private void levelOrderDfs(TreeNode root, int depth, List<List<Integer>> result) {
    if (root == null) {
      return;
    }

    if (depth >= result.size()) {
      result.add(new ArrayList<>());
    }

    result.get(depth).add(root.val);

    levelOrderDfs(root.left, depth + 1, result);
    levelOrderDfs(root.right, depth + 1, result);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
