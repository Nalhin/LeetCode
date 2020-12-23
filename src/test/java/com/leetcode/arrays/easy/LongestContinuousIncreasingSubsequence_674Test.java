package com.leetcode.arrays.easy;

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

class LongestContinuousIncreasingSubsequence_674Test {

  private final LongestContinuousIncreasingSubsequence_674 solution =
      new LongestContinuousIncreasingSubsequence_674();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 3, 5, 4, 7}, 3),
          arguments(new int[] {2, 2, 2, 2, 2}, 1),
          arguments(new int[] {}, 0));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findLengthOfLCIS(int[] input, int expectedResult) {
    int actualResult = solution.findLengthOfLCIS(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
