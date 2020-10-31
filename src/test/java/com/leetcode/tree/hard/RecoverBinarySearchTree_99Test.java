package com.leetcode.tree.hard;

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

class RecoverBinarySearchTree_99Test {

  private final RecoverBinarySearchTree_99 solution = new RecoverBinarySearchTree_99();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, 3, null, null, 2), BinaryTree.of(3, 1, null, null, 2)),
          arguments(BinaryTree.of(3, 1, 4, null, null, 2), BinaryTree.of(2, 1, 4, null, null, 3)),
          arguments(BinaryTree.of(2, 3, 1), BinaryTree.of(2, 1, 3)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void recoverTree(TreeNode root, TreeNode expectedResult) {
    solution.recoverTree(root);

    assertThatBinaryTree(root).isEqualTo(expectedResult);
  }
}
