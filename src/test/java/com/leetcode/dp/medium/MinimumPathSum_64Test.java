package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumPathSum_64Test {

  private final MinimumPathSum_64 solution = new MinimumPathSum_64();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}, 7),
          arguments(new int[][] {{1}}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minPathSum(int[][] grid, int expectedResult) {
    int actualResult = solution.minPathSum(grid);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
