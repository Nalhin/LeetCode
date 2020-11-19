package com.leetcode.tree.medium;

// Given a binary tree, find the length of the longest consecutive sequence path.
//
//
// The path refers to any sequence of nodes from some starting node to any node
// in the tree along the parent-child connections. The longest consecutive path nee
// d to be from parent to child (cannot be the reverse).
//
// Example 1:
//
//
// Input:
//
//   1
//    \
//     3
//    / \
//   2   4
//        \
//         5
//
// Output: 3
//
// Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
//
// Example 2:
//
//
// Input:
//
//   2
//    \
//     3
//    /
//   2
//  /
// 1
//
// Output: 2
//
// Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
// Related Topics Tree
// 👍 572 👎 136

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 1 ms, faster than 86.79% of Java online submissions for Binary Tree Longest Consecutive Sequence.
 O(h) Memory Usage: 40.4 MB, less than 39.42% of Java online submissions for Binary Tree Longest Consecutive Sequence.
*/
public class BinaryTreeLongestConsecutiveSequence_298 {
  public int longestConsecutive(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(dfs(root.left, root.val, 1), dfs(root.right, root.val, 1));
  }

  private int dfs(TreeNode root, int parentVal, int chainLength) {
    if (root == null) {
      return chainLength;
    }

    int curr = root.val == parentVal + 1 ? chainLength + 1 : 1;

    return Math.max(
        Math.max(dfs(root.left, root.val, curr), dfs(root.right, root.val, curr)), curr);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
