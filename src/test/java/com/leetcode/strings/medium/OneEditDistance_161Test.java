package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OneEditDistance_161Test {

  private final OneEditDistance_161 solution = new OneEditDistance_161();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("ab", "acb", true),
          arguments("", "", false),
          arguments("a", "", true),
          arguments("", "A", true),
          arguments("abcd", "abdd", true),
          arguments("abbd", "abdd", true),
          arguments("abcd", "abc", true),
          arguments("ba", "a", true));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isOneEditDistance(String s, String t, boolean expectedResult) {
    boolean actualResult = solution.isOneEditDistance(s, t);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
