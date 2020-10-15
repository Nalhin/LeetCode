package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CountUnivalueSubtrees_250Test {

  private final CountUnivalueSubtrees_250 solution = new CountUnivalueSubtrees_250();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(5, 1, 5, 5, 5, null, 5), 4),
          arguments(BinaryTree.empty(), 0),
          arguments(BinaryTree.of(5, 5, 5, 5, 5, null, 5), 6),
          arguments(BinaryTree.of(1, 1, 1, 5, 5, null, 5), 3),
          arguments(BinaryTree.of(5, 5, 5, 5, 1, null, 5), 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countUnivalSubtrees(BinaryTree.TreeNode input, int expectedResult) {

    int actualResult = solution.countUnivalSubtrees(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
