package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DecodeWays_91Test {

  private final DecodeWays_91 solution = new DecodeWays_91();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("12", 2),
          arguments("00", 0),
          arguments("0", 0),
          arguments("1", 1),
          arguments("226", 3),
          arguments("27", 1),
          arguments("2101", 1),
          arguments("10", 1),
          arguments("101010101", 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numDecodings(String str, int expectedResult) {
    int actualResult = solution.numDecodings(str);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
