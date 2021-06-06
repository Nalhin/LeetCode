package com.leetcode.hashtable.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestConsecutiveSequence_128Test {

  private final LongestConsecutiveSequence_128.Recursive solutionRecursive =
      new LongestConsecutiveSequence_128.Recursive();
  private final LongestConsecutiveSequence_128.Iterative solutionIterative =
      new LongestConsecutiveSequence_128.Iterative();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {100, 4, 200, 1, 3, 2}, 4),
          arguments(new int[] {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestConsecutiveRecursive(int[] nums, int expectedResult) {
    int actualResult = solutionRecursive.longestConsecutive(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void longestConsecutiveIterative(int[] nums, int expectedResult) {
    int actualResult = solutionIterative.longestConsecutive(nums);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
