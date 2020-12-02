package com.leetcode.tree.easy;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumAbsoluteDifferanceInBST_530Test {

  private final MinimumAbsoluteDifferanceInBST_530 solution =
      new MinimumAbsoluteDifferanceInBST_530();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, null, 3, 2), 1),
          arguments(BinaryTree.of(0, null, 2236, 1277, 2776, 519), 519),
          arguments(BinaryTree.of(334, 277, 507, null, 285, null, 678), 8),
          arguments(BinaryTree.of(5, 4, 7), 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void getMinimumDifference(TreeNode root, int expectedResult) {

    int actualResult = solution.getMinimumDifference(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
