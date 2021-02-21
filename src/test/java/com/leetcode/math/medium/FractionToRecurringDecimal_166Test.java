package com.leetcode.math.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FractionToRecurringDecimal_166Test {
  private final FractionToRecurringDecimal_166 solution = new FractionToRecurringDecimal_166();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(1, 2, "0.5"),
          arguments(2, 1, "2"),
          arguments(2, 3, "0.(6)"),
          arguments(4, 333, "0.(012)"),
          arguments(1, 5, "0.2"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void fractionToDecimal(int numerator, int denominator, String expectedResult) {
    String actualResult = solution.fractionToDecimal(numerator, denominator);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
