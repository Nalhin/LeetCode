package com.leetcode.greedy.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BestTimeToBuyAndSellStockII_122Test {

  private final BestTimeToBuyAndSellStockII_122 solution = new BestTimeToBuyAndSellStockII_122();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {7, 1, 5, 3, 6, 4}, 7),
          arguments(new int[] {1, 2, 3, 4, 5}, 4),
          arguments(new int[] {7, 6, 4, 3, 1}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void lastStoneWeight(int[] input, int expectedResult) {
    int actualResult = solution.maxProfit(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
