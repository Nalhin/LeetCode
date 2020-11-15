package com.leetcode.tree.medium;

// Given a binary tree, return the sum of values of its deepest leaves.
//
// Example 1:
//
//
//
//
// Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
// Output: 15
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is between 1 and 10^4.
// The value of nodes is between 1 and 100.
// Related Topics Tree Depth-first Search
// 👍 797 👎 44

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 4 ms, faster than 27.47% of Java online submissions for Deepest Leaves Sum.
 O(n) Memory Usage: 40.8 MB, less than 46.38% of Java online submissions for Deepest Leaves Sum.
*/
public class DeepestLeavesSum_1302 {
  public int deepestLeavesSum(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Deque<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      int sum = 0;

      for (int i = 0; i < size; i++) {
        TreeNode node = queue.pop();
        sum += node.val;

        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }

      if (queue.isEmpty()) {
        return sum;
      }
    }

    return 0;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
