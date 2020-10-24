package com.leetcode.tree.medium;

// Given a root node reference of a BST and a key, delete the node with the given
// key in the BST. Return the root node reference (possibly updated) of the BST.
//
// Basically, the deletion can be divided into two stages:
//
//
// Search for a node to remove.
// If the node is found, delete the node.
//
//
// Follow up: Can you solve it with time complexity O(height of tree)?
//
//
// Example 1:
//
//
// Input: root = [5,3,6,2,4,null,7], key = 3
// Output: [5,4,6,2,null,null,7]
// Explanation: Given key to delete is 3. So we find the node with value 3 and de
// lete it.
// One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
// Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also
// accepted.
//
//
//
// Example 2:
//
//
// Input: root = [5,3,6,2,4,null,7], key = 0
// Output: [5,3,6,2,4,null,7]
// Explanation: The tree does not contain a node with value = 0.
//
//
// Example 3:
//
//
// Input: root = [], key = 0
// Output: []
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 104].
// -105 <= Node.val <= 105
// Each node has a unique value.
// root is a valid binary search tree.
// -105 <= key <= 105
//
// Related Topics Tree
// 👍 2336 👎 94

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class DeleteNodeInABST_450 {
  /*
  O(h) Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a BST.
  O(h) Memory Usage: 39.2 MB, less than 15.06% of Java online submissions for Delete Node in a BST.
  */
  static class Recursive {
    public TreeNode deleteNode(TreeNode root, int key) {
      if (root == null) {
        return null;
      }
      if (key < root.val) {
        root.left = deleteNode(root.left, key);
      } else if (key > root.val) {
        root.right = deleteNode(root.right, key);
      } else {
        if (root.left == null && root.right == null) {
          return null;
        }
        if (root.right != null) {
          root.val = treeMin(root.right).val;
          root.right = deleteNode(root.right, root.val);
        } else {
          root.val = treeMax(root.left).val;
          root.left = deleteNode(root.left, root.val);
        }
      }
      return root;
    }

    private TreeNode treeMin(TreeNode root) {
      while (root.left != null) {
        root = root.left;
      }
      return root;
    }

    private TreeNode treeMax(TreeNode root) {
      while (root.right != null) {
        root = root.right;
      }
      return root;
    }
  }
  /*
  O(h) Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a BST.
  O(1) Memory Usage: 39.4 MB, less than 14.81% of Java online submissions for Delete Node in a BST.
  */
  static class Iterative {
    public TreeNode deleteNode(TreeNode root, int key) {
      TreeNode prev = null;
      TreeNode curr = root;
      while (curr != null && curr.val != key) {
        prev = curr;
        if (key > curr.val) {
          curr = curr.right;
        } else {
          curr = curr.left;
        }
      }
      if (prev == null) {
        return deleteCurr(root);
      }
      if (prev.left == curr) {
        prev.left = deleteCurr(curr);
      } else {
        prev.right = deleteCurr(curr);
      }
      return root;
    }

    private TreeNode deleteCurr(TreeNode root) {
      if (root == null) {
        return null;
      }
      if (root.left == null) {
        return root.right;
      }
      if (root.right == null) {
        return root.left;
      }

      TreeNode next = root.right;
      TreeNode prev = null;
      while (next.left != null) {
        prev = next;
        next = next.left;
      }

      next.left = root.left;
      if (root.right != next) {
        prev.left = next.right;
        next.right = root.right;
      }
      return next;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
