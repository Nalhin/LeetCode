package com.leetcode.tree.easy;

// Given two non-empty binary trees s and t, check whether tree t has exactly the
// same structure and node values with a subtree of s. A subtree of s is a tree co
// nsists of a node in s and all of this node's descendants. The tree s could also
// be considered as a subtree of itself.
//
// Example 1:
// Given tree s:
//
//
//     3
//    / \
//   4   5
//  / \
// 1   2
//
// Given tree t:
//
//
//   4
//  / \
// 1   2
//
// Return true, because t has the same structure and node values with a subtree o
// f s.
//
//
//
// Example 2:
// Given tree s:
//
//
//     3
//    / \
//   4   5
//  / \
// 1   2
//    /
//   0
//
// Given tree t:
//
//
//   4
//  / \
// 1   2
//
// Return false.
//
//
// Related Topics Tree
// 👍 2951 👎 141

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
  O(n * m) Runtime: 5 ms, faster than 95.43% of Java online submissions for Subtree of Another Tree.
  O(n) Memory Usage: 39 MB, less than 84.28% of Java online submissions for Subtree of Another Tree.
*/
public class SubtreeOfAnotherTree_572 {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null) {
      return false;
    }

    if (s.val == t.val && isSubtreeEqual(s, t)) {
      return true;
    }

    return isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  private boolean isSubtreeEqual(TreeNode s, TreeNode t) {
    if (s == null && t == null) {
      return true;
    }

    if (s == null || t == null) {
      return false;
    }

    return s.val == t.val && isSubtreeEqual(s.left, t.left) && isSubtreeEqual(s.right, t.right);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
