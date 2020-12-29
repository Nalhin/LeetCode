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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PseudoPalindromicPathsInABinaryTree_1457Test {

  private final PseudoPalindromicPathsInABinaryTree_1457 solution =
      new PseudoPalindromicPathsInABinaryTree_1457();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(2, 3, 1, 3, 1, null, 1), 2),
          arguments(BinaryTree.of(2, 1, 1, 1, 3, null, null, null, null, null, 1), 1),
          arguments(BinaryTree.empty(), 0),
          arguments(BinaryTree.of(9), 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void pseudoPalindromicPaths(TreeNode root, int expectedResult) {
    int actualResult = solution.pseudoPalindromicPaths(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
