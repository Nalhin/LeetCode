package com.leetcode.tree.hard;

// We run a preorder depth-first search (DFS) on the root of a binary tree.
//
// At each node in this traversal, we output D dashes (where D is the depth of t
// his node), then we output the value of this node. If the depth of a node is D, t
// he depth of its immediate child is D + 1. The depth of the root node is 0.
//
// If a node has only one child, that child is guaranteed to be the left child.
//
//
// Given the output S of this traversal, recover the tree and return its root.
//
//
// Example 1:
//
//
// Input: S = "1-2--3--4-5--6--7"
// Output: [1,2,5,3,4,6,7]
//
//
// Example 2:
//
//
// Input: S = "1-2--3---4-5--6---7"
// Output: [1,2,5,3,null,6,null,4,null,7]
//
//
// Example 3:
//
//
// Input: S = "1-401--349---90--88"
// Output: [1,401,null,349,88,90]
//
//
//
// Constraints:
//
//
// The number of nodes in the original tree is in the range [1, 1000].
// 1 <= Node.val <= 109
//
// Related Topics Tree Depth-first Search
// 👍 564 👎 21

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 2 ms, faster than 96.24% of Java online submissions for Recover a Tree From Preorder Traversal.
 O(1) Memory Usage: 39.4 MB, less than 66.67% of Java online submissions for Recover a Tree From Preorder Traversal.
*/
public class RecoverATreeFromPreorderTraversal_1028 {

  private int index = 0;

  public TreeNode recoverFromPreorder(String s) {
    TreeNode root = new TreeNode(resolveNum(s));
    root.left = recoverFromPreorderDfs(s, 0);
    root.right = recoverFromPreorderDfs(s, 0);
    return root;
  }

  private TreeNode recoverFromPreorderDfs(String s, int parentDashes) {
    if (index >= s.length()) {
      return null;
    }
    int prev = index;
    int dashes = 0;

    while (s.charAt(index) == '-') {
      dashes++;
      index++;
    }
    if (dashes <= parentDashes) {
      index = prev;
      return null;
    }

    TreeNode curr = new TreeNode(resolveNum(s));
    curr.left = recoverFromPreorderDfs(s, dashes);
    curr.right = recoverFromPreorderDfs(s, dashes);
    return curr;
  }

  private int resolveNum(String s) {
    int start = index;
    int last = start;

    while (index < s.length() && s.charAt(index) != '-') {
      last++;
      index++;
    }

    return Integer.parseInt(s.substring(start, last));
  }
}
// leetcode submit region end(Prohibit modification and deletion)
