package com.leetcode.tree.medium;

// Given the root of a binary tree and an integer targetSum, return the number
// of paths where the sum of the values along the path equals targetSum.
//
// The path does not need to start or end at the root or a leaf, but it must go
// downwards (i.e., traveling only from parent nodes to child nodes).
//
//
// Example 1:
//
//
// Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
// Output: 3
// Explanation: The paths that sum to 8 are shown.
//
//
// Example 2:
//
//
// Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// Output: 3
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [0, 1000].
// -10⁹ <= Node.val <= 10⁹
// -1000 <= targetSum <= 1000
//
// Related Topics Tree Depth-First Search Binary Tree 👍 6376 👎 339
/*
 O(n) Runtime: 2 ms, faster than 100.00% of Java online submissions for Path Sum III.
 O(n) Memory Usage: 38.9 MB, less than 67.94% of Java online submissions for Path Sum III.
*/
// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class PathSumIII_437 {

  public int pathSum(TreeNode root, int targetSum) {
    Map<Integer, Integer> map = new HashMap<>();

    return prefixDfs(root, targetSum, 0, map);
  }

  private int prefixDfs(TreeNode root, int target, int prefixSum, Map<Integer, Integer> map) {
    if (root == null) {
      return 0;
    }

    int result = 0;

    prefixSum += root.val;
    if (prefixSum == target) {
      result++;
    }

    result += map.getOrDefault(prefixSum - target, 0);
    map.merge(prefixSum, 1, Integer::sum);

    int sumLeft = prefixDfs(root.left, target, prefixSum, map);
    int sumRight = prefixDfs(root.right, target, prefixSum, map);

    map.merge(prefixSum, -1, Integer::sum);

    return result + sumLeft + sumRight;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
