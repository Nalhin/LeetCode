package com.leetcode.tree.medium;

// Given a binary tree, imagine yourself standing on the right side of it, return
// the values of the nodes you can see ordered from top to bottom.
//
// Example:
//
//
// Input: [1,2,3,null,5,null,4]
// Output: [1, 3, 4]
// Explanation:
//
//   1            <---
// /   \
// 2     3         <---
// \     \
//  5     4       <---
// Related Topics Tree Depth-first Search Breadth-first Search
// 👍 2945 👎 165

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */

/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Right Side View.
 O(n) Memory Usage: 37.7 MB, less than 45.67% of Java online submissions for Binary Tree Right Side View.
*/
public class BinaryTreeRightSideView_199 {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    rightSideViewDfs(root, result, 0);
    return result;
  }

  private void rightSideViewDfs(TreeNode root, List<Integer> result, int level) {
    if (root == null) {
      return;
    }

    if (result.size() <= level) {
      result.add(root.val);
    } else {
      result.set(level, root.val);
    }

    rightSideViewDfs(root.left, result, level + 1);
    rightSideViewDfs(root.right, result, level + 1);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
