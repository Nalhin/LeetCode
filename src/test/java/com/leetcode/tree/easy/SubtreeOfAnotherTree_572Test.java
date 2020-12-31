package com.leetcode.tree.easy;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SubtreeOfAnotherTree_572Test {

  private final SubtreeOfAnotherTree_572 solution = new SubtreeOfAnotherTree_572();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(3, 4, 5, 1, 2), BinaryTree.of(4, 1, 2), true),
          arguments(
              BinaryTree.of(3, 4, 5, 1, 2, null, null, null, null, 0),
              BinaryTree.of(4, 1, 2),
              false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isSubtree(TreeNode s, TreeNode t, boolean expectedResult) {
    boolean actualResult = solution.isSubtree(s, t);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
