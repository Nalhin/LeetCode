package com.leetcode.bfs.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ShortestPathInAGridWithObstaclesElimination_1293Test {

  private final ShortestPathInAGridWithObstaclesElimination_1293 solution =
      new ShortestPathInAGridWithObstaclesElimination_1293();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}}, 1, 6),
          arguments(new int[][] {{0, 1, 1}, {1, 1, 1}, {1, 0, 0}}, 1, -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void shortestPath(int[][] grid, int k, int expectedResult) {
    int actualResult = solution.shortestPath(grid, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
