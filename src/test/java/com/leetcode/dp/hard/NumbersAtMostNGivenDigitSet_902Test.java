package com.leetcode.dp.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumbersAtMostNGivenDigitSet_902Test {

  private final NumbersAtMostNGivenDigitSet_902 solution = new NumbersAtMostNGivenDigitSet_902();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new String[] {"1", "3", "5", "7"}, 100, 20),
          arguments(new String[] {"1", "4", "9"}, 1000000000, 29523),
          arguments(new String[] {"7"}, 8, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void winnerSquareGame(String[] digits, int n, int expectedResult) {
    int actualResult = solution.atMostNGivenDigitSet(digits, n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
