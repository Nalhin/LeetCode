package com.leetcode.dp.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumProfitInJobScheduling_1235Test {

  private final MaximumProfitInJobScheduling_1235 solution =
      new MaximumProfitInJobScheduling_1235();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[] {1, 2, 3, 3}, new int[] {3, 4, 5, 6}, new int[] {50, 10, 40, 70}, 120),
          arguments(
              new int[] {1, 2, 3, 4, 6},
              new int[] {3, 5, 10, 6, 9},
              new int[] {20, 20, 100, 70, 60},
              150),
          arguments(new int[] {1, 1, 1}, new int[] {2, 3, 4}, new int[] {5, 6, 4}, 6));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void jobScheduling(int[] startTime, int[] endTime, int[] profit, int expectedResult) {
    int actualResult = solution.jobScheduling(startTime, endTime, profit);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
