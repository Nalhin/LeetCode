package com.leetcode.tree.medium;

import com.leetcode.utils.BinaryTree;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CheckCompletenessOfABinaryTree_958Test {

  private final CheckCompletenessOfABinaryTree_958 solution =
      new CheckCompletenessOfABinaryTree_958();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, 2, 3, 4, 5, 6), true),
          arguments(BinaryTree.of(1, 2, 3, 4, 5, null, 7), false),
          arguments(BinaryTree.of(1), true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isCompleteTree(BinaryTree.TreeNode root, boolean expectedResult) {
    boolean actualResult = solution.isCompleteTree(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
