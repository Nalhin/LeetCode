package com.leetcode.bfs.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ShortestPathInBinaryMatrix_1091Test {

  private final ShortestPathInBinaryMatrix_1091 solution = new ShortestPathInBinaryMatrix_1091();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{0, 1}, {1, 0}}, 2),
          arguments(new int[][] {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}, 4),
          arguments(new int[][] {{0, 0, 0}, {1, 0, 0}, {1, 1, 0}}, 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void shortestPathBinaryMatrix(int[][] grid, int expectedResult) {
    int actualResult = solution.shortestPathBinaryMatrix(grid);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
