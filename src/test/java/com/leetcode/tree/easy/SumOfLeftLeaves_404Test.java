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

class SumOfLeftLeaves_404Test {
  private final SumOfLeftLeaves_404 solution = new SumOfLeftLeaves_404();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.empty(), 0),
          arguments(BinaryTree.of(1), 0),
          arguments(BinaryTree.of(3, 9, 20, null, null, 15, 7), 24));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void sumOfLeftLeaves(TreeNode tree, int expectedResult) {

    int actualResult = solution.sumOfLeftLeaves(tree);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
