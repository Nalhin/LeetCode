package com.leetcode.bst.easy;

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
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PathSum_112Test {

  private final PathSum_112 solution = new PathSum_112();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1), 22, true),
          arguments(BinaryTree.empty(), 0, false),
          arguments(BinaryTree.of(1, 2), 1, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void hasPathSum(TreeNode input, int sum, boolean expectedResult) {

    boolean actualResult = solution.hasPathSum(input, sum);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
