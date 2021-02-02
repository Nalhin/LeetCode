package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumAverageSubarrayI_643Test {

  private final MaximumAverageSubarrayI_643 solution = new MaximumAverageSubarrayI_643();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 12, -5, -6, 50, 3}, 5, 10.8),
          arguments(new int[] {1, 12, -5, -6, 50, 3}, 4, 12.75));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findMaxAverage(int[] input, int k, double expectedResult) {
    double actualResult = solution.findMaxAverage(input, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
