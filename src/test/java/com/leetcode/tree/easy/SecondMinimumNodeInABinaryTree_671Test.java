package com.leetcode.tree.easy;

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

class SecondMinimumNodeInABinaryTree_671Test {

  private final SecondMinimumNodeInABinaryTree_671 solution =
      new SecondMinimumNodeInABinaryTree_671();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(2, 2, 5, null, null, 5, 7), 5),
          arguments(BinaryTree.of(2, 2, 2), -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findSecondMinimumValue(TreeNode tree, int expectedResult) {
    int actualResult = solution.findSecondMinimumValue(tree);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
