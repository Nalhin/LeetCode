package com.leetcode.bst.medium;

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

class BinaryTreePreorderTraversal_144Test {

  private final BinaryTreePreorderTraversal_144.Iterative solutionIterative =
      new BinaryTreePreorderTraversal_144.Iterative();

  private final BinaryTreePreorderTraversal_144.Recursive solutionRecursive =
      new BinaryTreePreorderTraversal_144.Recursive();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.empty(), Collections.emptyList()),
          arguments(BinaryTree.of(1, null, 2, 3), List.of(1, 2, 3)),
          arguments(BinaryTree.of(1), List.of(1)),
          arguments(BinaryTree.of(1, 2), List.of(1, 2)),
          arguments(BinaryTree.of(1, null, 2), List.of(1, 2)),
          arguments(BinaryTree.of(3, 1, 2), List.of(3, 1, 2)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void levelOrderIterative(TreeNode root, List<Integer> expectedResult) {
    List<Integer> actualResult = solutionIterative.preorderTraversal(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void levelOrderRecursive(TreeNode root, List<Integer> expectedResult) {
    List<Integer> actualResult = solutionRecursive.preorderTraversal(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
