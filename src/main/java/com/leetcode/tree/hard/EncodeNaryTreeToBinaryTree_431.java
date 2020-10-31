package com.leetcode.tree.hard;

// Design an algorithm to encode an N-ary tree into a binary tree and decode the
// binary tree to get the original N-ary tree. An N-ary tree is a rooted tree in wh
// ich each node has no more than N children. Similarly, a binary tree is a rooted
// tree in which each node has no more than 2 children. There is no restriction on
// how your encode/decode algorithm should work. You just need to ensure that an N-
// ary tree can be encoded to a binary tree and this binary tree can be decoded to
// the original N-nary tree structure.
//
// Nary-Tree input serialization is represented in their level order traversal,
// each group of children is separated by the null value (See following example).
//
// For example, you may encode the following 3-ary tree to a binary tree in this
// way:
//
//
//
//
// Input: root = [1,null,3,2,4,null,5,6]
//
//
// Note that the above is just an example which might or might not work. You do
// not necessarily need to follow this format, so please be creative and come up wi
// th different approaches yourself.
//
//
//
//
//
// Constraints:
//
//
// The height of the n-ary tree is less than or equal to 1000
// The total number of nodes is between [0, 10^4]
// Do not use class member/global/static variables to store states. Your encode
// and decode algorithms should be stateless.
//
// Related Topics Tree
// 👍 245 👎 15

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

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
  O(n) Runtime: 4 ms, faster than 26.59% of Java online submissions for Encode N-ary Tree to Binary Tree.
  O(n) Memory Usage: 41 MB, less than 86.26% of Java online submissions for Encode N-ary Tree to Binary Tree.
*/
public class EncodeNaryTreeToBinaryTree_431 {
  class Codec {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
      if (root == null) {
        return null;
      }

      Deque<Node> queue = new ArrayDeque<>();
      Deque<TreeNode> results = new ArrayDeque<>();
      TreeNode dummy = new TreeNode(root.val);
      queue.add(root);
      results.add(dummy);

      while (!queue.isEmpty()) {
        Node curr = queue.remove();
        TreeNode currRes = results.remove();
        TreeNode loopDummy = new TreeNode();
        TreeNode currDummy = loopDummy;
        for (Node n : curr.children) {
          TreeNode left = new TreeNode(n.val);
          if (n.children.size() > 0) {
            queue.add(n);
            results.add(left);
          }
          currDummy.left = left;
          currDummy = currDummy.left;
        }
        currRes.right = loopDummy.left;
      }
      return dummy;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
      if (root == null) {
        return null;
      }
      Node result = new Node(root.val, new ArrayList<>());
      if (root.right == null) {
        return result;
      }

      Deque<TreeNode> deque = new ArrayDeque<>();
      Deque<Node> resDeque = new ArrayDeque<>();
      resDeque.add(result);
      deque.add(root.right);

      while (!deque.isEmpty()) {
        TreeNode curr = deque.remove();
        Node currRes = resDeque.remove();
        while (curr != null) {
          Node n = new Node(curr.val, new ArrayList<>());
          currRes.children.add(n);
          if (curr.right != null) {
            resDeque.add(n);
            deque.add(curr.right);
          }
          curr = curr.left;
        }
      }
      return result;
    }
  }

  static class Node {
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
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));
// leetcode submit region end(Prohibit modification and deletion)
