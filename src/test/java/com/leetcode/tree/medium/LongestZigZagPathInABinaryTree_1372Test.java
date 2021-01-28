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

class LongestZigZagPathInABinaryTree_1372Test {
  private final LongestZigZagPathInABinaryTree_1372 solution =
      new LongestZigZagPathInABinaryTree_1372();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              BinaryTree.of(
                  1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1, null, 1),
              3),
          arguments(BinaryTree.of(1, 1, 1, null, 1, null, null, 1, 1, null, 1), 4),
          arguments(BinaryTree.of(1), 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxAncestorDiff(TreeNode root, int expectedResult) {
    int actualResult = solution.longestZigZag(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
