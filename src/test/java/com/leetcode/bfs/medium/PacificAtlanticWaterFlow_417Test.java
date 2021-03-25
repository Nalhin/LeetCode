package com.leetcode.bfs.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PacificAtlanticWaterFlow_417Test {
  private final PacificAtlanticWaterFlow_417 solution = new PacificAtlanticWaterFlow_417();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[][] {
                {1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}
              },
              List.of(
                  List.of(0, 4),
                  List.of(1, 3),
                  List.of(1, 4),
                  List.of(2, 2),
                  List.of(3, 0),
                  List.of(3, 1),
                  List.of(4, 0))));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void closedIsland(int[][] grid, List<List<Integer>> expectedResult) {
    List<List<Integer>> actualResult = solution.pacificAtlantic(grid);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
