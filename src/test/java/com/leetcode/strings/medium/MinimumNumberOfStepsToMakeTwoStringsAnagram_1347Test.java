package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumNumberOfStepsToMakeTwoStringsAnagram_1347Test {
  private final MinimumNumberOfStepsToMakeTwoStringsAnagram_1347 solution =
      new MinimumNumberOfStepsToMakeTwoStringsAnagram_1347();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("bab", "aba", 1),
          arguments("leetcode", "practice", 5),
          arguments("anagram", "managaar", 0),
          arguments("xxyyzz", "xxyyzz", 0),
          arguments("friend", "family", 4));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minSteps(String str1, String str2, int expectedResult) {
    int actualResult = solution.minSteps(str1, str2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
