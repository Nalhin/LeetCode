package com.leetcode.hashtable.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindWinnerOnATicTacToeGame_1275Test {

  private final FindWinnerOnATicTacToeGame_1275 solution = new FindWinnerOnATicTacToeGame_1275();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}}, "A"),
          arguments(new int[][] {{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}}, "B"),
          arguments(
              new int[][] {{0, 0}, {1, 1}, {2, 0}, {1, 0}, {1, 2}, {2, 1}, {0, 1}, {0, 2}, {2, 2}},
              "Draw"),
          arguments(new int[][] {{0, 0}, {1, 1}}, "Pending"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void tictactoe(int[][] moves, String expectedResult) {
    String actualResult = solution.tictactoe(moves);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
