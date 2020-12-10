package com.leetcode.tree.medium;

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

class BinaryTreeZigzagLevelOrderTraversal_103Test {

  private final BinaryTreeZigzagLevelOrderTraversal_103 solution =
      new BinaryTreeZigzagLevelOrderTraversal_103();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              BinaryTree.of(3, 9, 20, null, null, 15, 7),
              List.of(List.of(3), List.of(20, 9), List.of(15, 7))),
          arguments(BinaryTree.empty(), Collections.emptyList()));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void zigzagLevelOrder(TreeNode root, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.zigzagLevelOrder(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
