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

class MergeTwoBinaryTrees_617Test {
  private final MergeTwoBinaryTrees_617 solution = new MergeTwoBinaryTrees_617();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              BinaryTree.of(1, 3, 2, 5, null, null, null),
              BinaryTree.of(2, 1, 3, null, 4, null, 7),
              BinaryTree.of(3, 4, 5, 5, 4, null, 7)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void mergeTrees(TreeNode first, TreeNode second, TreeNode expectedResult) {

    TreeNode actualResult = solution.mergeTrees(first, second);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }
}
