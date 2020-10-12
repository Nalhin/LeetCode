package com.leetcode.bst.medium;

// Serialization is converting a data structure or object into a sequence of bits
// so that it can be stored in a file or memory buffer, or transmitted across a ne
// twork connection link to be reconstructed later in the same or another computer
// environment.
//
// Design an algorithm to serialize and deserialize a binary search tree. There
// is no restriction on how your serialization/deserialization algorithm should wor
// k. You need to ensure that a binary search tree can be serialized to a string, a
// nd this string can be deserialized to the original tree structure.
//
// The encoded string should be as compact as possible.
//
//
// Example 1:
// Input: root = [2,1,3]
// Output: [2,1,3]
// Example 2:
// Input: root = []
// Output: []
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 104].
// 0 <= Node.val <= 104
// The input tree is guaranteed to be a binary search tree.
//
// Related Topics Tree
// 👍 1490 👎 78

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
public class SerializeAndDeserializeBST_449 {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    StringBuilder result = new StringBuilder();

    while (!queue.isEmpty()) {
      TreeNode node = queue.remove();
      if (node != null) {
        queue.add(node.left);
        queue.add(node.right);
      }
      result.append(",");
      result.append(node == null ? "null" : node.val);
    }
    result.deleteCharAt(0);
    return result.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] nodes = data.split(",");
    TreeNode result = treeNodeOf(nodes[0]);

    if (result == null) {
      return null;
    }

    int curr = 1;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(result);

    while (!queue.isEmpty()) {
      TreeNode parent = queue.remove();
      parent.left = treeNodeOf(nodes[curr++]);
      parent.right = treeNodeOf(nodes[curr++]);

      if (parent.left != null) {
        queue.add(parent.left);
      }
      if (parent.right != null) {
        queue.add(parent.right);
      }
    }

    return result;
  }

  private TreeNode treeNodeOf(String node) {
    if (node.equals("null")) {
      return null;
    }
    return new TreeNode(Integer.parseInt(node));
  }
}
/*
 O(n) Runtime: 8 ms, faster than 57.16% of Java online submissions for Serialize and Deserialize BST.
 O(n) Memory Usage: 39.6 MB, less than 7.96% of Java online submissions for Serialize and Deserialize BST.
*/

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
// leetcode submit region end(Prohibit modification and deletion)
