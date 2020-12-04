package com.leetcode.tree.easy;

// Given the root of a binary search tree, rearrange the tree in in-order so that
// the leftmost node in the tree is now the root of the tree, and every node has n
// o left child and only one right child.
//
//
// Example 1:
//
//
// Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
// Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
//
//
// Example 2:
//
//
// Input: root = [5,1,7]
// Output: [1,null,5,null,7]
//
//
//
// Constraints:
//
//
// The number of nodes in the given tree will be in the range [1, 100].
// 0 <= Node.val <= 1000
// Related Topics Tree Depth-first Search Recursion
// 👍 967 👎 494

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class IncreasingOrderSearchTree_897 {
  /*
     O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Increasing Order Search Tree.
     O(h) Memory Usage: 36.4 MB, less than 80.96% of Java online submissions for Increasing Order Search Tree.
  */
  static class Iterative {
    public TreeNode increasingBST(TreeNode root) {
      TreeNode curr = root;
      TreeNode dummy = new TreeNode();
      TreeNode currResult = dummy;
      Deque<TreeNode> deque = new ArrayDeque<>();

      while (!deque.isEmpty() || curr != null) {
        while (curr != null) {
          deque.push(curr);
          curr = curr.left;
        }

        TreeNode node = deque.pop();
        currResult.right = node;
        currResult.left = null;
        currResult = node;
        curr = node.right;
      }
      currResult.left = null;
      return dummy.right;
    }
  }

  /*
     O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Increasing Order Search Tree.
     O(h) Memory Usage: 36.4 MB, less than 80.96% of Java online submissions for Increasing Order Search Tree.
  */
  static class Recursive {
    private TreeNode curr;

    public TreeNode increasingBST(TreeNode root) {
      TreeNode dummy = new TreeNode();
      curr = dummy;
      dfs(root);
      curr.left = null;
      return dummy.right;
    }

    private void dfs(TreeNode root) {
      if (root == null) {
        return;
      }

      dfs(root.left);
      curr.right = root;
      curr = curr.right;
      root.left = null;
      dfs(root.right);
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
