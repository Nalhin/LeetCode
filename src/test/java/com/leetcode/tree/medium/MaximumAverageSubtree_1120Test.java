package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumAverageSubtree_1120Test {

  private final MaximumAverageSubtree_1120 solution = new MaximumAverageSubtree_1120();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(5, 6, 1), 6),
          arguments(BinaryTree.empty(), 0),
          arguments(BinaryTree.of(1), 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maximumAverageSubtree(TreeNode root, double expectedResult) {
    double actualResult = solution.maximumAverageSubtree(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
