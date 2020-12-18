package com.leetcode.tree.medium;

// We are given the head node root of a binary tree, where additionally every nod
// e's value is either a 0 or a 1.
//
// Return the same tree where every subtree (of the given tree) not containing a
// 1 has been removed.
//
// (Recall that the subtree of a node X is X, plus every node that is a descenda
// nt of X.)
//
//
// Example 1:
// Input: [1,null,0,0,1]
// Output: [1,null,0,null,1]
//
// Explanation:
// Only the red nodes satisfy the property "every subtree not containing a 1".
// The diagram on the right represents the answer.
//
//
//
//
//
// Example 2:
// Input: [1,0,1,0,0,0,1]
// Output: [1,null,1,null,1]
//
//
//
//
//
//
// Example 3:
// Input: [1,1,0,1,1,0,1,0]
// Output: [1,1,0,1,1,null,1]
//
//
//
//
//
// Note:
//
//
// The binary tree will have at most 200 nodes.
// The value of each node will only be 0 or 1.
//
// Related Topics Tree
// 👍 1245 👎 50

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Pruning.
 O(h) Memory Usage: 38.5 MB, less than 5.92% of Java online submissions for Binary Tree Pruning.
*/
public class BinaryTreePruning_814 {
  public TreeNode pruneTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    root.left = pruneTree(root.left);
    root.right = pruneTree(root.right);

    if (root.right == null && root.left == null && root.val == 0) {
      return null;
    }
    return root;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
