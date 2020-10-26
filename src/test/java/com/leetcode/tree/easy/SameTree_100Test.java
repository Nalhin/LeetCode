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

class SameTree_100Test {

  private final SameTree_100 solution = new SameTree_100();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, 2, 3), BinaryTree.of(1, 2, 3), true),
          arguments(BinaryTree.of(1, 2), BinaryTree.of(1, null, 2), false),
          arguments(BinaryTree.of(1, 2, 1), BinaryTree.of(1, 1, 2), false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isSameTree(TreeNode first, TreeNode second, boolean expectedResult) {

    boolean actualResult = solution.isSameTree(first, second);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
