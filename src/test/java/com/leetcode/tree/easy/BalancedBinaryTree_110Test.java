package com.leetcode.tree.easy;

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

class BalancedBinaryTree_110Test {
  private final BalancedBinaryTree_110 solution = new BalancedBinaryTree_110();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(3, 9, 20, null, null, 15, 7), true),
          arguments(BinaryTree.of(1, 2, 2, 3, 3, null, null, 4, 4), false),
          arguments(BinaryTree.empty(), true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isBalanced(BinaryTree.TreeNode root, boolean expectedResult) {
    boolean actualResult = solution.isBalanced(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
