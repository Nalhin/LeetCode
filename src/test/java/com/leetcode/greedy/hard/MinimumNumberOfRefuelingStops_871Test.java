package com.leetcode.greedy.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumNumberOfRefuelingStops_871Test {

  private final MinimumNumberOfRefuelingStops_871 solution =
      new MinimumNumberOfRefuelingStops_871();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(1, 1, new int[][] {}, 0),
          arguments(100, 1, new int[][] {{10, 100}}, -1),
          arguments(100, 10, new int[][] {{10, 60}, {20, 30}, {30, 30}, {60, 40}}, 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minRefuelStops(int target, int startFuel, int[][] stations, int expectedResult) {
    int actualResult = solution.minRefuelStops(target, startFuel, stations);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
