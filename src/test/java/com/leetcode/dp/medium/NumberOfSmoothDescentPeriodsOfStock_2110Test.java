package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfSmoothDescentPeriodsOfStock_2110Test {

  private final NumberOfSmoothDescentPeriodsOfStock_2110 solution =
      new NumberOfSmoothDescentPeriodsOfStock_2110();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {3, 2, 1, 4}, 7),
          arguments(new int[] {8, 6, 7, 7}, 4),
          arguments(new int[] {1}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void getDescentPeriods(int[] prices, long expectedResult) {
    long actualResult = solution.getDescentPeriods(prices);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
