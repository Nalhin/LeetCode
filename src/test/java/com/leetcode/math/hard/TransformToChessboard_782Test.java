package com.leetcode.math.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TransformToChessboard_782Test {
  private final TransformToChessboard_782 solution = new TransformToChessboard_782();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{0, 1, 1, 0}, {0, 1, 1, 0}, {1, 0, 0, 1}}, 2),
          arguments(new int[][] {{0, 1}, {1, 0}}, 0),
          arguments(new int[][] {{1, 0}, {1, 0}}, -1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void movesToChessboard(int[][] board, int expectedResult) {
    int actualResult = solution.movesToChessboard(board);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
