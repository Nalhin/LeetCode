package com.leetcode.tree.medium;

// Given inorder and postorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.
//
// For example, given
//
//
// inorder = [9,3,15,20,7]
// postorder = [9,15,7,20,3]
//
// Return the following binary tree:
//
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
// Related Topics Array Tree Depth-first Search
// 👍 2125 👎 39

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder.length == 0) {
      return null;
    }
    Map<Integer, Integer> inorderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(inorder[i], i);
    }
    return buildTreeDfs(0, postorder.length - 1, postorder.length - 1, postorder, inorderMap);
  }

  private TreeNode buildTreeDfs(
      int start, int end, int postorderLast, int[] postorder, Map<Integer, Integer> inorderMap) {
    if (start > end || postorderLast < 0) {
      return null;
    }
    TreeNode node = new TreeNode(postorder[postorderLast]);
    int mid = inorderMap.get(postorder[postorderLast]);
    node.left =
        buildTreeDfs(start, mid - 1, postorderLast - (end - mid) - 1, postorder, inorderMap);
    node.right = buildTreeDfs(mid + 1, end, postorderLast - 1, postorder, inorderMap);
    return node;
  }
}
/*
 O(n)  Runtime: 1 ms, faster than 96.39% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
 O(n)  Memory Usage: 39.3 MB, less than 10.14% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
*/
// leetcode submit region end(Prohibit modification and deletion)
