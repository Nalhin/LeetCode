package com.leetcode.dp.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class UniquePathsII_63Test {

  private final UniquePathsII_63 solution = new UniquePathsII_63();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}, 2),
          arguments(new int[][] {{0, 1}, {0, 0}}, 1),
          arguments(
              new int[][] {
                {1, 0},
              },
              0),
          arguments(new int[][] {{1}}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void uniquePathsWithObstacles(int[][] obstacleGrid, int expectedResult) {
    int actualResult = solution.uniquePathsWithObstacles(obstacleGrid);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
