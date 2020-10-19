package com.leetcode.tree.medium;

// Given a binary search tree and a node in it, find the in-order successor of th
// at node in the BST.
//
// The successor of a node p is the node with the smallest key greater than p.va
// l.
//
//
//
// Example 1:
//
//
// Input: root = [2,1,3], p = 1
// Output: 2
// Explanation: 1's in-order successor node is 2. Note that both p and the return
// value is of TreeNode type.
//
//
// Example 2:
//
//
// Input: root = [5,3,6,2,4,null,null,1], p = 6
// Output: null
// Explanation: There is no in-order successor of the current node, so the answer
// is null.
//
//
//
//
// Note:
//
//
// If the given node has no in-order successor in the tree, return null.
// It's guaranteed that the values of the tree are unique.
//
// Related Topics Tree
// 👍 1286 👎 64

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
public class InorderSuccessorInBST_285 {
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (p.right != null) {
      TreeNode curr = p.right;
      while (curr.left != null) {
        curr = curr.left;
      }
      return curr;
    }
    TreeNode lastParentWithLeftChild = null;
    while (root != null && root.val != p.val) {
      if (p.val < root.val) {
        lastParentWithLeftChild = root;
        root = root.left;
      } else {
        root = root.right;
      }
    }
    return lastParentWithLeftChild;
  }
}
/*
 O(n)  Runtime: 2 ms, faster than 61.92% of Java online submissions for Inorder Successor in BST.
 O(1)  Memory Usage: 39.6 MB, less than 10.83% of Java online submissions for Inorder Successor in BST.
*/
// leetcode submit region end(Prohibit modification and deletion)
