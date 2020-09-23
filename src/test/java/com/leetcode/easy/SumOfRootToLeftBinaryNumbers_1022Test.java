package com.leetcode.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import com.leetcode.utils.BinaryTree;
import com.leetcode.utils.BinaryTree.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SumOfRootToLeftBinaryNumbers_1022Test {

  private final SumOfRootToLeftBinaryNumbers_1022.BinaryShiftSolution binaryShiftSolution =
      new SumOfRootToLeftBinaryNumbers_1022.BinaryShiftSolution();
  private final SumOfRootToLeftBinaryNumbers_1022.StringBasedSolution stringBasedSolution =
      new SumOfRootToLeftBinaryNumbers_1022.StringBasedSolution();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(BinaryTree.of(1, 0, 1, 0, 1, 0, 1), 22),
          arguments(BinaryTree.of(1), 1),
          arguments(BinaryTree.of(1, 1), 3),
          arguments(BinaryTree.of(0), 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxDepthStringBased(TreeNode input, int expectedResult) {

    int actualResult = stringBasedSolution.sumRootToLeaf(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxDepthBinaryShift(TreeNode input, int expectedResult) {

    int actualResult = binaryShiftSolution.sumRootToLeaf(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
