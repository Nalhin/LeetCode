package com.leetcode.tree.easy;

// Given two binary trees, write a function to check if they are the same or not.
//
//
// Two binary trees are considered the same if they are structurally identical a
// nd the nodes have the same value.
//
// Example 1:
//
//
// Input:     1         1
//          / \       / \
//         2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
// Output: true
//
//
// Example 2:
//
//
// Input:     1         1
//          /           \
//         2             2
//
//        [1,2],     [1,null,2]
//
// Output: false
//
//
// Example 3:
//
//
// Input:     1         1
//          / \       / \
//         2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
// Output: false
//
// Related Topics Tree Depth-first Search
// 👍 2593 👎 73

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */

// leetcode submit region end(Prohibit modification and deletion)
/*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
  O(h) Memory Usage: 36.2 MB, less than 10.18% of Java online submissions for Same Tree.
*/
public class SameTree_100 {
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }

    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
