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

class LeafSimilarTrees_872Test {

  private final LeafSimilarTrees_872 solution = new LeafSimilarTrees_872();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              BinaryTree.of(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4),
              BinaryTree.of(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8),
              true),
          arguments(BinaryTree.of(1), BinaryTree.of(1), true),
          arguments(BinaryTree.of(1), BinaryTree.of(2), false),
          arguments(BinaryTree.of(1, 2), BinaryTree.of(2, 2), true),
          arguments(BinaryTree.of(1, 2, 3), BinaryTree.of(1, 3, 2), false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isCousins(TreeNode root1, TreeNode root2, boolean expectedResult) {
    boolean actualResult = solution.leafSimilar(root1, root2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
