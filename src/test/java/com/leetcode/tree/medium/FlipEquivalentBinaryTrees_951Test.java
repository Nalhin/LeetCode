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

class FlipEquivalentBinaryTrees_951Test {

  private final FlipEquivalentBinaryTrees_951 solution = new FlipEquivalentBinaryTrees_951();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              BinaryTree.of(1, 2, 3, 4, 5, 6, null, null, null, 7, 8),
              BinaryTree.of(1, 3, 2, null, 6, 4, 5, null, null, null, null, 8, 7),
              true),
          arguments(BinaryTree.empty(), BinaryTree.empty(), true),
          arguments(BinaryTree.empty(), BinaryTree.of(1), false),
          arguments(BinaryTree.of(0, null, 1), BinaryTree.empty(), false),
          arguments(BinaryTree.of(0, null, 1), BinaryTree.of(0, 1), true),
          arguments(
              BinaryTree.of(1, 2, 3, 4, 5, 6, null, null, null, 7, 8),
              BinaryTree.of(99, 3, 2, null, 6, 4, 5, null, null, null, null, 8, 7),
              false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void flipEquiv(TreeNode tree1, TreeNode tree2, boolean expectedResult) {
    boolean actualResult = solution.flipEquiv(tree1, tree2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
