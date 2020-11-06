package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AllElementsInTwoBinarySearchTrees_1305Test {

  private final AllElementsInTwoBinarySearchTrees_1305.SinglePass solutionSinglePass =
      new AllElementsInTwoBinarySearchTrees_1305.SinglePass();
  private final AllElementsInTwoBinarySearchTrees_1305.Merge solutionMerge =
      new AllElementsInTwoBinarySearchTrees_1305.Merge();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(2, 1, 4), BinaryTree.of(1, 0, 3), List.of(0, 1, 1, 2, 3, 4)),
          arguments(
              BinaryTree.of(0, -10, 10),
              BinaryTree.of(5, 1, 7, 0, 2),
              List.of(-10, 0, 0, 1, 2, 5, 7, 10)),
          arguments(BinaryTree.empty(), BinaryTree.of(5, 1, 7, 0, 2), List.of(0, 1, 2, 5, 7)),
          arguments(BinaryTree.of(0, -10, 10), BinaryTree.empty(), List.of(-10, 0, 10)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void buildTreeSinglePass(TreeNode inorder, TreeNode postorder, List<Integer> expectedResult) {
    List<Integer> actualResult = solutionSinglePass.getAllElements(inorder, postorder);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void buildTreeMerge(TreeNode inorder, TreeNode postorder, List<Integer> expectedResult) {
    List<Integer> actualResult = solutionMerge.getAllElements(inorder, postorder);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
