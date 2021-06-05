package com.leetcode.greedy.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumPerformanceOfATeam_1383Test {
  private final MaximumPerformanceOfATeam_1383 solution = new MaximumPerformanceOfATeam_1383();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(6, new int[] {2, 10, 3, 1, 5, 8}, new int[] {5, 4, 3, 9, 7, 2}, 2, 60),
          arguments(6, new int[] {2, 10, 3, 1, 5, 8}, new int[] {5, 4, 3, 9, 7, 2}, 3, 68),
          arguments(6, new int[] {2, 10, 3, 1, 5, 8}, new int[] {5, 4, 3, 9, 7, 2}, 4, 72));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxPerformance(int n, int[] speed, int[] efficiency, int k, int expectedResult) {
    int actualResult = solution.maxPerformance(n, speed, efficiency, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
