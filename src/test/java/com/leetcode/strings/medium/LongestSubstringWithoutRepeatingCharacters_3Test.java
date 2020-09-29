package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestSubstringWithoutRepeatingCharacters_3Test {
  private final LongestSubstringWithoutRepeatingCharacters_3 solution =
      new LongestSubstringWithoutRepeatingCharacters_3();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("abcabcbb", 3), arguments("bbbbb", 1), arguments("pwwkew", 3));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void lengthOfLongestSubstring(String input, int expectedResult) {
    int actualResult = solution.lengthOfLongestSubstring(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
