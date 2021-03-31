package com.leetcode.strings.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StampingTheSequence_936Test {
  private final StampingTheSequence_936 solution = new StampingTheSequence_936();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments("abc", "ababc", new int[] {0, 2}),
          arguments("abca", "aabcaca", new int[] {0, 3, 1}));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void movesToStamp(String stamp, String target, int[] expectedResult) {
    int[] actualResult = solution.movesToStamp(stamp, target);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
