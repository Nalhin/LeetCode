package com.leetcode.arrays.medium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PairsOfSongsWithTotalDurationsDivisibleBy60_1010Test {

  private final PairsOfSongsWithTotalDurationsDivisibleBy60_1010 solution =
      new PairsOfSongsWithTotalDurationsDivisibleBy60_1010();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {30, 20, 150, 100, 40}, 3),
          arguments(new int[] {60, 60, 60}, 3),
          arguments(new int[] {61, 59}, 1));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void numPairsDivisibleBy60(int[] input, int expectedResult) {
    int actualResult = solution.numPairsDivisibleBy60(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
