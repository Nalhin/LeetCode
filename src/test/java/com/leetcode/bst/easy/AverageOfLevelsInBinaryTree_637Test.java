package com.leetcode.bst.easy;

import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AverageOfLevelsInBinaryTree_637Test {

  private final AverageOfLevelsInBinaryTree_637 solution = new AverageOfLevelsInBinaryTree_637();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.empty(), Collections.emptyList()),
          arguments(BinaryTree.of(5, 14, null, 1), List.of(5d, 14d, 1d)),
          arguments(BinaryTree.of(3, 9, 20, null, null, 15, 7), List.of(3d, 14.5d, 11d)));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void averageOfLevels(TreeNode root, List<Double> expectedResult) {
    List<Double> actualResult = solution.averageOfLevels(root);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
