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

class SmallestSubtreeWithAllTheDeepestNodes_865Test {

  private final SmallestSubtreeWithAllTheDeepestNodes_865 solution =
      new SmallestSubtreeWithAllTheDeepestNodes_865();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4), BinaryTree.of(2, 7, 4)),
          arguments(BinaryTree.of(1), BinaryTree.of(1)),
          arguments(BinaryTree.of(0, 1, 3, null, 2), BinaryTree.of(2)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void subtreeWithAllDeepest(TreeNode root, TreeNode expectedResult) {
    TreeNode actualResult = solution.subtreeWithAllDeepest(root);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }
}
