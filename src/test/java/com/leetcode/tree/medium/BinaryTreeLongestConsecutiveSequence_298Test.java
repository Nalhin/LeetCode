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

class BinaryTreeLongestConsecutiveSequence_298Test {

  private final BinaryTreeLongestConsecutiveSequence_298 solution =
      new BinaryTreeLongestConsecutiveSequence_298();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.empty(), 0),
          arguments(BinaryTree.of(1), 1),
          arguments(BinaryTree.of(2, null, 3, 2, null, 1, null), 2),
          arguments(BinaryTree.of(1, null, 3, 2, 4, null, null, null, 5), 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestConsecutive(TreeNode root, int expectedResult) {
    int actualResult = solution.longestConsecutive(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
