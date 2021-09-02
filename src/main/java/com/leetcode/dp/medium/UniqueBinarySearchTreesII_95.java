package com.leetcode.dp.medium;

// Given an integer n, return all the structurally unique BST's (binary search
// trees), which has exactly n nodes of unique values from 1 to n. Return the answer
// in any order.
//
//
// Example 1:
//
//
// Input: n = 3
// Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]
// ]
//
//
// Example 2:
//
//
// Input: n = 1
// Output: [[1]]
//
//
//
// Constraints:
//
//
// 1 <= n <= 8
//
// Related Topics Dynamic Programming Backtracking Tree Binary Search Tree
// Binary Tree 👍 3604 👎 236
/*
 Runtime: 0 ms, faster than 100% of Java online submissions for Unique Binary Search Trees II.
 Memory Usage: 38.7 MB, less than 99.29% of Java online submissions for Unique Binary Search Trees II.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class UniqueBinarySearchTreesII_95 {
  private static final int MAX_N = 8;

  public List<TreeNode> generateTrees(int n) {
    Map<Integer, List<TreeNode>> cache = new HashMap<>();
    return generateTreesBetween(1, n, cache);
  }

  private List<TreeNode> generateTreesBetween(
      int min, int max, Map<Integer, List<TreeNode>> cache) {
    if (max < min) {
      List<TreeNode> list = new ArrayList<>();
      list.add(null);
      return list;
    }

    int key = hash(min, max);
    if (cache.containsKey(key)) {
      return cache.get(key);
    }

    List<TreeNode> result = new ArrayList<>();

    for (int i = min; i <= max; i++) {
      List<TreeNode> leftSubtrees = generateTreesBetween(min, i - 1, cache);
      List<TreeNode> rightSubtrees = generateTreesBetween(i + 1, max, cache);

      for (TreeNode l : leftSubtrees) {
        for (TreeNode r : rightSubtrees) {
          result.add(new TreeNode(i, l, r));
        }
      }
    }

    cache.put(key, result);
    return result;
  }

  private int hash(int min, int max) {
    return min + max * MAX_N;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
