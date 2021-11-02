package com.leetcode.backtracking.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class UniquePathsIII_980Test {

  private final UniquePathsIII_980 solution = new UniquePathsIII_980();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}, 2),
          arguments(new int[][] {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}}, 4),
          arguments(new int[][] {{0, 1}, {2, 0}}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void totalNQueens(int[][] grid, int expectedResult) {
    int actualResult = solution.uniquePathsIII(grid);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
