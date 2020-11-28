package com.leetcode.arrays.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BestTimeToBuyAndSellStockIV_188Test {

  private final BestTimeToBuyAndSellStockIV_188 solution = new BestTimeToBuyAndSellStockIV_188();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {2, 4, 1}, 2, 2), arguments(new int[] {3, 2, 6, 5, 0, 3}, 2, 7));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxProfit(int[] input, int k, int expectedResult) {
    int actualResult = solution.maxProfit(k, input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
