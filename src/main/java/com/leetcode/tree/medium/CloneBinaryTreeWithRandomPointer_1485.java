package com.leetcode.tree.medium;

// A binary tree is given such that each node contains an additional random point
// er which could point to any node in the tree or null.
//
// Return a deep copy of the tree.
//
// The tree is represented in the same input/output way as normal binary trees w
// here each node is represented as a pair of [val, random_index] where:
//
//
// val: an integer representing Node.val
// random_index: the index of the node (in the input) where the random pointer p
// oints to, or null if it does not point to any node.
//
//
// You will be given the tree in class Node and you should return the cloned tre
// e in class NodeCopy. NodeCopy class is just a clone of Node class with the same
// attributes and constructors.
//
//
// Example 1:
//
//
// Input: root = [[1,null],null,[4,3],[7,0]]
// Output: [[1,null],null,[4,3],[7,0]]
// Explanation: The original binary tree is [1,null,4,7].
// The random pointer of node one is null, so it is represented as [1, null].
// The random pointer of node 4 is node 7, so it is represented as [4, 3] where 3
// is the index of node 7 in the array representing the tree.
// The random pointer of node 7 is node 1, so it is represented as [7, 0] where 0
// is the index of node 1 in the array representing the tree.
//
//
// Example 2:
//
//
// Input: root = [[1,4],null,[1,0],null,[1,5],[1,5]]
// Output: [[1,4],null,[1,0],null,[1,5],[1,5]]
// Explanation: The random pointer of a node can be the node itself.
//
//
// Example 3:
//
//
// Input: root = [[1,6],[2,5],[3,4],[4,3],[5,2],[6,1],[7,0]]
// Output: [[1,6],[2,5],[3,4],[4,3],[5,2],[6,1],[7,0]]
//
//
// Example 4:
//
//
// Input: root = []
// Output: []
//
//
// Example 5:
//
//
// Input: root = [[1,null],null,[2,null],null,[1,null]]
// Output: [[1,null],null,[2,null],null,[1,null]]
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 1000].
// Each node's value is between [1, 10^6].
//
// Related Topics Hash Table Tree Depth-first Search Breadth-first Search
// 👍 94 👎 18

// leetcode submit region begin(Prohibit modification and deletion)

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for Node. public class Node { int val; Node left; Node right; Node random; Node() {}
 * Node(int val) { this.val = val; } Node(int val, Node left, Node right, Node random) { this.val =
 * val; this.left = left; this.right = right; this.random = random; } }
 */
/*
 O(n) Runtime: 6 ms, faster than 99.64% of Java online submissions for Clone Binary Tree With Random Pointer.
 O(n) Memory Usage: 40.7 MB, less than 11.41% of Java online submissions for Clone Binary Tree With Random Pointer.
*/
public class CloneBinaryTreeWithRandomPointer_1485 {
  public NodeCopy copyRandomBinaryTree(Node root) {
    return copyDfs(root, new HashMap<>());
  }

  private NodeCopy copyDfs(Node root, Map<Node, NodeCopy> visited) {
    if (root == null) {
      return null;
    }
    if (visited.containsKey(root)) {
      return visited.get(root);
    }
    NodeCopy copy = new NodeCopy(root.val);
    visited.put(root, copy);
    copy.left = copyDfs(root.left, visited);
    copy.right = copyDfs(root.right, visited);
    copy.random = copyDfs(root.random, visited);
    return copy;
  }

  private static class Node {
    int val;
    Node left;
    Node right;
    Node random;

    Node() {}

    Node(int val) {
      this.val = val;
    }

    Node(int val, Node left, Node right, Node random) {
      this.val = val;
      this.left = left;
      this.right = right;
      this.random = random;
    }
  }

  private static class NodeCopy {
    int val;
    NodeCopy left;
    NodeCopy right;
    NodeCopy random;

    NodeCopy() {}

    NodeCopy(int val) {
      this.val = val;
    }

    NodeCopy(int val, NodeCopy left, NodeCopy right, NodeCopy random) {
      this.val = val;
      this.left = left;
      this.right = right;
      this.random = random;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
