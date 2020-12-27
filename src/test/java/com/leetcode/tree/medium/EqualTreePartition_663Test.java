package com.leetcode.tree.medium;

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

class EqualTreePartition_663Test {
  private final EqualTreePartition_663 solution = new EqualTreePartition_663();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(5, 10, 10, null, null, 2, 3), true),
          arguments(BinaryTree.of(1, 2, 10, null, null, 2, 20), false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void checkEqualTree(TreeNode root, boolean expectedResult) {
    boolean actualResult = solution.checkEqualTree(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
