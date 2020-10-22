package com.leetcode.tree.easy;

// Given a binary tree, find its minimum depth.
//
// The minimum depth is the number of nodes along the shortest path from the roo
// t node down to the nearest leaf node.
//
// Note: A leaf is a node with no children.
//
//
// Example 1:
//
//
// Input: root = [3,9,20,null,null,15,7]
// Output: 2
//
//
// Example 2:
//
//
// Input: root = [2,null,3,null,4,null,5,null,6]
// Output: 5
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 105].
// -1000 <= Node.val <= 1000
//
// Related Topics Tree Depth-first Search Breadth-first Search
// 👍 1780 👎 758

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 4 ms, faster than 12.33% of Java online submissions for Minimum Depth of Binary Tree.
 O(h) Memory Usage: 60 MB, less than 16.89% of Java online submissions for Minimum Depth of Binary Tree.
*/
public class MinimumDepthOfBinaryTree_111 {
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return minDepthDfs(root) + 1;
  }

  private int minDepthDfs(TreeNode root) {
    if (root.left == null && root.right == null) {
      return 0;
    }
    int result = Integer.MAX_VALUE;

    if (root.left != null) {
      result = Math.min(minDepthDfs(root.left) + 1, result);
    }
    if (root.right != null) {
      result = Math.min(minDepthDfs(root.right) + 1, result);
    }
    return result;
  }
}

// leetcode submit region end(Prohibit modification and deletion)
