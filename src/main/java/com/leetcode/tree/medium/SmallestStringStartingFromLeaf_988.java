package com.leetcode.tree.medium;

// Given the root of a binary tree, each node has a value from 0 to 25 representi
// ng the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents
// 'b', and so on.
//
// Find the lexicographically smallest string that starts at a leaf of this tree
// and ends at the root.
//
// (As a reminder, any shorter prefix of a string is lexicographically smaller:
// for example, "ab" is lexicographically smaller than "aba". A leaf of a node is a
// node that has no children.)
//
//
//
//
//
//
//
//
//
//
//
// Example 1:
//
//
//
//
// Input: [0,1,2,3,4,3,4]
// Output: "dba"
//
//
//
// Example 2:
//
//
//
//
// Input: [25,1,3,1,3,0,2]
// Output: "adz"
//
//
//
// Example 3:
//
//
//
//
// Input: [2,2,1,null,1,0,null,0]
// Output: "abc"
//
//
//
//
// Note:
//
//
// The number of nodes in the given tree will be between 1 and 8500.
// Each node in the tree will have a value between 0 and 25.
//
//
//
// Related Topics Tree Depth-first Search
// 👍 549 👎 107

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(nlog(h)) Runtime: 1 ms, faster than 100.00% of Java online submissions for Smallest String Starting From Leaf.
 O(h) Memory Usage: 38.5 MB, less than 93.79% of Java online submissions for Smallest String Starting From Leaf.
*/
public class SmallestStringStartingFromLeaf_988 {

  private String result = "";

  public String smallestFromLeaf(TreeNode root) {
    dfs(root, new StringBuilder());
    return result;
  }

  private void dfs(TreeNode root, StringBuilder sb) {
    if (root == null) {
      return;
    }
    sb.append((char) (root.val + 'a'));
    if (root.left == null && root.right == null) {
      String str = sb.reverse().toString();
      if (result.equals("") || result.compareTo(str) > 0) {
        result = str;
      }
      sb.reverse();
    } else {
      dfs(root.left, sb);
      dfs(root.right, sb);
    }
    sb.deleteCharAt(sb.length() - 1);
  }
}
// leetcode submit region end(Prohibit modification and deletion)
