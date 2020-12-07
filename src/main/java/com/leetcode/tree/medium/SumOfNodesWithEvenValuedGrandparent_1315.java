package com.leetcode.tree.medium;

// Given a binary tree, return the sum of values of nodes with even-valued grandp
// arent. (A grandparent of a node is the parent of its parent, if it exists.)
//
// If there are no nodes with an even-valued grandparent, return 0.
//
//
// Example 1:
//
//
//
//
// Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
// Output: 18
// Explanation: The red nodes are the nodes with even-value grandparent while the
// blue nodes are the even-value grandparents.
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is between 1 and 10^4.
// The value of nodes is between 1 and 100.
// Related Topics Tree Depth-first Search
// 👍 697 👎 29

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 1 ms, faster than 98.56% of Java online submissions for Sum of Nodes with Even-Valued Grandparent.
 O(h) Memory Usage: 40.4 MB, less than 86.19% of Java online submissions for Sum of Nodes with Even-Valued Grandparent.
*/
public class SumOfNodesWithEvenValuedGrandparent_1315 {
  public int sumEvenGrandparent(TreeNode root) {
    return sumDfs(root, false, false);
  }

  private int sumDfs(TreeNode root, boolean isGpEven, boolean isParentEven) {
    if (root == null) {
      return 0;
    }
    int sum =
        sumDfs(root.left, isParentEven, root.val % 2 == 0)
            + sumDfs(root.right, isParentEven, root.val % 2 == 0);
    return isGpEven ? sum + root.val : sum;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
