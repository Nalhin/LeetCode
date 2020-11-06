package com.leetcode.tree.medium;

// Given two binary search trees root1 and root2.
//
// Return a list containing all the integers from both trees sorted in ascending
// order.
//
//
// Example 1:
//
//
// Input: root1 = [2,1,4], root2 = [1,0,3]
// Output: [0,1,1,2,3,4]
//
//
// Example 2:
//
//
// Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
// Output: [-10,0,0,1,2,5,7,10]
//
//
// Example 3:
//
//
// Input: root1 = [], root2 = [5,1,7,0,2]
// Output: [0,1,2,5,7]
//
//
// Example 4:
//
//
// Input: root1 = [0,-10,10], root2 = []
// Output: [-10,0,10]
//
//
// Example 5:
//
//
// Input: root1 = [1,null,8], root2 = [8,1]
// Output: [1,1,8,8]
//
//
//
// Constraints:
//
//
// Each tree has at most 5000 nodes.
// Each node's value is between [-10^5, 10^5].
//
// Related Topics Sort Tree
// 👍 697 👎 29

// leetcode submit region begin(Prohibit modification and deletion)

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */

public class AllElementsInTwoBinarySearchTrees_1305 {
  /*
   O(n + m)  Runtime: 15 ms, faster than 47.46% of Java online submissions for All Elements in Two Binary Search Trees.
   O(n + m)  Memory Usage: 41.8 MB, less than 5.16% of Java online submissions for All Elements in Two Binary Search Trees.
  */
  static class Merge {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
      List<Integer> result = new ArrayList<>();

      List<Integer> res1 = inorder(root1);
      List<Integer> res2 = inorder(root2);

      int r1 = 0;
      int r2 = 0;
      int r1Size = res1.size();
      int r2Size = res2.size();
      while (r1 < r1Size && r2 < r2Size) {
        if (res1.get(r1) < res2.get(r2)) {
          result.add(res1.get(r1++));
        } else {
          result.add(res2.get(r2++));
        }
      }
      while (r2 < r2Size) {
        result.add(res2.get(r2++));
      }
      while (r1 < r1Size) {
        result.add(res1.get(r1++));
      }
      return result;
    }

    private List<Integer> inorder(TreeNode root) {
      List<Integer> result = new ArrayList<>();
      Deque<TreeNode> deque = new ArrayDeque<>();

      while (root != null || !deque.isEmpty()) {
        while (root != null) {
          deque.push(root);
          root = root.left;
        }
        TreeNode prev = deque.pop();
        result.add(prev.val);
        root = prev.right;
      }
      return result;
    }
  }

  /*
  O(n + m) Runtime: 11 ms, faster than 95.14% of Java online submissions for All Elements in Two Binary Search Trees.
  O(n + m) Memory Usage: 42.3 MB, less than 5.16% of Java online submissions for All Elements in Two Binary Search Trees.
  */
  static class SinglePass {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
      List<Integer> result = new ArrayList<>();
      Deque<TreeNode> deque1 = new ArrayDeque<>();
      Deque<TreeNode> deque2 = new ArrayDeque<>();

      while (root1 != null || !deque1.isEmpty() || root2 != null || !deque2.isEmpty()) {
        while (root1 != null) {
          deque1.push(root1);
          root1 = root1.left;
        }
        while (root2 != null) {
          deque2.push(root2);
          root2 = root2.left;
        }

        if (deque2.isEmpty() || (!deque1.isEmpty() && deque2.peek().val > deque1.peek().val)) {
          TreeNode curr1 = deque1.pop();
          result.add(curr1.val);
          root1 = curr1.right;
        } else {
          TreeNode curr2 = deque2.pop();
          result.add(curr2.val);
          root2 = curr2.right;
        }
      }
      return result;
    }
  }
}
// leetcode submit region end(Prohibit modification and deletion)
