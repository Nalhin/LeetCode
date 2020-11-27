package com.leetcode.strings.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestSubstringWithAtLeastKRepeatingCharacters_395Test {

  private final LongestSubstringWithAtLeastKRepeatingCharacters_395 solution =
      new LongestSubstringWithAtLeastKRepeatingCharacters_395();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(arguments("aaabb", 3, 3), arguments("ababbc", 2, 5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestSubstring(String input, int k, int expectedResult) {
    int actualResult = solution.longestSubstring(input, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
