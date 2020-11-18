package com.leetcode.tree.medium;

// Given the root of a binary tree, return an array of the largest value in each
// row of the tree (0-indexed).
//
//
//
//
// Example 1:
//
//
// Input: root = [1,3,2,5,3,null,9]
// Output: [1,3,9]
//
//
// Example 2:
//
//
// Input: root = [1,2,3]
// Output: [1,3]
//
//
// Example 3:
//
//
// Input: root = [1]
// Output: [1]
//
//
// Example 4:
//
//
// Input: root = [1,null,2]
// Output: [1,2]
//
//
// Example 5:
//
//
// Input: root = []
// Output: []
//
//
//
// Constraints:
//
//
// The number of nodes in the tree will be in the range [0, 104].
// -231 <= Node.val <= 231 - 1
//
// Related Topics Tree Depth-first Search Breadth-first Search
// 👍 1089 👎 68

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Largest Value in Each Tree Row.
 O(n) Memory Usage: 39.4 MB, less than 49.17% of Java online submissions for Find Largest Value in Each Tree Row.
*/
public class FindLargestValueInEachTreeRow_515 {
  public List<Integer> largestValues(TreeNode root) {
    List<Integer> result = new ArrayList<>();

    largestValuesDfs(root, 0, result);

    return result;
  }

  private void largestValuesDfs(TreeNode root, int depth, List<Integer> result) {
    if (root == null) {
      return;
    }

    if (result.size() <= depth) {
      result.add(root.val);
    } else {
      result.set(depth, Math.max(result.get(depth), root.val));
    }

    largestValuesDfs(root.left, depth + 1, result);
    largestValuesDfs(root.right, depth + 1, result);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
