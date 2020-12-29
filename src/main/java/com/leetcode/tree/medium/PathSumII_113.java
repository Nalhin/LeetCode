package com.leetcode.tree.medium;

// Given a binary tree and a sum, find all root-to-leaf paths where each path's s
// um equals the given sum.
//
// Note: A leaf is a node with no children.
//
// Example:
//
// Given the below binary tree and sum = 22,
//
//
//      5
//     / \
//    4   8
//   /   / \
//  11  13  4
// /  \    / \
// 7    2  5   1
//
//
// Return:
//
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
// ]
//
// Related Topics Tree Depth-first Search
// 👍 2387 👎 85

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n^2) Runtime: 1 ms, faster than 100.00% of Java online submissions for Path Sum II.
 O(n^2) Memory Usage: 39.5 MB, less than 57.68% of Java online submissions for Path Sum II.
*/
public class PathSumII_113 {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<>();
    pathSumDfs(root, sum, new ArrayList<>(), result);
    return result;
  }

  private void pathSumDfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
    if (root == null) {
      return;
    }

    path.add(root.val);

    if (root.left == null && root.right == null && sum == root.val) {
      result.add(new ArrayList<>(path));
    }

    pathSumDfs(root.left, sum - root.val, path, result);
    pathSumDfs(root.right, sum - root.val, path, result);

    path.remove(path.size() - 1);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
