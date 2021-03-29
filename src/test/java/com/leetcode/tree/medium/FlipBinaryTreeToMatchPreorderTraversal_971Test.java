package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FlipBinaryTreeToMatchPreorderTraversal_971Test {
  private final FlipBinaryTreeToMatchPreorderTraversal_971 solution =
      new FlipBinaryTreeToMatchPreorderTraversal_971();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, 2), new int[] {2, 1}, List.of(-1)),
          arguments(BinaryTree.of(1, 2, 3), new int[] {1, 3, 2}, List.of(-1)),
          arguments(BinaryTree.of(1, 2, 3), new int[] {1, 2, 3}, Collections.emptyList()));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void flipMatchVoyage(TreeNode preorder, int[] voyage, List<Integer> expectedResult) {
    List<Integer> actualResult = solution.flipMatchVoyage(preorder, voyage);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
