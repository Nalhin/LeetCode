package com.leetcode.tree.easy;

// Given a non-empty binary search tree and a target value, find the value in the
// BST that is closest to the target.
//
// Note:
//
//
// Given target value is a floating point.
// You are guaranteed to have only one unique value in the BST that is closest t
// o the target.
//
//
// Example:
//
//
// Input: root = [4,2,5,1,3], target = 3.714286
//
//    4
//   / \
//  2   5
// / \
// 1   3
//
// Output: 4
//
// Related Topics Binary Search Tree
// 👍 869 👎 66

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(h) Runtime: 0 ms, faster than 100.00% of Java online submissions for Closest Binary Search Tree Value.
 O(1) Memory Usage: 39.1 MB, less than 8.95% of Java online submissions for Closest Binary Search Tree Value.
*/
public class ClosestBinarySearchTreeValue_270 {
  public int closestValue(TreeNode root, double target) {
    int result = -1;
    double absResDiff = Double.MAX_VALUE;

    while (root != null) {
      double absDiff = Math.abs(root.val - target);
      if (absDiff < absResDiff) {
        result = root.val;
        absResDiff = absDiff;
      }
      if (root.val > target) {
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
