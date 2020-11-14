package com.leetcode.tree.medium;

// Given a binary tree containing digits from 0-9 only, each root-to-leaf path co
// uld represent a number.
//
// An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
//
// Find the total sum of all root-to-leaf numbers.
//
// Note: A leaf is a node with no children.
//
// Example:
//
//
// Input: [1,2,3]
//    1
//   / \
//  2   3
// Output: 25
// Explanation:
// The root-to-leaf path 1->2 represents the number 12.
// The root-to-leaf path 1->3 represents the number 13.
// Therefore, sum = 12 + 13 = 25.
//
// Example 2:
//
//
// Input: [4,9,0,5,1]
//    4
//   / \
//  9   0
//  / \
// 5   1
// Output: 1026
// Explanation:
// The root-to-leaf path 4->9->5 represents the number 495.
// The root-to-leaf path 4->9->1 represents the number 491.
// The root-to-leaf path 4->0 represents the number 40.
// Therefore, sum = 495 + 491 + 40 = 1026.
// Related Topics Tree Depth-first Search
// 👍 1852 👎 45

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum Root to Leaf Numbers.
 O(h) Memory Usage: 36.6 MB, less than 62.48% of Java online submissions for Sum Root to Leaf Numbers.
*/
public class SumRootToLeafNumbers_129 {
  public int sumNumbers(TreeNode root) {
    return sumDfs(root, 0);
  }

  private int sumDfs(TreeNode root, int prev) {
    if (root == null) {
      return 0;
    }

    int curr = prev * 10 + root.val;
    if (root.left == null && root.right == null) {
      return curr;
    }

    return sumDfs(root.left, curr) + sumDfs(root.right, curr);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
