package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumNumberOfDeletionsToMakeCharacterFrequenciesUnique_1647Test {

  private final MinimumNumberOfDeletionsToMakeCharacterFrequenciesUnique_1647 solution =
      new MinimumNumberOfDeletionsToMakeCharacterFrequenciesUnique_1647();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("aab", 0), arguments("aaabbbcc", 2), arguments("ceabaacb", 2));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minDeletions(String input, int expectedResult) {
    int actualResult = solution.minDeletions(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
