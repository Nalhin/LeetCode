package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BestTimeToBuyAndSellStockWithTransactionFee_714Test {

  private final BestTimeToBuyAndSellStockWithTransactionFee_714 solution =
      new BestTimeToBuyAndSellStockWithTransactionFee_714();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 3, 2, 8, 4, 9}, 2, 8),
          arguments(new int[] {1, 2, 3, 4, 5, 6, 7}, 7, 0),
          arguments(new int[] {3, 213, 4, 5, 43, 5456, 6, 1, 2}, 2, 5658));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxProfit(int[] prices, int fee, int expectedResult) {
    int actualResult = solution.maxProfit(prices, fee);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
