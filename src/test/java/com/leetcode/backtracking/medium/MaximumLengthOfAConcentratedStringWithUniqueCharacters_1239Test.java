package com.leetcode.backtracking.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumLengthOfAConcentratedStringWithUniqueCharacters_1239Test {

  private final MaximumLengthOfAConcentratedStringWithUniqueCharacters_1239 solution =
      new MaximumLengthOfAConcentratedStringWithUniqueCharacters_1239();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(List.of("un", "iq", "ue"), 4),
          arguments(List.of("cha", "r", "act", "ers"), 6),
          arguments(List.of("abcdefghijklmnopqrstuvwxyz"), 26));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxLength(List<String> arr, int expectedResult) {
    int actualResult = solution.maxLength(arr);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
