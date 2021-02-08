package com.leetcode.tree.medium;

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

class TwoSumBSTs_1214Test {

  private final TwoSumBSTs_1214 solution = new TwoSumBSTs_1214();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(2, 1, 4), BinaryTree.of(1, 0, 3), 5, true),
          arguments(BinaryTree.of(0, -10, 10), BinaryTree.of(5, 1, 7, 0, 2), 18, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void twoSumBSTs(TreeNode root1, TreeNode root2, int target, boolean expectedResult) {
    boolean actualResult = solution.twoSumBSTs(root1, root2, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
