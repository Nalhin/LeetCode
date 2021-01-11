package com.leetcode.math.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ConfusingNumbers_1056Test {

  private final ConfusingNumbers_1056 solution = new ConfusingNumbers_1056();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(6, true),
          arguments(89, true),
          arguments(101, false),
          arguments(11, false),
          arguments(25, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void addDigits(int num, boolean expectedResult) {
    boolean actualResult = solution.confusingNumber(num);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
