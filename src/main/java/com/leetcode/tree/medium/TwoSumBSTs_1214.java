package com.leetcode.tree.medium;

// Given two binary search trees, return True if and only if there is a node in t
// he first tree and a node in the second tree whose values sum up to a given integ
// er target.
//
//
// Example 1:
//
//
//
//
// Input: root1 = [2,1,4], root2 = [1,0,3], target = 5
// Output: true
// Explanation: 2 and 3 sum up to 5.
//
//
// Example 2:
//
//
//
//
// Input: root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
// Output: false
//
//
//
// Constraints:
//
//
// Each tree has at most 5000 nodes.
// -10^9 <= target, node.val <= 10^9
//
// Related Topics Binary Search Tree
// 👍 240 👎 23

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n1 + n2) Runtime: 2 ms, faster than 86.64% of Java online submissions for Two Sum BSTs.
 O(n1 + h2) Memory Usage: 40.5 MB, less than 19.72% of Java online submissions for Two Sum BSTs.
*/
public class TwoSumBSTs_1214 {
  public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
    Set<Integer> set = new HashSet<>();
    dfs(root1, set);

    return dfsWithMatch(root2, set, target);
  }

  private boolean dfsWithMatch(TreeNode root, Set<Integer> set, int target) {
    if (root == null) {
      return false;
    }

    return set.contains(target - root.val)
        || dfsWithMatch(root.left, set, target)
        || dfsWithMatch(root.right, set, target);
  }

  private void dfs(TreeNode root, Set<Integer> set) {
    if (root == null) {
      return;
    }

    set.add(root.val);
    dfs(root.left, set);
    dfs(root.right, set);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
