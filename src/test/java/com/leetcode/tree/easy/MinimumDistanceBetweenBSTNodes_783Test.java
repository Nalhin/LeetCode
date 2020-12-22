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

class MinimumDistanceBetweenBSTNodes_783Test {

  private final MinimumDistanceBetweenBSTNodes_783 solution =
      new MinimumDistanceBetweenBSTNodes_783();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(BinaryTree.of(4, 2, 6, 1, 3, null, null), 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minDiffInBST(TreeNode input, int expectedResult) {
    int actualResult = solution.minDiffInBST(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
