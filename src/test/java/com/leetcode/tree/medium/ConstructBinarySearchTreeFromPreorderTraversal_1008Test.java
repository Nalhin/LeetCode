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

class ConstructBinarySearchTreeFromPreorderTraversal_1008Test {

  private final ConstructBinarySearchTreeFromPreorderTraversal_1008 solution =
      new ConstructBinarySearchTreeFromPreorderTraversal_1008();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {8, 5, 1, 7, 10, 12}, BinaryTree.of(8, 5, 10, 1, 7, null, 12)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void bstFromPreorder(int[] array, TreeNode expectedResult) {
    TreeNode actualResult = solution.bstFromPreorder(array);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }
}
