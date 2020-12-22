package com.leetcode.tree.easy;

// Given a Binary Search Tree (BST) with the root node root, return the minimum d
// ifference between the values of any two different nodes in the tree.
//
// Example :
//
//
// Input: root = [4,2,6,1,3,null,null]
// Output: 1
// Explanation:
// Note that root is a TreeNode object, not an array.
//
// The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
//
//          4
//        /   \
//      2      6
//     / \
//    1   3
//
// while the minimum difference in this tree is 1, it occurs between node 1 and n
// ode 2, also between node 3 and node 2.
//
//
// Note:
//
//
// The size of the BST will be between 2 and 100.
// The BST is always valid, each node's value is an integer, and each node's val
// ue is different.
// This question is the same as 530: https://leetcode.com/problems/minimum-absol
// ute-difference-in-bst/
//
// Related Topics Tree Recursion
// 👍 869 👎 231

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
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Distance Between BST Nodes.
 O(h) Memory Usage: 36.3 MB, less than 90.01% of Java online submissions for Minimum Distance Between BST Nodes.
*/
public class MinimumDistanceBetweenBSTNodes_783 {
  public int minDiffInBST(TreeNode root) {
    boolean first = true;
    int prev = 0;
    int result = Integer.MAX_VALUE;

    Deque<TreeNode> deque = new ArrayDeque<>();
    TreeNode curr = root;

    while (curr != null || !deque.isEmpty()) {
      while (curr != null) {
        deque.push(curr);
        curr = curr.left;
      }
      TreeNode node = deque.pop();
      if (!first) {
        result = Math.min(result, node.val - prev);
      }
      first = false;
      prev = node.val;
      curr = node.right;
    }

    return result;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
