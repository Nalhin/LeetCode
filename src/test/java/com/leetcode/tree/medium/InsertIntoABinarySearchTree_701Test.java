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

class InsertIntoABinarySearchTree_701Test {

  private final InsertIntoABinarySearchTree_701 solution = new InsertIntoABinarySearchTree_701();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              BinaryTree.of(40, 20, 60, 10, 30, 50, 70),
              25,
              BinaryTree.of(40, 20, 60, 10, 30, 50, 70, null, null, 25)),
          arguments(
              BinaryTree.of(4, 2, 7, 1, 3, null, null, null, null, null, null),
              5,
              BinaryTree.of(4, 2, 7, 1, 3, 5)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void insertIntoBST(TreeNode root, int val, TreeNode expectedResult) {
    TreeNode actualResult = solution.insertIntoBST(root, val);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }
}
