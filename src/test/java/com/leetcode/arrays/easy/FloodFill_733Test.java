package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FloodFill_733Test {
  private final FloodFill_733 solution = new FloodFill_733();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}},
              1,
              1,
              2,
              new int[][] {{2, 2, 2}, {2, 2, 0}, {2, 0, 1}}),
          arguments(
              new int[][] {{0, 0, 0}, {0, 1, 1}},
              1,
              1,
              1,
              new int[][] {
                {0, 0, 0}, {0, 1, 1},
              }));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void floodFill(int[][] input, int sr, int sc, int color, int[][] expectedResult) {
    int[][] actualResult = solution.floodFill(input, sr, sc, color);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
