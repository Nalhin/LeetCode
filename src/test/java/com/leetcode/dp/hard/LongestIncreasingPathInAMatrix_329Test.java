package com.leetcode.dp.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestIncreasingPathInAMatrix_329Test {

  private final LongestIncreasingPathInAMatrix_329 solution =
      new LongestIncreasingPathInAMatrix_329();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}}, 4),
          arguments(new int[][] {{3, 4, 5}, {3, 2, 6}, {2, 2, 1}}, 4),
          arguments(new int[][] {{1}}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestIncreasingPath(int[][] matrix, int expectedResult) {
    int actualResult = solution.longestIncreasingPath(matrix);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
