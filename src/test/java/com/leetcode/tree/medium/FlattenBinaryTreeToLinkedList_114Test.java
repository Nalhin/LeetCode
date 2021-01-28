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

class FlattenBinaryTreeToLinkedList_114Test {

  private final FlattenBinaryTreeToLinkedList_114 solution =
      new FlattenBinaryTreeToLinkedList_114();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              BinaryTree.of(1, 2, 5, 3, 4, null, 6),
              BinaryTree.of(1, null, 2, null, 3, null, 4, null, 5, null, 6)),
          arguments(BinaryTree.empty(), BinaryTree.empty()),
          arguments(BinaryTree.of(0), BinaryTree.of(0)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void flattenRecursive(TreeNode preorder, TreeNode expectedResult) {
    solution.flatten(preorder);

    assertThatBinaryTree(preorder).isEqualTo(expectedResult);
  }
}
