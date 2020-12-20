package com.leetcode.tree.medium;

//
// Given an integer array with no duplicates. A maximum tree building on this arr
// ay is defined as follow:
//
// The root is the maximum number in the array.
// The left subtree is the maximum tree constructed from left part subarray divi
// ded by the maximum number.
// The right subtree is the maximum tree constructed from right part subarray di
// vided by the maximum number.
//
//
//
//
// Construct the maximum tree by the given array and output the root node of this
// tree.
//
//
// Example 1:
//
// Input: [3,2,1,6,0,5]
// Output: return the tree root node representing the following tree:
//
//      6
//    /   \
//   3     5
//    \    /
//     2  0
//       \
//        1
//
//
//
// Note:
//
// The size of the given array will be in the range [1,1000].
//
// Related Topics Tree
// 👍 2198 👎 260

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
  O(n^2) Runtime: 2 ms, faster than 88.43% of Java online submissions for Maximum Binary Tree.
  (n)    Memory Usage: 39 MB, less than 88.00% of Java online submissions for Maximum Binary Tree.
*/
public class MaximumBinaryTree_654 {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return constructDfs(nums, 0, nums.length);
  }

  private TreeNode constructDfs(int[] nums, int left, int right) {
    if (left >= right) {
      return null;
    }
    int maxIndex = maxIndex(nums, left, right);
    TreeNode node = new TreeNode(nums[maxIndex]);
    node.left = constructDfs(nums, left, maxIndex);
    node.right = constructDfs(nums, maxIndex + 1, right);
    return node;
  }

  private int maxIndex(int[] nums, int left, int right) {
    int maxIndex = left;
    int max = nums[left];
    for (int i = left + 1; i < right; i++) {
      if (nums[i] > max) {
        max = nums[i];
        maxIndex = i;
      }
    }

    return maxIndex;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
