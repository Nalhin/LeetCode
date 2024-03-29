package com.leetcode.backtracking.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MatchsticksToSquare_473Test {
  private final MatchsticksToSquare_473 solution = new MatchsticksToSquare_473();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 1, 2, 2, 2}, true), arguments(new int[] {3, 3, 3, 3, 4}, false));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void makesquare(int[] matchsticks, boolean expectedResult) {
    boolean actualResult = solution.makesquare(matchsticks);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
