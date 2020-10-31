package com.leetcode.tree.medium;

// Given an n-ary tree, return the level order traversal of its nodes' values.
//
// Nary-Tree input serialization is represented in their level order traversal,
// each group of children is separated by the null value (See examples).
//
//
// Example 1:
//
//
//
//
// Input: root = [1,null,3,2,4,null,5,6]
// Output: [[1],[3,2,4],[5,6]]
//
//
// Example 2:
//
//
//
//
// Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null
// ,12,null,13,null,null,14]
// Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
//
//
//
// Constraints:
//
//
// The height of the n-ary tree is less than or equal to 1000
// The total number of nodes is between [0, 10^4]
//
// Related Topics Tree Breadth-first Search
// 👍 721 👎 51

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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/*
  O(n) Runtime: 2 ms, faster than 86.47% of Java online submissions for N-ary Tree Level Order Traversal.
  O(n) Memory Usage: 39.9 MB, less than 7.05% of Java online submissions for N-ary Tree Level Order Traversal.
*/
public class NaryTreeLevelOrderTraversal_429 {
  public List<List<Integer>> levelOrder(Node root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Deque<Node> deque = new ArrayDeque<>();
    deque.add(root);

    while (!deque.isEmpty()) {

      int size = deque.size();
      List<Integer> level = new ArrayList<>();

      for (int i = 0; i < size; i++) {
        Node curr = deque.remove();
        level.add(curr.val);
        deque.addAll(curr.children);
      }

      result.add(level);
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
// leetcode submit region end(Prohibit modification and deletion)
