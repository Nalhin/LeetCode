package com.leetcode.math.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SumOfSquareNumbers_633Test {
  private final SumOfSquareNumbers_633 solution = new SumOfSquareNumbers_633();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(5, true),
          arguments(3, false),
          arguments(4, true),
          arguments(2, true),
          arguments(1, true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void judgeSquareSum(int c, boolean expectedResult) {
    boolean actualResult = solution.judgeSquareSum(c);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
