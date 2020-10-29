package com.leetcode.dp.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinCostClimbingStairs746Test {

  private final MinCostClimbingStairs_746 solution = new MinCostClimbingStairs_746();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {10, 15, 20}, 15),
          arguments(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, 6),
          arguments(new int[] {0, 0, 0, 1}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minCostClimbingStairs(int[] array, int expectedResult) {
    int actualResult = solution.minCostClimbingStairs(array);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
