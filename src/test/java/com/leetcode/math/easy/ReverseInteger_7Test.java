package com.leetcode.math.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ReverseInteger_7Test {

  private final ReverseInteger_7 solution = new ReverseInteger_7();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(123, 321),
          arguments(-123, -321),
          arguments(120, 21),
          arguments(0, 0),
          arguments(1534236469, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void reverse(int x, int expectedResult) {
    int actualResult = solution.reverse(x);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
