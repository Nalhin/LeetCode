package com.leetcode.tree.medium;

// Given a binary tree
//
//
// struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
// }
//
//
// Populate each next pointer to point to its next right node. If there is no ne
// xt right node, the next pointer should be set to NULL.
//
// Initially, all next pointers are set to NULL.
//
//
//
// Follow up:
//
//
// You may only use constant extra space.
// Recursive approach is fine, you may assume implicit stack space does not coun
// t as extra space for this problem.
//
//
//
// Example 1:
//
//
//
//
// Input: root = [1,2,3,4,5,null,7]
// Output: [1,#,2,3,#,4,5,7,#]
// Explanation: Given the above binary tree (Figure A), your function should popu
// late each next pointer to point to its next right node, just like in Figure B. T
// he serialized output is in level order as connected by the next pointers, with '
// #' signifying the end of each level.
//
//
//
// Constraints:
//
//
// The number of nodes in the given tree is less than 6000.
// -100 <= node.val <= 100
//
// Related Topics Tree Depth-first Search
// 👍 1816 👎 187

// leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

public class PopulatingNextRightPointersInEachNodeII_117 {
  public Node connect(Node root) {
    Node curr = root;
    Node prev = null;
    Node first = null;

    while (curr != null) {
      while (curr != null) {
        if (curr.left != null) {
          if (prev != null) {
            prev.next = curr.left;
          } else {
            first = curr.left;
          }
          prev = curr.left;
        }
        if (curr.right != null) {
          if (prev != null) {
            prev.next = curr.right;
          } else {
            first = curr.right;
          }
          prev = curr.right;
        }
        curr = curr.next;
      }
      curr = first;
      first = null;
      prev = null;
    }
    return root;
  }

  private static class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
      val = _val;
      left = _left;
      right = _right;
      next = _next;
    }
  }
}
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Populating Next Right Pointers in Each Node II.
 O(1) Memory Usage: 38.8 MB, less than 7.80% of Java online submissions for Populating Next Right Pointers in Each Node II.
*/
// leetcode submit region end(Prohibit modification and deletion)
