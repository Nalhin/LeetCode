package com.leetcode.easy;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BullsAndCows_299Test {

  private final BullsAndCows_299 solution = new BullsAndCows_299();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("1807", "7810", "1A3B"),
          arguments("1123", "0111", "1A1B"),
          arguments("112314431231231231", "044442311321233111", "5A10B"),
          arguments("1123144", "0444411", "0A4B"));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestCommonPrefix(String secret, String guess, String expected) {

    String result = solution.getHint(secret, guess);

    assertThat(result).isEqualTo(expected);
  }
}
