package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BinaryTreeWithFactors_823Test {

  private final BinaryTreeWithFactors_823 solution = new BinaryTreeWithFactors_823();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 4}, 3),
          arguments(new int[] {2, 4, 5, 10}, 7),
          arguments(new int[] {18, 3, 6, 2}, 12));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numFactoredBinaryTrees(int[] arr, int expectedResult) {
    int actualResult = solution.numFactoredBinaryTrees(arr);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
