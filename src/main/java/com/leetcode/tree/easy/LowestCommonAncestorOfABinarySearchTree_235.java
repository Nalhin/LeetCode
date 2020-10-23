package com.leetcode.tree.easy;

// Given a binary search tree (BST), find the lowest common ancestor (LCA) of two
// given nodes in the BST.
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor
// is defined between two nodes p and q as the lowest node in T that has both p and
// q as descendants (where we allow a node to be a descendant of itself).”
//
//
// Example 1:
//
//
// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
// Output: 6
// Explanation: The LCA of nodes 2 and 8 is 6.
//
//
// Example 2:
//
//
// Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
// Output: 2
// Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant o
// f itself according to the LCA definition.
//
//
// Example 3:
//
//
// Input: root = [2,1], p = 2, q = 1
// Output: 2
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [2, 105].
// -109 <= Node.val <= 109
// All Node.val are unique.
// p != q
// p and q will exist in the BST.
//
// Related Topics Tree
// 👍 2453 👎 111

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
/*
 O(n) Runtime: 4 ms, faster than 57.79% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
 O(1) Memory Usage: 39.7 MB, less than 5.76% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
*/
public class LowestCommonAncestorOfABinarySearchTree_235 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode curr = root;

    while (curr.val != p.val || curr.val != q.val) {
      if (p.val > curr.val && q.val < curr.val) {
        return curr;
      }
      if (p.val < curr.val && q.val > curr.val) {
        return curr;
      }
      if (curr.val == q.val || curr.val == p.val) {
        return curr;
      }
      curr = curr.val > q.val ? curr.left : curr.right;
    }
    return null;
  }
}
