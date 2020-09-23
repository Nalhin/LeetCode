package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ValidParentheses_20Test {

  private final ValidParentheses_20 solution = new ValidParentheses_20();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("()", true),
          arguments("()[]{}", true),
          arguments("(]", false),
          arguments("([)]", false),
          arguments("{[]}", true),
          arguments("((", false),
          arguments("){", false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isValid(String input, boolean expected) {
    boolean result = solution.isValid(input);

    assertThat(result).isEqualTo(expected);
  }
}
