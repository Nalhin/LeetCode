package com.leetcode.tree.medium;

// You have a binary tree with a small defect. There is exactly one invalid node
// where its right child incorrectly points to another node at the same depth but t
// o the invalid node's right.
//
// Given the root of the binary tree with this defect, root, return the root of
// the binary tree after removing this invalid node and every node underneath it (m
// inus the node it incorrectly points to).
//
// Custom testing:
//
// The test input is read as 3 lines:
//
//
// TreeNode root
// int fromNode (not available to correctBinaryTree)
// int toNode (not available to correctBinaryTree)
//
//
// After the binary tree rooted at root is parsed, the TreeNode with value of fr
// omNode will have its right child pointer pointing to the TreeNode with a value o
// f toNode. Then, root is passed to correctBinaryTree.
//
//
// Example 1:
//
//
//
//
// Input: root = [1,2,3], fromNode = 2, toNode = 3
// Output: [1,null,3]
// Explanation: The node with value 2 is invalid, so remove it.
//
//
// Example 2:
//
//
//
//
// Input: root = [8,3,1,7,null,9,4,2,null,null,null,5,6], fromNode = 7, toNode =
// 4
// Output: [8,3,1,null,null,9,4,null,null,5,6]
// Explanation: The node with value 7 is invalid, so remove it and the node under
// neath it, node 2.
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [3, 104].
// -109 <= Node.val <= 109
// All Node.val are unique.
// fromNode != toNode
// fromNode and toNode will exist in the tree and will be on the same depth.
// toNode is to the right of fromNode.
// fromNode.right is null in the initial tree from the test data.
// Related Topics Tree
// 👍 29 👎 4

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 11 ms, faster than 13.17% of Java online submissions for Correct a Binary Tree.
 O(n) Memory Usage: 42.7 MB, less than 53.62% of Java online submissions for Correct a Binary Tree.
*/
public class CorrectABinaryTree_1660 {
  public TreeNode correctBinaryTree(TreeNode root) {
    return removeDfs(root, findNode(root));
  }

  private TreeNode findNode(TreeNode root) {
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.push(root);

    while (!deque.isEmpty()) {

      int size = deque.size();
      Set<TreeNode> level = new HashSet<>(deque);
      for (int i = 0; i < size; i++) {
        TreeNode node = deque.pop();

        if (node.left != null) {
          deque.add(node.left);
        }
        if (node.right != null) {
          if (level.contains(node.right)) {
            return node;
          }
          deque.add(node.right);
        }
      }
    }
    return null;
  }

  private TreeNode removeDfs(TreeNode root, TreeNode node) {
    if (root == null) {
      return null;
    }

    if (root == node) {
      return null;
    }
    root.left = removeDfs(root.left, node);
    root.right = removeDfs(root.right, node);
    return root;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
