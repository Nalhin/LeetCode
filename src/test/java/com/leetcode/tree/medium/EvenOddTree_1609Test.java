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

class EvenOddTree_1609Test {

  private final EvenOddTree_1609 solution = new EvenOddTree_1609();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, 10, 4, 3, null, 7, 9, 12, 8, 6, null, null, 2), true),
          arguments(BinaryTree.of(5, 4, 2, 3, 3, 7), false),
          arguments(BinaryTree.of(1), true),
          arguments(BinaryTree.of(5, 9, 1, 3, 5, 7), false),
          arguments(BinaryTree.of(11, 8, 6, 1, 3, 9, 11, 30, 20, 18, 16, 12, 10, 4, 2, 17), true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isEvenOddTree(TreeNode preorder, boolean expectedResult) {
    boolean actualResult = solution.isEvenOddTree(preorder);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
