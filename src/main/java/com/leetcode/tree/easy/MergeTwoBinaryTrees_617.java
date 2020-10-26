package com.leetcode.tree.easy;

// Given two binary trees and imagine that when you put one of them to cover the
// other, some nodes of the two trees are overlapped while the others are not.
//
// You need to merge them into a new binary tree. The merge rule is that if two
// nodes overlap, then sum node values up as the new value of the merged node. Othe
// rwise, the NOT null node will be used as the node of new tree.
//
// Example 1:
//
//
// Input:
//	Tree 1                     Tree 2
//          1                         2
//         / \                       / \
//        3   2                     1   3
//       /                           \   \
//      5                             4   7
// Output:
// Merged tree:
//	     3
//	    / \
//	   4   5
//	  / \   \
//	 5   4   7
//
//
//
//
// Note: The merging process must start from the root nodes of both trees.
// Related Topics Tree
// 👍 3536 👎 183

// leetcode submit region begin(Prohibit modification and deletion)
/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import com.leetcode.utils.BinaryTree.TreeNode;
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Binary Trees.
 O(h) Memory Usage: 39.1 MB, less than 12.39% of Java online submissions for Merge Two Binary Trees.
*/
public class MergeTwoBinaryTrees_617 {
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) {
      return null;
    }
    if (t1 == null) {
      return t2;
    }
    if (t2 == null) {
      return t1;
    }

    t1.left = mergeTrees(t1.left, t2.left);
    t1.right = mergeTrees(t1.right, t2.right);
    t1.val += t2.val;
    return t1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
