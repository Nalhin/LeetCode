package com.leetcode.tree.easy;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TwoSumIV_InputIsABST_653Test {

  private final TwoSumIV_InputIsABST_653 solution = new TwoSumIV_InputIsABST_653();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(5, 3, 6, 2, 4, null, 7), 9, true),
          arguments(BinaryTree.of(5, 3, 6, 2, 4, null, 7), 28, false),
          arguments(BinaryTree.of(2, 1, 3), 4, true),
          arguments(BinaryTree.of(2, 1, 3), 1, false),
          arguments(BinaryTree.of(2, 1, 3), 3, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findTarget(TreeNode tree, int target, boolean expectedResult) {
    boolean actualResult = solution.findTarget(tree, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
