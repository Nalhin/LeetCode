package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ThousandSeparator_1556Test {
  private final ThousandSeparator_1556 solution = new ThousandSeparator_1556();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(987, "987"),
          arguments(1234, "1.234"),
          arguments(123456789, "123.456.789"),
          arguments(0, "0"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void balancedStringSplit(int input, String expectedResult) {
    String actualResult = solution.thousandSeparator(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
