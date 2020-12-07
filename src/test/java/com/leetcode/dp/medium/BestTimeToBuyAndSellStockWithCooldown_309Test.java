package com.leetcode.dp.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BestTimeToBuyAndSellStockWithCooldown_309Test {

  private final BestTimeToBuyAndSellStockWithCooldown_309 solution =
      new BestTimeToBuyAndSellStockWithCooldown_309();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 0, 2}, 3),
          arguments(new int[] {}, 0),
          arguments(new int[] {10}, 0),
          arguments(new int[] {1, 4, 2}, 3),
          arguments(new int[] {1, 321, 3, 21, 312, 4, 12, 3, 5, 6, 2, 13, 4, 4}, 624));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxProfit(int[] prices, int expectedResult) {
    int actualResult = solution.maxProfit(prices);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
