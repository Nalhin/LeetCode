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

class ClosestBinarySearchTreeValue_270Test {

  ClosestBinarySearchTreeValue_270 solution = new ClosestBinarySearchTreeValue_270();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(4, 2, 5, 1, 3), 3.714, 4),
          arguments(BinaryTree.of(4, 2, 5, 1, 3), 3.4, 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void closestValue(TreeNode root, double target, int expectedResult) {
    int actualResult = solution.closestValue(root, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
