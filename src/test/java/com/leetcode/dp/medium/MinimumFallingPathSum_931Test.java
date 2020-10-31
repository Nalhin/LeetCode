package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumFallingPathSum_931Test {

  private final MinimumFallingPathSum_931 solution = new MinimumFallingPathSum_931();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 12),
          arguments(new int[][] {{1}}, 1),
          arguments(new int[][] {{17, 82}, {1, -44}}, -27));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minFallingPathSum(int[][] grid, int expectedResult) {
    int actualResult = solution.minFallingPathSum(grid);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
