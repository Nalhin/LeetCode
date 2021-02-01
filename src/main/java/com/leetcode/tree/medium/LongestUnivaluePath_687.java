package com.leetcode.tree.medium;

// Given the root of a binary tree, return the length of the longest path, where
// each node in the path has the same value. This path may or may not pass through
// the root.
//
// The length of the path between two nodes is represented by the number of edge
// s between them.
//
//
// Example 1:
//
//
// Input: root = [5,4,5,1,1,5]
// Output: 2
//
//
// Example 2:
//
//
// Input: root = [1,4,5,4,4,5]
// Output: 2
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 104].
// -1000 <= Node.val <= 1000
// The depth of the tree will not exceed 1000.
//
// Related Topics Tree Recursion
// 👍 2142 👎 543

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 3 ms, faster than 29.78% of Java online submissions for Longest Univalue Path.
 O(h) Memory Usage: 63.7 MB, less than 9.80% of Java online submissions for Longest Univalue Path.
*/
public class LongestUnivaluePath_687 {
  private int max = 1;

  public int longestUnivaluePath(TreeNode root) {
    dfs(root);
    return max - 1;
  }

  private int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = dfs(root.left);
    int right = dfs(root.right);

    int result = Math.max(left + 1, right + 1);
    max = Math.max(Math.max(left + 1, right + 1), max);

    if (left != 0 && right != 0 && root.right.val == root.val && root.left.val == root.val) {
      max = Math.max(max, left + right + 1);
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
