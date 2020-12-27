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

class CountCompleteTreeNodes_222Test {

  private final CountCompleteTreeNodes_222.BruteForce solutionBf =
      new CountCompleteTreeNodes_222.BruteForce();

  private final CountCompleteTreeNodes_222.DivideAndConquer solutionDaC =
      new CountCompleteTreeNodes_222.DivideAndConquer();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(BinaryTree.of(1, 2, 3, 4, 5, 6, null), 6));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countNodesBruteForce(TreeNode root, int expectedResult) {
    int actualResult = solutionBf.countNodes(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void countNodesBinarySearch(TreeNode root, int expectedResult) {
    int actualResult = solutionDaC.countNodes(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
