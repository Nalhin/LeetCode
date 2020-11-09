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

class RangeSumOfBST_938Test {
  private final RangeSumOfBST_938 solution = new RangeSumOfBST_938();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(10, 5, 15, 3, 7, null, 18), 7, 15, 32),
          arguments(BinaryTree.of(10, 5, 15, 3, 7, 13, 18, 1, null, 6), 6, 10, 23));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void rangeSumBST(TreeNode input, int min, int max, int expectedResult) {

    int actualResult = solution.rangeSumBST(input, min, max);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
