package com.leetcode.tree.medium;

// Given a binary tree root, a ZigZag path for a binary tree is defined as follow
// :
//
//
// Choose any node in the binary tree and a direction (right or left).
// If the current direction is right then move to the right child of the current
// node otherwise move to the left child.
// Change the direction from right to left or right to left.
// Repeat the second and third step until you can't move in the tree.
//
//
// Zigzag length is defined as the number of nodes visited - 1. (A single node h
// as a length of 0).
//
// Return the longest ZigZag path contained in that tree.
//
//
// Example 1:
//
//
//
//
// Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
// Output: 3
// Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
//
//
// Example 2:
//
//
//
//
// Input: root = [1,1,1,null,1,null,null,1,1,null,1]
// Output: 4
// Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right
// ).
//
//
// Example 3:
//
//
// Input: root = [1]
// Output: 0
//
//
//
// Constraints:
//
//
// Each tree has at most 50000 nodes..
// Each node's value is between [1, 100].
// Related Topics Dynamic Programming Tree
// 👍 482 👎 10

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 7 ms, faster than 49.40% of Java online submissions for Longest ZigZag Path in a Binary Tree.
 O(h) Memory Usage: 73.8 MB, less than 19.76% of Java online submissions for Longest ZigZag Path in a Binary Tree.
*/
public class LongestZigZagPathInABinaryTree_1372 {
  private int result = 0;

  public int longestZigZag(TreeNode root) {
    result = Math.max(dfs(root.left, true) + 1, result);
    result = Math.max(dfs(root.right, false) + 1, result);

    return result;
  }

  private int dfs(TreeNode root, boolean wasLeft) {
    if (root == null) {
      return -1;
    }

    if (wasLeft) {
      result = Math.max(dfs(root.left, true) + 1, result);
      return dfs(root.right, false) + 1;
    }

    result = Math.max(dfs(root.right, false) + 1, result);
    return dfs(root.left, true) + 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
