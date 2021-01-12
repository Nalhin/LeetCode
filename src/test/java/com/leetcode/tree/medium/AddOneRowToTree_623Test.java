package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static com.leetcode.assertions.BinaryTreeAssertions.assertThatBinaryTree;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AddOneRowToTree_623Test {

  private final AddOneRowToTree_623 solution = new AddOneRowToTree_623();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              BinaryTree.of(4, 2, 6, 3, 1, 5),
              1,
              2,
              BinaryTree.of(4, 1, 1, 2, null, null, 6, 3, 1, 5)),
          arguments(
              BinaryTree.of(4, 2, null, 3, 1),
              1,
              3,
              BinaryTree.of(4, 2, null, 1, 1, 3, null, null, 1)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void addOneRow(TreeNode root, int v, int d, TreeNode expectedResult) {
    TreeNode actualResult = solution.addOneRow(root, v, d);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }
}
