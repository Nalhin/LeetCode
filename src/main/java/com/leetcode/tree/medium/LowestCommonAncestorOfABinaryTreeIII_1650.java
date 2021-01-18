package com.leetcode.tree.medium;

// Given two nodes of a binary tree p and q, return their lowest common ancestor
// (LCA).
//
// Each node will have a reference to its parent node. The definition for Node i
// s below:
//
//
// class Node {
//    public int val;
//    public Node left;
//    public Node right;
//    public Node parent;
// }
//
//
// According to the definition of LCA on Wikipedia: "The lowest common ancestor
// of two nodes p and q in a tree T is the lowest node that has both p and q as des
// cendants (where we allow a node to be a descendant of itself)."
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
// Explanation: The LCA of nodes 5 and 4 is 5 since a node can be a descendant of
// itself according to the LCA definition.
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
// p and q exist in the tree.
//
// Related Topics Tree
// 👍 47 👎 4

// leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorOfABinaryTreeIII_1650 {

  /*
   O(h) Runtime: 20 ms, faster than 94.36% of Java online submissions for Lowest Common Ancestor of a Binary Tree III.
   O(h) Memory Usage: 40.3 MB, less than 28.14% of Java online submissions for Lowest Common Ancestor of a Binary Tree III.
  */
  class SetSolution {
    public Node lowestCommonAncestor(Node p, Node q) {
      Set<Node> visited = new HashSet<>();

      while (p.parent != null || q.parent != null) {
        if (p.parent != null) {
          if (visited.contains(p)) {
            return p;
          }
          visited.add(p);
          p = p.parent;
        }
        if (q.parent != null) {
          if (visited.contains(q)) {
            return q;
          }
          visited.add(q);
          q = q.parent;
        }
      }
      return null;
    }
  }
  /*
   O(h) Runtime: 20 ms, faster than 94.36% of Java online submissions for Lowest Common Ancestor of a Binary Tree III.
   O(1) Memory Usage: 40.2 MB, less than 28.14% of Java online submissions for Lowest Common Ancestor of a Binary Tree III.
  */
  static class TwoRacers {
    public Node lowestCommonAncestor(Node p, Node q) {
      Node first = p;
      Node second = q;
      while (first != second) {
        first = first == null ? q : first.parent;
        second = second == null ? p : second.parent;
      }
      return first;
    }
  }

  private static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
