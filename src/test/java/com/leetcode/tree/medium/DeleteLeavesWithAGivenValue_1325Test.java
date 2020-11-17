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

class DeleteLeavesWithAGivenValue_1325Test {

  private final DeleteLeavesWithAGivenValue_1325 solution = new DeleteLeavesWithAGivenValue_1325();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, 2, 3, 2, null, 2, 4), 2, BinaryTree.of(1, null, 3, null, 4)),
          arguments(BinaryTree.of(1, 3, 3, 3, 2), 3, BinaryTree.of(1, 3, null, null, 2)),
          arguments(BinaryTree.of(1, 2, null, 2, null, 2), 2, BinaryTree.of(1)),
          arguments(BinaryTree.of(1, 1, 1), 1, BinaryTree.empty()),
          arguments(BinaryTree.of(1, 2, 3), 1, BinaryTree.of(1, 2, 3)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void removeLeafNodes(TreeNode root, int target, TreeNode expectedResult) {
    TreeNode actualResult = solution.removeLeafNodes(root, target);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }
}
