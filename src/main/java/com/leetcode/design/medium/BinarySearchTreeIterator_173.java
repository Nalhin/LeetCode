package com.leetcode.design.medium;

// Implement an iterator over a binary search tree (BST). Your iterator will be i
// nitialized with the root node of a BST.
//
// Calling next() will return the next smallest number in the BST.
//
//
//
//
//
//
// Example:
//
//
//
//
// BSTIterator iterator = new BSTIterator(root);
// iterator.next();    // return 3
// iterator.next();    // return 7
// iterator.hasNext(); // return true
// iterator.next();    // return 9
// iterator.hasNext(); // return true
// iterator.next();    // return 15
// iterator.hasNext(); // return true
// iterator.next();    // return 20
// iterator.hasNext(); // return false
//
//
//
//
// Note:
//
//
// next() and hasNext() should run in average O(1) time and uses O(h) memory, wh
// ere h is the height of the tree.
// You may assume that next() call will always be valid, that is, there will be
// at least a next smallest number in the BST when next() is called.
//
// Related Topics Stack Tree Design
// 👍 2925 👎 284

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class BinarySearchTreeIterator_173 {
  static class BSTIterator {

    private TreeNode curr;
    private Deque<TreeNode> stack = new ArrayDeque<>();

    public BSTIterator(TreeNode root) {
      curr = root;
    }

    /** @return the next smallest number */
    public int next() {
      while (curr != null) {
        stack.push(curr);
        curr = curr.left;
      }
      TreeNode prev = stack.pop();
      curr = prev.right;
      return prev.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
      return stack.size() > 0 || curr != null;
    }
  }
}
/*
 O(1) amortized Runtime: 15 ms, faster than 85.24% of Java online submissions for Binary Search Tree Iterator.
 O(h) Memory Usage: 44.3 MB, less than 5.64% of Java online submissions for Binary Search Tree Iterator.
*/
/**
 * Your BSTIterator object will be instantiated and called as such: BSTIterator obj = new
 * BSTIterator(root); int param_1 = obj.next(); boolean param_2 = obj.hasNext();
 */
// leetcode submit region end(Prohibit modification and deletion)
