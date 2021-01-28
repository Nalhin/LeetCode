package com.leetcode.tree.medium;

// Given the root of a binary tree, flatten the tree into a "linked list":
//
//
// The "linked list" should use the same TreeNode class where the right child po
// inter points to the next node in the list and the left child pointer is always n
// ull.
// The "linked list" should be in the same order as a pre-order traversal of the
// binary tree.
//
//
//
// Example 1:
//
//
// Input: root = [1,2,5,3,4,null,6]
// Output: [1,null,2,null,3,null,4,null,5,null,6]
//
//
// Example 2:
//
//
// Input: root = []
// Output: []
//
//
// Example 3:
//
//
// Input: root = [0]
// Output: [0]
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 2000].
// -100 <= Node.val <= 100
//
//
//
// Follow up: Can you flatten the tree in-place (with O(1) extra space)? Related
// Topics Tree Depth-first Search
// 👍 3785 👎 390

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.
 O(n) Memory Usage: 38.5 MB, less than 59.38% of Java online submissions for Flatten Binary Tree to Linked List.
*/
public class FlattenBinaryTreeToLinkedList_114 {
  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    dfs(root);
  }

  private TreeNode dfs(TreeNode root) {
    if (root.left == null && root.right == null) {
      return root;
    }

    if (root.left == null) {
      return dfs(root.right);
    }

    TreeNode deep = dfs(root.left);
    deep.right = root.right;
    root.right = root.left;
    root.left = null;
    return dfs(root.right);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
