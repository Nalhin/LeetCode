package com.leetcode.strings.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ImplementStrStr_28Test {

  private final ImplementStrStr_28 solution = new ImplementStrStr_28();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments("hello", "ll", 2),
          arguments("aaaaa", "bba", -1),
          arguments("mississippi", "issi", 1),
          arguments("a", "a", 0),
          arguments("aaa", "aaaa", -1),
          arguments("abc", "c", 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void strStr(String haystack, String needle, int expectedResult) {

    int actualResult = solution.strStr(haystack, needle);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
