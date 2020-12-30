package com.leetcode.arrays.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GameOfLife_289Test {

  private final GameOfLife_289 solution = new GameOfLife_289();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 1}, {1, 0}}, new int[][] {{1, 1}, {1, 1}}),
          arguments(
              new int[][] {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}},
              new int[][] {{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 1, 0}}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void gameOfLife(int[][] board, int[][] expectedResult) {

    solution.gameOfLife(board);

    assertThat(board).isEqualTo(expectedResult);
  }
}
