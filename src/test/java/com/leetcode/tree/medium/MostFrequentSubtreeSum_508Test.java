package com.leetcode.tree.medium;

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
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MostFrequentSubtreeSum_508Test {

  private final MostFrequentSubtreeSum_508 solution = new MostFrequentSubtreeSum_508();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(5, 2, -3), new int[] {2, -3, 4}),
          arguments(BinaryTree.of(5, 2, -5), new int[] {2}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findFrequentTreeSum(TreeNode root, int[] expectedResult) {
    int[] actualResult = solution.findFrequentTreeSum(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
