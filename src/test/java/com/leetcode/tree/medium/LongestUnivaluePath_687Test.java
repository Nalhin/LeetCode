package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestUnivaluePath_687Test {

  private final LongestUnivaluePath_687 solution = new LongestUnivaluePath_687();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(5, 4, 5, 1, 1, 5), 2),
          arguments(BinaryTree.of(1, 4, 5, 4, 4, 5), 2),
          arguments(BinaryTree.of(1), 0),
          arguments(BinaryTree.of(1, null, 1, 1, 1, 1, 1, 1), 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestUnivaluePath(BinaryTree.TreeNode root, int expectedResult) {
    int actualResult = solution.longestUnivaluePath(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
