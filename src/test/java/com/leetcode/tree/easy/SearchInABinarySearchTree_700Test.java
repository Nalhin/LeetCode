package com.leetcode.tree.easy;

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

class SearchInABinarySearchTree_700Test {

  private final SearchInABinarySearchTree_700.Iterative solutionIterative =
      new SearchInABinarySearchTree_700.Iterative();
  private final SearchInABinarySearchTree_700.Recursive solutionRecursive =
      new SearchInABinarySearchTree_700.Recursive();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(BinaryTree.of(4, 2, 7, 1, 3), 2, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void searchBSTIterative(TreeNode input, int target, int expectedResult) {
    TreeNode actualResult = solutionIterative.searchBST(input, target);

    assertThat(actualResult.val).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void searchBSTRecursive(TreeNode input, int target, int expectedResult) {
    TreeNode actualResult = solutionRecursive.searchBST(input, target);

    assertThat(actualResult.val).isEqualTo(expectedResult);
  }
}
