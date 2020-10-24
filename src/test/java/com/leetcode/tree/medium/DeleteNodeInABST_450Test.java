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

class DeleteNodeInABST_450Test {

  private final DeleteNodeInABST_450.Iterative solutionIterative =
      new DeleteNodeInABST_450.Iterative();
  private final DeleteNodeInABST_450.Recursive solutionRecursive =
      new DeleteNodeInABST_450.Recursive();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              BinaryTree.of(5, 3, 6, 2, 4, null, 7), 3, BinaryTree.of(5, 4, 6, 2, null, null, 7)),
          arguments(
              BinaryTree.of(5, 3, 6, 2, 4, null, 7), 0, BinaryTree.of(5, 3, 6, 2, 4, null, 7)),
          arguments(BinaryTree.of(5, 3, 6, 2, 4, null, 7), 5, BinaryTree.of(6, 3, 7, 2, 4)),
          arguments(
              BinaryTree.of(5, 3, 6, 2, 4, null, 7), 0, BinaryTree.of(5, 3, 6, 2, 4, null, 7)),
          arguments(
              BinaryTree.of(50, 30, 70, null, 40, 60, 80),
              50,
              BinaryTree.of(60, 30, 70, null, 40, null, 80)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void insertIntoBSTIterative(TreeNode root, int val, TreeNode expectedResult) {
    TreeNode actualResult = solutionIterative.deleteNode(root, val);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void insertIntoBSTRecursive(TreeNode root, int val, TreeNode expectedResult) {
    TreeNode actualResult = solutionRecursive.deleteNode(root, val);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }
}
