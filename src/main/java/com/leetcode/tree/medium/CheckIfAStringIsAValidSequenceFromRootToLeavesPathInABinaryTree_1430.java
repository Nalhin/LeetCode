package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree.TreeNode;
//Given a binary tree where each path going from the root to any leaf form a val
//id sequence, check if a given string is a valid sequence in such binary tree.
//
// We get the given string from the concatenation of an array of integers arr an
//d the concatenation of all values of the nodes along a path results in a sequenc
//e in the given binary tree.
//
//
// Example 1:
//
//
//
//
//Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
//Output: true
//Explanation:
//The path 0 -> 1 -> 0 -> 1 is a valid sequence (green color in the figure).
//Other valid sequences are:
//0 -> 1 -> 1 -> 0
//0 -> 0 -> 0
//
//
// Example 2:
//
//
//
//
//Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
//Output: false
//Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a s
//equence.
//
//
// Example 3:
//
//
//
//
//Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,1]
//Output: false
//Explanation: The path 0 -> 1 -> 1 is a sequence, but it is not a valid sequenc
//e.
//
//
//
// Constraints:
//
//
// 1 <= arr.length <= 5000
// 0 <= arr[i] <= 9
// Each node's value is between [0 - 9].
//
// Related Topics Tree
// 👍 61 👎 4


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree_1430 {
  public boolean isValidSequence(TreeNode root, int[] arr) {
    return isValidDFS(root, arr, 0);
  }

  private boolean isValidDFS(TreeNode root, int[] arr, int index) {
    if(root == null || index >= arr.length || arr[index] != root.val){
      return false;
    }

    if(root.left == null && root.right == null){
      return index + 1 == arr.length ;
    }

    return isValidDFS(root.left, arr, index + 1) || isValidDFS(root.right, arr, index + 1);
  }
}

/*
   O(min(2^n, m), n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree.
   O(n) Memory Usage: 40.2 MB, less than 69.50% of Java online submissions for Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree.
 */
//leetcode submit region end(Prohibit modification and deletion)
