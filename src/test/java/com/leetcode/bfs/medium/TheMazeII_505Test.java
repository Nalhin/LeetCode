package com.leetcode.bfs.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TheMazeII_505Test {

  private final TheMazeII_505 solution = new TheMazeII_505();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {
                {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}
              },
              new int[] {0, 4},
              new int[] {4, 4},
              12),
          arguments(
              new int[][] {
                {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}
              },
              new int[] {0, 4},
              new int[] {3, 2},
              -1),
          arguments(
              new int[][] {
                {0, 0, 0, 0, 0}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 1, 0, 0, 0}
              },
              new int[] {4, 3},
              new int[] {0, 1},
              -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void shortestDistance(int[][] maze, int[] start, int[] end, int expectedResult) {
    int actualResult = solution.shortestDistance(maze, start, end);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
