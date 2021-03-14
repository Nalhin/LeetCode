package com.leetcode.dp.easy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NthTribonacciNumber_1137Test {

  private final NthTribonacciNumber_1137 solution = new NthTribonacciNumber_1137();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments(4, 4), arguments(25, 1389537));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void tribonacci(int n, int expectedResult) {
    int actualResult = solution.tribonacci(n);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
