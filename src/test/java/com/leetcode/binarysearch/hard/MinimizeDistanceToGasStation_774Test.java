package com.leetcode.binarysearch.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimizeDistanceToGasStation_774Test {

  private final MinimizeDistanceToGasStation_774 solution = new MinimizeDistanceToGasStation_774();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9, 0.50000),
          arguments(new int[] {23, 24, 36, 39, 46, 56, 57, 65, 84, 98}, 1, 14.0000));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minmaxGasDist(int[] stations, int k, double expectedResult) {
    double actualResult = solution.minmaxGasDist(stations, k);

    assertThat(actualResult).isEqualTo(expectedResult, withPrecision(0.000001d));
  }
}
