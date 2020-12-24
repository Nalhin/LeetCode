package com.leetcode.tree.easy;

// Given an n-ary tree, return the preorder traversal of its nodes' values.
//
// Nary-Tree input serialization is represented in their level order traversal,
// each group of children is separated by the null value (See examples).
//
//
//
// Follow up:
//
// Recursive solution is trivial, could you do it iteratively?
//
//
// Example 1:
//
//
//
//
// Input: root = [1,null,3,2,4,null,5,6]
// Output: [1,3,5,6,2,4]
//
//
// Example 2:
//
//
//
//
// Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null
// ,12,null,13,null,null,14]
// Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
//
//
//
// Constraints:
//
//
// The height of the n-ary tree is less than or equal to 1000
// The total number of nodes is between [0, 10^4]
//
// Related Topics Tree
// 👍 777 👎 63

// leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.*;
/*
 O(n) Runtime: 2 ms, faster than 45.31% of Java online submissions for N-ary Tree Preorder Traversal.
 O(n) Memory Usage: 39.4 MB, less than 92.43% of Java online submissions for N-ary Tree Preorder Traversal.
*/
// leetcode submit region end(Prohibit modification and deletion)
public class NaryTreePreorderTraversal_589 {
  public List<Integer> preorder(Node root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();

    Deque<Node> deque = new ArrayDeque<>();
    deque.push(root);

    while (!deque.isEmpty()) {
      Node node = deque.pop();
      List<Node> children = node.children;
      for (int i = children.size() - 1; i >= 0; i--) {
        deque.push(children.get(i));
      }
      result.add(node.val);
    }

    return result;
  }

  private static class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }
}
