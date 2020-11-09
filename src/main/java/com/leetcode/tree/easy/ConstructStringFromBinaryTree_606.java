package com.leetcode.tree.easy;

// You need to construct a string consists of parenthesis and integers from a bin
// ary tree with the preorder traversing way.
//
// The null node needs to be represented by empty parenthesis pair "()". And you
// need to omit all the empty parenthesis pairs that don't affect the one-to-one m
// apping relationship between the string and the original binary tree.
//
// Example 1:
//
// Input: Binary tree: [1,2,3,4]
//       1
//     /   \
//    2     3
//   /
//  4
//
// Output: "1(2(4))(3)"
// Explanation: Originallay it needs to be "1(2(4)())(3()())", but you need to o
// mit all the unnecessary empty parenthesis pairs. And it will be "1(2(4))(3)".
//
//
//
// Example 2:
//
// Input: Binary tree: [1,2,3,null,4]
//       1
//     /   \
//    2     3
//     \
//      4
//
// Output: "1(2()(4))(3)"
// Explanation: Almost the same as the first example, except we can't omit the f
// irst parenthesis pair to break the one-to-one mapping relationship between the i
// nput and the output.
//
// Related Topics String Tree
// 👍 849 👎 1157

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 1 ms, faster than 100.00% of Java online submissions for Construct String from Binary Tree.
 O(h) Memory Usage: 39.1 MB, less than 5.48% of Java online submissions for Construct String from Binary Tree.
*/
public class ConstructStringFromBinaryTree_606 {
  public String tree2str(TreeNode t) {
    if (t == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    sb.append(t.val);
    if (t.left == null && t.right != null) {
      sb.append("()");
    }
    strinfigyDfs(t.left, sb);
    strinfigyDfs(t.right, sb);
    return sb.toString();
  }

  private void strinfigyDfs(TreeNode root, StringBuilder sb) {
    if (root == null) {
      return;
    }

    sb.append("(").append(root.val);
    if (root.left == null && root.right != null) {
      sb.append("()");
    }
    strinfigyDfs(root.left, sb);
    strinfigyDfs(root.right, sb);
    sb.append(")");
  }
}
// leetcode submit region end(Prohibit modification and deletion)
