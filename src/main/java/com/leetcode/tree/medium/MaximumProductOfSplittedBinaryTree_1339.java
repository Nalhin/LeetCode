package com.leetcode.tree.medium;

// Given the root of a binary tree, split the binary tree into two subtrees by
// removing one edge such that the product of the sums of the subtrees is maximized.
//
//
// Return the maximum product of the sums of the two subtrees. Since the answer
// may be too large, return it modulo 10⁹ + 7.
//
// Note that you need to maximize the answer before taking the mod and not
// after taking it.
//
//
// Example 1:
//
//
// Input: root = [1,2,3,4,5,6]
// Output: 110
// Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10.
// Their product is 110 (11*10)
//
//
// Example 2:
//
//
// Input: root = [1,null,2,3,4,null,null,5,6]
// Output: 90
// Explanation: Remove the red edge and get 2 binary trees with sum 15 and 6.
// Their product is 90 (15*6)
//
//
// Example 3:
//
//
// Input: root = [2,3,9,10,7,8,6,5,4,11,1]
// Output: 1025
//
//
// Example 4:
//
//
// Input: root = [1,1]
// Output: 1
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [2, 5 * 10⁴].
// 1 <= Node.val <= 10⁴
//
// Related Topics Tree Depth-First Search Binary Tree 👍 839 👎 47
/*
 O(n) Runtime: 8 ms, faster than 74.47% of Java online submissions for Maximum Product of Splitted Binary Tree.
 O(h) Memory Usage: 55.7 MB, less than 52.25% of Java online submissions for Maximum Product of Splitted Binary Tree.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class MaximumProductOfSplittedBinaryTree_1339 {

  private static final int MOD = 1_000_000_007;
  private long max = 0;

  public int maxProduct(TreeNode root) {
    long sum = sum(root);
    maxSum(root, sum);
    return (int) (max % MOD);
  }

  private long maxSum(TreeNode root, long sum) {
    if (root == null) {
      return 0;
    }

    long curr = maxSum(root.left, sum) + maxSum(root.right, sum) + root.val;
    max = Math.max(max, curr * (sum - curr));
    return curr;
  }

  private long sum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return sum(root.left) + sum(root.right) + root.val;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
