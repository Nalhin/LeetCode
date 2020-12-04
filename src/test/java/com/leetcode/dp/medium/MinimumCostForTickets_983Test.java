package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumCostForTickets_983Test {

  private final MinimumCostForTickets_983 solution = new MinimumCostForTickets_983();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 4, 6, 7, 8, 20}, new int[] {2, 7, 15}, 11),
          arguments(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31}, new int[] {2, 7, 15}, 17),
          arguments(new int[] {1, 4, 6, 7, 8, 20}, new int[] {7, 2, 15}, 6));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void mincostTickets(int[] days, int[] costs, int expectedResult) {
    int actualResult = solution.mincostTickets(days, costs);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
