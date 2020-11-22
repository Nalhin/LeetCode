package com.leetcode.tree.medium;

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

class CountGoodNodesInBinaryTree_1448Test {

  private final CountGoodNodesInBinaryTree_1448 solution = new CountGoodNodesInBinaryTree_1448();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(3, 1, 4, 3, null, 1, 5), 4),
          arguments(BinaryTree.of(3, 3, null, 4, 2), 3),
          arguments(BinaryTree.of(1), 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void goodNodes(TreeNode root, int expectedResult) {
    int actualResult = solution.goodNodes(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
