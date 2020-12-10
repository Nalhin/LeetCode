package com.leetcode.tree.medium;

// Given a binary tree, return the zigzag level order traversal of its nodes' val
// ues. (ie, from left to right, then right to left for the next level and alternat
// e between).
//
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//
//
// return its zigzag level order traversal as:
//
// [
//  [3],
//  [20,9],
//  [15,7]
// ]
//
// Related Topics Stack Tree Breadth-first Search
// 👍 2829 👎 114

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
 O(n) Memory Usage: 39.1 MB, less than 44.45% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
*/
public class BinaryTreeZigzagLevelOrderTraversal_103 {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();

    zigzagDfs(root, result, 0);
    return result;
  }

  private void zigzagDfs(TreeNode root, List<List<Integer>> result, int depth) {
    if (root == null) {
      return;
    }

    if (result.size() <= depth) {
      result.add(new LinkedList<>());
    }

    LinkedList<Integer> levelList = (LinkedList<Integer>) result.get(depth);

    if (depth % 2 == 0) {
      levelList.addLast(root.val);
    } else {
      levelList.addFirst(root.val);
    }

    zigzagDfs(root.left, result, depth + 1);
    zigzagDfs(root.right, result, depth + 1);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
