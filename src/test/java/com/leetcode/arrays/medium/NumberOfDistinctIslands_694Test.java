package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfDistinctIslands_694Test {
  private final NumberOfDistinctIslands_694 solution = new NumberOfDistinctIslands_694();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}}, 1),
          arguments(
              new int[][] {{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}}, 3),
          arguments(new int[][] {{1, 1, 0}, {0, 1, 1}, {0, 0, 0}, {1, 1, 1}, {0, 1, 0}}, 2),
          arguments(
              new int[][] {
                {0, 0, 0, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0}
              },
              2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numDistinctIslands(int[][] grid, int expectedResult) {
    int actualResult = solution.numDistinctIslands(grid);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
