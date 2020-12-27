package com.leetcode.tree.medium;

//
// Given a binary tree with n nodes, your task is to check if it's possible to pa
// rtition the tree to two trees which have the equal sum of values after removing
// exactly one edge on the original tree.
//
//
// Example 1:
//
// Input:
//    5
//   / \
//  10 10
//    /  \
//   2   3
//
// Output: True
// Explanation:
//    5
//   /
//  10
//
// Sum: 15
//
//   10
//  /  \
// 2    3
//
// Sum: 15
//
//
//
//
// Example 2:
//
// Input:
//    1
//   / \
//  2  10
//    /  \
//   2   20
//
// Output: False
// Explanation: You can't split the tree into two trees with equal sum after remo
// ving exactly one edge on the tree.
//
//
//
// Note:
//
// The range of tree node value is in the range of [-100000, 100000].
// 1 <= n <= 10000
//
// Related Topics Tree
// 👍 312 👎 23

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 3 ms, faster than 35.23% of Java online submissions for Equal Tree Partition.
 O(n) Memory Usage: 41 MB, less than 17.61% of Java online submissions for Equal Tree Partition.
*/
public class EqualTreePartition_663 {
  public boolean checkEqualTree(TreeNode root) {
    Map<Integer, Integer> map = new HashMap<>();
    int sum = sumDfs(root, map);

    if (sum == 0) {
      return map.getOrDefault(0, 0) > 1;
    }
    return sum % 2 == 0 && map.containsKey(sum / 2);
  }

  private int sumDfs(TreeNode root, Map<Integer, Integer> map) {
    if (root == null) {
      return 0;
    }
    int sum = sumDfs(root.left, map) + sumDfs(root.right, map) + root.val;
    map.put(sum, map.getOrDefault(sum, 0) + 1);
    return sum;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
