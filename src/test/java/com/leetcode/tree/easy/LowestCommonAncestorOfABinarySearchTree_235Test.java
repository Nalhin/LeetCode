package com.leetcode.tree.easy;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LowestCommonAncestorOfABinarySearchTree_235Test {

  private final LowestCommonAncestorOfABinarySearchTree_235 solution =
      new LowestCommonAncestorOfABinarySearchTree_235();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              BinaryTree.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5),
              new TreeNode(2),
              new TreeNode(8),
              6),
          arguments(
              BinaryTree.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 55, 14, null, 1),
              new TreeNode(2),
              new TreeNode(4),
              2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, int expectedResult) {
    TreeNode actualResult = solution.lowestCommonAncestor(root, p, q);

    assertThat(actualResult.val).isEqualTo(expectedResult);
  }
}
