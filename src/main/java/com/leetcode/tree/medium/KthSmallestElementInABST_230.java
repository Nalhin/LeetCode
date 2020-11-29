package com.leetcode.tree.medium;

// Given a binary search tree, write a function kthSmallest to find the kth small
// est element in it.
//
//
//
// Example 1:
//
//
// Input: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//    2
// Output: 1
//
// Example 2:
//
//
// Input: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
// Output: 3
//
//
// Follow up:
// What if the BST is modified (insert/delete operations) often and you need to f
// ind the kth smallest frequently? How would you optimize the kthSmallest routine?
//
//
//
// Constraints:
//
//
// The number of elements of the BST is between 1 to 10^4.
// You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
//
// Related Topics Binary Search Tree
// 👍 3198 👎 75

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
 O(h + k) Runtime: 0 ms, faster than 100.00% of Java online submissions for Kth Smallest Element in a BST.
 O(h) Memory Usage: 38.6 MB, less than 81.71% of Java online submissions for Kth Smallest Element in a BST.
*/
public class KthSmallestElementInABST_230 {
  public int kthSmallest(TreeNode root, int k) {
    TreeNode curr = root;
    Deque<TreeNode> deque = new ArrayDeque<>();

    while (!deque.isEmpty() || curr != null) {
      while (curr != null) {
        deque.push(curr);
        curr = curr.left;
      }
      TreeNode prev = deque.pop();
      if (--k == 0) {
        return prev.val;
      }
      curr = prev.right;
    }
    return -1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
