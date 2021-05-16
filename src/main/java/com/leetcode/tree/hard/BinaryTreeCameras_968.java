package com.leetcode.tree.hard;

// Given a binary tree, we install cameras on the nodes of the tree.
//
// Each camera at a node can monitor its parent, itself, and its immediate child
// ren.
//
// Calculate the minimum number of cameras needed to monitor all nodes of the tr
// ee.
//
//
//
// Example 1:
//
//
//
// Input: [0,0,null,0,0]
// Output: 1
// Explanation: One camera is enough to monitor all nodes if placed as shown.
//
//
//
// Example 2:
//
//
// Input: [0,0,null,0,null,0,null,null,0]
// Output: 2
// Explanation: At least two cameras are needed to monitor all nodes of the tree.
// The above image shows one of the valid configurations of camera placement.
//
//
//
// Note:
//
//
// The number of nodes in the given tree will be in the range [1, 1000].
// Every node has value 0.
//
//
//
// Related Topics Dynamic Programming Tree Depth-first Search
// 👍 1427 👎 21

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Cameras.
 O(h) Memory Usage: 38.1 MB, less than 99.81% of Java online submissions for Binary Tree Cameras.
*/
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class BinaryTreeCameras_968 {
  private static final int MAX_NODES = 1000;

  public int minCameraCover(TreeNode root) {
    int[] result = dfs(root);
    return Math.min(result[1], result[2]);
  }

  private int[] dfs(TreeNode node) {
    if (node == null) {
      return new int[] {0, 0, MAX_NODES};
    }
    int[] left = dfs(node.left);
    int[] right = dfs(node.right);

    int minLeftCovered = Math.min(left[1], left[2]);
    int minRightCovered = Math.min(right[1], right[2]);

    int currNotCovered = left[1] + right[1];
    int currCoveredWithoutCamera = Math.min(left[2] + minRightCovered, right[2] + minLeftCovered);
    int currCoveredWithCamera =
        Math.min(left[0], minLeftCovered) + Math.min(right[0], minRightCovered) + 1;
    return new int[] {currNotCovered, currCoveredWithoutCamera, currCoveredWithCamera};
  }
}

// leetcode submit region end(Prohibit modification and deletion)
