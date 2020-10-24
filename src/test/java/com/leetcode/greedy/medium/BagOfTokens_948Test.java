package com.leetcode.greedy.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BagOfTokens_948Test {

  private final BagOfTokens_948 solution = new BagOfTokens_948();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {100}, 50, 0),
          arguments(new int[] {100, 200}, 150, 1),
          arguments(new int[] {100, 200, 300, 400}, 200, 2),
          arguments(new int[] {81, 91, 31}, 73, 1),
          arguments(new int[] {71, 55, 82}, 54, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void bagOfTokensScore(int[] tokens, int power, int expectedResult) {

    int actualResult = solution.bagOfTokensScore(tokens, power);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
