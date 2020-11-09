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

class MaximumDifferenceBetweenNodeAndAncestor_1026Test {

  private final MaximumDifferenceBetweenNodeAndAncestor_1026 solution =
      new MaximumDifferenceBetweenNodeAndAncestor_1026();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13), 7),
          arguments(BinaryTree.of(1, null, 2, null, 0, 3), 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxAncestorDiff(TreeNode root, int expectedResult) {
    int actualResult = solution.maxAncestorDiff(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
