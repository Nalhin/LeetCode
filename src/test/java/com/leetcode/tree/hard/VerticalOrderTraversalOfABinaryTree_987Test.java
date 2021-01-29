package com.leetcode.tree.hard;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class VerticalOrderTraversalOfABinaryTree_987Test {

  private final VerticalOrderTraversalOfABinaryTree_987 solution =
      new VerticalOrderTraversalOfABinaryTree_987();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              BinaryTree.of(1, 2, 3, 4, 5, 6, 7),
              List.of(List.of(4), List.of(2), List.of(1, 5, 6), List.of(3), List.of(7))),
          arguments(
              BinaryTree.of(3, 9, 20, null, null, 15, 7),
              List.of(List.of(9), List.of(3, 15), List.of(20), List.of(7))),
          arguments(
              BinaryTree.of(0, 8, 1, null, null, 3, 2, null, 4, 5, null, null, 7, 6),
              List.of(List.of(8), List.of(0, 3, 6), List.of(1, 4, 5), List.of(2, 7))),
          arguments(
              BinaryTree.of(
                  0, 5, 1, 9, null, 2, null, null, null, null, 3, 4, 8, 6, null, null, null, 7),
              List.of(List.of(9, 7), List.of(5, 6), List.of(0, 2, 4), List.of(1, 3), List.of(8))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void verticalTraversal(TreeNode root, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.verticalTraversal(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
