package com.leetcode.bfs.medium;

import com.leetcode.backtracking.medium.BraceExpression_1087;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinKnightMoves_1197Test {

  private final MinKnightMoves_1197 solution = new MinKnightMoves_1197();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(2, 1, 1), arguments(5, 5, 4), arguments(0, 0, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minKnightMoves(int x, int y, int expectedResult) {
    int actualResult = solution.minKnightMoves(x, y);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
