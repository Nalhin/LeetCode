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

class BinaryTreeLevelOrderTraversal_102Test {

  private final BinaryTreeLevelOrderTraversal_102.Iterative solutionIterative =
      new BinaryTreeLevelOrderTraversal_102.Iterative();

  private final BinaryTreeLevelOrderTraversal_102.Recursive solutionRecursive =
      new BinaryTreeLevelOrderTraversal_102.Recursive();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.empty(), Collections.emptyList()),
          arguments(
              BinaryTree.of(3, 9, 20, null, null, 15, 7),
              List.of(List.of(3), List.of(9, 20), List.of(15, 7))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void levelOrderIterative(TreeNode root, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solutionIterative.levelOrder(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void levelOrderRecursive(TreeNode root, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solutionRecursive.levelOrder(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
