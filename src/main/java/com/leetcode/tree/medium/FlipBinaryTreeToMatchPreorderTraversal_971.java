package com.leetcode.tree.medium;

// You are given the root of a binary tree with n nodes, where each node is uniqu
// ely assigned a value from 1 to n. You are also given a sequence of n values voya
// ge, which is the desired pre-order traversal of the binary tree.
//
// Any node in the binary tree can be flipped by swapping its left and right sub
// trees. For example, flipping node 1 will have the following effect:
//
// Flip the smallest number of nodes so that the pre-order traversal of the tree
// matches voyage.
//
// Return a list of the values of all flipped nodes. You may return the answer i
// n any order. If it is impossible to flip the nodes in the tree to make the pre-o
// rder traversal match voyage, return the list [-1].
//
//
// Example 1:
//
//
// Input: root = [1,2], voyage = [2,1]
// Output: [-1]
// Explanation: It is impossible to flip the nodes such that the pre-order traver
// sal matches voyage.
//
//
// Example 2:
//
//
// Input: root = [1,2,3], voyage = [1,3,2]
// Output: [1]
// Explanation: Flipping node 1 swaps nodes 2 and 3, so the pre-order traversal m
// atches voyage.
//
// Example 3:
//
//
// Input: root = [1,2,3], voyage = [1,2,3]
// Output: []
// Explanation: The tree's pre-order traversal already matches voyage, so no node
// s need to be flipped.
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is n.
// n == voyage.length
// 1 <= n <= 100
// 1 <= Node.val, voyage[i] <= n
// All the values in the tree are unique.
// All the values in voyage are unique.
//
// Related Topics Tree Depth-first Search
// 👍 458 👎 180
/*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Flip Binary Tree To Match Preorder Traversal.
  O(n) Memory Usage: 39.1 MB, less than 43.33% of Java online submissions for Flip Binary Tree To Match Preorder Traversal.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class FlipBinaryTreeToMatchPreorderTraversal_971 {
  private int index = 0;
  private boolean invalid = false;
  private final List<Integer> result = new ArrayList<>();

  public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
    dfs(root, voyage);
    return invalid ? List.of(-1) : result;
  }

  private void dfs(TreeNode root, int[] voyage) {
    if (root == null) {
      return;
    }

    if (root.val != voyage[index]) {
      invalid = true;
      return;
    }

    index++;

    if (index < voyage.length && root.left != null && root.left.val != voyage[index]) {
      result.add(root.val);
      dfs(root.right, voyage);
      dfs(root.left, voyage);
    } else {
      dfs(root.left, voyage);
      dfs(root.right, voyage);
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
