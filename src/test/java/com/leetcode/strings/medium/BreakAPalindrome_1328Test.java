package com.leetcode.strings.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BreakAPalindrome_1328Test {

  private final BreakAPalindrome_1328 solution = new BreakAPalindrome_1328();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("abccba", "aaccba"),
          arguments("a", ""),
          arguments("aa", "ab"),
          arguments("aba", "abb"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void breakPalindrome(String input, String expectedResult) {
    String actualResult = solution.breakPalindrome(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
