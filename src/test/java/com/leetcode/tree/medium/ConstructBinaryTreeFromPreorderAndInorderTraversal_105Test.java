package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static com.leetcode.assertions.BinaryTreeAssertions.assertThatBinaryTree;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ConstructBinaryTreeFromPreorderAndInorderTraversal_105Test {

  private final ConstructBinaryTreeFromPreorderAndInorderTraversal_105 solution =
      new ConstructBinaryTreeFromPreorderAndInorderTraversal_105();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[] {3, 9, 20, 15, 7},
              new int[] {9, 3, 15, 20, 7},
              BinaryTree.of(3, 9, 20, null, null, 15, 7)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void buildTree(int[] preorder, int[] inorder, BinaryTree.TreeNode expectedResult) {
    BinaryTree.TreeNode actualResult = solution.buildTree(preorder, inorder);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }
}
