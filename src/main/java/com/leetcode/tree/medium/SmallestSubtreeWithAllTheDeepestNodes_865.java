package com.leetcode.tree.medium;

// Given the root of a binary tree, the depth of each node is the shortest distan
// ce to the root.
//
// Return the smallest subtree such that it contains all the deepest nodes in th
// e original tree.
//
// A node is called the deepest if it has the largest depth possible among any n
// ode in the entire tree.
//
// The subtree of a node is tree consisting of that node, plus the set of all de
// scendants of that node.
//
// Note: This question is the same as 1123: https://leetcode.com/problems/lowest
// -common-ancestor-of-deepest-leaves/
//
//
// Example 1:
//
//
// Input: root = [3,5,1,6,2,0,8,null,null,7,4]
// Output: [2,7,4]
// Explanation: We return the node with value 2, colored in yellow in the diagram
// .
// The nodes coloured in blue are the deepest nodes of the tree.
// Notice that nodes 5, 3 and 2 contain the deepest nodes in the tree but node 2
// is the smallest subtree among them, so we return it.
//
//
// Example 2:
//
//
// Input: root = [1]
// Output: [1]
// Explanation: The root is the deepest node in the tree.
//
//
// Example 3:
//
//
// Input: root = [0,1,3,null,2]
// Output: [2]
// Explanation: The deepest node in the tree is 2, the valid subtrees are the sub
// trees of nodes 2, 1 and 0 but the subtree of node 2 is the smallest.
//
//
//
// Constraints:
//
//
// The number of nodes in the tree will be in the range [1, 500].
// 0 <= Node.val <= 500
// The values of the nodes in the tree are unique.
// Related Topics Tree Depth-first Search Breadth-first Search Recursion
// 👍 944 👎 266

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.*;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 1 ms, faster than 29.50% of Java online submissions for Smallest Subtree with all the Deepest Nodes.
 O(n) Memory Usage: 38.2 MB, less than 46.03% of Java online submissions for Smallest Subtree with all the Deepest Nodes.
*/
public class SmallestSubtreeWithAllTheDeepestNodes_865 {
  private int maxDepth = 0;

  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    Map<TreeNode, TreeNode> parents = new HashMap<>();
    List<TreeNode> maxDepthNodes = new ArrayList<>();

    collectLevelsDfs(root, 0, parents, maxDepthNodes);

    Deque<TreeNode> deque = new ArrayDeque<>(maxDepthNodes);
    Set<TreeNode> visited = new HashSet<>();

    while (deque.size() > 1) {
      TreeNode top = deque.pop();
      TreeNode parent = parents.get(top);
      if (!visited.contains(parent)) {
        deque.add(parent);
        visited.add(parent);
      }
    }
    return deque.pop();
  }

  private void collectLevelsDfs(
      TreeNode root, int depth, Map<TreeNode, TreeNode> parents, List<TreeNode> maxDepthNodes) {
    if (depth > maxDepth) {
      maxDepthNodes.clear();
      maxDepth = depth;
    }
    if (depth >= maxDepth) {
      maxDepthNodes.add(root);
    }

    if (root.left != null) {
      parents.put(root.left, root);
      collectLevelsDfs(root.left, depth + 1, parents, maxDepthNodes);
    }
    if (root.right != null) {
      parents.put(root.right, root);
      collectLevelsDfs(root.right, depth + 1, parents, maxDepthNodes);
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
