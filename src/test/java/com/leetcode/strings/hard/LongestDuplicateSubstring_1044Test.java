package com.leetcode.strings.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestDuplicateSubstring_1044Test {

  private final LongestDuplicateSubstring_1044 solution = new LongestDuplicateSubstring_1044();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("banana", "ana"), arguments("abcd", ""), arguments("aa", "a"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestDupSubstring(String str, String expectedResult) {
    String actualResult = solution.longestDupSubstring(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
