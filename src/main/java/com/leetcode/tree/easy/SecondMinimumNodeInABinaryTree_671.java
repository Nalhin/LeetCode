package com.leetcode.tree.easy;

// Given a non-empty special binary tree consisting of nodes with the non-negativ
// e value, where each node in this tree has exactly two or zero sub-node. If the n
// ode has two sub-nodes, then this node's value is the smaller value among its two
// sub-nodes. More formally, the property root.val = min(root.left.val, root.right
// .val) always holds.
//
// Given such a binary tree, you need to output the second minimum value in the
// set made of all the nodes' value in the whole tree.
//
// If no such second minimum value exists, output -1 instead.
//
//
//
//
// Example 1:
//
//
// Input: root = [2,2,5,null,null,5,7]
// Output: 5
// Explanation: The smallest value is 2, the second smallest value is 5.
//
//
// Example 2:
//
//
// Input: root = [2,2,2]
// Output: -1
// Explanation: The smallest value is 2, but there isn't any second smallest valu
// e.
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 25].
// 1 <= Node.val <= 231 - 1
// root.val == min(root.left.val, root.right.val) for each internal node of the
// tree.
//
// Related Topics Tree
// 👍 709 👎 961

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.*;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Second Minimum Node In a Binary Tree.
  O(h) Memory Usage: 36.1 MB, less than 89.10% of Java online submissions for Second Minimum Node In a Binary Tree.
*/
public class SecondMinimumNodeInABinaryTree_671 {
  public int findSecondMinimumValue(TreeNode root) {
    long[] mins = new long[2];
    Arrays.fill(mins, Long.MAX_VALUE);
    secondSmallest(root, mins);
    return mins[1] == Long.MAX_VALUE ? -1 : (int) mins[1];
  }

  public void secondSmallest(TreeNode root, long[] vals) {
    if (root == null) {
      return;
    }

    if (vals[0] > root.val) {
      vals[1] = vals[0];
      vals[0] = root.val;
    } else if (vals[0] != root.val) {
      vals[1] = Math.min(root.val, vals[1]);
    }

    secondSmallest(root.left, vals);
    secondSmallest(root.right, vals);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
