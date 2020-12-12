package com.leetcode.tree.easy;

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

class TrimABinarySearchTree_669Test {

  private final TrimABinarySearchTree_669 solution = new TrimABinarySearchTree_669();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, 0, 2), 1, 2, BinaryTree.of(1, null, 2)),
          arguments(
              BinaryTree.of(3, 0, 4, null, 2, null, null, 1), 1, 3, BinaryTree.of(3, 2, null, 1)),
          arguments(BinaryTree.of(1), 1, 3, BinaryTree.of(1)),
          arguments(BinaryTree.of(1, null, 2), 1, 3, BinaryTree.of(1, null, 2)),
          arguments(BinaryTree.of(1, null, 2), 2, 4, BinaryTree.of(2)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void trimBST(TreeNode tree, int low, int high, TreeNode expectedResult) {
    TreeNode actualResult = solution.trimBST(tree, low, high);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }
}
