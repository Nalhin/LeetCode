package com.leetcode.tree.easy;

// Given an n-ary tree, return the postorder traversal of its nodes' values.
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
// Output: [5,6,3,2,4,1]
//
//
// Example 2:
//
//
//
//
// Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null
// ,12,null,13,null,null,14]
// Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
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
// 👍 838 👎 72

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
 O(n) Runtime: 3 ms, faster than 28.02% of Java online submissions for N-ary Tree Postorder Traversal.
 O(n) Memory Usage: 39.4 MB, less than 94.40% of Java online submissions for N-ary Tree Postorder Traversal.
*/
// leetcode submit region end(Prohibit modification and deletion)
public class NaryTreePostorderTraversal_590 {
  public List<Integer> postorder(Node root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();
    Deque<Node> deque = new ArrayDeque<>();
    deque.add(root);

    while (!deque.isEmpty()) {
      Node node = deque.pop();
      result.add(node.val);
      for (Node child : node.children) {
        deque.push(child);
      }
    }

    Collections.reverse(result);

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
