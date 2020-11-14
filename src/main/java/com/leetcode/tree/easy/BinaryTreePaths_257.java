package com.leetcode.tree.easy;

// Given a binary tree, return all root-to-leaf paths.
//
// Note: A leaf is a node with no children.
//
// Example:
//
//
// Input:
//
//   1
// /   \
// 2     3
// \
//  5
//
// Output: ["1->2->5", "1->3"]
//
// Explanation: All root-to-leaf paths are: 1->2->5, 1->3
// Related Topics Tree Depth-first Search
// 👍 2127 👎 119

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
 O(n) Runtime: 1 ms, faster than 99.97% of Java online submissions for Binary Tree Paths.
 O(n) Memory Usage: 39.3 MB, less than 62.05% of Java online submissions for Binary Tree Paths.
*/
public class BinaryTreePaths_257 {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    btPathsDfs(root, sb, result);
    return result;
  }

  private void btPathsDfs(TreeNode root, StringBuilder sb, List<String> result) {
    if (root == null) {
      return;
    }

    int len = sb.length();
    sb.append(root.val);

    if (root.left == null && root.right == null) {
      result.add(sb.toString());
      sb.setLength(len);
      return;
    }

    sb.append("->");
    btPathsDfs(root.left, sb, result);
    btPathsDfs(root.right, sb, result);
    sb.setLength(len);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
