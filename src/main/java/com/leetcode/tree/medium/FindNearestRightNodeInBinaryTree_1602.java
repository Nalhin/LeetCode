package com.leetcode.tree.medium;

// Given the root of a binary tree and a node u in the tree, return the nearest n
// ode on the same level that is to the right of u, or return null if u is the righ
// tmost node in its level.
//
//
// Example 1:
//
//
//
//
// Input: root = [1,2,3,null,4,5,6], u = 4
// Output: 5
// Explanation: The nearest node on the same level to the right of node 4 is node
// 5.
//
//
// Example 2:
//
//
//
//
// Input: root = [3,null,4,2], u = 2
// Output: null
// Explanation: There are no nodes to the right of 2.
//
//
// Example 3:
//
//
// Input: root = [1], u = 1
// Output: null
//
//
// Example 4:
//
//
// Input: root = [3,4,2,null,null,null,1], u = 4
// Output: 2
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 105].
// 1 <= Node.val <= 105
// All values in the tree are distinct.
// u is a node in the binary tree rooted at root.
//
// Related Topics Tree Breadth-first Search
// 👍 46 👎 1

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 7 ms, faster than 87.87% of Java online submissions for Find Nearest Right Node in Binary Tree.
 O(h) Memory Usage: 55.1 MB, less than 39.36% of Java online submissions for Find Nearest Right Node in Binary Tree.
*/
public class FindNearestRightNodeInBinaryTree_1602 {

  private TreeNode prev;
  private int prevLevel;
  private TreeNode ans;

  public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
    nearestDfs(root, u, 0);
    return ans;
  }

  private void nearestDfs(TreeNode root, TreeNode u, int level) {
    if (root == null) {
      return;
    }

    if (prev == u && level == prevLevel) {
      ans = root;
    }

    if (root == u) {
      prev = root;
      prevLevel = level;
    }

    nearestDfs(root.left, u, level + 1);
    nearestDfs(root.right, u, level + 1);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
