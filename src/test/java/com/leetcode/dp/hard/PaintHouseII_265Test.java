package com.leetcode.dp.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PaintHouseII_265Test {

  private final PaintHouseII_265 solution = new PaintHouseII_265();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{1, 5, 3}, {2, 9, 4}}, 5),
          arguments(new int[][] {{1, 3}, {2, 4}}, 5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minCostII(int[][] costs, int expectedResult) {
    int actualResult = solution.minCostII(costs);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
