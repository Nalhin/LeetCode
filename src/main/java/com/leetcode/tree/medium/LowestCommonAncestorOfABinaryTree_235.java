package com.leetcode.tree.medium;

// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
// in the tree.
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor
// is defined between two nodes p and q as the lowest node in T that has both p and
// q as descendants (where we allow a node to be a descendant of itself).”
//
//
// Example 1:
//
//
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// Output: 3
// Explanation: The LCA of nodes 5 and 1 is 3.
//
//
// Example 2:
//
//
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
// Output: 5
// Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant o
// f itself according to the LCA definition.
//
//
// Example 3:
//
//
// Input: root = [1,2], p = 1, q = 2
// Output: 1
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [2, 105].
// -109 <= Node.val <= 109
// All Node.val are unique.
// p != q
// p and q will exist in the tree.
//
// Related Topics Tree
// 👍 4404 👎 184

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
// leetcode submit region end(Prohibit modification and deletion)
public class LowestCommonAncestorOfABinaryTree_235 {
  static class Recursive {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null || root == p || root == q) {
        return root;
      }

      TreeNode left = lowestCommonAncestor(root.left, p, q);
      TreeNode right = lowestCommonAncestor(root.right, p, q);

      if (left != null && right != null) {
        return root;
      }
      return left == null ? right : left;
    }
  }
  /*
   O(n)  Runtime: 4 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
   O(log(n))    Memory Usage: 41.2 MB, less than 14.05% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
  */

  static class Iterative {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      HashMap<TreeNode, TreeNode> parents = new HashMap<>();
      Deque<TreeNode> deque = new ArrayDeque<>();
      deque.push(root);
      while (!deque.isEmpty()) {
        TreeNode curr = deque.pop();

        if (curr.left != null) {
          parents.put(curr.left, curr);
          deque.push(curr.left);
        }

        if (curr.right != null) {
          parents.put(curr.right, curr);
          deque.push(curr.right);
        }
      }
      TreeNode curr = q;
      HashSet<TreeNode> set = new HashSet<>();
      while (curr != null) {
        curr = parents.get(curr);
        if (curr != null) {
          set.add(curr);
        }
      }
      curr = p;
      while (curr != null) {
        curr = parents.get(curr);
        if (set.contains(curr)) {
          return curr;
        }
      }
      return null;
    }
  }
  /*
  O(n) Runtime: 9 ms, faster than 27.17% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
  O(n) Memory Usage: 40.5 MB, less than 14.05% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
  */
}
