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

class DiameterOfBinaryTree_543Test {

  private final DiameterOfBinaryTree_543 solution = new DiameterOfBinaryTree_543();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, 2, 3, 4, 5), 3),
          arguments(
              BinaryTree.of(
                  4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6,
                  5, null, 9, null, null, -1, -4, null, null, null, -2),
              8));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void diameterOfBinaryTree(TreeNode root, int expectedResult) {
    int actualResult = solution.diameterOfBinaryTree(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
