package com.leetcode.tree.easy;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static com.leetcode.assertions.BinaryTreeAssertions.assertThatBinaryTree;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class InvertBinaryTree_226Test {

  private final InvertBinaryTree_226.Iterative solutionIterative =
      new InvertBinaryTree_226.Iterative();

  private final InvertBinaryTree_226.Recursive solutionRecursive =
      new InvertBinaryTree_226.Recursive();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.empty(), BinaryTree.empty()),
          arguments(BinaryTree.of(4, 2, 7, 1, 3, 6, 9), BinaryTree.of(4, 7, 2, 9, 6, 3, 1)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void levelOrderIterative(TreeNode root, TreeNode expectedResult) {
    TreeNode actualResult = solutionIterative.invertTree(root);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void levelOrderRecursive(TreeNode root, TreeNode expectedResult) {
    TreeNode actualResult = solutionRecursive.invertTree(root);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }
}
