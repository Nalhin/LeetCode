package com.leetcode.bfs.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RottingOranges_994Test {

  private final RottingOranges_994 solution = new RottingOranges_994();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}, 4),
          arguments(new int[][] {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}, -1),
          arguments(new int[][] {{0, 2}}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void orangesRotting(int[][] grid, int expectedResult) {
    int actualResult = solution.orangesRotting(grid);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
