package com.leetcode.tree.medium;

// A binary tree is named Even-Odd if it meets the following conditions:
//
//
// The root of the binary tree is at level index 0, its children are at level in
// dex 1, their children are at level index 2, etc.
// For every even-indexed level, all nodes at the level have odd integer values
// in strictly increasing order (from left to right).
// For every odd-indexed level, all nodes at the level have even integer values
// in strictly decreasing order (from left to right).
//
//
// Given the root of a binary tree, return true if the binary tree is Even-Odd,
// otherwise return false.
//
//
// Example 1:
//
//
//
//
// Input: root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
// Output: true
// Explanation: The node values on each level are:
// Level 0: [1]
// Level 1: [10,4]
// Level 2: [3,7,9]
// Level 3: [12,8,6,2]
// Since levels 0 and 2 are all odd and increasing, and levels 1 and 3 are all ev
// en and decreasing, the tree is Even-Odd.
//
//
// Example 2:
//
//
//
//
// Input: root = [5,4,2,3,3,7]
// Output: false
// Explanation: The node values on each level are:
// Level 0: [5]
// Level 1: [4,2]
// Level 2: [3,3,7]
// Node values in the level 2 must be in strictly increasing order, so the tree i
// s not Even-Odd.
//
//
// Example 3:
//
//
//
//
// Input: root = [5,9,1,3,5,7]
// Output: false
// Explanation: Node values in the level 1 should be even integers.
//
//
// Example 4:
//
//
// Input: root = [1]
// Output: true
//
//
// Example 5:
//
//
// Input: root = [11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]
// Output: true
//
//
//
// Constraints:
//
//
// The number of nodes in the tree is in the range [1, 105].
// 1 <= Node.val <= 106
//
// Related Topics Tree
// 👍 164 👎 10

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
/*
 O(n) Runtime: 9 ms, faster than 75.39% of Java online submissions for Even Odd Tree.
 O(n) Memory Usage: 55.3 MB, less than 93.26% of Java online submissions for Even Odd Tree.
*/
public class EvenOddTree_1609 {
  public boolean isEvenOddTree(TreeNode root) {
    Deque<TreeNode> deque = new ArrayDeque<>();

    deque.add(root);

    int level = 0;
    while (!deque.isEmpty()) {
      int size = deque.size();
      TreeNode prev = null;

      for (int i = 0; i < size; i++) {
        TreeNode curr = deque.pop();

        if (level % 2 == 0 && ((prev != null && curr.val <= prev.val) || curr.val % 2 == 0)) {
          return false;
        }
        if (level % 2 == 1 && ((prev != null && curr.val >= prev.val) || curr.val % 2 == 1)) {
          return false;
        }

        if (curr.left != null) {
          deque.add(curr.left);
        }

        if (curr.right != null) {
          deque.add(curr.right);
        }

        prev = curr;
      }
      level++;
    }
    return true;
  }
}
// leetcode submit region end(Prohibit modification and deletion)
