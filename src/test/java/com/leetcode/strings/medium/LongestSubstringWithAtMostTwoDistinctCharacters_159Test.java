package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestSubstringWithAtMostTwoDistinctCharacters_159Test {

  private final LongestSubstringWithAtMostTwoDistinctCharacters_159 solution =
      new LongestSubstringWithAtMostTwoDistinctCharacters_159();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("eceba", 3),
          arguments("ccaabbb", 5),
          arguments("a", 1),
          arguments("eveca", 3),
          arguments("aaaaa", 5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void lengthOfLongestSubstringTwoDistinct(String input, int expectedResult) {
    int actualResult = solution.lengthOfLongestSubstringTwoDistinct(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
