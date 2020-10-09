package com.leetcode.assertions;

import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class BinaryTreeAssertions {

  private final TreeNode treeRoot;

  private BinaryTreeAssertions(TreeNode treeRoot) {
    this.treeRoot = treeRoot;
  }

  public void isEqualTo(TreeNode expected) {
    assertThat(convertTreeToList(treeRoot)).isEqualTo(convertTreeToList(expected));
  }

  private List<Integer> convertTreeToList(TreeNode head) {
    List<Integer> result = new ArrayList<>();
    inorderTraversal(head, result);
    return result;
  }

  private void inorderTraversal(TreeNode root, List<Integer> result) {

    if (root == null) {
      result.add(null);
      return;
    }

    result.add(root.val);

    inorderTraversal(root.left, result);
    inorderTraversal(root.right, result);
  }

  public static BinaryTreeAssertions assertThatBinaryTree(TreeNode head) {
    return new BinaryTreeAssertions(head);
  }
}
