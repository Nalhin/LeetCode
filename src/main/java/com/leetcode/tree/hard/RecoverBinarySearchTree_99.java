package com.leetcode.tree.hard;

// You are given the root of a binary search tree (BST), where exactly two nodes
// of the tree were swapped by mistake. Recover the tree without changing its struc
// ture.
//
// Follow up: A solution using O(n) space is pretty straight forward. Could you
// devise a constant space solution?
//
//
// Example 1:
//
//
// Input: root = [1,3,null,null,2]
// Output: [3,1,null,null,2]
// Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 mak
// es the BST valid.
//
//
// Example 2:
//
//
// Input: root = [3,1,4,null,null,2]
// Output: [2,1,4,null,null,3]
// Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 a
// nd 3 makes the BST valid.
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [2, 1000].
// -231 <= Node.val <= 231 - 1
//
// Related Topics Tree Depth-first Search
// 👍 1903 👎 79

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;
import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */

/*
 O(n) Runtime: 3 ms, faster than 38.91% of Java online submissions for Recover Binary Search Tree.
 O(log(n)) Memory Usage: 39.1 MB, less than 8.37% of Java online submissions for Recover Binary Search Tree.
*/
public class RecoverBinarySearchTree_99 {

  public void recoverTree(TreeNode root) {

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode curr = root;
    TreeNode prev = null;
    TreeNode firstSwap = null;
    TreeNode secondSwap = null;

    while (curr != null || !stack.isEmpty()) {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      curr = stack.pop();
      if (prev != null) {
        if (curr.val < prev.val) {
          secondSwap = curr;
          if (firstSwap == null) {
            firstSwap = prev;
          } else {
            break;
          }
        }
      }
      prev = curr;
      curr = curr.right;
    }
    int temp = secondSwap.val;
    secondSwap.val = firstSwap.val;
    firstSwap.val = temp;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
