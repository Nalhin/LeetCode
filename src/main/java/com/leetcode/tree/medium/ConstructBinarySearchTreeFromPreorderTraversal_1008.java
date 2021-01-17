package com.leetcode.tree.medium;

// Return the root node of a binary search tree that matches the given preorder t
// raversal.
//
// (Recall that a binary search tree is a binary tree where for every node, any
// descendant of node.left has a value < node.val, and any descendant of node.right
// has a value > node.val. Also recall that a preorder traversal displays the valu
// e of the node first, then traverses node.left, then traverses node.right.)
//
// It's guaranteed that for the given test cases there is always possible to fin
// d a binary search tree with the given requirements.
//
// Example 1:
//
//
// Input: [8,5,1,7,10,12]
// Output: [8,5,10,1,7,null,12]
//
//
//
//
// Constraints:
//
//
// 1 <= preorder.length <= 100
// 1 <= preorder[i] <= 10^8
// The values of preorder are distinct.
//
// Related Topics Tree
// 👍 1642 👎 47

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Construct Binary Search Tree from Preorder Traversal.
 O(h) Memory Usage: 39.2 MB, less than 7.01% of Java online submissions for Construct Binary Search Tree from Preorder Traversal.
*/
public class ConstructBinarySearchTreeFromPreorderTraversal_1008 {

  private int index = 0;

  public TreeNode bstFromPreorder(int[] preorder) {
    return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private TreeNode dfs(int[] preorder, int min, int max) {
    if (index >= preorder.length || preorder[index] < min || preorder[index] > max) {
      return null;
    }

    int curr = preorder[index++];
    TreeNode root = new TreeNode(curr);
    root.left = dfs(preorder, min, curr);
    root.right = dfs(preorder, curr, max);
    return root;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
