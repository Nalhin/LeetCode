package com.leetcode.tree.medium;

// Given the root of a binary tree, return the lowest common ancestor (LCA) of tw
// o given nodes, p and q. If either node p or q does not exist in the tree, return
// null. All values of the nodes in the tree are unique.
//
// According to the definition of LCA on Wikipedia: "The lowest common ancestor
// of two nodes p and q in a binary tree T is the lowest node that has both p and q
// as descendants (where we allow a node to be a descendant of itself)". A descend
// ant of a node x is a node y that is on the path from node x to some leaf node.
//
//
// Example 1:
//
//
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// Output: 3
// Explanation: The LCA of nodes 5 and 1 is 3.
//
// Example 2:
//
//
//
//
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
// Output: 5
// Explanation: The LCA of nodes 5 and 4 is 5. A node can be a descendant of itse
// lf according to the definition of LCA.
//
// Example 3:
//
//
//
//
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 10
// Output: null
// Explanation: Node 10 does not exist in the tree, so return null.
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 104].
// -109 <= Node.val <= 109
// All Node.val are unique.
// p != q
//
//
//
// Follow up: Can you find the LCA traversing the tree, without checking nodes ex
// istence? Related Topics Tree
// 👍 77 👎 2

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
/*
 O(n) Runtime: 16 ms, faster than 15.52% of Java online submissions for Lowest Common Ancestor of a Binary Tree II.
 O(n) Memory Usage: 68.7 MB, less than 6.48% of Java online submissions for Lowest Common Ancestor of a Binary Tree II.

*/
public class LowestCommonAncestorOfABinaryTree_II {
  private TreeNode result = null;

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    lcs(root, p, q);
    return result;
  }

  private int lcs(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return 0;
    }
    int left = lcs(root.left, p, q);
    int right = lcs(root.right, p, q);

    int matched = left + right + (root == p ? 1 : 0) + (root == q ? 1 : 0);

    if (matched == 2 && result == null) {
      result = root;
    }

    return matched;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
