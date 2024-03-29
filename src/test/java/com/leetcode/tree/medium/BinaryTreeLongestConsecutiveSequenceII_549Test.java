package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BinaryTreeLongestConsecutiveSequenceII_549Test {
  private final BinaryTreeLongestConsecutiveSequenceII_549 solution =
      new BinaryTreeLongestConsecutiveSequenceII_549();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, 2, 3), 2),
          arguments(BinaryTree.of(2, 1, 3), 3),
          arguments(BinaryTree.of(1, 2, 3, 4), 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestConsecutive(TreeNode root, int expectedResult) {
    int actualResult = solution.longestConsecutive(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
