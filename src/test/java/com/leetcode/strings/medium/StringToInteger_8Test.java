package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StringToInteger_8Test {

  private final StringToInteger_8 solution = new StringToInteger_8();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("42", 42),
          arguments("      -42", -42),
          arguments("4193 with words", 4193),
          arguments("-2147483649", -2147483648),
          arguments("9223372036854775808", 2147483647),
          arguments("00000-42a1234", 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void myAtoi(String str, int expectedResult) {
    int actualResult = solution.myAtoi(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
