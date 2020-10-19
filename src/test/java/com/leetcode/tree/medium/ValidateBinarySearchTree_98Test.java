package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidateBinarySearchTree_98Test {

  private final ValidateBinarySearchTree_98.Iterative solutionIterative =
      new ValidateBinarySearchTree_98.Iterative();

  private final ValidateBinarySearchTree_98.Recursive solutionRecursive =
      new ValidateBinarySearchTree_98.Recursive();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.empty(), true),
          arguments(BinaryTree.of(2, 1, 3), true),
          arguments(BinaryTree.of(5, 1, 4, null, null, 3, 6), false),
          arguments(BinaryTree.of(1, 1), false),
          arguments(BinaryTree.of(10, 5, 15, null, null, 6, 20), false),
          arguments(BinaryTree.of(2147483647), true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isValidBSTRecursive(TreeNode root, boolean expectedResult) {
    boolean actualResult = solutionIterative.isValidBST(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isValidBSTIterative(TreeNode root, boolean expectedResult) {
    boolean actualResult = solutionRecursive.isValidBST(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
