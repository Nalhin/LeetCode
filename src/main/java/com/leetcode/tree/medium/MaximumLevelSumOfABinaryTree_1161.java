package com.leetcode.tree.medium;

// Given the root of a binary tree, the level of its root is 1, the level of its
// children is 2, and so on.
//
// Return the smallest level X such that the sum of all the values of nodes at l
// evel X is maximal.
//
//
// Example 1:
//
//
// Input: root = [1,7,0,7,-8,null,null]
// Output: 2
// Explanation:
// Level 1 sum = 1.
// Level 2 sum = 7 + 0 = 7.
// Level 3 sum = 7 + -8 = -1.
// So we return the level with the maximum sum which is level 2.
//
//
// Example 2:
//
//
// Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
// Output: 2
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 104].
// -105 <= Node.val <= 105
//
// Related Topics Tree Breadth-first Search
// 👍 596 👎 28

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */

/*
  O(n) Runtime: 6 ms, faster than 96.25% of Java online submissions for Maximum Level Sum of a Binary Tree.
  O(h) Memory Usage: 42.1 MB, less than 56.21% of Java online submissions for Maximum Level Sum of a Binary Tree.
*/
public class MaximumLevelSumOfABinaryTree_1161 {
  public int maxLevelSum(TreeNode root) {
    List<Integer> levels = new ArrayList<>();
    maxLevelSumDfs(root, 0, levels);

    int maxLevel = 0;
    int maxSum = Integer.MIN_VALUE;
    for (int i = 0; i < levels.size(); i++) {
      int levelSum = levels.get(i);
      if (levelSum > maxSum) {
        maxLevel = i + 1;
        maxSum = levelSum;
      }
    }

    return maxLevel;
  }

  private void maxLevelSumDfs(TreeNode root, int depth, List<Integer> result) {
    if (root == null) {
      return;
    }

    if (result.size() <= depth) {
      result.add(root.val);
    } else {
      result.set(depth, result.get(depth) + root.val);
    }

    maxLevelSumDfs(root.left, depth + 1, result);
    maxLevelSumDfs(root.right, depth + 1, result);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
