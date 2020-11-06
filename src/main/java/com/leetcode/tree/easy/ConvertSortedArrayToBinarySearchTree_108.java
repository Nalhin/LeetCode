package com.leetcode.tree.easy;

// Given an array where elements are sorted in ascending order, convert it to a h
// eight balanced BST.
//
// For this problem, a height-balanced binary tree is defined as a binary tree i
// n which the depth of the two subtrees of every node never differ by more than 1.
//
//
// Example:
//
//
// Given the sorted array: [-10,-3,0,5,9],
//
// One possible answer is: [0,-3,9,-10,null,5], which represents the following he
// ight balanced BST:
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//
// Related Topics Tree Depth-first Search
// 👍 2988 👎 231

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n)  Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
 O(log(n)) Memory Usage: 38.7 MB, less than 12.45% of Java online submissions for Convert Sorted Array to Binary Search Tree.
*/
public class ConvertSortedArrayToBinarySearchTree_108 {
  public TreeNode sortedArrayToBST(int[] nums) {
    return toBst(nums, 0, nums.length - 1);
  }

  private TreeNode toBst(int[] nums, int first, int last) {
    if (first > last) {
      return null;
    }
    int mid = (first + last) >>> 1;

    TreeNode root = new TreeNode(nums[mid]);

    root.left = toBst(nums, first, mid - 1);
    root.right = toBst(nums, mid + 1, last);
    return root;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
