package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AverageSalaryExcludingTheMinimumAndMaximum_1491Test {

  private final AverageSalaryExcludingTheMinimumAndMaximum_1491 solution =
      new AverageSalaryExcludingTheMinimumAndMaximum_1491();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {4000, 3000, 1000, 2000}, 2500d),
          arguments(new int[] {1000, 2000, 3000}, 2000d),
          arguments(new int[] {6000, 5000, 4000, 3000, 2000, 1000}, 3500d),
          arguments(new int[] {8000, 9000, 2000, 3000, 6000, 1000}, 4750d));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void average(int[] input, double expectedResult) {

    double actualResult = solution.average(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
