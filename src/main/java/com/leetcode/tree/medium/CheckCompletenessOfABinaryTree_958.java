package com.leetcode.tree.medium;

// Given the root of a binary tree, determine if it is a complete binary tree.
//
// In a complete binary tree, every level, except possibly the last, is complete
// ly filled, and all nodes in the last level are as far left as possible. It can h
// ave between 1 and 2h nodes inclusive at the last level h.
//
//
// Example 1:
//
//
// Input: root = [1,2,3,4,5,6]
// Output: true
// Explanation: Every level before the last is full (ie. levels with node-values
// {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as
// possible.
//
//
// Example 2:
//
//
// Input: root = [1,2,3,4,5,null,7]
// Output: false
// Explanation: The node with value 7 isn't as far left as possible.
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 100].
// 1 <= Node.val <= 1000
//
// Related Topics Tree
// 👍 1052 👎 14

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 1 ms, faster than 66.07% of Java online submissions for Check Completeness of a Binary Tree.
 O(n) Memory Usage: 38.4 MB, less than 41.67% of Java online submissions for Check Completeness of a Binary Tree.
*/
public class CheckCompletenessOfABinaryTree_958 {
  public boolean isCompleteTree(TreeNode root) {
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.push(root);
    boolean end = false;

    while (!deque.isEmpty()) {
      TreeNode curr = deque.pop();
      if (end && (curr.left != null || curr.right != null)) {
        return false;
      }
      if (curr.left != null) {
        deque.add(curr.left);
      }
      if (curr.right != null) {
        deque.add(curr.right);
      }
      if (!end && (curr.right == null || curr.left == null)) {
        if (curr.left == null && curr.right != null) {
          return false;
        }
        end = true;
      }
    }
    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
