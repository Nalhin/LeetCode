package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree.TreeNode;

/*
 O(N) Runtime: 0 ms, faster than 100.00% of Java online submissions for Largest BST Subtree.
 O(N) Memory Usage: 39.2 MB, less than 54.21% of Java online submissions for Largest BST Subtree.
*/
public class LargestBSTSubtree_333 {

  private static class ChildrenSummary {
    private final int min;
    private final int max;
    private final int count;

    private ChildrenSummary(int min, int max, int count) {
      this.min = min;
      this.max = max;
      this.count = count;
    }
  }

  public int largestBSTSubtree(TreeNode root) {
    return bst(root).count;
  }

  private ChildrenSummary bst(TreeNode root) {
    if (root == null) {
      return new ChildrenSummary(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    }

    ChildrenSummary left = bst(root.left);
    ChildrenSummary right = bst(root.right);

    if (root.val <= left.max || root.val >= right.min) {
      return new ChildrenSummary(
          Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.count, right.count));
    }

    int min = Math.min(left.min, root.val);
    int max = Math.max(right.max, root.val);

    return new ChildrenSummary(min, max, left.count + right.count + 1);
  }
}
