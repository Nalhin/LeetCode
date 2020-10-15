package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree.TreeNode;

// Given the root of a binary tree, return the number of uni-value subtrees.
//
// A uni-value subtree means all nodes of the subtree have the same value.
//
//
// Example 1:
//
//
// Input: root = [5,1,5,5,5,null,5]
// Output: 4
//
//
// Example 2:
//
//
// Input: root = []
// Output: 0
//
//
// Example 3:
//
//
// Input: root = [5,5,5,5,5,null,5]
// Output: 6
//
//
//
// Constraints:
//
//
// The numbrt of the node in the tree will be in the range [0, 1000].
// -1000 <= Node.val <= 1000
//
// Related Topics Tree
// 👍 571 👎 152

// leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class CountUnivalueSubtrees_250 {
  private int sum = 0;

  public int countUnivalSubtrees(TreeNode root) {
    isUnival(root, 0);
    return sum;
  }

  public boolean isUnival(TreeNode root, int val) {
    if (root == null) {
      return true;
    }
    if (!isUnival(root.left, root.val) | !isUnival(root.right, root.val)) {
      return false;
    }
    sum++;
    return root.val == val;
  }
}
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Univalue Subtrees.
 O(nlog(n)) Memory Usage: 38.4 MB, less than 14.77% of Java online submissions for Count Univalue Subtrees
*/
// leetcode submit region end(Prohibit modification and deletion)
