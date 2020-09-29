package com.leetcode.bst.medium;

// Given the root of a binary tree, return all duplicate subtrees.
//
// For each kind of duplicate subtrees, you only need to return the root node of
// any one of them.
//
// Two trees are duplicate if they have the same structure with the same node va
// lues.
//
//
// Example 1:
//
//
// Input: root = [1,2,3,4,null,2,4,null,null,4]
// Output: [[2,4],[4]]
//
//
// Example 2:
//
//
// Input: root = [2,1,1]
// Output: [[1]]
//
//
// Example 3:
//
//
// Input: root = [2,2,2,3,null,3,null]
// Output: [[2,3],[3]]
//
//
//
// Constraints:
//
//
// The number of the nodes in the tree will be in the range [1, 10^4]
// -200 <= Node.val <= 200
//
// Related Topics Tree
// 👍 1478 👎 214

// leetcode submit region begin(Prohibit modification and deletion)

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */

// leetcode submit region end(Prohibit modification and deletion)
import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees_652 {
  HashMap<String, TreeNode> result = new HashMap<>();
  HashMap<String, Integer> serializedNodes = new HashMap<>();
  int uniqueId = 0;

  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    traverseDFS(root);
    return new ArrayList<>(result.values());
  }

  public int traverseDFS(TreeNode node) {
    if (node == null) {
      return -201;
    }

    int left = traverseDFS(node.left);
    int right = traverseDFS(node.right);
    String serialized = left + "#" + right + "#" + node.val;
    int id = serializedNodes.computeIfAbsent(serialized, (a) -> uniqueId++);

    if (serializedNodes.containsKey(serialized)) {
      result.put(serialized, node);
    }

    serializedNodes.put(serialized, id);
    return id;
  }
}

/*
O(n) Runtime: 13 ms, faster than 91.45% of Java online submissions for Find Duplicate Subtrees.
O(n) Memory Usage: 40.9 MB, less than 98.65% of Java online submissions for Find Duplicate Subtrees.
*/
// leetcode submit region end(Prohibit modification and deletion)
