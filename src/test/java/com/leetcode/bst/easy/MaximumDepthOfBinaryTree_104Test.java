package com.leetcode.bst.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumDepthOfBinaryTree_104Test {

  private final MaximumDepthOfBinaryTree_104 solution = new MaximumDepthOfBinaryTree_104();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(BinaryTree.of(3, 9, 20, null, null, 15, 7), 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxDepth(TreeNode input, int expectedResult) {

    int actualResult = solution.maxDepth(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
