package com.leetcode.tree.medium;

//
// Given the root of a tree, you are asked to find the most frequent subtree sum.
// The subtree sum of a node is defined as the sum of all the node values formed b
// y the subtree rooted at that node (including the node itself). So what is the mo
// st frequent subtree sum value? If there is a tie, return all the values with the
// highest frequency in any order.
//
//
// Examples 1
// Input:
//
//  5
// /  \
// 2   -3
//
// return [2, -3, 4], since all the values happen only once, return all of them i
// n any order.
//
//
// Examples 2
// Input:
//
//  5
// /  \
// 2   -5
//
// return [2], since 2 happens twice, however -5 only occur once.
//
//
// Note:
// You may assume the sum of values in any subtree is in the range of 32-bit sign
// ed integer.
// Related Topics Hash Table Tree
// 👍 769 👎 140

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
  O(n) Runtime: 11 ms, faster than 7.89% of Java online submissions for Most Frequent Subtree Sum.
  O(n) Memory Usage: 39.4 MB, less than 70.87% of Java online submissions for Most Frequent Subtree Sum.
*/
public class MostFrequentSubtreeSum_508 {
  public int[] findFrequentTreeSum(TreeNode root) {
    Map<Integer, Integer> map = new HashMap<>();
    sumDfs(root, map);
    return map.values().stream().mapToInt(i -> i).max().stream()
        .flatMap(
            maxVal ->
                map.entrySet().stream()
                    .filter(entry -> entry.getValue() == maxVal)
                    .map(Map.Entry::getKey)
                    .mapToInt(i -> i))
        .toArray();
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
