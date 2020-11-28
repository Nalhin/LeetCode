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

class ConstructBinaryTreeFromInorderAndPostorderTraversal_106Test {

  private final ConstructBinaryTreeFromInorderAndPostorderTraversal_106 solution =
      new ConstructBinaryTreeFromInorderAndPostorderTraversal_106();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[] {9, 3, 15, 20, 7},
              new int[] {9, 15, 7, 20, 3},
              BinaryTree.of(3, 9, 20, null, null, 15, 7)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void buildTree(int[] inorder, int[] postorder, TreeNode expectedResult) {
    TreeNode actualResult = solution.buildTree(inorder, postorder);

    assertThatBinaryTree(actualResult).isEqualTo(expectedResult);
  }
}
