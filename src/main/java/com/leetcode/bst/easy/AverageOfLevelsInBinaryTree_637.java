package com.leetcode.bst.easy;

// Given a non-empty binary tree, return the average value of the nodes on each l
// evel in the form of an array.
//
// Example 1:
//
// Input:
//    3
//   / \
//  9  20
//    /  \
//   15   7
// Output: [3, 14.5, 11]
// Explanation:
// The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level
// 2 is 11. Hence return [3, 14.5, 11].
//
//
//
// Note:
//
// The range of node's value is in the range of 32-bit signed integer.
//
// Related Topics Tree
// 👍 1459 👎 171

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class AverageOfLevelsInBinaryTree_637 {
  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      int levelSum = 0;

      for (int i = 0; i < size; i++) {
        TreeNode curr = queue.poll();

        if (curr.left != null) {
          queue.add(curr.left);
        }
        if (curr.right != null) {
          queue.add(curr.right);
        }
        levelSum += curr.val;
      }
      result.add((double) levelSum / size);
    }
    return result;
  }
}
/*
 O(n) Runtime: 2 ms, faster than 83.19% of Java online submissions for Average of Levels in Binary Tree.
 O(n) Memory Usage: 40.7 MB, less than 6.41% of Java online submissions for Average of Levels in Binary Tree.
*/
// leetcode submit region end(Prohibit modification and deletion)
