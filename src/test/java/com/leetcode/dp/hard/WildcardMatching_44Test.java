package com.leetcode.dp.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WildcardMatching_44Test {
  private final WildcardMatching_44 solution = new WildcardMatching_44();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("aa", "a", false),
          arguments("aa", "*", true),
          arguments("cb", "?a", false),
          arguments("adceb", "*a*b", true),
          arguments("acdcb", "a*c?b", false),
          arguments("mississippi", "m??*ss*?i*pi", false),
          arguments("", "******", true),
          arguments("add", "add***", true),
          arguments("abefcdgiescdfimde", "ab*cd?i*de", true),
          arguments("a", "", false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void isMatch(String str, String pattern, boolean expectedResult) {
    boolean actualResult = solution.isMatch(str, pattern);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
