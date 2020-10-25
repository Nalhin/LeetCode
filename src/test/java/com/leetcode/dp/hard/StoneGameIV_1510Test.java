package com.leetcode.dp.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StoneGameIV_1510Test {

  private final StoneGameIV_1510 solution = new StoneGameIV_1510();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(1, true),
          arguments(2, false),
          arguments(4, true),
          arguments(7, false),
          arguments(17, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void winnerSquareGame(int num, boolean expectedResult) {
    boolean actualResult = solution.winnerSquareGame(num);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
