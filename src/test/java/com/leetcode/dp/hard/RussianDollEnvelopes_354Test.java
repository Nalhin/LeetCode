package com.leetcode.dp.hard;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RussianDollEnvelopes_354Test {

  private final RussianDollEnvelopes_354 solution = new RussianDollEnvelopes_354();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[][] {{5, 4}, {6, 4}, {6, 7}, {2, 3}}, 3),
          arguments(new int[][] {{1, 1}, {1, 1}, {1, 1}}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void maxEnvelopes(int[][] envelopes, int expectedResult) {
    int actualResult = solution.maxEnvelopes(envelopes);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
