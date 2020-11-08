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

class BinaryTreeTilt_563Test {

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, 2, 3), 1),
          arguments(BinaryTree.of(4, 2, 9, 3, 5, null, 7), 15),
          arguments(BinaryTree.of(21, 7, 14, 1, 1, 2, 2, 3, 3), 9));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findTilt(TreeNode root, int expectedResult) {
    BinaryTreeTilt_563 solution = new BinaryTreeTilt_563();

    int actualResult = solution.findTilt(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
