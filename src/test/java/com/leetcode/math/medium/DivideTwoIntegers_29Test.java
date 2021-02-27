package com.leetcode.math.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DivideTwoIntegers_29Test {
  private final DivideTwoIntegers_29 solution = new DivideTwoIntegers_29();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(10, 3, 3),
          arguments(7, -3, -2),
          arguments(0, 1, 0),
          arguments(1, 1, 1),
          arguments(-2147483648, 1, -2147483648),
          arguments(-2147483648, -1, 2147483647));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void divide(int dividend, int divisor, int expectedResult) {
    int actualResult = solution.divide(dividend, divisor);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
