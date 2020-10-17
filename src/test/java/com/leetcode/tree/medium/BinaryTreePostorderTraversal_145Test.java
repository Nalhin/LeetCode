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

class BinaryTreePostorderTraversal_145Test {

  private final BinaryTreePostorderTraversal_145.Iterative solutionIterative =
      new BinaryTreePostorderTraversal_145.Iterative();
  private final BinaryTreePostorderTraversal_145.IterativeDoublePush solutionIterativeDoublePush =
      new BinaryTreePostorderTraversal_145.IterativeDoublePush();

  private final BinaryTreePostorderTraversal_145.Recursive solutionRecursive =
      new BinaryTreePostorderTraversal_145.Recursive();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.empty(), Collections.emptyList()),
          arguments(BinaryTree.of(1), List.of(1)),
          arguments(BinaryTree.of(1, null, 2, 3), List.of(3, 2, 1)),
          arguments(BinaryTree.of(1, 2), List.of(2, 1)),
          arguments(BinaryTree.of(1, null, 2), List.of(2, 1)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void postorderTraversalIterative(TreeNode root, List<Integer> expectedResult) {
    List<Integer> actualResult = solutionIterative.postorderTraversal(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void postorderTraversalIterativeDoublePush(TreeNode root, List<Integer> expectedResult) {
    List<Integer> actualResult = solutionIterativeDoublePush.postorderTraversal(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void levelOrderRecursive(TreeNode root, List<Integer> expectedResult) {
    List<Integer> actualResult = solutionRecursive.postorderTraversal(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
