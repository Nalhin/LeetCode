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

class IncreasingOrderSearchTree_897Test {

  private final IncreasingOrderSearchTree_897.Recursive solutionRecursive =
      new IncreasingOrderSearchTree_897.Recursive();
  private final IncreasingOrderSearchTree_897.Iterative solutionIterative =
      new IncreasingOrderSearchTree_897.Iterative();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              BinaryTree.of(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9),
              BinaryTree.of(
                  1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7, null, 8, null, 9)),
          arguments(BinaryTree.of(5, 1, 7), BinaryTree.of(1, null, 5, null, 7)),
          arguments(
              BinaryTree.of(2, 1, 4, null, null, 3), BinaryTree.of(1, null, 2, null, 3, null, 4)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void increasingBSTIterative(TreeNode root, TreeNode expectedResult) {
    TreeNode actualResult = solutionIterative.increasingBST(root);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void increasingBSTRecursive(TreeNode root, TreeNode expectedResult) {
    TreeNode actualResult = solutionRecursive.increasingBST(root);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }
}
