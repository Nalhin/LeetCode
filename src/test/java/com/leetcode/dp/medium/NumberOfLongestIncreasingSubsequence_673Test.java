package com.leetcode.dp.medium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfLongestIncreasingSubsequence_673Test {
  private final NumberOfLongestIncreasingSubsequence_673 solution =
      new NumberOfLongestIncreasingSubsequence_673();

  private static class TestArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
          arguments(new int[] {1, 3, 5, 4, 7}, 2), arguments(new int[] {2, 2, 2, 2, 2}, 5));
    }
  }

  @ParameterizedTest
  @ArgumentsSource(TestArgumentsProvider.class)
  void findNumberOfLIS(int[] input, int expectedResult) {
    int actualResult = solution.findNumberOfLIS(input);

    assertThat(actualResult).isEqualTo(expectedResult);
  }
}
