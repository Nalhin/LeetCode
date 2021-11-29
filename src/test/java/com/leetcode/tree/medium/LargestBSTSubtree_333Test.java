package com.leetcode.tree.medium;

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

class LargestBSTSubtree_333Test {

  private final LargestBSTSubtree_333 solution = new LargestBSTSubtree_333();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(10, 5, 15, 1, 8, null, 7), 3),
          arguments(BinaryTree.of(4, 2, 7, 2, 3, 5, null, 2, null, null, null, null, null, 1), 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void largestBSTSubtree(TreeNode root, int expectedResult) {
    int actualResult = solution.largestBSTSubtree(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
