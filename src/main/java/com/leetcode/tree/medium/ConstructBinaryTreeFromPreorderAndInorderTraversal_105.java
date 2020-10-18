package com.leetcode.tree.medium;

// Given preorder and inorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.
//
// For example, given
//
//
// preorder = [3,9,20,15,7]
// inorder = [9,3,15,20,7]
//
// Return the following binary tree:
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics Array Tree Depth-first Search
// 👍 4067 👎 109

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(inorder[i], i);
    }

    return buildTreeDfs(0, preorder.length - 1, 0, preorder, inorderMap);
  }

  private TreeNode buildTreeDfs(
      int start, int end, int preorderIndex, int[] preorder, Map<Integer, Integer> inorderMap) {
    if (start > end || preorderIndex >= preorder.length) {
      return null;
    }
    TreeNode node = new TreeNode(preorder[preorderIndex]);
    int mid = inorderMap.get(preorder[preorderIndex]);
    node.left = buildTreeDfs(start, mid - 1, preorderIndex + 1, preorder, inorderMap);
    node.right =
        buildTreeDfs(mid + 1, end, preorderIndex + (mid - start) + 1, preorder, inorderMap);
    return node;
  }
}
/*
  O(n) Runtime: 1 ms, faster than 98.55% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
  O(n) Memory Usage: 38.7 MB, less than 9.26% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
*/
// leetcode submit region end(Prohibit modification and deletion)
