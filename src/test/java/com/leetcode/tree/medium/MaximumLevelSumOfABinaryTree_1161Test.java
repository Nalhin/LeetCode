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

class MaximumLevelSumOfABinaryTree_1161Test {

  private final MaximumLevelSumOfABinaryTree_1161 solution =
      new MaximumLevelSumOfABinaryTree_1161();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, 7, 0, 7, -8, null, null), 2),
          arguments(BinaryTree.of(989, null, 10250, 98693, -89388, null, null, null, -32127), 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxLevelSum(TreeNode root, int expectedResult) {
    int actualResult = solution.maxLevelSum(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
