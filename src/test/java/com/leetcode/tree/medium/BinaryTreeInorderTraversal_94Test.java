package com.leetcode.tree.medium;

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

class BinaryTreeInorderTraversal_94Test {

  private final BinaryTreeInorderTraversal_94.Iterative solutionIterative =
      new BinaryTreeInorderTraversal_94.Iterative();
  private final BinaryTreeInorderTraversal_94.Recursive solutionRecursive =
      new BinaryTreeInorderTraversal_94.Recursive();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, null, 2, 3), List.of(1, 3, 2)),
          arguments(BinaryTree.of(1), List.of(1)),
          arguments(BinaryTree.of(1, 2), List.of(2, 1)),
          arguments(BinaryTree.of(1, null, 2), List.of(1, 2)),
          arguments(BinaryTree.empty(), Collections.emptyList()));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void inorderTraversalIterative(TreeNode root, List<Integer> expectedResult) {
    List<Integer> actualResult = solutionIterative.inorderTraversal(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void inorderTraversalRecursive(TreeNode root, List<Integer> expectedResult) {
    List<Integer> actualResult = solutionRecursive.inorderTraversal(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
