package com.leetcode.strings.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidNumber_65Test {

  private final ValidNumber_65 solution = new ValidNumber_65();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("2", true),
          arguments("0089", true),
          arguments("-0.1", true),
          arguments("+3.14", true),
          arguments("4.", true),
          arguments("-.9", true),
          arguments("2e10", true),
          arguments("-90E3", true),
          arguments("3e+7", true),
          arguments("+6e-1", true),
          arguments("53.5e93", true),
          arguments("-123.456e789", true),
          arguments("e9", false),
          arguments("abc", false),
          arguments("1a", false),
          arguments("1e", false),
          arguments("e3", false),
          arguments("99e2.5", false),
          arguments("--6", false),
          arguments("-+3", false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isNumber(String number, boolean expectedResult) {
    boolean actualResult = solution.isNumber(number);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
