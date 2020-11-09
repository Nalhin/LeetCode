package com.leetcode.tree.medium;

// Given the root of a binary tree, find the maximum value V for which there exis
// t different nodes A and B where V = |A.val - B.val| and A is an ancestor of B.
//
// A node A is an ancestor of B if either: any child of A is equal to B, or any
// child of A is an ancestor of B.
//
//
// Example 1:
//
//
// Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]
// Output: 7
// Explanation: We have various ancestor-node differences, some of which are give
// n below :
// |8 - 3| = 5
// |3 - 7| = 4
// |8 - 1| = 7
// |10 - 13| = 3
// Among all possible differences, the maximum value of 7 is obtained by |8 - 1|
// = 7.
//
// Example 2:
//
//
// Input: root = [1,null,2,null,0,3]
// Output: 3
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [2, 5000].
// 0 <= Node.val <= 105
//
// Related Topics Tree Depth-first Search
// 👍 776 👎 33

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Difference Between Node and Ancestor.
 O(h) Memory Usage: 39.6 MB, less than 6.88% of Java online submissions for Maximum Difference Between Node and Ancestor.

*/
public class MaximumDifferenceBetweenNodeAndAncestor_1026 {
  public int maxAncestorDiff(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return maxDiffDfs(root, root.val, root.val);
  }

  private int maxDiffDfs(TreeNode root, int min, int max) {
    if (root == null) {
      return max - min;
    }
    max = Math.max(max, root.val);
    min = Math.min(min, root.val);
    return Math.max(maxDiffDfs(root.left, min, max), maxDiffDfs(root.right, min, max));
  }
}
