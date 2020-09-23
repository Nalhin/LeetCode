package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumRemoveToMakeValidParentheses_1249Test {

  MinimumRemoveToMakeValidParentheses_1249 solution =
      new MinimumRemoveToMakeValidParentheses_1249();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("lee(t(c)o)de)", "lee(t(c)o)de"),
          arguments("a)b(c)d", "ab(c)d"),
          arguments("(a(b(c)d)", "a(b(c)d)"),
          arguments("()(", "()"),
          arguments(")()(", "()"),
          arguments(")()", "()"),
          arguments("))((", ""));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minRemoveToMakeValid(String input, String expectedResult) {

    String actualResult = solution.minRemoveToMakeValid(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
