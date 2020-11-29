package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KthSmallestElementInABST_230Test {
  private final KthSmallestElementInABST_230 solution = new KthSmallestElementInABST_230();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(3, 1, 4, null, 2), 1, 1),
          arguments(BinaryTree.of(5, 3, 6, 2, 4, null, null, 1), 3, 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxAncestorDiff(TreeNode root, int k, int expectedResult) {
    int actualResult = solution.kthSmallest(root, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
