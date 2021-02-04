package com.leetcode.strings.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CanConvertStringInKMoves_1540Test {

  private final CanConvertStringInKMoves_1540 solution = new CanConvertStringInKMoves_1540();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("aab", "bbb", 9, false),
          arguments("input", "ouput", 9, true),
          arguments("abc", "bcd", 10, false),
          arguments("aab", "bbb", 27, true),
          arguments("atntxzhjz", "tvbtjhvjd", 35, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void canConvertString(String s, String t, int k, boolean expectedResult) {
    boolean actualResult = solution.canConvertString(s, t, k);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
