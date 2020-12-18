package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static com.leetcode.assertions.BinaryTreeAssertions.assertThatBinaryTree;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BinaryTreePruning_814Test {
  private final BinaryTreePruning_814 solution = new BinaryTreePruning_814();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, null, 0, 0, 1), BinaryTree.of(1, null, 0, null, 1)),
          arguments(BinaryTree.of(1, 0, 1, 0, 0, 0, 1), BinaryTree.of(1, null, 1, null, 1)),
          arguments(BinaryTree.of(1, 1, 0, 1, 1, 0, 1, 0), BinaryTree.of(1, 1, 0, 1, 1, null, 1)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void pruneTree(TreeNode root, TreeNode expectedResult) {
    TreeNode actualResult = solution.pruneTree(root);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }
}
