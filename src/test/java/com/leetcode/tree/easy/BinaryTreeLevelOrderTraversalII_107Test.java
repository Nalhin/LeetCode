package com.leetcode.tree.easy;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BinaryTreeLevelOrderTraversalII_107Test {

  private final BinaryTreeLevelOrderTraversalII_107 solution =
      new BinaryTreeLevelOrderTraversalII_107();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              BinaryTree.of(3, 9, 20, null, null, 15, 7),
              List.of(List.of(15, 7), List.of(9, 20), List.of(3))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void levelOrderBottom(TreeNode root, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.levelOrderBottom(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
