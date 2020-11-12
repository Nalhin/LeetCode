package com.leetcode.tree.medium;

// Given a binary tree, collect a tree's nodes as if you were doing this: Collect
// and remove all leaves, repeat until the tree is empty.
//
//
//
// Example:
//
//
// Input: [1,2,3,4,5]
//
//           1
//         / \
//        2   3
//       / \
//      4   5
//
// Output: [[4,5,3],[2],[1]]
//
//
//
//
// Explanation:
//
// 1. Removing the leaves [4,5,3] would result in this tree:
//
//
//          1
//         /
//        2
//
//
//
//
// 2. Now removing the leaf [2] would result in this tree:
//
//
//          1
//
//
//
//
// 3. Now removing the leaf [1] would result in the empty tree:
//
//
//          []
//
// [[3,5,4],[2],[1]], [[3,4,5],[2],[1]], etc, are also consider correct answers s
// ince per each level it doesn't matter the order on which elements are returned.
// Related Topics Tree Depth-first Search
// 👍 1180 👎 17

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
 O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Leaves of Binary Tree.
 O(n) Memory Usage: 37.7 MB, less than 8.57% of Java online submissions for Find Leaves of Binary Tree.
*/
public class FindLeavesOfBinaryTree_366 {
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    findLeavesDfs(root, result);
    return result;
  }

  private int findLeavesDfs(TreeNode root, List<List<Integer>> result) {
    if (root == null) {
      return 0;
    }

    int levelLeft = findLeavesDfs(root.left, result);
    int levelRight = findLeavesDfs(root.right, result);

    int curr = Math.max(levelLeft, levelRight);

    if (result.size() <= curr) {
      result.add(new ArrayList<>());
    }

    result.get(curr).add(root.val);

    return curr + 1;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
