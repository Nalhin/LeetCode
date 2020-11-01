package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CoinChange_322Test {

  private final CoinChange_322 solution = new CoinChange_322();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 5}, 11, 3),
          arguments(new int[] {2}, 3, -1),
          arguments(new int[] {1}, 0, 0),
          arguments(new int[] {1}, 1, 1),
          arguments(new int[] {1}, 2, 2),
          arguments(new int[] {1, 2147483647}, 2, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void coinChange(int[] coins, int amount, int expectedResult) {
    int actualResult = solution.coinChange(coins, amount);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
