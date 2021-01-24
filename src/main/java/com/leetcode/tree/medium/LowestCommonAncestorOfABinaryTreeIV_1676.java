package com.leetcode.tree.medium;

// Given the root of a binary tree and an array of TreeNode objects nodes, return
// the lowest common ancestor (LCA) of all the nodes in nodes. All the nodes will
// exist in the tree, and all values of the tree's nodes are unique.
//
// Extending the definition of LCA on Wikipedia: "The lowest common ancestor of
// n nodes p1, p2, ..., pn in a binary tree T is the lowest node that has every pi
// as a descendant (where we allow a node to be a descendant of itself) for every v
// alid i". A descendant of a node x is a node y that is on the path from node x to
// some leaf node.
//
//
// Example 1:
//
//
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [4,7]
// Output: 2
// Explanation: The lowest common ancestor of nodes 4 and 7 is node 2.
//
//
// Example 2:
//
//
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [1]
// Output: 1
// Explanation: The lowest common ancestor of a single node is the node itself.
//
//
//
// Example 3:
//
//
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [7,6,2,4]
// Output: 5
// Explanation: The lowest common ancestor of the nodes 7, 6, 2, and 4 is node 5.
//
//
//
// Example 4:
//
//
// Input: root = [3,5,1,6,2,0,8,null,null,7,4], nodes = [0,1,2,3,4,5,6,7,8]
// Output: 3
// Explanation: The lowest common ancestor of all the nodes is the root node.
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 104].
// -109 <= Node.val <= 109
// All Node.val are unique.
// All nodes[i] will exist in the tree.
// All nodes[i] are distinct.
//
// Related Topics Tree Depth-first Search
// 👍 65 👎 1

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
/*
 O(n) Runtime: 6 ms, faster than 31.78% of Java online submissions for Lowest Common Ancestor of a Binary Tree IV.
 O(max(h, m)) Memory Usage: 41.8 MB, less than 41.31% of Java online submissions for Lowest Common Ancestor of a Binary Tree IV.
*/
public class LowestCommonAncestorOfABinaryTreeIV_1676 {
  private TreeNode result = null;

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
    HashSet<TreeNode> toVisit = new HashSet<>();

    Collections.addAll(toVisit, nodes);

    visitDfs(root, toVisit);
    return result;
  }

  private int visitDfs(TreeNode root, Set<TreeNode> nodes) {
    if (root == null) {
      return 0;
    }

    int children = visitDfs(root.left, nodes) + visitDfs(root.right, nodes);
    int curr = children + (nodes.contains(root) ? 1 : 0);

    if (curr == nodes.size() && result == null) {
      result = root;
    }

    return curr;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
