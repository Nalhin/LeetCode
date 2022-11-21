package com.leetcode.bfs.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NearestExitFromEntranceInMaze_1926Test {

  private final NearestExitFromEntranceInMaze_1926 solution = new NearestExitFromEntranceInMaze_1926();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}}, new int[]{1,2}, 1),
          arguments(new char[][]{{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}}, new int[]{1,0} ,2),
          arguments(
              new char[][] {
                  {'.', '+'}
              },
              new int[]{0,0},
              -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void nearestExit(char[][] maze, int[] entrance, int expectedResult) {
    int actualResult = solution.nearestExit(maze, entrance);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}