package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DetermineIfTwoStringsAreClose_1657Test {

  private final DetermineIfTwoStringsAreClose_1657 solution =
      new DetermineIfTwoStringsAreClose_1657();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("abc", "bca", true),
          arguments("a", "aa", false),
          arguments("cabbba", "abbccc", true),
          arguments("cabbba", "aabbss", false),
          arguments("uau", "ssx", false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void closeStrings(String word1, String word2, boolean expectedResult) {
    boolean actualResult = solution.closeStrings(word1, word2);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
