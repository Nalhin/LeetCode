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

class PathSumIII_437Test {

  private final PathSumIII_437 solution = new PathSumIII_437();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), 8, 3),
          arguments(BinaryTree.of(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22, 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void pathSum(TreeNode root, int sum, int expectedResult) {
    int actualResult = solution.pathSum(root, sum);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
