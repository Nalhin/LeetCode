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

class MinimumDepthOfBinaryTree_111Test {
  private final MinimumDepthOfBinaryTree_111 solution = new MinimumDepthOfBinaryTree_111();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(3, 9, 20, null, null, 15, 7), 2),
          arguments(BinaryTree.of(2, null, 3, null, 4, null, 5, null, 6), 5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minDepth(TreeNode input, int expectedResult) {
    int actualResult = solution.minDepth(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
