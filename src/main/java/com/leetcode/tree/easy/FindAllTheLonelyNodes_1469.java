package com.leetcode.tree.easy;

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
  O(n) Runtime: 0 ms, faster than 100.00% of Java online submissions for Find All The Lonely Nodes.
  O(h) Memory Usage: 39.5 MB, less than 13.54% of Java online submissions for Find All The Lonely Nodes.
*/
public class FindAllTheLonelyNodes_1469 {
  public List<Integer> getLonelyNodes(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    findAllLonelyDfs(root, false, result);
    return result;
  }

  private void findAllLonelyDfs(TreeNode root, boolean isLonely, List<Integer> result) {
    if (root == null) {
      return;
    }
    if (isLonely) {
      result.add(root.val);
    }

    findAllLonelyDfs(root.left, root.right == null, result);
    findAllLonelyDfs(root.right, root.left == null, result);
  }
}
