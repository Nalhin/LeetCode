package com.leetcode.hashtable.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumWindowSubstring_76Test {
  private final MinimumWindowSubstring_76 solution = new MinimumWindowSubstring_76();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("ADOBECODEBANC", "ABC", "BANC"),
          arguments("a", "a", "a"),
          arguments("a", "aa", ""));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void minWindow(String str, String target, String expectedResult) {
    String actualResult = solution.minWindow(str, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
