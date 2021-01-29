package com.leetcode.tree.hard;

// Given the root of a binary tree, calculate the vertical order traversal of the
// binary tree.
//
// For each node at position (x, y), its left and right children will be at posi
// tions (x - 1, y - 1) and (x + 1, y - 1) respectively.
//
// The vertical order traversal of a binary tree is a list of non-empty reports
// for each unique x-coordinate from left to right. Each report is a list of all no
// des at a given x-coordinate. The report should be primarily sorted by y-coordina
// te from highest y-coordinate to lowest. If any two nodes have the same y-coordin
// ate in the report, the node with the smaller value should appear earlier.
//
// Return the vertical order traversal of the binary tree.
//
//
// Example 1:
//
//
// Input: root = [3,9,20,null,null,15,7]
// Output: [[9],[3,15],[20],[7]]
// Explanation: Without loss of generality, we can assume the root node is at pos
// ition (0, 0):
// The node with value 9 occurs at position (-1, -1).
// The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2).
// The node with value 20 occurs at position (1, -1).
// The node with value 7 occurs at position (2, -2).
//
// Example 2:
//
//
// Input: root = [1,2,3,4,5,6,7]
// Output: [[4],[2],[1,5,6],[3],[7]]
// Explanation: The node with value 5 and the node with value 6 have the same pos
// ition according to the given scheme.
// However, in the report [1,5,6], the node with value 5 comes first since 5 is s
// maller than 6.
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 1000].
// 0 <= Node.val <= 1000
//
// Related Topics Hash Table Tree Depth-first Search Breadth-first Search
// 👍 1156 👎 2246

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(nlog(n/k)) Runtime: 5 ms, faster than 20.14% of Java online submissions for Vertical Order Traversal of a Binary Tree.
 O(n) Memory Usage: 39.4 MB, less than 28.79% of Java online submissions for Vertical Order Traversal of a Binary Tree.
*/
public class VerticalOrderTraversalOfABinaryTree_987 {
  public List<List<Integer>> verticalTraversal(TreeNode root) {
    Map<Integer, List<int[]>> map = new HashMap<>();
    dfs(root, 0, 0, map);

    int min = Collections.min(map.keySet());
    int max = Collections.max(map.keySet());
    List<List<Integer>> result = new ArrayList<>();

    for (int column = min; column <= max; column++) {
      result.add(
          map.get(column).stream()
              .sorted((a, b) -> a[1] - b[1] == 0 ? a[0] - b[0] : b[1] - a[1])
              .map(el -> el[0])
              .collect(Collectors.toList()));
    }

    return result;
  }

  private void dfs(
      TreeNode root, int verticalLevel, int horizontalLevel, Map<Integer, List<int[]>> map) {
    if (root == null) {
      return;
    }

    List<int[]> level = map.getOrDefault(verticalLevel, new ArrayList<>());
    level.add(new int[] {root.val, horizontalLevel});
    map.put(verticalLevel, level);

    dfs(root.left, verticalLevel - 1, horizontalLevel - 1, map);
    dfs(root.right, verticalLevel + 1, horizontalLevel - 1, map);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
