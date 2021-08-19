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

class MaximumProductOfSplittedBinaryTree_1339Test {

  private final MaximumProductOfSplittedBinaryTree_1339 solution =
      new MaximumProductOfSplittedBinaryTree_1339();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, null, 2, 3, 4, null, null, 5, 6), 90),
          arguments(BinaryTree.of(2, 3, 9, 10, 7, 8, 6, 5, 4, 11, 1), 1025),
          arguments(BinaryTree.of(1, 1), 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxProduct(TreeNode root, int expectedResult) {
    int actualResult = solution.maxProduct(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
