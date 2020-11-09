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

class UnivaluedBinaryTree_956Test {

  private final UnivaluedBinaryTree_956 solution = new UnivaluedBinaryTree_956();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, 1, 1, 1, 1, null, 1), true),
          arguments(BinaryTree.of(2, 2, 2, 5, 2), false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isUnivalTree(TreeNode tree, boolean expectedResult) {

    boolean actualResult = solution.isUnivalTree(tree);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
