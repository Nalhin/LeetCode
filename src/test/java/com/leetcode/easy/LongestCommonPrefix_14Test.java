package com.leetcode.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestCommonPrefix_14Test {

  LongestCommonPrefix_14 solution = new LongestCommonPrefix_14();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {

      return Stream.of(
          arguments(new String[] {"flower", "flow", "flight"}, "fl"),
          arguments(new String[] {"dog", "racecar", "car"}, ""));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestCommonPrefix(String[] input, String expected) {

    String result = solution.longestCommonPrefix(input);

    assertThat(result).isEqualTo(expected);
  }
}
