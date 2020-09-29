package com.leetcode.hashtable.easy;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LoggerRateLimiter_359Test {

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(
              new int[] {1, 2, 3, 8, 10, 11},
              new String[] {"foo", "bar", "foo", "bar", "foo", "foo"},
              new boolean[] {true, true, false, false, false, true}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestCommonPrefix(int[] timestamps, String[] messages, boolean[] expectedResults) {
    LoggerRateLimiter_359.Logger logger = new LoggerRateLimiter_359.Logger();

    SoftAssertions softly = new SoftAssertions();

    for (int i = 0; i < timestamps.length; ++i) {
      boolean actualResult = logger.shouldPrintMessage(timestamps[i], messages[i]);

      softly.assertThat(actualResult).isEqualTo(expectedResults[i]);
    }

    softly.assertAll();
  }
}
