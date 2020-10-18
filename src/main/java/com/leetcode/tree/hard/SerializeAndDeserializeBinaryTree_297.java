package com.leetcode.tree.hard;

// Serialization is the process of converting a data structure or object into a s
// equence of bits so that it can be stored in a file or memory buffer, or transmit
// ted across a network connection link to be reconstructed later in the same or an
// other computer environment.
//
// Design an algorithm to serialize and deserialize a binary tree. There is no r
// estriction on how your serialization/deserialization algorithm should work. You
// just need to ensure that a binary tree can be serialized to a string and this st
// ring can be deserialized to the original tree structure.
//
// Clarification: The input/output format is the same as how LeetCode serializes
// a binary tree. You do not necessarily need to follow this format, so please be
// creative and come up with different approaches yourself.
//
//
// Example 1:
//
//
// Input: root = [1,2,3,null,null,4,5]
// Output: [1,2,3,null,null,4,5]
//
//
// Example 2:
//
//
// Input: root = []
// Output: []
//
//
// Example 3:
//
//
// Input: root = [1]
// Output: [1]
//
//
// Example 4:
//
//
// Input: root = [1,2]
// Output: [1,2]
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 104].
// -1000 <= Node.val <= 1000
//
// Related Topics Tree Design
// 👍 3511 👎 169

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// leetcode submit region end(Prohibit modification and deletion)
public class SerializeAndDeserializeBinaryTree_297 {
  public static class Codec {
    public String serialize(TreeNode root) {
      StringBuilder sb = new StringBuilder();

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(root);

      while (!queue.isEmpty()) {
        TreeNode curr = queue.remove();
        sb.append(",");
        if (curr == null) {
          sb.append("null");
          continue;
        } else {
          sb.append(curr.val);
        }

        queue.add(curr.left);
        queue.add(curr.right);
      }
      sb.deleteCharAt(0);
      return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
      String[] nodes = data.split(",");
      int currIndex = 1;
      TreeNode result = nodeFromString(nodes[0]);

      Queue<TreeNode> queue = new LinkedList<>();
      queue.add(result);

      while (currIndex < nodes.length) {
        TreeNode root = queue.remove();
        if (root == null) {
          continue;
        }
        root.left = nodeFromString(nodes[currIndex++]);
        root.right = nodeFromString(nodes[currIndex++]);
        queue.add(root.left);
        queue.add(root.right);
      }

      return result;
    }

    private TreeNode nodeFromString(String str) {
      if (str.equals("null")) {
        return null;
      }
      return new TreeNode(Integer.parseInt(str));
    }
  }
}
/*
  O(n)  Runtime: 11 ms, faster than 67.86% of Java online submissions for Serialize and Deserialize Binary Tree.
  O(n)  Memory Usage: 42 MB, less than 5.83% of Java online submissions for Serialize and Deserialize Binary Tree.
*/

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// leetcode submit region end(Prohibit modification and deletion)
