package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PathSumII_113Test {

  private final PathSumII_113 solution = new PathSumII_113();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              BinaryTree.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1),
              22,
              List.of(List.of(5, 4, 11, 2), List.of(5, 8, 4, 5))),
          arguments(BinaryTree.empty(), 0, Collections.emptyList()));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void pathSum(TreeNode root, int sum, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.pathSum(root, sum);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
