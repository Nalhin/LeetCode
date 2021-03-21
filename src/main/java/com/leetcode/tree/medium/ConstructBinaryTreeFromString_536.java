package com.leetcode.tree.medium;

// You need to construct a binary tree from a string consisting of parenthesis an
// d integers.
//
// The whole input represents a binary tree. It contains an integer followed by
// zero, one or two pairs of parenthesis. The integer represents the root's value a
// nd a pair of parenthesis contains a child binary tree with the same structure.
//
// You always start to construct the left child node of the parent first if it e
// xists.
//
//
// Example 1:
//
//
// Input: s = "4(2(3)(1))(6(5))"
// Output: [4,2,6,3,1,5]
//
//
// Example 2:
//
//
// Input: s = "4(2(3)(1))(6(5)(7))"
// Output: [4,2,6,3,1,5,7]
//
//
// Example 3:
//
//
// Input: s = "-4(2(3)(1))(6(5)(7))"
// Output: [-4,2,6,3,1,5,7]
//
//
//
// Constraints:
//
//
// 0 <= s.length <= 3 * 104
// s consists of digits, '(', ')', and '-' only.
//
// Related Topics String Tree
// 👍 576 👎 104
/*
 O(n) Runtime: 2 ms, faster than 92.23% of Java online submissions for Construct Binary Tree from String.
 O(n) Memory Usage: 39.5 MB, less than 60.84% of Java online submissions for Construct Binary Tree from String.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class ConstructBinaryTreeFromString_536 {
  private int position = 0;

  public TreeNode str2tree(String s) {
    return s.isEmpty() ? null : dfs(s);
  }

  private TreeNode dfs(String str) {
    TreeNode root = new TreeNode(getNodeValue(str));

    if (position < str.length() && str.charAt(position) == '(') {
      position++;
      root.left = dfs(str);
    }

    if (position < str.length() && str.charAt(position) == '(') {
      position++;
      root.right = dfs(str);
    }

    position++;
    return root;
  }

  private int getNodeValue(String str) {
    int initial = position;
    while (position < str.length() && str.charAt(position) != '(' && str.charAt(position) != ')') {
      position++;
    }
    return Integer.parseInt(str.substring(initial, position));
  }
}
// leetcode submit region end(Prohibit modification and deletion)
