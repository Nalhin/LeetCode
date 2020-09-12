package easy;// Given a binary tree, each node has value 0 or 1. Each root-to-leaf path repres
// ents a binary number starting with the most significant bit. For example, if the
// path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which
// is 13.
//
// For all leaves in the tree, consider the numbers represented by the path from
// the root to that leaf.
//
// Return the sum of these numbers.
//
//
//
// Example 1:
//
//
//
//
// Input: [1,0,1,0,1,0,1]
// Output: 22
// Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
//
//
//
//
// Note:
//
//
// The number of nodes in the tree is between 1 and 1000.
// node.val is 0 or 1.
// The answer will not exceed 2^31 - 1.
//
// Related Topics Tree
// 👍 602 👎 74

// leetcode submit region begin(Prohibit modification and deletion)


import utils.BinaryTree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class SumOfRootToLeftBinaryNumbers_1022 {
  public static class StringBasedSolution {

    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
      inOrderTraversal(root, String.valueOf(root.val));
      return sum;
    }

    private void inOrderTraversal(TreeNode node, String path) {
      if (node.left != null) {
        inOrderTraversal(node.left, path + node.left.val);
      }
      if (node.right != null) {
        inOrderTraversal(node.right, path + node.right.val);
      }

      if (node.left == null && node.right == null && !path.isEmpty()) {
        sum += Integer.valueOf(path, 2);
      }
    }
  }

  public static class BinaryShiftSolution {
    int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
      postOrderTraversal(root, 0);
      return sum;
    }

    private void postOrderTraversal(TreeNode node, int currVal) {
      int val = (currVal << 1) | node.val;
      if (node.left != null) {
        postOrderTraversal(node.left, val);
      }
      if (node.right != null) {
        postOrderTraversal(node.right, val);
      }

      if (node.left == null && node.right == null) {
        sum += val;
      }
    }
  }
}

// leetcode submit region end(Prohibit modification and deletion)
