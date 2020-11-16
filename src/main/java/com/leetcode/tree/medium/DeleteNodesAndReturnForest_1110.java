package com.leetcode.tree.medium;

// Given the root of a binary tree, each node in the tree has a distinct value.
//
// After deleting all nodes with a value in to_delete, we are left with a forest
// (a disjoint union of trees).
//
// Return the roots of the trees in the remaining forest. You may return the res
// ult in any order.
//
//
// Example 1:
//
//
//
//
// Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
// Output: [[1,2,null,4],[6],[7]]
//
//
//
// Constraints:
//
//
// The number of nodes in the given tree is at most 1000.
// Each node has a distinct value between 1 and 1000.
// to_delete.length <= 1000
// to_delete contains distinct values between 1 and 1000.
// Related Topics Tree Depth-first Search
// 👍 1425 👎 48

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 2 ms, faster than 30.93% of Java online submissions for Delete Nodes And Return Forest.
 O(n) Memory Usage: 40 MB, less than 27.33% of Java online submissions for Delete Nodes And Return Forest.
*/
public class DeleteNodesAndReturnForest_1110 {
  public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
    Set<TreeNode> resultSet = new HashSet<>();

    Set<Integer> toDeleteSet = new HashSet<>();
    for (int val : toDelete) {
      toDeleteSet.add(val);
    }

    delDfs(root, root, toDeleteSet, resultSet);

    return new ArrayList<>(resultSet);
  }

  private TreeNode delDfs(
      TreeNode root, TreeNode parent, Set<Integer> toDelete, Set<TreeNode> resultSet) {
    if (root == null) {
      if (parent != null) {
        resultSet.add(parent);
      }
      return null;
    }

    if (toDelete.contains(root.val)) {
      delDfs(root.left, root.left, toDelete, resultSet);
      delDfs(root.right, root.right, toDelete, resultSet);
      if (!toDelete.contains(parent.val)) {
        resultSet.add(parent);
      }
      return null;
    }

    root.left = delDfs(root.left, parent, toDelete, resultSet);
    root.right = delDfs(root.right, parent, toDelete, resultSet);

    return root;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
