package com.leetcode.tree.medium;

//
// Given a binary tree, find the leftmost value in the last row of the tree.
//
//
// Example 1:
//
// Input:
//
//    2
//   / \
//  1   3
//
// Output:
// 1
//
//
//
// Example 2:
//
// Input:
//
//        1
//       / \
//      2   3
//     /   / \
//    4   5   6
//       /
//      7
//
// Output:
// 7
//
//
//
// Note:
// You may assume the tree (i.e., the given root node) is not NULL.
// Related Topics Tree Depth-first Search Breadth-first Search
// 👍 1131 👎 156

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Bottom Left Tree Value.
 O(1) Memory Usage: 38.6 MB, less than 73.05% of Java online submissions for Find Bottom Left Tree Value.
*/
public class FindBottomLeftTreeValue_513 {

  private int maxDepth = 0;
  private int mostLeft = 0;

  public int findBottomLeftValue(TreeNode root) {
    findBottomDfs(root, 1);

    return mostLeft;
  }

  private void findBottomDfs(TreeNode root, int depth) {
    if (root == null) {
      return;
    }

    if (maxDepth <= depth) {
      mostLeft = root.val;
      maxDepth = depth;
    }

    findBottomDfs(root.right, depth + 1);
    findBottomDfs(root.left, depth + 1);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
