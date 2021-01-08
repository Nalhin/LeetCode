package com.leetcode.tree.easy;

// Given a binary search tree (BST) with duplicates, find all the mode(s) (the mo
// st frequently occurred element) in the given BST.
//
// Assume a BST is defined as follows:
//
//
// The left subtree of a node contains only nodes with keys less than or equal t
// o the node's key.
// The right subtree of a node contains only nodes with keys greater than or equ
// al to the node's key.
// Both the left and right subtrees must also be binary search trees.
//
//
//
//
// For example:
// Given BST [1,null,2,2],
//
//
//   1
//    \
//     2
//    /
//   2
//
//
//
//
// return [2].
//
// Note: If a tree has more than one mode, you can return them in any order.
//
// Follow up: Could you do that without using any extra space? (Assume that the
// implicit stack space incurred due to recursion does not count).
// Related Topics Tree
// 👍 1160 👎 389

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.*;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 12 ms, faster than 6.57% of Java online submissions for Find Mode in Binary Search Tree.
 O(n) Memory Usage: 44.1 MB, less than 5.03% of Java online submissions for Find Mode in Binary Search Tree.
*/
public class FindModeInBinarySearchTree_501 {

  public int[] findMode(TreeNode root) {
    Map<Integer, Integer> result = new HashMap<>();
    findModeDfs(root, result);
    int max = Collections.max(result.values());

    List<Integer> results = new ArrayList<>();

    for (var entry : result.entrySet()) {
      if (entry.getValue() == max) {
        results.add(entry.getKey());
      }
    }

    return results.stream().mapToInt(i -> i).toArray();
  }

  private void findModeDfs(TreeNode root, Map<Integer, Integer> result) {
    if (root == null) {
      return;
    }
    result.put(root.val, result.getOrDefault(root.val, 0) + 1);
    findModeDfs(root.left, result);
    findModeDfs(root.right, result);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
