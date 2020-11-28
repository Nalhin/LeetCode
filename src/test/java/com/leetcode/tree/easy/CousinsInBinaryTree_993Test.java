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

class CousinsInBinaryTree_993Test {

  private final CousinsInBinaryTree_993 solution = new CousinsInBinaryTree_993();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, 2, 3, 4), 4, 3, false),
          arguments(BinaryTree.of(1, 2, 3, null, 4, null, 5), 5, 4, true),
          arguments(BinaryTree.of(1, 2, 3, null, 4), 2, 3, false),
          arguments(BinaryTree.of(1, 2, 3, null, 4), 2, 3, false),
          arguments(BinaryTree.of(1, 2, null, 3, 4, null, null, 5), 2, 4, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isCousins(TreeNode root, int x, int y, boolean expectedResult) {
    boolean actualResult = solution.isCousins(root, x, y);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
