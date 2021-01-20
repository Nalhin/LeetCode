package com.leetcode.bitmanipulation.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PowerOfTwo_231Test {

  private final PowerOfTwo_231 solution = new PowerOfTwo_231();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(1, true),
          arguments(16, true),
          arguments(3, false),
          arguments(4, true),
          arguments(5, false),
          arguments(-2147483648, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isPowerOfTwo(int input, boolean expectedResult) {
    boolean actualResult = solution.isPowerOfTwo(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
