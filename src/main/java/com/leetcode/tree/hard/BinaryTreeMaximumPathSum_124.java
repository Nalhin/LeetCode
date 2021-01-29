package com.leetcode.tree.hard;

// A path in a binary tree is a sequence of nodes where each pair of adjacent nod
// es in the sequence has an edge connecting them. A node can only appear in the se
// quence at most once. Note that the path does not need to pass through the root.
//
//
// The path sum of a path is the sum of the node's values in the path.
//
// Given the root of a binary tree, return the maximum path sum of any path.
//
//
// Example 1:
//
//
// Input: root = [1,2,3]
// Output: 6
// Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
//
//
//
// Example 2:
//
//
// Input: root = [-10,9,20,null,null,15,7]
// Output: 42
// Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7
// = 42.
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 3 * 104].
// -1000 <= Node.val <= 1000
//
// Related Topics Tree Depth-first Search Recursion
// 👍 5018 👎 368

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Maximum Path Sum.
 O(h) Memory Usage: 40.7 MB, less than 86.68% of Java online submissions for Binary Tree Maximum Path Sum.
*/
public class BinaryTreeMaximumPathSum_124 {
  private int result = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    result = Math.max(dfs(root), result);
    return result;
  }

  private int dfs(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = dfs(root.left);
    int right = dfs(root.right);

    int maxReturn = Math.max(Math.max(left + root.val, right + root.val), root.val);
    result = Math.max(Math.max(result, maxReturn), left + right + root.val);

    return maxReturn;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
