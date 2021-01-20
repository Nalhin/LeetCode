package com.leetcode.strings.easy;

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

class ValidPalindrome_125Test {

  private final ValidPalindrome_125 solution = new ValidPalindrome_125();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("A man, a plan, a canal: Panama", true),
          arguments("race a car", false),
          arguments("a8a", true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isPalindrome(String str, boolean expected) {
    boolean result = solution.isPalindrome(str);

    assertThat(result).isEqualTo(expected);
  }
}
