package com.leetcode.math.medium;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PowXN_50Test {

  private final PowXN_50.Recursive solutionRecursive = new PowXN_50.Recursive();
  private final PowXN_50.Iterative solutionIterative = new PowXN_50.Iterative();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(2.0, 10, 1024.0), arguments(2.1, 3, 9.26100), arguments(2.0, -2, 0.25));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void reachNumberRecursive(double x, int n, double expectedResult) {
    double actualResult = solutionRecursive.myPow(x, n);

    assertThat(actualResult).isCloseTo(expectedResult, Percentage.withPercentage(0.0001));
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void reachNumberIterative(double x, int n, double expectedResult) {
    double actualResult = solutionIterative.myPow(x, n);

    assertThat(actualResult).isCloseTo(expectedResult, Percentage.withPercentage(0.0001));
  }
}
