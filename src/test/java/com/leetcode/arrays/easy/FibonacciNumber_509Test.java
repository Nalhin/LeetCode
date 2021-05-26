package com.leetcode.arrays.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FibonacciNumber_509Test {

  private final FibonacciNumber_509 solution = new FibonacciNumber_509();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(-4, -4),
          arguments(0, 0),
          arguments(1, 1),
          arguments(5, 5),
          arguments(2, 1),
          arguments(40, 102334155));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void fib(int input, int expectedResult) {

    int result = solution.fib(input);

    assertThat(result).isEqualTo(expectedResult);
  }
}
