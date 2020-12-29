package com.leetcode.tree.medium;

// Given a binary tree where node values are digits from 1 to 9. A path in the bi
// nary tree is said to be pseudo-palindromic if at least one permutation of the no
// de values in the path is a palindrome.
//
// Return the number of pseudo-palindromic paths going from the root node to lea
// f nodes.
//
//
// Example 1:
//
//
//
//
// Input: root = [2,3,1,3,1,null,1]
// Output: 2
// Explanation: The figure above represents the given binary tree. There are thre
// e paths going from the root node to leaf nodes: the red path [2,3,3], the green
// path [2,1,1], and the path [2,3,1]. Among these paths only red path and green pa
// th are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in
// [3,2,3] (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (pa
// lindrome).
//
//
// Example 2:
//
//
//
//
// Input: root = [2,1,1,1,3,null,null,null,null,null,1]
// Output: 1
// Explanation: The figure above represents the given binary tree. There are thre
// e paths going from the root node to leaf nodes: the green path [2,1,1], the path
// [2,1,3,1], and the path [2,1]. Among these paths only the green path is pseudo-
// palindromic since [2,1,1] can be rearranged in [1,2,1] (palindrome).
//
//
// Example 3:
//
//
// Input: root = [9]
// Output: 1
//
//
//
// Constraints:
//
//
// The given binary tree will have between 1 and 10^5 nodes.
// Node values are digits from 1 to 9.
//
// Related Topics Bit Manipulation Tree Depth-first Search
// 👍 364 👎 13

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 2 ms, faster than 100.00% of Java online submissions for Pseudo-Palindromic Paths in a Binary Tree.
 O(h) Memory Usage: 57 MB, less than 69.93% of Java online submissions for Pseudo-Palindromic Paths in a Binary Tree.
*/
public class PseudoPalindromicPathsInABinaryTree_1457 {
  public int pseudoPalindromicPaths(TreeNode root) {
    return pathsDfs(root, 0);
  }

  private int pathsDfs(TreeNode root, int counter) {
    if (root == null) {
      return 0;
    }
    counter ^= (1 << root.val);

    if (root.left == null && root.right == null) {
      return canBePalindromic(counter) ? 1 : 0;
    }

    return pathsDfs(root.left, counter) + pathsDfs(root.right, counter);
  }

  private boolean canBePalindromic(int counter) {
    return (counter & (counter - 1)) == 0;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
