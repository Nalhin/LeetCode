package com.leetcode.tree.hard;

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

class BinaryTreeMaximumPathSum_124Test {

  private final BinaryTreeMaximumPathSum_124 solution = new BinaryTreeMaximumPathSum_124();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, 2, 3), 6),
          arguments(BinaryTree.of(-10, 9, 20, null, null, 15, 7), 42));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxPathSum(TreeNode root, int expectedResult) {
    int actualResult = solution.maxPathSum(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
